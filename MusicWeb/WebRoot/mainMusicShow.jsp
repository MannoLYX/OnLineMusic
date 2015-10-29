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

<!-- 下载按钮 -->
<link rel="stylesheet" type="text/css" href="css/btn_download.css">

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


<link rel="stylesheet" type="text/css"
	href="commmentary_js/css/style.css" media="screen" />
<style type="text/css">
.video {
	float: left;
}

#left {
	background: #99FF99;
	height: 400px;
	width: 300px;
	float: left;
}

#left .whitebutton
{
	margin-top: 40px;
	
}

#right {
	background: #7CCD7C;
	height: 400px;
	width: 600px;;
	margin-left: 300px;
}

.newCommentary {

	font-size: 16px;
	margin: 20px auto auto 20px;
}

.oldCommentary {
	margin: 20px auto auto 20px;
}

h5 {
	margin-top: 10px;
	float: right;
	margin-right: 50px;
}

.commentary
{
width: 900px;
background-color:#66CDAA;
}

#submitComm
{
margin-left:550px;
	margin-top: 10px;
	height: 30px;
	width:100px;
	color: green;
}
.oldCommentary table tr td
{
	width: 800px;
}

.oldCommentary table tr td h4{
margin-left: 500px;
}


.singerMusic table tr td
{
	font-size: 16px;
	font-weight: bold;
	padding: 10px;
}

.singerMusic table th
{
	font-size:20px;
	font-weight: bold;
	color: #CDCD00;
	text-align: center;
}

.singerMusic table tr #musicInstr
{
	width:600px;
}

.singerMusic table tr a
{
	text-decoration: none;
	
}
</style>
</head>

