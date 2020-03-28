<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>五组OA自动化办公系统</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	margin-left: 0px;
	margin-top: 0px;
}
a:link {
	color: #0000CC;
	text-decoration: none;
}
a:visited {
	color: #0000CC;
	text-decoration: none;
}
a:hover {
	color: #FF0099;
	text-decoration: underline;
}
.STYLE1 {color: #FFFFFF}
a:active {
	text-decoration: none;
}
.STYLE2 {	color: #005FCF;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<div class="quanxian">您的位置：<a href="index.jsp" target="_parent" class="STYLE1">后台管理&gt; </a> 会议管理&gt; &gt; &gt; </div>

<div class="quanxian3">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="23" align="right"><a href="meeting_add.jsp"><img src="admin_img/roomgif.gif" width="71" height="19" style="border:0px;"/></a>&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>

     <table width="100%" height="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#0077B2">
           <tr>
             <td height="23" align="left" background="image/beijing.gif" class="STYLE1">&nbsp;会议名称</td>
             <td width="22%" align="center" background="image/beijing.gif"><span class="STYLE1">会议时间</span></td>
             
             <td colspan="2" align="center" background="image/beijing.gif">&nbsp;</td>
           </tr>
          
           <tr>
             <td height="25" align="left" bgcolor="#FFFFFF">&nbsp;<%=992013093%></td>
             <td height="11" align="center" bgcolor="#FFFFFF">&nbsp;<%=992013093%></td>
             <td width="7%" align="center" bgcolor="#FFFFFF"><a href="meetingServlet?action=delete&amp;meet_id=<%=992013093%>&amp;page=<%=992013093%>">删除</a></td>
             <td width="9%" align="center" bgcolor="#FFFFFF"><a href="meeting_edit.jsp?meet_id=<%=992013093%>">编辑</a></td>
           </tr>
		
           <tr>
             <td height="28" colspan="4" align="center" background="image/tablehdbg1.gif" bgcolor="#FFFFFF">

  <input type="button" value="GO" class="class6" onclick="javascript:location.href='meeting_list.asp?page='+Num.value;">
  </td>
           </tr>
  </table>
	 </div>

</body>
</html>
