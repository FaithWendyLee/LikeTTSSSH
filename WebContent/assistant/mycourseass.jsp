<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="dao.impl.*"%>
<%@page import="model.Course"%>
<%@page import="model.Assistant"%>
<%@page import="service.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLDecoder"%>
<%@page import= "org.springframework.context.ApplicationContext"%>
<%@page import= "org.springframework.context.support.ClassPathXmlApplicationContext"%>
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
	<div class="col-xs-2">
		
	</div>
	<div class="col-xs-8">
		<form name="frm" method="post" action="">
			<table class="table table-bordered">
				<caption>我的课程</caption>
				<thead>
					<tr>
						<th>课程编号</th>
						<th>课程名</th>
						<th>学期</th>
						<th>授课教师</th>
					</tr>
				</thead>
				<tbody>

					<%
						request.setCharacterEncoding("utf-8");
						int id = (Integer)request.getSession().getAttribute("assid");
						AssistantService as = (AssistantService) request.getSession().getAttribute("assistantService");
						Assistant ass=as.getAssistant(id);
						String assname=ass.getAssistantname();
						ArrayList<Course> courselist=(ArrayList<Course>)request.getSession().getAttribute("courseList");
						for (int i = 0; i < courselist.size(); i++) {
							boolean isExist = false;
							Course c = courselist.get(i);
							pageContext.setAttribute("course", c);
							if(c.getAssistantlist()==null)
								continue;
							else if (c.getAssistantlist().equals(assname))
								isExist = true;
							String[] arr = c.getAssistantlist().split(" ");
							for (int j = 0; j < arr.length; j++) {
								if (arr[j].equals(assname)) {
									isExist = true;
								}
							}
							if (isExist) {
								session.setAttribute("assid", id);
								request.setAttribute("course",c);
					%>
					<TR>
						<TD><jsp:getProperty name="course" property="cnumber" /></TD>
						<TD><a href="../assistant/courseinfoass.jsp?param=<%=c.getCid()%>"><%=c.getCname()%></a></TD>
						<TD><jsp:getProperty name="course" property="term" /></TD>
						<TD><jsp:getProperty name="course" property="teacherlist" /></TD>
						<%
							}
							}
						%>
					</TR>
				</tbody>
			</table>
		</form>
	</div>
	<div class="col-xs-2"></div>



</body>
</html>