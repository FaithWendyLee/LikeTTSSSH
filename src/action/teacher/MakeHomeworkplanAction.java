package action.teacher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import service.PlanService;
import action.BaseAction;
import model.Plan;

/**
 * Servlet implementation class makeplan
 */
public class MakeHomeworkplanAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private PlanService planService; // 使用Spring注解注入业务方法
	public PlanService getPlanService() {
		return planService;
	}
	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	public String execute() throws Exception{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		response.setContentType("text/html");
		String courseid=request.getParameter("courseid");
		int cid=Integer.parseInt(courseid);
		String pnumber=request.getParameter("plannumber");
		String datestu=request.getParameter("datestu");
		String dateass = request.getParameter("dateass");
		String format = request.getParameter("format");
		String score = request.getParameter("score");
		String difficulty = request.getParameter("difficulty");
		String content = request.getParameter("content");
		Plan p = new Plan();
		p.setCid(cid);
		p.setPlannumber(pnumber);
		p.setStuduetime(datestu);
		p.setAssduetime(dateass);
		p.setFormat(format);
		p.setScore(score);
		p.setDifficulty(difficulty);
		p.setContent(content);
		Date nowDate = new Date();
		String ptime=(new SimpleDateFormat("yyyy-MM-dd")).format(nowDate); 
		p.setPtime(ptime);
		planService.addPlan(p);
		ArrayList<Plan> planList=(ArrayList<Plan>) planService.getPlan();
		session.setAttribute("planList", planList);
	    return "success";
	}

}
