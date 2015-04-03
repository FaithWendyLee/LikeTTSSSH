package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SampleComment implements java.io.Serializable{
	private int fileid;
	private int courseid;
	private String filename;
	private String uptime;
	
	@Id
	public int getFileid(){
		return fileid;
	}
	public void setFileid(int fileid){
		this.fileid=fileid;
	}
	
	public int getCourseid(){
		return courseid;
	}
	public void setCourseid(int courseid){
		this.courseid=courseid;
	}

	
	public String getFilename(){
		return filename;
	}
	public void setFilename(String filename){
		this.filename=filename;
	}

	public String getUptime(){
		return uptime;
	}
	public void setUptime(String uptime){
		this.uptime=uptime;
	}
	

}
