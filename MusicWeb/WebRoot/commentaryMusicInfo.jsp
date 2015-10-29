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
	/* $(document).ready(function() {
		dopage('show_ajax.jsp');
		$.NiceJForms.build();
		var options = {
			target : '#message', //输出信息
			beforeSubmit : validate, //验证
			success : dosuccess, //成功时回调
			clearForm : true,
			timeout : 30000
		};
	}); */

	/* function validate(formData, jqForm, options) {
		var Value = $("#valueid").val();
		if (!Value || Value.length <= 10) {
			$('#valueTip').html("<font color=\"red\">评论必须大于10个字符！</font>");
			return false;
		} 
		else {
			$('#valueTip').html(" ");
		}
	} */

	/* function dosuccess() {
		dopage('show_ajax.jsp');
	} */
/* 
	function addbox(music_id) {
		$.ajax({
			url : 'addtobox.action?music_id=' + $music_id,
			type : 'GET',
			dataType : 'html',
			timeout : 30000,
			async : false,
			error : function() {
				alert("出现错误！");
			},
			success : function(html) {
				//window.location="#article_md";
				alert(html);
			}
		});
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
	} */

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

		document.getElementById("span").innerHTML = str.toString();

	}
</script>

</head>
<body>
	<div id="header">
		<div id="logo">
			<h1>OnlineMusic</h1>
			<h2></h2>
		</div>
		<%-- <div id="menu">
			<ul>
				<li class="active"><a
					href="member_queryMemberUserInfoRecently.action" accesskey="1"
					title="">首页</a>
				</li>
				<s:iterator value="#session.menuList" status="status" id="menu">
					<li><a href="${menu.action}" target="_blank"
						accesskey="${status.index+1 }"> <s:property
								value="#menu.authorityName" /> </a></li>

				</s:iterator>
				<!-- <li><a href="musicbox.jsp" target="_blank" >音乐盒
							</a> 
							</li> -->
			</ul>
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
							歌曲说明：${musicInfo.musicInstruction } 
					</div>

					<p class="meta">
						<s:if test="${mUser.memberName!=null }">
							<a href="download.action?fileName=${musicInfo.musicPath}"
								class="comments">点击下载</a>
						</s:if>
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
										<form  method="post"
											action="commentary_addCommentary.action" ><!-- class="niceform" id="myForm" name="myForm" -->
											<input type="hidden" name="memberId"
												value="${mUser.memberId}" />
											<input type="hidden" name="musicId"
												value="${musicInfo.musicId }" />												
									
											<label> 用户昵称： <input type="text" name="name"
												id="textfield" value="${mUser.memberName }" maxlength="16"
												readonly="readonly" /> </label>

											<p></p>
											<label> 发表评论： <textarea name="commentaryContext"
													id="valueid" cols="40" rows="5" placeholder="评论内容"
													onblur="size(this);"></textarea> </label>
											<div id="valueTip"></div>
											<label> <br />
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="submit" name="button" id="button" value="提交评论"  />
											</label>
											<div id="message"></div>
										</form></td>
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
					<div>
						<TABLE width="80%" align="center" class="mytable">
							<s:if test="#application.commentaryInfoBymusic.size()!=0">
								<s:iterator value="#application.commentaryInfoBymusic"
									status="stu" id="musicCommentary">
									<TBODY>

										<TR class=odd>

											<TD>
												<div align="left">${musicCommentary.memberName } 发表于
													${musicCommentary.commentaryTime }</div>
											</TD>
										</TR>
									</TBODY>
									<TFOOT></TFOOT>
									<TBODY>
										<TR>
											<TD>
												<div align="left">${musicCommentary.commentaryContext
													}</div>
											</TD>
										</TR>

									</TBODY>
								</s:iterator>
							</s:if>
							<s:else>
								<TBODY>
									<TR class=odd>
										<TD>
											<div align="left">对不起，暂无任何评论！</div>
										</TD>
									</TR>
								</TBODY>
							</s:else>
						</TABLE>



					</div>
					<!-- 	<div class="entry" id="comments">
						<p></p>
					</div> 
					<p class="meta"></p>-->
				</div>
			</div>
			<!-- end content -->
			<%-- 	<div id="sidebar">
				<div id="about-box" style="font-size: 12px">
					<img src="${mUser.memberPicture }" width="200px" height="100px" />

					<h3>
						<a href="infoframe.jsp">${mUser.memberName}</a>，欢迎您回来！
					</h3>
					退出请点<a href="logout.action" style="color: #FF0000">[注销登陆]</a>！



				</div>
				<ul>
					<li>
						<h2>最新消息</h2>
						<ul>

						</ul>
					</li>
					<li>
						<h2>友情链接</h2>
						<ul>

						</ul>
					</li>
				</ul>
			</div> --%>
			<!-- end sidebar -->
			<div style="clear: both;">&nbsp;</div>
		</div>
	</div>
	<!-- end page -->
	<hr />
	<div id="footer">
		<p>(c) 2015 onlinemusic</p>
	</div>
</body>


</script>
</html>
