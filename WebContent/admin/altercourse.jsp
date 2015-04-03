<%@page import="model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="dao.impl.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "org.springframework.context.ApplicationContext"%>
<%@page import= "org.springframework.context.support.ClassPathXmlApplicationContext"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyHomework</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
	<%

		String alter =request.getParameter("param");
		request.getSession().setAttribute("alterflag", alter);
		
		%>
		<s:form action="/admin/altercourse" class="form-signin">
		<h2>修改课程</h2>
			<label>课程编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="number" /><br> <br>
			<label>课程名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="name" /><br>
			<br> 
			<label>学期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
				type="text" name="term" placeholder="2015 Summer"/><br> <br>
			<label>开始时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
				type="text" name="begintime" placeholder="2015-03-01"/><br> <br>
			<label>结束时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
				type="text" name="endtime" placeholder="2015-07-01"/><br> <br>
			<label >授课教师 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><br>
				<%

			ArrayList<Teacher> teacherList=(ArrayList<Teacher>)request.getSession().getAttribute("teacherList");
			for (int i = 0; i < teacherList.size(); i++) {
 		    Teacher tea = teacherList.get(i);
 			pageContext.setAttribute("teacher", tea);
 %>
            <label class="checkbox">
			<input type="checkbox" name="teacherlist" value="<%=tea.getTeaname()%> "/><%=tea.getTeaname()%><br>
			</label>
			<%
				}
			%><br> <br> 
			<button class="btn btn-lg btn-primary "">确定</button>
		</s:form>
	</div>
</body>
</html>