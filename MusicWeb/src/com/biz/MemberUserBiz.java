package com.biz;

import java.util.List;

import com.entity.MemberUser;
import com.entity.MemberUserRole;


/**
 *	
 * 2015-3-6上午11:24:26
 *
 *MusicWeb.biz.MemberUserBiz
 * 会员信息 业务逻辑接口
 */
public interface MemberUserBiz {

	
	/**
	 * @return
	 * 增加会员信息
	 */
	public boolean addMemberUser(MemberUser mUser);
	
	
	/**
	 * @param mUser
	 * @return
	 * 用户注册
	 */
	public boolean addMemberUserByUser(MemberUser mUser);
	
	
	/**
	 * @param memberId
	 * @return
	 * 删除会员信息
	 */
	public boolean deleteMemberUser(int memberId);
	
	/**
	 * @param memberId
	 * @return
	 * 管理员修改会员信息
	 */
	public boolean adminUpdateMemberUser(MemberUser mUser);
	
	
	/**
	 * @param mUser
	 * @return
	 * 用户更修改自己信息
	 */
	public boolean updateMemberUser(MemberUser mUser);
	
	
	
	/**
	 * @param memberId
	 * @return
	 * 修改用户密码
	 */
	public boolean changePwd(int memberId,String pwd);
	
	
	/**
	 * @param memberId
	 * @return
	 * 更换用户头像
	 */
	public boolean changeUserPicture(String memberPicture,int memberId);
	
	/**
	 * @param memberId
	 * @return
	 * 根据 memberName 查找会员信息
	 */
	public MemberUserRole queryMemberUserInfobyAccountName(String AccountName);
	
	
	/**
	 * @return
	 * 遍历全部的会员信息
	 */
	public List<MemberUserRole> queryAllMemberUserInfo();
	
	/**
	 * @param accountNumber
	 * @param pwd
	 * @return
	 * 用户 账号密码登录
	 */
	public MemberUser UserlogIn(String accountNumber,String pwd);
	
	/**
	 * @param memberId
	 * @return
	 * 根据 memberid 查找会员信息
	 */
	public MemberUser queryMemberUserById(int memberId);
	
	

	/**
	 * @return
	 * 遍历最近的的会员信息
	 */
	public List<MemberUserRole> queryMemberUserInfoRecently();
	
	/**
	 * @return
	 *通过积分排序
	 */
	public List<MemberUserRole> queryMemberUserInfoByIntegral();
	
	/**
	 * @param memberId
	 * @return
	 * 通过ID查找用户角色具体信息
	 */
	public MemberUserRole queryMemberUserRoleById(int memberId);
	
	
	
	/**
	 * @return
	 * 获取表中总记录数
	 */
	public int counterByPage();
	
	/**
	 * @param pageNum
	 * @param limitPage
	 * @return
	 * 查询第几页的信息
	 */
	public  List<MemberUserRole> queryMemberUserInfoByPage(int pageNow,int limitPage);
	
	
	/**
	 * @return下载减少积分
	 */
	public boolean  reducedIntegral(int memberId);
	/**
	 * @return 评论增加积分
	 */
	public boolean addIntegral(int memberId);

}
