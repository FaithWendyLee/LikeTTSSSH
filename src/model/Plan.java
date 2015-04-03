package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
@Entity
public class Plan implements java.io.Serializable{
	private int pid;
	private int cid;
	private String plannumber;
	private String studuetime;
	private String assduetime;
	private String format;
	private String score;
	private String difficulty;
	private String content;
	private String ptime;
	@Id
	public int getPid(){
		return pid;
	}
	public void setPid(int pid){
		this.pid=pid;
	}

	public int getCid(){
		return cid;
	}
	public void setCid(int cid){
		this.cid=cid;
	}
	public String getPlannumber() {
		return plannumber;
	}
	public void setPlannumber(String plannumber) {
		this.plannumber = plannumber;
	}
	public String getStuduetime() {
		return studuetime;
	}
	public void setStuduetime(String studuetime) {
		this.studuetime = studuetime;
	}
	public String getAssduetime() {
		return assduetime;
	}
	public void setAssduetime(String assduetime) {
		this.assduetime = assduetime;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

	public boolean getExiststu(String month) throws ParseException{
		String stumonth=studuetime.substring(0, 7);
		return month.equals(stumonth);
	}
	
	public boolean getExistass(String month) throws ParseException{
		String stumonth=assduetime.substring(0, 7);
		return month.equals(stumonth);
	}
	
	public String getPtime(){
		return ptime;
	}
	public void setPtime(String ptime){
		this.ptime=ptime;
	}
	
	public boolean getIsupload(String month) throws ParseException{
		String hmonthtime=ptime.substring(0,7);

		return month.equals(hmonthtime);
	}
	@SuppressWarnings("deprecation")
	public boolean Stuover() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = sdf.parse(studuetime);
	    Date nowDate = new Date();
		return nowDate.after(date);
	}
	@SuppressWarnings("deprecation")
	public boolean Assover() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = sdf.parse(assduetime);
	    Date nowDate = new Date();
		return nowDate.after(date);
	}
}
