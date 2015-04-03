package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.CourseDao;
import dao.SampleCommentDao;
import model.Plan;
import model.SampleComment;
@Service() 
public class SampleCommentServiceImpl implements SampleCommentService{
	private SampleCommentDao sampleCommentDao;

	public ArrayList<SampleComment> getSampleComment() {
		// TODO Auto-generated method stub
		try {
			return sampleCommentDao.getSampleComment();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public SampleCommentDao getSampleCommentDao() {
		return sampleCommentDao;
	}
	public void setSampleCommentDao(SampleCommentDao sampleCommentDao) {
		this.sampleCommentDao = sampleCommentDao;
	}
	public void addSampleComment(SampleComment f) {
		// TODO Auto-generated method stub
		sampleCommentDao.addSampleComment(f);
	}

}
