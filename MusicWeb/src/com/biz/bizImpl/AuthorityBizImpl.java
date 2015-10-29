package com.biz.bizImpl;

import java.util.List;

import com.biz.AuthorityBiz;
import com.dao.AuthorityDao;
import com.dao.daoImpl.AuthorityDaoImpl;
import com.entity.Authority;



/**
 *	
 * 2015-3-6ÏÂÎç3:28:22
 *
 *MusicWeb.biz.bizImpl.AuthorityBizImpl
 */
public class AuthorityBizImpl implements AuthorityBiz {

	AuthorityDao dao = new AuthorityDaoImpl();
	
	public boolean addAuthority(Authority authority) {
		// TODO Auto-generated method stub
		return dao.addAuthority(authority);
	}

	public boolean deleteAuthority(int authorityId) {
		// TODO Auto-generated method stub
		return dao.deleteAuthority(authorityId);
	}

	public boolean updateAuthority(Authority authority) {
		// TODO Auto-generated method stub
		return dao.updateAuthority(authority);
	}

	public Authority queryAuthorityById(int authorityId) {
		// TODO Auto-generated method stub
		return dao.queryAuthorityById(authorityId);
	}

	public List<Authority> queryAuthorityInfo() {
		// TODO Auto-generated method stub
		return dao.queryAuthorityInfo();
	}

	public List<Authority> queryUserAuthorityInfo() {
		// TODO Auto-generated method stub
		return dao.queryUserAuthorityInfo();
	}

	public List<Authority> queryAdminAuthorityInfo() {
		// TODO Auto-generated method stub
		return dao.queryAdminAuthorityInfo();
	}

}
