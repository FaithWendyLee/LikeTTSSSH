package service;

import java.util.ArrayList;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import dao.HomeworkDao;
import model.Homework;
@Service() 
public class HomeworkServiceImpl implements HomeworkService{
	private HomeworkDao homeworkDao;

	public HomeworkDao getHomeworkDao() {
		return homeworkDao;
	}

	public void setHomeworkDao(HomeworkDao homeworkDao) {
		this.homeworkDao = homeworkDao;
	}

	public void uploadHw(Homework hw) {
		// TODO Auto-generated method stub
		homeworkDao.uploadHw(hw);
	}


	public ArrayList<Homework> getHomework() {
		// TODO Auto-generated method stub
		return homeworkDao.getHomework();
	}

	@Override
	public void remove(int planid) {
		// TODO Auto-generated method stub
		homeworkDao.remove(planid);
	}

	@Override
	public Homework getHomeworkBypid(int planid) {
		// TODO Auto-generated method stub
		return homeworkDao.getHomeworkBypid(planid);
	}
}
