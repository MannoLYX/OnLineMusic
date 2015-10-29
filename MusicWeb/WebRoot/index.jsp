<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Onlinemusic</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="js/js/jquery.js"></script>
<script type="text/javascript" src="js/js/nicejforms.js"></script>
<script type="text/javascript" src="js/js/thickbox.js"></script>
<script type="text/javascript" src="js/js/audioplayer.js"></script>
<link href="js/css/default.css" rel="stylesheet" type="text/css" />
<link href="js/css/page.css" rel="stylesheet" type="text/css" />
<link href="js/css/thickbox.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/css/LoadingStatus.css" type="text/css" />
<link rel="stylesheet" href="js/css/userRank.css" type="text/css" />
<style type="text/css" media="screen">
@import url(js/css/niceforms.css);
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$.NiceJForms.build();
		dopage('index_ajax.jsp');
	});

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
						$('#content')
								.html(
										'<table  width="50%" border="0" align="center"> <tr> <td class="center_article" align="center">获取文章失败，请刷新此页面！！！</td></tr></table>');
						$('#LoadingStatus').hide(500);
					},
					success : function(html) {
						//window.location="#article_md";
						$('#LoadingStatus').hide(1000);
						$('#content').html(html);
					}
				});
	}

	function addbox(music_id) {
		$.ajax({
			url : 'addtobox.action?music_id=' + music_id,
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

	//用于显示用户 信息榜
	function nTabs(thisObj, Num) {
		if (thisObj.className == "active")
			return;
		var tabObj = thisObj.parentNode.id;
		var tabList = document.getElementById(tabObj)
				.getElementsByTagName("li");
		for (i = 0; i < tabList.length; i++) {
			if (i == Num) {
				thisObj.className = "active";
				document.getElementById(tabObj + "_Content" + i).style.display = "block";
			} else {
				tabList[i].className = "normal";
				document.getElementById(tabObj + "_Content" + i).style.display = "none";
			}
		}
	}
	var show_king_id = 1;
	function show_king_list(e, k) {
		if (show_king_id == k)
			return true;
		o = document.getElementById("a" + show_king_id);
		o.className = "bg";
		e.className = " ";
		show_king_id = k;
	}
	var show_kinga_id = 1;
	function show_kinga_list(f, l) {
		if (show_kinga_id == l)
			return true;
		o = document.getElementById("b" + show_kinga_id);
		o.className = "bg";
		f.className = " ";
		show_kinga_id = l;
	}
</script>
</head>
<body>
	<div id="header">
		<div id="logo">
			<h1>OnlineMusic</h1>
			<h2></h2>
		</div>
		<div id="menu">
			<ul>
				<li class="active"><a href="member_queryMemberUserInfoRecently.action" accesskey="1" title="">首页</a>
				</li>
				<s:iterator value="#session.menuList" status="status" id="menu">
					<li><a href="${menu.action}" target="_blank"
						accesskey="${status.index+1 }"><s:property
								value="#menu.authorityName" /> </a></li>

				</s:iterator>
				<!-- <li><a href="musicbox.jsp" target="_blank" >音乐盒
							</a> 
							</li> -->
			</ul>
		</div>
	</div>
	<div id="LoadingStatus">
		<img src="images/images/ajax-loader.gif" />
	</div>
	<hr />
	<div id="page">

		<div id="bg">
			<a name="article_md"></a>
			<!-- 分页技术的实现-->
			<div id="musicPage">
				共
				<s:property value="totalRecord" />
				条记录&nbsp;&nbsp;
				 共 ${totalPage} 页&nbsp;&nbsp;
				 第<s:property value="nowPage" />页&nbsp;&nbsp;

				<s:a href="page_queryNewMusicByNumberByPage.action?nowPage=${1}">首页</s:a>&nbsp;&nbsp;

				<s:if test="nowPage>1">
					<s:a
						href="page_queryNewMusicByNumberByPage.action?nowPage=${nowPage-1}">上一页</s:a>&nbsp;&nbsp;
				</s:if>
				<s:if test="nowPage<totalPage">
					<s:a
						href="page_queryNewMusicByNumberByPage.action?nowPage=${nowPage+1}">下一页</s:a>&nbsp;&nbsp;
				</s:if>
				<s:if test="nowPage>1">
				<s:a
					href="page_queryNewMusicByNumberByPage.action?nowPage=${totalPage}">尾页</s:a>
				</s:if>
			</div>
			<div id="content"></div>

			<!-- end contentn -->
			<div id="sidebar">
				<div id="about-box" style="font-size: 12px">
						<s:if test="#session.mUser==null">

							<form action="member_logIn.action" method="post" class="niceform">
								<h3>用户登录</h3>
								<label for="textinput"> &nbsp;&nbsp;用户名： </label>
								<br /> &nbsp;&nbsp;
								<input type="text" id="textinput" name="mUser.accountNumber"
									size="15" maxlength="16" placeholder="用户名" />
								<br />
								<label for="passwordinput"> &nbsp;&nbsp;密 码： </label>
								<br /> &nbsp;&nbsp;
								<input type="password" id="passwordinput" name="mUser.pwd"
									size="15" maxlength="16" placeholder="密码" />
								<br />
								<br /> &nbsp;&nbsp;&nbsp;&nbsp;
								<a href="register.jsp" title="我要注册">我要注册</a> &nbsp;&nbsp;
								<input type="submit" value="登  录" />

							</form>


							<p></p>
						</s:if>
						<s:else>
							<img src="${mUser.memberPicture }" width="200px" height="100px" />

							<h3>
								<a href="infoframe.jsp">${mUser.memberName}</a>，欢迎您回来！
							</h3>
									退出请点<a href="logout.action" style="color: #FF0000">[注销登陆]</a>！
							</s:else>
				</div>
				<ul>
					 <!-- <li>
						<h2>最新消息</h2>
						<ul>
						</ul></li> -->
					<li>
						<ul>
							<div class="door_container">
								<div class="TabTitle">
									<ul id="myTab">
										<li class="active" onclick=nTabs(this,0);>最近注册用户</li>
										<li class="normal" onclick=nTabs(this,1);>用户积分榜</li>
									</ul>
								</div>
								<div class="TabContent">
									<div id=myTab_Content0>
										<div class="star">

											<!-- 显示最近的用户 -->
											<s:iterator value="#application.RecentUserInfo" status="stu"
												id="User">
												<dl class=bg>
													<dt class="sl01">${stu.index+1}</dt>
													<dd class="sl03">
														<a href="#"><img src="${User.memberPicture}" alt="" />
														</a> <a href="#"><s:property value="#User.memberName" />
														</a>
													</dd>
													<dd class="sl04">
														<s:property value="#User.roleName" />
														&nbsp;年龄:
														<s:property value="#User.age" />
													</dd>
													<dd class="sl05"></dd>
												</dl>
											</s:iterator>
										</div>
									</div>
									<div class="none" id=myTab_Content1>
										<div class="star">

											<!-- 用户积分榜 -->
											<s:iterator value="#application.IntegralUserInfo"
												status="stu" id="User">

												<dl class=bg>
													<dt class="sl01">${stu.index+1}</dt>
													<dd class="sl03">
														<a href="#"><img src="${User.memberPicture}" alt="" />
														</a> <a href="#"><s:property value="#User.memberName" />
														</a>
													</dd>
													<dd class="sl04">
														<s:property value="#User.roleName" />
														&nbsp; 积分:
														<s:property value="#User.memberIntegral" />
													</dd>
												</dl>
											</s:iterator>
										</div>
									</div>
								</div>
							</div>

						</ul></li>
				</ul>
			</div>

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
</html>
