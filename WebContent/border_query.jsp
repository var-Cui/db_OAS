<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五组OA自动化办公系统</title>
</head>
<body>
<table width="100%" height="25" border="0" cellspacing="0">
  <tr>
    <td align="center" background="image/beijing.gif"><span class="STYLE4">公告详情</span></td>
  </tr>
</table>

<table width="100%" height="128" border="0" cellspacing="1" cellpadding="0" bgcolor="#0077B2">
        <tr>
          <td width="21%" height="30" align="center" bgcolor="#FFFFFF">公告标题：</td>
          <td width="79%" align="left" bgcolor="#FFFFFF">&nbsp;
		  <input name="border_theme" value= "${noticeVo.notice_name}" readonly="readonly" type="text" size="70" maxlength="50"></td>
        </tr>
         <tr>
          <td width="21%" height="30" align="center" bgcolor="#FFFFFF">公告类别：</td>
          <c:forEach items="${typeList }" var="t">
	       		<c:if test = "${noticeVo.notice_type == t.id}">
          		<td width="79%" align="left" bgcolor="#FFFFFF">&nbsp;
         		 <input name="border_theme" value= "${t.type}" readonly="readonly" type="text" size="70" maxlength="50">
         		 </td>
         		 </c:if>
       	  </c:forEach>
        </tr>
        <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">发布人：</td>
          <td height="31" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
		  <input name="notice_promulgator" readonly="readonly" type="text" value="${noticeVo.notice_promulgator}"></td>
        </tr>
		
        <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">发布时间：</td>
          <td height="15" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
		  <input name="notice_releaseTime" readonly="readonly" id="issue_date" type="text" value="${noticeVo.notice_releaseTime}" ></td>
        </tr>
        <tr>
          <td height="50" align="center" valign="middle" bgcolor="#FFFFFF">公告内容：</td>
          <td height="40" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
		  <input name="notice_content" readonly="readonly" type="text" value="${noticeVo.notice_content}" style=" width : 492px; height : 30px;"></td>
		 
        </tr>
        <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">公告审核者：</td>
          <td height="15" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
		  <input name="issue_people" readonly="readonly" type="text" value="${noticeVo.notice_assentor}" ></td>
        </tr>
        <tr>
        <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">审核状况：</td>
          <td height="15" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
		  <input name="issue_state" readonly="readonly" type="text" value="${noticeVo.notice_result}" ></td>
        </tr>
        <tr>
       <%--  <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">审核时间：</td>
          <td height="15" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
		  <input name="issue_time"  readonly="readonly" type="text" value="<%=992013093%>" ></td>
        </tr> --%>
        <tr>
         <tr>
          <td height="30" colspan="2" align="right" valign="middle" bgcolor="#FFFFFF"><span onclick="history.go(-1)" style="cursor:hand;"><img src="image/return1.gif" width="70" height="20" /></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        </tr>
        
        
    </table>
  <div style="width:700px; margin-left:25px;">
   <input name="border_content" type="hidden" value="">
  
  <table width="550" border="0" align="center" cellspacing="0">
    <tr>
      <td align="center"><label>
        
      </label></td>
    </tr>
  </table>
  </div>
</body>
</html>