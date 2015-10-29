package com.entity;

/**
 *	
 * 2015-3-10ÉÏÎç9:51:25
 *
 *MusicWeb.entity.EmotionCategory
 */
public class EmotionCategory {

	private int emotionId;
	private String emotionName;
	
	public EmotionCategory(int emotionId, String emotionName) {
		super();
		this.emotionId = emotionId;
		this.emotionName = emotionName;
	}

	public EmotionCategory(String emotionName) {
		super();
		this.emotionName = emotionName;
	}

	public EmotionCategory() {
		super();
	}

	public int getEmotionId() {
		return emotionId;
	}

	public void setEmotionId(int emotionId) {
		this.emotionId = emotionId;
	}

	public String getEmotionName() {
		return emotionName;
	}

	public void setEmotionName(String emotionName) {
		this.emotionName = emotionName;
	}
	
	
}
