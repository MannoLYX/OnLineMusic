<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员添加信息</title>

<link rel="stylesheet" href="css/css-reg/style.css" />

<script type="text/javascript" src="js/js-reg/jquery-2.1.0.min.js"></script>
<%-- <script type="text/javascript" src="js/js-reg/easyform.js"></script> --%>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">

table tr td select {
	width: 280px;
	margin-right: 20px;
	height: 30px;
}
</style>


</head>
<body>

	<s:if test="#request.add==0">
		<div class="form-div">
			<s:form id="reg-form" action="member_AdminAddMember.action"
				method="post">

				<table>

					<tr>
						<td>账号</td>
						<td><input name="mUser.accountNumber" type="text" id="uid"
						 />
						</td>
					</tr>
					<tr>
						<td>昵称</td>
						<td><input name="mUser.memberName" type="text" id="nickname"
						 />
						</td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input name="mUser.pwd" type="text" id="psw1"
						 />
						</td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td><input name="psw2" type="text" id="psw2"
						 />
						</td>
					</tr>

					<tr>
						<td>邮箱</td>
						<td><input name="mUser.memberEmail" type="text" id="email"
						 />
						</td>
					</tr>

					<tr>
						<td>性别</td>
						<td><input name="mUser.gender" type="radio"
							 checked="checked" value="男" />男
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="mUser.gender"  type="radio" value="女" />女
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><input name="mUser.age" type="text"
							 />
						</td>
					</tr>

					<tr>
						<td>生日</td>
						<td><input name="mUser.birthday" type="text"
							readonly="readonly" 
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
						<td>积分</td>
						<td><input name="mUser.memberIntegral" type="text"
							 />
						</td>
					</tr>
					<tr>
						<td>个人标签</td>
						<td><input name="mUser.memberLabel" type="text"
							 />
						</td>
					</tr>
					<tr>
						<td>个人介绍</td>
						<td><input name="mUser.memberIntroduction" type="text"
							/>
						</td>
					</tr>



					<!-- 用户注册时间 后台获得 -->

				</table>

				<div class="buttons">
					<input value="提交用户信息" type="submit"
						style="margin-right:20px; margin-top:20px;" />
						
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>

				<br class="clear" />
			</s:form>
		</div>
	</s:if>


	<!-- 增加歌曲 music_addMusic.action -->
	<s:elseif test="#request.add==1">

		<div class="form-div">
			<s:form name="updateform" action="multiFileUpload.action"
				method="post" enctype="multipart/form-data">

				<table>
					<caption>
						<h2>歌曲资料</h2>
					</caption>
					<tr>
						<td>歌曲名称</td>
						<td><input name="musicName" type="text"
							/>
						</td>
					</tr>

					<tr>
						<td>歌手</td>
						<td><input name="singerName" type="text"
							/>
						</td>
						
					</tr>
					<tr>
						<td>歌曲说明</td>
						<td><input name="musicInstruction" type="text"
							 />
						</td>
					</tr>
					<tr>
						<td>风格</td>
						<td><s:select name="styleCategory.styleId" list="styleList"
								listKey="styleId" listValue="styleName">
							</s:select>
						</td>
					</tr>

					<tr>
						<td>心情</td>
						<td><s:select name="emotionCategory.emotionId"
								list="emotionList" listKey="emotionId" listValue="emotionName">
							</s:select>
						</td>
					</tr>

					<tr>
						<td>上传歌曲</td>
						<td>
							<s:file name="image">
							</s:file>
						
					<!-- 	<input name="musicPath" "
							type="text"
							easytip="disappear:lost-focus;theme:blue;" /> -->
						</td>
					</tr>

					<tr>
						<td>歌曲图片</td>
						<td>
						
							<s:file name="image">
							</s:file>
						<!-- <input name="musicPicture" 
							type="text"
							easytip="disappear:lost-focus;theme:blue;" /> -->
						</td>
					</tr>

					<tr>
						<td>歌词</td>
						<td><textarea rows="20" cols="40" name="musicLyrics"></textarea>

						</td>
					</tr>

				</table>

				<div class="buttons">
					<input value="保存信息" type="submit"
						style="margin-right:20px; margin-top:20px;" /> <input
						type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>

				<br class="clear" />
			</s:form>
		</div>
	</s:elseif>

	<!--添加 歌手信息 -->
	<s:elseif test="#request.add==2">
		<div class="form-div">
			<s:form name="updateform" action="fileUpload_addSingerInfo.action"
				method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>歌手姓名</td>
						<td><input name="singerName" type="text"
							 /></td>
					</tr>
					<tr>
						<td>歌手国籍</td>
						<td><input name="singerCountry" type="text"
							 /></td>
					</tr>
					<tr>
						<td>歌手性别</td>
						<td><input name="singerGender" type="radio"
							 checked="checked" value="男" />男
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="singerGender" type="radio" value="女" />女
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="singerGender"  type="radio"
							value="组合" />组合
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>

					<tr>
						<td>歌手年代</td>
						<td><input name="times" type="text"
							 />
							<br/>(例如：80,90,00)
							</td>
					</tr>
					<tr>
						<td>歌手图片</td>
						<td>
							
							<s:file name="file">
							</s:file>
						<!-- <input name="singerPicture" type="text"
							 /> --></td>
					</tr>

					<tr>
						<td>受欢迎程度</td>
						<td><input name="popularity" type="text" />
						<br/>(1-10)
						</td>
					</tr>
							
				</table>
					<div class="buttons">
					<input value="保存信息" type="submit"
						style="margin-right:20px; margin-top:20px;" /> <input
						type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
					</div>
			</s:form>
		</div>

	</s:elseif>
	
	<!-- 风格类型信息 -->
	<s:elseif test="#request.add==3">
		<div class="form-div">
			<s:form name="updateform"
				action="category_addStyle.action" method="post">
			<table>					
				<tr>
					<td>风格类型</td>
					<td><input name="styleName" type="text" 
						easytip="disappear:lost-focus;theme:blue;" 
						 /></td>
				</tr>
			</table>
										
				<div class="buttons">
					<input value="保存信息" type="submit"
						style="margin-right:20px; margin-top:20px;" />
					
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>
				<br class="clear" />
			</s:form>
		</div>
	
	
	</s:elseif>
	
	
		<!-- 情感类型信息 -->
	<s:elseif test="#request.add==4">
		<div class="form-div">
			<s:form name="updateform"
				action="category_addEmotion.action" method="post">
			<table>					
				<tr>
					<td>风格类型</td>
					<td><input name="emotion.emotionName" type="text" 
						 
						 /></td>
				</tr>
			</table>
										
				<div class="buttons">
					<input value="保存信息" type="submit"
						style="margin-right:20px; margin-top:20px;" />
					
					<input type="button" value="返回"
						style="margin-right:20px; margin-top:20px;"
						onclick="javascript:window.history.go(-1)" />
				</div>
				<br class="clear" />
			</s:form>
		</div>
	
	
	</s:elseif>
	
	
	
	<!-- 角色权限信息 -->
	<s:elseif test="#request.add==5">
		<div >
			<s:form name="updateform"
				action="personRole_addPersonRole.action" method="post">
			<table>			
				<tr>
						<th>角色名称:</th>
						<td><input name="roleName" type="text" 						
						/></td>
					</tr>	
					
				<tr>
				
				</tr>
					 	
				<tr>
					<th>用户权限集合:</th>
					<td>
					
					<s:checkboxlist list="UserAuthList" name="authArray" listKey="authorityId" listValue="authorityName"  ></s:checkboxlist>
					
				 </td>
				</tr>
				
				<tr>
					<th>管理员权限集合:</th>
					<td>
					<s:checkboxlist list="AdminAuthList" name="authArray" listKey="authorityId" listValue="authorityName" ></s:checkboxlist>
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
		$(document).ready(function() {
			$('#reg-form').easyform();
		});
	</script>
	
</body>
</html>
