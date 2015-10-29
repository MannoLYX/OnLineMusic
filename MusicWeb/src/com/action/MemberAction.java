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
 * 2015-3-11下午2:53:14
 *
 *MusicWeb.action.MemberAction
 *前端Action
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
	 * 用于管理员对用户的管理
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
	 * 用户登录
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
	 * 显示菜单目录
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
	 * 获得子菜单 信息
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
	 * 管理员增加成员信息
	 */
	public String addMemberByUser()
	{
		java.util.Date curDate = new java.util.Date();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(curDate.getTime()));// new Date()为获取当前系统时间
		
		mUser.setRegisterDate(new java.sql.Date(curDate.getTime()));
		
		if(userbiz.addMemberUserByUser(mUser))
		
			return "addMemberByUser";
		else
			return "error";
	}
	
	
	/**
	 * @return
	 * 管理员增加成员信息
	 */
	PersonRoleBiz roleBiz = new PersonRoleBizImpl();
	
	public String AdminAddMember()
	{
		java.util.Date curDate = new java.util.Date();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(curDate.getTime()));// new Date()为获取当前系统时间
		
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
	 * 删除用户信息
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
	 * 更新用户信息
	 */
	@SuppressWarnings("unchecked")
	public String updateMember()
	{
		if(userbiz.updateMemberUser(mUser))
		{
			
			//根据MemberID重新查找一遍，防止更新不及时
			mUserRole = userbiz.queryMemberUserRoleById(mUser.getMemberId());
			mUser = userbiz.queryMemberUserById(mUser.getMemberId());
			
			//把获取的新的值重新设置到session会话中
			sessionMap.put("mUser", mUser);
			
		return "updateMember";
		}
		else
			return "error";
			
	}
	
	/**
	 * @return
	 * 管理员更新用户信息
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
	 * 修改用户密码
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
	 * 通过用户名查找 会员
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
	 * 通过ID查找以便 用户更新
	 */
	public String queryMemberById()
	{
		//mUser=userbiz.queryMemberUserById(memberId);
	
		//mUserRole = userbiz.queryMemberUserRoleById(memberId);
		
		mUser = userbiz.queryMemberUserById(memberId);
	
		return "queryMemberById";
	}
	
	
	/**
	 * admin通过ID查找以便更新
	 */
	public String adminQueryMemberById()
	{
		user= userbiz.queryMemberUserById(memberId);
		app.setAttribute("user", user);
		
		
		
		return "adminQueryMemberById";
	}
	
	/**
	 * admin通过ID查看用户信息
	 */
	public String adminCheckMemberById()
	{
		
		
		user= userbiz.queryMemberUserById(memberId);
		
			app.setAttribute("user", user);
			
		return "adminCheckMemberById";
	}
	
	
	/**
	 * 用户通过ID查找
	 */
	public String queryMyInfo()
	{
		mUser=userbiz.queryMemberUserById(memberId);
		return "queryMyInfo";
	}
	
	/**
	 * @return
	 * 通过ID查找roleInfo
	 */
	public String queryMyRoleInfo()
	{
		mUserRole=userbiz.queryMemberUserRoleById(memberId);
		
		return "queryMyRoleInfo";
	}
	
	/**
	 * @return
	 * 查询最近十位 会员信息
	 */
	public String queryMemberUserInfoRecently()
	{
		List<MemberUserRole> RecentUserInfo = userbiz.queryMemberUserInfoRecently();
		
		app.setAttribute("RecentUserInfo",RecentUserInfo);
		
		return "queryMemberUserInfoRecently";
	}
	
	
	/**
	 * @return
	 * 查询用户的积分排序
	 */
	public String queryMemberUserInfoByIntegral()
	{
		List<MemberUserRole> IntegralUserInfo = userbiz.queryMemberUserInfoByIntegral();
		
		app.setAttribute("IntegralUserInfo",IntegralUserInfo);
		
		return "queryMemberUserInfoByIntegral";
	}
	
	/**
	 * @return
	 * 查询全部 会员信息
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
	 * 查询12个歌手信息
	 */
	public String querySingerInfoByNumber()
	{
		List<Singer> singerList =singerbiz.querySingerInfoByNumber();
		
		app.setAttribute("singerList", singerList);
		
		int m=0;
		req.setAttribute("m",m);
		
		
		return "querySingerInfoByNumber";
	}
	
	//歌手
	
	/**
	 * @return
	 * 查询全部信息
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
	 * 遍历全部歌曲信息
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
	 * 查询12张的悦单信息
	 */
	public String querySongListInfoByNumber()
	{
		List<SongList> songList = songListbiz.querySongListInfoByNumber();
		
		app.setAttribute("songList", songList);
		
	
		return "querySongListInfoByNumber";
	}
	
	
	//风格类别的处理
	
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
	
	
	//情感分类
	
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
	 * 显示管理员首页
	 */
	public String showMainPage()
	{
		int showMainPage=0;
		req.setAttribute("showMainPage", showMainPage);
		return "showMainPage";
	}
	
	
	//加减积分
	
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

	
	
	//Ajax验证用户名，防止重復
	private String accounterNumber;
	
	public String getAccounterNumber() {
		return accounterNumber;
	}

	public void setAccounterNumber(String accounterNumber) {
		this.accounterNumber = accounterNumber;
	}

	public void CheckAccounterNumber()
	{
		//查找該用戶名是否存在
		mUserRole=userbiz.queryMemberUserInfobyAccountName(accounterNumber);
		
		//設置响应编码UTF-8，防止中文乱码
		res.setContentType("text/html;charset=UTF-8");   
		  
		if(mUserRole!=null)
		{
		try {
			res.getWriter().write("用户名已经存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
		try {
			res.getWriter().write("此用户名可用");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}
	
	
	
	
	
	
	/**
	 * 登录时验证用户名或密码是否正确
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
		//查找該用戶名是否存在
		mUserRole=userbiz.queryMemberUserInfobyAccountName(accounterNumber);
		
		//設置响应编码UTF-8，防止中文乱码
		res.setContentType("text/html;charset=UTF-8");   
		  
		if(mUserRole==null)
		{
			try {
				res.getWriter().write("用户名不存在");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}		
		}else if(mUserRole!=null && (!pwd.equals(mUserRole.getPwd())))
		{
			try {
				res.getWriter().write("用户名和密码不匹配");
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
