package com.action;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;

import com.biz.EmotionCategoryBiz;
import com.biz.MemberUserBiz;
import com.biz.MusicBiz;
import com.biz.PersonRoleBiz;
import com.biz.RoleMenuBiz;
import com.biz.SingerBiz;
import com.biz.SongListBiz;
import com.biz.StyleCategoryBiz;
import com.biz.bizImpl.EmotionCategoryBizImpl;
import com.biz.bizImpl.MemberUserBizImpl;
import com.biz.bizImpl.MusicBizImpl;
import com.biz.bizImpl.PersonRoleBizImpl;
import com.biz.bizImpl.RoleMenuBizImpl;
import com.biz.bizImpl.SingerBizImpl;
import com.biz.bizImpl.SongListBizImpl;
import com.biz.bizImpl.StyleCategoryBizImpl;
import com.entity.Authority;
import com.entity.EmotionCategory;
import com.entity.MemberUser;
import com.entity.MemberUserRole;
import com.entity.MusicInfo;
import com.entity.PersonRole;
import com.entity.Singer;
import com.entity.SongList;
import com.entity.StyleCategory;
import com.opensymphony.xwork2.Action;


/**
 *	
 * 2015-3-11����2:53:14
 *
 *MusicWeb.action.MemberAction
 *ǰ��Action
 */
