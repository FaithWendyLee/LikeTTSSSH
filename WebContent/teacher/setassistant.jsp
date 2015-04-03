<%@page import="model.Assistant"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.impl.*"%>
<%@page import="service.*"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:useBean id="assistant" class="model.Assistant" scope="page">
</jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MyHomework</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
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

		<%
			
		%>

		<div class="panel panel-default">
			<div class="panel-body courseinfo">
				助教信息<br>
				<hr>
				助教：<%=c.getAssistantlist()%><br>
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
			} else {
		%>
		<s:form action="/teacher/setassistant">
			<div class="div-right">
				<button>确定</button>
			</div>
			<table class="table table-bordered">
				<caption>
					<h3>安排助教</h3>
				</caption>
				<thead>
					<tr>
						<th>助教编号</th>
						<th>助教姓名</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					ArrayList<Assistant> assistantList=(ArrayList<Assistant>)request.getSession().getAttribute("assistantList");
					
										
						for (int i = 0; i < assistantList.size(); i++) {
								Assistant ass =assistantList.get(i);
								pageContext.setAttribute("assistant", ass);
					%>

					<TR>
						<TD><jsp:getProperty name="assistant" property="assistantid" /></TD>
						<TD><jsp:getProperty name="assistant"
								property="assistantname" /></TD>
						<TD><input type="checkbox" name="assistantlist"
							value="<%=ass.getAssistantname()%>"></TD>
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