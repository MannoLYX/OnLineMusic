package com.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dao.daoImpl.PersonRoleDaoImpl;
import com.entity.PersonRole;


/**
 *	
 * 2015-3-6����1:42:05
 *
 *MusicWeb.Test.PersonRoleTest
 *PersonRoleDaoImpl ������
 */
public class PersonRoleTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * ���� ��ɫ��Ϣ
	 */
	@Test
	public void Tet_addPersonRole()
	{
		PersonRoleDaoImpl prdi = new PersonRoleDaoImpl();
		
		PersonRole pRole = new PersonRole("��Ա","1");
		
		boolean b =prdi.addPersonRole(pRole);
		
		if(b)
		{
			System.out.println("���ӳɹ�");
		}else
		{
			System.out.println("����ʧ��");
		}
	}
	
	
	
	
	
	
	/**
	 * ɾ��
	 */
	@Test
	public void Test_deletePersonRole()
	{
		PersonRoleDaoImpl prdi = new PersonRoleDaoImpl();
		boolean b = prdi.deletePersonRole(4);
		
		if(b)
		{
			System.out.println("ɾ���ɹ�");
		}else
		{
			System.out.println("ɾ��ʧ��");
		}
	}
	
	
	
	
	/**
	 * ���� ���»�Ա��Ϣ
	 */
	@Test
	public void Test_updatePersonRole()
	{
		PersonRoleDaoImpl prdi = new PersonRoleDaoImpl();
		PersonRole pRole = new PersonRole();
		
		pRole.setRoleId(2);
		pRole.setRoleName("��ͨ��Ա");
		pRole.setAuthority_RoleId("1,2");
		
		boolean b= prdi.updatePersonRole(pRole);
		if(b)
		{
			System.out.println("���³ɹ�");
		}else
		{
			System.out.println("����ʧ��");
		}
	}
	
	
	/**
	 * ���� ͨ��roleId��ѯ��ɫ��Ϣ
	 */
	@Test
	public void Test_queryPersonRoleInfoById()
	{
		PersonRoleDaoImpl prdi = new PersonRoleDaoImpl();
		PersonRole pRole = new PersonRole();
		
		pRole = prdi.queryPersonRoleInfoById(2);
		System.out.println(pRole.getRoleId()+","+pRole.getRoleName()+","+pRole.getAuthority_RoleId());
		
	}
	
	
	/**
	 * ���� ����ȫ����ɫ��Ϣ
	 */
	@Test
	public void Test_queryPerosonRoleInfo()
	{
		PersonRoleDaoImpl prdi = new PersonRoleDaoImpl();
		
		List<PersonRole> pRoleList = new ArrayList<PersonRole>();
		
		pRoleList = prdi.queryPerosonRoleInfo();
		
		for (PersonRole personRole : pRoleList) {
			System.out.println(personRole.getRoleId()+","+personRole.getRoleName()+","+personRole.getAuthority_RoleId());
		}
	}

}
