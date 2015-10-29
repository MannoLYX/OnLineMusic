package com.action;

import java.util.List;

import com.biz.PersonRoleBiz;
import com.biz.bizImpl.PersonRoleBizImpl;
import com.entity.PersonRole;

/**
 * 
 *         2015-3-27����10:49:37
 * 
 *         MusicWeb.com.action.PersonRoleAction
 */
public class PersonRoleAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PersonRole pRole;

	private int roleId;

	private String[] authArray;

	public String[] getAuthArray() {
		return authArray;
	}

	public void setAuthArray(String[] authArray) {
		this.authArray = authArray;
	}

	public PersonRole getPRole() {
		return pRole;
	}

	public void setPRole(PersonRole pRole) {
		this.pRole = pRole;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	PersonRoleBiz rolebiz = new PersonRoleBizImpl();

	/**
	 * @return ��� ��ɫ��Ϣ
	 */
	public String addPersonRole() {
		String roleName = req.getParameter("roleName");

		// ��ȡȨ����Ϣ
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < authArray.length; i++) {

			strBuf.append(",").append(authArray[i]);
		}
		String authority_RoleId = strBuf.deleteCharAt(0).toString();

		pRole = new PersonRole(roleName, authority_RoleId);

		if (rolebiz.addPersonRole(pRole))

			return "addPersonRole";
		else
			return "error";

	}

	/**
	 * @return ɾ�� ��ɫ��Ϣ
	 */
	public String deletePersonRole() {
		if (rolebiz.deletePersonRole(roleId))

			return "deletePersonRole";
		else
			return "error";
	}

	/**
	 * @param pRole
	 * @return �޸� ��Ա��Ϣ
	 */
	public String updatePersonRole() {
		int roleId = Integer.valueOf(req.getParameter("roleId"));

		String roleName = req.getParameter("roleName");

		// ��ȡȨ����Ϣ
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < authArray.length; i++) {

			strBuf.append(",").append(authArray[i]);
		}
		String authority_RoleId = strBuf.deleteCharAt(0).toString();

		pRole = new PersonRole(roleId, roleName, authority_RoleId);

		if (rolebiz.updatePersonRole(pRole))

			return "updatePersonRole";
		else
			return "error";
	}

	/**
	 * @param roleId
	 * @return ����Աͨ��RoleId ��ѯ������ɫ��Ϣ����
	 */
	public String AdminQueryPersonRoleInfoById() {
		pRole = rolebiz.queryPersonRoleInfoById(roleId);

		app.setAttribute("pRole", pRole);

		return "AdminQueryPersonRoleInfoById";

	}

	/**
	 * @param roleId
	 * @return ����Աͨ��RoleId ��ѯ������ɫ��Ϣ����
	 */
	public String AdminQueryPersonRoleInfoByIdToUpdate() {
		pRole = rolebiz.queryPersonRoleInfoById(roleId);

		app.setAttribute("pRole", pRole);

		return "AdminQueryPersonRoleInfoByIdToUpdate";

	}

	/**
	 * @param roleId
	 * @return ͨ��RoleId ��ѯ����
	 */
	public String queryPersonRoleInfoById() {
		pRole = rolebiz.queryPersonRoleInfoById(roleId);

		int check = 0;
		req.setAttribute("check", check);
		return "queryPersonRoleInfoById";

	}

	/**
	 * @return ���� ȫ���� ��ɫ��Ϣ
	 */
	public String queryPerosonRoleInfo() {
		List<PersonRole> pRoleList = rolebiz.queryPerosonRoleInfo();
		app.setAttribute("pRoleList", pRoleList);

		int update = 0;
		req.setAttribute("update", update);

		return "queryPerosonRoleInfo";

	}

	/**
	 * @return ����Ա ���� ȫ���� ��ɫ��Ϣ
	 */
	public String AdminQueryPerosonRoleInfo() {
		List<PersonRole> pRoleList = rolebiz.queryPerosonRoleInfo();
		app.setAttribute("pRoleList", pRoleList);

		int add = 0;
		req.setAttribute("add", add);

		return "AdminQueryPerosonRoleInfo";

	}

	/**
	 * @return ����Ա ���� ȫ���� ��ɫ��Ϣ��ʾ����Ա��ҳ
	 */
	public String AdminQueryPerosonRole() {
		List<PersonRole> pRoleList = rolebiz.queryPerosonRoleInfo();
		app.setAttribute("pRoleList", pRoleList);

		int a = 8;
		req.setAttribute("a", a);

		return "AdminQueryPerosonRole";

	}

}
