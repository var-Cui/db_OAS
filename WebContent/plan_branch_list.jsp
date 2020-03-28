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
        <td height="22" valign="top" class="word_orange">当前位置：计划制定 &gt; 部门计划管理 &gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="15%" align="center"><a href="planServlet?action=planBranchlist" style="COLOR: #ff0000;">查看全部计划</a> </td>
    <td width="10%"><a href="planServlet?action=planBranchVerifyQuery" style="COLOR: #ff0000;">待审核</a> </td>
	<td width="10%"><a href="planServlet?action=planBranchPassQuery" style="COLOR: #ff0000;">已通过</a></td>
	<td width="10%"><a href="planServlet?action=planBranchRefuseQuery" style="COLOR: #ff0000;">未通过</a></td>
	<td width="35%"></td>
	
	<c:if test="${sessionScope.staffVo.staff_position eq c }">
	<td width="20%" align="center"><a href="plan_branch_add.jsp">添加部门计划</a></td>
	</c:if>	  
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
    
    <td width="8%" bgcolor="#afdeda">查看类容</td>
   <c:if test="${sessionScope.staffVo.staff_position eq  c }">
    <td width="10%" bgcolor="#afdeda">删除</td>
    </c:if>
  </tr>
  <c:forEach items="${planList}" var="v">
 	<tr>
    <td style="padding:5px;">${v.plan_id }</td>  
    <td style="padding:5px;">${v.plan_name }</td>
    <td align="center">${v.plan_result }</td>
    <td style="padding:5px;">${v.plan_promulgator }</td>
    <td align="center">${v.plan_branch }</td>
    <td align="center">${v.plan_foundTime }</td>     
    <td align="center"><a href="planServlet?action=planQuery&plan_id=${v.plan_id }">查看内容 </a></td>   
    <td align="center">
    <a href="planServlet?action=planDel&plan_id=${v.plan_id}&check=bra">
    <c:if test="${sessionScope.staffVo.staff_position eq  c }">删除</c:if>
    </a></td>
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