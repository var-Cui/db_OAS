<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>会议管理</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #E0E6F8;
}
.STYLE2 {
	color: #AA393C;
	font-weight: bold;
	font-size: 24px;
}
.STYLE3{
cursor:hand;
}
a:link {
	text-decoration: none;
	color: #0000CC;
}
a:visited {
	text-decoration: none;
	color: #0000CC;
}
a:hover {
	text-decoration: underline;
	color: #FF0099;
}
a:active {
	text-decoration: none;
}
-->
</style>
</head>
<body>
<form name="form1" method="post" action="" style="margin-top:25px;">
<div class="dingwei">
  <table width="550" height="134" border="0" align="center" cellspacing="0">
    <tr>
      <td width="515" height="35" align="center"><span class="STYLE2">会议咨询管理</span></td>
    </tr>
    <tr>
      <td height="99" align="center" bgcolor="#4A7AC9"><table width="100%" height="82%" border="0" cellspacing="1">
        <tr>
          <td width="87" height="31" align="center" bgcolor="#FFFFFF">会议标题：</td>
          <td colspan="3" align="left" bgcolor="#FFFFFF">&nbsp;<input name="meet_theme" type="text" id="new_title" style="border:0px;"   value="<%=992013093%>"></td>
        </tr>
        <tr>
          <td height="31" align="center" valign="middle" bgcolor="#FFFFFF">会议时间：</td>
          <td width="195" height="31" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;<input name="meet_time" type="text" id="meet_time" style="border:0px;" value="<%=992013093%>" /></td>
          <td width="81" height="31" align="center" valign="middle" bgcolor="#FFFFFF">是否公开：</td>
          <td width="172" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;
		  <label>
		  是
		  <input type="radio" name="yes_no" value="true"  checked="checked" >
		  &nbsp;否
		  <input type="radio" name="yes_no" value="false"  checked="checked" >
		  </label></td>
        </tr>
        <tr>
          <td width="87" height="30" align="center" valign="middle" bgcolor="#FFFFFF">参加人员：</td>
          <td height="30" colspan="3" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;<input name="join_people" type="text" style="border:0px;" size="60" value="<%=992013093%>"></td>
          </tr>
        <tr>
          <td height="29" align="center" valign="middle" bgcolor="#FFFFFF">所属部门：</td>
		  
          <td height="29" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;<select name="branch">
		           
<option value="<%=9920130%>"  selected="selected" ><%=992013093%></option>

		         </select> </td>
          <td height="29" align="center" valign="middle" bgcolor="#FFFFFF">开会地点：</td>
		  
          <td height="29" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;<select name="meetingroom_name">
		      
			    <option value="<%=992013093%>"  selected="selected" ><%=992013093%></option>
			
			   </select>
		           </td>
				  
        </tr>
      </table></td>
    </tr>
  </table>
  </div>
  <div style="width:500px; margin-left:140px; margin-top:5px;">
   <input name="meet_content" type="hidden" value="<%=992013093%>">
  
   <table width="550" border="0" align="center" cellspacing="0">
    <tr>
      <td align="center"><label>
        
      </label></td>
    </tr>
    
  </table>
  
  </div>
  <input type="submit" name="Submit" value="提交" />
</form>
</body>
</html>
