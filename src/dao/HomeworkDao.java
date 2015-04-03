package dao;

import java.util.ArrayList;

import model.Homework;


public interface HomeworkDao {

	public void uploadHw(Homework hw);

	public ArrayList<Homework> getHomework();

	public void remove(int planid);

	public Homework getHomeworkBypid(int planid);
}
