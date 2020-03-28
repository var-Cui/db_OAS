<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/index.css" type="text/css" rel="stylesheet">
<title>五组OA自动化办公系统</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	margin-top: 0px;
}
.STYLE1 {
	color: #333666;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<form name="form1" method="post" action="noticeServlet?action=addType">

<div class="diary5">
  <table width="655" height="24" border="0" cellspacing="0">
    <tr>
      <td width="26" align="center"><img src="image/notify_new.gif" width="16" height="16"></td>
      <td width="435"><span class="STYLE1">新建公告类型</span></td>
      <td width="96" align="center" valign="middle"><span onClick="form1.submit()" style="cursor:hand;"><img src="image/submit.gif" width="70" height="20"></span></td>
      <td width="90" align="center"><span onClick="history.go(-1)" style="cursor:hand;"><img src="image/return1.gif" width="70" height="20"></span></td>
    </tr>
  </table>
</div>
<div class="group">
  <table width="655" border="0" cellpadding="0" cellspacing="1" bgcolor="#0077B2">
    <tr>
      <td width="99" height="25" align="center" bgcolor="#FFFFFF">类型名称：</td>
      <td width="553" bgcolor="#FFFFFF">&nbsp;<input name="type" type="text"></td>
    </tr>
  </table>
</div>


</form>
</body>
</html>