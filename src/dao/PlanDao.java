package dao;

import java.text.ParseException;
import java.util.ArrayList;

import model.Plan;

public interface PlanDao {

	public ArrayList<Plan> getPlanList();

	public void addPlan(Plan p);

	public Plan findPlan(int pid);

}
