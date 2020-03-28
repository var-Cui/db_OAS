<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微企无纸化办公平台</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
}
body,td,th {
	font-size: 12px;
}
#legal{
background-image:url(admin_img/errorpage2.gif);
background-repeat:no-repeat;
}
#sss{
background-image:url(admin_img/errorpage.gif);
background-repeat:no-repeat;
}
#aaa{
background-image:url(admin_img/errorpage4.gif);
background-repeat:no-repeat;
}
.STYLE2 {color: #40BDE8}
-->
</style>
</head>

<frameset rows="102,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset rows="*" cols="180,*" framespacing="0" frameborder="no" border="0">
    <frame src="maintainServlet?action=sss" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="right.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes>
<body>
<%@include file="doLogin.jsp"  %>
</body>
<%@ include file="copyright.jsp"%>

</html>