package action.teacher;

import java.io.*;

import javax.servlet.ServletOutputStream;

import action.BaseAction;

public class DownLoadScoreAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception{

		String path = "D://apache-tomcat-7.0.56//webapps//data//assistant";
		String fileName;
			fileName = new String(((String) request.getParameter("scorename")).getBytes("ISO8859-1"),"UTF-8");
		

		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String(fileName.getBytes("utf-8"), "ISO-8859-1"));

		  File file = new File(path + "/" + fileName);
		  //����ļ�����
		  if (file.exists()) {
		   //������Ӧ���ͼ���Ӧͷ
		   response.setContentType("application/x-msdownload");
		   //��ȡ�ļ�
		   InputStream inputStream = new FileInputStream(file);
		   BufferedInputStream bis = new BufferedInputStream(inputStream);
		   byte[] bytes = new byte[1024];

		   ServletOutputStream outStream = response.getOutputStream();
		   BufferedOutputStream bos = new BufferedOutputStream(outStream);
		   int readLength = 0;
		   while ((readLength = bis.read(bytes)) != -1) {
		    bos.write(bytes, 0, readLength);
		   }
		   //�ͷ���Դ
		   inputStream.close();
		   bis.close();
		   bos.flush();
		   outStream.close();
		   bos.close();
		  }
		return null;
	}
}
