<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="js/css/thickbox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/js/jquery.js"></script>
<script type="text/javascript" src="js/js/thickbox.js"></script>
<script type="text/javascript" src="js/js/nicejforms.js"></script>

<s:if test="#application.allmusicListPage.size()!=0">
<s:iterator value="#application.allmusicListPage" status="stu" id="music">
	<div class="post">
		<div class="entry">
				 <h2> 歌名：	<a href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }" >${music.musicName }</a> </h2>
					
					<object type="application/x-shockwave-flash"
						data="player/audioplayer.swf" width="290" height="24"
						id="audioplayer${music.musicId }">
						<param name="movie" value="player/audioplayer.swf" />
						<param name="FlashVars"
							value="playerID=${music.musicId }&soundFile=${music.musicPath }" />
						<param name="quality" value="high" />
						<param name="menu" value="false" />
						<param name="wmode" value="transparent" />
					</object>
					
					<img alt="${music.musicId }" src="${music.musicPicture }" width="200px" height="80px" style="float: right;">
					<br /> 歌手： ${music.singerName }<br />风格：${music.styleName} 
					<br/> 歌曲说明：${music.musicInstruction }
		</div>
		<p class="meta">
		
			<a href="music_queryMusicInfoBymusicId.action?musicId=${music.musicId }" class="more" target="_blank">查看详情</a> <b>|</b>

		</p>
	</div>
	</s:iterator>
</s:if>
<s:else>
	<div class="post">暂无任何歌曲，快来分享给大家喔~！</div>
</s:else>