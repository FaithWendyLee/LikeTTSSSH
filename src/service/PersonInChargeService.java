package service;

import java.util.ArrayList;

import model.Assistant;
import model.PersonInCharge;

public interface PersonInChargeService {

	public PersonInCharge findPersonInCharge(String name, String pw);

	public void addPersonInCharge(PersonInCharge rp);

	public PersonInCharge getPersonInCharge(int userid);

	public void alterPersonInCharge(PersonInCharge rp);

	public ArrayList<PersonInCharge> getPersonInCharge();
}
