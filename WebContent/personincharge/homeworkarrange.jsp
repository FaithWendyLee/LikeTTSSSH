<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>homeworkarrange</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="col-xs-2"></div>
	<div class="col-xs-8">
		<%
		request.setCharacterEncoding("utf-8");
		String month=(String)request.getAttribute("month");;
	%>
		<div class="div-right">
		<s:form action="/pic/Month">
			<input type="text"  name="monthtext"/> 
			 <input type="hidden" name="flag" value="arrange"/>
			<Button>统计</Button>
			</s:form>
		</div>
		<center>
		    <%
		    if(month==null){

	%>
			    <h3>学生作业安排情况统计</h3>
			<img  alt="还未统计。。。" width=500 height=300 border=0>
		<%
		    }else{
		    	request.getSession().setAttribute("month", month);
	%>
	
		    <h3>学生作业安排情况统计<%=month%></h3>
		     <img src="<s:url action="homeworkarrangestu" namespace="pic"></s:url>" />
	<%
		    }
	%>
	
	
	
	
		    <%
		    if(month==null){
		    	
	%>
	<h3>助教作业安排情况统计</h3>
			<img  alt="还未统计。。。" width=500 height=300 border=0>
		<%
		    }else{
		    	request.getSession().setAttribute("month", month);
	%>
	<h3>助教作业安排情况统计<%=month%></h3>
	<img src="<s:url action="homeworkarrangeass" namespace="pic"></s:url>" />
	<%
		    }
	%>
		</center>
	</div>
	<div class="col-xs-2"></div>
</body>
</html>