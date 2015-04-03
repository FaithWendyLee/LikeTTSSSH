<%@page import="model.Teacher"%>
<%@page import="service.TeacherServiceImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="dao.impl.*"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="stu" class="model.Student" scope="page">
</jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>teacherinfo</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="col-xs-2"></div>
	<div class="col-xs-8">
	<%
    Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
					%>
		<div class="panel panel-default">
			<div class="panel-body studentinfo">
				个人信息<br>
				<hr>
				账号：<%=teacher.getTeaname()%><br>
				密码：<%=teacher.getTeapwd()%>
			</div>
		</div>
	</div>
	<div class="col-xs-2"></div>



</body>
</html>