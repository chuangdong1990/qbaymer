<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl -->
<%@include file="common/tag.jsp" %>
<%@include file="common/head.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>商户后台管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<link href="${basePath}resources/css/common.css" rel="stylesheet">
		<style type="text/css">
			html{
				background-color: rgb(102,164,166);
				background-image: url('${basePath}/resources/img/login_bg.jpg');
				background-repeat:no-repeat;
				background-position: center 0;
				-webkit-background-size: cover;
			}
		</style>
	</head>
	<body>
		<div class="login-layout">
			<div class="login-layout-form">
				<div class="login-title">51帮学后台登录</div>
				<div class="login-form-bg">
					<img src="${basePath}/resources/img/login_form.png">
				</div>
				<div class="login-form-ip">
					<form id="formdata">
					<table>
						<tr>
							<td>用户名：</td>
							<td>
								<input type="text" id="login" name="login">
							</td>
						</tr>
						<tr>
							<td>密&nbsp;码：</td>
							<td>
								<input id="password" name="password" type="password">
							</td>
						</tr>
						<tr>
							<td>验证码：</td>
							<td>
								<input type="text" name="imgvalidate" maxlength="5" id="imgvalidate" style="width: 140px;vertical-align:middle">
								<img src="${basePath}/getCodeImage" id="imgcode_br" style="height: 30px;width:150px;line-height: 40px;vertical-align:middle;cursor:pointer;">
							</td>
						</tr>
					</table>
					</form>
				</div>
				<div class="login-form-bt">
					<img src="${basePath}/resources/img/login_button.png" id="img_btn">
				</div>
			</div>
		</div>
	</body>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript">
		function clearForm(){
			$("#formdata").form('clear');
		}
		
		function submitForm(){
			var login = $('#login').val();
			var password = $('#password').val();
			var validationimg = $('#imgvalidate').val();
			
			if(login == ""){
				$.messager.alert('登录提示','请输入帐号！');
				return false;
			}
			if(password == ""){
				$.messager.alert('登录提示','请输入密码！');
				return false;
			}
			if(validationimg == ""){
				$.messager.alert('登录提示','请输入图形验证码！');
				return false;
			}
			
			$.post('${base}/login/login',$("#formdata").serialize(),function(data){
				$('#imgcode_br').attr('src','${base}/login/getCodeImage?'+Math.random());
				if (data) {
					if(data.result == 'success'){
						clearForm();
						location.href='${base}/toindex';
					}else{
						clearForm();
						$.messager.alert('登录提示',data.message);
					}
				} else {
					$.messager.alert('错误提示','服务器繁忙，请稍候重试！','error');
				}
			},'json');
		}
		
		$(function(){
			$("#login")[0].focus();
			$('#imgcode_br').bind('click',function(){
				$('#imgcode_br').attr('src','${base}/login/getCodeImage?'+Math.random());
			});
			
			$('#img_btn').bind('click',submitForm);
			
		});
		$(document).keydown(function(event){ 
			if(event.keyCode == 13){ //绑定回车 
				submitForm(); //自动/触发登录按钮 
			} 
		}); 
	</script>
</html>
