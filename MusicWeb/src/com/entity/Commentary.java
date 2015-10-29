package com.entity;

import java.sql.Date;

/**
 *	
 * 2015-3-5����1:46:54
 *
 *MusicWeb.entity.Commentary
 *���� ��
 */
public class Commentary {

	/**
	 * ����ID
	 */
	private	int commentaryId;
	/**
	 * ��������
	 */
	private String commentaryContext;
	/**
	 * ����ʱ��
	 */
	private Date commentaryTime;
	/**
	 * ����ID
	 */
	private int musicId;
	/**
	 * �õ�ID
	 */
	private int songListId;
	/**
	 * ������
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
