package com.entity;

/**
 *	
 * 2015-3-5����1:54:59
 *
 *MusicWeb.entity.Music
 *������
 */
public class Music {

	
	/**
	 * ����ID
	 */
	private int musicId;
	/**
	 * ��������
	 */
	private String musicName;
	/**
	 * ����
	 */
	private int singerId;
	/**
	 * ����ͼƬ
	 */
	private String musicPicture;
	/**
	 * ���
	 */
	private String musicLyrics;
	/**
	 * ����˵��
	 */
	private String musicInstruction;
	
	/**
	 * ���ID
	 */
	private int styleId;
	
	
	/**
	 * ����ID
	 */
	private int emotionId;

	/**
	 *����·�� 
	 */
	private String musicPath;

	
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}




	
	
	

	public Music(int musicId, String musicName, int singerId,
			String musicPicture, String musicLyrics, String musicInstruction,
			int styleId, int emotionId, String musicPath) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.singerId = singerId;
		this.musicPicture = musicPicture;
		this.musicLyrics = musicLyrics;
		this.musicInstruction = musicInstruction;
		this.styleId = styleId;
		this.emotionId = emotionId;
		this.musicPath = musicPath;
	}








	public String getMusicPath() {
		return musicPath;
	}








	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}








	


	


	public Music(String musicName, int singerId, String musicPicture,
			String musicLyrics, String musicInstruction, int styleId,
			int emotionId, String musicPath) {
		super();
		this.musicName = musicName;
		this.singerId = singerId;
		this.musicPicture = musicPicture;
		this.musicLyrics = musicLyrics;
		this.musicInstruction = musicInstruction;
		this.styleId = styleId;
		this.emotionId = emotionId;
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


	public int getSingerId() {
		return singerId;
	}


	public void setSingerId(int singerId) {
		this.singerId = singerId;
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

	
	
	
}
