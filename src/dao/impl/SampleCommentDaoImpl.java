package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;

import model.Assistant;
import model.SampleComment;
import dao.SampleCommentDao;

public class SampleCommentDaoImpl implements SampleCommentDao {
	@Resource
	private SessionFactory sessionFactory;
	private static SampleCommentDaoImpl fileDaoImpl = new SampleCommentDaoImpl();

	public static SampleCommentDaoImpl getInstance() {
		// TODO Auto-generated method stub
		return fileDaoImpl;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public ArrayList<SampleComment> getSampleComment() {
		ArrayList<SampleComment> sclist = (ArrayList<SampleComment>) new HibernateTemplate(sessionFactory).find("from SampleComment");
		return sclist;
	}

	@Override
	public void addSampleComment(SampleComment sc) {
		new HibernateTemplate(sessionFactory).save(sc);
	}
}
