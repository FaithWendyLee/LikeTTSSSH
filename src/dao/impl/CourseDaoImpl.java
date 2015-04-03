package dao.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import model.Course;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import dao.CourseDao;

public class CourseDaoImpl implements CourseDao{
	@Resource
	private SessionFactory sessionFactory;
	private static CourseDaoImpl courseDaoImpl  = new CourseDaoImpl();

	public static CourseDaoImpl getInstance() {
		// TODO Auto-generated method stub
		return courseDaoImpl;
	}
	
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ArrayList<Course> getCourseList() {
		ArrayList<Course> clist = (ArrayList<Course>) new HibernateTemplate(sessionFactory).find("from Course");
		return clist;

	}

	public void addCourse(Course c) {
		new HibernateTemplate(sessionFactory).save(c);
	}

	public Course getCourse(int courseid) {
		Course c = new HibernateTemplate(sessionFactory).get(Course.class, courseid);
		return c;
	}

	@Override
	public void alterCourse(Course c) {
		new HibernateTemplate(sessionFactory).update(c);
	}
}
