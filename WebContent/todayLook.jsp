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
</style>
</head>
<body>
<%-- <%@include file="doLogin.jsp"  %> --%>
<div class="right">
 <table width="552" height="150" border="0" align="left" cellpadding="0" cellspacing="0" style="margin-top:10px;">
  	<tr><td align="left" class="todayTitle">今日公告</td></tr>
  	<c:if test="${noticeList.size() == 0}">
  	<tr><td colspan="2" align="center">今日无公告</td></tr>
  	</c:if>
  	<c:if test="${noticeList.size() != 0}">
  		<c:forEach items="${noticeList}" var="n" varStatus="ni">
		  	<tr class="dataTr"><td align="left">${ni.count}、${n.notice_name}</td><td align="right">${n.notice_releaseTime}</td></tr>
  		</c:forEach>
  	</c:if>
  	<tr><td colspan="2" align="right"><a style="color:#4DD0E1;" href="noticeServlet?action=query">查看更多</a></td></tr>
</table>
</div>
</body>
</html>