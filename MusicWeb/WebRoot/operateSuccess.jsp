<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>顶部页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
div#div1 {
	position: fixed;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: -1;
}

div#div1>img {
	height: 100%;
	width: 100%;
	border: 0;
}

h1 {
	
	color: olive;
}
</style>
</head>

<body>
	          
	<s:if test="#request.operate==0">
		<div>
			<h1>操作成功！！！</h1>
		</div>
	</s:if>
	<s:else>
		<div>
			<h1>对不起！你操作失败！请重新操作。</h1>
		</div>
		
	</s:else>
		
	
	<div id="div1">
		<img src="images/出错壁纸.jpg" />
	</div>
</body>
</html>
