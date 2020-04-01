<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
	color: #333666;
	text-decoration: none;
}
a:visited {
	color: #333666;
	text-decoration: none;
}
a:hover {
	color: #FF0099;
	text-decoration: underline;
}
a:active {
	text-decoration: none;
}
.STYLE3 {color: #FFFFFF; font-weight: bold; }
.STYLE5 {
	color: #333666;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<form name="form1" method="post" action="">
<div class="quanxian">
  <table width="652" height="23" border="0" cellspacing="0">
    <tr>
      <td width="25" height="25" background="image/tablehdbg1.gif">&nbsp;</td>
      <td width="27" align="center" bgcolor="#9BC9EA"><img src="image/flowpath.gif" width="16" height="16" /></td>
      <td width="79" bgcolor="#9BC9EA"><span class="STYLE5"><a href="noticeServlet?action=addNotice">添加新公告</a></span></td>
      <td width="141" background="image/tablehdbg1.gif">&nbsp;</td>
      <td width="22" align="center" background="image/tablehdbg1.gif"><img src="image/presence.gif" width="16" height="16" /></td>
      <td width="176" background="image/tablehdbg1.gif" class="STYLE5"><a href="noticeServlet?action=queryType">公告类别管理</a></td>
      <td width="119" align="center" bgcolor="#9BC9EA" class="STYLE5"><a href="group_add.jsp">公告类别添加</a></td>
      <td width="47" background="image/tablehdbg1.gif" class="STYLE5">&nbsp;</td>
    </tr>
  </table>
</div>
   <div class="quanxian3">
   <table width="650" border="0" cellspacing="0">
  <tr>
    <td width="33" height="28" align="right" background="image/tablehdbg1.gif">&nbsp;&nbsp;<img src="image/notify_open.gif" width="16" height="16"></td>
    <td width="63" background="image/tablehdbg1.gif">公告类型：</td>
    <td width="153" background="image/tablehdbg1.gif">
	
      <select name="border_type" onChange="javascript:location.href='noticeServlet?action=querySelect&amp;type='+this.options[this.selectedIndex].value">
	  <option value="--请选择--" selected="selected">--请选择--</option>
	  		<option value="0">所有类型</option>
	  		<c:forEach items="${typeList }" var="t">
        		<option value="${t.id}">${t.type}</option>
        	</c:forEach>
      </select>
	    </td>
    <td width="273" background="image/tablehdbg1.gif">&nbsp;</td>
    <!-- <td width="118" background="image/tablehdbg1.gif"><span onClick="history.go(-1)" style="cursor:hand;"><img src="image/return1.gif" width="70" height="20"></span></td> -->
  </tr>
</table>

     <table width="100%" height="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#0077B2">
          
           <tr>
             <td height="23" align="center" background="image/beijing.gif" class="STYLE1">&nbsp;公告标题</td>
             <td height="23" align="center" background="image/beijing.gif" class="STYLE1">&nbsp;公告类别</td>
             <td width="22%" align="center" background="image/beijing.gif"><span class="STYLE1">发布时间</span></td>
             <td height="23" align="center" background="image/beijing.gif" class="STYLE1">&nbsp;发布人</td>
             <td height="23" align="center" background="image/beijing.gif" class="STYLE1">&nbsp;附件</td>
             <td colspan="2" align="center" background="image/beijing.gif">&nbsp;操作</td>
           </tr>
          <c:forEach items="${list }" var="a">
           <tr>
             <td height="25" align="center" bgcolor="#FFFFFF"><a href="noticeServlet?action=queryNotice&amp;id=${a.notice_id }">${a.notice_name }&nbsp;</a></td>
             <td height="25" align="center" bgcolor="#FFFFFF"><a href="noticeServlet?action=queryNotice&amp;id=${a.notice_id }">${a.type }&nbsp;</a></td>
             <td height="25" align="center" bgcolor="#FFFFFF"><a href="noticeServlet?action=queryNotice&amp;id=${a.notice_id }">${a.notice_releaseTime }&nbsp;</a></td> 
             <td height="11" align="center" bgcolor="#FFFFFF"><a href="noticeServlet?action=queryNotice&amp;id=${a.notice_id }">${a.notice_promulgator }</a></td>
             <td height="11" align="center" bgcolor="#FFFFFF">&nbsp; 
             <c:if test="${a.file_name != '' }">
	             <a href="DownServlet?id=${a.notice_id }">下载</a>
             </c:if>
             </td>
             <td width="7%" align="center" bgcolor="#FFFFFF"><a href="noticeServlet?action=delete&amp;id=${a.notice_id }">删除</a></td>
             <td width="9%" align="center" bgcolor="#FFFFFF"><a href="noticeServlet?action=updateNotice&amp;id=${a.notice_id }">编辑</a></td>
           </tr>
		</c:forEach>
  </table>
  </div>
  </form>
</body>
</html>