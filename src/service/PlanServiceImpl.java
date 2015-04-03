package service;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.CourseDao;
import dao.PlanDao;
import sun.util.calendar.BaseCalendar.Date;
import model.Plan;
@Service() 
public class PlanServiceImpl implements PlanService{
	private PlanDao planDao;
	@Override
	public ArrayList<Plan> getPlan() {
		// TODO Auto-generated method stub
		try {
			return planDao.getPlanList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public PlanDao getPlanDao() {
		return planDao;
	}
	public void setPlanDao(PlanDao planDao) {
		this.planDao = planDao;
	}
	@Override
	public void addPlan(Plan p) {
		// TODO Auto-generated method stub
		planDao.addPlan(p);
	}

	@Override
	public Plan findPlan(int pid) {
		// TODO Auto-generated method stub
		return planDao.findPlan(pid);
	}
}
