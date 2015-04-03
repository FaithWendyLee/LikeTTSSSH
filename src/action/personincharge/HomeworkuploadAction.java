package action.personincharge;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import model.Course;
import model.Homework;
import model.Plan;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import service.PlanService;
import action.BaseAction;


/**
 * Servlet implementation class homeworkupload2
 */
public class HomeworkuploadAction extends BaseAction {
	private PlanService planService;

	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	
	public String execute() throws Exception {  
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");  
        // 使用普通数据集  
        DefaultCategoryDataset chartDate = new DefaultCategoryDataset(); 


		String month = (String) request.getSession().getAttribute("month");
		
		ArrayList<Course> clist=new ArrayList<Course>();
		ArrayList<Course> ac=(ArrayList<Course>)request.getSession().getAttribute("courseList");

		for(int j=0;j<ac.size();j++){
				try {
					if(ac.get(j).IsBetween(month)){
						clist.add(ac.get(j));
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		ArrayList<Homework> ah=(ArrayList<Homework>)request.getSession().getAttribute("homeworkList");
			
		for(int i=0;i<clist.size();i++){
			ArrayList<Homework> hlist=new ArrayList<Homework>();
			for(int j=0;j<ah.size();j++){
					Plan p=planService.findPlan(ah.get(j).getPid());
					if(p==null){
						continue;
					}
					else if((p.getCid()==clist.get(i).getCid())&&(ah.get(j).getIsupload(month))){
						hlist.add(ah.get(j));
			        }else{
			        	continue;
			        }
            }

			chartDate.addValue(hlist.size(), "作业提交数", clist.get(i).getCname());
		}
		
		
        try {  
            // 从数据库中获得数据集  
            DefaultCategoryDataset data = chartDate;  
              
            // 使用ChartFactory创建3D柱状图，不想使用3D，直接使用createBarChart  
            JFreeChart chart = ChartFactory.createBarChart3D(  
                    "", // 图表标题  
                    "课程", // 目录轴的显示标签  
                    "作业提交数", // 数值轴的显示标签  
                    data, // 数据集  
                    PlotOrientation.VERTICAL, // 图表方向，此处为垂直方向  
                    // PlotOrientation.HORIZONTAL, //图表方向，此处为水平方向  
                    true, // 是否显示图例  
                    true, // 是否生成工具  
                    false // 是否生成URL链接  
                    );            
            // 设置整个图片的背景色  
            chart.setBackgroundPaint(Color.WHITE);  
            // 设置图片有边框  
            chart.setBorderVisible(true);  
            Font kfont = new Font("宋体", Font.PLAIN, 12);    // 底部  
            Font titleFont = new Font("宋体", Font.BOLD, 25); // 图片标题  
            // 图片标题  
            chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));  
            // 底部  
            chart.getLegend().setItemFont(kfont);  
            // 得到坐标设置字体解决乱码  
            CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();  
            categoryplot.setDomainGridlinesVisible(true);  
            categoryplot.setRangeCrosshairVisible(true);  
            categoryplot.setRangeCrosshairPaint(Color.blue);  
            NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
            numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());  
            BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();  
            barrenderer.setBaseItemLabelFont(new Font("宋体", Font.PLAIN, 12));  
            barrenderer.setSeriesItemLabelFont(1, new Font("宋体", Font.PLAIN, 12));  
            CategoryAxis domainAxis = categoryplot.getDomainAxis();           
            /*------设置X轴坐标上的文字-----------*/  
            domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
            /*------设置X轴的标题文字------------*/  
            domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
            /*------设置Y轴坐标上的文字-----------*/  
            numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
            /*------设置Y轴的标题文字------------*/  
            numberaxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
            /*------这句代码解决了底部汉字乱码的问题-----------*/  
            chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));  
            // 生成图片并输出  
            ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1.0f,  
                    chart, 500, 300, null);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return null;  
    }  
}
