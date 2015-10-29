package com.entity;

import java.sql.Date;

/**
 *	
 * 2015-3-9����11:46:17
 *
 *MusicWeb.entity.CommentaryInfo
 */
public class CommentaryInfo {

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
	 * ��������
	 */
	private String musicName;
	/**
	 * �õ�����
	 */
	private String songListName;
	/**
	 * ������
	 */
	private String memberName;
	
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



	public CommentaryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	



	
	public CommentaryInfo(int commentaryId, String commentaryContext,
			Date commentaryTime, String songListName, String memberName,
			int musicId, int songListId, int memberId) {
		super();
		this.commentaryId = commentaryId;
		this.commentaryContext = commentaryContext;
		this.commentaryTime = commentaryTime;
		this.songListName = songListName;
		this.memberName = memberName;
		this.musicId = musicId;
		this.songListId = songListId;
		this.memberId = memberId;
	}



	public CommentaryInfo(int commentaryId, String commentaryContext,
			Date commentaryTime, String musicName, String songListName,
			String memberName, int musicId, int songListId, int memberId) {
		super();
		this.commentaryId = commentaryId;
		this.commentaryContext = commentaryContext;
		this.commentaryTime = commentaryTime;
		this.musicName = musicName;
		this.songListName = songListName;
		this.memberName = memberName;
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
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getSongListName() {
		return songListName;
	}
	public void setSongListName(String songListName) {
		this.songListName = songListName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	
}
