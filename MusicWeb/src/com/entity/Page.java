package com.entity;

/**
 *	
 * 2015-4-2����8:59:15
 *
 *MusicWeb.com.page.Page
 */
public class Page<T> {

	/**
	 * �ܼ�¼��
	 */
	private int totalRecord;
	/**
	 * ÿҳ��ʾ����
	 */
	private int limitPage;
	
	/**
	 * ��ǰҳ
	 */
	private int nowPage;
	
	/**
	 * ��ҳ��
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
