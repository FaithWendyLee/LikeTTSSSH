<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="model.Assistant"%>
<%@page import="model.Course"%>
<%@page import="dao.impl.*"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
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
	<%
		request.setCharacterEncoding("utf-8");
		String id = (String) request.getSession().getAttribute("id");
	%>
	<div class="col-xs-2">
		<div class="list-group">
			<a
				href="<%=request.getContextPath()%>/teacher/courseinfo.jsp?cid=<%=id %>"
				class="list-group-item">基本信息</a> <a
				href="<%=request.getContextPath()%>/teacher/setassistant.jsp"
				class="list-group-item">安排助教 </a> <a
				href="<%=request.getContextPath()%>/teacher/setstudent.jsp"
				class="list-group-item">安排学生</a> <a
				href="<%=request.getContextPath()%>/teacher/makehomeworkplan.jsp"
				class="list-group-item">制定作业计划</a> <a
				href="<%=request.getContextPath()%>/teacher/checkassScore.jsp"
				class="list-group-item">审查助教批的作业</a> <a
				href="<%=request.getContextPath()%>/teacher/uploadSampleComment.jsp"
				class="list-group-item">上传样例及点评</a>
		</div>
	</div>
</body>
</html>