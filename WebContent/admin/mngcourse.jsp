<%@page import="model.Course"%>
<%@page import="service.CourseServiceImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.impl.*"%>
<%@page import= "org.springframework.context.ApplicationContext"%>
<%@page import= "org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="course"
	class="model.Course" scope="page">
</jsp:useBean> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>mngcourse</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<div class="col-xs-2"></div>
	<div class="col-xs-8">
		<div class="div-right">
			<a href="addcourse.jsp" target="_parent">添加课程</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		</div>

		
		<table class="table table-bordered">
			<caption>课程</caption>
			<thead>
				<tr>
					<th>课程编号</th>
					<th>课程名</th>
					<th>学期</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>授课教师</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			
					<%
					ArrayList<Course> courseList=(ArrayList<Course>)request.getSession().getAttribute("courseList");
					for (int i = 0; i < courseList.size(); i++) {
						Course c=courseList.get(i);
						pageContext.setAttribute("course",c );
					%>
					
					<TR>
						<TD><jsp:getProperty name="course" property="cnumber" /></TD>
						<TD><jsp:getProperty name="course"	property="cname" /></TD>
						<TD><jsp:getProperty name="course" property="term" /></TD>
						<TD><jsp:getProperty name="course" property="begintime" /></TD>
						<TD><jsp:getProperty name="course" property="endtime" /></TD>
						<TD><jsp:getProperty name="course" property="teacherlist" /></TD>
						<TD><a href="altercourse.jsp?param=<%=c.getCid()%>" target="_parent">修改</a></TD>
						<%
						} 
						%>
					</TR>
			</tbody>
		</table>
	</div>
	<div class="col-xs-2"></div>



</body>
</html>