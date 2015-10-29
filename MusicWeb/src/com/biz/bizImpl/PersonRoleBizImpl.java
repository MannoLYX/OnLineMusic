package com.biz.bizImpl;

import java.util.List;

import com.biz.PersonRoleBiz;
import com.dao.PersonRoleDao;
import com.dao.daoImpl.PersonRoleDaoImpl;
import com.entity.PersonRole;



/**
 *	
 * 2015-3-6下午2:15:22
 *
 *MusicWeb.biz.bizImpl.PersonRoleBizImpl
 *接口的实现
 */
public class PersonRoleBizImpl  implements PersonRoleBiz{

	PersonRoleDao dao = new PersonRoleDaoImpl();
	
	public boolean addPersonRole(PersonRole pRole) {
		// TODO Auto-generated method stub
		return dao.addPersonRole(pRole);
	}

	public boolean deletePersonRole(int RoleId) {
		// TODO Auto-generated method stub
		return dao.deletePersonRole(RoleId);
	}

	public boolean updatePersonRole(PersonRole pRole) {
		// TODO Auto-generated method stub
		return dao.updatePersonRole(pRole);
	}

	public PersonRole queryPersonRoleInfoById(int roleId) {
		// TODO Auto-generated method stub
		return dao.queryPersonRoleInfoById(roleId);
	}

	public List<PersonRole> queryPerosonRoleInfo() {
		// TODO Auto-generated method stub
		return dao.queryPerosonRoleInfo();
	}

	public PersonRole queryPersonRoleInfoByRoleName(String RoleName) {
		// TODO Auto-generated method stub
		return dao.queryPersonRoleInfoByRoleName(RoleName);
	}

}
