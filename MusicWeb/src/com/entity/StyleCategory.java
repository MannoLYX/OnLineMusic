package com.entity;

/**
 *	
 * 2015-3-10ÉÏÎç9:49:10
 *
 *MusicWeb.entity.StyleCategory
 */
public class StyleCategory {

	private int styleId;
	private String styleName;
	
	public int getStyleId() {
		return styleId;
	}
	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	public StyleCategory(int styleId, String styleName) {
		super();
		this.styleId = styleId;
		this.styleName = styleName;
	}
	public StyleCategory(String styleName) {
		super();
		this.styleName = styleName;
	}
	public StyleCategory() {
		super();
	}
	
	
}
