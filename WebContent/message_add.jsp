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
            <span>通讯组管理 >> 通讯信息添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="message_Servlet">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="message_id">通讯组ID：</label>
                    <input type="text" name="message_id" id="message_id"/>
                </div>
                <div>
                <input type="hidden" name="action" value="add">
                    <label for="message_name">通讯组名称：</label>
                    <input type="text" name="message_name" id="message_name"/>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</body>
</html>