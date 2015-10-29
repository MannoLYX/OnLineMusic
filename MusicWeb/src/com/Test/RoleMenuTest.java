package com.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.biz.RoleMenuBiz;
import com.biz.bizImpl.RoleMenuBizImpl;
import com.entity.Authority;



/**
 *	
 * 2015-3-12ÉÏÎç10:32:50
 *
 *MusicWeb.Test.RoleMenuTest
 */
public class RoleMenuTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	RoleMenuBiz biz = new RoleMenuBizImpl();
	/**
	 * 
	 */
	@Test
	public void Test_checkMenu()
	{
		List<Authority> authList = new ArrayList<Authority>();
		
		authList = biz.checkMenu(1);
		
		for (Authority a : authList) {
			System.out.println(a.getAuthorityId()+","+a.getAuthorityName()+","+a.getAuthority_parentId());
		}
		
	}
	
	
	@Test
	public void Test_GetChildMenu()
	{
		List<Authority> aList = new ArrayList<Authority>();
		
		aList= biz.GetChildMenu(2);
		
		for (Authority a : aList) {
			System.out.println(a.getAuthorityId()+","+a.getAuthorityName()+","+a.getAuthority_parentId());
		}
	}

}
