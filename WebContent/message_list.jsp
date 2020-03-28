<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="com.lxitedu.st1610.dao.*,com.lxitedu.st1610.dao.Impl.*,com.lxitedu.st1610.vo.*,com.lxitedu.st1610.service.*" %>
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
                <strong>你所在的位置是:</strong>
                <span>通讯组管理：</span>
            </div>
            <form action="message_Servlet">
            <div class="search">
            <input type="hidden" name="action" value="query">
               <span>组名：</span>
                <input type="text" name="message_name"  placeholder="请输入组名"  />
                <input type="submit" value="查询" />
                <a href="message_add.jsp">添加组</a>
            <a href="me_staff_list.jsp" >查看详细信息</a>
            </div>
            </form>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
               <form action="#">
               	 <tr class="firstTr">
                    <th width="20%">通讯组编号：&nbsp;&nbsp;&nbsp;</th>
                    <th width="20%">通讯组名称：</th>
                </tr>
			 <c:forEach items="${list.reseltList}" var="us"  >
                <tr>
                    <td>${us.message_id}</td>
                    <td>${us.message_name}</td>
                    <td>
	                  <a href="message_Servlet?action=del&&id=${us.message_id}" class="removeUser"  ><img src="" alt="删除" title="删除"/></a>
	                  <a href="message_view?name=update&&id=${us.message_id}" class="removeUser"  ><img src="" alt="修改" title="修改"/></a>
                    </td>
                </tr>
                </c:forEach>		
               </form> 
           </table>
        </div>
    </section>
<%Page_VO pa = (Page_VO)request.getAttribute("list");
if(pa!=null){          	             
if(pa.getCurrentPage()> 0){
%>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="message_Query?pageIndex=1">首页：&nbsp;</a></td>
  <td><a href="message_Query?pageIndex=<%=pa.getCurrentPage()-1%>">上一页&nbsp;</a></td>
<%
} if(pa.getCurrentPage() < pa.getToatlPages()){//控制页面显示风格
%> <td><a href="message_Query?pageIndex=<%=pa.getCurrentPage()+1%>">下一页&nbsp;</a></td>
   <td><a href="message_Query?pageIndex=<%=pa.getToatlPages()%>">末页</a></td>
   </tr>
<%   
} 
}%>
</table>
</form>

</body>
</html>
</body>
</html>