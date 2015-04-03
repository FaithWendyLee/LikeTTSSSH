package action.personincharge;

import action.BaseAction;

public class MonthAction extends BaseAction{ 
	public String execute() throws Exception{  
    	request.setCharacterEncoding("utf-8");
		String month=request.getParameter("monthtext");
		request.setAttribute("month", month);
		String flag=request.getParameter("flag");
		String message=null;
		switch(flag){
		case "info":message="info";break;
		case "arrange":message="arrange";
		break;
		case "upload":message="upload";break;
		case "scoreupload":message="scoreupload";break;
		}
		return message;
    }  

}
