<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>五组OA自动化办公系统</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	margin-left: 0px;
	margin-top: 0px;
}
a:link {
	color: #333666;
	text-decoration: none;
}
a:visited {
	color: #333666;
	text-decoration: none;
}
a:hover {
	color: #FF0099;
	text-decoration: underline;
}
a:active {
	text-decoration: none;
}
.STYLE3 {color: #FFFFFF; font-weight: bold; }
.STYLE5 {
	color: #333666;
	font-weight: bold;
}
.STYLE7 {color: #FFFFFF}
-->
</style>
</head>
<body>
<form name="form1" method="post" action="">
<div class="quanxian">
  <table width="652" height="23" border="0" cellspacing="0">
    <tr>
      <td width="25" height="25" background="image/tablehdbg1.gif">&nbsp;</td>
      <td width="27" align="center" bgcolor="#9BC9EA"><img src="image/flowpath.gif" width="16" height="16" /></td>
      <td width="79" bgcolor="#9BC9EA"><span class="STYLE5"><a href="noticeServlet?action=addNotice">添加新公告</a></span></td>
      <td width="141" background="image/tablehdbg1.gif">&nbsp;</td>
      <td width="22" align="center" background="image/tablehdbg1.gif"><img src="image/presence.gif" width="16" height="16" /></td>
      <td width="176" background="image/tablehdbg1.gif" class="STYLE5">公告类别管理</td>
      <td width="119" align="center" bgcolor="#9BC9EA" class="STYLE5"><a href="group_add.jsp">公告类别添加</a></td>
      <td width="47" background="image/tablehdbg1.gif" class="STYLE5">&nbsp;</td>
    </tr>
  </table>
</div>
   <div class="quanxian3">
     <table width="100%" height="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#0077B2">
           <tr>
             <td width="79%" height="23" background="image/beijing.gif">&nbsp;<span class="STYLE3">公告类别列表</span></td>
             <td  align="center" background="image/beijing.gif"><span class="STYLE3">删除</span></td>
           </tr>
           <c:forEach items="${typeList }" var="t">
           <tr>
             <td height="25" bgcolor="#ffffff">&nbsp;${t.type}</td>
             <td height="25" align="center" bgcolor="#ffffff">
			 <a href="noticeServlet?action=deleteType&amp;id=${t.id}">删除</a> </td>
           </tr>
           </c:forEach>
          <!--  <tr>
             <td height="28" colspan="2" background="image/tablehdbg1.gif">
			 <div style="width:100%; text-align:center; height:17px;">
  			<input type="button" value="GO" class="class6" onClick="javascript:location.href='border_typede.jsp?page='+Num.value;"></div></td></tr> -->
     </table>
  </div>
</form>
</body>
</html>