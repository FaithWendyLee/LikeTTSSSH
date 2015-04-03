package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import action.BaseAction;
import service.AssistantService;
import service.PersonInChargeService;
import service.StudentService;
import service.TeacherService;
import model.Assistant;
import model.PersonInCharge;
import model.Student;
import model.Teacher;

/**
 * Servlet implementation class alteruser
 */
public class AlterUserAction extends BaseAction {
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

	public void setPersonInChargeService(
			PersonInChargeService personInChargeService) {
		this.personInChargeService = personInChargeService;
	}

	public AssistantService getAssistantService() {
		return assistantService;
	}

	public void setAssistantService(AssistantService assistantService) {
		this.assistantService = assistantService;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		
		String alter = (String) request.getSession().getAttribute("alterflag");
		if (alter == null) {
			JOptionPane.showMessageDialog(null, "请选择要修改的用户！");
			return "failed";
		}
		char identity = alter.charAt(0);
		String alter2 = alter.substring(1);
		int userid = Integer.parseInt(alter2);

		if (identity == '0') {
			String number=request.getParameter("number");
			String stuname=request.getParameter("name");
			String stupwd=request.getParameter("pwd");
			Student stu = studentService
					.getStudent(userid);
			stu.setNumber(number);
			stu.setStuname(stuname);
			stu.setStupwd(stupwd);
			studentService.alterStudent(stu);
			ArrayList<Student> studentList=(ArrayList<Student>) studentService.getStudent();
			session.setAttribute("studentList", studentList);
		} else if (identity == '1') {
			String assname=request.getParameter("name");
			String asspwd=request.getParameter("pwd");
			Assistant ass = assistantService
					.getAssistant(userid);
			ass.setAssistantname(assname);
			ass.setAssistantpwd(asspwd);
			assistantService.alterAssistant(ass);
			ArrayList<Assistant> assistantList=(ArrayList<Assistant>) assistantService.getAssistant();
			session.setAttribute("assistantList", assistantList);
		} else if (identity == '2') {
			String teaname=request.getParameter("name");
			String teapwd=request.getParameter("pwd");
			Teacher tea = teacherService
					.getTeacher(userid);
			tea.setTeaname(teaname);
			tea.setTeapwd(teapwd);
			teacherService.alterTeacher(tea);
			ArrayList<Teacher> teacherList=(ArrayList<Teacher>) teacherService.getTeacher();
			session.setAttribute("teacherList", teacherList);
		} else if (identity == '3') {
			String rpname=request.getParameter("name");
			String rppwd=request.getParameter("pwd");
			PersonInCharge pic = personInChargeService.getPersonInCharge(
							userid);
			pic.setPicname(rpname);
			pic.setPicpwd(rppwd);
			personInChargeService.alterPersonInCharge(pic);
			ArrayList<PersonInCharge> personinchargeList=(ArrayList<PersonInCharge>) personInChargeService.getPersonInCharge();
			session.setAttribute("personinchargeList", personinchargeList);
		}
		
		return "success";

	}

}
