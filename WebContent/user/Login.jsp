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
    
	<div class="container">
      <s:form action="/admin/login" class="form-signin">
         <h2 class="form-signin-heading">请登录</h2>
        <input type="text" class="form-control" placeholder="昵称" id="login" name="login" autofocus>
        <input type="password" class="form-control" placeholder="密码" id="password" name="password">      
        <select class="form-control" name="identity">
				<option>系统管理员</option>
				<option>选课学生</option>
				<option>助教</option>
				<option>授课教师</option>
				<option>教学负责人</option>
			</select>
			<br><br> 
        <button class="btn btn-lg btn-primary btn-block" onClick="check();">登陆</button>
      </s:form>
    </div>
</body>
</html>