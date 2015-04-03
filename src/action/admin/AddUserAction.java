package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Repository;

import service.AssistantService;
import service.PersonInChargeService;
import service.StudentService;
import service.TeacherService;
import action.BaseAction;
import model.Assistant;
import model.PersonInCharge;
import model.Student;
import model.Teacher;

/**
 * Servlet implementation class AddUser
 */
@Repository
public class AddUserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private StudentService studentService; // 使用Spring注解注入业务方法
	private TeacherService teacherService; // 使用Spring注解注入业务方法
	private PersonInChargeService personInChargeService; // 使用Spring注解注入业务方法
	private AssistantService assistantService; // 使用Spring注解注入业务方法
       
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

	public String execute() throws Exception{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String identity=request.getParameter("identity");
		HttpSession session = request.getSession();
		
		if(identity.equals("选课学生")){
			Student stu=new Student(name,pwd);
			stu.setNumber(number);
			studentService.addStudent(stu);
			ArrayList<Student> studentList=(ArrayList<Student>) studentService.getStudent();
			session.setAttribute("studentList", studentList);
		}else if(identity.equals("助教")){
			Assistant assistant=new Assistant(name,pwd);
			assistantService.addAssistant(assistant);
			ArrayList<Assistant> assistantList=(ArrayList<Assistant>) assistantService.getAssistant();
			session.setAttribute("assistantList", assistantList);
		}else if(identity.equals("授课教师")){
			Teacher tea=new Teacher(name,pwd);
			teacherService.addTeacher(tea);
			ArrayList<Teacher> teacherList=(ArrayList<Teacher>) teacherService.getTeacher();
			session.setAttribute("teacherList", teacherList);
		}else if(identity.equals("教学负责人")){
			PersonInCharge rp=new PersonInCharge(name,pwd);
			personInChargeService.addPersonInCharge(rp);
			ArrayList<PersonInCharge> personinchargeList=(ArrayList<PersonInCharge>) personInChargeService.getPersonInCharge();
			session.setAttribute("personinchargeList", personinchargeList);
		}
		return "success";
	}
	
	
}
