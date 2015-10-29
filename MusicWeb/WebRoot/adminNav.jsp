

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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>管理员导航栏</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".menuTitle").click(
						function() {
							$(this).next("div").slideToggle("slow").siblings(
									".menuContent:visible").slideUp("slow");
							$(this).toggleClass("activeTitle");
							$(this).siblings(".activeTitle").removeClass(
									"activeTitle");
						});
			});
</script>
<style type="text/css">
body {
	margin: 0;
	background-color: #79CDCD;
}

a {
	text-decoration: none;
	color: #43860c;
}

.container {
	width: 300px;
	text-align: center;
}

.menuTitle {
	width: 200px;
	height: 25px;
	background-image: url(images/expand.gif);
	margin: 0 auto;
	line-height: 25px;
	font-size: 18px;
	font-weight: bold;
	color: #43860c;
	cursor: pointer;
	margin-top: 6px;
}

.activeTitle {
	width: 200px;
	height: 25px;
	background-image: url(images/fold.gif);
	margin: 0 auto;
	line-height: 25px;
	font-size: 18px;
	font-weight: bold;
	color: #43860c;
	cursor: pointer;
	margin-top: 6px;
}

.menuContent {
	background-color: #fff;
	margin: 0 auto;
	height: auto;
	width: 200px;
	text-align: left;
	display: none;
}

li {
	background: url(images/arr.gif) no-repeat 20px 6px;
	list-style-type: none;
	padding: 0px 0px 0px 38px;
	height: 20px;
	line-height: 20px;
}

li a {
	font-size: 16px;
	font-weight: bold;
	text-decoration: none;
}

a:hover {
	color: blue;
}

ul {
	margin: 0;
	padding: 0;
}

input {
	width: 100px;
}
</style>

</head>
<body>
	<div class="container">
		<div class="menuTitle">
			<a href="member_showMainPage.action" target="adminNavRight">首页</a>
		</div>
		<div class="menuContent"></div>

		<s:iterator value="#session.menuList" status="stu" id="menu">
			<div class="menuTitle">
				<a href="${ menu.action}" target="adminNavRight"><s:property
						value="#menu.authorityName" />
				</a>

			</div>
			<div class="menuContent">
				<s:if test="${menu.authorityId==12 }">
					<ul>
						<li><a href="page_queryMusicCommentaryInfoByPage.action"
							target="adminNavRight">歌曲评论</a>
						</li>
						<!-- <li><a
							href="commentary_queryAllSongListCommentaryInfo.action"
							target="adminNavRight">悦单评论</a>
						</li> -->
						
							
					</ul>

				</s:if>


				<s:if test="${menu.authorityId==11 }">
					<ul>
						<li><a href="page_queryStyleCategoryInfoByPage.action"
							target="adminNavRight">风格类型</a>
						</li>
						<li><a href="page_queryEmotionCategoryInfoByPage.action"
							target="adminNavRight">情感类型</a>
						</li>
					</ul>


				</s:if>

			</div>

		</s:iterator>



	</div>


</body>
</html>
