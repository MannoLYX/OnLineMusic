package com.entity;

/**
 *	
 * 2015-3-5下午1:42:59
 *
 *MusicWeb.entity.Authority
 *权限 类
 */
public class Authority {

	
	/**
	 * 权限ID
	 */
	private int authorityId;
	/**
	 *权限名称
	 */
	private String authorityName;
	/**
	 * 链接名称
	 */
	private String action;
	/**
	 * 父权限ID
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
