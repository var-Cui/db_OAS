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
            <span>通讯组详细信息管理： >> 详细信息修改页</span>
        </div>
        <div class="providerAdd">
            <form action="me_staff_Servlet">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                <input type="hidden" name="action" value="update">
                    <label for="me_staff_id">通讯人员ID：</label>
                    <input type="text" name="me_staff_id" id="me_staff_id"  value=${view.me_staff_id} ></input>
                </div>
                <div>
                    <label for="me_staff_name">通讯人员名称：</label>
                    <input type="text" name="me_staff_name" id="me_staff_name" value=${view.me_staff_name} ></input>
                </div>
                <div>
                    <label for="me_staff_branch">通讯人员部门：</label>
                    <input type="text" name="me_staff_branch" id="me_staff_branch" value=${view.me_staff_branch} ></input>

                </div>
                <div>
                    <label for="me_staff_message">	通讯人员信息组：</label>
                    <input type="text" name="me_staff_message" id="me_staff_message" value=${view.me_staff_message} ></input>
                </div>
                <div>
                    <label for="me_staff_address">通讯人员家庭地址：</label>
                    <input type="text" name="me_staff_address" id="me_staff_address" value=${view.me_staff_address} ></input>
                </div>
                <div>
                    <label for="me_staff_phone">通讯人员电话号码：</label>
                    <input type="text" name="me_staff_phone" id="me_staff_phone" value=${view.me_staff_phone} ></input>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.jsp">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>
    </div>
</body>
</html>