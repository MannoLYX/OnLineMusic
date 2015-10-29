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
 * 2015-3-6����9:40:46
 *
 *MusicWeb.Test.MemberUserTest
 *MemberUserDaoImpl ��Ԫ������
 */
public class MemberUserTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	
	/**
	 * ���� ��ӻ�Ա��Ϣ
	 *  sql.date �� util.date �� ת��
	 */
	@Test
	public void Test_addMemberUser()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		MemberUser mUser = new MemberUser();
		//mUser.setMemberId(11);
		mUser.setMemberName("������1");
		mUser.setAge(30);
		mUser.setGender("��");
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
//		df.format(new Date());
		mUser.setBirthday(new Date(0));
		
		mUser.setMemberLabel("��java��Ӿ�ĳ���Գ");
		mUser.setMemberIntroduction("����Ա");
		mUser.setMemberPicture("ͼƬ33");
		mUser.setRegisterDate(new Date(0));
		mUser.setPwd("123456");
		mUser.setAccountNumber("liuyuxin1112");
		mUser.setMemberEmail("2222.@qq.com");
		
		boolean b=mudi.addMemberUser(mUser);
		
		if(b)
		{
			System.out.println("���ӳɹ�");
		}else
		{
			System.out.println("����ʧ��");
		}
		
		
	}
	
		
	/**
	 * ���� ɾ����Ա��Ϣ
	 * ���� ��� ʱ �޷�ɾ��
	 */
	@Test
	public void Test_deleteMemberUser()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		boolean b=mudi.deleteMemberUser(14);
		
		if(b)
		{
			System.out.println("ɾ���ɹ�");
		}else
		{
			System.out.println("ɾ��ʧ��");
		}
	}
	
	
	
	
	/**
	 * ����  ����Ա�޸� ��Ա��Ϣ
	 * ����  ���� �� roleId �޷��޸�
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
		mUser.setGender("��");
		mUser.setBirthday(new Date(0));
		mUser.setMemberLabel("��������1");
		mUser.setMemberIntroduction("�ú�ѧϰ1");
		mUser.setMemberPicture("ͼƬ1");
		mUser.setPwd("liuyuxin1");
		mUser.setMemberIntegral(100);
		mUser.setRegisterDate(new Date(0));
		mUser.setRoleId(2);
		mUser.setAccountNumber("liuyuxin2");
		mUser.setMemberEmail("111.@qq.com");
		boolean b=mudi.updateMemberUser(mUser);
		
		if(b)
		{
			System.out.println("����Ա���³ɹ�");
		}else
		{
			System.out.println("����Ա����ʧ��");
		}
	}
	
	
	
	
	/**
	 * ���� �޸Ļ�Ա��Ϣ
	 */
	@Test
	public void Test_updateMemberUser()
	{
		MemberUserDaoImpl mudi = new MemberUserDaoImpl();
		
		MemberUser mUser = new MemberUser();
		
		mUser.setMemberId(3);
		mUser.setMemberName("liuyuxin");
		mUser.setAge(29);
		mUser.setGender("Ů");
		mUser.setBirthday(new Date(0));
		mUser.setMemberLabel("��������");
		mUser.setMemberIntroduction("�ú�ѧϰ");
		mUser.setMemberPicture("ͼƬ");
		mUser.setPwd("liuyuxin");
		mUser.setMemberEmail("1112222.@qq.com");
		
		boolean b=mudi.updateMemberUser(mUser);
		
		if(b)
		{
			System.out.println("���³ɹ�");
		}else
		{
			System.out.println("����ʧ��");
		}
	}
	
	
	
	
	/**
	 * ���� ���� memberName ��ѯ��Ա��Ϣ
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
	 * ���� ��ѯȫ����Ϣ
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
	 * �û���¼
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
		
			System.out.println("��¼�ɹ�");
		 else
		
			System.out.println("��¼�ɹ�");
		

	}
	
	@Test
	public void Test_addIntegral()
	{
		MemberUserBiz biz = new MemberUserBizImpl();
		
		if(biz.reducedIntegral(3))
			System.out.println("������ʮ����");
		else
			System.out.println("����ʧ��");
	}
}
