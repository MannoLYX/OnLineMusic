<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=GBK"%>
<html>
<head>
<title>播放器</title>
<style type="text/css">
.video {
	text-align: left;
	background-color: black;
	width: 300px;
	height: 30px;
}

body {
	font-size: 16px;
	font-weight: bold;
	color: #7CFC00;
	background-image: url("images/emerald.jpg");
}

input {
	background-image: url("images/p5.jpg");
}
</style>


</head>
<body>

	<div class="video">
		<audio controls="controls" autoplay="autoplay" loop="loop"> 
			<source src="${musicInfo.musicPath}" type="audio/mpeg"> 
			<h3>你的浏览器不支持该播放器,请使用其他浏览器打开！</h3>  
		</audio>
	</div>
	<div class="music">
		<br> <img alt="图挂了" src="${musicInfo.musicPicture }"
			width="300px" height="200px"> <br>
		<h3>歌名： ${musicInfo.musicName}</h3>
		<h3>歌手： ${musicInfo.singerName}</h3>
		<h3>歌曲介绍： ${musicInfo.musicInstruction}</h3>
		<!--  <h3>歌词： ${musicInfo.musicLyrics }</h3>-->
		
		<input type="button" value="返回首页"
			style="margin-right:20px; margin-top:20px;"
			onclick="javascript:window.history.go(-1)" />

	</div>

</body>
</html>
