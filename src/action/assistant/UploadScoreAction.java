package action.assistant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Homework;
import model.Score;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.HomeworkService;
import service.ScoreService;
import action.BaseAction;
import dao.impl.HomeworkDaoImpl;
import dao.impl.ScoreDaoImpl;

/**
 * Servlet implementation class uploadhomework
 */
public class UploadScoreAction extends BaseAction {
	 //上传文件存放路径
    private final static String UPLOADDIR = "D://apache-tomcat-7.0.56//webapps//data//assistant";
    //上传文件集合
    private List<File> file;
    //上传文件名集合
    private List<String> fileFileName;
    //上传文件内容类型集合
    private List<String> fileContentType;
	public List<File> getFile() {
		return file;
	}




	public void setFile(List<File> file) {
		this.file = file;
	}




	public List<String> getFileFileName() {
		return fileFileName;
	}




	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}




	public List<String> getFileContentType() {
		return fileContentType;
	}




	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}




	private HomeworkService homeworkService; // 使用Spring注解注入业务方法




	public HomeworkService getHomeworkService() {
		return homeworkService;
	}




	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}


	public String execute() throws Exception {
        for (int i = 0; i < file.size(); i++) {
            //循环上传每个文件
            uploadFile(i);
        }
        return "success";
    }

	
	public void uploadFile(int i) throws Exception{
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		ScoreService scoreService=(ScoreService)request.getSession().getAttribute("scoreService");
		String pids = (String) session.getAttribute("pid");
		int planid = Integer.parseInt(pids);
		String cid=(String)session.getAttribute("cid");
		int assid = (Integer)session.getAttribute("assid");
		ArrayList<Score> ah=scoreService.getScore();
		ArrayList<String> as=new ArrayList<String>();
		for(int j=0;j<ah.size();j++){
			if(ah.get(j).getAssid()==assid){
			as.add(ah.get(j).getPlanid()+"");
		}}
		if(as.contains(pids)){
			Score s=scoreService.findScore(planid);
			if(s!=null){
				File deleteFile = new File(UPLOADDIR + "/" + s.getScorename());
			    if (deleteFile.isFile() && deleteFile.exists()) {  
			    	deleteFile.delete();  }
			    scoreService.remove(planid);
			}
		}
		 try {
	            InputStream in = new FileInputStream(file.get(i));
	            String dir = UPLOADDIR;
	            File uploadFile = new File(dir, this.getFileFileName().get(i));
	            OutputStream out = new FileOutputStream(uploadFile);
	            byte[] buffer = new byte[1024 * 1024];
	            int length;
	            while ((length = in.read(buffer)) > 0) {
	                out.write(buffer, 0, length);
	            }
	            in.close();
	            out.close();
	            Score sc = new Score();

				sc.setPlanid(planid);
				sc.setAssid(assid);
				sc.setScorename(this.getFileFileName().get(i));
				sc.setScorecheck("wait");
				Date nowDate = new Date();
				String stime=(new SimpleDateFormat("yyyy-MM-dd")).format(nowDate); 
				sc.setStime(stime);
				scoreService.uploadScore(sc);

				request.setAttribute("courseid", cid+"");
				
	        } catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}// end doPost()

}
