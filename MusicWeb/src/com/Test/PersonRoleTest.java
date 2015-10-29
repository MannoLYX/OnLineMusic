package com.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dao.daoImpl.PersonRoleDaoImpl;
import com.entity.PersonRole;


/**
 *	
 * 2015-3-6下午1:42:05
 *
 *MusicWeb.Test.PersonRoleTest
 *PersonRoleDaoImpl 测试类
 */
public class PersonRoleTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * 增加 角色信息
	 */
	@Test
	public void Tet_addPersonRole()
	{
		PersonRoleDaoImpl prdi = new PersonRoleDaoImpl();
		
		PersonRole pRole = new PersonRole("会员","1");
		
		boolean b =prdi.addPersonRole(pRole);
		
		if(b)
		{
			System.out.println("增加成功");
		}else
		{
			System.out.println("增加失败");
		}
	}
	
	
	
	
	
	
	/**
	 * 删除
	 */
	@Test
	public void Test_deletePersonRole()
	{
		PersonRoleDaoImpl prdi = new PersonRoleDaoImpl();
		boolean b = prdi.deletePersonRole(4);
		
		if(b)
		{
			System.out.println("删除成功");
		}else
		{
			System.out.println("删除失败");
		}
	}
	
	
	
	
	/**
	 * 测试 更新会员信息
	 */
	@Test
	public void Test_updatePersonRole()
	{
		PersonRoleDaoImpl prdi = new PersonRoleDaoImpl();
		PersonRole pRole = new PersonRole();
		
		pRole.setRoleId(2);
		pRole.setRoleName("普通会员");
		pRole.setAuthority_RoleId("1,2");
		
		boolean b= prdi.updatePersonRole(pRole);
		if(b)
		{
			System.out.println("更新成功");
		}else
		{
			System.out.println("更新失败");
		}
	}
	
	
	/**
	 * 测试 通过roleId查询角色信息
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
	 * 测试 遍历全部角色信息
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
