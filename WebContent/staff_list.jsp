<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style1.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
</head>
<script language="javascript">
function check(form){

	if(form.currPageNo.value==""){
		alert("请输入跳转页数!");return;  
	}
	var reg = /^\w{1}/ig;
	if(!reg.test(form.currPageNo.value))
   {     
		alert('请正确输入数字');
		  return ;
   }
 
	form.submit();
}

	function toPage(num){
		var param = "staffServlet?action=sss&currPageNo="+num;
		var key = $("#key").val();
		if((key != "") && (key != null)){
			param += "&f=" + $("#f").val() + "&key=" + key;
		}
		window.location.href=param;
	}
</script>
<%@include file="doLogin.jsp"  %>
<body>
<form name="form1" method="post" action="staffServlet?action=sss">
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="left">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="680" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：员工管理 &gt; 员工信息管理 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="87%">&nbsp;      </td>
<td width="13%">
     <c:if test="${sessionScope.staffVo.staff_position ne '普通员工'}"> <a href="branchServlet?action=staffAdd">添加员工信息</a></td></c:if>
  </tr>
</table>  

 <table width="98%" height="38"  border="0" cellpadding="0" cellspacing="0" bgcolor="#E3F4F7" class="tableBorder_gray">
  <tr>
    <td align="center" bgcolor="#F9D16B">

&nbsp;<img src="image/search1.gif" width="45" height="28"></td>
    <td bgcolor="#F9D16B">请选择查询依据：
      <select name="f" class="wenbenkuang" id="f">
        <option value="num" <c:if test="${yiju == 'num'}">selected=selected</c:if>>编号</option>
        <option value="name" <c:if test="${yiju == 'name'}">selected=selected</c:if>>姓名</option>
        <option value="sex" <c:if test="${yiju == 'sex'}">selected=selected</c:if>>性别</option>
        <option value="branch" <c:if test="${yiju == 'branch'}">selected=selected</c:if>>部门</option>
        <option value="position" <c:if test="${yiju == 'position'}">selected=selected</c:if>>职位</option>
        </select>
      <input name="key" type="text" id="key" size="50" value="${result}">
      <input name="Submit" type="submit" class="btn_grey" value="查询"></td>
  </tr>
</table>
  </form>
  <table width="95%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="left" bgcolor="#e3F4F7">
    <td width="5%" align="center" bgcolor="#F9D16B">编号</td>  
    <td width="10%" align="center" bgcolor="#F9D16B">名字</td>
    <td width="5%"  align="center" bgcolor="#F9D16B">性别</td>
    <td width="20%" align="center" bgcolor="#F9D16B">出生日期</td>
    <td width="15%" align="center" bgcolor="#F9D16B">所属部门</td>
    <td width="12%" align="center" bgcolor="#F9D16B">职位</td>
    <td width="15%" align="center" bgcolor="#F9D16B">入职时间</td>
    <c:if test="${sessionScope.staffVo.staff_position ne '普通员工'}"><td width="5%" align="center" bgcolor="#F9D16B">修改</td></c:if>
    <c:if test="${sessionScope.staffVo.staff_position ne '普通员工'}"><td width="5%" align="center" bgcolor="#F9D16B">删除</td></c:if>
  </tr>
   <c:forEach items="${list}" var="result"> <!-- 标签  -->
 		<tr>
		    <td align="center" style="padding:5px;">${result.staff_num }</td>
		    <td align="center" style="padding:5px;">${result.staff_name }</td>
		    <td align="center" style="padding:5px;">${result.staff_sex}</td>
		    <td align="center" style="padding:5px;">${result.staff_birthdate }</td>
		    <td align="center" style="padding:7px;">${result.staff_branch }</td>
		    <td align="center" style="padding:5px;">${result.staff_position }</td>
		    <td align="center" style="padding:7px;">${result.staff_enterTime }</td>
		<c:if test="${sessionScope.staffVo.staff_position ne '普通员工'}">  <td align="center"><a href="staffServlet?action=queryInfo&user_id=${result.staff_id}">修改</a></td></c:if> 
		<c:if test="${sessionScope.staffVo.staff_position ne '普通员工'}">    <td align="center"><a href="staffServlet?action=delete&staff_id=${result.staff_id}">删除</a></td></c:if>
 		 </tr>
 	</c:forEach>
		 <tr>
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
    	 	 		<a href="javascript:void(0)" onclick="toPage(1)">首页</a>&nbsp;
    	 	 		<a href="javascript:void(0)" onclick="toPage(${VO.currPageNo-1})">上一页</a>&nbsp;
    	 	 	</c:otherwise>
    	 	 </c:choose>
    	 	 <c:choose>
    	 	 	<c:when test="${VO.currPageNo==VO.totalPageCount}">
    	 	 		下一页&nbsp;
    	 	 		末页
    	 	 	</c:when>
    	 	 	<c:otherwise>
    	 	 		<a href="javascript:void(0)" onclick="toPage(${VO.currPageNo+1 })">下一页</a>&nbsp;
    	 	 		<a href="javascript:void(0)" onclick="toPage(${VO.totalPageCount })">末页</a>&nbsp;
    	 	 	</c:otherwise>
    	 	 </c:choose>
    	 		当前为第${VO.currPageNo}页/共${VO.totalPageCount}页&nbsp;
    	 		共${VO.totalCount}条数据&nbsp;
    	 		每页显示5条&nbsp;
    	 	</td>
    	 	</tr>
    	 	<tr>
    	 	<td  align="center" colspan="7">
    	 		 <%-- <input type="text" size="2" id="pageSize" value="${VO.pageSize}" onblur="changePageSize()"/>  --%>
    	 		请输入跳转的页面
    	 		<form action="staffServlet?action=sss" name="from" method="post">
                  <input type="text" size="6" name="currPageNo" width="2px" />  
                  <input type="button" onclick="check(form)"  value="提交"/>
                  <input type="hidden" value="${VO.totalPageCount }" name="all" />
                 </form>		
    	 	</td>
    	 	</tr>
      </table>
          </td>
      </tr>
    </table>
    </td>
  </tr>
</table>

<%@ include file="copyright.jsp"%>

</body>
</html>