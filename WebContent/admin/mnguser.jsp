<%@page import="model.Student"%>
<%@page import="model.Assistant"%>
<%@page import="model.Teacher"%>
<%@page import="model.PersonInCharge"%>
<%@page import="service.AssistantServiceImpl"%>
<%@page import="service.PersonInChargeServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page import="dao.impl.*"%>
<%@page import="java.net.URLDecoder"%>
<%@page import= "org.springframework.context.ApplicationContext"%>
<%@page import= "org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mnguser</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="col-xs-2"></div>
	<div class="col-xs-8">
		<form name="/admin/alter_user">
		<div class="div-right">
		
	<%
	String name = (String) request.getSession().getAttribute("name");
	request.setAttribute("name", name);
	%>
			<a href="adduser.jsp" target="_parent">注册用户</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		</div>
		<table class="table table-bordered">
			<caption>选课学生</caption>
			<thead>
				<tr>
					<th>学号</th>
					<th>学生姓名</th>
					<th>学生密码</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			
					<%

					ArrayList<Student> studentList=(ArrayList<Student>)request.getSession().getAttribute("studentList");
					for (int i = 0; i < studentList.size(); i++) {
					    Student stu=studentList.get(i);
					%>
					<TR>
						<TD><%=stu.getNumber()%></TD>
						<TD><%=stu.getStuname()%></TD>
						<TD><%=stu.getStupwd()%></TD>
						<TD><a href="alteruser.jsp?param=0<%=stu.getId()%>" target="_parent">修改</a></TD>
					</TR>
					<%
					}
					%>
			</tbody>
		</table>

		<table class="table table-bordered">
			<caption>助  教</caption>
			<thead>
				<tr>
					<th>助教编号</th>
					<th>助教姓名</th>
					<th>助教密码</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<Assistant> assistantList=(ArrayList<Assistant>)request.getSession().getAttribute("assistantList");
				for (int i = 0; i < assistantList.size(); i++) {
					Assistant ass=assistantList.get(i);
				%>
					
					<TR>
						<TD><%=ass.getAssistantid()%></TD>
						<TD><%=ass.getAssistantname()%></TD>
						<TD><%=ass.getAssistantpwd()%></TD>
						<TD><a href="alteruser.jsp?param=1<%=ass.getAssistantid()%>" target="_parent">修改</a></TD>
						<%
							}
						%>
					</TR>
			</tbody>
		</table>

		<table class="table table-bordered">
			<caption>授课教师</caption>
			<thead>
				<tr>
					<th>教师编号</th>
					<th>教师姓名</th>
					<th>教师密码</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			
					<%
					ArrayList<Teacher> teacherList=(ArrayList<Teacher>)request.getSession().getAttribute("teacherList");
					for (int i = 0; i < teacherList.size(); i++) {
						Teacher tea=teacherList.get(i);
						%>
					
					<TR>
						<TD><%=tea.getTeaid()%></TD>
						<TD><%=tea.getTeaname()%></TD>
						<TD><%=tea.getTeapwd()%></TD>
						<TD><a href="alteruser.jsp?param=2<%=tea.getTeaid()%>" target="_parent">修改</a></TD>
						<%
							}
						%>
					</TR>
			</tbody>
		</table>

		<table class="table table-bordered">
			<caption>教学负责人</caption>
			<thead>
				<tr>
					<th>负责人编号</th>
					<th>负责人姓名</th>
					<th>负责人密码</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			
					<%
					ArrayList<PersonInCharge> personinchargeList=(ArrayList<PersonInCharge>)request.getSession().getAttribute("personinchargeList");
					for (int i = 0; i < personinchargeList.size(); i++) {
						PersonInCharge pinc=personinchargeList.get(i);
						%>
					
					<TR>
						<TD><%=pinc.getPicid()%></TD>
						<TD><%=pinc.getPicname()%></TD>
						<TD><%=pinc.getPicpwd()%></TD>
						<TD><a href="alteruser.jsp?param=3<%=pinc.getPicid()%>" target="_parent">修改</a></TD>
					</TR>
					<%
					}
						%>
			</tbody>
		</table>
		</form>
	</div>
	<div class="col-xs-2"></div>



</body>
</html>