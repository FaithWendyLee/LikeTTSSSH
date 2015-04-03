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
        // ʹ����ͨ���ݼ�  
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

			chartDate.addValue(hlist.size(), "��ҵ�ύ��", clist.get(i).getCname());
		}
		
		
        try {  
            // �����ݿ��л�����ݼ�  
            DefaultCategoryDataset data = chartDate;  
              
            // ʹ��ChartFactory����3D��״ͼ������ʹ��3D��ֱ��ʹ��createBarChart  
            JFreeChart chart = ChartFactory.createBarChart3D(  
                    "", // ͼ�����  
                    "�γ�", // Ŀ¼�����ʾ��ǩ  
                    "��ҵ�ύ��", // ��ֵ�����ʾ��ǩ  
                    data, // ���ݼ�  
                    PlotOrientation.VERTICAL, // ͼ���򣬴˴�Ϊ��ֱ����  
                    // PlotOrientation.HORIZONTAL, //ͼ���򣬴˴�Ϊˮƽ����  
                    true, // �Ƿ���ʾͼ��  
                    true, // �Ƿ����ɹ���  
                    false // �Ƿ�����URL����  
                    );            
            // ��������ͼƬ�ı���ɫ  
            chart.setBackgroundPaint(Color.WHITE);  
            // ����ͼƬ�б߿�  
            chart.setBorderVisible(true);  
            Font kfont = new Font("����", Font.PLAIN, 12);    // �ײ�  
            Font titleFont = new Font("����", Font.BOLD, 25); // ͼƬ����  
            // ͼƬ����  
            chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));  
            // �ײ�  
            chart.getLegend().setItemFont(kfont);  
            // �õ�������������������  
            CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();  
            categoryplot.setDomainGridlinesVisible(true);  
            categoryplot.setRangeCrosshairVisible(true);  
            categoryplot.setRangeCrosshairPaint(Color.blue);  
            NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
            numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());  
            BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();  
            barrenderer.setBaseItemLabelFont(new Font("����", Font.PLAIN, 12));  
            barrenderer.setSeriesItemLabelFont(1, new Font("����", Font.PLAIN, 12));  
            CategoryAxis domainAxis = categoryplot.getDomainAxis();           
            /*------����X�������ϵ�����-----------*/  
            domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
            /*------����X��ı�������------------*/  
            domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
            /*------����Y�������ϵ�����-----------*/  
            numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
            /*------����Y��ı�������------------*/  
            numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
            /*------���������˵ײ��������������-----------*/  
            chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));  
            // ����ͼƬ�����  
            ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1.0f,  
                    chart, 500, 300, null);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return null;  
    }  
}
