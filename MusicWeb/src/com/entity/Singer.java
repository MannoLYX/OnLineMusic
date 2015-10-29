package com.entity;

/**
 *	
 * 2015-3-10����9:34:19
 *
 *MusicWeb.entity.Singer
 */
public class Singer {
	
	/**
	 * ����ID
	 */
	private int singerId;
	/**
	 * ��������
	 */
	private String singerName;
	/**
	 * ����ͼƬ
	 */
	private String singerPicture;
	/**
	 * ���ֹ���
	 */
	private String singerCountry;
	/**
	 * �����Ա�
	 */
	private String singerGender;
	/**
	 * �����ܻ�ӭ�̶ȣ�1-10��
	 */
	private int popularity;
	/**
	 * ����ʱ��
	 */
	private String times;
	
	public int getSingerId() {
		return singerId;
	}
	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getSingerPicture() {
		return singerPicture;
	}
	public void setSingerPicture(String singerPicture) {
		this.singerPicture = singerPicture;
	}
	public String getSingerCountry() {
		return singerCountry;
	}
	public void setSingerCountry(String singerCountry) {
		this.singerCountry = singerCountry;
	}
	public String getSingerGender() {
		return singerGender;
	}
	public void setSingerGender(String singerGender) {
		this.singerGender = singerGender;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Singer(int singerId, String singerName, String singerPicture,
			String singerCountry, String singerGender, int popularity,
			String times) {
		super();
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerPicture = singerPicture;
		this.singerCountry = singerCountry;
		this.singerGender = singerGender;
		this.popularity = popularity;
		this.times = times;
	}
	public Singer(String singerName, String singerPicture,
			String singerCountry, String singerGender, int popularity,
			String times) {
		super();
		this.singerName = singerName;
		this.singerPicture = singerPicture;
		this.singerCountry = singerCountry;
		this.singerGender = singerGender;
		this.popularity = popularity;
		this.times = times;
	}
	public Singer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
