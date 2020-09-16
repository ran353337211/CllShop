<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
}
</script>
</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="post" action="UserServlet">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="name" value="${param.name}" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='userAdd.jsp'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>

    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
    <c:if test="${User.role=='经理'}">
        <td width="150"><div class="STYLE1" align="center">操作 </div></td>
    </c:if>
  </tr>
  </tr>
  <c:forEach items="${userList}" var="user" varStatus="in">
  <tr>
    <td height="23"><span class="STYLE1">${user.id }</span></td>
    <td><span class="STYLE1"><a href="#" onclick="doit('mod',1)">${user.name }</a></span></td>
    <td><span class="STYLE1">${user.sex }</span></td>
    <td><span class="STYLE1">${user.age }</span></td>
    <td><span class="STYLE1">${user.tel }</span></td>
    <td><span class="STYLE1">${user.address }</span></td>
    <td><span class="STYLE1">${user.role }</span></td>
      <c:if test="${User.role=='经理'}">
          <td>
              <a href="UDUserServlet?action=findUserById&id=${user.id }">修改</a>||
              <a href="UDUserServlet?action=deleteById&id=${user.id }">删除</a>
          </td>
      </c:if>
      </tr>
  </c:forEach>
</tbody></table>
  <p align="center">
				<a href="UserServlet?nowPage=1&name=${param.name}">首页</a>
      <a href=""> </a>
		   
		   <c:if test="${nowPage<=1 }">
				<a href="UserServlet?nowPage=1&name=${param.name}">上一页</a>
		   </c:if>
		   
		   <c:if test="${nowPage>1 }">
				<a href="UserServlet?nowPage=${nowPage-1 }&name=${param.name}">上一页</a>
		   </c:if>
		   
		   <c:if test="${nowPage>=pageCount }">
				<a href="UserServlet?&nowPage=${pageCount }&name=${param.name}">下一页</a>
		   </c:if>
		   
		   <c:if test="${nowPage<pageCount }">
				<a href="UserServlet?nowPage=${nowPage+1 }&name=${param.name}">下一页</a>
		   </c:if>
		   <a href="UserServlet?nowPage=${pageCount }&name=${param.name}">尾页</a>
		   
		         当前第${nowPage }页 | 共${total }条记录 | 共${pageCount }页 |
		  
	    </p>
</div>
</div>
<%
    String errorInfo = (String)request.getAttribute("msg");
    if(errorInfo != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=errorInfo%>");
</script>
<%
    }
%>
</body>
</html>