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
<title>管理员更新页面</title>

<link rel="stylesheet" href="css/css-reg/style.css" />

<script type="text/javascript" src="js/js-reg/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/js-reg/easyform.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script>
	function update()
   {
      if(confirm("确定要更新吗？"))
      {
       updateform.action="member_adminUpdateMemberInfo.action";
       updateform.submit();
      }
   }
</script>

<style type="text/css">
table tr td select {
	width: 280px;
	margin-right: 20px;
	height: 30px;
}
</style>

</head>
<body>


	<s:if test="#request.update==0">
		<div class="form-div">
			<s:form name="updateform"
				action="member_adminUpdateMemberInfo.action" method="post">

				<table>
					<caption>
						<h2>用户资料</h2>
					</caption>
					<tr>
						<input type="hidden" name="memberId" value="${user.memberId }" />
					</tr>

					<tr>
						<td>账号</td>
						<td><input name="accountNumber" value="${user.accountNumber}"
							type="text" id="uid"
							easyform="length:4-16;char-normal;real-time;"
							message="用户名必须为4—16位的英文字母或数字"
							easytip="disappear:lost-focus;theme:blue;" ajax-message="用户名不能修改" />

						</td>
					</tr>

					<tr>
						<td>昵称</td>
						<td><input name="memberName" value="${user.memberName}"
							type="text" id="nickname" easyform="length:2-16"
							message="昵称必须为2—16位" easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input name="pwd" value="${user.pwd}" type="text"
							id="psw1" easyform="length:6-16;" message="密码必须为6—16位"
							easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr>
					<tr>
						<td>邮箱</td>
						<td><input name="memberEmail" value="${user.memberEmail}"
							type="text" id="email" easyform="email;real-time;"
							message="Email格式要正确" easytip="disappear:lost-focus;theme:blue;"
							ajax-message="这个Email地址已经被注册过，请换一个吧!" />
						</td>
					</tr>


					<tr>
						<td>性别</td>
						<td><s:if test="${user.gender=='男'}">
								<input name="gender" type="radio" easyform="length:2-16"
									checked="checked" value="男" />男
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input name="gender" easyform="length:2-16"
									type="radio" value="女" />女
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </s:if> <s:elseif test="${user.gender=='女'}">
								<input name="gender" type="radio" easyform="length:2-16"
									value="男" />男
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input name="gender" easyform="length:2-16"
									checked="checked" type="radio" value="女" />女
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </s:elseif></td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><input name="age" value="${user.age }" type="text"
							easyform="length:2-16" message="年龄必须为正整数"
							easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr>

					<tr>
						<td>生日</td>
						<td><input name="birthday" value="${user.birthday }"
							type="text" easyform="length:2-16" message="生日"
							easytip="disappear:lost-focus;theme:blue;"
							onclick="WdatePicker()" />
						</td>
					</tr>

					<tr>
						<td>角色</td>
						<td><select name="roleId">
								<s:iterator value="#application.pRoleList" status="stu"
									id="pRole">
									<option value="${pRole.roleName }">
										<s:property value="#pRole.roleName" />

									</option>
								</s:iterator>

						</select></td>

					</tr>

					<tr>
						<td>个人标签</td>
						<td><input name="memberLabel" value="${user.memberLabel }"
							type="text" message="个人介绍"
							easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr>
					</tr>
					<tr>
						<td>个人积分</td>
						<td><input name="memberIntegral" type="text"
							value="${user.memberIntegral}"
							easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr>
					<tr>
						<td>个人介绍</td>
						<td><input name="memberIntroduction"
							value="${user.memberIntroduction }" type="text" message="个人介绍"
							easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr>
					<%-- <tr>
						<td>个人图片</td>
						<td><input name="memberPicture" type="text"
							value="${user.memberPicture}"
							easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr> --%>

					<tr>
						<td>注册日期</td>
						<td><input name="registerDate" value="${user.registerDate }"
							type="text" easyform="length:2-16" message="生日"
							easytip="disappear:lost-focus;theme:blue;"
							onclick="WdatePicker()" />
						</td>
					</tr>


				</table>

				<div class="buttons">
					<input value="修改后保存" type="submit"
						style="margin-right:20px; margin-top:20px;" />
					<!-- onclick="update()" -->
					<input type="button" value="返回个人资料"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>

				<br class="clear" />
			</s:form>
		</div>
	</s:if>


