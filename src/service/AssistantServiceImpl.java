package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.AssistantDao;
import model.Assistant;
@Service() 
public class AssistantServiceImpl implements AssistantService{
	private AssistantDao assistantDao;
	public AssistantDao getAssistantDao() {
		return assistantDao;
	}
	public void setAssistantDao(AssistantDao assistantDao) {
		this.assistantDao = assistantDao;
	}

	public void addAssistant(Assistant assistant){
		assistantDao.add(assistant);	
	}

	public ArrayList<Assistant> getAssistant(){
		return assistantDao.getAssistantList();
		
		
	}

	public Assistant getAssistant(int assistantid) {
		// TODO Auto-generated method stub
		return assistantDao.findbyID(assistantid);
	}

	public void alterAssistant(Assistant ass) {
		// TODO Auto-generated method stub
		assistantDao.alterassistant(ass);
	}

	@Override
	public Assistant findAssistant(String name, String pwd) {
		// TODO Auto-generated method stub
		return assistantDao.findAssistant(name, pwd);
	}
}
