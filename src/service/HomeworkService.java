package service;

import java.util.ArrayList;

import model.Homework;

public interface HomeworkService {
	public ArrayList<Homework> getHomework();

	public void uploadHw(Homework hw);

	public void remove(int planid);

	public Homework getHomeworkBypid(int planid);
}
