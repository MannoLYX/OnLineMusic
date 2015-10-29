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
<title>管理员添加信息</title>

<link rel="stylesheet" href="css/css-reg/style.css" />

<script type="text/javascript" src="js/js-reg/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/js-reg/easyform.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
table tr td select {
	width: 280px;
	margin-right: 20px;
	height: 30px;
}

table tr td #musicPic {
	margin-left: 200px;
}
</style>


</head>
<body>
	<s:if test="#request.showMainPage==0">
	<h3>welcome,${mUser.memberName}</h3>
	
	</s:if>

	<!-- 用户信息 -->
	<s:if test="#request.check==0">
		<div class="form-div">

			<table>
				<tr>
					<td><img src="${user.memberPicture}" alt="头像" height="40px;"
						width="40px" />
					</td>
				</tr>

				<tr>
					<td>账号</td>
					<td><input name="accountNumber" type="text" id="uid"
						easyform="length:4-16;char-normal;real-time;"
						message="用户名必须为4—16位的英文字母或数字"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						ajax-message="用户名已存在!" value="${user.accountNumber }" />
					</td>
				</tr>
				<tr>
					<td>昵称</td>
					<td><input name="memberName" type="text" id="nickname"
						easyform="length:2-16" message="昵称必须为2—16位"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${user.memberName }" />
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input name="pwd" type="text" id="psw1"
						easyform="length:6-16;" message="密码必须为6—16位"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${ user.pwd}" />
					</td>
				</tr>

				<tr>
					<td>邮箱</td>
					<td><input name="memberEmail" type="text" id="email"
						easytip="disappear:lost-focus;theme:blue;"
						value="${user.memberEmail }" readonly="readonly" />
					</td>
				</tr>

				<tr>
					<td>性别</td>
					<td><input name="gender" type="text"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${user.gender}" />
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input name="age" type="text" easyform="length:2-16"
						message="年龄必须为正整数" easytip="disappear:lost-focus;theme:blue;"
						readonly="readonly" value="${user.age }" />
					</td>
				</tr>

				<tr>
					<td>生日</td>
					<td><input name="birthday" type="text" readonly="readonly"
						easyform="length:2-16" easytip="disappear:lost-focus;theme:blue;"
						readonly="readonly" value="${user.birthday }" />
					</td>
				</tr>

				<tr>
					<td>角色</td>
					<td><input name="roleName" type="text"
						value="${pRole.roleName}" readonly="readonly" />
					</td>

				</tr>
				<tr>
					<td>积分</td>
					<td><input name="memberIntegral" type="text"
						easyform="length:2-16" message="个人积分"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${user.memberIntegral}" />
					</td>
				</tr>
				<tr>
					<td>个人标签</td>
					<td><input name="memberLabel" type="text"
						easyform="length:2-16" message="个人标签"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${user.memberLabel}" />
					</td>
				</tr>
				<tr>
					<td>个人介绍</td>
					<td><input name="memberIntroduction" type="text"
						easyform="length:2-16" message="个人介绍"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${user.memberIntroduction }" />
					</td>
				</tr>


				<tr>
					<td>注册时间</td>
					<td><input name="registerDate" type="text"
						easyform="length:2-16" easytip="disappear:lost-focus;theme:blue;"
						readonly="readonly" value="${user.registerDate}" />
					</td>
				</tr>


			</table>

			<div class="buttons">
				<input value="返回" type="submit"
					style="margin-right:20px; margin-top:20px;"
					onclick="javascript:window.history.go(-1)" />
			</div>

			<br class="clear" />

		</div>
	</s:if>

	<!-- 歌曲信息 -->
	<s:elseif test="#request.check==1">
		<div class="form-div">
			<table>
				<tr>

					<div class="buttons">
						<input value="返回" type="submit"
							style="margin-right:20px; margin-top:20px;"
							onclick="javascript:window.history.go(-1)" />
					</div>
				</tr>
				<tr>
					<td id="musicPic"><img src="${musicInfo.musicPicture}" alt="头像"
						height="120px;" width="150px" />
					</td>
				</tr>

				<tr>
					<td>歌曲名称</td>
					<td><input name="accountNumber" type="text" id="uid"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${musicInfo.musicName }" />
					</td>
				</tr>
				<tr>
					<td>歌手</td>
					<td><input name="memberName" type="text"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${musicInfo.singerName }" />
					</td>
				</tr>
				<tr>
					<td>歌曲说明</td>
					<td><input name="pwd" type="text" id="psw1"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${ musicInfo.musicInstruction}" />
					</td>
				</tr>

				<tr>
					<td>风格</td>
					<td><input name="memberEmail" type="text"
						easytip="disappear:lost-focus;theme:blue;"
						value="${musicInfo.styleName }" readonly="readonly" />
					</td>
				</tr>

				<tr>
					<td>情感</td>
					<td><input name="gender" type="text" readonly="readonly"
						value="${musicInfo.emotionName}" />
					</td>
				</tr>
				<tr>
					<td>音乐路径</td>
					<td><input name="age" type="text" readonly="readonly"
						value="${musicInfo.musicPath }" />
					</td>
				</tr>

				<tr>
					<td>歌词</td>
					<td><textarea rows="30" cols="40" readonly="readonly">
							${musicInfo.musicLyrics }
						</textarea></td>

				</tr>

			</table>



		</div>
	</s:elseif>



	<!-- 歌手信息 -->
	<s:elseif test="#request.check==2">
		<div class="form-div">
			<table>
				<tr>
					<div class="buttons">
						<input value="返回" type="submit"
							style="margin-right:20px; margin-top:20px;"
							onclick="javascript:window.history.go(-1)" />

					</div>

				</tr>
				<tr>
					<td id="singerPicture"><img src="${singer.singerPicture}"
						alt="头像" height="120px;" width="150px" />
					</td>
				</tr>

				<tr>
					<td>歌手姓名</td>
					<td><input name="singerName" type="text" id="uid"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${singer.singerName }" />
					</td>
				</tr>
				<tr>
					<td>歌手国籍</td>
					<td><input name="singerCountry" type="text"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${singer.singerCountry }" />
					</td>
				</tr>
				<tr>
					<td>歌手性别</td>
					<td><input name="singerGender" type="text"
						easytip="disappear:lost-focus;theme:blue;" readonly="readonly"
						value="${ singer.singerGender}" />
					</td>
				</tr>

				<tr>
					<td>歌手年代</td>
					<td><input name="times" type="text"
						easytip="disappear:lost-focus;theme:blue;"
						value="${singer.times }后" readonly="readonly" />
					</td>
				</tr>

				<tr>
					<td>受欢迎程度</td>
					<td><input name="popularity" type="text" readonly="readonly"
						value="${singer.popularity}" />
					</td>
				</tr>

			</table>
		</div>
	</s:elseif>

	<!-- 评论信息 -->
	<s:elseif test="#request.check==3">
		<div class="form-div">
			<table>
				<tr>
					<div class="buttons">
						<input value="返回" type="submit"
							style="margin-right:20px; margin-top:20px;"
							onclick="javascript:window.history.go(-1)" />
					</div>
				</tr>
				<tr>
					<td>评论内容</td>
					<td><textarea rows="10" cols="40" readonly="readonly">
							${commInfo.commentaryContext }
						</textarea></td>
				</tr>
				<tr>
					<td>评论时间</td>
					<td><input name="commentaryTime" type="text"
						readonly="readonly" value="${commInfo.commentaryTime }" />
					</td>
				</tr>
				<tr>
					<td>评论者</td>
					<td><input name="memberName" type="text" readonly="readonly"
						value="${ commInfo.memberName}" />
					</td>
				</tr>


			</table>
		</div>
	</s:elseif>

	<!-- 歌曲评论信息 -->
	<s:elseif test="#request.check==4">
		<div class="form-div">
			<table>
				<tr>
					<div class="buttons">
						<input value="返回" type="submit"
							style="margin-right:20px; margin-top:20px;"
							onclick="javascript:window.history.go(-1)" />
					</div>
				</tr>
				<tr>
					<td>评论内容</td>
					<td><textarea rows="10" cols="40" readonly="readonly">
							${commInfo.commentaryContext }
						</textarea></td>
				</tr>
				<tr>
					<td>歌曲名称</td>
					<td><input name="musicName" type="text" readonly="readonly"
						value="${commInfo.musicName }" />
					</td>
				</tr>
				<tr>
					<td>评论时间</td>
					<td><input name="commentaryTime" type="text"
						readonly="readonly" value="${commInfo.commentaryTime }" />
					</td>
				</tr>
				<tr>
					<td>评论者</td>
					<td><input name="memberName" type="text" readonly="readonly"
						value="${ commInfo.memberName}" />
					</td>
				</tr>


			</table>
		</div>
	</s:elseif>



	<!--悦单评论信息 -->
	<s:elseif test="#request.check==5">
		<div class="form-div">
			<table>
				<tr>
					<div class="buttons">
						<input value="返回" type="submit"
							style="margin-right:20px; margin-top:20px;"
							onclick="javascript:window.history.go(-1)" />
					</div>
				</tr>
				<tr>
					<td>评论内容</td>
					<td><textarea rows="10" cols="40" readonly="readonly">
							${commInfo.commentaryContext }
						</textarea></td>
				</tr>
				<tr>
					<td>悦单名称</td>
					<td><input name="songListName" type="text" readonly="readonly"
						value="${commInfo.songListName }" />
					</td>
				</tr>
				<tr>
					<td>评论时间</td>
					<td><input name="commentaryTime" type="text"
						readonly="readonly" value="${commInfo.commentaryTime }" />
					</td>
				</tr>
				<tr>
					<td>评论者</td>
					<td><input name="memberName" type="text" readonly="readonly"
						value="${ commInfo.memberName}" />
					</td>
				</tr>


			</table>
		</div>
	</s:elseif>




	<!--角色权限信息 -->
	<s:elseif test="#request.check==6">
		<div class="form-div">
			<table>
				<tr>
					<div class="buttons">
						<input value="返回" type="submit"
							style="margin-right:20px; margin-top:20px;"
							onclick="javascript:window.history.go(-1)" />
					</div>
				</tr>

				<tr>
					<td>角色名称</td>
					<td><input name="roleName" type="text" readonly="readonly"
						value="${pRole.roleName }" />
					</td>
				</tr>

				<tr>
					<td>权限集合</td>
					<td><textarea rows="30" cols="40" readonly="readonly">
						<s:iterator value="#application.authList" status="stu" id="auth">				
						序号:${auth.authorityId } /权限名称：${auth.authorityName }  /权限链接：${auth.action }
						</s:iterator>
						</textarea></td>
				</tr>
			</table>
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
