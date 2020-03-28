<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form name="form1" method="post" action="registerServlet" >
<table width="518" border="0" cellspacing="0">
  <tr>
    <td width="30" height="28" align="center" background="image/tablehdbg1.gif"><img src="image/flowpath.gif" width="16" height="16" /></td>
    <td width="484" background="image/tablehdbg1.gif"><span class="STYLE7">详细信息</span></td>
  </tr>
</table>

<table width="517" height="82%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0077B2">
        <tr>
          <td height="22" colspan="2" background="image/beijing.gif" bgcolor="#FFFFFF"><span class="STYLE6">&nbsp;&nbsp;详细信息记录：</span></td>
        </tr>
        <tr>
          <input name="type" type="hidden"   value="register_evection" />
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">员工编码：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_staffNum" type="text"  readonly="readonly" value=${registerVo.register_staffNum}  style="border:0px;"></td>
        </tr>
        <tr>
         <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">名字：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_name" type="text"  readonly="readonly" value=${registerVo.register_name}  style="border:0px;"></td>
        </tr>
  		
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">所属部门：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_branch" type="text" readonly="readonly" value=${registerVo.register_branch} style="border:0px;"></td>
        </tr>
		
        <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">类型：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
          <input name="register_type" type="text" readonly="readonly" value=${registerVo.register_type}  style="border:0px;"></td>
		 <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">原因：</td>
          <td height="25" align="left" valign="middle"  bgcolor="#FFFFFF"> <textarea name="register_reason"  readonly="readonly" > ${registerVo.register_reason} </textarea>
            &nbsp;</td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">开始时间:</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_startTime" type="text" readonly="readonly"  value=${registerVo.register_startTime}  style="border:0px;"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">结束时间:</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_endTime" type="text" readonly="readonly" value=${registerVo.register_endTime} style="border:0px;"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">审核人:</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_assentor" type="text" readonly="readonly"  style="border:0px;" value=${registerVo.register_assentor} ></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">审核状态:</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_result" type="text" readonly="readonly" value=${registerVo.register_result} style="border:0px;"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">审核留言:</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_note" type="text" readonly="readonly" style="border:0px;" value=${registerVo.register_note}></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">审核时间:</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_releaseTime" type="text" readonly="readonly" style="border:0px;" value=${registerVo.register_releaseTime} ></td>
        </tr> 
		 </td>
        </tr>    
        <tr>
      
        
        </tr>
        <tr>
          <td height="30" colspan="2" align="right" valign="middle" bgcolor="#FFFFFF"><span onclick="history.go(-1)" style="cursor:hand;"><img src="image/return1.gif" width="70" height="20" /></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        </tr>
  </table>
</form>
</body>
</html>