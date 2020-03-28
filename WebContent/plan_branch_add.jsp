<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style1.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<script language="javascript">
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
</script>
<%@include file="doLogin.jsp"  %>
<body onLoad="clockon(bgclock)">
<table width="778"  border="0" cellspacing="0" cellpadding="0" align="left">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：部门计划 &gt; 部门计划管理 &gt; 增加部门计划 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
<form name="form1" method="post" action="planServlet?action=planBranchAdd">
	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
      <td></td>
     <td align="right">
		<input name="Submit2" type="button" class="btn_grey" value="退出" onClick="history.back()"></td>     
      </tr>
      <tr>
      <td width="173" height="30" align="left">输入你的标题：</td>
      <td width="427" height="39">
          <input name="plan_name" type="text" > </td>
      </tr>
      <tr>
       <td width="173" height="30" align="left" valign="top">输入你的内容：</td>
      <td><textarea name="plan_content" cols="60" rows="20" class="wenbenkuang" id="remark"></textarea></td>
      </tr>
      <tr>
        <td width="173" height="30" align="left">发&nbsp;布&nbsp;者：</td>
        <td><input name="plan_promulgator" type="text" id="barcode" value="${sessionScope.staffVo.staff_name }" readonly="yes"></td>
      </tr>
      <tr>
        <td width="173" height="30" align="left">所属部门：</td>
        <td><input name="plan_branch" type="text" id="vocation" value="${sessionScope.staffVo.staff_branch }" readonly="yes"></td>
      </tr>
      <tr>
      <td></td>
      <td align="center"><input name="tijiao" type="submit" value="提交审核" onClick="return checkForm(form1)"></td>       
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
</table>
</body>
</html>