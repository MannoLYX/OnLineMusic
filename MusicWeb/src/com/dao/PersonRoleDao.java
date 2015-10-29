package com.dao;

import java.util.List;

import com.entity.PersonRole;


/**
 *	
 * 2015-3-6����11:31:14
 *
 *MusicWeb.dao.PersonRole
 *���ݷ��ʽӿ�
 */
public interface PersonRoleDao {

	/**
	 * @return
	 * ��� ��ɫ��Ϣ
	 */
	public boolean addPersonRole(PersonRole pRole);
	
	/**
	 * @return
	 * ɾ�� ��ɫ��Ϣ
	 */
	public boolean deletePersonRole(int RoleId);
	
	/**
	 * @param pRole
	 * @return
	 * �޸� ��Ա��Ϣ
	 */
	public boolean updatePersonRole(PersonRole pRole);
	
	
	/**
	 * @param roleId
	 * @return
	 * ͨ��RoleId ��ѯ����
	 */
	public PersonRole queryPersonRoleInfoById(int roleId);
	
	
	/**
	 * @return
	 * ���� ȫ���� ��ɫ��Ϣ
	 */
	public List<PersonRole> queryPerosonRoleInfo();
	
	/**
	 * @param RoleName
	 * @return
	 * ͨ����ɫ�� ��ѯ����ɫ��Ϣ
	 */
	public PersonRole queryPersonRoleInfoByRoleName(String RoleName);

	
}
