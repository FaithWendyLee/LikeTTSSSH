package dao;

import java.util.ArrayList;

import model.Assistant;

public interface AssistantDao {

	public void add(Assistant assistant);

	public ArrayList<Assistant> getAssistantList();

	public Assistant findbyID(int id);

	public void alterassistant(Assistant ass);

	public Assistant findAssistant(String name,String pwd);
}
