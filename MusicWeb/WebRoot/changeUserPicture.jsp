<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div >
		<h2>修改用户头像</h2>
	<s:form action="fileUpload_changeUserPicture.action?memberId=${mUserRole.memberId  }" method="post" enctype="multipart/form-data">
		<s:file name="file" ></s:file>
		<s:submit value="上传头像"></s:submit>
	  </s:form>
	</div>
</body>
</html>