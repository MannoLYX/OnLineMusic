package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.PersonRoleDao;
import com.entity.PersonRole;
import com.util.DBUtil;



/**
 *	
 * 2015-3-6上午11:42:17
 *
 *MusicWeb.dao.daoImpl.PersonRoleDaoImpl
 *角色类 数据访问接口的实现
 */
public class PersonRoleDaoImpl implements PersonRoleDao{

	DBUtil util = new DBUtil();
	String sql;
	
	
	/* (non-Javadoc)
	 * @see dao.PersonRoleDao#addPersonRole(entity.PersonRole)
	 * 增加 角色信息
	 */
	public boolean addPersonRole(PersonRole pRole) {
		// TODO Auto-generated method stub
		sql="INSERT INTO PERSON_ROLE(ROLENAME, AUTHORITY_ROLE_ID)VALUES(?,?)";
		
		return util.update(sql, pRole.getRoleName(),pRole.getAuthority_RoleId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.PersonRoleDao#deletePersonRole(int)
	 * 删除角色信息
	 */
	public boolean deletePersonRole(int RoleId) {
		// TODO Auto-generated method stub
		sql="DELETE FROM PERSON_ROLE WHERE ROLEID=?";
		
		return util.update(sql,RoleId)>=1;
	}

	/* (non-Javadoc)
	 * @see dao.PersonRoleDao#updatePersonRole(entity.PersonRole)
	 * 更新 角色信息
	 */
	public boolean updatePersonRole(PersonRole pRole) {
		// TODO Auto-generated method stub
		sql="UPDATE PERSON_ROLE SET ROLENAME=?, AUTHORITY_ROLE_ID=? WHERE ROLEID=?";
		return util.update(sql, pRole.getRoleName(),pRole.getAuthority_RoleId(),pRole.getRoleId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.PersonRoleDao#queryPersonRoleInfoById(int)
	 * 根据 RoleID 查找 角色信息
	 */
	public PersonRole queryPersonRoleInfoById(int roleId) {
		// TODO Auto-generated method stub
		sql="SELECT ROLEID,ROLENAME, AUTHORITY_ROLE_ID FROM PERSON_ROLE WHERE ROLEID=?";
		PersonRole pRole=null;
		ResultSet rs = util.Query(sql, roleId);
		
		try {
			while(rs.next())
			{
				pRole = new PersonRole(rs.getInt("roleID"),rs.getString("roleName"),rs.getString("AUTHORITY_ROLE_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return pRole;
	}

	/* (non-Javadoc)
	 * @see dao.PersonRoleDao#queryPerosonRoleInfo()
	 * 遍历 全部 角色信息
	 */
	public List<PersonRole> queryPerosonRoleInfo() {
		// TODO Auto-generated method stub
		sql ="SELECT ROLEID,ROLENAME, AUTHORITY_ROLE_ID FROM PERSON_ROLE ";
		
		ResultSet rs = util.Query(sql);
		List<PersonRole> pRoleList = new ArrayList<PersonRole>();
		
		
		try {
			while(rs.next())
			{
				PersonRole pRole = new PersonRole(rs.getInt("ROLEID"),rs.getString("ROLENAME"),rs.getString("AUTHORITY_ROLE_ID"));
				pRoleList.add(pRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return pRoleList;
	}

	/* (non-Javadoc)
	 * @see com.dao.PersonRoleDao#queryPersonRoleInfoByRoleName(java.lang.String)
	 */
	public PersonRole queryPersonRoleInfoByRoleName(String RoleName) {
		// TODO Auto-generated method stub
		sql="SELECT ROLEID,ROLENAME, AUTHORITY_ROLE_ID FROM PERSON_ROLE WHERE ROLENAME=?";
		PersonRole pRole=null;
		ResultSet rs = util.Query(sql, RoleName);
		
		try {
			while(rs.next())
			{
				pRole = new PersonRole(rs.getInt("roleID"),rs.getString("roleName"),rs.getString("AUTHORITY_ROLE_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return pRole;
	}

}
