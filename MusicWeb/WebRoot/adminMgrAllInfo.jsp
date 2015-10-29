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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css">
body {
	margin: 0;
}

#bt {
	background: green;
}

#bt th {
	margin: inherit;
}

#info {
	margin: inherit;
}

#info td {
	height: 30px;
	align: center;
}

#userInfoTable {
	margin: inherit;
}

#search {
	width: 100%;
	height: 30px;
	margin-left: 40px;
}

#allInfo {
	width: 100%;
	height: 100%
}

#tableInfo {
	width: 900px;
}

#colSize {
	width: 400px;
}

#styleColSize {
	width: 600px;
}

#addDiv {
	margin-left: 40px;
}

#addDiv h3 a {
	font-weight: bold;
	text-decoration: none;
	color: blue;
}

#addDiv h3 a:HOVER {
	color: red;
}

#tableInfo td a {
	text-decoration: none;
	font-weight: bold;
	color: blue;
}

#tableInfo td a:HOVER {
	color: red;
}
</style>


<script type="text/javascript">
	function del() {
		if (confirm("确定要删除吗？")) {

			userform.action = "member_deleteMember.action?memberId=${userInfo.memberId}";
			userform.submit();
		}
	}

	function check() {
		var name = document.getElementById("searchName").value;
		if (null == name || "" == name) {
			alert("查询条件不能为空！");
		}
	}
	

</script>
</head>



