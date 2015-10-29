package com.biz;

import java.util.List;

import com.entity.Authority;


/**
 *	
 * 2015-3-12上午9:59:54
 *
 *MusicWeb.biz.RoleMenuBiz
 *显示菜单
 */
public interface RoleMenuBiz { 
	
	
	/**
	 * @return
	 * 遍历出用户的权限（菜单）
	 */
	public List<Authority> checkMenu(int userRoleId);
	
	
	
	/**
	 * @param authId
	 * @return
	 * 根据 权限ID 查找权限信息
	 */
	public Authority showMenu(int authId);
	
	
	/**
	 * @param parentId
	 * @return
	 * 通过 父权限ID获取 权限信息
	 */
	public List<Authority> GetChildMenu(int parentId);
}
