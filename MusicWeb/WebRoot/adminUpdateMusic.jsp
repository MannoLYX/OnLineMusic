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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>



<body>
	
	<form action="fileUpload.action" method="post" enctype="multipart/form-data">
    　　
        username: <input type="text" name="username"/><br>
        file: <input type="file" name="file"/><br>
        
        <input type="submit" value="submit"/>
    </form>
	
	
	<s:form action="multiFileUpload.action" method="post" enctype="multipart/form-data">
		<s:file name="image"></s:file>
		<s:file name="image"></s:file>
		<s:file name="image"></s:file>
		<s:submit value="上传"></s:submit>
	  </s:form>
	  
	
	<a href="download.action?fileName=铭记11er.mp3">下载图片</a>
	
	
	
<input type="button" value="Struts2的文件下载【Struts2的stream拦截器的简便应用】" onclick="javascript:window.location='download.action?fileName=铭记11er.mp3';"/>
	
	
	
</body>
</html>
