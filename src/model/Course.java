package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
@Entity
public class Course implements java.io.Serializable{
	private int cid;
	private String cnumber;
	private String cname;
	private String term;
	private String teacherlist;
	private String assistantlist;
	private String studentlist;
	private String begintime;
	private String endtime;

	public Course() {
	}
	@Id
	public int getCid(){
		return cid;
	}
	public void setCid(int id){
		this.cid=id;
	}
	
	public String getCnumber(){
		return cnumber;
	}
	public void setCnumber(String number){
		this.cnumber=number;
	}
	
	public String getCname(){
		return cname;
	}
	public void setCname(String name){
		this.cname=name;
	}
	
	public String getTerm(){
		return term;
	}
	public void setTerm(String term){
		this.term=term;
	}
	
	public String getBegintime() throws ParseException{
		return begintime;
	}
	public void setBegintime(String begintime){
		this.begintime=begintime;
	}
	public String getEndtime() throws ParseException{
		return endtime;
	}
	public void setEndtime(String endtime){
		this.endtime=endtime;
	}
	public String getTeacherlist(){
		return teacherlist;
	}
	public void setTeacherlist(String teacherlist){
		this.teacherlist=teacherlist;
	}
	
	public String getAssistantlist(){
		return assistantlist;
	}
	public void setAssistantlist(String assistantlist){
		this.assistantlist=assistantlist;
	}

	
	public String getStudentlist(){
		return studentlist;
	}
	public void setStudentlist(String studentlist){
		this.studentlist=studentlist;
	}
	

	@SuppressWarnings("deprecation")
	public boolean IsOver() throws ParseException{
		Date nowdate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		Date enddate=sdf.parse(endtime);
		return (nowdate.after(enddate));
	}
	public boolean IsBetween(String month) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		String datemonth1=month+"-31";
		Date date1=sdf.parse(datemonth1); 
		String datemonth2=month+"-01";
		Date date2=sdf.parse(datemonth2); 
		Date begindate=sdf.parse(begintime);
		Date enddate=sdf.parse(endtime);
		return (date1.after(begindate)&&date2.before(enddate));
	}
	
}
