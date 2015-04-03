<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="model.*" %>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
</head>
<body>
<header class="navbar navbar-inverse navbar-fixed-top docs-nav"
		role="banner">
	<div class="container">
		<div class="navbar-header navbar-brand">
			MyHomeworks
		</div>
		<nav class="collapse navbar-collapse bs-navbar-collapse"
			role="navigation">
		<ul class="nav navbar-nav navbar-left">
			<li><a href="<%=request.getContextPath() %>/teacher/mycourse.jsp">我的课程</a></li>
		</ul>
		<%
			request.setCharacterEncoding("utf-8");
		    Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
					%>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="../teacher/teacherinfo.jsp">欢迎<%=teacher.getTeaname()%></a></li>
			<li><a href="<%=request.getContextPath() %>/admin/Login.jsp">退出</a></li>
		</ul>
		</nav>
	</div>
	</header>
</body>
</html>