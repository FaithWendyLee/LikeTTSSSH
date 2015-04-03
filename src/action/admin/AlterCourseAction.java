package action.admin;

import java.io.IOException;
import java.util.ArrayList;

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
import model.Student;

public class AlterCourseAction extends BaseAction {
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

		String alter = (String) request.getSession().getAttribute("alterflag");
		if (alter == null) {
			JOptionPane.showMessageDialog(null, "请选择要修改的课程！balala~~~");
			return "failed";
		}
		int courseid = Integer.parseInt(alter);
		Course course = courseService.getCourse(courseid);


		String cnumber = request.getParameter("number");
		String cname = request.getParameter("name");
		String term = request.getParameter("term");
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");
		String sc[] = request.getParameterValues("teacherlist");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<sc.length;i++){
			sb.append(sc[i]);
		}
		String teacherlist=sb.toString();
		course.setCnumber(cnumber);
		course.setCname(cname);
		course.setTerm(term);
		course.setBegintime(begintime);
		course.setEndtime(endtime);
		course.setTeacherlist(teacherlist);
		
		
		courseService.alterCourse(course);
		ArrayList<Course> courseList=(ArrayList<Course>) courseService.getCourse();
		session.setAttribute("courseList", courseList);
		return "success";
	}

}
