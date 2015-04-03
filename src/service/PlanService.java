package service;

import java.util.ArrayList;

import model.Plan;

public interface PlanService {
	public ArrayList<Plan> getPlan();

	public void addPlan(Plan p);

	public Plan findPlan(int pid);
}
