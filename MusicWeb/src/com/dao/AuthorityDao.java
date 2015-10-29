package com.dao;

import java.util.List;

import com.entity.Authority;


/**
 *	
 * 2015-3-6下午2:18:28
 *
 *MusicWeb.dao.AuthorityDao
 *权限 数据访问 接口
 */
public interface AuthorityDao {

	
	/**
	 * @param authority
	 * @return
	 * 添加权限
	 */
	public boolean addAuthority(Authority authority);
	
	
	/**
	 * @param authorityId
	 * @return
	 * 根据 ID 删除权限
	 */
	public boolean deleteAuthority(int authorityId);
	
	/**
	 * @param authority
	 * @return
	 * 修改 权限信息
	 */
	public boolean updateAuthority(Authority authority);
	
	
	/**
	 * @param authorityId
	 * @return
	 * 通过ID 查找权限信息
	 */
	public Authority queryAuthorityById(int authorityId);
	
	
	/**
	 * @return
	 * 遍历全部的权限信息
	 */
	public List<Authority> queryAuthorityInfo();
	
	/**
	 * @return
	 * 用户权限
	 */
	public List<Authority> queryUserAuthorityInfo();
	
	/**
	 * @return
	 * 管理员权限
	 */
	public List<Authority> queryAdminAuthorityInfo();
	
}
