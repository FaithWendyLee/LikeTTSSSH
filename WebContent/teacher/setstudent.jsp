<%@page import="model.Student"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="service.*"%>
<%@page import="dao.impl.*"%>
<%@page import= "org.springframework.context.ApplicationContext"%>
<%@page import= "org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:useBean id="student" class="model.Student" scope="page">
</jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MyHomework</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script type="text/javascript" src="../js/homeworks.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<%
	    String id = (String) request.getSession().getAttribute("id");
		int cid = Integer.parseInt(id);
		CourseService cs=(CourseService)request.getSession().getAttribute("courseService");
		Course c = cs.getCourse(cid);
		request.getSession().setAttribute("courseid", id);
		request.getSession().setAttribute("course", c);
	%>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="col-xs-8">
	<div class="panel panel-default">
			<div class="panel-body courseinfo">
				选课学生<br>
				<hr>
				学生：<%=c.getStudentlist()%><br>
			</div>
		</div>
	
	
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	Date date = sdf.parse("2015-04-06");
    Date nowDate = new Date();
	boolean isOver=date.before(nowDate);
    if(isOver){
		%>
		&nbsp;
		<%		
	}else{
				if (date.before(nowDate)) {
			%>
			&nbsp;
			<%
					}
			else{
	%>
	
		<s:form  action="/teacher/setstudent">
			<div class="div-right">
				<input type="text" placeholder="输入学号 " name="aa" /> <input
					type="button" value="查找" onClick="gorow()" /> <button>确定</button>
			</div>
			<table class="table table-bordered" id="t1">
				<caption>
					<h3>安排学生</h3>
				</caption>
				<thead>
					<tr>
						<th>学生编号</th>
						<th>学生姓名</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					ArrayList<Student> studentList=(ArrayList<Student>)request.getSession().getAttribute("studentList");
					
						for (int i = 0; i < studentList.size(); i++) {
							Student stu = studentList.get(i);
							pageContext.setAttribute("student", stu);
					%>

					<TR>
						<TD id="<%=stu.getNumber()%>"><jsp:getProperty name="student"
								property="number" /></TD>
						<TD><jsp:getProperty name="student" property="stuname" /></TD>
						<TD><input type="checkbox" name="studentlist"
							value="<%=stu.getStuname()%>"></TD>
						<%
							}
						%>
					</TR>
				</tbody>
			</table>
		</s:form>
		<%
			}}
						%>
	</div>
	<div class="col-xs-2"></div>

</body>
</html>