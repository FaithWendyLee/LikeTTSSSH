package model;

import java.text.ParseException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.JOptionPane;
@Entity
public class Score implements java.io.Serializable{
	private int scoreid;
	private int planid;
	private int assid;
	private String scorename;
	private String scorecheck;
	private String stime;

	
	public void setScoreid(int scoreid){
		this.scoreid=scoreid;
	}
	
	
	@Id
	public int getScoreid(){
		return scoreid;
	}
	
	public void setPlanid(int planid){
		this.planid=planid;
	}
	public int getPlanid(){
		return planid;
	}

	public void setAssid(int assid){
		this.assid=assid;
	}
	public int getAssid(){
		return assid;
	}
	
	
	public void setScorename(String scorename){
		this.scorename=scorename;
	}
	public String getScorename(){
		return scorename;
	}
	public void setScorecheck(String scorecheck) {
		this.scorecheck=scorecheck;
	}
	public String getScorecheck(){
		return scorecheck;
	}
	public String getStime(){
		return stime;
	}
	public void setStime(String stime){
		this.stime=stime;
	}
	
	public boolean getIsupload(String month) throws ParseException{
		String hmonthtime=stime.substring(0,7);
		return month.equals(hmonthtime);
	}
}
