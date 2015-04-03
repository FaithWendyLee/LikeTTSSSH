package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;

import model.Assistant;
import model.Teacher;
import dao.TeacherDao;

public class TeacherDaoImpl implements TeacherDao{
	@Resource
	private SessionFactory sessionFactory;
	private static TeacherDaoImpl teacherDao = new TeacherDaoImpl();

	public static TeacherDao getInstance() {
		// TODO Auto-generated method stub
		return teacherDao;
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public ArrayList<Teacher> getTeacherList() {
		ArrayList<Teacher> tlist = (ArrayList<Teacher>) new HibernateTemplate(sessionFactory).find("from Teacher");
		return tlist;
	}

	@Override
	public void addTeacher(Teacher tea) {
		new HibernateTemplate(sessionFactory).save(tea);
	}

	public Teacher getTeacher(int teaid) {
		Teacher tea = new HibernateTemplate(sessionFactory).get(Teacher.class, teaid);
		return tea;
	}

	@Override
	public void alterTeacher(Teacher tea) {
		new HibernateTemplate(sessionFactory).update(tea);
	}
	
	public Teacher findTeacher(String name, String pwd) {
		String hql = "from Teacher t where t.teaname=? and t.teapwd=?";
		Teacher t = (Teacher) new HibernateTemplate(sessionFactory).find(hql,new String[]{name, pwd}).get(0);
		return t;
	}

}
