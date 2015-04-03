<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="model.Course"%>
<%@page import="model.SampleComment"%>
<%@page import="service.SampleCommentServiceImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="dao.impl.*"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>samplecomment</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/homeworks.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="col-xs-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
		<%
			request.setCharacterEncoding("utf-8");
			String cid = (String) request.getParameter("param");
		%>
		<div class="panel panel-default">
			<div class="panel-body courseinfo">
				请下载文件<br>
				<hr>
	    			<% ArrayList<Course> courseList=(ArrayList<Course>)request.getSession().getAttribute("courseList");
	    			ArrayList<SampleComment> sampleCommentList=(ArrayList<SampleComment>)request.getSession().getAttribute("sampleCommentList");
	    			for (int i = courseList.size() - 1; i >= 0; i--) {
						Course c = courseList.get(i);
						String ccid = c.getCid() + "";

						if (ccid.equals(cid)) {
							ArrayList<String> slString = new ArrayList<String>();
							for (int j = 0; j < sampleCommentList.size(); j++) {
								if (sampleCommentList.get(j).getCourseid() == c.getCid()) {
									slString.add(sampleCommentList.get(j).getFilename());
								}
							}
							String pathwenjian = "D://apache-tomcat-7.0.56//webapps//data//teacher";
							//声明集合存放目录下所有文件的文件名
							ArrayList<String> fileList = new ArrayList<String>();
							File folder = new File(pathwenjian);
							//判断文件夹是否存在并且是否是一个目录
							if (folder.exists() && folder.isDirectory()) {
								//获得目录中所有文件及目录
								File[] files = folder.listFiles();
								for (File file : files) {
									//如果是文件
									if (file.isFile()
											&& slString.contains(file.getName())) {
										//将文件名放入集合中
										fileList.add(file.getName());
									}
								}
							}

							for (int k = 0; k < fileList.size(); k++) {
								if (c.IsOver()) {
									%>
									<h4><%=fileList.get(k)%></h4>
									<%
								}
								else{
				%>
				<s:url action="downloadsamplecomment" id="Logincd">
					<s:param name="sampleCommentname"><%=fileList.get(k)%></s:param>
				</s:url>
				<s:a href="%{Logincd}"><%=fileList.get(k)%></s:a>
				<br>
				<%
								}}}}
				%>
			</div>
		</div>

	</div>
	<div class="col-xs-2"></div>



</body>
</html>