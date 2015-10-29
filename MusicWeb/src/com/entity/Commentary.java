package com.entity;

import java.sql.Date;

/**
 *	
 * 2015-3-5下午1:46:54
 *
 *MusicWeb.entity.Commentary
 *评论 类
 */
public class Commentary {

	/**
	 * 评论ID
	 */
	private	int commentaryId;
	/**
	 * 评论内容
	 */
	private String commentaryContext;
	/**
	 * 评论时间
	 */
	private Date commentaryTime;
	/**
	 * 歌曲ID
	 */
	private int musicId;
	/**
	 * 悦单ID
	 */
	private int songListId;
	/**
	 * 评论者
	 */
	private int memberId;
	
	
	
	
	
	
	
	
	public Commentary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	public Commentary(String commentaryContext, Date commentaryTime,
			int musicId, int songListId, int memberId) {
		super();
		this.commentaryContext = commentaryContext;
		this.commentaryTime = commentaryTime;
		this.musicId = musicId;
		this.songListId = songListId;
		this.memberId = memberId;
	}




	public Commentary(int commentaryId, String commentaryContext,
			Date commentaryTime, int musicId, int songListId, int memberId) {
		super();
		this.commentaryId = commentaryId;
		this.commentaryContext = commentaryContext;
		this.commentaryTime = commentaryTime;
		this.musicId = musicId;
		this.songListId = songListId;
		this.memberId = memberId;
	}




	public int getCommentaryId() {
		return commentaryId;
	}
	public void setCommentaryId(int commentaryId) {
		this.commentaryId = commentaryId;
	}
	public String getCommentaryContext() {
		return commentaryContext;
	}
	public void setCommentaryContext(String commentaryContext) {
		this.commentaryContext = commentaryContext;
	}
	public Date getCommentaryTime() {
		return commentaryTime;
	}
	public void setCommentaryTime(Date commentaryTime) {
		this.commentaryTime = commentaryTime;
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
	
	
	
	
}
