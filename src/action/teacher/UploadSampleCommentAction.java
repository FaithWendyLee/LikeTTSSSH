package action.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import model.SampleComment;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.PlanService;
import service.SampleCommentService;
import action.BaseAction;
import dao.impl.PlanDaoImpl;
import dao.impl.SampleCommentDaoImpl;

public class UploadSampleCommentAction extends BaseAction {
	 //上传文件存放路径
    private final static String UPLOADDIR = "D://apache-tomcat-7.0.56//webapps//data//teacher";
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




	private SampleCommentService sampleCommentService; // 使用Spring注解注入业务方法




	public SampleCommentService getSampleCommentService() {
		return sampleCommentService;
	}




	public void setSampleCommentService(SampleCommentService sampleCommentService) {
		this.sampleCommentService = sampleCommentService;
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

		String courseid = (String) session.getAttribute("courseid");
		int cid = Integer.parseInt(courseid);
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
	            SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");// 设置日期格式
				System.out.println(df.format(new Date()));// new
															// Date()为获取当前系统时间


				String uptime = df.format(new Date());
				SampleComment mf = new SampleComment();

				mf.setCourseid(cid);
				mf.setFilename(this.getFileFileName().get(i));
				mf.setUptime(uptime);
				sampleCommentService.addSampleComment(mf);
				ArrayList<SampleComment> samplecommentList=(ArrayList<SampleComment>) sampleCommentService.getSampleComment();
				session.setAttribute("samplecommentList", samplecommentList);
	        } catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}// end doPost()
}