<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'singerCountry.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="musicpic/js/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="musicpic/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="musicpic/js/jq.imgTxtCut.js"></script>
<script type="text/javascript">
	$(function() {
		$("#img-txt-box1").imgTxtCut({
			speed : 300
		});
		$("#img-txt-box2").imgTxtCut({
			effects : "fade",
			speed : 300
		});
		$("#img-txt-box3").imgTxtCut({
			effects : "scroll",
			speed : 300
		});
	});
</script>


</head>

<body>
	

		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#session.singerList" status="stu" id="singer">


						<li>
							<div class="imgBox">
								<a href="music_queryMusicBysingerId.action?singerId=${singer.singerId }"><img src="${singer.singerPicture }" alt="${singer.singerName}"
									width="160" height="200" /> </a>
							</div>
							<div class="txtBox">
								<h3>
									<a href="music_queryMusicBysingerId.action?singerId=${singer.singerId }" font-size="16px;"><s:property
											value="#singer.singerName" /> </a>
								</h3>
								<p>
									国籍：<a href="music_queryMusicBysingerId.action?singerId=${singer.singerId }">${singer.singerCountry}</a>
								</p>
								<p>
									年代：
									<s:property value="#singer.times" />后
								</p>
							</div>
						</li>


					</s:iterator>
				</ul>
			</div>

		</div>


</body>
</html>
