<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top界面</title>
<STYLE type=text/css> 
*{
	FONT-SIZE: 12px; COLOR: white
}
#logo {
	COLOR: white
}
#logo A {
	COLOR: white
}
FORM {
	MARGIN: 0px
}
</STYLE>
<SCRIPT src="Top.files/Clock.js" type=text/javascript></SCRIPT>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</head>
<%@include file="doLogin.jsp"  %>
<body style="BACKGROUND-IMAGE: url(admin_img/bg.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x">
<form id="form1">
  <!-- <DIV id=logo 
style="BACKGROUND-IMAGE: url(admin_img/logo.gif); BACKGROUND-REPEAT: no-repeat"> -->
    <DIV 
style="PADDING-RIGHT: 40px; BACKGROUND-POSITION: right 50%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(admin_img/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 20px; TEXT-ALIGN: right"><A 
href="#"><IMG src="Top.files/mail.gif" 
align=absMiddle border=0></A> 您有新消息<A id=HyperLink1 
href="#">5</A>条 <IMG 
src="Top.files/menu_seprator.gif" align=absMiddle>  </DIV>
    <DIV style="DISPLAY: block; HEIGHT: 54px">
    	<div style= "font-size:30px;color:#DFEFF7;" >微企无纸化办公平台</div>
   	</DIV>
    <DIV 
style="BACKGROUND-IMAGE: url(admin_img/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px">
      <TABLE cellSpacing=0 cellPadding=0 width="100%">
        <TBODY>
          <TR>
            <TD>
              <DIV><IMG src="Top.files/nav_pre.gif" align=absMiddle> 欢迎 <SPAN 
      id=lblBra>理想IT</SPAN> <SPAN id=lblDep>${sessionScope.staffVo.staff_branch}</SPAN> [<a href="staffServlet?action=queryPersonInfo&user_id=${sessionScope.staffVo.staff_id}"  target=mainFrame>${sessionScope.staffVo.staff_name}</a>] 光临 </DIV>
            </TD>
            <TD align=right width="70%"><SPAN style="PADDING-RIGHT: 50px"><A 
      href="javascript:history.go(-1);"><IMG src="Top.files/nav_back.gif" 
      align=absMiddle border=0>后退</A> <A href="javascript:history.go(1);"><IMG 
      src="Top.files/nav_forward.gif" align=absMiddle border=0>前进</A> <A 
      href="login.jsp" target=_top><IMG 
      src="Top.files/nav_changePassword.gif" align=absMiddle border=0>重新登录</A> <A href="password.jsp" 
      target=_top><IMG src="Top.files/nav_resetPassword.gif" 
      align=absMiddle border=0>修改密码</A> <A 
      href="http://localhost:1479/Web/sys/Top.aspx#" target=mainFrame><IMG 
      src="Top.files/nav_help.gif" align=absMiddle border=0>帮助</A> <IMG 
      src="Top.files/menu_seprator.gif" align=absMiddle> <SPAN 
      id=clock></SPAN></SPAN></TD>
          </TR>
        </TBODY>
      </TABLE>
    </DIV>
  </DIV>
  <SCRIPT type=text/javascript>
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
</SCRIPT>
</form>
</body>
</html>