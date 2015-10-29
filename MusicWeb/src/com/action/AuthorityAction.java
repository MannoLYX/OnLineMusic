package com.action;

import java.util.ArrayList;
import java.util.List;

import com.biz.AuthorityBiz;
import com.biz.bizImpl.AuthorityBizImpl;
import com.entity.Authority;
import com.entity.PersonRole;

/**
 * 
 *         2015-4-1上午9:54:41
 * 
 *         MusicWeb.com.action.AuthorityAction
 */
public class AuthorityAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Authority authority;
	private int authorityId;

	private PersonRole pRole;
	private String authority_RoleId;

	private List<Authority> authList;
	private List<Authority> UserAuthList;
	private List<Authority> AdminAuthList;

	public List<Authority> getAdminAuthList() {
		return AdminAuthList;
	}

	public void setAdminAuthList(List<Authority> adminAuthList) {
		AdminAuthList = adminAuthList;
	}

	public List<Authority> getUserAuthList() {
		return UserAuthList;
	}

	public void setUserAuthList(List<Authority> userAuthList) {
		UserAuthList = userAuthList;
	}

	public List<Authority> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Authority> authList) {
		this.authList = authList;
	}

	public PersonRole getpRole() {
		return pRole;
	}

	public void setpRole(PersonRole pRole) {
		this.pRole = pRole;
	}

	public String getAuthority_RoleId() {
		return authority_RoleId;
	}

	public void setAuthority_RoleId(String authority_RoleId) {
		this.authority_RoleId = authority_RoleId;
	}

	public int getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	AuthorityBiz authBiz = new AuthorityBizImpl();

	/**
	 * @return
	 */
	public String addAuthority() {
		if (authBiz.addAuthority(authority))
			return "addAuthority";
		else
			return "error";

	}

	/**
	 * @return
	 */
	public String deleteAuthority() {
		if (authBiz.deleteAuthority(authorityId))
			return "deleteAuthority";
		else
			return "error";
	}

	/**
	 * @return
	 */
	public String queryAuthorityById() {

		authority = authBiz.queryAuthorityById(authorityId);
		return "queryAuthorityById";
	}

	/**
	 * @return 显示角色拥有哪些权限
	 */
	public String queryUserAllAuthority() {

		String[] authArr = authority_RoleId.split(",");
		List<Authority> authList = new ArrayList<Authority>();

		for (int i = 0; i < authArr.length; i++) {

			int index = Integer.valueOf(authArr[i]);
			Authority authority = authBiz.queryAuthorityById(index);
			authList.add(authority);
		}
		app.setAttribute("authList", authList);

		int check = 6;
		req.setAttribute("check", check);

		return "queryUserAllAuthority";
	}

	/**
	 * @return
	 */
	public String queryAuthorityInfo() {
		authList = new ArrayList<Authority>();

		authList = authBiz.queryAuthorityInfo();

		app.setAttribute("authList", authList);

		return "queryAuthorityInfo";
	}

	/**
	 * @return 显示角色拥有哪些权限
	 */
	public String AdminQueryUserAllAuthorityToUpdate() {

		String[] authArr = authority_RoleId.split(",");
		List<Authority> authList = new ArrayList<Authority>();

		for (int i = 0; i < authArr.length; i++) {

			int index = Integer.valueOf(authArr[i]);
			Authority authority = authBiz.queryAuthorityById(index);
			authList.add(authority);
		}
		app.setAttribute("authList", authList);

		return "AdminQueryUserAllAuthorityToUpdate";
	}

	/**
	 * @return 用户权限
	 */
	public String queryUserAuthorityInfo() {
		UserAuthList = new ArrayList<Authority>();

		UserAuthList = authBiz.queryUserAuthorityInfo();

		app.setAttribute("UserAuthList", UserAuthList);

		return "queryUserAuthorityInfo";

	}

	/**
	 * @return 管理员权限
	 */
	public String queryAdminAuthorityInfo() {
		AdminAuthList = new ArrayList<Authority>();

		AdminAuthList = authBiz.queryAdminAuthorityInfo();

		app.setAttribute("AdminAuthList", AdminAuthList);

		int update = 5;
		req.setAttribute("update", update);

		return "queryAdminAuthorityInfo";
	}

	/**
	 * @return 用户权限 用于管理员添加数据
	 */
	public String queryUserAuthorityInfoToAdd() {
		UserAuthList = new ArrayList<Authority>();

		UserAuthList = authBiz.queryUserAuthorityInfo();

		app.setAttribute("UserAuthList", UserAuthList);

		return "queryUserAuthorityInfoToAdd";

	}

	/**
	 * @return 管理员权限 用于管理员添加数据
	 */
	public String queryAdminAuthorityInfoToAdd() {
		AdminAuthList = new ArrayList<Authority>();

		AdminAuthList = authBiz.queryAdminAuthorityInfo();

		app.setAttribute("AdminAuthList", AdminAuthList);

		int add = 5;
		req.setAttribute("add", add);

		return "queryAdminAuthorityInfoToAdd";
	}

}
