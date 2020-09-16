<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
	<form method="post" action="findAllCheckByTag">
		商品名称：<input type="text" name="name" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="paymoney">
			<option value="">请选择</option>
			<option value="是">已付款</option>
			<option value="否">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.jsp'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>账单时间</td>
			</tr>
			<c:forEach items="${list}" var="check" varStatus="in">
			<tr>
				<td>${check.id}</td>
				<td>${check.name}</td>
				<td>${check.number}</td>
				<td>${check.money}</td>
				<td>${check.paymoney}</td>
				<td>${check.supname}</td>
				<td>${check.notice}</td>
				<td>${check.date}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>