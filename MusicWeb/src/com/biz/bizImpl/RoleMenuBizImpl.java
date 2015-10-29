package com.biz.bizImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.RoleMenuBiz;
import com.entity.Authority;
import com.entity.PersonRole;
import com.util.DBUtil;



/**
 *	
 * 2015-3-12上午10:02:01
 *
 *MusicWeb.biz.bizImpl.RoleMenuBizImpl
 */
public class RoleMenuBizImpl implements RoleMenuBiz{

	DBUtil util = new DBUtil();
	String sql;
	
	/* (non-Javadoc)
	 * @see biz.RoleMenuBiz#checkMenu(entity.MemberUser)
	 */
	public List<Authority> checkMenu(int userRoleId) {
		// TODO Auto-generated method stub
		
		//获取权限的集合
		sql="select p.roleid,p.rolename,p.authority_role_id from MemberUser m,person_role p where m.roleid=p.roleid and m.roleid=?";
		
		PersonRole pRole = null;
		
		ResultSet rs =util.Query(sql, userRoleId);
		
		try {
			while(rs.next())
			{
				pRole=new PersonRole(rs.getInt("roleid"),rs.getString("rolename"),rs.getString("authority_role_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Authority> authList = new ArrayList<Authority>();
		
		
		String[] arrRole = pRole.getAuthority_RoleId().split(",");
		
		int arrlength = arrRole.length;
		for(int i=0;i<arrlength;i++)
		{
			int authId = Integer.valueOf(arrRole[i]);
			Authority auth = showMenu(authId);
			
			authList.add(auth);
		
//			//遍历出 父权限ID 下的 子权限信息
//			if(auth.getAuthority_parentId()==0)
//			{
//				List<Authority> aList = new ArrayList<Authority>();
//				aList = GetChildMenu(auth.getAuthorityId());
//				
//				for (Authority a : aList) {
//					authList.add(a);
//				}
//			}
			
//			if(auth.getAuthority_parentId()!=0)
//			{
//				Authority authority = showMenu(auth.getAuthority_parentId());
//				
//				boolean isbe=false;
//				//for (int j=0;j<authList.size();j++) {
//					
//					if(authList.contains(authority))
//							//authList.get(j)==(authority))
//					{
//					//System.out.println("a:"+authList.get(j).getAuthority_parentId()+","+authList.get(j).getAuthorityName());
//					System.out.println("authority:"+authority.getAuthority_parentId()+","+authority.getAuthorityName());
//						isbe=true;
//					}
//				//}
//				
//				if(!isbe)
//				{
//					authList.add(authority);
//				}
//				
//			}
			//authList.add(auth);
		}
		
		
		return authList;
	}

	
	/* (non-Javadoc)
	 * @see biz.RoleMenuBiz#showMenu(int)
	 */
	public Authority showMenu(int authId) {
		// TODO Auto-generated method stub
		
		sql="select AUTHORITYID,AUTHORITY_NAME,ACTION,AUTHORITY_PARENTID from authority  where authorityid=?";
		
		Authority auth = null;
		
		ResultSet rs = util.Query(sql, authId);
		
		try {
			while(rs.next())
			{
				auth = new Authority(rs.getInt("AUTHORITYID"),rs.getString("AUTHORITY_NAME"),rs.getString("ACTION"),
						rs.getInt("AUTHORITY_PARENTID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return auth;
	}



	
	
	
	/**
	 * @param parentId
	 * @return
	 * 
	 */
	public List<Authority> GetChildMenu(int parentId) {
		// TODO Auto-generated method stub
		
		sql="select auth.authorityid,  auth.Authority_name,auth.action,auth.authority_parentid from authority auth,authority au " +
				"where auth.authority_parentid =au.authorityid and au.authorityid=? order by authorityid asc";
		
		ResultSet rs = util.Query(sql, parentId);
		
	
		List<Authority> authList = new ArrayList<Authority>();
		
		try {
			while(rs.next())
			{
				Authority auth = new Authority(rs.getInt("AUTHORITYID"),rs.getString("AUTHORITY_NAME"),rs.getString("ACTION"),
						rs.getInt("authority_parentid"));
				
				authList.add(auth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return authList;
	}
}


