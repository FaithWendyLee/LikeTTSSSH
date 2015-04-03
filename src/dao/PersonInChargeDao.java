package dao;

import java.util.ArrayList;

import model.PersonInCharge;


public interface PersonInChargeDao {

	public PersonInCharge findPersonInCharge(String name,String pwd);

	public ArrayList<PersonInCharge> getPersonInCharge();

	public void addPersonInCharge(PersonInCharge pic);

	public PersonInCharge getPersonInCharge(int userid);

	public void alterPersonInCharge(PersonInCharge pic);
}
