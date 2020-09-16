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
				supname:"required",
				suptel:{
					required:true,
					rangelength:[10,12]
				}
			},
			
			messages:{
				rules:{
					id:{
						required:"必填",
						digits:"必须是数字",
					},
					supname:"必填",
					suptel:{
						required:"必填",
						rangelength:"请输入11位数的电话号码"
					}
				}	
		});		
	});
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="addSupplier" onsubmit="return checkit();">
		<div class="content">
		<font color="red"></font>
<input name="flag" value="doAdd" type="hidden">
			<table class="box">

			<tbody>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input name="supname" id="textfield" value="" class="text" type="text"> <font color="red">*</font></td>

				</tr>
			<tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="supnotice" id="textarea" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">供应商负责人：</td>
					<td><input name="name" id="textfield1" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name="suptel" id="textfield2" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="supaddress" id="textfield4" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商邮箱：</td>
					<td><input name="email" id="textfield3" value="" class="text" type="text"></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" id="button1" value="提交" class="input-button" type="submit">
			<input name="button" id="button" onclick="window.location='providerAdmin.jsp';" value="返回" class="input-button" type="button"> 
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