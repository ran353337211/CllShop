<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	window.location = "provider.do?id="+id+"&flag="+flag;
}
</script>
</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="post" action="merchantsSelect">
<input name="flag" value="search" type="hidden">
供应商名称：<input name="providerName" class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;
供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
        <input value="组 合 查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.jsp'" type="button"></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>

	<div class="content">
<table class="list">
  <tbody>
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
    <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
    <td width="100"><div class="STYLE1" align="center">联系人</div></td>
    <td width="100"><div class="STYLE1" align="center">电话</div></td>
    <td width="100"><div class="STYLE1" align="center">地址</div></td>
    <td width="100"><div class="STYLE1" align="center">邮箱</div></td>
  </tr>
   <c:forEach items="${suppliers}" var="supplier" varStatus="in">
			<tr>
               <td width="70" height="29"><div class="STYLE1" align="center">${supplier.id }</div></td>
               <td width="80"><div class="STYLE1" align="center">${supplier.supname }</div></td>
               <td width="100"><div class="STYLE1" align="center">${supplier.supnotice }</div></td>
               <td width="100"><div class="STYLE1" align="center">${supplier.name }</div></td>
               <td width="100"><div class="STYLE1" align="center">${supplier.suptel }</div></td>
               <td width="100"><div class="STYLE1" align="center">${supplier.supaddress }</div></td>
               <td width="100"><div class="STYLE1" align="center">${supplier.supemail }</div></td>
            </tr>
			</c:forEach>
</tbody></table>
	</div>
</div>
</body>
</html>