package service;

import java.util.ArrayList;

import model.Score;

public interface ScoreService {
	public ArrayList<Score> getScore();
	public void uploadScore(Score s);
	public void updateScore(Score s);
	public Score findScore(int pid);
	public void remove(int planid);

}
