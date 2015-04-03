package dao.impl;

import java.util.ArrayList;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import model.Plan;
import dao.PlanDao;

public class PlanDaoImpl implements PlanDao{
	@Resource
	private SessionFactory sessionFactory;
	private static PlanDaoImpl homeworkDaoImpl = new PlanDaoImpl();

	public static PlanDaoImpl getInstance() {
		// TODO Auto-generated method stub
		return homeworkDaoImpl;
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	@Override
	public ArrayList<Plan> getPlanList() {
		ArrayList<Plan> plist = (ArrayList<Plan>) new HibernateTemplate(sessionFactory).find("from Plan");
		return plist;
	}

	@Override
	public void addPlan(Plan p) {
		new HibernateTemplate(sessionFactory).save(p);
		
	}


	@Override
	public Plan findPlan(int pid) {
		Plan p = new HibernateTemplate(sessionFactory).get(Plan.class, pid);
		return p;
	}
	
	

}
