<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style1.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<%@include file="doLogin.jsp"  %>
<body>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="left">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：个人计划 &gt; 个人计划管理 &gt; 计划评论详情 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
        <table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
<form method="post" action="planServlet?action=planCommentQuery">
	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
      <td height="30" align="center">计划标题：</td>
      <td width="427" height="39">
          <input name="name" type="text" value="${plan_name}"> </td>
          <input name="plan_id" type="hidden" value="${planVo.plan_id }">
      </tr>
      <tr>
      <td height="30" align="center" valign="top">计划内容：</td>
      <td><textarea name="remark" cols="60" rows="20" class="wenbenkuang" id="remark" value="${plan_content }">${planVo.plan_content }</textarea></td>
      </tr>
      <tr>
      <td></td>
        <td align="center">
		<input name="Submit2" type="button" class="btn_grey" value="返回" onClick="history.back()"></td>
      </tr>
    </table>
    </form>
	</td>
  </tr>
</table></td>
      </tr>
    </table>
</td>
</table>
</body>
</html>