<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="model.Plan"%>
<%@page import="service.*"%>
<%@page import="dao.impl.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="service.PlanServiceImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="plan" class="model.Plan" scope="page">
</jsp:useBean>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>uploadhomework</title>
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
        String strcid= (String)request.getAttribute("courseid");
			int id = (Integer) request.getSession().getAttribute("stuid");
			CourseService cs = (CourseService) request.getSession()
					.getAttribute("courseService");
			ArrayList<Plan> planlist=(ArrayList<Plan>)request.getSession().getAttribute("planList");

            int cid=Integer.parseInt(strcid);

			for (int i = planlist.size() - 1; i >= 0; i--) {
				Plan p = planlist.get(i);
				pageContext.setAttribute("plan", p);
				int pcid = p.getCid();

				if (pcid==cid) {
		%>
		<div class="panel panel-default">
			<div class="panel-body courseinfo">
				作业<%=p.getPlannumber()%><br>
				<hr>
				作业编号：<%=p.getPlannumber()%><br> 学生提交截止日期：<%=p.getStuduetime()%><br>
				作业文件格式：<%=p.getFormat()%><br> 分数：<%=p.getScore()%><br> 难度：<%=p.getFormat()%><br>
				内容：<%=p.getContent()%><br>
				<%
					if (p.Stuover()) {
				%>
				已结束提交
				<%
					} else {
						session.setAttribute("cid", cid);
						session.setAttribute("stuid", id);;
						   
					%>
					<a href="submit.jsp?id=<%=p.getPid()%>">提交</a>
				<%
					}
				%>
			</div>
		</div>
		<%
			}
			}
		%>

	</div>
	<div class="col-xs-2"></div>



</body>
</html>