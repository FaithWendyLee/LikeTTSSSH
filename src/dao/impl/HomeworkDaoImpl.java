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
import model.Homework;
import model.Score;
import dao.HomeworkDao;

public class HomeworkDaoImpl implements HomeworkDao{
	@Resource
	private SessionFactory sessionFactory;
	private static HomeworkDaoImpl hwDaoImpl = new HomeworkDaoImpl();

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	@Override
	public void uploadHw(Homework hw) {
		new HibernateTemplate(sessionFactory).save(hw);
		
	}

	public static HomeworkDaoImpl getInstance() {
		// TODO Auto-generated method stub
		return hwDaoImpl;
	}

	public ArrayList<Homework> getHomework() {
		ArrayList<Homework> hlist = (ArrayList<Homework>) new HibernateTemplate(sessionFactory).find("from Homework");
		return hlist;
	}

	@Override
	public void remove(int pid){
		String hql = "from Homework h where h.pid=?";
		Homework h = (Homework) new HibernateTemplate(sessionFactory).find(hql,pid).get(0);
		new HibernateTemplate(sessionFactory).delete(h);
	}

	@Override
	public Homework getHomeworkBypid(int pid) {
		String hql = "from Homework h where h.pid=?";
		Homework h = (Homework) new HibernateTemplate(sessionFactory).find(hql,pid).get(0);
		return h;
	}
}
