package com.biz.bizImpl;

import java.util.List;

import com.biz.MemberUserBiz;
import com.dao.MemberUserDao;
import com.dao.daoImpl.MemberUserDaoImpl;
import com.entity.MemberUser;
import com.entity.MemberUserRole;



/**
 *	
 * 2015-3-6上午11:26:26
 *
 *MusicWeb.biz.bizImpl.MemberUserBizImpl
 *业务逻辑 接口的实现
 */
public class MemberUserBizImpl implements MemberUserBiz{

	/* (non-Javadoc)
	 * @see biz.MemberUserBiz#addMemberUser(entity.MemberUser)
	 */
	MemberUserDao dao = new MemberUserDaoImpl();
	
	public boolean addMemberUser(MemberUser mUser) {
		// TODO Auto-generated method stub
		return dao.addMemberUser(mUser);
	}

	public boolean deleteMemberUser(int memberId) {
		// TODO Auto-generated method stub
		return dao.deleteMemberUser(memberId);
	}

	public boolean adminUpdateMemberUser(MemberUser mUser) {
		// TODO Auto-generated method stub
		return dao.adminUpdateMemberUser(mUser);
	}

	public boolean updateMemberUser(MemberUser mUser) {
		// TODO Auto-generated method stub
		return dao.updateMemberUser(mUser);
	}

	public MemberUserRole queryMemberUserInfobyAccountName(String AccountName) {
		// TODO Auto-generated method stub
		return dao.queryMemberUserInfobyAccountName(AccountName);
	}

	public List<MemberUserRole> queryAllMemberUserInfo() {
		// TODO Auto-generated method stub
		return dao.queryAllMemberUserInfo();
	}

	public MemberUser UserlogIn(String accountNumber, String pwd) {
		// TODO Auto-generated method stub
		return dao.UserlogIn(accountNumber, pwd);
	}

	public MemberUser queryMemberUserById(int memberId) {
		// TODO Auto-generated method stub
		return dao.queryMemberUserById(memberId);
	}

	public boolean addMemberUserByUser(MemberUser mUser) {
		// TODO Auto-generated method stub
		return dao.addMemberUserByUser(mUser);
	}

	public List<MemberUserRole> queryMemberUserInfoRecently() {
		// TODO Auto-generated method stub
		return dao.queryMemberUserInfoRecently();
	}

	public List<MemberUserRole> queryMemberUserInfoByIntegral() {
		// TODO Auto-generated method stub
		return dao.queryMemberUserInfoByIntegral();
	}

	public MemberUserRole queryMemberUserRoleById(int memberId) {
		// TODO Auto-generated method stub
		return dao.queryMemberUserRoleById(memberId);
	}

	public boolean changePwd(int memberId,String pwd) {
		// TODO Auto-generated method stub
		return dao.changePwd(memberId, pwd);
	}

	public int counterByPage() {
		// TODO Auto-generated method stub
		return dao.counterByPage();
	}

	public List<MemberUserRole> queryMemberUserInfoByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		return dao.queryMemberUserInfoByPage(pageNow, limitPage);
	}

	public boolean changeUserPicture(String memberPicture, int memberId) {
		// TODO Auto-generated method stub
		return dao.changeUserPicture(memberPicture, memberId);
	}

	public boolean reducedIntegral(int memberId) {
		// TODO Auto-generated method stub
		return dao.reducedIntegral(memberId);
	}

	public boolean addIntegral(int memberId) {
		// TODO Auto-generated method stub
		return dao.addIntegral(memberId);
	}

	

}
