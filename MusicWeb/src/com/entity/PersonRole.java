package com.entity;

/**
 *	
 * 2015-3-5����2:00:25
 *
 *MusicWeb.entity.PersonRole
 *��ɫ ��
 */
public class PersonRole {

	/**
	 * ��ɫID
	 */
	private int roleId;
	/**
	 * ��ɫ����
	 */
	private String roleName;
	/**
	 * Ȩ�޽�ɫID
	 */
	private String authority_RoleId;
	
	
	
	
	
	
	public PersonRole(String roleName, String authority_RoleId) {
		super();
		this.roleName = roleName;
		this.authority_RoleId = authority_RoleId;
	}
	public PersonRole(int roleId, String roleName, String authority_RoleId) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.authority_RoleId = authority_RoleId;
	}
	public PersonRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getAuthority_RoleId() {
		return authority_RoleId;
	}
	public void setAuthority_RoleId(String authority_RoleId) {
		this.authority_RoleId = authority_RoleId;
	}
	
	
	

}
