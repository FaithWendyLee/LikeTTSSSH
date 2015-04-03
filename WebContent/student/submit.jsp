<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="model.Plan"%>
<%@page import="dao.impl.*"%>
<%@page import="service.*"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="service.PlanServiceImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="plan" class="model.Plan" scope="page">
</jsp:useBean>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>submit</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/homeworks.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="col-xs-2"></div>
	<div class="col-xs-8">
	<%
			request.setCharacterEncoding("utf-8");
			String pid = (String) request.getParameter("id");
			int planid=Integer.parseInt(pid);
			PlanService ps = (PlanService) request.getSession()
					.getAttribute("planService");
			Plan p = ps.findPlan(planid);
			pageContext.setAttribute("plan", p);

			request.setAttribute("cid", p.getCid());
		%>
		<div class="panel panel-default">
			<div class="panel-body courseinfo">
				作业<%=p.getPlannumber()%><br>
				<hr>
				作业编号：<%=p.getPlannumber()%><br> 学生提交截止日期：<%=p.getStuduetime()%><br>
				作业文件格式：<%=p.getFormat()%><br> 分数：<%=p.getScore()%><br> 难度：<%=p.getDifficulty()%><br>
				内容：<%=p.getContent()%><br>
				<s:form enctype="multipart/form-data" action="/student/uploadhomework">
					<input type="file" name="file" size="30">
					<input type="hidden" name="pid" value="<%=pid %>"/>
					<Button>提交</Button>
				</s:form>
			</div>
		</div>

	</div>
	<div class="col-xs-2"></div>



</body>
</html>