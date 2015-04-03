package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import dao.StudentDao;
import model.Student;
@Service() 
public class StudentServiceImpl implements StudentService
{
	
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}


	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public void addStudent(Student stu){
		studentDao.add(stu);		
	}


	public ArrayList<Student> getStudent(){
		return studentDao.getStudentList();
		
	}

	public void forwardPage(String page,HttpServletRequest req,HttpServletResponse resp) 
					throws ServletException,IOException
	{
		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL(page));
		dispater.forward(req,resp);
	}
	

	public Student getStudent(int id){
		return studentDao.findById(id);
	}

	public void alterStudent(Student stu){
		studentDao.updateStudent(stu);
		
	}

	@Override
	public Student findStudent(String name, String pw) {
		// TODO Auto-generated method stub
		return studentDao.findStudent(name,pw);
	}


}
