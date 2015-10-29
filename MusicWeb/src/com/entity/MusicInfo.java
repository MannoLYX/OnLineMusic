package com.entity;

/**
 *	
 * 2015-3-9下午5:28:03
 *
 *MusicWeb.entity.MusicInfo
 */
public class MusicInfo {
	
	/**
	 * 歌曲ID
	 */
	private int musicId;
	/**
	 * 歌曲名称
	 */
	private String musicName;
	/**
	 * 歌手
	 */
	private String singerName;
	/**
	 * 歌曲图片
	 */
	private String musicPicture;
	/**
	 * 歌词
	 */
	private String musicLyrics;
	/**
	 * 歌曲说明
	 */
	private String musicInstruction;
	
	/**
	 * 风格ID
	 */
	private int styleId;
	
	
	/**
	 * 心情ID
	 */
	private int emotionId;
	/**
	 * 风格
	 */
	private String styleName;
	
	
	/**
	 * 心情
	 */
	private String emotionName;

	
	/**
	 *音乐路径 
	 */
	private String musicPath;

	
	
	
	

	public String getMusicPath() {
		return musicPath;
	}


	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}


	public MusicInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	public MusicInfo(int musicId, String musicName, String singerName,
			String musicPicture, String musicLyrics, String musicInstruction,
			int styleId, int emotionId, String styleName, String emotionName,
			String musicPath) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.singerName = singerName;
		this.musicPicture = musicPicture;
		this.musicLyrics = musicLyrics;
		this.musicInstruction = musicInstruction;
		this.styleId = styleId;
		this.emotionId = emotionId;
		this.styleName = styleName;
		this.emotionName = emotionName;
		this.musicPath = musicPath;
	}


	public int getStyleId() {
		return styleId;
	}


	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}


	public int getEmotionId() {
		return emotionId;
	}


	public void setEmotionId(int emotionId) {
		this.emotionId = emotionId;
	}


	public MusicInfo(int musicId, String musicName, String singerName,
			String musicPicture, String musicLyrics, String musicInstruction,
			String styleName, String emotionName, String musicPath) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.singerName = singerName;
		this.musicPicture = musicPicture;
		this.musicLyrics = musicLyrics;
		this.musicInstruction = musicInstruction;
		this.styleName = styleName;
		this.emotionName = emotionName;
		this.musicPath = musicPath;
	}


	public int getMusicId() {
		return musicId;
	}


	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}


	public String getMusicName() {
		return musicName;
	}


	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}


	public String getSingerName() {
		return singerName;
	}


	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}


	public String getMusicPicture() {
		return musicPicture;
	}


	public void setMusicPicture(String musicPicture) {
		this.musicPicture = musicPicture;
	}


	public String getMusicLyrics() {
		return musicLyrics;
	}


	public void setMusicLyrics(String musicLyrics) {
		this.musicLyrics = musicLyrics;
	}


	public String getMusicInstruction() {
		return musicInstruction;
	}


	public void setMusicInstruction(String musicInstruction) {
		this.musicInstruction = musicInstruction;
	}


	public String getStyleName() {
		return styleName;
	}


	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}


	public String getEmotionName() {
		return emotionName;
	}


	public void setEmotionName(String emotionName) {
		this.emotionName = emotionName;
	}
	
	
	
	
}
