<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五组OA自动化办公系统</title>
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
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
<script language="javascript">
$(function() {
	$("#meet_date").click(function() {
		WdatePicker({
			highLineWeekDay : true //周末高亮
			,
			readOnly : true //只读，只可用控件input中 修改内容
			,
			dateFmt : 'yyyy-MM-dd HH-mm-ss'
		});
	});
});
</script>
<body>
<form name="form1" method="post" action="MeetingServlet?action=add" style="margin-top:25px;">
<div class="dingwei">
  <table width="550" height="134" border="0" align="center" cellspacing="0">
    <tr>
      <td width="515" height="35" align="center"><span class="STYLE2">添加会议</span></td>
    </tr>
    <tr>
      <td height="99" align="center" bgcolor="#4A7AC9"><table width="100%" height="82%" border="0" cellspacing="1">
        <tr>
          <td width="87" height="31" align="center" bgcolor="#FFFFFF">会议标题：</td>
          <td colspan="3" align="left" bgcolor="#FFFFFF">&nbsp;
          <input name="meet_theme" type="text" id="new_title" style="width: 95%;border:0px;" value="">
          </td>
        </tr>
        <tr>
          <td height="31" align="center" valign="middle" bgcolor="#FFFFFF">会议时间：</td>
          <td width="195" height="31" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;
		  <input name="meet_date" type="text" id="meet_date" style="border:0px;" value="" />
		  </td>
          <td width="81" height="31" align="center" valign="middle" bgcolor="#FFFFFF">是否公开：</td>
          <td width="172" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;
		  <label>
		  是
		  <input type="radio" name="is_open" value="是"  checked="checked" >
		  &nbsp;
		  否
		  <input type="radio" name="is_open" value="否" >
		  </label></td>
        </tr>
        <tr>
          <td width="87" height="30" align="center" valign="middle" bgcolor="#FFFFFF">参加人员：</td>
          <td height="30" colspan="3" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;
		  <input name="join_people" type="text" style="border:0px;" size="60" value=""></td>
          </tr>
        <tr>
          <td height="29" align="center" valign="middle" bgcolor="#FFFFFF">所属部门：</td>
          <td height="29" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;
		  <select style="width:70%;" name="branch_id">
		  	<c:forEach items="${branchList }" var="b">
				<option value="${b.branch_id}">${b.branch_name}</option>
			</c:forEach>
          </select> 
          </td>
          <td height="29" align="center" valign="middle" bgcolor="#FFFFFF">开会地点：</td>
          <td height="29" align="left" valign="middle" bgcolor="#FFFFFF">
		  &nbsp;
		  <input name="meetingroom_name" type="text" style="border:0px;" value="" />
          </td>
        </tr>
      </table>
      </td>
    </tr>
    <tr>
    <td align="center"><input type="submit" name="Submit" value="提交" /></td>
    </tr>
  </table>
  </div>
</form>
</body>
</html>