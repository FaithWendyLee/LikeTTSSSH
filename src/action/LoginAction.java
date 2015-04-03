package action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Repository;

import service.AssistantService;
import service.CourseService;
import service.HomeworkService;
import service.PersonInChargeService;
import service.PlanService;
import service.SampleCommentService;
import service.ScoreService;
import service.StudentService;
import service.TeacherService;
import model.Assistant;
import model.Course;
import model.Homework;
import model.PersonInCharge;
import model.Plan;
import model.SampleComment;
import model.Score;
import model.Student;
import model.Teacher;

/**
 * Servlet implementation class LoginServlet
 */
@Repository
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private StudentService studentService; // 使用Spring注解注入业务方法
	private TeacherService teacherService; // 使用Spring注解注入业务方法
	private PersonInChargeService personInChargeService; // 使用Spring注解注入业务方法
	private AssistantService assistantService; // 使用Spring注解注入业务方法
	private CourseService courseService; // 使用Spring注解注入业务方法
	private PlanService planService; // 使用Spring注解注入业务方法
	private ScoreService scoreService; // 使用Spring注解注入业务方法
	private SampleCommentService sampleCommentService; // 使用Spring注解注入业务方法
	private HomeworkService homeworkService; // 使用Spring注解注入业务方法





	public HomeworkService getHomeworkService() {
		return homeworkService;
	}


	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}


	public SampleCommentService getSampleCommentService() {
		return sampleCommentService;
	}


	public void setSampleCommentService(SampleCommentService sampleCommentService) {
		this.sampleCommentService = sampleCommentService;
	}


	public ScoreService getScoreService() {
		return scoreService;
	}


	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}


	public PlanService getPlanService() {
		return planService;
	}


	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}


	public StudentService getStudentService() {
		return studentService;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}


	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}



	public PersonInChargeService getPersonInChargeService() {
		return personInChargeService;
	}


	public void setPersonInChargeService(PersonInChargeService personInChargeService) {
		this.personInChargeService = personInChargeService;
	}


	public AssistantService getAssistantService() {
		return assistantService;
	}


	public void setAssistantService(AssistantService assistantService) {
		this.assistantService = assistantService;
	}

	public CourseService getCourseService() {
		return courseService;
	}


	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}


	public String execute() throws Exception {
		String name = request.getParameter("login");
		String pw = request.getParameter("password");
		String identity = request.getParameter("identity");
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		String message = "";
		switch (identity) {
		case "系统管理员": {
			if (name.equals("admin") && pw.equals("admin")) {
				message = "admin";
				
				ArrayList<Student> studentList=(ArrayList<Student>) studentService.getStudent();
				session.setAttribute("studentList", studentList);
				
				ArrayList<Assistant> assistantList=(ArrayList<Assistant>) assistantService.getAssistant();
				session.setAttribute("assistantList", assistantList);
				
				ArrayList<Teacher> teacherList=(ArrayList<Teacher>) teacherService.getTeacher();
				session.setAttribute("teacherList", teacherList);
				
				ArrayList<PersonInCharge> personinchargeList=(ArrayList<PersonInCharge>) personInChargeService.getPersonInCharge();
				session.setAttribute("personinchargeList", personinchargeList);
				
				ArrayList<Course> courseList=(ArrayList<Course>) courseService.getCourse();
				session.setAttribute("courseList", courseList);



			}
		}
			break;
		case "授课教师":{
			Teacher tea=teacherService.findTeacher(name, pw);
			if(tea==null)
				JOptionPane.showMessageDialog(null, "该用户不存在！");
			else{
				if(tea.getTeapwd()==null)
					JOptionPane.showMessageDialog(null, "密码错误！");
			       // TODO
				else{    			     	
					session.setAttribute("teacher", tea);
					session.setAttribute("courseService", courseService);
					session.setAttribute("planService", planService);
					session.setAttribute("courseService", courseService);
					ArrayList<Course> courseList=(ArrayList<Course>) courseService.getCourse();
					session.setAttribute("courseList", courseList);
					ArrayList<Student> studentList=(ArrayList<Student>) studentService.getStudent();
					session.setAttribute("studentList", studentList);
					ArrayList<Assistant> assistantList=(ArrayList<Assistant>) assistantService.getAssistant();
					session.setAttribute("assistantList", assistantList);
					ArrayList<Plan> planList=(ArrayList<Plan>) planService.getPlan();
					session.setAttribute("planList", planList);
					ArrayList<Score> scoreList=(ArrayList<Score>) scoreService.getScore();
					session.setAttribute("scoreList", scoreList);
					ArrayList<SampleComment> samplecommentList=(ArrayList<SampleComment>) sampleCommentService.getSampleComment();
					session.setAttribute("samplecommentList", samplecommentList);
					
					message = "teacher";
               }     					
			}	
		}break;
		case "选课学生":{
			Student student=studentService.findStudent(name, pw);
			if(student==null)
				JOptionPane.showMessageDialog(null, "该用户不存在！");
			else{
				if(student.getStupwd()==null)
					JOptionPane.showMessageDialog(null, "密码错误！");
			       // TODO
				else{
					session.setAttribute("student", student);
					session.setAttribute("courseService", courseService);
					session.setAttribute("planService", planService);
					session.setAttribute("planService", planService);
					session.setAttribute("studentService", studentService);
					ArrayList<Course> courseList=(ArrayList<Course>) courseService.getCourse();
					session.setAttribute("courseList", courseList);
					ArrayList<Student> studentList=(ArrayList<Student>) studentService.getStudent();
					session.setAttribute("studentList", studentList);
					ArrayList<Plan> planList=(ArrayList<Plan>) planService.getPlan();
					session.setAttribute("planList", planList);
					ArrayList<Score> scoreList=(ArrayList<Score>) scoreService.getScore();
					session.setAttribute("scoreList", scoreList);
					ArrayList<SampleComment> sampleCommentList=(ArrayList<SampleComment>) sampleCommentService.getSampleComment();
					session.setAttribute("sampleCommentList", sampleCommentList);
					ArrayList<Homework> homeworkList=(ArrayList<Homework>) homeworkService.getHomework();
					session.setAttribute("homeworkList", homeworkList);
					int stuid=student.getId();
					session.setAttribute("stuid", stuid);
					message = "student";
					
               }     					
			}	

		}break;
		case "助教":{
			Assistant ass=assistantService.findAssistant(name, pw);
			if(ass==null){
				JOptionPane.showMessageDialog(null, "该用户不存在！");				
			}
			if(ass.getAssistantpwd()==null)
				JOptionPane.showMessageDialog(null, "密码错误！");
		       // TODO
			else{
				int assid=ass.getAssistantid();
				request.getSession().setAttribute("assid", assid);
				session.setAttribute("assistantService", assistantService);
				session.setAttribute("courseService", courseService);
				session.setAttribute("scoreService", scoreService);
				session.setAttribute("planService", planService);
				ArrayList<Course> courseList=(ArrayList<Course>) courseService.getCourse();
				session.setAttribute("courseList", courseList);
				ArrayList<Plan> planList=(ArrayList<Plan>) planService.getPlan();
				session.setAttribute("planList", planList);
				ArrayList<Homework> homeworkList=(ArrayList<Homework>) homeworkService.getHomework();
				session.setAttribute("homeworkList", homeworkList);
				ArrayList<Score> scorelist=(ArrayList<Score>)request.getSession().getAttribute("scoreList");
				session.setAttribute("scorelist", scorelist);
				message = "assistant";
			}
		}break;
		case "教学负责人": {
			PersonInCharge personincharge=personInChargeService.findPersonInCharge(name, pw);
			if(personincharge==null){
				JOptionPane.showMessageDialog(null, "该用户不存在！");				
			}
			if(personincharge.getPicpwd()==null)
				JOptionPane.showMessageDialog(null, "密码错误！");
		       // TODO
			else{

				session.setAttribute("personincharge", personincharge);
				int personinchargeid=personincharge.getPicid();
				ArrayList<Score> scorelist=(ArrayList<Score>)scoreService.getScore();
				session.setAttribute("scoreList", scorelist);
				ArrayList<Homework> homeworkList=(ArrayList<Homework>) homeworkService.getHomework();
				session.setAttribute("homeworkList", homeworkList);
				ArrayList<Course> courseList=(ArrayList<Course>) courseService.getCourse();
				session.setAttribute("courseList", courseList);
				session.setAttribute("planService", planService);
				ArrayList<Plan> planList=(ArrayList<Plan>) planService.getPlan();
				session.setAttribute("planList", planList);
				session.setAttribute("personInChargeService", personInChargeService);
				request.setAttribute("personinchargeid", personinchargeid);
				message = "personincharge";
			}
		}
		}
		return message;
	}

}
