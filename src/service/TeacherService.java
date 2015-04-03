package service;

import java.util.ArrayList;
import java.util.Calendar;

import model.Teacher;

public interface TeacherService {
	public ArrayList<Teacher> getTeacher();

	public void addTeacher(Teacher tea);

	public Teacher getTeacher(int userid);

	public void alterTeacher(Teacher tea);

	public Teacher findTeacher(String name, String pw);
	
}
