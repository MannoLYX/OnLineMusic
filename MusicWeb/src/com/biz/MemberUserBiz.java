package com.biz;

import java.util.List;

import com.entity.MemberUser;
import com.entity.MemberUserRole;


/**
 *	
 * 2015-3-6����11:24:26
 *
 *MusicWeb.biz.MemberUserBiz
 * ��Ա��Ϣ ҵ���߼��ӿ�
 */
public interface MemberUserBiz {

	
	/**
	 * @return
	 * ���ӻ�Ա��Ϣ
	 */
	public boolean addMemberUser(MemberUser mUser);
	
	
	/**
	 * @param mUser
	 * @return
	 * �û�ע��
	 */
	public boolean addMemberUserByUser(MemberUser mUser);
	
	
	/**
	 * @param memberId
	 * @return
	 * ɾ����Ա��Ϣ
	 */
	public boolean deleteMemberUser(int memberId);
	
	/**
	 * @param memberId
	 * @return
	 * ����Ա�޸Ļ�Ա��Ϣ
	 */
	public boolean adminUpdateMemberUser(MemberUser mUser);
	
	
	/**
	 * @param mUser
	 * @return
	 * �û����޸��Լ���Ϣ
	 */
	public boolean updateMemberUser(MemberUser mUser);
	
	
	
	/**
	 * @param memberId
	 * @return
	 * �޸��û�����
	 */
	public boolean changePwd(int memberId,String pwd);
	
	
	/**
	 * @param memberId
	 * @return
	 * �����û�ͷ��
	 */
	public boolean changeUserPicture(String memberPicture,int memberId);
	
	/**
	 * @param memberId
	 * @return
	 * ���� memberName ���һ�Ա��Ϣ
	 */
	public MemberUserRole queryMemberUserInfobyAccountName(String AccountName);
	
	
	/**
	 * @return
	 * ����ȫ���Ļ�Ա��Ϣ
	 */
	public List<MemberUserRole> queryAllMemberUserInfo();
	
	/**
	 * @param accountNumber
	 * @param pwd
	 * @return
	 * �û� �˺������¼
	 */
	public MemberUser UserlogIn(String accountNumber,String pwd);
	
	/**
	 * @param memberId
	 * @return
	 * ���� memberid ���һ�Ա��Ϣ
	 */
	public MemberUser queryMemberUserById(int memberId);
	
	

	/**
	 * @return
	 * ��������ĵĻ�Ա��Ϣ
	 */
	public List<MemberUserRole> queryMemberUserInfoRecently();
	
	/**
	 * @return
	 *ͨ����������
	 */
	public List<MemberUserRole> queryMemberUserInfoByIntegral();
	
	/**
	 * @param memberId
	 * @return
	 * ͨ��ID�����û���ɫ������Ϣ
	 */
	public MemberUserRole queryMemberUserRoleById(int memberId);
	
	
	
	/**
	 * @return
	 * ��ȡ�����ܼ�¼��
	 */
	public int counterByPage();
	
	/**
	 * @param pageNum
	 * @param limitPage
	 * @return
	 * ��ѯ�ڼ�ҳ����Ϣ
	 */
	public  List<MemberUserRole> queryMemberUserInfoByPage(int pageNow,int limitPage);
	
	
	/**
	 * @return���ؼ��ٻ���
	 */
	public boolean  reducedIntegral(int memberId);
	/**
	 * @return �������ӻ���
	 */
	public boolean addIntegral(int memberId);

}
