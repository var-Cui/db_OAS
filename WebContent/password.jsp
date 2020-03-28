<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="index.css" type="text/css" rel="stylesheet">
<title>密码修改</title>
<style type="text/css">

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

</style>
</head>
<script language="javascript">
function checkForm(form){
	if(form.oldpwd.value==""){
		alert("请输入原密码!");form.oldpwd.focus();return false;
	}
	if(form.oldpwd.value!=form.holdpwd.value){
		alert("您输入的原密码不正确，请重新输入!");form.oldpwd.value="";
		form.oldpwd.focus();return false;
	}
	if(form.newpwd.value==""){
		alert("请输入新密码!");form.newpwd.focus();return false;
	}	
	if(form.repwd.value==""){
		alert("请确认新密码!");form.repwd.focus();return false;
	}	
	if(form.newpwd.value!=form.repwd.value){
		alert("您两次输入的新密码不一致，请重新输入!");
		form.newpwd.value="";form.repwd.value="";
		form.newpwd.focus();return false;
	}
}
</script>
<%@include file="doLogin.jsp"  %>
<body onLoad="clockon(bgclock)">
<form name="form1" method="post" action="staffServlet?action=updatePwd">
<div class="quanxian">
  <table width="100%" height="100%" border="0" cellspacing="0">
    <tr>
      <td width="15%" align="right"></td>
      <td width="6%" align="right" bgcolor="#9BC9EA"><img src="image/menu/@personsetting.gif" width="16" height="16"></td>
      <td width="15%" bgcolor="#9BC9EA">&nbsp;<span class="STYLE1">密码修改</span></td>
      <td width="30%">&nbsp;</td>
      <td width="34%">&nbsp;</td>
    </tr>
  </table>
</div>
<div class="password">
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="6%" height="24" align="right" background="image/tablehdbg1.gif"><img src="image/menu/@personsetting.gif" width="16" height="16"></td>
    <td width="76%" background="image/tablehdbg1.gif">&nbsp;密码修改</td>
    <td width="18%" align="center" background="image/tablehdbg1.gif">
	  <label>
	  <input type="submit" name="Submit" value="保存修改" onClick="return checkForm(form1)">
	  </label></td>
  </tr>
</table> 
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#0077B2">
  <tr>
    <td width="15%" height="30" align="center" bgcolor="#FFFFFF">用户名：</td>
    <td width="85%" bgcolor="#FFFFFF">&nbsp;
	<input name="user_name" type="text" readonly="yes" value=${sessionScope.staffVo.staff_num }></td>
  </tr>
 <%--  <tr>
    <td height="30" align="center" bgcolor="#FFFFFF">姓名：</td>
    <td height="30" align="left" bgcolor="#FFFFFF">&nbsp;
	<input name="true_name" type="text" readonly value="<%=992013093%>"></td>
  </tr> --%>
  <tr>
    <td height="30" align="center" bgcolor="#FFFFFF">原密码:</td>
    <td height="30" align="left" bgcolor="#FFFFFF">&nbsp;
	<input name="oldpwd" type="password"></td>
	<input name="holdpwd" type="hidden" id="holdpwd" value=${sessionScope.staffVo.staff_password }></td>
  </tr>
  <tr>
    <td height="30" align="center" bgcolor="#FFFFFF">新密码：</td>
    <td height="30" align="left" bgcolor="#FFFFFF">&nbsp;
	<input name="newpwd" type="password"></td>
  </tr>
  <tr>
    <td height="30" align="center" bgcolor="#FFFFFF">密码确认：</td>
    <td height="30" align="left" bgcolor="#FFFFFF">&nbsp;
	  <input name="repwd" type="password"></td>
  </tr>
</table>

</div>
</form>
</body>
</html>