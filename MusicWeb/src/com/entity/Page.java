package com.entity;

/**
 *	
 * 2015-4-2上午8:59:15
 *
 *MusicWeb.com.page.Page
 */
public class Page<T> {

	/**
	 * 总记录数
	 */
	private int totalRecord;
	/**
	 * 每页显示条数
	 */
	private int limitPage;
	
	/**
	 * 当前页
	 */
	private int nowPage;
	
	/**
	 * 总页数
	 */
	private int totalPage;

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getLimitPage() {
		return limitPage;
	}

	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Page(int totalRecord, int limitPage, int nowPage, int totalPage) {
		super();
		this.totalRecord = totalRecord;
		this.limitPage = limitPage;
		this.nowPage = nowPage;
		this.totalPage = totalPage;
	}

	public Page() {
		super();
	}
	
	
	

}
