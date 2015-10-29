

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
<title>音乐页面导航栏</title>
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
	background-color:#79CDCD;
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

<script type="text/javascript">
	function check() {
		var name = document.getElementById("searchName").value;
		if (null == name || "" == name) {
			alert("查询条件不能为空！");
		}
	}
</script>

</head>
<body>
	<div class="container">
		<div class="menuTitle">
			<a href="mainMusicShowInfo.jsp" target="musicright">首页</a>
		</div>
		<div class="menuContent"></div>

		<div class="menuTitle">
			<a href="music_queryMusicInfo.action" target="musicright">歌曲</a>
		</div>
		<div class="menuContent"></div>

		<div class="menuTitle">风格</div>
		<div class="menuContent">
			<ul>
				<s:iterator value="#application.styleList" status="stu" id="style">
					<li><a
						href="music_queryMusicBystyleId.action?styleId=${style.styleId }"
						target="musicright"><s:property value="#style.styleName" />
					</a>
					</li>
				</s:iterator>

			</ul>

		</div>



		<div class="menuTitle">情感</div>
		<div class="menuContent">
			<ul>
				<s:iterator value="#application.emotionList" status="stu"
					id="emotion">
					<li><a
						href="music_queryMusicByemotionId.action?emotionId=${emotion.emotionId }"
						target="musicright"><s:property value="#emotion.emotionName" />
					</a>
					</li>
				</s:iterator>

			</ul>
		</div>
		<div class="menuTitle">
			<a href="music_queryNewMusicByNumber.action" target="musicright">新歌榜</a>
		</div>
		<div class="menuContent"></div>

		<div class="menuTitle">
			<a href="music_queryHostMusicByNumber.action" target="musicright">热歌榜</a>
		</div>
		<div class="menuContent"></div>


		<div class="menuTitle">搜索</div>
		<div class="menuContent">

			<ul>
				<li><s:form action="music_fuzzyQueryMusicInfo.action"
						method="post" target="musicright">
						<input type="text" name="searchName" id="searchName"
							placeholder="歌名" />
						<input type="submit" value="Search" onclick="check()" />

					</s:form></li>
			</ul>
		</div>
	</div>


</body>
</html>