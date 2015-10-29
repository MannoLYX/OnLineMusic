package com.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dao.daoImpl.AuthorityDaoImpl;
import com.entity.Authority;


/**
 *	
 * 2015-3-6下午3:02:44
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
	 * 增加权限
	 */
	@Test
	public void Test_addAuthority()
	{
		Authority authority = new Authority();
		
		
		authority.setAuthorityName("权限管理");
		authority.setAction("friend");
		authority.setAuthority_parentId(2);
		
		boolean b =daoImpl.addAuthority(authority);
		
		if(b)
		{
			System.out.println("添加成功");
		}else
		{
			System.out.println("添加失败");
		}
	}
	
	
	/**
	 * 删除权限
	 */
	@Test
	public void Test_deleteAuthority()
	{
		boolean b = daoImpl.deleteAuthority(7);
		if(b)
		{
			System.out.println("删除成功");
		}else
		{
			System.out.println("删除失败");
		}
	}
	
	/**
	 * 修改
	 */
	@Test
	public void Test_updateAuthority()
	{
		Authority authority = new Authority();
		
		authority.setAuthorityId(1);
		authority.setAuthorityName("好友管理");
		authority.setAction("friend");
		authority.setAuthority_parentId(2);
		
		boolean b =daoImpl.updateAuthority(authority);
		
		if(b)
		{
			System.out.println("修改成功");
		}else
		{
			System.out.println("修改失败");
		}
	}
	
	
	/**
	 * 通过ID 查找权限
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
	 * 遍历全部 信息
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
