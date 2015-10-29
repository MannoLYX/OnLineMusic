package com.biz;

import java.util.List;

import com.entity.Authority;


/**
 *	
 * 2015-3-6����3:27:12
 *
 *MusicWeb.biz.AuthorityBiz
 */
public interface AuthorityBiz {

	/**
	 * @param authority
	 * @return
	 * ���Ȩ��
	 */
	public boolean addAuthority(Authority authority);
	
	
	/**
	 * @param authorityId
	 * @return
	 * ���� ID ɾ��Ȩ��
	 */
	public boolean deleteAuthority(int authorityId);
	
	/**
	 * @param authority
	 * @return
	 * �޸� Ȩ����Ϣ
	 */
	public boolean updateAuthority(Authority authority);
	
	
	/**
	 * @param authorityId
	 * @return
	 * ͨ��ID ����Ȩ����Ϣ
	 */
	public Authority queryAuthorityById(int authorityId);
	
	
	/**
	 * @return
	 * ����ȫ����Ȩ����Ϣ
	 */
	public List<Authority> queryAuthorityInfo();
	
	
	/**
	 * @return
	 * �û�Ȩ��
	 */
	public List<Authority> queryUserAuthorityInfo();
	
	/**
	 * @return
	 * ����ԱȨ��
	 */
	public List<Authority> queryAdminAuthorityInfo();
	
}
