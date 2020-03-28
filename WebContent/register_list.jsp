 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style1.css" rel="stylesheet">
<title>五组OA自动化办公系统</title>
</head>
<%@include file="doLogin.jsp"  %>
<body>

<table width="778"  border="0" cellspacing="0" cellpadding="0" align="left">
<form name="form1" method="post" action="registerTwoServlet" >
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：考勤管理 &gt; 考勤记录管理 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
  	
    <td width="87%">&nbsp;<input type="hidden" name="select" value="punch"/>
    	请选择查询类型:<select name="type" class="wenbenkuang" id="type">
    	  <option value="个人" selected>个人</option>
    	   <c:if test="${sessionScope.staffVo.staff_position ne '普通员工'}">
    	   <option value="全部">全部</option>
          <option value="员工编号">员工编号</option>
          <option value="员工名称">员工名字</option>
          <option value="部门名称">部门名称</option>
          </c:if>
        </select>
       	   请输入:<input type="text" name="punchType"/> <input  type="submit" />
    </td>
	<td width="13%"></td>
      
  </tr>
</table>  
  <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#0000CD">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="15%" bgcolor="#F9D16B">请假人员编号</td>  
    <td width="9%" bgcolor="#F9D16B">姓名</td>
    <td width="10%" bgcolor="#F9D16B">登记类型</td>
    <td width="10%" bgcolor="#F9D16B">状态</td>
    <td width="12%" bgcolor="#F9D16B">登记时间</td> 
  </tr>
   

<c:forEach items="${punchVoList}" var="punchList"  >
  <tr>
    <td style="padding:5px;">${punchList.punch_staffId}</td>  
    <td style="padding:5px;">${punchList.punch_staffName}</td> 
    <td style="padding:5px;">${punchList.punch_type}</td>
    <td style="padding:5px;">${punchList.punch_result}</td>
    <td style="padding:5px;"><fmt:formatDate value="${punchList.punch_time}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>  
  </tr>
</c:forEach>
</table>
</form>

</body>

</html>