<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>音乐网站登录界面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<style type="text/css">
html,body {
	height: 100%;
}
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 400px;
	position: absolute;
	top: 50%;

	margin-top: -200px;
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
	height: 300px;
	width: 100%;
	max-width:500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}		
	
	
.input-group {
	margin: 0px 0px 30px 0px !important;
}
.form-control,
.input-group {
	height: 40px;
}

.form-group {
	margin-bottom: 0px !important;
}
.login-title {
	padding: 20px 10px;
	background-color: rgba(0, 0, 0, .6);
}
.login-title h1 {
	margin-top: 10px !important;
}
.login-title small {
	color: #fff;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}
.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
}
.loginBtn{
	width: 100px;
	height: 30px;
}
</style>

<script type="text/javascript" src="js/js-reg/jquery-2.1.0.min.js"></script>
<!-- 登录 用户验证 -->
<script language="javascript">
 function checkLogin()
 {                                                                                         
     if(document.LogInForm.username.value=="")
	 {
	 	alert("请输入用户名");
		document.LogInForm.username.focus();
		return false;
	 }
	 if(document.LogInForm.password.value=="")
	 {
	 	alert("请输入密码");
		document.LogInForm.password.focus();
		return false;
	 }
	// document.getElementById("indicator").style.display="block";
	// loginService.login(document.ThisForm.username.value,document.ThisForm.password.value,0,callback);
 }
 
 $(document).ready(function(){
 
 	$("#password").blur(function(){
 	
 			var accounterNumber =$("#username").val();
 			
 			var pwd = $("#password").val();
 			
			if(document.LogInForm.username.value=="")
			 {
			 	alert("请输入用户名");
				document.LogInForm.username.focus();
				return false;
			 }
			 if(document.LogInForm.password.value=="")
			 {
			 	alert("请输入密码");
				document.LogInForm.password.focus();
				return false;
			 }
 			
 			if((document.LogInForm.password.value!="") && (document.LogInForm.username.value!=""))
 			{
	 			$.post("member_CheckLogin.action",
	 			{accounterNumber:accounterNumber,pwd:pwd},
	 			function(response)
	 			{
		 			if(response=="用户名不存在")
		 			{
		 				document.getElementById("username").value="";
		 				document.getElementById("username").focus();//用户名输入控件获得焦点
		 				alert(response);
		 			}else if(response=="用户名和密码不匹配")
		 			{
		 				document.getElementById("password").value="";
		 				//document.getElementById("password").focus();//用户名输入控件获得焦点
		 				alert(response);
		 			}
	 			
	 			});
	 			
	 			
	 			
	 			/* $ajax({
		 			type:"post",
		 			url:"member_CheckLogin.action",
		 			data:{"accounterNumber":accounterNumber,"pwd":pwd},
					dataType:"json",
		 			success:function(response){
		 			
		 				alert(response);
		 			}
 				
 				});	 */
 			}
 	});
 
 	
 
 
 });
 
 
 
 </script>
</head>

<body>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><big>OnLineMusic</big></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			
			<form action="member_logIn.action" method="post" name="LogInForm">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="username" name="mUser.accountNumber" class="form-control" placeholder="用户名"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" id="password" name="mUser.pwd" class="form-control" placeholder="密码"/>
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
						  <input name="button"  type="submit"  class="loginBtn" value="登录" onClick="return checkLogin()"/>
						<!--  <button type="submit" class="btn btn-sm btn-info" onClick="check1()"><a href="index.html"/><span class="glyphicon glyphicon-off"></span> 登录</button>-->
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-6 link">
						<%-- <p class="text-center remove-margin"><small>忘记密码？</small> <a href="javascript:void(0)" ><small>找回</small></a> --%>
						</p>
					</div>
					<div class="col-xs-6 link">
						<p class="text-center remove-margin"><small>还没注册?</small> <a href="register.jsp" ><small>注册</small></a>
						</p>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>

</body>

</html>