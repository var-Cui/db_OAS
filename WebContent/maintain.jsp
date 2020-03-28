<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style1.css" rel="stylesheet">
<title>网站维护</title>
</head>

<%@include file="doLogin.jsp"  %>
<body>
<c:choose>
<c:when test="${sessionScope.staffVo.staff_position eq '董事长' or sessionScope.staffVo.staff_position eq '总经理'}">
<form name="form1" method="post" action="">




<table width="778"  border="0" cellspacing="0" cellpadding="0" align="left">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="680" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：系统设置 &gt; 网站维护 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="87%">&nbsp;      </td>
<td width="13%">
      <a href="maintainServlet?action=model">添加菜单</a></td>	  
  </tr>
</table>  
  <table width="95%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="left" bgcolor="#e3F4F7">
  	<td width="15%" bgcolor="#F9D16B">模块</td>
    <td width="15%" bgcolor="#F9D16B">菜单</td>  
    <td width="40%" bgcolor="#F9D16B">URL</td>
    <td width="20%" bgcolor="#F9D16B">发布时间</td>
    <td width="5%" bgcolor="#F9D16B">修改</td>
    <td width="5%" bgcolor="#F9D16B">删除</td>
  </tr>
  <c:forEach items="${list }" var="result"> <!-- 标签  -->
 		<tr>
 		
 		  <c:forEach items="${lists }" var="obj">
 		    <c:if test="${obj.maintain_model  eq  result.maintain_model }">
		    <td style="padding:5px;">${obj.maintain_name }</td>
		    </c:if>
		    
		    </c:forEach>
		    
		    <td style="padding:5px;">${result.maintain_menu }</td>
		    <td style="padding:5px;">${result.maintain_url }</td>
		    <td style="padding:5px;">${result.maintain_time }</td>
		    <td align="center"><a href="maintainServlet?action=modelUpdate&maintain_id=${result.maintain_id}" >修改</a></td>
		    <td align="center"><a href="maintainServlet?action=delete&maintain_id=${result.maintain_id}">删除</a></td>
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
</c:when>
	<c:otherwise>
	<script>alert('你没有权限进行此操作！');location='javascript:history.go(-1);';</script>
	</c:otherwise>
</c:choose>
</body>

<%@ include file="copyright.jsp"%>
</html>