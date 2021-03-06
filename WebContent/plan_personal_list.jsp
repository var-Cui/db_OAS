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
<table width="978"  border="0" cellspacing="0" cellpadding="0" align="left">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：计划制定 &gt; 个人计划管理 &gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="13%" align="center"><a href="planServlet?action=planPersonalList&amp;status=0" style="COLOR: #ff0000;">查看全部计划</a> </td>
    <td width="10%" align="center"><a href="planServlet?action=planPersonalList&amp;status=1" style="COLOR: #ff0000;">待审核</a> </td>
    <td width="10%" align="center"><a href="planServlet?action=planPersonalList&amp;status=2" style="COLOR: #ff0000;">已通过</a> </td>
    <td width="10%" align="center"><a href="planServlet?action=planPersonalList&amp;status=3" style="COLOR: #ff0000;">未通过</a> </td>
   	<%-- <c:if test="${sessionScope.staffVo.staff_position eq a or sessionScope.staffVo.staff_position eq b}">   
	    <td width="10%"><a href="planServlet?action=planPersonalVerifyQuery" style="COLOR: #ff0000;">部长的个人计划</a> </td>
		<td width="10%"><a href="planServlet?action=planPersonalRefuseQuery" style="COLOR: #ff0000;">员工的个人计划</a></td>
	</c:if> --%>
	<td width="42%"></td>	  
	<td width="20%" align="center"><a href="plan_personal_add.jsp">添加个人计划</a></td>	  
  </tr>
</table>  
  <table width="95%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="5%" bgcolor="#afdeda">ID</td>  
    <td width="19%" bgcolor="#afdeda">标题</td>
    <td width="10%" bgcolor="#afdeda">审核状态</td>
    <td width="11%" bgcolor="#afdeda">申请者</td>
    <td width="10%" bgcolor="#afdeda">部门</td>    
    <td width="27%" bgcolor="#afdeda">创建时间</td>
    <td width="8%" bgcolor="#afdeda">查看内容</td>
     <c:if test="${sessionScope.staffVo.staff_position eq a or sessionScope.staffVo.staff_position eq b}">
    	<c:if test="${skip eq 'planPersonalRefuseQuery'}">
    <td width="10%" bgcolor="#afdeda">评论</td>
    	</c:if>
    </c:if>
    <c:if test="${skip eq 'planPersonalList'}">
    <td width="10%" bgcolor="#afdeda">删除</td>
    </c:if>
  </tr>
  <c:forEach items="${planList}" var="v">
 	<tr>
    <td style="padding:5px;" align="center">${v.plan_id }</td>  
    <td style="padding:5px;" align="center">${v.plan_name }</td>
    <td align="center">${v.plan_result }</td>
    <td style="padding:5px;" align="center">${v.plan_promulgator }</td>
    <td align="center">${v.plan_branch }</td>
    <td align="center">${v.plan_foundTime }</td>  
    <td align="center"><a href="planServlet?action=planQuery&plan_id=${v.plan_id }">查看内容</a></td>
    <td align="center">    	
	    <c:if test="${sessionScope.staffVo.staff_position eq a or sessionScope.staffVo.staff_position eq b}">   
		    <c:if test="${skip eq 'planPersonalRefuseQuery'}">
		    <a href="planServlet?action=planComment&plan_id=${v.plan_id }">评论</a>
		    </c:if>
	    </c:if>
	     <c:if test="${skip eq 'planPersonalList'}">
	    <a href="planServlet?action=planDel&plan_id=${v.plan_id}&check=per">删除</a>
	    </c:if>
    </td>
  </tr>
</c:forEach>
  
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
    	 	 		<a href="planServlet?action=${skip}&currPageNo=${1}">首页</a> &nbsp;
    	 			<a href="planServlet?action=${skip}&currPageNo=${VO.currPageNo-1 }">上一页</a> &nbsp;
    	 	 	</c:otherwise>
    	 	 </c:choose>
    	 	 
    	 	 <c:choose>
    	 	 	<c:when test="${VO.currPageNo==VO.totalPageCount}">
    	 	 		下一页&nbsp;
    	 	 		末页
    	 	 	</c:when>
    	 	 	<c:otherwise>
    	 	 		<a href="planServlet?action=${skip}&currPageNo=${VO.currPageNo+1 }">下一页</a>&nbsp;
    	 			<a href="planServlet?action=${skip}&currPageNo=${VO.totalPageCount}">末页</a>&nbsp;
    	 	 	</c:otherwise>
    	 	 </c:choose>
    	 		当前为第${VO.currPageNo}页/共${VO.totalPageCount}页&nbsp;
    	 		共${VO.totalCount}条数据&nbsp;
    	 		每页显示 <input type="text" size="2" id="pageSize" value="${VO.pageSize}" onblur="changePageSize()"/> 条&nbsp;
    	 		请输入跳转的页面<form action="planServlet?action=${skip}" name="from" method="post">
                 <input type="text" size="6" name="currPageNo" width="2px" />  
                  <input type="submit" onclick="check(form)"  value="提交"/>
                  <input type="hidden" value="${VO.totalPageCount }" name="all" />
                 </form>		
    	 	</td>
</table>
</body>
</html>