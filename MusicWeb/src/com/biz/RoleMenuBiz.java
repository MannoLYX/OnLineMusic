package com.biz;

import java.util.List;

import com.entity.Authority;


/**
 *	
 * 2015-3-12����9:59:54
 *
 *MusicWeb.biz.RoleMenuBiz
 *��ʾ�˵�
 */
public interface RoleMenuBiz { 
	
	
	/**
	 * @return
	 * �������û���Ȩ�ޣ��˵���
	 */
	public List<Authority> checkMenu(int userRoleId);
	
	
	
	/**
	 * @param authId
	 * @return
	 * ���� Ȩ��ID ����Ȩ����Ϣ
	 */
	public Authority showMenu(int authId);
	
	
	/**
	 * @param parentId
	 * @return
	 * ͨ�� ��Ȩ��ID��ȡ Ȩ����Ϣ
	 */
	public List<Authority> GetChildMenu(int parentId);
}
