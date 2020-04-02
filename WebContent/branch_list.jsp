<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style1.css" rel="stylesheet">
<title>五组OA自动化办公系统</title>
</head>
<%@include file="doLogin.jsp"  %>
<body>
<form name="form1" method="post" action="">
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="left">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="680" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：部门管理 &gt; 部门信息管理 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="87%">&nbsp;      </td>
<td width="13%">
      <a href="staffServlet?action=branchQuery">添加部门信息</a></td>	  
  </tr>
</table>  
  <table width="95%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="15%" bgcolor="#F9D16B">部门</td>  
    <td width="15%" bgcolor="#F9D16B">部长</td>
    <td width="45%" bgcolor="#F9D16B">部门描述</td>
    <td width="15%" bgcolor="#F9D16B">创建时间</td>
    <td width="5%" bgcolor="#F9D16B">修改</td>
    <td width="5%" bgcolor="#F9D16B">删除</td>
  </tr>
  <c:forEach items="${list }" var="result"> <!-- 标签  -->
 		<tr>
		    <td align="center" style="padding:5px;">${result.branch_name }</td>
		    <td align="center" style="padding:5px;">${result.branch_minister }</td>
		    <td align="center" style="padding:5px;">${result.branch_summarize}</td>
		    <td align="center" style="padding:5px;">${result.branch_time }</td>
		    <td align="center"><a href="branchServlet?action=queryName&branch_name=${result.branch_name}">修改</a></td>
		    <td align="center"><a href="branchServlet?action=delete&branch_id=${result.branch_id}">删除</a></td>
 		 </tr>
 </c:forEach>
          </tr>
        </table>
          </td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
<%@ include file="copyright.jsp"%>
</html>