<!-- 歌曲更新 -->
<s:elseif test="#request.update==1">

		<div class="form-div">
			<s:form name="updateform"
				action="music_updateMusic.action" method="post">

				<table>
					<caption>
						<h2>歌曲资料</h2>
					</caption>
					<tr>
						<input type="hidden" name="musicId" value="${musicInfo.musicId }" />
						<input type="hidden" name="musicPath" value="${musicInfo.musicPath }">
					</tr>

					<tr>
						<td>歌曲名称</td>
						<td><input name="musicName" value="${musicInfo.musicName}"
							type="text" 
							easytip="disappear:lost-focus;theme:blue;" />

						</td>
					</tr>

					<tr>
						<td>歌手</td>
						<td>
						<input name="singerName" value="${musicInfo.singerName}"
							type="text" easytip="disappear:lost-focus;theme:blue;" />
						
						</td>
					</tr>
					<tr>
						<td>歌曲说明</td>
						<td><input name="musicInstruction" value="${musicInfo.musicInstruction}" type="text"						
							easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr>
					<tr>
						<td>风格</td>		
						<td>
						<s:select name="styleCategory.styleId" list="styleList" listKey="styleId" listValue="styleName" value="${musicInfo.styleId}">			
						</s:select>
						</td>
					</tr>
	
					<tr>
						<td>心情</td>
						<td>
						<s:select name="emotionCategory.emotionId" list="emotionList" listKey="emotionId" listValue="emotionName" value="${musicInfo.emotionId}">			
						</s:select>		
						</td>
					</tr>
<%-- 
					<tr>
						<td>歌曲图片</td>
						<td><input name="musicPicture" value="${musicInfo.musicPicture }"
							type="text" easytip="disappear:lost-focus;theme:blue;" />
						</td>
					</tr> --%>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>歌词</td>
						<td>
						<textarea rows="20" cols="40"  name="musicLyrics" 
							 >${musicInfo.musicLyrics }</textarea>
						
						</td>
					</tr>
					
				</table>

				<div class="buttons">
					<input value="修改后保存" type="submit"
						style="margin-right:20px; margin-top:20px;" />
					<!-- onclick="update()" -->
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>

				<br class="clear" />
			</s:form>
		</div>

</s:elseif>




<!-- 歌手更新 -->
<s:elseif test="#request.update==2">

		<div class="form-div">
			<s:form name="updateform"
				action="singer_updateSinger.action" method="post">
			<table>		
				<tr>
					<input name="singerId" type="hidden" value="${singer.singerId }"/>
				
				</tr>				
				<tr>
					<td>歌手姓名</td>
					<td><input name="singerName" type="text" 
						easytip="disappear:lost-focus;theme:blue;" 
						 value="${singer.singerName }" /></td>
				</tr>
				<tr>
					<td>歌手国籍</td>
					<td><input name="singerCountry" type="text"
						easytip="disappear:lost-focus;theme:blue;" 
						value="${singer.singerCountry }" /></td>
				</tr>
				<tr>
					<td>歌手性别</td>
					
					<td><s:if test="${singer.singerGender=='男'}">
								<input name="singerGender" type="radio" easyform="length:2-16"
									checked="checked" value="男" />男
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input name="singerGender" easyform="length:2-16"
									type="radio" value="女" />女
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input name="singerGender" easyform="length:2-16"
									type="radio" value="组合" />组合
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </s:if> 
                <s:elseif test="${singer.singerGender=='女'}">
								<input name="singerGender" type="radio" easyform="length:2-16"
									value="男" />男
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input name="singerGender" easyform="length:2-16"
									checked="checked" type="radio" value="女" />女
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                  <input name="singerGender" easyform="length:2-16"
									type="radio" value="组合" />组合
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </s:elseif>
                   <s:elseif test="${singer.singerGender=='组合'}">
								<input name="singerGender" type="radio" easyform="length:2-16"
									value="男" />男
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input name="singerGender" easyform="length:2-16"
									type="radio" value="女" />女
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                  <input name="singerGender" easyform="length:2-16"
								checked="checked" 	type="radio" value="组合" />组合
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </s:elseif>
                
                
                </td>
								
				</tr>
				
				<%-- <tr>
					<td>歌手图片</td>
					<td><input name="singerPicture" type="text" 
						easytip="disappear:lost-focus;theme:blue;" 
						 value="${singer.singerPicture }" /></td>
				</tr>
 --%>
				<tr>
					<td>歌手年代</td>
					<td><input name="times" type="text" 
						easytip="disappear:lost-focus;theme:blue;"
						value="${singer.times }" />
						<br/>(例如：80、90、00)</td>
				</tr>

				<tr>
					<td>受欢迎程度</td>
					<td><input name="popularity" type="text" value="${singer.popularity}" />
						 <br/>(1-10)</td>
				</tr>

			</table>
										
				<div class="buttons">
					<input value="修改后保存" type="submit"
						style="margin-right:20px; margin-top:20px;" />
					
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>

				<br class="clear" />
			</s:form>
		</div>

