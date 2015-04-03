package dao;

import java.util.ArrayList;

import model.Teacher;

public interface TeacherDao {
	public ArrayList<Teacher> getTeacherList();

	public void addTeacher(Teacher tea);

	public Teacher getTeacher(int userid);

	public void alterTeacher(Teacher tea);

	public Teacher findTeacher(String name, String pw);

}
