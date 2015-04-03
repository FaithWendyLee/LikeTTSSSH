package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements java.io.Serializable{
	private int id;
	private String number;
	private String stuname;
	private String stupwd;

	public Student() {
	}
	
	public Student(String stuname, String stupwd) {
		this.stuname = stuname;
		this.stupwd = stupwd;
	}
	@Id
	public int getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}
	


	public void setId(int id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStupwd() {
		return stupwd;
	}

	public void setStupwd(String stupwd) {
		this.stupwd = stupwd;
	}
}
