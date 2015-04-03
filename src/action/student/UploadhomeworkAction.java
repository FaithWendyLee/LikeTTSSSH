package action.student;

import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import model.Homework;
import service.HomeworkService;
import action.BaseAction;

public class UploadhomeworkAction extends BaseAction {
	 //上传文件存放路径
    private final static String UPLOADDIR = "D://apache-tomcat-7.0.56//webapps//data//student";
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
		String pids = (String) request.getParameter("pid");
		int planid = Integer.parseInt(pids);
		int stuid = (Integer)session.getAttribute("stuid");
		ArrayList<Homework> ah=homeworkService.getHomework();
		ArrayList<String> as=new ArrayList<String>();
		for(int j=0;j<ah.size();j++){
			if(ah.get(j).getSid()==stuid){
			as.add(ah.get(j).getPid()+"");
		}}
		while(as.contains(pids)){
			System.out.println(pids+"====");
			Homework h=homeworkService.getHomeworkBypid(planid);
			System.out.println(h.getHname()+"+++");
			if(h!=null){
				File deleteFile = new File(UPLOADDIR + "/" + h.getHname());
			    if (deleteFile.isFile() && deleteFile.exists()) {  
			    	deleteFile.delete();  
			    	}
			    homeworkService.remove(planid);
			}
			as.remove(pids);
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
	            Homework hw = new Homework();

				hw.setPid(planid);
				hw.setSid(stuid);
				hw.setHname(this.getFileFileName().get(i));
				Date nowDate = new Date();
				String sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(nowDate); 
				hw.setHtime(sdate);
				homeworkService.uploadHw(hw);
				int cid=(Integer)request.getSession().getAttribute("cid");
				request.setAttribute("cid", cid);
				
	        } catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}// end doPost()
}