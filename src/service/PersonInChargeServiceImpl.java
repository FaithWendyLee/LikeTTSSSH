package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AssistantDao;
import dao.PersonInChargeDao;
import model.PersonInCharge;
@Service 
public class PersonInChargeServiceImpl implements PersonInChargeService{

	private PersonInChargeDao personInChargeDao;

	public PersonInChargeDao getPersonInChargeDao() {
		return personInChargeDao;
	}

	public void setPersonInChargeDao(PersonInChargeDao personInChargeDao) {
		this.personInChargeDao = personInChargeDao;
	}

	@Override
	public PersonInCharge findPersonInCharge(String name, String pw) {
		// TODO Auto-generated method stub
		return personInChargeDao.findPersonInCharge(name, pw);
	}

	@Override
	public void addPersonInCharge(PersonInCharge pic) {
		personInChargeDao.addPersonInCharge(pic);
		
	}

	@Override
	public PersonInCharge getPersonInCharge(int userid) {
		// TODO Auto-generated method stub
		return personInChargeDao.getPersonInCharge(userid);
	}

	@Override
	public void alterPersonInCharge(PersonInCharge pic) {
		personInChargeDao.alterPersonInCharge(pic);
		
	}

	@Override
	public ArrayList<PersonInCharge> getPersonInCharge() {
		// TODO Auto-generated method stub
		return personInChargeDao.getPersonInCharge();
	}

}
