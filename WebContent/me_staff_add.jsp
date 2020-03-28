<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.*,com.lxitedu.st1610.dao.Impl.*,com.lxitedu.st1610.vo.*,com.lxitedu.st1610.dao.*,com.lxitedu.st1610.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>通讯组管理 >> 通讯信息添加页面</span>
		</div>
		<div class="providerAdd">
			<form  action="me_staff_Servlet">
				<!--div的class 为error是验证错误，ok是验证成功-->
				<div class="">
					<input type="hidden" name="action" value="add"> <label
						for="me_staff_id">通讯人员ID：</label> <input type="text"
						name="me_staff_id" id="me_staff_id" />
				</div>
				<div>
					<input type="hidden" name="action" value="add"> <label
						for="me_staff_name">通讯人员名称：</label> <input type="text"
						name="me_staff_name" id="me_staff_name" />
				</div>
				<div>
					<input type="hidden" name="action" value="add"> <label
						for="me_staff_branch">通讯人员部门：</label> <input type="text"
						name="me_staff_branch" id="me_staff_branch" />
				</div>
				<div>
					<input type="hidden" name="action" value="add"> <label
						for="me_staff_message">通讯人员信息组：</label> <input type="text"
						name="me_staff_message" id="me_staff_message" />
				</div>
            
			</div>
		</div>
		<div>
			<input type="hidden" name="action" value="add"> <label
				for="me_staff_address">通讯人员地址：</label> <input type="text"
				name="me_staff_address" id="me_staff_address" />
		</div>
		<div>
			<input type="hidden" name="action" value="add"> <label
				for="me_staff_phone">通讯人员手机：</label> <input type="text"
				name="me_staff_phone" id="me_staff_phone" />
		</div>
		<div class="providerAddBtn">
			<input type="submit" value="保存" /> <input type="button" value="返回" onclick="history.back(-1)" />
		</div>		
	</div>
	</div>
	</form>
</body>
</html>