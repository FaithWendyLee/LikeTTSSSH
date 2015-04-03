<%@page import="model.Plan"%>
<%@page import="model.Course"%>
<%@page import="service.PlanServiceImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="dao.impl.*"%>
<%@page import="service.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import= "org.springframework.context.ApplicationContext"%>
<%@page import= "org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="plan" class="model.Plan" scope="page">
</jsp:useBean>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>makehomeworkplan</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/homeworks.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	
	<jsp:include page="left.jsp"></jsp:include>
	<div class="col-xs-8">
			<table class="table table-bordered">
				<caption><h3>作业计划</h3></caption>
				<thead>
					<tr>
						<th>作业编号</th>
						<th>学生提交截止日期</th>
						<th>助教批改截止日期</th>
						<th>作业文件格式</th>
						<th>分数</th>
						<th>难度</th>
						<th>内容</th>
						<th>发布时间</th>
					</tr>
				</thead>
				<tbody>

					<%
					CourseService cs=(CourseService)request.getSession().getAttribute("courseService");
                    ArrayList<Plan> planlist=(ArrayList<Plan>)request.getSession().getAttribute("planList");
					request.setCharacterEncoding("utf-8");
											String cid = (String)request.getSession().getAttribute("id");
											int ccid=Integer.parseInt(cid);
											Course c= cs.getCourse(ccid);
											int pnumber=0;
												for (int i = 0; i <planlist.size(); i++) {
													Plan p = planlist.get(i);
													pageContext.setAttribute("plan", p);
													String pcid=p.getCid()+"";
													if (pcid.equals(cid)){
														pnumber++;
					%>
					<TR>
						<TD><jsp:getProperty name="plan" property="plannumber" /></TD>
						<TD><jsp:getProperty name="plan" property="studuetime" /></TD>
						<TD><jsp:getProperty name="plan" property="assduetime" /></TD>
						<TD><jsp:getProperty name="plan" property="format" /></TD>
						<TD><jsp:getProperty name="plan" property="score" /></TD>
						<TD><jsp:getProperty name="plan" property="difficulty" /></TD>
						<TD><jsp:getProperty name="plan" property="content" /></TD>
						<TD><jsp:getProperty name="plan" property="ptime" /></TD>
						<%
							}
							}
						%>
					</TR>
				</tbody>
			</table>
		<div class="div-right">
			<a href="importhp.jsp?param=<%= cid %>">导出excel</a>
		</div>
		<%

								if (c.IsOver()) {
									%>
									&nbsp;
									<%
								}
								else{%>
		<div class="container">
		<s:form action="/teacher/makehomeworkplan">
		<h3>制定计划</h3>
	     	<input type="hidden" name="courseid" value=<%=cid%>>
	     	<input type="hidden" name="plannumber" value=<%=pnumber+1%>>
			<label>提交日期</label><input type="text" name="datestu" placeholder="yyyy-MM-dd"/><br> <br> 
			<label>批改日期</label><input type="text" name="dateass"placeholder="yyyy-MM-dd"/><br> <br> 
			<label>作业格式</label> <input type="text" name="format"placeholder="rar/doc/pdf"/><br> <br>
			<label>作业分数</label><input type="text" name="score" /><br> <br> 
			<label>作业难度</label> <input type="text" name="difficulty"placeholder="hard/medium/easy"/><br> <br>
			<label>作业内容</label> <textarea rows="3" cols="18" name="content"/></textarea><br> <br>
			<button class="btn btn-lg btn-primary " onClick="check();">确定</button>
		</s:form>
	</div>
	</div>
	<%
	}
	%>
	<div class="col-xs-2"></div>



</body>
</html>