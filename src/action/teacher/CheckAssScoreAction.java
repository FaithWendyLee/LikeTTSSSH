package action.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.PlanService;
import service.ScoreService;
import action.BaseAction;
import dao.impl.PlanDaoImpl;
import dao.impl.ScoreDaoImpl;
import model.Score;

/**
 * Servlet implementation class checkassscore
 */
// @WebServlet("/checkassscore")
public class CheckAssScoreAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private ScoreService scoreService; // 使用Spring注解注入业务方法


	public ScoreService getScoreService() {
		return scoreService;
	}


	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}


	public String execute() throws Exception{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		String agree = request.getParameter("agree");
		String disagree = request.getParameter("disagree");
		String planid = request.getParameter("planid");
		String cid = request.getParameter("courseid");
		int pid=Integer.parseInt(planid);
		if (agree != null) {
			Score s=scoreService.findScore(pid);
			s.setScorecheck("agree");
			scoreService.updateScore(s);
		}
		if (disagree != null) {
			Score s=scoreService.findScore(pid);
			s.setScorecheck("disagree");
			scoreService.updateScore(s);
		}
		request.getSession().setAttribute("scoreList",scoreService.getScore());
		return "success";

	}

}
