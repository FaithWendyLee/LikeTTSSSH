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

import action.BaseAction;
import service.CourseService;
import dao.impl.CourseDaoImpl;
import model.Course;

public class SetAssistantAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private CourseService courseService; // 使用Spring注解注入业务方法
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Course c = (Course) session.getAttribute("course");
		String cid = (String) session.getAttribute("courseid");
		int id=Integer.parseInt(cid);
		response.setContentType("text/html");
		String al[] = request.getParameterValues("assistantlist");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<al.length;i++){
			sb.append(al[i]+" ");
		}
		String assistantlist=sb.toString();
		c.setAssistantlist(assistantlist);
		courseService.alterCourse(c);
		return "success";

	}
}
