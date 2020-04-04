<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五组OA自动化办公系统</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	margin-left: 10px;
	margin-top: 10px;
}
.STYLE6 {
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE7 {
	color: #333666;
	font-weight: bold;
}
-->
</style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<script language="javascript">
$(function(){
		
		$("#staff_enterTime").click(function(){
        WdatePicker({
            highLineWeekDay:true //周末高亮
            ,readOnly:true      //只读，只可用控件input中 修改内容
            ,dateFmt:'yyyy-MM-dd'
        });
		});
		
		$("#staff_birthdate").click(function(){
	        WdatePicker({
	            highLineWeekDay:true //周末高亮
	            ,readOnly:true      //只读，只可用控件input中 修改内容
	            ,dateFmt:'yyyy-MM-dd'
	        });
			});

});
function checkForm(form){
	for(i=0;i<form.length;i++){
		if(form.elements[i].value==""){
			alert("请将信息填写完整!");
			form.elements[i].focus();
			return false;
		}
	}
}
</script>
<%@include file="doLogin.jsp"  %>
<body onLoad="clockon(bgclock)">
<form name="form1" method="post" action="staffServlet?action=add" >
<table width="518" border="0" cellspacing="0">
  <tr>
    <td width="30" height="28" align="center" background="image/tablehdbg1.gif"><img src="image/flowpath.gif" width="16" height="16" /></td>
    <td width="484" background="image/tablehdbg1.gif"><span class="STYLE7">员工管理&gt;</span>员工添加&gt;&gt;&gt;</td>
  </tr>
</table>

<table width="517" height="82%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0077B2">
        <tr>
          <td height="22" colspan="2" background="image/beijing.gif" bgcolor="#FFFFFF"><span class="STYLE6">&nbsp;&nbsp;用户添加</span></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">编号</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
           <%long bracode=Math.round(Math.random()*1000); %>
            &nbsp;<input name="staff_num" type="text"  value="<%=bracode%>"  style="border:0px;" readonly="yes"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">名字</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input name="staff_name" type="text"  value=""  style="border:0px;"></td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">性别</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
          <select name="staff_sex">
		  
		     <option value="男">男</option>
			
			 <option value="女" selected="selected">女</option>
		  </select>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">出生日期</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input id="staff_birthdate" name="staff_birthdate" type="text"  value=""  style="border:0px;"></td>
        </tr>
		<c:choose>
			<c:when test="${sessionScope.staffVo.staff_position eq '总经理' or sessionScope.staffVo.staff_position eq '董事长'}">
				 <tr>
			          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">所属部门：</td>
			          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
					<select name="staff_branch">
					  <c:forEach items="${list}" var="a">
					     <option value=${a.branch_name }>${a.branch_name}</option>
					 </c:forEach>
					  </select>
					
				 <tr>
			</c:when>
			<c:otherwise>
				<tr>
			          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">所属部门：</td>
			          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
					  <input id="staff_branch" name="staff_branch" type="text"  value="${sessionScope.staffVo.staff_branch}"  style="border:0px;" readonly="yes"></td>
					  
				 <tr>
			</c:otherwise>
		</c:choose>
       
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">职位</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;
        	<select name="staff_position">
		     <option value="普通员工" selected="selected">普通员工</option>
			 <option value="部门主管">部门主管</option>
			 <option value="人事">人事</option>
		  </select>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">入职时间</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
            &nbsp;<input id="staff_enterTime" name="staff_enterTime" type="text"  value=""  style="border:0px;"></td>
        </tr>
		 
		 </td>
        </tr>
        <tr>
          <td height="25" align="center" valign="middle" bgcolor="#FFFFFF">密码：</td>
          <td height="25" align="left" valign="middle" bgcolor="#FFFFFF">
          &nbsp;<input name="staff_pwd" type="password" style="border:0px;text-align:left" value=""></td>
        </tr>
       
        <tr>
          <td height="25" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF"><label>
            <input type="submit" name="Submit" value="提交"  onClick="return checkForm(form1)"/>
          </label></td>
        </tr>
        <tr>
          <td height="30" colspan="2" align="right" valign="middle" bgcolor="#FFFFFF"><span onclick="history.go(-1)" style="cursor:hand;"><img src="image/return1.gif" width="70" height="20" /></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        </tr>
  </table>
</form>
</body>
</html>