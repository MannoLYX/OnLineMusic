<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册页面</title>

<link rel="stylesheet" href="css/css-reg/style.css"/>

<script type="text/javascript" src="js/js-reg/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/js-reg/easyform.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
  $(document).ready(function(){   
    var inputUserNameObj = $("#uid");  
  
		    $("#uid").blur(function(){   
		        var text = inputUserNameObj.val();   
			        $.post("member_CheckAccounterNumber.action?accounterNumber="+text,null,function(response){    
			            if(response=="用户名已经存在"){
			            
				            document.getElementById("uid").focus();//用户名输入控件获得焦点
				           
			             document.getElementById("showResult").innerHTML="<font color='red'>"+response+"</font>";
			            }else{
							if(document.getElementById("uid").value=="") //判断用户名是否为空
						     {
						     	 document.getElementById("showResult").innerHTML="<font color='red'>"+"用户名不为空"+"</font>";
						     	  document.getElementById("uid").focus();//用户名输入控件获得焦点
						      }else{
		             			document.getElementById("showResult").innerHTML="<font color='blue'>"+response+"</font>";
		           			 }
			            }
			        });   
			});   
       
});

     </script>
</head>
<body>
<div class="form-div">
    <form id="reg-form" action="member_addMemberByUser.action" method="post">

        <table>
        
            <tr>
                <td>账号</td>
                <td><input name="mUser.accountNumber" type="text" id="uid" easyform="length:4-16;char-normal;real-time;" message="用户名必须为4—16位的英文字母或数字" easytip="disappear:lost-focus;theme:blue;"  ajax-message="用户名已存在!"/>
                	<div id="showResult"></div>
                </td>
            </tr>
             <tr>
                <td>昵称</td>
                <td><input name="mUser.memberName" type="text" id="nickname" easyform="length:2-16" message="昵称必须为2—16位" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            <tr>
                <td>密码</td>
                <td><input name="mUser.pwd" type="password" id="psw1" easyform="length:6-16;" message="密码必须为6—16位" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input name="psw2" type="password" id="psw2" easyform="length:6-16;equal:#psw1;" message="两次密码输入要一致" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr>
           
            <tr>
                <td>邮箱</td>
                <td><input name="mUser.memberEmail" type="text" id="email" easyform="email;real-time;" message="Email格式要正确" easytip="disappear:lost-focus;theme:blue;" ajax-message="这个Email地址已经被注册过，请换一个吧!"/></td>
            </tr>
           
			<tr>
                <td>性别</td>
                <td>
                <input name="mUser.gender" type="radio" easyform="length:2-16" checked="checked" value="男" />男
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="mUser.gender" easyform="length:2-16" type="radio" value="女"/>女
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>                       
            </tr>  
              <tr>
                <td>年龄</td>
                <td><input name="mUser.age" type="text"  easyform="length:2-16" message="年龄必须为正整数" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            
            <tr>
                <td>生日</td>
                <td><input name="mUser.birthday" type="text" readonly="readonly"  easyform="length:2-16" message="生日" easytip="disappear:lost-focus;theme:blue;" onclick="WdatePicker()"/></td>
            </tr> 
            
            </tr>  
              <tr>
                <td>个人标签</td>
                <td><input name="mUser.memberLabel" type="text"  easyform="length:2-16" message="个人标签" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
             <tr>
                <td>个人介绍</td>
                <td><input name="mUser.memberIntroduction" type="text"  easyform="length:2-16" message="个人介绍" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
             
           <!--    <tr>
                <td>个人图片</td>
                <td><input name="mUser.memberPicture" type="text"  easyform="length:2-16" message="个人图片" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr>  -->
            
            
            <!-- 用户注册时间 后台获得 -->            
            
        </table>
		<s:if test="mUser.roleId!=1">
		<div class="buttons">
			<input value="注 册" type="submit" style="margin-right:20px; margin-top:20px;"/>
			<input value="我有账号，我要登录" type="button" style="margin-right:45px; margin-top:20px;" onclick="location.href='login.jsp'"/>
        </div>
        </s:if>
        <s:else>
        	<div class="buttons">
					<input value="提交用户信息" type="submit"
						style="margin-right:20px; margin-top:20px;" />
						
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>
        	
        
        </s:else>
		
        <br class="clear"/>
    </form>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$('#reg-form').easyform();
});
</script>
<div style="text-align:center;clear:both;">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
</body>
</html>
