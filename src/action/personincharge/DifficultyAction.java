package action.personincharge;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import model.Plan;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import service.PlanService;
import action.BaseAction;

public class DifficultyAction extends BaseAction {
	private PlanService planService;

	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}

	public String execute() throws Exception {
		MakeChart();
		return null;
	}
	
	public void MakeChart() throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		// 使用普通数据集

		String month = (String) request.getSession().getAttribute("month");

		ArrayList<Plan> plist = new ArrayList<Plan>();
		ArrayList<Plan> ps = planService.getPlan();
		int hardnum = 0;
		int mediumnum = 0;
		int easynum = 0;

		int j = 0;

		while (j < ps.size()) {
			Plan p = ps.get(j);
			if (month == null) {
				break;
			} else if (p.getIsupload(month)) {
				plist.add(p);
			}
			j++;

		}
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i).getDifficulty().equals("hard")) {
				hardnum++;
			} else if (plist.get(i).getDifficulty().equals("medium")) {
				mediumnum++;
			} else if (plist.get(i).getDifficulty().equals("easy")) {
				easynum++;
			}
		}

		// 默认数据类型
		DefaultPieDataset dataType = new DefaultPieDataset();
		// 数据参数 内容，数量
		dataType.setValue("hard", hardnum);
		dataType.setValue("medium", mediumnum);
		dataType.setValue("easy", easynum);
		try {
			DefaultPieDataset data = dataType;
			// 生成普通饼状图除掉 3D 即可
			// 生产3D饼状图
			PiePlot3D plot = new PiePlot3D(data);
			JFreeChart chart = new JFreeChart("", // 图形标题
					JFreeChart.DEFAULT_TITLE_FONT, // 标题字体
					plot, // 图标标题对象
					true // 是否显示图例
			);
			// 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
					"{0}={1}({2})", NumberFormat.getInstance(),
					new DecimalFormat("0.00%")));
			plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
					"{0}={1}({2})"));
			// 设置整个图片的背景色
			chart.setBackgroundPaint(Color.WHITE);
			// 设置图片有边框
			chart.setBorderVisible(true);
			// 配置字体
			Font kfont = new Font("宋体", Font.PLAIN, 12); // 底部
			Font titleFont = new Font("宋体", Font.BOLD, 25); // 图片标题
			// 图片标题
			chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));
			// 底部
			chart.getLegend().setItemFont(kfont);
			ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1.0f,
					chart, 500, 300, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}