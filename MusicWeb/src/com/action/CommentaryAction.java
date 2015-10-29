package com.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.CommentaryBiz;
import com.biz.MemberUserBiz;
import com.biz.bizImpl.CommentaryBizImpl;
import com.biz.bizImpl.MemberUserBizImpl;
import com.entity.Commentary;
import com.entity.CommentaryInfo;
import com.util.DBUtil;

/**
 * 
 *         2015-3-25上午9:09:59
 * 
 *         MusicWeb.com.action.CommentaryAction
 */
public class CommentaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Commentary comm;
	private CommentaryInfo commInfo;
	private int commentaryId;
	private int musicId;
	private int songListId;
	private int memberId;

	public Commentary getComm() {
		return comm;
	}

	public void setComm(Commentary comm) {
		this.comm = comm;
	}

	public CommentaryInfo getCommInfo() {
		return commInfo;
	}

	public void setCommInfo(CommentaryInfo commInfo) {
		this.commInfo = commInfo;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public int getSongListId() {
		return songListId;
	}

	public void setSongListId(int songListId) {
		this.songListId = songListId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Commentary getCommentary() {
		return comm;
	}

	public void setCommentary(Commentary comm) {
		this.comm = comm;
	}

	public int getCommentaryId() {
		return commentaryId;
	}

	public void setCommentaryId(int commentaryId) {
		this.commentaryId = commentaryId;
	}

	CommentaryBiz commentarybiz = new CommentaryBizImpl();

	MemberUserBiz userbiz = new MemberUserBizImpl();

	/**
	 * @return 增
	 */
	public String addCommentary() {
		String commtext = req.getParameter("commentaryContext");

		int memberId = Integer.valueOf(req.getParameter("memberId"));
		int musicId = Integer.valueOf(req.getParameter("musicId"));

		java.util.Date curDate = new java.util.Date();

		/*
		 * SimpleDateFormat df = new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 * System.out.println(df.format(curDate.getTime()));// new
		 * Date()为获取当前系统时间
		 */
		java.sql.Date curDateCommentary = new java.sql.Date(curDate.getTime());

		comm = new Commentary(commtext, curDateCommentary, musicId, 0, memberId);

		if (commentarybiz.addCommentary(comm) && userbiz.addIntegral(memberId))// 增加评论、积分
			return "addCommentary";
		else
			return "error";

	}

	/**
	 * @return 删
	 */
	public String deleteCommentary() {
		if (commentarybiz.deleteCommentary(commentaryId))
			return "deleteCommentary";
		else
			return "error";
	}

	public String AdminDeleteCommentary() {
		if (commentarybiz.deleteCommentary(commentaryId))
			return "AdminDeleteCommentary";
		else
			return "error";
	}

	/**
	 * @return 管理员根据commentaryId 查找评论
	 */
	public String queryCommentaryByCommId() {
		commInfo = commentarybiz.queryCommentaryByCommId(commentaryId);

		int check = 3;
		req.setAttribute("check", check);

		return "queryCommentaryByCommId";
	}

	/**
	 * @return 管理员根据commentaryId 查找评论
	 */
	public String queryMusicCommentaryByCommId() {
		commInfo = commentarybiz.queryCommentaryByCommId(commentaryId);

		int check = 4;
		req.setAttribute("check", check);

		return "queryMusicCommentaryByCommId";
	}

	/**
	 * @return 管理员根据commentaryId 查找评论
	 */
	public String queryMusicCommentaryByCommIdToUpdate() {
		commInfo = commentarybiz.queryCommentaryByCommId(commentaryId);

		int update = 5;
		req.setAttribute("update", update);

		return "queryMusicCommentaryByCommIdToUpdate";
	}

	/**
	 * @return 管理员根据commentaryId 查找评论
	 */
	public String querySongListCommentaryByCommId() {
		commInfo = commentarybiz.querySongListCommentaryByCommId(commentaryId);

		int check = 5;
		req.setAttribute("check", check);

		return "querySongListCommentaryByCommId";
	}

	/**
	 * @return 通过musicId查找 某歌曲的评论
	 */
	public String queryCommentaryByMusicIdByAll() {
		List<CommentaryInfo> commentaryInfoBymusic = commentarybiz
				.queryCommentaryByMusicId(musicId);

		app.setAttribute("commentaryInfoBymusic", commentaryInfoBymusic);

		return "queryCommentaryByMusicIdByAll";
	}

	/**
	 * @return 通过musicId查找 某歌曲的评论
	 */
	public String queryCommentaryByMusicId() {
		List<CommentaryInfo> commentaryInfoBymusic = commentarybiz
				.queryCommentaryByMusicId(musicId);

		app.setAttribute("commentaryInfoBymusic", commentaryInfoBymusic);

		return "queryCommentaryByMusicId";
	}

	/**
	 * @return 通过songListId查找 某悦单的评论
	 */
	public String queryCommentaryBySongListId() {
		List<CommentaryInfo> commentaryInfoBysongList = commentarybiz
				.queryCommentaryBySongListId(songListId);

		app.setAttribute("commentaryInfoBysongList", commentaryInfoBysongList);

		return "queryCommentaryBySongListId";
	}

	/**
	 * @return 通过memberId查找 某用户的全部评论
	 */
	public String queryCommentaryByMemberUserId() {
		List<CommentaryInfo> commentaryInfoBymember = commentarybiz
				.queryCommentaryByMemberUserId(memberId);

		app.setAttribute("commentaryInfoBymember", commentaryInfoBymember);

		int c = 2;
		req.setAttribute("c", c);

		return "queryCommentaryByMemberUserId";
	}

	/**
	 * @return 查询全部用户的评论信息
	 */
	public String queryCommentaryInfoByAll() {
		List<CommentaryInfo> allCommentaryInfo = commentarybiz
				.queryCommentaryInfoByAll();

		app.setAttribute("allCommentaryInfo", allCommentaryInfo);

		int a = 7;
		req.setAttribute("a", a);

		return "queryCommentaryInfoByAll";
	}

	/**
	 * @return 某用户的歌曲评论
	 */
	public String queryMusicCommentaryByUserId() {
		List<CommentaryInfo> MusicCommentaryInfo = commentarybiz
				.queryMusicCommentaryByUserId(memberId);

		app.setAttribute("MusicCommentaryInfo", MusicCommentaryInfo);

		int c = 0;
		req.setAttribute("c", c);

		return "queryMusicCommentaryByUserId";
	}

	/**
	 * @return 某用户的悦单评论
	 */
	public String querySongListCommentaryByUserId() {
		List<CommentaryInfo> SongListCommentaryInfo = commentarybiz
				.querySongListCommentaryByUserId(memberId);

		app.setAttribute("SongListCommentaryInfo", SongListCommentaryInfo);

		int c = 1;
		req.setAttribute("c", c);

		return "querySongListCommentaryByUserId";
	}

	/**
	 * @return 全部的歌曲评论
	 */
	public String queryAllMUsicCommentaryInfo() {
		List<CommentaryInfo> AllMusicCommentaryInfo = commentarybiz
				.queryAllMUsicCommentaryInfo();

		app.setAttribute("AllMusicCommentaryInfo", AllMusicCommentaryInfo);

		int a = 5;
		req.setAttribute("a", a);

		return "queryAllMUsicCommentaryInfo";
	}

	/**
	 * @return 全部的悦单评论
	 */
	public String queryAllSongListCommentaryInfo() {
		List<CommentaryInfo> AllSongListCommentaryInfo = commentarybiz
				.queryAllSongListCommentaryInfo();

		app.setAttribute("AllSongListCommentaryInfo", AllSongListCommentaryInfo);

		int a = 6;
		req.setAttribute("a", a);
		return "queryAllSongListCommentaryInfo";
	}

	/**
	 * @return 模糊查询
	 */
	public String fuzzyQueryCommentaryInfo() {

		String searchName = req.getParameter("searchName");

		String sql = "SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,m.musicname FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM "
				+ "WHERE comm.memberid = mem.memberid and comm.musicid = M.musicid  and m.musicname like '%"
				+ searchName + "%'  order by comm.commentary_time Asc";
		DBUtil util = new DBUtil();
		ResultSet rs = util.Query(sql);

		List<CommentaryInfo> fuzzyCommentaryList = new ArrayList<CommentaryInfo>();

		try {
			while (rs.next()) {
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs
						.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setMusicName(rs.getString("musicname"));
				commInfo.setMemberName(rs.getString("membername"));

				fuzzyCommentaryList.add(commInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		app.setAttribute("fuzzyCommentaryList", fuzzyCommentaryList);

		int c = 3;
		req.setAttribute("c", c);

		return "fuzzyQueryCommentaryInfo";

	}
}
