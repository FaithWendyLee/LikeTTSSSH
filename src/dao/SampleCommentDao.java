package dao;

import java.util.ArrayList;

import model.SampleComment;

public interface SampleCommentDao {
	public ArrayList<SampleComment> getSampleComment();

	public void addSampleComment(SampleComment sc);
}
