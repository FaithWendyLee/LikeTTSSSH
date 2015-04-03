package service;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.AssistantDao;
import dao.CourseDao;
import model.Course;
@Service() 
public class CourseServiceImpl implements CourseService{
	private CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void addCourse(Course c) {
		// TODO Auto-generated method stub
		courseDao.addCourse(c);
	}

	@Override
	public Course getCourse(int courseid) {
		// TODO Auto-generated method stub
		return courseDao.getCourse(courseid);
	}

	@Override
	public void alterCourse(Course c) {
		// TODO Auto-generated method stub
		courseDao.alterCourse(c);
	}

	public ArrayList<Course> getCourse() {
		// TODO Auto-generated method stub
		return courseDao.getCourseList();
	}



}
