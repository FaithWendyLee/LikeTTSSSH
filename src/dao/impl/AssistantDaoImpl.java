package dao.impl;

import java.util.ArrayList;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import model.Assistant;
import dao.AssistantDao;

public class AssistantDaoImpl implements AssistantDao {
	@Resource
	private SessionFactory sessionFactory;
	private static AssistantDaoImpl assistantDaoImpl  = new AssistantDaoImpl();

	public static AssistantDaoImpl getInstance() {
		// TODO Auto-generated method stub
		return assistantDaoImpl;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	@Override
	public void add(Assistant assistant) {
		new HibernateTemplate(sessionFactory).save(assistant);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Assistant> getAssistantList() {
		ArrayList<Assistant> alist = (ArrayList<Assistant>) new HibernateTemplate(sessionFactory).find("from Assistant");
		return alist;

	}

	public Assistant findbyID(int id) {
		Assistant ass = new HibernateTemplate(sessionFactory).get(Assistant.class, id);
		return ass;
	}

	public void alterassistant(Assistant ass) {
		new HibernateTemplate(sessionFactory).update(ass);
	}

	@Override
	public Assistant findAssistant(String name, String pwd) {
		String hql = "from Assistant a where a.assistantname=? and a.assistantpwd=?";
		Assistant s = (Assistant) new HibernateTemplate(sessionFactory).find(hql,new String[]{name, pwd}).get(0);
		return s;
	}
	

}
