<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.lxitedu.st1610.dao.Impl.*,com.lxitedu.st1610.vo.*,java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	me_staff_Dao_Impl md = new me_staff_Dao_Impl();
	ArrayList<me_staff_VO> mv =(ArrayList<me_staff_VO>) md.all_Query();
	request.setAttribute("mds", mv);	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
        <div class="right">
            <div class="location">
                <strong>你所在的位置是:</strong>
                <span>通讯组详细信息管理：</span>
            </div>
        <form action="me_staff_Servlet">
        <div class="search">
        <input type="hidden" name="action" value="query">
            <input type="text" name="name" placeholder="通讯人员名称" />
            <input type="submit" value="查询"/>
             <input type="button" value="返回" onclick="history.back(-1)"/>
        </div>
        </form>
                <a href="me_staff_add.jsp">添加详细信息</a>
        <table class="providerTable" cellpadding="0" cellspacing="0">
         <form action="#">
            <tr class="firstTr">
                <td>通讯人员ID：</td>
		        <td>通讯人员名称： </td>
		        <td>通讯人员部门：</td>
		        <td>通讯人员信息组：</td>
		        <td>通讯人员家庭地址：</td>
		        <td>通讯人员电话号码：</td>
		        </br>
		        <hr>
            </tr>
             <c:choose>
			<c:when test="${mv != null}">
				 <c:forEach items="${mv}" var="mvs" >
		            <tr>
		                <td>${mvs.me_staff_id }</td>
		                <td>${mvs.me_staff_name }</td>
		                <td>${mvs.me_staff_branch }</td>
		                <td>${mvs.me_staff_message }</td>
		                <td>${mvs.me_staff_address }</td>
		                <td>${mvs.me_staff_phone }</td>
		                <td>
		                    <a href="me_staff_view?id=${mvs.me_staff_id}&&&&name=update"><img src="" alt="修改" title="修改"/></a>
		                    <a href="me_staff_Servlet?action=del&&id=${mvs.me_staff_name}"><img src="" alt="删除" title="删除"/></a>
		                </td>
		            </tr>
		          </c:forEach>
			</c:when>
			<c:otherwise>
				 <c:forEach items="${mds}" var="mvs" >
		            <tr>
		                <td>${mvs.me_staff_id}</td>
		                <td>${mvs.me_staff_name}</td>
		                <td>${mvs.me_staff_branch}</td>
		                <td>${mvs.me_staff_message}</td>
		                <td>${mvs.me_staff_address}</td>
		                <td>${mvs.me_staff_phone}</td>
		                <td>
		                    <a href="me_staff_view?id=${mvs.me_staff_id}&&&&name=update"><img src="" alt="修改" title="修改"/></a>
		                	<a href="me_staff_Servlet?action=del&&id=${mvs.me_staff_name}"><img src="" alt="删除" title="删除"/></a>
		                </td>
		            </tr>
		        </c:forEach>			
			</c:otherwise>
		</c:choose>
            </form >    
        </table>
</body>
</html>