<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>微企无纸化办公平台</title>
<style type="text/css">
.todayTitle{
	color:#1976d2;
}
.dataTr{
	display:table-row;
	margin:10px 0;
	background-color: #f5f5f5;
}
.head{
	color:#4DD0E1;
}
.out{
	width: 838px; border-right:1px solid #A39F9F;  border-top:1px solid #A39F9F;  margin-left:2px; height:600px;
}
</style>
</head>
<body>
<%-- <%@include file="doLogin.jsp"  %> --%>
<div class="out">
<div >
 <table width = "100%" height="150" border="0" align="left" cellpadding="0" cellspacing="0" style="margin-top:10px;">
  	<tr><td align="left" class="todayTitle">今日公告</td></tr>
  	<c:if test="${noticeList.size() == 0}">
  	<tr><td colspan="2" align="center">今日无公告</td></tr>
  	</c:if>
  	<c:if test="${noticeList.size() != 0}">
  		<c:forEach items="${noticeList}" var="n" varStatus="ni">
		  	<tr class="dataTr"><td align="left">${ni.count}、${n.notice_name}</td><td align="left">${n.notice_releaseTime}</td></tr>
  		</c:forEach>
  	</c:if>
  	<tr><td colspan="2" align="right"><a style="color:#4DD0E1;" href="noticeServlet?action=query">查看更多>></a></td></tr>
</table>
</div>
<c:if test = "${sessionScope.staffVo.staff_position ne '普通员工' }">
	<div>
	<c:if test="${auditList.size() == 0}">
  	<p class="todayTitle">今日无待处理事项</p>
  	</c:if>
  	<c:if test="${auditList.size() != 0}">
	<p class="todayTitle">今日待处理事项</p>
	 <table width="100%" height="150" border="1" bordercolor="#9e9e9e" align="left" cellpadding="0" cellspacing="0" style="margin-top:10px;">
	  	<thead>
	  		<tr><td align = "center"></td><td class="head" align = "center">申请类型</td><td class="head" align = "center">申请人</td></tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${auditList}" var="n" varStatus="a">
			  	<tr><td align = "center">${a.count}</td><td align = "center">${n.maintain_url}</td><td align = "center">${n.maintain_menu}</td></tr>
	  		</c:forEach>
	  	</tbody>
	</table>
	<div style="text-align :right"><a style="color:#4DD0E1;" href="examineServlet?action=examineQuery&examineType=1">去处理>></a></div>
	</c:if>
	</div>
</c:if>
<div>
	<table width = "100%" height="150" border="0" align="left" cellpadding="0" cellspacing="0" style="margin-top:10px;">
  	<tr><td align="left" class="todayTitle">今日通知</td></tr>
  	<tr class="dataTr"><td align="left">1、12312312321</td><td align="left"><a style="color:#4DD0E1;" href="examineServlet?action=examineQuery&examineType=1">查看>></a></td></tr>
  	<tr class="dataTr"><td align="left">1、12312312321</td><td align="left"><a style="color:#4DD0E1;" href="examineServlet?action=examineQuery&examineType=1">查看>></a></td></tr>
</table>
</div>
</div>
</body>
</html>