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

#tableInfo {
	width: 900px;
}

.context a{
text-decoration:none;
font-size: 16px;
color: green;
font-weight: bold;
}

.context a:HOVER{
	color: red;
}

.del a{
 text-decoration: none;
 font-weight: bold;
	color:blue;
}

.del a:HOVER {
	color:green;
}

</style>


<script type="text/javascript">
	function del() {
		if (confirm("确定要删除吗？")) {

			userform.action = "member_deleteMember.action?memberId=${userInfo.memberId}";
			userform.submit();
		}
	}
</script>
</head>

<body>
<!-- 全部评论 -->
		<s:if test="#request.c==2">
			<div id="tableInfo" align="center">
				<s:form name="userform" method="post">
					<table border="1" id="userInfoTable">

						<tr id="bt">
							<th>序号</th>
							<th>评论内容</th>
							<th>评论时间</th>
							<th>评论者</th>
							<th>操作</th>

						</tr>
						<s:iterator value="#application.commentaryInfoBymember"
							status="status" id="commentary">
							<tr id="info"
								bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
								<td>${status.index+1}</td>
								<td class="context" width="500px"><a href=""><s:property value="#commentary.commentaryContext" />
								</a></td>
								<td width="100px"><s:property value="#commentary.commentaryTime" />
								</td>
								<td><s:property value="#commentary.memberName" />
								</td>
								<td class="del"><a
									href="commentary_deleteCommentary.action?commentaryId=${commentary.commentaryId }"><span>删除</span>
								</a></td>
							</tr>
						</s:iterator>
					</table>
				</s:form>
			</div>
		</s:if>
		
		<!-- 歌曲评论 -->
		<s:elseif test="#request.c==0">
			<div id="tableInfo" align="center">
				<s:form name="userform" method="post">
					<table border="1" id="userInfoTable">

						<tr id="bt">
							<th>序号</th>
							<th>评论内容</th>
							<th>评论时间</th>
							<th>歌曲名称</th>
							<th>操作</th>

						</tr>
						<s:iterator value="#application.MusicCommentaryInfo"
							status="status" id="commentary">
							<tr id="info"
								bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
								<td>${status.index+1}</td>
							<td class="context" width="500px"><a href=""><s:property value="#commentary.commentaryContext" />
								</a></td>
								<td width="100px"><s:property value="#commentary.commentaryTime" />
								</td>
								<td><s:property value="#commentary.musicName" />
								</td>
								<td class="del"><a
									href="commentary_deleteCommentary.action?commentaryId=${commentary.commentaryId }"><span>删除</span>
								</a></td>
							</tr>
						</s:iterator>
					</table>
				</s:form>
			</div>
		</s:elseif>

<!-- 悦单评论 -->
		<s:elseif test="#request.c==1">
			<div id="tableInfo" align="center">
				<s:form name="userform" method="post">
					<table border="1" id="userInfoTable">

						<tr id="bt">
							<th>序号</th>
							<th>评论内容</th>
							<th>评论时间</th>
							<th>悦单名称</th>
							<th>操作</th>
						</tr>
						<s:iterator value="#application.SongListCommentaryInfo"
							status="status" id="commentary">
							<tr id="info"
								bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
								<td>${status.index+1}</td>
								<td class="context" width="500px"><a href=""><s:property value="#commentary.commentaryContext" />
								</a></td>
								<td width="100px"><s:property value="#commentary.commentaryTime" />
								</td>
								<td><s:property value="#commentary.songListName" />
								</td>
								<td class="del"><a
									href="commentary_deleteCommentary.action?commentaryId=${commentary.commentaryId }"><span>删除</span>
								</a></td>
							</tr>
						</s:iterator>
					</table>
				</s:form>
			</div>
		</s:elseif>
		
		
			
	<!-- 模糊查询 -->
	<s:elseif test="#request.c==3">
		<div>
			<s:if test="${application.fuzzyCommentaryList.size()==0 }">
				<h2>对不起，没有你想要的结果！</h2>
			</s:if>
			<s:else>
			<div id="tableInfo" align="center">
				<s:form name="userform" method="post">
					<table border="1" id="userInfoTable">

						<tr id="bt">
							<th>序号</th>
							<th>评论内容</th>
							<th>评论时间</th>
							<th>歌曲名称</th>
							<th>操作</th>
						</tr>
						<s:iterator value="#application.fuzzyCommentaryList"
							status="status" id="commentary">
							<tr id="info"
								bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">
								<td>${status.index+1}</td>
								<td class="context" width="500px"><a href=""><s:property value="#commentary.commentaryContext" />
								</a></td>
								<td width="100px"><s:property value="#commentary.commentaryTime" />
								</td>
								<td><s:property value="#commentary.musicName" />
								</td>
								<td class="del"><a
									href="commentary_deleteCommentary.action?commentaryId=${commentary.commentaryId }"><span>删除</span>
								</a></td>
							</tr>
						</s:iterator>
					</table>
				</s:form>
			</div>
			</s:else>
		</div>
	</s:elseif>
</body>
</html>







