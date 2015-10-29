<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OnlineMusic</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="js/js/jquery.js"></script>
<script type="text/javascript" src="js/js/jquery.form.js"></script>
<script type="text/javascript" src="js/js/nicejforms.js"></script>
<script type="text/javascript" src="js/js/audioplayer.js"></script>
<link href="js/css/table.css" rel="stylesheet" type="text/css" />
<link href="js/css/page.css" rel="stylesheet" type="text/css" />
<link href="js/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/css/LoadingStatus.css" type="text/css" />
<link href="js/css/thickbox.css" rel="stylesheet" type="text/css" />
<style type="text/css" media="screen">
@import url(css/niceforms.css);
</style>
<script type="text/javascript">
	$(document).ready(function() {
		dopage('show_ajax.jsp');
		$.NiceJForms.build();
		var options = {
			target : '#message', //输出信息
			beforeSubmit : validate, //验证
			success : dosuccess, //成功时回调
			clearForm : true,
			timeout : 30000
		};
	});


	function dosuccess() {
		dopage('show_ajax.jsp');
	}


	function dopage(ajaxurl) {
		$('#LoadingStatus').show();
		$
				.ajax({
					url : ajaxurl,
					type : 'GET',
					dataType : 'html',
					timeout : 30000,
					async : false,
					error : function() {
						$('#comments')
								.html(
										'<table  width="50%" border="0" align="center"> <tr> <td class="center_article" align="center">获取信息失败，请刷新此页面！！！</td></tr></table>');
						$('#LoadingStatus').hide(500);
					},
					success : function(html) {
						//window.location="#article_md";
						$('#LoadingStatus').hide(1000);
						$('#comments').html(html);
					}
				});
	}
	
	
	
	function size(par) {

		var max = 50;

		if (par.value.length < max)

			var str = max - par.value.length;
		if (par.value == "") {
			alert("评论不能为空！！！");

		}

		if (str >= 0) {

		} else {
			alert("超过了限制字数！！！");
			par.value = "";
			return false;

		}
		}
</script>

</head>
<body>
	<div id="header">
		<div id="logo">
			<h1>OnlineMusic</h1>
		</div>
		<%-- <div id="userInfo">
			
					<img src="${mUser.memberPicture }" width="200px" height="100px" />

					<h3>
						<a href="infoframe.jsp">${mUser.memberName}</a>，欢迎您回来！
					</h3>
					退出请点<a href="logout.action" style="color: #FF0000">[注销登陆]</a>！
	
		</div> --%>
		
	</div>
	<hr />
	<div id="page">
		<div id="bg">
			<div id="content">
				<div class="post">
					<h2 class="title"></h2>
					<h3 class="date"></h3>
					<div class="entry">
						<h2>歌名： ${musicInfo.musicName }</h2>

						<object type="application/x-shockwave-flash"
							data="player/audioplayer.swf" width="290" height="24"
							id="audioplayer${musicInfo.musicId }">
							<param name="movie" value="player/audioplayer.swf" />
							<param name="FlashVars"
								value="playerID=${musicInfo.musicId }&soundFile=${musicInfo.musicPath }" />
							<param name="quality" value="high" />
							<param name="menu" value="false" />
							<param name="wmode" value="transparent" />
						</object>

						<img alt="" src="${musicInfo.musicPicture }" width="200px"
							height="80px" style="float: right;"> <br /> 歌手：
							${musicInfo.singerName }<br />风格：${musicInfo.styleName} <br />
							情感：${musicInfo.emotionName }<br/>
							歌曲说明：${musicInfo.musicInstruction } 
					</div>

					<p class="meta">
						<s:if test="${mUser.memberIntegral>=10 }">
							<h4><a href="download.action?fileName=${musicInfo.musicPath}&memberId=${mUser.memberId}" class="comments">点击下载</a></h4>
						</s:if>
						<s:else>
							<h4 style="color: red;">积分不足，丧失下载功能，快去评论吧！(异常请重新登录！)</h4>
						</s:else>aaaa
					</p>
				</div>
				<div class="post">
					<h2 class="title">我要留言</h2>
					<h3 class="date">&nbsp;</h3>
					<div class="entry">
						<p>
							<table width="80%" border="0" align="center">
								<tr>
									<td>
										<form id="myForm" name="myForm" method="post"
											action="commentary_addCommentary.action" class="niceform">
											<input type="hidden" name="memberId"
												value="${mUser.memberId}" />
											<input type="hidden" name="musicId"
												value="${musicInfo.musicId }" />
											<label> 用户昵称： <input type="text" name="name"
												id="textfield" value="${mUser.memberName }" maxlength="16"
												readonly="readonly" /> </label>

											<p></p>
											<label> 发表评论： <textarea name="commentaryContext"
													 cols="40" rows="5" placeholder="评论奖积分十分" onblur="size(this);"></textarea>
											</label>
											<div id="valueTip"></div>
											<label> <br />
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="submit" name="button" id="button" value="提交评论" />
											</label>
											<div id="message"></div>
										</form>
									</td>
								</tr>
							</table>
					</div>
					<p class="meta"></p>
				</div>
				<div id="LoadingStatus">
					<img src="images/ajax-loader.gif" />
				</div>
				<div class="post">
					<h2 class="title">最近留言</h2>
					<h3 class="date">&nbsp;</h3>

					<div class="entry" id="comments">
						<p></p>
					</div>
					<p class="meta"></p>
				</div>
			</div>
			<!-- end content -->
			<div id="sidebar" >
				
				<h2 style="font-weight: bold; margin: 10px auto auto 10px;">歌词</h2>
					<textarea cols="30" rows="30" readonly="readonly"  style="background-color:#CAE1FF ">
					${musicInfo.musicLyrics }
					</textarea>			
			</div>
			<!-- end sidebar -->
			<div style="clear: both;">&nbsp;</div>
		</div>
	</div>
	<!-- end page -->
	<hr />
	<div id="footer">
		<p>(c) 2015 OnlineMusic 版权所有，翻版必究</p>
	</div>
</body>

</html>
