package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.MemberUserDao;
import com.entity.MemberUser;
import com.entity.MemberUserRole;
import com.util.DBUtil;



/**
 *	
 * 2015-3-5下午2:37:49
 *
 *MusicWeb.dao.daoImpl.MemberUserDaoImpl
 *会员信息 接口的实现类
 */
public class MemberUserDaoImpl implements MemberUserDao {

	DBUtil util = new DBUtil();
	String sql;
	
	/* (non-Javadoc)
	 * @see dao.MemberUserDao#addMemberUser(entity.MemberUser)
	 * 
	 */
	public boolean addMemberUser(MemberUser mUser) {
		// TODO Auto-generated method stub
		sql="INSERT INTO MEMBERUSER(MEMBERNAME,AGE,GENDER,BIRTHDAY,MEMBER_LABEL,MEMBER_INTRODUCTION," +
				"REGISTER_DATE,PWD,ACCOUNTNUMBER,MEMBEREMAIL,MEMBER_INTEGRAL,roleId)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		return util.update(sql,mUser.getMemberName(),mUser.getAge(),mUser.getGender(),mUser.getBirthday(),
				mUser.getMemberLabel(),mUser.getMemberIntroduction(),mUser.getRegisterDate()
				,mUser.getPwd(),mUser.getAccountNumber(),mUser.getMemberEmail(),mUser.getMemberIntegral(),mUser.getRoleId())>=1;
	}

	
	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#addMemberUserByUser(com.entity.MemberUser)
	 */
	public boolean addMemberUserByUser(MemberUser mUser) {
		// TODO Auto-generated method stub
		sql="INSERT INTO MEMBERUSER(MEMBERNAME,AGE,GENDER,BIRTHDAY,MEMBER_LABEL," +
				"REGISTER_DATE,PWD,ACCOUNTNUMBER,MEMBEREMAIL,MEMBER_INTRODUCTION)VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		return util.update(sql,mUser.getMemberName(),mUser.getAge(),mUser.getGender(),mUser.getBirthday(),
				mUser.getMemberLabel(),mUser.getRegisterDate()
				,mUser.getPwd(),mUser.getAccountNumber(),mUser.getMemberEmail(),mUser.getMemberIntroduction())>=1;
	}

	
	
	
	/* (non-Javadoc)
	 * @see dao.MemberUserDao#deleteMemberUser(int)
	 */
	public boolean deleteMemberUser(int memberId) {
		// TODO Auto-generated method stub
		sql=" DELETE FROM MEMBERUSER WHERE MEMBERID=?";
		return util.update(sql, memberId)>=1;
	}

	/* (non-Javadoc)
	 * @see dao.MemberUserDao#updateMemberUser(entity.MemberUser)
	 * 管理员 更新会员信息
	 */
	public boolean adminUpdateMemberUser(MemberUser mUser) {
		sql="UPDATE MEMBERUSER SET MEMBERNAME=?,AGE=?,GENDER=?,BIRTHDAY=?,MEMBER_LABEL=?,MEMBER_INTRODUCTION=?," +
				"MEMBER_INTEGRAL=?,REGISTER_DATE=?,ROLEID=?,PWD=?,ACCOUNTNUMBER=?,MEMBEREMAIL=? WHERE MEMBERID=?";
		
				
		return util.update(sql, mUser.getMemberName(),mUser.getAge(),mUser.getGender(),mUser.getBirthday(),
				mUser.getMemberLabel(),mUser.getMemberIntroduction(),mUser.getMemberIntegral()
				,mUser.getRegisterDate(),mUser.getRoleId(),mUser.getPwd(),mUser.getAccountNumber(),mUser.getMemberEmail(),
				mUser.getMemberId())>=1;
	}
	
	/* (non-Javadoc)
	 * @see dao.MemberUserDao#updateMemberUser(entity.MemberUser)
	 * 用户修改自己的信息
	 */
	public boolean updateMemberUser(MemberUser mUser) {
		// TODO Auto-generated method stub
		sql="UPDATE MEMBERUSER SET MEMBERNAME=?,AGE=?,GENDER=?,BIRTHDAY=?,MEMBER_LABEL=?,MEMBER_INTRODUCTION=?," +
				"MEMBEREMAIL=? WHERE MEMBERID=?";
		return util.update(sql, mUser.getMemberName(),mUser.getAge(),mUser.getGender(),mUser.getBirthday(),
				mUser.getMemberLabel(),mUser.getMemberIntroduction(),
				mUser.getMemberEmail(),mUser.getMemberId())>=1;
	}
	
	

	/* (non-Javadoc)
	 * @see dao.MemberUserDao#queryMemberUserInfo(int)
	 */
	public MemberUserRole queryMemberUserInfobyAccountName(String AccountName) {
		// TODO Auto-generated method stub
		sql="SELECT M.memberId, M.MEMBERNAME,M.AGE,M.GENDER,M.BIRTHDAY,M.MEMBER_LABEL,M.MEMBER_INTRODUCTION,M.MEMBER_PICTURE,M.REGISTER_DATE," +
				"P.ROLENAME,M.PWD,M.MEMBER_INTEGRAL,M.ACCOUNTNUMBER, M.MEMBEREMAIL FROM MEMBERUSER M,PERSON_ROLE P WHERE M.ROLEID=P.ROLEID AND M.ACCOUNTNUMBER=?";
		
		ResultSet rs = util.Query(sql, AccountName);
		
		MemberUserRole mUserRole = null;
		
		try {
			while(rs.next())
			{
								
				mUserRole = new MemberUserRole(rs.getInt("MEMBERID"),rs.getString("memberName"),rs.getInt("age"),rs.getString("gender"),rs.getDate("birthday"),
						rs.getString("MEMBER_LABEL"),rs.getString("MEMBER_INTRODUCTION"),rs.getString("MEMBER_PICTURE"),rs.getDate("REGISTER_DATE"),
						rs.getString("roleName"),rs.getString("pwd"),rs.getInt("MEMBER_INTEGRAL"),rs.getString("ACCOUNTNUMBER"),rs.getString("MEMBEREMAIL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return mUserRole;
	}

	/* (non-Javadoc)
	 * @see dao.MemberUserDao#queryAllMemberUserInfo()
	 */
	public List<MemberUserRole> queryAllMemberUserInfo() {
		// TODO Auto-generated method stub
		sql="select M.MEMBERID,M.MEMBERNAME,M.AGE,M.GENDER,M.BIRTHDAY,M.MEMBER_LABEL,M.MEMBER_INTRODUCTION,M.MEMBER_PICTURE,M.MEMBER_INTEGRAL," +
				"M.REGISTER_DATE,P.ROLENAME,M.ACCOUNTNUMBER,M.PWD,M.MEMBEREMAIL from memberuser m,person_role p " +
				"where m.roleid=p.roleid order by m.memberid Asc";
		
		List<MemberUserRole> mUserRoleList = new ArrayList<MemberUserRole>();
		
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				MemberUserRole mUserRole = new MemberUserRole(rs.getInt("MEMBERID"),rs.getString("memberName"),rs.getInt("age"),rs.getString("gender"),rs.getDate("birthday"),
						rs.getString("MEMBER_LABEL"),rs.getString("MEMBER_INTRODUCTION"),rs.getString("MEMBER_PICTURE"),rs.getDate("REGISTER_DATE"),
						rs.getString("roleName"),rs.getString("pwd"),rs.getInt("MEMBER_INTEGRAL"),rs.getString("ACCOUNTNUMBER"),rs.getString("MEMBEREMAIL"));
				
				mUserRoleList.add(mUserRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return mUserRoleList;
	}

	/* (non-Javadoc)
	 * @see dao.MemberUserDao#UserlogIn(java.lang.String, java.lang.String)
	 */
	public MemberUser UserlogIn(String accountNumber, String pwd) {
		// TODO Auto-generated method stub
		sql="SELECT M.MEMBERID,M.MEMBERNAME,M.AGE,M.GENDER,M.BIRTHDAY,M.MEMBER_LABEL,M.MEMBER_INTRODUCTION,M.MEMBER_PICTURE,M.MEMBER_INTEGRAL," +
				"M.REGISTER_DATE,M.roleId,M.ACCOUNTNUMBER,M.PWD,M.MEMBEREMAIL FROM MEMBERUSER M WHERE M.ACCOUNTNUMBER=? AND M.PWD=? ";
		
		MemberUser mUser = null;
		
		ResultSet rs =util.Query(sql, accountNumber,pwd);
		
		try {
			while(rs.next())
			{			
				mUser = new MemberUser(rs.getInt("MEMBERID"),rs.getString("MEMBERNAME"),rs.getInt("age"),rs.getString("GENDER"),
						rs.getDate("BIRTHDAY"),rs.getString("MEMBER_LABEL"),rs.getString("MEMBER_INTRODUCTION"),
						rs.getString("MEMBER_PICTURE"),rs.getDate("REGISTER_DATE"),rs.getInt("ROLEID"),rs.getString("PWD"),
						rs.getInt("MEMBER_INTEGRAL"),rs.getString("ACCOUNTNUMBER"),rs.getString("MEMBEREMAIL"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mUser;
	}

	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#queryMemberUserById(int)
	 */
	public MemberUser queryMemberUserById(int memberId) {
		// TODO Auto-generated method stub
		sql="SELECT M.MEMBERID,M.MEMBERNAME,M.AGE,M.GENDER,M.BIRTHDAY,M.MEMBER_LABEL,M.MEMBER_INTRODUCTION,M.MEMBER_PICTURE,M.MEMBER_INTEGRAL," +
			"M.REGISTER_DATE,M.roleId,M.ACCOUNTNUMBER,M.PWD,M.MEMBEREMAIL FROM MEMBERUSER M WHERE M.memberId=? ";
		
		
		MemberUser mUser = null;
		
		ResultSet rs =util.Query(sql,memberId);
		
		try {
			while(rs.next())
			{			
				mUser = new MemberUser(rs.getInt("MEMBERID"),rs.getString("MEMBERNAME"),rs.getInt("age"),rs.getString("GENDER"),
						rs.getDate("BIRTHDAY"),rs.getString("MEMBER_LABEL"),rs.getString("MEMBER_INTRODUCTION"),
						rs.getString("MEMBER_PICTURE"),rs.getDate("REGISTER_DATE"),rs.getInt("ROLEID"),rs.getString("PWD"),
						rs.getInt("MEMBER_INTEGRAL"),rs.getString("ACCOUNTNUMBER"),rs.getString("MEMBEREMAIL"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mUser;
	}


	public List<MemberUserRole> queryMemberUserInfoRecently() {
		// TODO Auto-generated method stub
		
		sql="select * from(select M.MEMBERID,M.MEMBERNAME,M.AGE,M.GENDER,M.BIRTHDAY,M.MEMBER_LABEL,M.MEMBER_INTRODUCTION,M.MEMBER_PICTURE,M.MEMBER_INTEGRAL," +
				"M.REGISTER_DATE,P.ROLENAME,M.ACCOUNTNUMBER,M.PWD,M.MEMBEREMAIL from memberuser m,person_role p " +
				"where m.roleid=p.roleid order by m.REGISTER_DATE desc)where rownum<=10";
		
		List<MemberUserRole> mUserRoleList = new ArrayList<MemberUserRole>();
		
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				MemberUserRole mUserRole = new MemberUserRole(rs.getInt("MEMBERID"),rs.getString("memberName"),rs.getInt("age"),rs.getString("gender"),rs.getDate("birthday"),
						rs.getString("MEMBER_LABEL"),rs.getString("MEMBER_INTRODUCTION"),rs.getString("MEMBER_PICTURE"),rs.getDate("REGISTER_DATE"),
						rs.getString("roleName"),rs.getString("pwd"),rs.getInt("MEMBER_INTEGRAL"),rs.getString("ACCOUNTNUMBER"),rs.getString("MEMBEREMAIL"));
				
				mUserRoleList.add(mUserRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return mUserRoleList;
	}


	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#queryMemberUserInfoByIntegral()
	 */
	public List<MemberUserRole> queryMemberUserInfoByIntegral() {
		// TODO Auto-generated method stub
		
		sql="select * from(select M.MEMBERID,M.MEMBERNAME,M.AGE,M.GENDER,M.BIRTHDAY,M.MEMBER_LABEL,M.MEMBER_INTRODUCTION,M.MEMBER_PICTURE,M.MEMBER_INTEGRAL," +
				"M.REGISTER_DATE,P.ROLENAME,M.ACCOUNTNUMBER,M.PWD,M.MEMBEREMAIL from memberuser m,person_role p" +
				" where m.roleid=p.roleid order by m.MEMBER_INTEGRAL desc) where rownum<=10";
		
		List<MemberUserRole> mUserRoleList = new ArrayList<MemberUserRole>();
		
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				MemberUserRole mUserRole = new MemberUserRole(rs.getInt("MEMBERID"),rs.getString("memberName"),rs.getInt("age"),rs.getString("gender"),rs.getDate("birthday"),
						rs.getString("MEMBER_LABEL"),rs.getString("MEMBER_INTRODUCTION"),rs.getString("MEMBER_PICTURE"),rs.getDate("REGISTER_DATE"),
						rs.getString("roleName"),rs.getString("pwd"),rs.getInt("MEMBER_INTEGRAL"),rs.getString("ACCOUNTNUMBER"),rs.getString("MEMBEREMAIL"));
				
				mUserRoleList.add(mUserRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return mUserRoleList;
	}


	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#queryMemberUserRoleById(int)
	 */
	public MemberUserRole queryMemberUserRoleById(int memberId) {
		// TODO Auto-generated method stub
		sql="select M.MEMBERID,M.MEMBERNAME,M.AGE,M.GENDER,M.BIRTHDAY,M.MEMBER_LABEL,M.MEMBER_INTRODUCTION,M.MEMBER_PICTURE,M.MEMBER_INTEGRAL," +
				"M.REGISTER_DATE,P.ROLENAME,M.ACCOUNTNUMBER,M.PWD,M.MEMBEREMAIL from memberuser m,person_role p " +
				"where m.roleid=p.roleid and M.memberId=?";
		
		
		MemberUserRole mUserRole=null;
		ResultSet rs = util.Query(sql,memberId);
		
		try {
			while(rs.next())
			{
				 mUserRole = new MemberUserRole(rs.getInt("MEMBERID"),rs.getString("memberName"),rs.getInt("age"),rs.getString("gender"),rs.getDate("birthday"),
						rs.getString("MEMBER_LABEL"),rs.getString("MEMBER_INTRODUCTION"),rs.getString("MEMBER_PICTURE"),rs.getDate("REGISTER_DATE"),
						rs.getString("roleName"),rs.getString("pwd"),rs.getInt("MEMBER_INTEGRAL"),rs.getString("ACCOUNTNUMBER"),rs.getString("MEMBEREMAIL"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return mUserRole;
	}


	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#changPwd(int)
	 */
	public boolean changePwd(int memberId,String pwd ) {
		// TODO Auto-generated method stub
		
		sql=" UPDATE MEMBERUSER SET PWD=? WHERE MEMBERID=?";
		return util.update(sql,pwd,memberId)>=1;
		
	}


	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#counterByPage()
	 */
	public int counterByPage() {
		// TODO Auto-generated method stub
		sql="select count(*) from memberuser";
		
		ResultSet rs =util.Query(sql);
		int totalCount=0;
		
		try {
			while(rs.next())
			{
				totalCount = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalCount;
	}


	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#queryMemberUserInfoByPage(int, int)
	 * 分页查询
	 */
	public List<MemberUserRole> queryMemberUserInfoByPage(int pageNow,int limitPage) {
		// TODO Auto-generated method stub
		
		sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (select M.MEMBERID,M.MEMBERNAME,M.AGE,M.GENDER,M.BIRTHDAY,M.MEMBER_LABEL,M.MEMBER_INTRODUCTION," +
				"M.MEMBER_PICTURE,M.MEMBER_INTEGRAL,M.REGISTER_DATE,P.ROLENAME,M.ACCOUNTNUMBER,M.PWD,M.MEMBEREMAIL from " +
				"memberuser m,person_role p where m.roleid=p.roleid order by m.memberid Asc) A WHERE ROWNUM <=?)WHERE RN >?";
		
		List<MemberUserRole> memberList = new ArrayList<MemberUserRole>();
		
		ResultSet rs = util.Query(sql,limitPage*pageNow,(pageNow-1)*limitPage);
		
		try {
			while(rs.next())
			{
				MemberUserRole mUserRole = new MemberUserRole(rs.getInt("MEMBERID"),rs.getString("memberName"),rs.getInt("age"),rs.getString("gender"),rs.getDate("birthday"),
						rs.getString("MEMBER_LABEL"),rs.getString("MEMBER_INTRODUCTION"),rs.getString("MEMBER_PICTURE"),rs.getDate("REGISTER_DATE"),
						rs.getString("roleName"),rs.getString("pwd"),rs.getInt("MEMBER_INTEGRAL"),rs.getString("ACCOUNTNUMBER"),rs.getString("MEMBEREMAIL"));
				
				memberList.add(mUserRole);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return memberList;
	}


	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#changeUserPicture(int)
	 * 更换用户头像
	 */
	public boolean changeUserPicture(String memberPicture,int memberId) {
		// TODO Auto-generated method stub
		sql=" UPDATE MEMBERUSER SET member_picture=? WHERE MEMBERID=?";
		
		return util.update(sql,memberPicture,memberId)>=1;
		
	}


	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#reducedIntegral(int)
	 * 减少
	 */
	public boolean reducedIntegral(int memberId) {
		// TODO Auto-generated method stub
		sql="update memberuser  set member_integral=member_integral-10 where memberid=?";
		
		return util.update(sql, memberId)>=1;
	}


	/* (non-Javadoc)
	 * @see com.dao.MemberUserDao#addIntegral(int)
	 * 增加
	 */
	public boolean addIntegral(int memberId) {
		// TODO Auto-generated method stub
		sql="update memberuser  set member_integral=member_integral+10 where memberid=?";
		
		return util.update(sql, memberId)>=1;
	}

}
