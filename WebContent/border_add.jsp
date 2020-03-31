<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五组OA自动化办公系统</title>
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
<!--
body, td, th {
	font-size: 12px;
}

body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #E0E6F8;
}

.STYLE4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 18px;
}
-->
</style>
</head>
<script language="javascript">
	$(function() {

		$("#issue_date").click(function() {
			WdatePicker({
				highLineWeekDay : true //周末高亮
				,
				readOnly : true //只读，只可用控件input中 修改内容
				,
				dateFmt : 'yyyy-MM-dd'
			});
		});

	});
	function checkForm(form) {
		for (i = 0; i < form.length; i++) {
			if (form.elements[i].value == "") {
				alert("请将信息填写完整!");
				form.elements[i].focus();
				return false;
			}
		}
	}

	function submitForm() {
		console.log($("#file1"));
		$("#form1").submit();
	}

	function file() {
		$("#form2").submit();
	}
</script>
<body>
	<form name="form1" method="post" id="form1" action="noticeServlet?action=add" style="margin-top: 25px;">
		<div class="dingwei">
			<table width="100%" height="25" border="0" cellspacing="0">
				<tr>
					<td align="center" background="image/beijing.gif"><span class="STYLE4">添加公告</span></td>
				</tr>
			</table>

			<table width="100%" height="128" border="0" cellspacing="1" cellpadding="0" bgcolor="#0077B2">
				<tr>
					<td width="21%" height="30" align="center" bgcolor="#FFFFFF">公告标题：</td>
					<td width="79%" align="left" bgcolor="#FFFFFF">&nbsp; 
					<input name="notice_name" type="text" size="70" maxlength="50">
					</td>
				</tr>
				<tr>
					<td width="21%" height="30" align="center" bgcolor="#FFFFFF">公告类别：</td>
					<td width="79%" align="left" bgcolor="#FFFFFF">&nbsp;
					<select style="width: 29%;" name="notice_type">
							<c:forEach items="${typeList }" var="t">
								<option value="${t.id}">${t.type}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td height="30" align="center" valign="middle" bgcolor="#FFFFFF">发布人：</td>
					<td height="31" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
						<input name="notice_promulgator" type="text" value="${sessionScope.staffVo.staff_name}">
					</td>
				</tr>

				<tr>
					<td height="30" align="center" valign="middle" bgcolor="#FFFFFF">发布时间：</td>
					<td height="15" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
						<input id="issue_date" name="notice_releaseTime" type="text" value="">
					</td>
				</tr>
				<tr>
					<td height="50" align="center" valign="middle" bgcolor="#FFFFFF">公告内容：</td>
					<td height="40" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
						<input name="notice_content" type="text" value="" style="width: 492px; height: 30px;">
					</td>
					<input id="fileName" type="hidden" name="fileName" />
				</tr>
				</form>
				<tr>
				<form action="uploadServlet" id="form2" method="post" enctype="multipart/form-data">
					<td height="50" align="center" valign="middle" bgcolor="#FFFFFF">附件：</td>
					<td height="40" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp;
						<input type="file" name="attachment1" id="file1" /> 
						<input type="button" onclick="file()"   value="上传" />
					</td>
				</form>				
				</tr>
				<tr>
					<td height="25" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF">
					<label> 
						<input type="button" onclick="submitForm()" value="提交" />
					</label>
					</td>
				</tr>
				<tr>
					<td height="30" colspan="2" align="right" valign="middle"
						bgcolor="#FFFFFF"><span onclick="history.go(-1)"
						style="cursor: hand;"><img src="image/return1.gif"
							width="70" height="20" /></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
		</div>
</body>
</html>