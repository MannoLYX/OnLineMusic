package com.dao;

import java.util.List;

import com.entity.PersonRole;


/**
 *	
 * 2015-3-6上午11:31:14
 *
 *MusicWeb.dao.PersonRole
 *数据访问接口
 */
public interface PersonRoleDao {

	/**
	 * @return
	 * 添加 角色信息
	 */
	public boolean addPersonRole(PersonRole pRole);
	
	/**
	 * @return
	 * 删除 角色信息
	 */
	public boolean deletePersonRole(int RoleId);
	
	/**
	 * @param pRole
	 * @return
	 * 修改 会员信息
	 */
	public boolean updatePersonRole(PersonRole pRole);
	
	
	/**
	 * @param roleId
	 * @return
	 * 通过RoleId 查询数据
	 */
	public PersonRole queryPersonRoleInfoById(int roleId);
	
	
	/**
	 * @return
	 * 遍历 全部的 角色信息
	 */
	public List<PersonRole> queryPerosonRoleInfo();
	
	/**
	 * @param RoleName
	 * @return
	 * 通过角色名 查询出角色信息
	 */
	public PersonRole queryPersonRoleInfoByRoleName(String RoleName);

	
}
