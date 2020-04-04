<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$("#register_startTime").click(function(){
        WdatePicker({
            highLineWeekDay:true //周末高亮
            ,readOnly:true      //只读，只可用控件input中 修改内容
            ,dateFmt:'yyyy-MM-dd HH:mm:ss'
        });
		});
	
		$("#register_endTime").click(function(){
        WdatePicker({
            highLineWeekDay:true //周末高亮
            ,readOnly:true      //只读，只可用控件input中 修改内容
            ,dateFmt:'yyyy-MM-dd HH:mm:ss'
        });
		});
});
function checkForm(form){
	for(i=0;i<form.length;i++){
		if(form.elements[i].value==""){
			alert("请将信息填写完整!");
			form.elements[i].focus();
			return false;
		}
	}
}
</script>
<%@include file="doLogin.jsp"  %>
<body onLoad="clockon(bgclock)">
<form name="form1" method="post" action="registerServlet" >
<table width="518" border="0" cellspacing="0">
  <tr>
    <td width="30" height="28" align="center" background="image/tablehdbg1.gif"><img src="image/flowpath.gif" width="16" height="16" /></td>
    <td width="484" background="image/tablehdbg1.gif"><span class="STYLE7">请假登记</span></td>
  </tr>
</table>

<table width="517" height="82%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0077B2">
        <tr>
          <td height="22" colspan="2" background="image/beijing.gif" bgcolor="#FFFFFF"><span class="STYLE6">&nbsp;&nbsp;请假记录：</span></td>
        </tr>
        <tr>
        
		<input name="type" type="hidden"   value="register_leave" />
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">员工编码：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_staffNum" type="text"  value=${staffVo.staff_num}  style="border:0px;"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">名字：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_name" type="text"  value=${staffVo.staff_name}  style="border:0px;"></td>
        </tr>
  		
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">所属部门：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="register_branch" type="text"  value=${staffVo.staff_branch} style="border:0px;"></td>
        </tr>
		
        <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">类型：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
          <input name="register_type" type="text" readonly="readonly"  value="<%="请假"%>"  style="border:0px;"></td>
		 <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">原因：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF"> <textarea name="register_reason"></textarea>
            &nbsp;</td>
        </tr>
        
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">请假开始时间:</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input id="register_startTime" name="register_startTime" type="text"  placeholder="<%="2020-02-02 09:00:00"%>"  style="border:0px;"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">请假结束时间:</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input id="register_endTime" name="register_endTime" type="text"  placeholder="<%="2020-02-02 09:00:00"%>"  style="border:0px;"></td>
        </tr>
		 
		 </td>
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