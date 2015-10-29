<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册页面</title>


<link rel="stylesheet" href="css/css-reg/style.css" />
aa
<script type="text/javascript">
function checkoldpwd()
{
	var oldPwd =document.getElementById("oldPwd").value;
	var holdpwd =document.getElementById("holdPwd").value;
	if(oldPwd != holdpwd)
	{
		alert("输入的旧密码错误！！！");
		document.getElementById("oldPwd").value="";
		
		document.getElementById("oldPwd").focus();
		return false;
	}
	return true;
}


function checksame()
{

	var psw1=document.getElementById("psw1").value;
	var psw2=document.getElementById("psw2").value;
	if (psw1 != psw2)
	{
		alert("两次密码不一致，请重新输入！");
		document.getElementById("psw2").value=" ";
		document.getElementById("psw2").focus();
		
		return false;
	}
	else if(confirm("确定要修改密码吗？"))
	{
		changePwdFrom.action="member_changeuserPwd.action?memberId=${mUser.memberId}";
       changePwdFrom.submit();
	}
	
}

</script>

</head>
<body>
	<div class="form-div">
		<s:form name="changePwdFrom" action="" method="post">

			<table>
				<caption>
					<h2>修改密码</h2>
				</caption>

				<tr>
					<input type="hidden" value="${mUser.memberId }" />

				</tr>

				<tr>
					<th>旧密码</th>
					<input type="hidden" id="holdPwd" value="${mUser.pwd}" />

					<td><input id="oldPwd" type="text" easyform="length:6-16;"
						message="密码必须为6—16位" easytip="disappear:lost-focus;theme:blue;"
						onblur="checkoldpwd();" />
					</td>
				</tr>

				<tr>
					<th>新密码</th>
					<td><input name="newPWD" type="text" id="psw1"
						easytip="disappear:lost-focus;theme:blue;" />
					</td>
				</tr>
				<tr>
					<th>再次输入密码</th>
					<td><input name="mUser.pwd" type="text" id="psw2"
						easytip="disappear:lost-focus;theme:blue;" />
					</td>
				</tr>

			</table>
			<div class="buttons">
				<input value="修改密码" type="submit"
					style="margin-right:20px; margin-top:20px;" onclick="checksame();" />
				<input type="button" value="返回个人资料"
					style="margin-right:20px; margin-top:20px;"
					onclick="javascript:window.history.go(-1)" />
			</div>

			<br class="clear" />
		</s:form>
	</div>

</body>
</html>
