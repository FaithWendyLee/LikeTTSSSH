package service;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistantDao;
import dao.TeacherDao;
import model.Teacher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AssistantDao;
import dao.StudentDao;
import model.Assistant;
import model.Student;
@Service 
public class TeacherServiceImpl implements TeacherService{
	private TeacherDao teacherDao;


	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public ArrayList<Teacher> getTeacher() {
		// TODO Auto-generated method stub
		return teacherDao.getTeacherList();
	}

	public void addTeacher(Teacher tea) {
		// TODO Auto-generated method stub
		teacherDao.addTeacher(tea);
		
	}

	@Override
	public Teacher getTeacher(int userid) {
		// TODO Auto-generated method stub
		return teacherDao.getTeacher(userid);
	}

	public void alterTeacher(Teacher tea) {
		// TODO Auto-generated method stub
		teacherDao.alterTeacher(tea);
		
	}

	@Override
	public Teacher findTeacher(String name, String pw) {
		// TODO Auto-generated method stub
		return teacherDao.findTeacher(name,pw);
	}


}
