package service;

import java.util.ArrayList;

import model.Assistant;

public interface AssistantService {
	public void addAssistant(Assistant assistant);
	public ArrayList<Assistant> getAssistant();
	public Assistant getAssistant(int assistantid);
	public void alterAssistant(Assistant ass);
	public Assistant findAssistant(String name, String pw);
}
