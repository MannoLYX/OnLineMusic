<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>显示歌曲首页图片</title>
<!-- Include a stylesheet -->
<link type="text/css" rel="stylesheet" href="css/jsized.carousel.css">
<!-- Include jQuery 1.3.2 only if you don't already have it on the page. -->
<script src="js/jquery-1.3.2.js" type="text/javascript"></script>
<!-- Add other required files -->
<script src="js/merged-without-jquery.js" type="text/javascript"></script>

<script>
	jQuery(function($) {
		// this lines create a carousel when the page finishes loading
		$('.example1').jsizedCarousel({
			// disable slideshow
			changeInterval : 0
		});

		$('.example2').jsizedCarousel({
			// size of the biggest slide
			front : {
				width : 450,
				height : 250
			},
			// determinies how much the slides decrease
			// from distance
			// default 0.15
			sizeDecrease : 0.2,
			// distance between slides in px
			distanceBetween : 25,
			changeInterval : 5
		});
	});
</script>

<style>
/* 
        Styles for this demo only, you probably won't need them
        Look into jsized.carousel.css to customize gallery 
        */
body {
	background: #2C2C2C;
}

.wr {
	width: 500px;
	margin: 0 auto;
	padding: 30px 100px;
	background: #C9C9C9;
	border: 1px solid background:   #DBDAD9;
}

h2 {
	margin: 30px;
	text-align: center;
	font-size: 18px;
	font-weight: normal;
	font-family: Verdana;
}
</style>
</head>
<body>
	<div class="wr">
		<div class="jsizedCarousel example1">
			<s:iterator value="#application.musicListByNumber" status="stu"
				id="music">
				<img src="${music.musicPicture }" alt="${music.musicName }"
					width="533" height="300" />

			</s:iterator>
		</div>

	</div>

</body>
</html>