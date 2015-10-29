<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>更新我的资料</title>

<link rel="stylesheet" href="css/css-reg/style.css"/>

<script type="text/javascript" src="js/js-reg/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/js-reg/easyform.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script>
	function update()
   {
      if(confirm("确定要更新吗？"))
      {
       updateform.action="member_updateMember.action";
       updateform.submit();
      }
   }
   
   /*
   function update()
   {
   	$.ajax(
   	{
   		url:'member_updateMember.action',
   		data:null,
   		dataType:"text",
   		type:"post",
   		success:function()
   		{
   			confirm('更新成功！');
   		}
   	});
   	  }
   	*/
 
</script>

</head>
<body>
<div class="form-div">
    <s:form name="updateform" action="" method="post" enctype="multipart/form-data">

        <table>
	        <tr>
	        <input  type="hidden" name="mUser.memberId" value="${mUserRole.memberId }" />
	        </tr>
	      
            <tr>
                <td>账号</td>
                <td><input name="mUser.accountNumber"  value="${mUser.accountNumber}" readonly="readonly" type="text" id="uid" easyform="length:4-16;char-normal;real-time;"  message="用户名必须为4—16位的英文字母或数字" easytip="disappear:lost-focus;theme:blue;" ajax-message="用户名不能修改" />
               	
                </td>
            </tr>
             
             <tr>
                <td>昵称</td>
                <td><input name="mUser.memberName" value="${mUser.memberName}" type="text" id="nickname" easyform="length:2-16" message="昵称必须为2—16位" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
             
            <tr>
                <td>邮箱</td>
                <td><input name="mUser.memberEmail" value="${mUser.memberEmail}"  type="text" id="email" easyform="email;real-time;" message="Email格式要正确" easytip="disappear:lost-focus;theme:blue;" ajax-message="这个Email地址已经被注册过，请换一个吧!"/></td>
            </tr>
           
			<tr>
                <td>性别</td>
                <td>
	               <s:if test="${mUser.gender=='男'}">
	                <input name="mUser.gender" type="radio" easyform="length:2-16" checked="checked" value="男" />男
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input name="mUser.gender" easyform="length:2-16" type="radio" value="女"/>女
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </s:if>
                 <s:elseif test="${mUser.gender=='女'}">
	                <input name="mUser.gender" type="radio" easyform="length:2-16"  value="男" />男
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input name="mUser.gender" easyform="length:2-16" checked="checked" type="radio" value="女"/>女
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </s:elseif>
                </td>                       
            </tr>  
              <tr>
                <td>年龄</td>
                <td><input name="mUser.age" value="${mUser.age }" type="text"  easyform="length:2-16" message="年龄必须为正整数" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            
            <tr>
                <td>生日</td>
                <td><input name="mUser.birthday" value="${mUser.birthday }" type="text" readonly="readonly"  easyform="length:2-16" message="生日" easytip="disappear:lost-focus;theme:blue;" onclick="WdatePicker()"/></td>
            </tr> 
            
             
              <tr>
                <td>个人标签</td>
                <td><input name="mUser.memberLabel" value="${mUser.memberLabel }" type="text"   message="个人介绍" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            
              <tr>
                <td>个人介绍</td>
                <td><input name="mUser.memberIntroduction" value="${mUser.memberIntroduction }" type="text"   message="个人介绍" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
       
           
            <!-- 用户注册时间 后台获得 -->            
        </table>

		<div class="buttons">
			<input value="修改后保存" type="submit" style="margin-right:20px; margin-top:20px;" onclick="update()"/>
       		<input type="button" value="返回个人资料" style="margin-right:20px; margin-top:20px;" onclick="javascript:window.history.go(-1)"/>
        </div>
		
        <br class="clear"/>
    </s:form>
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