<body>
	<!-- 风格分类 -->
	<s:if test="#request.i==0">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#application.styleMusicInfo" status="stu"
						id="music">


						<li>
							<div class="imgBox">
								<a href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"><img src="${music.musicPicture }"
									alt="${music.musicName}" width="160" height="200" /> </a>
							</div>
							<div class="txtBox">
								<h3>
									<a
										href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"
										font-size="16px;"><s:property value="#music.musicName" />
									</a>
								</h3>
								<p>
									歌手：<a href="#">${music.singerName }</a>
								</p>
								<p>
									介绍：
									<s:property value="#music.musicInstruction" />
								</p>
							</div></li>


					</s:iterator>
				</ul>
			</div>

		</div>
	</s:if>

	<!-- 情感分类 -->
	<s:elseif test="#request.i==1">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#application.emotionMusicInfo" status="stu"
						id="music">


						<li>
							<div class="imgBox">
								<a
									href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"><img
									src="${music.musicPicture }" alt="${music.musicName}"
									width="160" height="200" /> </a>
							</div>
							<div class="txtBox">
								<h3>
									<a
										href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"
										font-size="16px;"><s:property value="#music.musicName" />
									</a>
								</h3>
								<p>
									歌手：<a href="#">${music.singerName }</a>
								</p>
								<p>
									介绍：
									<s:property value="#music.musicInstruction" />
								</p>
							</div></li>


					</s:iterator>
				</ul>
			</div>

		</div>
	</s:elseif>
	<!-- 最新歌曲 -->
	<s:elseif test="#request.i==2">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#application.newMusicList" status="stu"
						id="music">


						<li>
							<div class="imgBox">
								<a
									href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"><img
									src="${music.musicPicture }" alt="${music.musicName}"
									width="160" height="200" /> </a>
							</div>
							<div class="txtBox">
								<h3>
									<a
										href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"
										font-size="16px;"><s:property value="#music.musicName" />
									</a>
								</h3>
								<p>
									歌手：<a href="#">${music.singerName }</a>
								</p>
								<p>
									介绍：
									<s:property value="#music.musicInstruction" />
								</p>
							</div></li>


					</s:iterator>
				</ul>
			</div>

		</div>
	</s:elseif>

	<!-- 最火歌曲 -->
	<s:elseif test="#request.i==3">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#application.hostMusicList" status="stu"
						id="music">


						<li>
							<div class="imgBox">
								<a
									href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"><img
									src="${music.musicPicture }" alt="${music.musicName}"
									width="160" height="200" /> </a>
							</div>
							<div class="txtBox">
								<h3>
									<a
										href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"
										font-size="16px;"><s:property value="#music.musicName" />
									</a>
								</h3>
								<p>
									歌手：<a href="#">${music.singerName }</a>
								</p>
								<p>
									介绍：
									<s:property value="#music.musicInstruction" />
								</p>
							</div></li>


					</s:iterator>
				</ul>
			</div>

		</div>
	</s:elseif>

	<!-- 全部歌曲 -->
	<s:elseif test="#request.i==4">
		<div>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#application.musicList" status="stu" id="music">


						<li>
							<div class="imgBox">
								<a
									href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"><img
									src="${music.musicPicture }" alt="${music.musicName}"
									width="160" height="200" /> </a>
							</div>
							<div class="txtBox">
								<h3>
									<a
										href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"
										><s:property value="#music.musicName" />
									</a>
								</h3>
								<p>
									歌手：<a href="#">${music.singerName }</a>
								</p>
								<p>
									介绍：
									<s:property value="#music.musicInstruction" />
								</p>
							</div></li>


					</s:iterator>
				</ul>
			</div>

		</div>
	</s:elseif>


	<!-- 模糊查询歌曲 -->
	<s:elseif test="#request.i==5">
		<div>
			<s:if test="${application.fuzzymusicList.size()==0}">
					<h2 >对不起,没有你想要的结果。</h2>
				</s:if>
			<div class="img-txt-flaser clearfix" id="img-txt-box1">
				<ul>
					<s:iterator value="#application.fuzzymusicList" status="stu"
						id="music">


						<li>
							<div class="imgBox">
								<a href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"><img src="${music.musicPicture }"
									alt="${music.musicName}" width="160" height="200" /> </a>
							</div>
							<div class="txtBox">
								<h3>
									<a href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }" font-size="16px;"><s:property
											value="#music.musicName" /> </a>
								</h3>
								<p>
									歌手：<a href="#">${music.singerName }</a>
								</p>
								<p>
									介绍：
									<s:property value="#music.musicInstruction" />
								</p>
							</div></li>


					</s:iterator>
				</ul>
			</div>

		</div>
	</s:elseif>

	<%-- <!-- 播放器-->
	<s:elseif test="#request.i==6">

		 <div class="video">
			<audio controls="controls" autoplay="autoplay" loop="loop"> <source
				src="${musicInfo.musicPath}" type="audio/mpeg">
			<h3>你的浏览器不支持该播放器,请使用其他浏览器打开！</h3></audio>
		</div>
		<br>
		<br>
		<div>
			<div id="left">
				<br> <img alt="图挂了" src="${musicInfo.musicPicture }"
					width="300px" height="200px"> <br>
				<h3>歌名： ${musicInfo.musicName}</h3>
				<h3>歌手： ${musicInfo.singerName}</h3>
				<h3>歌曲介绍： ${musicInfo.musicInstruction}</h3>
				
				<!-- 下载按钮 -->
				<!-- <input type="button" value="点击下载" onclick="javascript:window.location='download.action?fileName=${musicInfo.musicPath}';"/> -->
				<div class="whitebutton">
					<a href="download.action?fileName=${musicInfo.musicPath}">点击下载</a>
					<span class="up">${musicInfo.singerName}</span>
					<span class="down">  ${musicInfo.musicName} </span>
				</div>
				
	
			</div>
				
			<div id="right">
				<h3>歌词</h3>
				${musicInfo.musicLyrics }
			</div>
		</div>

		<div class="commentary">
			<div class="newCommentary">
				<s:form action="commentary_addCommentary.action" method="post">
					<input type="hidden" name="memberId" value="${mUser.memberId}" />
					<input type="hidden" name="musicId" value="${musicInfo.musicId }" />
					<h3>
						<small>字数：150. 剩余：<span id="span">150</span>.</small>
					</h3>
					<textarea rows="5" cols="100" placeholder="评论内容"
						name="commentaryContext"  onblur="size(this);"></textarea>
					<!--  <input type="text"  name="commentaryContext" id="commText"  placeholder="评论内容" />-->
					<br>
					<input type="submit" value="提交评论"  id="submitComm"/>

				</s:form>
			</div>

			<div class="oldCommentary">
				<s:iterator value="#application.commentaryInfoBymusic" status="stu"
					id="commentary">
					
					
					<table>
					
						<tr >
							<td><s:property value="#commentary.commentaryContext" /></td>
						
						
						</tr>
						<tr  bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td >
							<h4>
							评论者：
							<s:property value="#commentary.memberName" />
							|&nbsp;
							评论时间：
							<s:property value="#commentary.commentaryTime" />
							</h4>
							</td>
						</tr>
					
					</table>
					

				</s:iterator>

			</div>
		</div> 
		
			
	</s:elseif> --%>
	
	
	
	<!-- 歌手分类 -->
	<s:elseif test="#request.i==7">
		<div class="singerMusic">
		
			<table border="3" bordercolor="green" >
			<th>歌名</th>
			<th>介绍</th>
			<th>歌手</th>
			<s:iterator value="#application.singerMusicInfo" status="stu"
						id="music">
			<tr>
				
				<td>
					<a href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }"><s:property value="#music.musicName" /></a>
				</td>
				<td id="musicInstr">
					<s:property value="#music.musicInstruction" />
				</td>
				<td>
					<s:property value="#music.singerName" />
				</td>
			</tr>
			</s:iterator>
			</table>
			
		</div>
	</s:elseif>

</body>

<script type="text/javascript">
	function size(par) {

		var max = 150;

		if (par.value.length < max)

			var str = max - par.value.length;
		if(par.value=="")
		{
		alert("评论不能为空！！！");
		}

		if (str >= 0) {

		} else {
			alert("超过了限制字数！！！");
		}

		document.getElementById("span").innerHTML = str.toString();

	}
</script>

</html>
