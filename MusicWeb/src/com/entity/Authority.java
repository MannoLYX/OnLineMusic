package com.entity;

/**
 *	
 * 2015-3-5����1:42:59
 *
 *MusicWeb.entity.Authority
 *Ȩ�� ��
 */
public class Authority {

	
	/**
	 * Ȩ��ID
	 */
	private int authorityId;
	/**
	 *Ȩ������
	 */
	private String authorityName;
	/**
	 * ��������
	 */
	private String action;
	/**
	 * ��Ȩ��ID
	 */
	private int authority_parentId;
	
	
	
	
	
	
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authority(int authorityId, String authorityName, String action,
			int authority_parentId) {
		super();
		this.authorityId = authorityId;
		this.authorityName = authorityName;
		this.action = action;
		this.authority_parentId = authority_parentId;
	}
	
	public int getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getAuthority_parentId() {
		return authority_parentId;
	}
	public void setAuthority_parentId(int authority_parentId) {
		this.authority_parentId = authority_parentId;
	}
	
	
	
}
