<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		<s:form action="/admin/addUser">
		<h2>注册用户</h2>
			<label>学号</label><input type="text" name="number" placeholder="仅选课学生填"/><br> <br> 
			<label>姓名</label><input type="text" name="name"/><br> <br> 
			<label>密码</label><input type="password" name="pwd"/><br> <br> 
			<label>确认</label><input type="password" name="pwd"/><br> <br> 
			<label>身份</label> 
			<select name="identity">
				<option>选课学生</option>
				<option>助教</option>
				<option>授课教师</option>
				<option>教学负责人</option>
			</select>
			<br><br> 
			<button class="btn btn-lg btn-primary " onClick="check();">提交注册</button>
		</s:form>
	</div>
</body>
</html>