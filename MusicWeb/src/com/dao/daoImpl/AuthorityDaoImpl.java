package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.AuthorityDao;
import com.entity.Authority;
import com.util.DBUtil;



/**
 *	
 * 2015-3-6下午2:25:28
 *
 *MusicWeb.dao.daoImpl.AuthorityDaoImpl
 * 权限接口的 实现类
 */
public class AuthorityDaoImpl implements AuthorityDao{

	
	DBUtil util = new DBUtil();
	String sql;
	
	/* (non-Javadoc)
	 * @see dao.AuthorityDao#addAuthority(entity.Authority)
	 */
	public boolean addAuthority(Authority authority) {
		// TODO Auto-generated method stub
		sql="INSERT INTO AUTHORITY(AUTHORITY_NAME,ACTION,AUTHORITY_PARENTID)VALUES(?,?,?)";
		
		return util.update(sql, authority.getAuthorityName(),authority.getAction(),authority.getAuthority_parentId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.AuthorityDao#deleteAuthority(int)
	 */
	public boolean deleteAuthority(int authorityId) {
		// TODO Auto-generated method stub
		sql="DELETE FROM AUTHORITY WHERE AUTHORITYID=?";
		
		return util.update(sql, authorityId)>=1;
	}

	/* (non-Javadoc)
	 * @see dao.AuthorityDao#updateAuthority(entity.Authority)
	 */
	public boolean updateAuthority(Authority authority) {
		// TODO Auto-generated method stub
		sql="UPDATE AUTHORITY SET AUTHORITY_NAME=?,ACTION=?,AUTHORITY_PARENTID=? WHERE AUTHORITYID=?";
		
		return util.update(sql, authority.getAuthorityName(),authority.getAction(),authority.getAuthority_parentId(),
				authority.getAuthorityId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.AuthorityDao#queryAuthorityById(int)
	 */
	public Authority queryAuthorityById(int authorityId) {
		// TODO Auto-generated method stub
		sql="SELECT * FROM AUTHORITY WHERE AUTHORITYID=?";
		Authority authority = null;
		ResultSet rs = util.Query(sql, authorityId);
		
//		int authorityId, String authorityName, String action,
//		int authority_parentId
		try {
			while(rs.next())
			{
				authority = new Authority(rs.getInt("AUTHORITYID"),rs.getString("AUTHORITY_NAME"),rs.getString("ACTION"),
						rs.getInt("AUTHORITY_PARENTID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return authority;
	}

	/* (non-Javadoc)
	 * @see dao.AuthorityDao#queryAuthorityInfo()
	 */
	public List<Authority> queryAuthorityInfo() {
		// TODO Auto-generated method stub
		sql="SELECT * FROM AUTHORITY ";
		
		List<Authority> authorityList = new ArrayList<Authority>();
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				Authority authority =new Authority(rs.getInt("AUTHORITYID"),rs.getString("AUTHORITY_NAME"),rs.getString("ACTION"),
						rs.getInt("AUTHORITY_PARENTID"));
				
				authorityList.add(authority);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		
		return authorityList;
	}

	/* (non-Javadoc)
	 * @see com.dao.AuthorityDao#queryUserAuthorityInfo()
	 * 用户权限
	 */
	public List<Authority> queryUserAuthorityInfo() {
		// TODO Auto-generated method stub
sql="SELECT AUTHORITYID,AUTHORITY_NAME,ACTION,AUTHORITY_PARENTID FROM AUTHORITY where authority_parentid='0'";
		
		List<Authority> authorityList = new ArrayList<Authority>();
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				Authority authority =new Authority(rs.getInt("AUTHORITYID"),rs.getString("AUTHORITY_NAME"),rs.getString("ACTION"),
						rs.getInt("AUTHORITY_PARENTID"));
				
				authorityList.add(authority);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		
		return authorityList;
	}

	/* (non-Javadoc)
	 * @see com.dao.AuthorityDao#queryAdminAuthorityInfo()
	 * 管理员权限
	 */
	public List<Authority> queryAdminAuthorityInfo() {
		// TODO Auto-generated method stub
sql="SELECT AUTHORITYID,AUTHORITY_NAME,ACTION,AUTHORITY_PARENTID FROM AUTHORITY where authority_parentid='1' ";
		
		List<Authority> authorityList = new ArrayList<Authority>();
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				Authority authority =new Authority(rs.getInt("AUTHORITYID"),rs.getString("AUTHORITY_NAME"),rs.getString("ACTION"),
						rs.getInt("AUTHORITY_PARENTID"));
				
				authorityList.add(authority);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		
		return authorityList;
	}

}
