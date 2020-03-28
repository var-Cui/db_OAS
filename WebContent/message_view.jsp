<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
            <span>通讯组管理： >> 信息查看</span>
        </div>
        <div class="message_Servlet">
            <p><strong>通讯ID：</strong><span>${view.message_id}</span></p>
            <p><strong>通讯名称：</strong><span>${view.message_name}</span></p>
            <a href="message_list.jsp">返回</a>
        </div>
    </div>
</body>
</html>