<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style1.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<%@include file="doLogin.jsp"  %>
<body>
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="left">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：个人计划 &gt; 个人计划管理 &gt; 计划评论详情 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
<form method="post" action="planServlet?action=planCommentQuery">
	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <c:forEach items="${planList }" var="v">
      <tr>
        <td height="30" align="center">评&nbsp;论&nbsp;者：<input name="barcode" type="text" id="barcode" value="${v.comment_staff_name}" readonly="readonly"></td>
        <td height="30" align="center">所属职位：<input name="paperNO" type="text" id="paperNO" value="${v.comment_staff_position }" readonly="yes"></td>
      </tr>
      <tr>
      <td height="30" align="left" valign="top">评论内容：</td>
      <td height="30"><textarea name="remark" cols="60" rows="2	" class="wenbenkuang" id="remark" value="${v.comment_text}" readonly="yes">${v.comment_text}</textarea></td>
      </tr>
      </c:forEach>
      <tr>
      <td></td>
        <td align="center">
		<input name="Submit2" type="button" class="btn_grey" value="返回" onClick="history.back()"></td>
      </tr>
    </table>
    </form>
	</td>
  </tr>
</table></td>
      </tr>
    </table>
</td>
  </tr>
      		<td align="center" colspan="7">
    	 	<%--
    	 	需求： 
    	 		1） 如果当前页是首页，那么不能点击“首页”和“上一页”，否则可以点击
    	 		2) 如果当前页是末页，那么不能点击“下一页”和“末页”，否则可以点击
    	 	 --%>
    	 	 <c:choose>
    	 	 	<c:when test="${VO.currPageNo==1}">
    	 	 		首页&nbsp;
    	 	 		上一页
    	 	 	</c:when>
    	 	 	<c:otherwise>
    	 	 		<a href="./planServlet?action=${skip}&currPageNo=${1}&plan_id=${plan_id}">首页</a> &nbsp;
    	 			<a href="./planServlet?action=${skip}&currPageNo=${VO.currPageNo-1 }&plan_id=${plan_id}">上一页</a> &nbsp;
    	 	 	</c:otherwise>
    	 	 </c:choose>
    	 	 
    	 	 <c:choose>
    	 	 	<c:when test="${VO.currPageNo==VO.totalPageCount}">
    	 	 		下一页&nbsp;
    	 	 		末页
    	 	 	</c:when>
    	 	 	<c:otherwise>
    	 	 		<a href="./planServlet?action=${skip}&currPageNo=${VO.currPageNo+1 }&plan_id=${plan_id}">下一页</a>&nbsp;
    	 			<a href="./planServlet?action=${skip}&currPageNo=${VO.totalPageCount}&plan_id=${plan_id}">末页</a>&nbsp;
    	 	 	</c:otherwise>
    	 	 </c:choose>
    	 		当前为第${VO.currPageNo}页/共${VO.totalPageCount}页&nbsp;
    	 		共${VO.totalCount}条数据&nbsp;
    	 		每页显示 <input type="text" size="2" id="pageSize" value="${VO.pageSize}" onblur="changePageSize()"/> 条&nbsp;
    	 		请输入跳转的页面<form action="./planServlet?action=${skip}&plan_id=${plan_id}" name="from" method="post">
                 <input type="text" size="6" name="currPageNo" width="2px" />  
                  <input type="submit" onclick="check(form)"  value="提交"/>
                  <input type="hidden" value="${VO.totalPageCount }" name="all" />
                 </form>		
    	 	</td>
</table>
</body>
</html>