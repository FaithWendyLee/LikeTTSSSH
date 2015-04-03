package dao;

import java.util.ArrayList;

import model.Student;
public interface StudentDao {

	
	
//	public Student find(String name,String password);

	public void add(Student stu);

	public ArrayList<Student> getStudentList();

	public Student findById(int id);

	public void updateStudent(Student stu);

	public Student findStudent(String name, String pw);
	
	
	
	

}
