package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher implements java.io.Serializable{
	private int teaid;
	private String teaname;
	private String teapwd;
	public Teacher(){}
	public Teacher(String name, String pwd) {
		// TODO Auto-generated constructor stub
		this.teaname=name;
		this.teapwd=pwd;
	}
	public void setTeaid(int id){
		this.teaid=id;
	}
	@Id
	public int getTeaid(){
		return teaid;
	}
	public void setTeaname(String name){
		this.teaname=name;
	}
	public String getTeaname(){
		return teaname;
	}
	public void setTeapwd(String password){
		this.teapwd=password;
	}
	public String getTeapwd(){
		return teapwd;
	}
	

}
