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
		// ʹ����ͨ���ݼ�

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

		// Ĭ����������
		DefaultPieDataset dataType = new DefaultPieDataset();
		// ���ݲ��� ���ݣ�����
		dataType.setValue("hard", hardnum);
		dataType.setValue("medium", mediumnum);
		dataType.setValue("easy", easynum);
		try {
			DefaultPieDataset data = dataType;
			// ������ͨ��״ͼ���� 3D ����
			// ����3D��״ͼ
			PiePlot3D plot = new PiePlot3D(data);
			JFreeChart chart = new JFreeChart("", // ͼ�α���
					JFreeChart.DEFAULT_TITLE_FONT, // ��������
					plot, // ͼ��������
					true // �Ƿ���ʾͼ��
			);
			// ͼ����ʾ�ٷֱ�:�Զ��巽ʽ�� {0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ����
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
					"{0}={1}({2})", NumberFormat.getInstance(),
					new DecimalFormat("0.00%")));
			plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
					"{0}={1}({2})"));
			// ��������ͼƬ�ı���ɫ
			chart.setBackgroundPaint(Color.WHITE);
			// ����ͼƬ�б߿�
			chart.setBorderVisible(true);
			// ��������
			Font kfont = new Font("����", Font.PLAIN, 12); // �ײ�
			Font titleFont = new Font("����", Font.BOLD, 25); // ͼƬ����
			// ͼƬ����
			chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));
			// �ײ�
			chart.getLegend().setItemFont(kfont);
			ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1.0f,
					chart, 500, 300, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}