package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;

import dao.PersonInChargeDao;
import model.Assistant;
import model.PersonInCharge;


public class PersonInChargeDaoImpl implements PersonInChargeDao{
	@Resource
	private SessionFactory sessionFactory;
	private static PersonInChargeDaoImpl picDao = new PersonInChargeDaoImpl();

	public static PersonInChargeDao getInstance() {
		// TODO Auto-generated method stub
		return picDao;
	}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	@Override
	public PersonInCharge findPersonInCharge(String name, String pwd) {
		String hql = "from PersonInCharge p where p.picname=? and p.picpwd=?";
		PersonInCharge pic = (PersonInCharge) new HibernateTemplate(sessionFactory).find(hql,new String[]{name, pwd}).get(0);
		return pic;
	}

	@Override
	public ArrayList<PersonInCharge> getPersonInCharge() {
		ArrayList<PersonInCharge> piclist=(ArrayList<PersonInCharge>) new HibernateTemplate(sessionFactory).find("from PersonInCharge");
		return piclist;
	}

	@Override
	public void addPersonInCharge(PersonInCharge pic) {
		new HibernateTemplate(sessionFactory).save(pic);
	}

	@Override
	public PersonInCharge getPersonInCharge(int userid) {
		PersonInCharge pic = new HibernateTemplate(sessionFactory).get(PersonInCharge.class, userid);
		return pic;
	}

	@Override
	public void alterPersonInCharge(PersonInCharge pic) {
		new HibernateTemplate(sessionFactory).update(pic);

		
	}


}
