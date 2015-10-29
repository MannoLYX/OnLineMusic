package com.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dao.daoImpl.AuthorityDaoImpl;
import com.entity.Authority;


/**
 *	
 * 2015-3-6����3:02:44
 *
 *MusicWeb.Test.AuthorityTest
 */
public class AuthorityTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	AuthorityDaoImpl daoImpl = new AuthorityDaoImpl();
	
	
	/**
	 * ����Ȩ��
	 */
	@Test
	public void Test_addAuthority()
	{
		Authority authority = new Authority();
		
		
		authority.setAuthorityName("Ȩ�޹���");
		authority.setAction("friend");
		authority.setAuthority_parentId(2);
		
		boolean b =daoImpl.addAuthority(authority);
		
		if(b)
		{
			System.out.println("��ӳɹ�");
		}else
		{
			System.out.println("���ʧ��");
		}
	}
	
	
	/**
	 * ɾ��Ȩ��
	 */
	@Test
	public void Test_deleteAuthority()
	{
		boolean b = daoImpl.deleteAuthority(7);
		if(b)
		{
			System.out.println("ɾ���ɹ�");
		}else
		{
			System.out.println("ɾ��ʧ��");
		}
	}
	
	/**
	 * �޸�
	 */
	@Test
	public void Test_updateAuthority()
	{
		Authority authority = new Authority();
		
		authority.setAuthorityId(1);
		authority.setAuthorityName("���ѹ���");
		authority.setAction("friend");
		authority.setAuthority_parentId(2);
		
		boolean b =daoImpl.updateAuthority(authority);
		
		if(b)
		{
			System.out.println("�޸ĳɹ�");
		}else
		{
			System.out.println("�޸�ʧ��");
		}
	}
	
	
	/**
	 * ͨ��ID ����Ȩ��
	 */
	@Test
	public void Test_queryAuthorityById()
	{
		Authority authority = new Authority();
		authority= daoImpl.queryAuthorityById(2);
		
		System.out.println(authority.getAuthorityId()+","+authority.getAuthorityName()+","+authority.getAuthority_parentId()+","+
				authority.getAuthority_parentId());
	}
	
	
	/**
	 * ����ȫ�� ��Ϣ
	 */
	@Test
	public void Test_queryAuthorityInfo()
	{
		List<Authority> aList = new ArrayList<Authority>();
		
		aList =  daoImpl.queryAuthorityInfo();
		
		for (Authority authority : aList) {
			System.out.println(authority.getAuthorityId()+","+authority.getAuthorityName()+","+authority.getAuthority_parentId()+","+
					authority.getAuthority_parentId());
		}
	}
}
