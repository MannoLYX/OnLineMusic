<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>歌手页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		* { margin: 0; padding: 0; }
		body { font-family: Georgia, serif; background: #666666; }
	</style>
  </head>
  
  <body>
    <frameset name="singerframe" cols="30%,*">
    
    <iframe name="singerleft"  class="middlepic"  src="uSingerNav.jsp" scrolling="no"    height="100%" frameborder="no"  border="0" allowTransparency="true"  >
					</iframe>	
			
			
		<iframe name="singerright"  class="middlepic"src="uSingerInfoFirst.jsp" scrolling="auto" width="1035px"     height="100%" frameborder="no" border="0"  allowTransparency="true"  >
					</iframe>
		
 
    </frameset>
  </body>
</html>
