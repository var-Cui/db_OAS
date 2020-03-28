<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>微企无纸化办公平台</title>
</head>
<%
	//服务器对象实现保存访问次数
		List<String> ips = application.getAttribute("ips") == null ? new ArrayList<String>()
				: (ArrayList<String>) application.getAttribute("ips");

		int count = application.getAttribute("count") == null ? 0 : (Integer) application.getAttribute("count");
		System.out.println(count);
		if (!ips.contains(request.getRemoteAddr())) {

			ips.add(request.getRemoteAddr());
			application.setAttribute("count", ++count);
			System.out.println(request.getRemoteAddr());
			//获取文件的真实路径（绝对路径）
			System.out.println(application.getRealPath("login.jsp"));

		}
		application.setAttribute("ips", ips);
	%>
	<%="当前访问人数：" + count+"<br>"%>
	<%
		for (String str : ips) {
			out.print(str+"<br>");
		}
	%>
<body>
<%@include file="doLogin.jsp"  %>
<div class="right">
  <table width="200" border="0" align="center" cellspacing="0" style="margin-top:10px;">
    <tr>
      <td><img src="admin_img/info.gif" width="450" height="32" /></td>
    </tr>
  </table>
  
  <table width="552" height="279" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;">
    <tr>
      <td height="39" colspan="3" valign="top"><img src="admin_img/errorpage3.gif" width="534" height="42" /></td>
    </tr>
    <tr>
      <td width="39" height="235" rowspan="2" valign="top" id="sss">&nbsp;</td>
      <td width="483" height="226" valign="top"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" valign="middle" bgcolor="#F7F7F7" class="STYLE2">微企无纸化办公平台</td>
        </tr>
        <tr>
          <td align="center" valign="middle" bgcolor="#F7F7F7" class="STYLE2">版权所有：彩色的黑</td>
        </tr>
        <tr>
          <td align="center" valign="middle" bgcolor="#F7F7F7" class="STYLE2">服务器器IP：192.168.19.179</td>
        </tr>
        <tr>
          <td align="center" valign="middle" bgcolor="#F7F7F7" class="STYLE2">本地IP：-- -- -- --
    
		 </td>
        </tr>
        <tr>
          <td align="center" valign="middle" bgcolor="#F7F7F7" class="STYLE2">制作：彩色的黑</td>
        </tr>
        <tr>
          <td align="center" valign="middle" bgcolor="#F7F7F7"><span class="STYLE2">版本：V1.0</span></td>
        </tr>
      </table></td>
      <td width="30" rowspan="2" valign="top" id="aaa"><img src="admin_img/errorpage4.gif" width="12" height="237" /></td>
    </tr>
    <tr>
      <td height="2" valign="top" id="legal"><img src="admin_img/errorpage2.gif" width="483" height="11" /></td>
    </tr>
</table>
</div>
</body>
</html>