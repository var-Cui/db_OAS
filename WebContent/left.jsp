<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>菜单表</title>
<style type="text/css">

body,td,th {
	font-size: 12px;
}
body {
	margin-top: 0px;
	margin-left: 0px;
}
.STYLE1 {
	color: #005FCF;
	font-weight: bold;
}
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #000000;
}
a:hover {
	text-decoration: none;
	color: #3366FF;
}
a:active {
	text-decoration: none;
	color: #000000;
}

</style>
</head>
<%@include file="doLogin.jsp"  %>
<body>

<div class="left_kuang">
  <c:forEach items="${lists }" var="result" varStatus="count">
<table width="150" border="0" cellspacing="0" style="border: #000000 1px solid; margin-top:5px;">
  <tr>
    <td height="25" align="center" bgcolor="#DFEFF7"><img src="admin_img/left.gif" width="22" height="23" /></td>
    <td width="112" bgcolor="#DFEFF7" class="STYLE1" style="padding-top:2px;">
    <c:if test= "${result.maintain_name == '今日看板'}"><a target="mainFrame" style="color:#005FCF" href="maintainServlet?action=queryToday">${result.maintain_name }</a></c:if>
    <c:if test= "${result.maintain_name != '今日看板'}">${result.maintain_name }</c:if>
    </td>
  </tr>
</table>
  
 <c:forEach items="${list }" var="obj" varStatus="i">
 
 

  <c:if test="${result.maintain_model eq  obj.maintain_model }">
	<table width="150" border="0" cellspacing="0" style="border:1px solid #000000; margin-top:0px;">


  <tr>
    <td width="15" height="18" bgcolor="#DFEFF7"><img src="admin_img/20070612195621660.gif" width="11" height="11" /></td>
    <c:choose>
    <c:when test="${obj.maintain_menu eq '退出登录'}">
    	<td width="129" height="18" bgcolor="#DFEFF7"><a href="${obj.maintain_url }" target=_top>${obj.maintain_menu }</a></td>
    </c:when>
    <c:otherwise>
    	<td width="129" height="18" bgcolor="#DFEFF7"><a href="${obj.maintain_url }" target="mainFrame">${obj.maintain_menu }</a></td>
    </c:otherwise>
    </c:choose>
    
  </tr>

	</table>
  </c:if>
   </c:forEach>
 </c:forEach>
</div>
</body>
</html>