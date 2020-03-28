// JavaScript Document
function check_user()
{
 var user_name=form1.user_name.value;
 if(user_name=="")
 {
  megbox.innerText=("请输入用户名!");
 }
  else 
  megbox.innerText=("");
     window.open ('check_user.asp?user_name='+form1.user_name.value,'newwindow','height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
function check_password()
{
 if(form1.password.value<4 || form1.password.value>20)
  megbox.innertext=("密码格式不符！")
}
function check_business()
{
 if(form1.business.value=="")
  megbox.innertext=("请输入职务！")
}
function check_branch()
{
  if(form1.user_branch.value=="")
  megbox.innertext=("请输入所属部门！")
}