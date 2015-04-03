package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Assistant implements java.io.Serializable{
	private int assistantid;
	private String assistantname;
	private String assistantpwd;

	public Assistant() {
		// TODO Auto-generated constructor stub
	}
	
	public Assistant(String name, String password) {
		// TODO Auto-generated constructor stub
		this.assistantname=name;
		this.assistantpwd=password;
	}

	@Id
	public int getAssistantid() {
		// TODO Auto-generated method stub
		return assistantid;
	}

	public String getAssistantname() {
		// TODO Auto-generated method stub
		return assistantname;
	}

	public void setAssistantname(String assistantname) {
		this.assistantname = assistantname;
	}

	public String getAssistantpwd() {
		return assistantpwd;
	}

	public void setAssistantpwd(String assistantpwd) {
		this.assistantpwd = assistantpwd;
	}

	public void setAssistantid(int assistantid) {
		this.assistantid = assistantid;
	}

}
