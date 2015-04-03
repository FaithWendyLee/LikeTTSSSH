package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonInCharge implements java.io.Serializable{
	private int picid;
	private String picname;
	private String picpwd;

	public PersonInCharge() {
		// TODO Auto-generated constructor stub
	}
	public PersonInCharge(String name, String pwd) {
		picname=name;
	    picpwd=pwd;
	}
	@Id
	public int getPicid(){
		return picid;
	}
	public void setPicid(int picid){
		this.picid=picid;
	}
	
	public String getPicname(){
		return picname;
	}
	public void setPicname(String picname){
		this.picname=picname;
	}
	
	public String getPicpwd(){
		return picpwd;
	}
	public void setPicpwd(String picpwd){
		this.picpwd=picpwd;
	}

}
