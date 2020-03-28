<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>登录界面</title>
<link href="css/bootstrap.min.css" title="" rel="stylesheet" />
<link title="orange" href="css/login.css" rel="stylesheet" type="text/css"/>
</head>
<script language="javascript">
function checkForm(form){
	if (form.user_name.value==""){
		alert("请输入账号!");form.user_name.focus();return false;
	}
	if (form.password.value==""){
		alert("请输入密码!");form.password.focus();return false;
	}
	if(form.validateCodeImage.value==""){
		alert("请输入验证码!");form.validateCodeImage.focus();return false;
	}	
}
</script>
<body onLoad="clockon(bgclock)">
<div style="height:1px;"></div>
<div class="login">
 <header>
    <h1>欢迎登陆</h1>
 </header>
 <div class="sr">
    <form name="form1" method="post" action="staffServlet?action=doLogin">
	    <div class="name">
			<label>
			<i class="sublist-icon glyphicon glyphicon-user"></i>
			</label>
			<input type="text" name="user_name" id ="user_name" placeholder="这里输入登录账号" class="name_inp">
		</div>
		 <div class="name">
			<label>
			<i class="sublist-icon glyphicon glyphicon-pencil"></i>
			</label>
			<input type="password" name="password" id="password" placeholder="这里输入登录密码" class="name_inp">
		</div>
		<div class="name">
			<label>
			<i class="sublist-icon glyphicon glyphicon-pencil"></i>
			</label>
			<input type="text" name="validateCodeImage" placeholder="这里输入验证码" class="name_inp">
		</div>
		<tr>
       <td  height="30" align="right" bgcolor="#FFFFFF"></td>
       <td height="30" bgcolor="#FFFFFF">&nbsp;<img id="validateCodeImage" width="100" height="30" alt="验证码" 
						src="Num.jsp"  onclick="refreshValidateCode();"/></td>
		
      </tr>
		
         <input class="dl" type="submit" name="Submit" value="立即登录" onClick="return checkForm(form1)">
        
	</form>
 </div>
</div>
</body>
</html>