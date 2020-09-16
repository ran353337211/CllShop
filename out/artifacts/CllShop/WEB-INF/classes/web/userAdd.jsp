<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$(function(){
		$("#form1").validate({
			
			ignore:"hidden:not(select)",
			rules:{//规则
				name:"required",
				pwd:{
					required:true,
					digits:true,
				},
				pwd1:{
					equalTo:"#pwd"
				},
				sex:"required",
				age:{
					required:true,
					min:1,
					max:120,
				},
				tel:{
					required:true,
					digits:true,
					rangelength:[10,12]
				}
			},
			messages:{
				name:"用户名不能为空",
				pwd:{
					required:"密码不能为空",
					digits:"密码必须是数字",
				},
				pwd1:{
					equalTo:"密码不一致",
				},
				sex:"必填",
				age:{
					required:"年龄不能为空",
					min:"年龄不能小于1岁",
					max:"年龄不能超过150岁",
				},
				tel:{
					required:"手机号不能为空",
					digits:"必须是数字",
					rangelength:"请数11位的手机号"
				}
			}

		});
		
	});

</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="form1" method="post" action="UserServlet1">
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="name" class="text" id="textfield" /></td>
				</tr>
				<tr>
					<td class="field">用户密码：</td>
					<td><input type="password" name="pwd" class="text" id="pwd" /></td>
				</tr>
				<tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="pwd1" id="pwd1" class="text"/></td>
				</tr>

				<tr>
					<td class="field">用户性别：</td>
					<td>
						<select name="sex" id="select">
   					 		<option value="女">女</option>
   							<option value="男">男</option>
 						</select>
 					</td>
				</tr>

				<tr>
					<td class="field">用户年龄：</td>
					<td><label><input type="text" name="age" class="text" id="textfield1"/></label></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="tel" class="text" id="textfield2"/></td>
				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><textarea name="address" id="textarea" class="text" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>
					<td><input type="radio" name="role" id="auth1" value="普通用户" checked="checked"/>普通用户
					<input type="radio" name="role" id="auth" value="经理" />经理</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button1" value="数据提交" onclick="checkpwd()" class="input-button"/>
			  <input type="button" name="button" id="button" onclick="window.location='userAdmin.jsp';" value="返回" class="input-button"/> 
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