package com.Test;

import static org.junit.Assert.*;

import java.sql.Date;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.biz.MemberUserBiz;
import com.biz.bizImpl.MemberUserBizImpl;
import com.dao.daoImpl.MemberUserDaoImpl;
import com.entity.MemberUser;
import com.entity.MemberUserRole;


/**
 *	
 * 2015-3-6上午9:40:46
 *
 *MusicWeb.Test.MemberUserTest
 *MemberUserDaoImpl 单元测试类
 */
public class MemberUserTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	
	/**
	 * 测试 添加会员信息
	 *  sql.date 和 util.date 的 转换
	 */
	@Test
	public void Test_addMemberUser()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		MemberUser mUser = new MemberUser();
		//mUser.setMemberId(11);
		mUser.setMemberName("刘育新1");
		mUser.setAge(30);
		mUser.setGender("男");
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		df.format(new Date());
		mUser.setBirthday(new Date(0));
		
		mUser.setMemberLabel("在java游泳的程序猿");
		mUser.setMemberIntroduction("程序员");
		mUser.setMemberPicture("图片33");
		mUser.setRegisterDate(new Date(0));
		mUser.setPwd("123456");
		mUser.setAccountNumber("liuyuxin1112");
		mUser.setMemberEmail("2222.@qq.com");
		
		boolean b=mudi.addMemberUser(mUser);
		
		if(b)
		{
			System.out.println("增加成功");
		}else
		{
			System.out.println("增加失败");
		}
		
		
	}
	
		
	/**
	 * 测试 删除会员信息
	 * 出现 外键 时 无法删除
	 */
	@Test
	public void Test_deleteMemberUser()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		boolean b=mudi.deleteMemberUser(14);
		
		if(b)
		{
			System.out.println("删除成功");
		}else
		{
			System.out.println("删除失败");
		}
	}
	
	
	
	
	/**
	 * 测试  管理员修改 会员信息
	 * 错误  积分 和 roleId 无法修改
	 */
	@Test
	public void Test_adminUpdateMemberUser()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		MemberUser mUser = new MemberUser();
//		MEMBERNAME=?,AGE=?,GENDER=?,BIRTHDAY=?,MEMBER_LABEL=?,MEMBER_INTRODUCTION=?," +
//				"MEMBER_PICTURE=?,MEMBER_INTEGRAL=?,REGISTER_DATE=?,ROLEID=?,PWD=? WHERE MEMBERID=?
		mUser.setMemberId(4);
		mUser.setMemberName("liuyuxin1");
		mUser.setAge(23);
		mUser.setGender("男");
		mUser.setBirthday(new Date(0));
		mUser.setMemberLabel("天天向上1");
		mUser.setMemberIntroduction("好好学习1");
		mUser.setMemberPicture("图片1");
		mUser.setPwd("liuyuxin1");
		mUser.setMemberIntegral(100);
		mUser.setRegisterDate(new Date(0));
		mUser.setRoleId(2);
		mUser.setAccountNumber("liuyuxin2");
		mUser.setMemberEmail("111.@qq.com");
		boolean b=mudi.updateMemberUser(mUser);
		
		if(b)
		{
			System.out.println("管理员更新成功");
		}else
		{
			System.out.println("管理员更新失败");
		}
	}
	
	
	
	
	/**
	 * 测试 修改会员信息
	 */
	@Test
	public void Test_updateMemberUser()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		MemberUser mUser = new MemberUser();
		
		mUser.setMemberId(3);
		mUser.setMemberName("liuyuxin");
		mUser.setAge(29);
		mUser.setGender("女");
		mUser.setBirthday(new Date(0));
		mUser.setMemberLabel("天天向上");
		mUser.setMemberIntroduction("好好学习");
		mUser.setMemberPicture("图片");
		mUser.setPwd("liuyuxin");
		mUser.setMemberEmail("1112222.@qq.com");
		
		boolean b=mudi.updateMemberUser(mUser);
		
		if(b)
		{
			System.out.println("更新成功");
		}else
		{
			System.out.println("更新失败");
		}
	}
	
	
	
	
	/**
	 * 测试 根据 memberName 查询会员信息
	 */
	@Test
	public void Test_queryMemberUserInfo()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		MemberUserRole memberUserRole = new MemberUserRole();
		memberUserRole = mudi.queryMemberUserInfobyAccountName("liuyuxin");
		
		System.out.println(memberUserRole.getMemberName()+","+memberUserRole.getAge()+","+memberUserRole.getGender()
				+","+memberUserRole.getMemberIntroduction()+","+memberUserRole.getMemberIntegral()+","+memberUserRole.getRegisterDate()
				+","+memberUserRole.getRoleName()+","+memberUserRole.getAccountNumber()+","+memberUserRole.getMemberEmail());
	}
	
	/**
	 * 测试 查询全部信息
	 */
	@Test
	public void Test_QueryAllMemberUserInfo()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		List<MemberUserRole> mUserRole = new ArrayList<MemberUserRole>();
		mUserRole=mudi.queryAllMemberUserInfo();
		
		for (MemberUserRole memberUserRole : mUserRole) {
			
			System.out.println(memberUserRole.getMemberId()+","+memberUserRole.getMemberName()+","+memberUserRole.getAge()+","+memberUserRole.getGender()
					+","+memberUserRole.getMemberIntroduction()+","+memberUserRole.getMemberIntegral()+","+memberUserRole.getRegisterDate()
					+","+memberUserRole.getRoleName()+","+memberUserRole.getAccountNumber()+","+memberUserRole.getMemberEmail());
		}
	}
	
	
	/**
	 * 用户登录
	 */
	@SuppressWarnings("unused")
	@Test
	public void Test_UserlogIn()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		MemberUser mUser = new MemberUser();
		mUser = mudi.UserlogIn("bigger","333333");
		
		System.out.println(mUser.getAccountNumber()+"|"+mUser.getPwd()+"|"+mUser.getMemberName()+","+mUser.getMemberEmail());
		if(mUser!=null)
		
			System.out.println("登录成功");
		 else
		
			System.out.println("登录成功");
		

	}
	
	@Test
	public void Test_addIntegral()
	{
		MemberUserBiz biz = new MemberUserBizImpl();
		
		if(biz.reducedIntegral(3))
			System.out.println("增加了十积分");
		else
			System.out.println("增加失败");
	}
}
