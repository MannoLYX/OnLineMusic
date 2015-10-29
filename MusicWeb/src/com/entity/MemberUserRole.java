package com.entity;

import java.sql.Date;

/**
 *	
 * 2015-3-6上午8:45:44
 *
 *MusicWeb.entity.memberUserRole
 *会员 和 角色 中间类
 * 用于查询 会员的信息
 */
public class MemberUserRole {

	int memberId;
	/**
	 * 会员名
	 */
	private String memberName; 
	/**
	 * 年龄
	 */
	private int age; 
	/**
	 * 性别
	 */
	private String gender; 
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 个人标签
	 */
	private String memberLabel; 
	/**
	 * 个人介绍
	 */
	private String memberIntroduction;
	/**
	 * 会员图片
	 */
	private String memberPicture;
	/**
	 * 注册日期
	 */
	private Date registerDate;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 会员积分
	 */
	private int memberIntegral;
	
	/**
	 * 账号
	 */
	private String accountNumber;
	
	/**
	 * 用户邮箱
	 */
	private String memberEmail;
	
	



	public String getMemberEmail() {
		return memberEmail;
	}




	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}




	public MemberUserRole(int age, String gender, Date birthday,
			String memberLabel, String memberIntroduction,
			String memberPicture, Date registerDate, String roleName,
			String pwd, int memberIntegral, String accountNumber,
			String memberEmail) {
		super();
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.memberLabel = memberLabel;
		this.memberIntroduction = memberIntroduction;
		this.memberPicture = memberPicture;
		this.registerDate = registerDate;
		this.roleName = roleName;
		this.pwd = pwd;
		this.memberIntegral = memberIntegral;
		this.accountNumber = accountNumber;
		this.memberEmail = memberEmail;
	}




	public MemberUserRole(int memberId ,String memberName, int age, String gender,
			Date birthday, String memberLabel, String memberIntroduction,
			String memberPicture, Date registerDate, String roleName,
			String pwd, int memberIntegral, String accountNumber,
			String memberEmail) {
		super();
		this.memberId=memberId;
		this.memberName = memberName;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.memberLabel = memberLabel;
		this.memberIntroduction = memberIntroduction;
		this.memberPicture = memberPicture;
		this.registerDate = registerDate;
		this.roleName = roleName;
		this.pwd = pwd;
		this.memberIntegral = memberIntegral;
		this.accountNumber = accountNumber;
		this.memberEmail = memberEmail;
	}




	public int getMemberId() {
		return memberId;
	}




	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}




	public MemberUserRole(String memberName) {
		super();
		this.memberName = memberName;
	}




	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public MemberUserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMemberLabel() {
		return memberLabel;
	}

	public void setMemberLabel(String memberLabel) {
		this.memberLabel = memberLabel;
	}

	public String getMemberIntroduction() {
		return memberIntroduction;
	}

	public void setMemberIntroduction(String memberIntroduction) {
		this.memberIntroduction = memberIntroduction;
	}

	public String getMemberPicture() {
		return memberPicture;
	}

	public void setMemberPicture(String memberPicture) {
		this.memberPicture = memberPicture;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getMemberIntegral() {
		return memberIntegral;
	}

	public void setMemberIntegral(int memberIntegral) {
		this.memberIntegral = memberIntegral;
	}
	
	
	
	
}
