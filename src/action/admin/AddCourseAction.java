package action.admin;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import action.BaseAction;
import service.CourseService;
import service.StudentService;
import service.TeacherService;
import dao.impl.CourseDaoImpl;
import model.Course;
import model.Teacher;

/**
 * Servlet implementation class AddUser
 */
public class AddCourseAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private CourseService courseService; // 使用Spring注解注入业务方法
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String execute()throws Exception{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		response.setContentType("text/html");
		String number=request.getParameter("number");
		String name = request.getParameter("name");
		String term = request.getParameter("term");
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");
		String sc[] = request.getParameterValues("teacherlist");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<sc.length;i++){
			sb.append(sc[i]+" ");
		}
		String teacherlist=sb.toString();
		Course c = new Course();
		c.setCnumber(number);
		c.setCname(name);
		c.setTerm(term);
		c.setBegintime(begintime);
		c.setEndtime(endtime);
		c.setTeacherlist(teacherlist);
		courseService.addCourse(c);
		session.setAttribute("course", c);
		ArrayList<Course> courseList=(ArrayList<Course>) courseService.getCourse();
		session.setAttribute("courseList", courseList);

		return "success";
	}
}
