<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="model.Plan"%>
<%@page import="model.Course"%>
<%@page import="model.Score"%>
<%@page import="service.ScoreServiceImpl"%>
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
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>assscore</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/scores.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="col-xs-8">
		<%
			request.setCharacterEncoding("utf-8");
			String cid = (String) request.getSession().getAttribute("id");
			CourseService cs = (CourseService) request.getSession()
					.getAttribute("courseService");
			ArrayList<Plan> planlist = (ArrayList<Plan>) request.getSession()
					.getAttribute("planList");
			int ccid = Integer.parseInt(cid);
			Course c = cs.getCourse(ccid);
			for (int i = planlist.size() - 1; i >= 0; i--) {
				Plan p = planlist.get(i);
				String pcid = p.getCid() + "";

				if (pcid.equals(cid)) {
		%>
		<div class="panel panel-default">
			<div class="panel-body courseinfo">
				作业<%=p.getPlannumber()%><br>
				<hr>
				<%
					ArrayList<Score> sl = (ArrayList<Score>) request
									.getSession().getAttribute("scoreList");
							String pathwenjian = "D://apache-tomcat-7.0.56//webapps//data//assistant";
							//声明集合存放目录下所有文件的文件名
							ArrayList<Score> ScoreList = new ArrayList<Score>();
							File folder = new File(pathwenjian);
							//判断文件夹是否存在并且是否是一个目录
							if (folder.exists() && folder.isDirectory()) {
								//获得目录中所有文件及目录
								File[] files = folder.listFiles();
								for (File file : files) {
									//如果是文件
									if (file.isFile()) {
										//将文件名放入集合中
										for (int j = 0; j < sl.size(); j++) {
											if (sl.get(j).getScorename()
													.equals(file.getName())
													&& p.getPid() == sl.get(j)
															.getPlanid()) {
												ScoreList.add(sl.get(j));
											}
										}
									}
								}
							}
							//此处设计不好，需要限制提交score的name必须unique！；
							//需要限制每个plan只对应一个score
							//哪天知道怎么改了，记得来改一下~

							for (int k = 0; k < ScoreList.size(); k++) {
								String scorename = ScoreList.get(k).getScorename();
								String state = ScoreList.get(k).getScorecheck();
								System.out.println(state+"+++");
								if (c.IsOver()) {
									
				%>
				<%=scorename%>
				<%
					} else {
				%>
				<s:url action="downloadscore" id="Logincd">
					<s:param name="scorename"><%=scorename%></s:param>
				</s:url>
				<s:a href="%{Logincd}"><%=scorename%></s:a>
				<br />
				
				
				<s:form id="form" action="/teacher/checkassscore">
					<%
						if (state.equals("agree")) {
					%>
					<div class="div-right">
						<h4>已发布~</h4>
					</div>

					<%
						} else if (state.equals("disagree")) {
					%>
					<div class="div-right">
						<h4>未通过，需重批~</h4>
					</div>

					<%
						} else if (state.equals("wait")) {
					%>
					<div class="div-right">
						<input type="hidden" value="<%=p.getPid()%>" name="planid">
						<input type="hidden" value="<%=cid%>" name="courseid"> 
						<input type="submit" value="同意发布" name="agree" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="submit" value="不同意" name="disagree" />
					</div>
					<%
						}
					%>
				</s:form>
				<%
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
