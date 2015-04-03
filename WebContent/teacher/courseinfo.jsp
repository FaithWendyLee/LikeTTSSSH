<%@page import="model.Course"%>
<%@page import="service.CourseServiceImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="dao.impl.*"%>
<%@page import="service.*"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="course" class="model.Course" scope="page">
</jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>setcourse</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<%
		request.setCharacterEncoding("utf-8");
	    CourseService cs=(CourseService)request.getSession().getAttribute("courseService");
    	String id =request.getParameter("cid");
    	Course c=cs.getCourse(Integer.parseInt(id));
		String number = c.getCnumber();
		String name = c.getCname();
		String term = c.getTerm();
		String begintime = c.getBegintime();
		String endtime = c.getEndtime();
		String teacherlist = c.getTeacherlist();
		request.getSession().setAttribute("id", id);
	%>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="col-xs-8">
		<div class="panel panel-default">
			<div class="panel-body courseinfo">
				基本信息<br>
				<hr>
				课程编号：<%=number%><br> 课程名称：<%=name%><br>
				授课学期：<%=term%><br> 
				开始时间：<%=begintime%><br> 
				结束时间：<%=endtime%><br> 
				授课教师：<%=teacherlist%><br>
			</div>
		</div>
	</div>
	<div class="col-xs-2"></div>



</body>
</html>