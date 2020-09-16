<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$(function(){
		$("#form1").validate({
			rules:{
				id:{
					required:true,
					digits:true,
				},
				money:{
					required:true,
					digits:true,
				},
				paymoney:"required"
			},
			
			messages:{
				id:{
					required:"必填",
					digits:"必须是数字",
				},
				money:{
					required:"必填",
					digits:"必须是数字",
				},
				paymoney:"必填"				
			}					
		});		
	});
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post" action="InsertServlet">
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="name" class="text" /></td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td><input type="text" name="number" class="text" /></td>
				</tr>
				<tr>
					<td class="field">交易金额：</td>
					<td><input type="text" name="money" class="text" /></td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>
					<td><textarea name="notice"></textarea></td>
				</tr>
				<tr>
					<td class="field">商家名称：</td>
					<td><input type="text" name="supname" class="text" /></td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="paymoney">
						<option value="是">是</option>
						<option value="否">否</option>
					</select></td>
				</tr>
				<tr>
					<td class="field">添加时间：</td>
					<td><input type="text" name="time" class="text" /></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
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