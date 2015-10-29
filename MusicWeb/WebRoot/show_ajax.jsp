<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<TABLE width="80%" align="center" class="mytable">
	<s:if test="#application.commentaryInfoBymusic.size()!=0">
		<s:iterator value="#application.commentaryInfoBymusic" status="stu"
			id="musicCommentary">
			<TBODY>

				<TR class=odd>

					<TD>
						<div align="left" style="font-size: 12px;">${musicCommentary.memberName } 发表于
							${musicCommentary.commentaryTime }</div></TD>
				</TR>
			</TBODY>
			<TFOOT></TFOOT>
			<TBODY>
				<TR>
					<TD>
						<div align="left" style="font-size: 14px; font-weight: bold;">${musicCommentary.commentaryContext }</div></TD>
				</TR>

			</TBODY>
		</s:iterator>
	</s:if>
	<s:else>
		<TBODY>
			<TR class=odd>
				<TD>
					<div align="left">对不起，暂无任何评论！</div></TD>
			</TR>
		</TBODY>
	</s:else>
</TABLE>

