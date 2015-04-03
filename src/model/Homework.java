package model;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Homework implements java.io.Serializable{
	private int hid;
	private int pid;
	private int sid;
	private String hname;
	private String htime;

	@Id
	public int getHid(){
		return hid;
	}
	public void setHid(int hid){
		this.hid=hid;
	}
	
	public int getPid(){
		return pid;
	}
	public void setPid(int pid){
		this.pid=pid;
	}
	
	public int getSid(){
		return sid;
	}
	public void setSid(int sid){
		this.sid=sid;
	}
	
	public String getHname(){
		return hname;
	}
	public void setHname(String hname){
		this.hname=hname;
	}
	
	public String getHtime(){
		return htime;
	}
	public void setHtime(String htime){
		this.htime=htime;
	}
	
	public boolean getIsupload(String month){
		String hmonthtime=htime.substring(0,7);
		return month.equals(hmonthtime);
	}
	
}