</s:elseif>

<!-- 风格类型 -->
<s:elseif test="#request.update==3">

		<div class="form-div">
			<s:form name="updateform"
				action="category_updateStyle.action" method="post">
			<table>		
				<tr>
					<input name="styleId" type="hidden" value="${style.styleId }"/>
				
				</tr>				
				<tr>
					<td>风格类型</td>
					<td><input name="styleName" type="text" 
						easytip="disappear:lost-focus;theme:blue;" 
						 value="${style.styleName }" /></td>
				</tr>
			</table>
										
				<div class="buttons">
					<input value="修改后保存" type="submit"
						style="margin-right:20px; margin-top:20px;" />
					
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>
				<br class="clear" />
			</s:form>
		</div>
</s:elseif>


<!-- 情感类型 -->
<s:elseif test="#request.update==4">

		<div class="form-div">
			<s:form name="updateform"
				action="category_updateEmotion.action" method="post">
			<table>		
				<tr>
					<input name="emotionId" type="hidden" value="${emotion.emotionId }"/>
				
				</tr>				
				<tr>
					<td>风格类型</td>
					<td><input name="emotionName" type="text" 
						easytip="disappear:lost-focus;theme:blue;" 
						 value="${emotion.emotionName }" /></td>
				</tr>
			</table>
										
				<div class="buttons">
					<input value="修改后保存" type="submit"
						style="margin-right:20px; margin-top:20px;" />
					
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>
				<br class="clear" />
			</s:form>
		</div>
</s:elseif>



<!-- 权限角色更新 -->
<s:elseif test="#request.update==5">

		<div >
			<s:form name="updateform"
				action="personRole_updatePersonRole.action" method="post">
			<table>		
				<tr>
					<input name="roleId" type="hidden" value="${pRole.roleId }"/>
				
				</tr>	
				<tr>
					<th>角色名称：</th>
						<td>
							<input name="roleName" type="text" 						
						 value="${pRole.roleName }"/></td>
				</tr>	
					
				<tr>
				
				</tr>
					 	
				<tr>
					<th>用户权限集合：</th>
					<td>
					
					<s:checkboxlist list="UserAuthList" name="authArray" listKey="authorityId" listValue="authorityName" value="#application.authList.{authorityId}" ></s:checkboxlist>
					
				 </td>
				</tr>
				
				<tr>
					<th>管理员权限集合：</th>
					<td>
					<s:checkboxlist list="AdminAuthList" name="authArray" listKey="authorityId" listValue="authorityName" value="#application.authList.{authorityId}"></s:checkboxlist>
					</td>
				</tr>
					
			</table>
										
				<div class="buttons">
					<input value="修改后保存" type="submit"
						style="margin-right:20px; margin-top:20px;" />
					
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>
				<br class="clear" />
			</s:form>
		</div>
</s:elseif>

	
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
