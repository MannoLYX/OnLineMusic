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
	<!-- 性别分类 -->
	<s:if test="#request.s==0">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#application.singerByGender" status="stu" id="singer">

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
	</s:if>

	<!-- 地域分类 -->
		<s:elseif test="#request.s==1">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
						<s:iterator value="#application.singerByCountry" status="stu" id="singer">

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

	</s:elseif>
	
	<!-- 欢迎度分类 -->
		<s:elseif test="#request.s==2">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
						<s:iterator value="#application.singerByPopularity" status="stu" id="singer">

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

	</s:elseif>

	<!-- 年代分类 -->
		<s:elseif test="#request.s==3">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
						<s:iterator value="#application.singerByTimes" status="stu" id="singer">

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

	</s:elseif>
	
	<!-- 模糊查询 -->
	<s:elseif test="#request.s==4">
		<div>
			<s:if test="${application.fuzzysingerList.size()==0 }">
				<h2>对不起，没有你想要的结果！</h2>
			</s:if>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#application.fuzzysingerList" status="stu"
						id="singer">


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
									国籍：<a href="music_queryMusicBysingerId.action?singerId=${singer.singerId }">${singer.singerCountry }</a>
								</p>
								<p>
									年代：
									<s:property value="#singer.times" />
								</p>
							</div>
						</li>


					</s:iterator>
				</ul>
			</div>

		</div>
	</s:elseif>

</body>
</html>
