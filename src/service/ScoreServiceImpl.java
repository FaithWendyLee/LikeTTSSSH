package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.CourseDao;
import dao.ScoreDao;
import model.Score;
@Service() 
public class ScoreServiceImpl implements ScoreService{
	private ScoreDao scoreDao;
	
	public ScoreDao getScoreDao() {
		return scoreDao;
	}

	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	@Override
	public void uploadScore(Score s) {
		// TODO Auto-generated method stub
		scoreDao.uploadScore(s);
		
	}

	@Override
	public ArrayList<Score> getScore() {
		// TODO Auto-generated method stub
		return scoreDao.getScore();
	}

	public void updateScore(Score s) {
		scoreDao.updateScore(s);
		
	}

	@Override
	public Score findScore(int pid) {
		// TODO Auto-generated method stub
		return scoreDao.findScore(pid);
	}


	@Override
	public void remove(int planid) {
		scoreDao.remove(planid);
		
	}


}
