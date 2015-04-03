<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"
%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="model.Course"%>
<%@page import="model.SampleComment"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="dao.impl.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.*"%>
<%@page import="service.*"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="plan" class="model.Plan" scope="page">
</jsp:useBean>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>uploadSamplecomment</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/homeworks.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>

	<jsp:include page="left.jsp"></jsp:include>
	<div class="col-xs-8">
     	<%
			request.setCharacterEncoding("utf-8");
		String cid = (String) request.getSession().getAttribute("id");
			int courseid=Integer.parseInt(cid);
			CourseService cs = (CourseService) request.getSession()
					.getAttribute("courseService");
			Course c= cs.getCourse(courseid);
		%>
		<div class="panel panel-default">
			<div class="panel-body courseinfo">
				作业样例及点评<br>
				<hr>
				<%

				ArrayList<SampleComment> samplecommentList = (ArrayList<SampleComment>) request.getSession()
						.getAttribute("samplecommentList");
				for(int i = 0;i < samplecommentList
					.size();i++){
					SampleComment sc=samplecommentList.get(i);
					if(sc.getCourseid()==courseid){
				%>	
				    <h4><%=sc.getFilename()%></h4>
				<%	
					}
				}
			    session.setAttribute("courseid",cid);


			    Date nowDate = new Date();
				 if (c.IsOver()) {
									%>
									&nbsp;
									<%
								}
								else{%>
				<s:form enctype="multipart/form-data" action="/teacher/uploadsamplecomment">
					<input type="file" name="file" size="30">
					<Button>提交</Button>
				</s:form>
				<%
								}
								%>
			</div>
		</div>

	</div>
	<div class="col-xs-2"></div>



</body>
</html>
