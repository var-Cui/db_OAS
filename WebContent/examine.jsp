<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<LINK href="YHChannelApply.files/Style.css" type=text/css rel=stylesheet><LINK href="YHChannelApply.files/Manage.css" type=text/css rel=stylesheet>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@include file="doLogin.jsp"  %>
<body>

<SCRIPT type=text/javascript>
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</SCRIPT>
<c:choose>
<c:when test="${sessionScope.staffVo.staff_position ne '普通员工'}">
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15><IMG src="YHChannelApply.files/new_019.jpg" border=0></TD>
    <TD width="100%" background=YHChannelApply.files/new_020.jpg height=20></TD>
    <TD width=15><IMG src="YHChannelApply.files/new_021.jpg" 
  border=0></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15 background=YHChannelApply.files/new_022.jpg><IMG 
      src="YHChannelApply.files/new_022.jpg" border=0> </TD>
    <TD vAlign=top width="100%" bgColor=#ffffff>
      <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
        <TR>
          <TD class=manageHead>当前位置：管理首页 &gt; 管理中心 &gt; 审核管理操作</TD></TR>
        <TR>
          <TD height=2></TD></TR></TABLE>
      <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" 
      align=center border=0>
        <TBODY>
        <TR>
          <TD height=25>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
 				<FORM action="examineServlet?action=examineQuery" method=post>
              <TR>
                <TD>筛选数据：</TD>
                <TD>
                	<input type="radio" name="examineType" value="1">会议
                    <input type="radio" name="examineType" value="2">公告
                    <input type="radio" name="examineType" value="3">请假
                    <input type="radio" name="examineType" value="4">出差
                    <input type="radio" name="examineType" value="5">外出
                    <input type="radio" name="examineType" value="6" checked>企业
                    <input type="radio" name="examineType" value="7">部门
                </TD>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>          
                <TD><INPUT type="submit" value="筛选 " name="saixuan"></TD></TR></TBODY></TABLE>
                </TD>
                </TR>
                </FORM>
        <TR>
          <TD>
            <TABLE id=grid 
            style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" 
            cellSpacing=1 cellPadding=2 rules=all border=0>
              <TBODY>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <TD>申请者</TD>
                <TD>所属部门</TD>
                <TD>申请类型</TD>
                <TD>申请标题</TD>
                <TD>申请时间</TD>
                <TD>详细</TD>
                <TD>领导建议</TD>
                <TD>同意</TD>
                <TD>拒绝</TD>               
                </TR>
                <FORM action="examineServlet?action=planExamineRe" method=post>                
                <c:if test="${(pd eq '6') or (pd eq '7')}">
                <c:forEach items="${planList }" var="v">
                <input type="hidden" name="plan_id" value="${v.plan_id}">
              <TR style="FONT-WEIGHT: normal; FONT-ST  YLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                <TD>${v.plan_promulgator }</TD>
                <TD>${v.plan_branch }</TD>
                <TD>${v.plan_type}</TD>
                <TD>${v.plan_name }</TD>
                <TD>${v.plan_foundTime }</TD>
                <TD><A href="planServlet?action=planQuery&plan_id=${v.plan_id}">查看</A> </TD>
                <TD><INPUT class="text" name="note" size="20" value=""></TD>
                <TD>
	                <INPUT type="submit" value="同意" name="planT">
	            </TD>
	            <TD>
	                <INPUT type="submit" value="拒绝" name="planT"> 
	            </TD>	            	            
                  </TR>
                  </c:forEach>
                  </c:if>
                  </FORM>
               <form action="examineServlet?action=registerExamineRe" method=post>                                 
                 <c:if test="${(pd eq '3') or (pd eq '5') or (pd eq '4') }">
               <c:forEach items="${registerList }" var="q">
               <input type="hidden" name="register_id" value="${q.register_id }">
             	<TR style="FONT-WEIGHT: normal; FONT-ST  YLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                <TD>${q.register_name }</TD>
                <TD>${q.register_branch }</TD>
                <TD>${q.register_type}</TD>
                <TD>${q.register_type }</TD>
                <TD>${q.register_startTime }</TD>
                <TD><A href="registerParticularServlet?particularId=${q.register_id}">查看</A> </TD>
                <TD><INPUT name="note" size="20" value=""></TD>
                <TD>
	                <INPUT type="submit" value="同意" name="registerT">
	            </TD>
	            <TD>
	                <INPUT type="submit" value="拒绝 " name="registerT"> 
	            </TD>	            
                  </TR>
                  </c:forEach>
                  </c:if>
                  </form>	
                 </TBODY></TABLE></TD></TR>               
        <TR>
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
    	 	 		<a href="examineServlet?action=${skip}&currPageNo=${1}&examineType=${pd}">首页</a> &nbsp;
    	 			<a href="examineServlet?action=${skip}&currPageNo=${VO.currPageNo-1 }&examineType=${pd}">上一页</a> &nbsp;
    	 	 	</c:otherwise>
    	 	 </c:choose>
    	 	 
    	 	 <c:choose>
    	 	 	<c:when test="${VO.currPageNo==VO.totalPageCount}">
    	 	 		下一页&nbsp;
    	 	 		末页
    	 	 	</c:when>
    	 	 	<c:otherwise>
    	 	 		<a href="examineServlet?action=${skip}&currPageNo=${VO.currPageNo+1 }&examineType=${pd}">下一页</a>&nbsp;
    	 			<a href="examineServlet?action=${skip}&currPageNo=${VO.totalPageCount}&examineType=${pd}">末页</a>&nbsp;
    	 	 	</c:otherwise>
    	 	 </c:choose>
    	 		当前为第${VO.currPageNo}页/共${VO.totalPageCount}页&nbsp;
    	 		共${VO.totalCount}条数据&nbsp;
    	 		每页显示 <input type="text" size="2" id="pageSize" value="${VO.pageSize}" onblur="changePageSize()"/> 条&nbsp;
    	 		请输入跳转的页面<form action="examineServlet?action=${skip}&examineType=${pd}" name="from" method="post">
                 <input type="text" size="6" name="currPageNo" width="2px" />  
                  <input type="submit" onclick="check(form)"  value="提交"/>
                  <input type="hidden" value="${VO.totalPageCount }" name="all" />
                 </form>		
    	 	</td>
            </TR>
            </TBODY></TABLE></TD>
    <TD width=15 background=YHChannelApply.files/new_023.jpg><IMG 
      src="YHChannelApply.files/new_023.jpg" border=0> </TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15><IMG src="YHChannelApply.files/new_024.jpg" border=0></TD>
    <TD align=middle width="100%" background=YHChannelApply.files/new_025.jpg 
    height=15></TD>
    <TD width=15><IMG src="YHChannelApply.files/new_026.jpg" 
  border=0></TD></TR>
  </TBODY>
  </TABLE>
</c:when>
	<c:otherwise>
	<script>alert('你没有权限进行此操作！');location='javascript:history.go(-1);';</script>
	</c:otherwise>
</c:choose>
</body>
</html>