<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五组OA自动化办公系统</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
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

<script language="javascript">
$(function(){
		
		$("#branch_time").click(function(){
        WdatePicker({
            highLineWeekDay:true //周末高亮
            ,readOnly:true      //只读，只可用控件input中 修改内容
            ,dateFmt:'yyyy-MM-dd'
        });
		});
});

</script>
<%@include file="doLogin.jsp"  %>
<body onLoad="clockon(bgclock)">
<form name="form1" method="post" action="branchServlet?action=update" >
<table width="518" border="0" cellspacing="0">
  <tr>
    <td width="30" height="28" align="center" background="image/tablehdbg1.gif"><img src="image/flowpath.gif" width="16" height="16" /></td>
    <td width="484" background="image/tablehdbg1.gif"><span class="STYLE7">部门管理&gt;</span>部门修改&gt;&gt;&gt;</td>
  </tr>
</table>

<table width="517" height="82%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0077B2">
        <tr>
          <td height="22" colspan="2" background="../image/beijing.gif" bgcolor="#FFFFFF"><span class="STYLE6">&nbsp;&nbsp;用户添加</span></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">部门</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="branch_name" type="text"  value="${result.branch_name }"  style="border:0px;"></td>
        	<input name="branch_id" type="hidden" id="id" value="${result.branch_id}"><!-- 隐藏域带个id -->
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">部长</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="branch_minister" type="text"  value="${result.branch_minister }"  style="border:0px;"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">部门描述</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="branch_summarize" type="text"  value="${result.branch_summarize}"  style="border:0px;height : 57px; width : 351px;"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">创建时间</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input id="branch_time" name="branch_time" type="text"  value="${result.branch_time }"  style="border:0px;"></td>
        </tr>  
        <tr>
          <td height="25" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF"><label>
            <input type="submit" name="Submit" value="提交" onClick="return checkForm(form1)"/>
          </label></td>
        </tr>
        <tr>
          <td height="30" colspan="2" align="right" valign="middle" bgcolor="#FFFFFF"><span onclick="history.go(-1)" style="cursor:hand;"><img src="image/return1.gif" width="70" height="20" /></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        </tr>
  </table>
</form>
</body>
</html>