public class MemberAction extends BaseAction implements Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// public MemberUser mUser = new MemberUser();
	private MemberUser mUser;
	private int memberId;
	private MemberUserRole mUserRole;
	private int authority_parentId;
	



	/**
	 * ���ڹ���Ա���û��Ĺ���
	 */
	private MemberUser user;



	public MemberUser getUser() {
		return user;
	}



	public void setUser(MemberUser user) {
		this.user = user;
	}



	public int getAuthority_parentId() {
		return authority_parentId;
	}



	public void setAuthority_parentId(int authority_parentId) {
		this.authority_parentId = authority_parentId;
	}



	public MemberUserRole getmUserRole() {
		return mUserRole;
	}



	public void setmUserRole(MemberUserRole mUserRole) {
		this.mUserRole = mUserRole;
	}



	public int getMemberId() {
		return memberId;
	}



	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}



	public MemberUser getmUser() {
		return mUser;
	}



	public void setmUser(MemberUser mUser) {
		this.mUser = mUser;
	}


	MemberUserBiz userbiz = new MemberUserBizImpl();
	
	RoleMenuBiz menubiz = new RoleMenuBizImpl();
	
	
	/**
	 * @return
	 * �û���¼
	 */
	@SuppressWarnings("unchecked")
	public String logIn()
	{
		if((mUser=userbiz.UserlogIn(mUser.getAccountNumber(),mUser.getPwd()))!=null)
		{
			mUserRole=userbiz.queryMemberUserRoleById(mUser.getMemberId());
			sessionMap.put("mUserRole", mUserRole);
			
			sessionMap.put("mUser", mUser);
			return "logIn";
		}
		else
			return "nologIn";
	}
	
	

	/**
	 * @return
	 * ��ʾ�˵�Ŀ¼
	 */
	@SuppressWarnings("unchecked")
	public String showMenu()
	{	
		List<Authority> menuList = new ArrayList<Authority>();
		menuList=menubiz.checkMenu(mUser.getRoleId());		
		
	
		sessionMap.put("menuList", menuList);	
		
		if(mUser.getRoleId()==1)
		{
		
			return "showAdminMenu";
		}else
		{
			return "showUserMenu";
		}
		//GetChildMenu();
		//sessionMap.put("childMenuList", childMenuList);
		
	}
	
	/**
	 * @return
	 * ����Ӳ˵� ��Ϣ
	 *//*
	
	public String GetChildMenu()
	{
		List<Authority> childMenuList =menubiz.GetChildMenu(authority_parentId);
		
		for (Authority a : childMenuList) {
			System.out.println(a.getAuthorityId()+","+a.getAuthorityName()+","+a.getAuthority_parentId());
		}
		
		app.setAttribute("childMenuList", childMenuList);
		
		return "GetChildMenu";
	}
	*/
	
	/**
	 * @return
	 * ����Ա���ӳ�Ա��Ϣ
	 */
	public String addMemberByUser()
	{
		java.util.Date curDate = new java.util.Date();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		System.out.println(df.format(curDate.getTime()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		
		mUser.setRegisterDate(new java.sql.Date(curDate.getTime()));
		
		if(userbiz.addMemberUserByUser(mUser))
		
			return "addMemberByUser";
		else
			return "error";
	}
	
	
	/**
	 * @return
	 * ����Ա���ӳ�Ա��Ϣ
	 */
	PersonRoleBiz roleBiz = new PersonRoleBizImpl();
	
	public String AdminAddMember()
	{
		java.util.Date curDate = new java.util.Date();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		System.out.println(df.format(curDate.getTime()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		
		mUser.setRegisterDate(new java.sql.Date(curDate.getTime()));
		
		String roleName= req.getParameter("roleId");
		
		PersonRole pRole= roleBiz.queryPersonRoleInfoByRoleName(roleName);
		
		mUser.setRoleId(pRole.getRoleId());
		
		
		if(userbiz.addMemberUser(mUser))
		
		return "AdminAddMember";
		
		else
			return "error";
	}
	
	/**
	 * @return
	 * ɾ���û���Ϣ
	 */
	public String deleteMember()
	{
		
		if(userbiz.deleteMemberUser(memberId))
		
		return "deleteMember";
		else
			return "error";
	}

	/**
	 * @return
	 * �����û���Ϣ
	 */
	@SuppressWarnings("unchecked")
	public String updateMember()
	{
		if(userbiz.updateMemberUser(mUser))
		{
			
			//����MemberID���²���һ�飬��ֹ���²���ʱ
			mUserRole = userbiz.queryMemberUserRoleById(mUser.getMemberId());
			mUser = userbiz.queryMemberUserById(mUser.getMemberId());
			
			//�ѻ�ȡ���µ�ֵ�������õ�session�Ự��
			sessionMap.put("mUser", mUser);
			
		return "updateMember";
		}
		else
			return "error";
			
	}
	
	/**
	 * @return
	 * ����Ա�����û���Ϣ
	 */
	public String adminUpdateMemberInfo()
	{
		int memberId =Integer.valueOf(req.getParameter("memberId"));
		String memberName = req.getParameter("memberName");
		String accountNumber = req.getParameter("accountNumber");
		String pwd = req.getParameter("pwd");
		String memberEmail = req.getParameter("memberEmail");
		String gender = req.getParameter("gender");
		int age =Integer.valueOf(req.getParameter("age"));
		java.sql.Date birthday =java.sql.Date.valueOf( req.getParameter("birthday"));		
		java.sql.Date registerDate = java.sql.Date.valueOf(req.getParameter("registerDate"));
		
		String roleName = req.getParameter("roleId");
		PersonRole pRole= roleBiz.queryPersonRoleInfoByRoleName(roleName);
		
		String memberLabel = req.getParameter("memberLabel");
		int memberIntegral=Integer.valueOf( req.getParameter("memberIntegral"));
		String memberIntroduction = req.getParameter("memberIntroduction");
		String memberPicture = req.getParameter("memberPicture");
		
		user = new MemberUser(memberId,memberName,age,gender,birthday,memberLabel,memberIntroduction,memberPicture,
				registerDate,pRole.getRoleId(),pwd,memberIntegral,accountNumber,memberEmail);
		
		if(userbiz.adminUpdateMemberUser(user))
			
		return "adminUpdateMemberInfo";
		
		else
			return "error";
	}
	

	
	
	/**
	 * @return
	 * �޸��û�����
	 */
	public String changeuserPwd()
	{
	String newpwd=req.getParameter("newPWD");
		if(userbiz.changePwd(memberId,newpwd))
		
		return "changeuserPwd";
		
		else
		{
		return "error";
		}
	}
	
	/**
	 * @return
	 * ͨ���û������� ��Ա
	 */
	public String queryMemberByAccountName()
	{
		String name=req.getParameter("searchName");
		mUserRole=userbiz.queryMemberUserInfobyAccountName(name);
		
		app.setAttribute("mUserRole",mUserRole );
		
		if(mUserRole==null)
		{
			int isnull =0;
			req.setAttribute("isnull", isnull);
		}
		int a=9;
		req.setAttribute("a",a);
		return "queryMemberByAccountName";
	}
	
	/**
	 * ͨ��ID�����Ա� �û�����
	 */
	public String queryMemberById()
	{
		//mUser=userbiz.queryMemberUserById(memberId);
	
		//mUserRole = userbiz.queryMemberUserRoleById(memberId);
		
		mUser = userbiz.queryMemberUserById(memberId);
	
		return "queryMemberById";
	}
	
	
	/**
	 * adminͨ��ID�����Ա����
	 */
	public String adminQueryMemberById()
	{
		user= userbiz.queryMemberUserById(memberId);
		app.setAttribute("user", user);
		
		
		
		return "adminQueryMemberById";
	}
	
	/**
	 * adminͨ��ID�鿴�û���Ϣ
	 */
	public String adminCheckMemberById()
	{
		
		
		user= userbiz.queryMemberUserById(memberId);
		
			app.setAttribute("user", user);
			
		return "adminCheckMemberById";
	}
	
	
	/**
	 * �û�ͨ��ID����
	 */
	public String queryMyInfo()
	{
		mUser=userbiz.queryMemberUserById(memberId);
		return "queryMyInfo";
	}
	
	/**
	 * @return
	 * ͨ��ID����roleInfo
	 */
	public String queryMyRoleInfo()
	{
		mUserRole=userbiz.queryMemberUserRoleById(memberId);
		
		return "queryMyRoleInfo";
	}
	
	/**
	 * @return
	 * ��ѯ���ʮλ ��Ա��Ϣ
	 */
	public String queryMemberUserInfoRecently()
	{
		List<MemberUserRole> RecentUserInfo = userbiz.queryMemberUserInfoRecently();
		
		app.setAttribute("RecentUserInfo",RecentUserInfo);
		
		return "queryMemberUserInfoRecently";
	}
	
	
	/**
	 * @return
	 * ��ѯ�û��Ļ�������
	 */
	public String queryMemberUserInfoByIntegral()
	{
		List<MemberUserRole> IntegralUserInfo = userbiz.queryMemberUserInfoByIntegral();
		
		app.setAttribute("IntegralUserInfo",IntegralUserInfo);
		
		return "queryMemberUserInfoByIntegral";
	}
	
	/**
	 * @return
	 * ��ѯȫ�� ��Ա��Ϣ
	 */
	public String queryAllMemberUserInfo()
	{
		List<MemberUserRole> allUserInfo = userbiz.queryAllMemberUserInfo();
		
		app.setAttribute("allUserInfo",allUserInfo);
		
		int a=0;
		req.setAttribute("a", a);
		
		
		
		return "queryAllMemberUserInfo";
	}
	
	
	
	
	
	SingerBiz singerbiz = new SingerBizImpl();
	/**
	 * @return
	 * ��ѯ12��������Ϣ
	 */
	public String querySingerInfoByNumber()
	{
		List<Singer> singerList =singerbiz.querySingerInfoByNumber();
		
		app.setAttribute("singerList", singerList);
		
		int m=0;
		req.setAttribute("m",m);
		
		
		return "querySingerInfoByNumber";
	}
	
	//����
	
	/**
	 * @return
	 * ��ѯȫ����Ϣ
	 */
	@SuppressWarnings("unchecked")
	public String queryAllSingerInfo()
	{
		List<Singer> allSingerList =singerbiz.queryAllSingerInfo();
		
		sessionMap.put("allSingerList", allSingerList);
		
		return "queryAllSingerInfo";
	}
	
	
	MusicBiz  musicbiz = new MusicBizImpl();
	/**
	 * @return
	 * ����ȫ��������Ϣ
	 */
	public String queryAllMusicInfoByNumber()
	{
		List<MusicInfo> allmusicList=musicbiz.queryAllMusicInfoByNumber();
		
		app.setAttribute("allmusicList", allmusicList);
		
		return "queryAllMusicInfoByNumber";
	}
	

	
	
	SongListBiz songListbiz =new SongListBizImpl();
	
	/**
	 * @return
	 * ��ѯ12�ŵ��õ���Ϣ
	 */
	public String querySongListInfoByNumber()
	{
		List<SongList> songList = songListbiz.querySongListInfoByNumber();
		
		app.setAttribute("songList", songList);
		
	
		return "querySongListInfoByNumber";
	}
	
	
	//������Ĵ���
	
	StyleCategoryBiz stylebiz = new StyleCategoryBizImpl();
		
	/**
	 * @return
	 */
	public String queryAllStyleInfo()
	{
		List<StyleCategory> styleList=stylebiz.queryAllStyleInfo();
		app.setAttribute("styleList", styleList);
		return "queryAllStyleInfo";
	}
	
	
	//��з���
	
	EmotionCategoryBiz emotionbiz = new EmotionCategoryBizImpl();

	/**
	 * @return
	 */
	public String queryAllemotionInfo()
	{
		List<EmotionCategory> emotionList = emotionbiz.queryAllemotionInfo();
		
		app.setAttribute("emotionList", emotionList);
		
		return "queryAllemotionInfo";
	}
	
	
	/**
	 * @return
	 * ��ʾ����Ա��ҳ
	 */
	public String showMainPage()
	{
		int showMainPage=0;
		req.setAttribute("showMainPage", showMainPage);
		return "showMainPage";
	}
	
	
	//�Ӽ�����
	
	public String reducedIntegral()
	{
		if(userbiz.reducedIntegral(memberId))
		{
			return "reducedIntegral";
		}else
		{
			return "error";
		}
	}
	
	public String addIntegral()
	{
		if(userbiz.addIntegral(memberId))
		{
			return "addIntegral";
		}else
		{
			return "error";
		}
	}

	
	
	//Ajax��֤�û�������ֹ�؏�
	private String accounterNumber;
	
	public String getAccounterNumber() {
		return accounterNumber;
	}

	public void setAccounterNumber(String accounterNumber) {
		this.accounterNumber = accounterNumber;
	}

	public void CheckAccounterNumber()
	{
		//����ԓ�Ñ����Ƿ����
		mUserRole=userbiz.queryMemberUserInfobyAccountName(accounterNumber);
		
		//�O����Ӧ����UTF-8����ֹ��������
		res.setContentType("text/html;charset=UTF-8");   
		  
		if(mUserRole!=null)
		{
		try {
			res.getWriter().write("�û����Ѿ�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
		try {
			res.getWriter().write("���û�������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}
	
	
	
	
	
	
	/**
	 * ��¼ʱ��֤�û����������Ƿ���ȷ
	 */
	
	private String pwd;
	
	
	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void CheckLogin()
	{
		//����ԓ�Ñ����Ƿ����
		mUserRole=userbiz.queryMemberUserInfobyAccountName(accounterNumber);
		
		//�O����Ӧ����UTF-8����ֹ��������
		res.setContentType("text/html;charset=UTF-8");   
		  
		if(mUserRole==null)
		{
			try {
				res.getWriter().write("�û���������");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}		
		}else if(mUserRole!=null && (!pwd.equals(mUserRole.getPwd())))
		{
			try {
				res.getWriter().write("�û��������벻ƥ��");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			logIn();
		}
	}
}
