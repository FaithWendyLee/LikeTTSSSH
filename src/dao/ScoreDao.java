package dao;

import java.util.ArrayList;

import model.Score;

public interface ScoreDao {
	public void uploadScore(Score s);
	
	public ArrayList<Score> getScore();


	void updateScore(Score s);

	public Score findScore(int pid);

	public void remove(int planid);



}
