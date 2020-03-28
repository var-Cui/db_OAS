<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>通讯组详细信息管理： >> 信息查看</span>
        </div>
        <div class="me_staff_view">
            <p><strong>通讯人员ID：</strong><span>${view.me_staff_id}</span></p>
            <p><strong>通讯人员名称：</strong><span>${view.me_staff_name}</span></p>
            <p><strong>通讯人员部门：</strong><span>${view.me_staff_branch}</span></p>
            <p><strong>通讯人员信息组：</strong><span>${view.me_staff_message}</span></p>
            <p><strong>通讯人员家庭地址：</strong><span>${view.me_staff_address}</span></p>
            <p><strong>通讯人员电话号码：</strong><span>${view.me_staff_phone}</span></p>

            <a href="me_staff_list.jsp">返回</a>
        </div>
    </div>
</body>
</html>