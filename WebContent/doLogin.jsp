<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	

<c:if test="${sessionScope.staffVo.staff_name eq null}">
 <% response.sendRedirect("login.jsp"); %>
</c:if>