package com.entity;

/**
 *	
 * 2015-3-5下午2:00:25
 *
 *MusicWeb.entity.PersonRole
 *角色 类
 */
public class PersonRole {

	/**
	 * 角色ID
	 */
	private int roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 权限角色ID
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
