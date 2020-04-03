<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五组OA自动化办公系统</title>
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<style type="text/css"> 
</style>
</head>
<script language="javascript">
</script>
<body>
<div>
	<table>
		<tr>
		<td width="63">周期：</td>
	    <td width="160">
		    <select name="border_type" onChange="javascript:location.href='ChartServlet?type='+this.options[this.selectedIndex].value">
		  		<option value="0" <c:if test="${type == 0}">selected="selected"</c:if>>所有</option>
		    	<option value="1" <c:if test="${type == 1}">selected="selected"</c:if>>本周</option>
		    	<option value="2" <c:if test="${type == 2}">selected="selected"</c:if>>本月</option>
		    	<option value="3" <c:if test="${type == 3}">selected="selected"</c:if>>本年</option>
		    </select>
	    </td>
	    </tr>
	</table>
	  <div  style="text-align:center">  
	     <img class="img" src="${chartURL}" >  
	  </div>
</div>
  <div  style="text-align:center">  
     <img class="img" src="${pieURL}" >  
  </div>
</body>
</html>