<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="model.Assistant"%>
<%@page import="model.Course"%>
<%@page import="dao.impl.*"%>
<%@page import="service.*"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
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
		int id = (Integer)request.getSession().getAttribute("stuid");
		System.out.println(id);

		String strcid = (String) request.getSession().getAttribute("courseid");
		int cid=Integer.parseInt(strcid);
		request.getSession().setAttribute("stuid", id);
		request.setAttribute("courseid", cid+"");
	%>
	<div class="col-xs-2">
		<div class="list-group">
			<a href="courseinfostu.jsp?param=<%=cid%>" class="list-group-item">基本信息</a> 
			<a href="uploadhomework.jsp" class="list-group-item">上传作业</a>
			<a href="samplecomment.jsp?param=<%=cid%>" class="list-group-item">查看点评及样例</a>
			<a href="checkgrade.jsp?param=<%=cid%>"	class="list-group-item">查看成绩</a>
		</div>
	</div>
</body>
</html>