<body>
	<br />

	
	<!-- 遍历用户的全部信息 -->
	<s:if test="#request.a==0">
		
		<div id="search">
	
		<s:form action="member_queryMemberByAccountName.action"
						method="post" target="adminNavRight">
						Search:<input type="text" name="searchName" id="searchName"
							placeholder="账号名" />
						<input type="submit" value="搜索" onclick="check()" />

					</s:form>
	</div>
	
		<div id="addDiv">
			<h3><!--  -->
				<a href="personRole_AdminQueryPerosonRoleInfo.action"
					target="adminNavRight">增加用户</a>
			</h3>
		</div>
		<div id="tableInfo" align="center">

			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th>账号</th>
						<th>用户名</th>
						<th>年龄</th>
						<th>性别</th>
						<th>生日</th>
						<th>积分</th>
						<th>角色</th>
						<th>邮箱</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>

					</tr>
					<s:iterator value="#application.memberListByPage" status="status"
						id="userInfo">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#userInfo.accountNumber" /></td>
							<td><s:property value="#userInfo.memberName" /></td>
							<td><s:property value="#userInfo.age" /></td>
							<td><s:property value="#userInfo.gender" /></td>
							<td><s:property value="#userInfo.birthday" /></td>
							<td><s:property value="#userInfo.memberIntegral" /></td>
							<td><s:property value="#userInfo.roleName" /></td>
							<td><s:property value="#userInfo.memberEmail" /></td>


							<s:if test="${mUser.roleId==1}">
								<td><a
									href="member_adminCheckMemberById.action?memberId=${userInfo.memberId}">查看</a>
									| <a
									href="member_deleteMember.action?memberId=${userInfo.memberId}"><span>删除</span>
								</a>| <a
									href="member_adminQueryMemberById.action?memberId=${userInfo.memberId}">更新</a>
								</td>
							</s:if>
						</tr>
					</s:iterator>
				</table>

				<!-- 分页技术的实现-->
				<div>
					<center>
						共<s:property value="totalRecord" />条记录 
						共 ${totalPage} 页
						 第<s:property value="nowPage" />页

						<s:a href="page_queryMemberUserInfoByPage.action?nowPage=${1}">首页</s:a>

						<s:if test="nowPage>1">
							<s:a
								href="page_queryMemberUserInfoByPage.action?nowPage=${nowPage-1}">上一页</s:a>
						</s:if>
						<s:if test="nowPage<totalPage">
							<s:a
								href="page_queryMemberUserInfoByPage.action?nowPage=${nowPage+1}">下一页</s:a>
						</s:if>
						<s:a
							href="page_queryMemberUserInfoByPage.action?nowPage=${totalPage}">尾页</s:a>
					</center>
				</div>

			</s:form>
		</div>

	</s:if>

	<!-- 遍历歌曲的全部信息 -->
	<s:elseif test="#request.a==1">
		<div id="addDiv">
			<h3>
				<a href="category_queryAllStyleInfoToAdd.action"
					target="adminNavRight">增加歌曲</a>
			</h3>
		</div>
		<div id="tableInfo" align="center">
			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th id="colSize">歌曲名</th>
						<th>歌手</th>
						<th>歌曲风格</th>
						<th>歌曲情感</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>


					</tr>
					<s:iterator value="#application.MusicInfoPage" status="status"
						id="music">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#music.musicName" /></td>
							<td><s:property value="#music.singerName" /></td>
							<td><s:property value="#music.styleName" /></td>
							<td><s:property value="#music.emotionName" /></td>


							<s:if test="${mUser.roleId==1}">
								<td><a
									href="music_queryMusicBymusicIdToAdmin.action?musicId=${music.musicId}">查看</a>
									| <a href="music_deleteMusic.action?musicId=${music.musicId}"><span>删除</span>
								</a>| <a
									href="music_queryMusicBymusicIdToAdminUpdate.action?musicId=${music.musicId}">更新</a>
								</td>
							</s:if>
						</tr>
					</s:iterator>
				</table>
				
					<!-- 分页技术的实现-->
				<div>
					<center>
						共<s:property value="totalRecord" />条记录 
						共 ${totalPage} 页
						 第<s:property value="nowPage" />页

						<s:a href="page_queryMusicInfoByPage.action?nowPage=${1}">首页</s:a>

						<s:if test="nowPage>1">
							<s:a
								href="page_queryMusicInfoByPage.action?nowPage=${nowPage-1}">上一页</s:a>
						</s:if>
						<s:if test="nowPage<totalPage">
							<s:a
								href="page_queryMusicInfoByPage.action?nowPage=${nowPage+1}">下一页</s:a>
						</s:if>
						<s:a
							href="page_queryMusicInfoByPage.action?nowPage=${totalPage}">尾页</s:a>
					</center>
				</div>
				
			</s:form>
		</div>
	</s:elseif>


	<!-- 遍历歌手的全部信息 -->
	<s:elseif test="#request.a==2">
		<div id="addDiv">
			<h3>
				<a href="singer_AdminQuerySingerToAdd.action" target="adminNavRight">增加歌手信息</a>
			</h3>
		</div>

		<div id="tableInfo" align="center">
			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th id="colSize">歌手名</th>
						<th>性别</th>
						<th>国籍</th>
						<th>年代</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>


					</tr>
					<s:iterator value="#application.SingerInfoPage" status="status"
						id="singer">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#singer.singerName" /></td>
							<td><s:property value="#singer.singerGender" /></td>
							<td><s:property value="#singer.singerCountry" /></td>
							<td><s:property value="#singer.times" /></td>


							<s:if test="${mUser.roleId==1}">
								<td><a
									href="singer_AdminQuerySingerBySingerIdToCheck.action?singerId=${singer.singerId}">查看</a>
									|<a
									href="singer_deleteSinger.action?singerId=${singer.singerId}"><span>删除</span>
								</a>| <a
									href="singer_AdminQuerySingerBySingerIdToUpdate.action?singerId=${singer.singerId}">更新</a>

								</td>
							</s:if>
						</tr>
					</s:iterator>
				</table>
					<!-- 分页技术的实现-->
				<div>
					<center>
						共<s:property value="totalRecord" />条记录 
						共 ${totalPage} 页
						 第<s:property value="nowPage" />页

						<s:a href="page_querySingerInfoByPage.action?nowPage=${1}">首页</s:a>

						<s:if test="nowPage>1">
							<s:a
								href="page_querySingerInfoByPage.action?nowPage=${nowPage-1}">上一页</s:a>
						</s:if>
						<s:if test="nowPage<totalPage">
							<s:a
								href="page_querySingerInfoByPage.action?nowPage=${nowPage+1}">下一页</s:a>
						</s:if>
						<s:a
							href="page_querySingerInfoByPage.action?nowPage=${totalPage}">尾页</s:a>
					</center>
				</div>
			</s:form>
		</div>
	</s:elseif>



	<!-- 遍历风格类型的全部信息 -->
	<s:elseif test="#request.a==3">
		<div id="addDiv">
			<h3>
				<a href="category_addStyleforword.action" target="adminNavRight">增加风格类型</a>
			</h3>
		</div>
		<div id="tableInfo" align="center">
			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th id="styleColSize">风格名称</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>


					</tr>
					<s:iterator value="#application.StyleCategoryInfoPage" status="status"
						id="style">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#style.styleName" /></td>

							<s:if test="${mUser.roleId==1}">
								<td><a
									href="category_deleteStyle.action?styleId=${style.styleId}"><span>删除</span>
								</a>| <a
									href="category_AdminQueryStyleByStyleIdToUpdate.action?styleId=${style.styleId}">更新</a>
								</td>
							</s:if>
						</tr>
					</s:iterator>
				</table>
						<!-- 分页技术的实现-->
				<div>
					<center>
						共<s:property value="totalRecord" />条记录 
						共 ${totalPage} 页
						 第<s:property value="nowPage" />页

						<s:a href="page_queryStyleCategoryInfoByPage.action?nowPage=${1}">首页</s:a>

						<s:if test="nowPage>1">
							<s:a
								href="page_queryStyleCategoryInfoByPage.action?nowPage=${nowPage-1}">上一页</s:a>
						</s:if>
						<s:if test="nowPage<totalPage">
							<s:a
								href="page_queryStyleCategoryInfoByPage.action?nowPage=${nowPage+1}">下一页</s:a>
						</s:if>
						<s:a
							href="page_queryStyleCategoryInfoByPage.action?nowPage=${totalPage}">尾页</s:a>
					</center>
				</div>

			</s:form>
		</div>
	</s:elseif>


	<!-- 遍历情感类型的全部信息 -->
	<s:elseif test="#request.a==4">
		<div id="addDiv">
			<h3>
				<a href="category_addEmotionforword.action" target="adminNavRight">增加情感类型</a>
			</h3>
		</div>

		<div id="tableInfo" align="center">
			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th id="styleColSize">情感名称</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>


					</tr>
					<s:iterator value="#application.EmotionCategoryInfoPage" status="status"
						id="emotion">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#emotion.emotionName" /></td>

							<s:if test="${mUser.roleId==1}">
								<td><a
									href="category_deleteEmotion.action?emotionId=${emotion.emotionId}"><span>删除</span>
								</a>| <a
									href="category_AdminQueryemotionByemotionId.action?emotionId=${emotion.emotionId}">更新</a>
								</td>
							</s:if>
						</tr>
					</s:iterator>
				</table>
					
						<!-- 分页技术的实现-->
				<div>
					<center>
						共<s:property value="totalRecord" />条记录 
						共 ${totalPage} 页
						 第<s:property value="nowPage" />页

						<s:a href="page_queryEmotionCategoryInfoByPage.action?nowPage=${1}">首页</s:a>

						<s:if test="nowPage>1">
							<s:a
								href="page_queryEmotionCategoryInfoByPage.action?nowPage=${nowPage-1}">上一页</s:a>
						</s:if>
						<s:if test="nowPage<totalPage">
							<s:a
								href="page_queryEmotionCategoryInfoByPage.action?nowPage=${nowPage+1}">下一页</s:a>
						</s:if>
						<s:a
							href="page_queryEmotionCategoryInfoByPage.action?nowPage=${totalPage}">尾页</s:a>
					</center>
				</div>
			</s:form>
		</div>
	</s:elseif>


	<!-- 遍历歌曲评论的全部信息 -->
	<s:elseif test="#request.a==5">
		<div id="tableInfo" align="center">
			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th id="colSize">评论内容</th>
						<th>评论时间</th>
						<th>歌曲名称</th>
						<th>评论者</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>


					</tr>
					<s:iterator value="#application.MusicCommentaryInfoPage"
						status="status" id="commentary">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#commentary.commentaryContext" /></td>
							<td><s:property value="#commentary.commentaryTime" /></td>
							<td><s:property value="#commentary.musicName" /></td>
							<td><s:property value="#commentary.memberName" /></td>


							<s:if test="${mUser.roleId==1}">
								<td><a
									href="commentary_queryMusicCommentaryByCommId.action?commentaryId=${commentary.commentaryId}"><span>查看</span>
								</a>| <a
									href="commentary_AdminDeleteCommentary.action?commentaryId=${commentary.commentaryId}"><span>删除</span>
								</a></td>
							</s:if>
						</tr>
					</s:iterator>
				</table>
					
					<!-- 分页技术的实现-->
				<div>
					<center>
						共<s:property value="totalRecord" />条记录 
						共 ${totalPage} 页
						 第<s:property value="nowPage" />页

						<s:a href="page_queryMusicCommentaryInfoByPage.action?nowPage=${1}">首页</s:a>

						<s:if test="nowPage>1">
							<s:a
								href="page_queryMusicCommentaryInfoByPage.action?nowPage=${nowPage-1}">上一页</s:a>
						</s:if>
						<s:if test="nowPage<totalPage">
							<s:a
								href="page_queryMusicCommentaryInfoByPage.action?nowPage=${nowPage+1}">下一页</s:a>
						</s:if>
						<s:a
							href="page_queryMusicCommentaryInfoByPage.action?nowPage=${totalPage}">尾页</s:a>
					</center>
				</div>
			</s:form>
		</div>
	</s:elseif>


	<!-- 遍历悦单评论的全部信息 -->
	<s:elseif test="#request.a==6">
		<div id="tableInfo" align="center">
			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th id="colSize">评论内容</th>
						<th>评论时间</th>
						<th>悦单名称</th>
						<th>评论者</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>


					</tr>
					<s:iterator value="#application.AllSongListCommentaryInfo"
						status="status" id="commentary">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#commentary.commentaryContext" /></td>
							<td><s:property value="#commentary.commentaryTime" /></td>
							<td><s:property value="#commentary.songListName" /></td>
							<td><s:property value="#commentary.memberName" /></td>


							<s:if test="${mUser.roleId==1}">
								<td><a
									href="commentary_querySongListCommentaryByCommId.action?commentaryId=${commentary.commentaryId}"><span>查看</span>
								</a>| <a
									href="commentary_AdminDeleteCommentary.action?commentaryId=${commentary.commentaryId}"><span>删除</span>
								</a></td>
							</s:if>
						</tr>
					</s:iterator>
				</table>

			</s:form>
		</div>
	</s:elseif>


	<!-- 遍历全部评论的全部信息 -->
	<s:elseif test="#request.a==7">
		<div id="tableInfo" align="center">
			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th id="colSize">评论内容</th>
						<th>评论时间</th>
						<th>评论者</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>


					</tr>
					<s:iterator value="#application.AllCommentaryInfoPage" status="status"
						id="commentary">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#commentary.commentaryContext" /></td>
							<td><s:property value="#commentary.commentaryTime" /></td>
							<td><s:property value="#commentary.memberName" /></td>


							<s:if test="${mUser.roleId==1}">
								<td><a
									href="commentary_queryCommentaryByCommId.action?commentaryId=${commentary.commentaryId}"><span>查看</span>
								</a>| <a
									href="commentary_AdminDeleteCommentary.action?commentaryId=${commentary.commentaryId}"><span>删除</span>
								</a></td>
							</s:if>
						</tr>
					</s:iterator>
				</table>
					<!-- 分页技术的实现-->
				<div>
					<center>
						共<s:property value="totalRecord" />条记录 
						共 ${totalPage} 页
						 第<s:property value="nowPage" />页

						<s:a href="page_queryAllCommentaryInfoByPage.action?nowPage=${1}">首页</s:a>

						<s:if test="nowPage>1">
							<s:a
								href="page_queryAllCommentaryInfoByPage.action?nowPage=${nowPage-1}">上一页</s:a>
						</s:if>
						<s:if test="nowPage<totalPage">
							<s:a
								href="page_queryAllCommentaryInfoByPage.action?nowPage=${nowPage+1}">下一页</s:a>
						</s:if>
						<s:a
							href="page_queryAllCommentaryInfoByPage.action?nowPage=${totalPage}">尾页</s:a>
					</center>
				</div>
			</s:form>
		</div>
	</s:elseif>


	<!-- 角色管理 -->
	<s:elseif test="#request.a==8">
		<div id="addDiv">
			<h3>
				<a href="authority_queryUserAuthorityInfoToAdd.action"
					target="adminNavRight">新增角色</a>
			</h3>
		</div>
		<div id="tableInfo" align="center">
			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th id="colSize">角色名称</th>
						<th>权限序号</th>
						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>


					</tr>
					<s:iterator value="#application.pRoleList" status="status"
						id="pRole">
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td><s:property value="#pRole.roleName" /></td>
							<td><s:property value="#pRole.authority_RoleId" /></td>

							<s:if test="${mUser.roleId==1}">
								<td><a
									href="personRole_AdminQueryPersonRoleInfoById.action?roleId=${pRole.roleId}"><span>查看</span>
								</a>| <a
									href="personRole_deletePersonRole.action?roleId=${pRole.roleId}"><span>删除</span>
								</a>| <a
									href="personRole_AdminQueryPersonRoleInfoByIdToUpdate.action?roleId=${pRole.roleId}">更新</a>
								</td>
							</s:if>
						</tr>
					</s:iterator>
				</table>

			</s:form>
		</div>
	</s:elseif>


	<!-- 查询出来的结果 -->
	<s:elseif test="#request.a==9">
		<s:if test="#request.isnull==0">
		<h3>对不起，没有你想要的结果</h3>
		</s:if>
		<div id="tableInfo" align="center">

			<s:form name="userform" method="post">
				<table border="1" id="userInfoTable">

					<tr id="bt">
						<th>序号</th>
						<th>账号</th>
						<th>用户名</th>
						<th>年龄</th>
						<th>性别</th>
						<th>生日</th>
						<th>积分</th>
						<th>角色</th>
						<th>邮箱</th>

						<s:if test="${mUser.roleId==1}">
							<th>操作</th>
						</s:if>

					</tr>
						<tr id="info" bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
							<td>${status.index+1}</td>
							<td>${mUserRole.accountNumber}</td>
							<td>${mUserRole.memberName}</td>
							<td>${mUserRole.age}</td>
							<td>${mUserRole.gender}</td>
							<td>${mUserRole.birthday}</td>
							<td>${mUserRole.memberIntegral}</td>
							<td>${mUserRole.roleName}</td>
							<td>${mUserRole.memberEmail}</td>


							<s:if test="${mUser.roleId==1}">
								<td><a
									href="member_adminCheckMemberById.action?memberId=${mUserRole.memberId}">查看</a>
									| <a
									href="member_deleteMember.action?memberId=${mUserRole.memberId}"><span>删除</span>
								</a>| <a
									href="member_adminQueryMemberById.action?memberId=${mUserRole.memberId}">更新</a>
								</td>
							</s:if>
						</tr>
				</table>
				</s:form>
				</div>
	</s:elseif>
</body>
</html>







