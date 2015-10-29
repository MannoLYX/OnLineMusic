package com.entity;

import java.sql.Date;

/**
 *	
 * 2015-3-5下午2:04:50
 *
 *MusicWeb.entity.SongList
 *悦单 类
 */
public class SongList {

	
	/**
	 * 悦单ID
	 */
	private int songListId;
	/**
	 * 悦单名称
	 */
	private String songListName;
	/**
	 * 悦单介绍
	 */
	private String songListInstryction;
	/**
	 * 悦单图片
	 */
	private String songListPicture;
	/**
	 * 悦单创建时间
	 */
	private Date songListCreateTime;
	/**
	 * 创建者
	 */
	private int memberId;
	/**
	 * 歌曲
	 */
	private int musicId;
	
	
	public SongList(int songListId, String songListName,
			String songListInstryction, String songListPicture,
			Date songListCreateTime, int memberId, int musicId) {
		super();
		this.songListId = songListId;
		this.songListName = songListName;
		this.songListInstryction = songListInstryction;
		this.songListPicture = songListPicture;
		this.songListCreateTime = songListCreateTime;
		this.memberId = memberId;
		this.musicId = musicId;
	}
	
	
	
	public SongList(String songListName, String songListInstryction,
			String songListPicture, Date songListCreateTime, int memberId,
			int musicId) {
		super();
		this.songListName = songListName;
		this.songListInstryction = songListInstryction;
		this.songListPicture = songListPicture;
		this.songListCreateTime = songListCreateTime;
		this.memberId = memberId;
		this.musicId = musicId;
	}



	public SongList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getSongListId() {
		return songListId;
	}
	public void setSongListId(int songListId) {
		this.songListId = songListId;
	}
	public String getSongListName() {
		return songListName;
	}
	public void setSongListName(String songListName) {
		this.songListName = songListName;
	}
	public String getSongListInstryction() {
		return songListInstryction;
	}
	public void setSongListInstryction(String songListInstryction) {
		this.songListInstryction = songListInstryction;
	}
	public String getSongListPicture() {
		return songListPicture;
	}
	public void setSongListPicture(String songListPicture) {
		this.songListPicture = songListPicture;
	}
	public Date getSongListCreateTime() {
		return songListCreateTime;
	}
	public void setSongListCreateTime(Date songListCreateTime) {
		this.songListCreateTime = songListCreateTime;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	
	
	

}
