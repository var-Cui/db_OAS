<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五组OA自动化办公系统</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	margin-left: 10px;
	margin-top: 10px;
}
.STYLE6 {
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE7 {
	color: #333666;
	font-weight: bold;
}
-->
</style>
</head>
<%@include file="doLogin.jsp"  %>
<body>
<form name="form1" method="post" action="" >
<table width="518" border="0" cellspacing="0">
  <tr>
    <td width="30" height="28" align="center" background="image/tablehdbg1.gif">
    <c:choose>
	    <c:when test="${sessionScope.staffVo.staff_sex eq '男'}">
	    	<img src="image/man.png" width="16" height="16" />
	    </c:when>
	    <c:otherwise>
	    	<img src="image/woman.png" width="16" height="16" />
	    </c:otherwise>
    </c:choose></td>
    <td width="484" background="image/tablehdbg1.gif"><span class="STYLE7">个人信息&gt;</span></td>
  </tr>
</table>

<table width="517" height="82%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0077B2">
        <tr>
          <td height="22" colspan="2" background="../image/beijing.gif" bgcolor="#FFFFFF"><span class="STYLE6">&nbsp;&nbsp;</span></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">编码</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="staff_num" type="text"  value="${result.staff_num}"  style="border:0px;" readonly="yes"></td>
        	
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">名字</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="staff_name" type="text"  value="${result.staff_name}"  style="border:0px;" readonly="yes"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">性别</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
          &nbsp;<input name="staff_sex" type="text"  value="${result.staff_sex}"  style="border:0px;" readonly="yes"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">出生日期</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="staff_birthdate" type="text"  value="${result.staff_birthdate}"  style="border:0px;" readonly="yes"></td>
        </tr>
		
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">职位</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="staff_position" type="text"  value="${result.staff_position}"  style="border:0px;" readonly="yes"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">入职时间</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="staff_enterTime" type="text"  value="${result.staff_enterTime}"  style="border:0px;" readonly="yes"></td>
        </tr>
		 
		 </td>
        </tr>     
        <tr>
          <td height="30" colspan="2" align="right" valign="middle" bgcolor="#FFFFFF"><span onclick="history.go(-1)" style="cursor:hand;"><img src="image/return1.gif" width="70" height="20" /></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        </tr>
  </table>
</form>
</form>
</body>
</html>