<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>音乐分类</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<style type="text/css">
body{
	background-image: url("images/0.jpg");
}
.styleDiv input {
	font-size: 20px;
	color: red;
	margin: 20px 10px auto;
}

.emotionDiv input {
	font-size: 20px;
	color: green;
	margin: 20px 10px auto;
}

.up{border: 1px solid green;color:blue;font-weight: bold;}
</style>

</head>

<body>
	<div class="styleDiv">
		<h2>风格</h2>
		<s:form name="styleform">
			<s:iterator value="#application.styleList" status="stu" id="style">
				<input type="button" value="${style.styleName}"
					onclick="window.location.href='music_queryMusicBystyleId.action?styleId=${style.styleId  }'"  
					
					onMouseOver="this.className='Up'" />
			</s:iterator>
		</s:form>
	</div>
<!-- window.location.href='music_queryMusicBystyleId.action?styleId=${style.styleId }' -->
	<div class="emotionDiv">
		<h2>心情</h2>
		<s:form name="emotionform">
			<s:iterator value="#application.emotionList" status="stu" id="emotion">

				<input type="button" value="${emotion.emotionName}" 
				onclick="window.location.href='music_queryMusicByemotionId.action?emotionId=${emotion.emotionId }'"
				
			onMouseOver="this.className='Up'" />
			</s:iterator>
		</s:form>
	</div>
		
</body>
</html>
