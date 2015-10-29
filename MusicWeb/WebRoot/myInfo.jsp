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
<title>个人资料</title>

<link rel="stylesheet" href="css/css-reg/style.css"/>

<script type="text/javascript" src="js/js-reg/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/js-reg/easyform.js"></script>

<style type="text/css">

.pic{
margin-top:20px;
margin-right:100px;
}
</style>

</head>
<body>
<div class="form-div">
    <s:form name="updateform" action="" method="post">

        <table >
        	<caption><h2> 个人资料</h2></caption>
        
	        <tr>
	       	<td>  <input  type="hidden" name="mUserRole.memberId" value="${mUserRole.memberId }" /></td>
	      
	        </tr>
	      	<tr>
	      	<th></th>
	      	<td class="pic">
        		<a href="changeUserPicture.jsp"><img src="${mUserRole.memberPicture}" alt="我的头像" title="点击更换头像"  height="100px" width="100px"/></a>
        	</td>
        	</tr>
            <tr>
                <th>账号</th>
                <td><input name="mUserRole.accountNumber"  value="${mUserRole.accountNumber}" readonly="readonly" type="text" id="uid" easyform="length:4-16;char-normal;real-time;"   easytip="disappear:lost-focus;theme:blue;" ajax-message="用户名不能修改" />
               	
                </td>
            </tr>
             
             <tr>
                <th>昵称</th>
                <td><input name="mUserRole.memberName" value="${mUserRole.memberName}" readonly="readonly" type="text" id="nickname" easyform="length:2-16" message="昵称必须为2—16位" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
                    
           
           
			<tr>
                <th>性别</th>
                <td>
                <input name="mUserRole.gender" type="text" easyform="length:2-16"  value="${mUserRole.gender}" readonly="readonly"/>
                </td>                       
            </tr>  
              <tr>
                <th>年龄</th>
                <td><input name="mUserRole.age" value="${mUserRole.age }" type="text" readonly="readonly" easyform="length:2-16" message="年龄必须为正整数" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            
            <tr>
                <th>生日</th>
                <td><input name="mUserRole.birthday" value="${mUserRole.birthday }" type="text" readonly="readonly"  easyform="length:2-16" message="生日" easytip="disappear:lost-focus;theme:blue;" /></td>
            </tr> 
             <tr>
                <th>积分</th>
                <td><input name="mUserRole.memberIntegral" value="${mUserRole.memberIntegral }" type="text" readonly="readonly"  easyform="length:2-16" message="生日" easytip="disappear:lost-focus;theme:blue;" /></td>
            </tr> 
             <tr>
                <th>邮箱</th>
                <td><input name="mUserRole.memberEmail" value="${mUserRole.memberEmail}" readonly="readonly" type="text" id="email" easyform="email;real-time;" message="Email格式要正确" easytip="disappear:lost-focus;theme:blue;" ajax-message="这个Email地址已经被注册过，请换一个吧!"/></td>
            </tr>
             <tr>
                <th>角色</th>
                <td><input name="mUserRole.roleName" value="${mUserRole.roleName}" readonly="readonly" type="text" id="email" easyform="email;real-time;" message="Email格式要正确" easytip="disappear:lost-focus;theme:blue;" ajax-message="这个Email地址已经被注册过，请换一个吧!"/></td>
            </tr>
             
              <tr>
                <th>个人标签</th>
                <td><input name="mUserRole.memberLabel" value="${mUserRole.memberLabel }" readonly="readonly" type="text"   message="个人介绍" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            
              <tr>
                <th>个人介绍</th>
                <td><input name="mUserRole.memberIntroduction" value="${mUserRole.memberIntroduction }" readonly="readonly" type="text"   message="个人介绍" easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            <!--  
              <tr>
                <th>个人图片</th>
                <td><input name="mUserRole.memberPicture" type="text" value="${mUserRole.memberPicture}" readonly="readonly"   easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            -->
               <tr>
                <th>注册时间</th>
                <td><input name="mUserRole.registerDate" type="text" value="${mUserRole.registerDate}" readonly="readonly"   easytip="disappear:lost-focus;theme:blue;"/></td>
            </tr> 
            
           
            <!-- 用户注册时间 后台获得 -->            
        </table>

		<div class="buttons">
			<h3><a href="updateUser.jsp" style="margin-right:70px; margin-top:20px;"  target="infoFrame" >修改资料</a>
			<a href="changePwd.jsp" style="margin-right:60px; margin-top:20px;"  target="infoFrame" >修改密码</a></h3>
			<!-- 
			<input value="修改信息" type="button" style="margin-right:20px; margin-top:20px;"    onclick="update()"/>
			<input value="修改密码" type="submit" style="margin-right:20px; margin-top:20px;"  onclick="update()"/>
       		 -->
        </div>
		
        <br class="clear"/>
    </s:form>
</div>

<div style="text-align:center;clear:both;">
<script src="../gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="../follow.js" type="text/javascript"></script>
</div>
</body>
</html>
