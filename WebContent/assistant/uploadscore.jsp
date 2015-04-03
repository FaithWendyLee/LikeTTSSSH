<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="model.Score"%>
<%@page import="model.Course"%>
<%@page import="model.Plan"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="service.ScoreServiceImpl"%>
<%@page import="service.PlanServiceImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="service.*"%>
<%@page import="dao.impl.*"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="plan" class="model.Plan" scope="page">
</jsp:useBean>
<jsp:useBean id="score" class="model.Score" scope="page">
</jsp:useBean>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>uploadScore</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/homeworks.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<%
		request.setCharacterEncoding("utf-8");
		CourseService cs = (CourseService) request.getSession()
				.getAttribute("courseService");

		 int cidint= (Integer)request.getSession().getAttribute("courseid");
		request.setAttribute("courseid", cidint);
		String cid=cidint+"";
	%>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="col-xs-8">
		<%
			request.setCharacterEncoding("utf-8");
			int id = (Integer) request.getSession().getAttribute("assid");
			ArrayList<Plan> planlist = (ArrayList<Plan>) request.getSession()
					.getAttribute("planList");
			for (int i = planlist.size() - 1; i >= 0; i--) {
				Plan p = planlist.get(i);
				pageContext.setAttribute("plan", p);
				String pcid = p.getCid() + "";

				if (pcid.equals(cid)) {
		%>
		<div class="panel panel-default">
			<div class="panel-body courseinfo">
				作业<%=p.getPlannumber()%><br>
				<hr>
				作业编号：<%=p.getPlannumber()%><br> 助教提交截止日期：<%=p.getAssduetime()%><br>
				作业文件格式：<%=p.getFormat()%><br> 分数：<%=p.getScore()%><br> 难度：<%=p.getFormat()%><br>
				内容：<%=p.getContent()%><br>

				<%
							if (p.Assover()) {
				%>
				未提交，已结束~
				<%
					} else {
								ScoreService ss = (ScoreService) request.getSession()
										.getAttribute("scoreService");

								Score s = ss.findScore(p.getPid());
								if (s == null) {
									session.setAttribute("cid", cid);
									session.setAttribute("assid", id);
				%>
				<a href="submit.jsp?id=<%=p.getPid()%>">提交</a>
				<%
					} else {
									if (s.getScorecheck().equals("agree")) {
				%>
				已成功提交~
				<%
					} else if (s.getScorecheck().equals("disagree")) {
										session.setAttribute("cid", cid);
										session.setAttribute("assid", id);
				%>
				<a href="submit.jsp?id=<%=p.getPid()%>">需重新提交</a>
				<%
					} else if (s.getScorecheck().equals("wait")) {
				%>
				正在审核~
				<%
					}
								}
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