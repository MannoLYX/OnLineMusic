package com.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.entity.MemberUser;
import com.opensymphony.xwork2.ActionSupport;

/**
 
 *	
 * 2015-3-12下午2:10:29
 *
 *MusicWeb.action.BaseAction
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,
ServletContextAware,SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	protected ServletContext app;
	@SuppressWarnings("rawtypes")
	protected Map sessionMap;

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public HttpServletResponse getRes() {
		return res;
	}

	public void setRes(HttpServletResponse res) {
		this.res = res;
	}

	public ServletContext getApp() {
		return app;
	}

	public void setApp(ServletContext app) {
		this.app = app;
	}

	@SuppressWarnings("unchecked")
	public Map<String, MemberUser> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(@SuppressWarnings("rawtypes") Map sessionMap) {
		this.sessionMap = sessionMap;
	}

	public void setServletContext(ServletContext app) {
		// TODO Auto-generated method stub
		this.app=app;
	}

	public void setServletResponse(HttpServletResponse res) {
		// TODO Auto-generated method stub
		this.res=res;
	}

	public void setServletRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.req=req;
	}

	public void setSession(@SuppressWarnings("rawtypes") Map sessionMap) {
		// TODO Auto-generated method stub
		this.sessionMap=sessionMap;
	}


	
	/**
	 * @param mUser
	 * 将登录的用户信息保存到 sessionMap中
	 */
	@SuppressWarnings("unchecked")
	public void saveLoginUser(MemberUser mUser)
	{
		sessionMap.put("memberUser",mUser);
	}
	
	/**
	 * @return
	 * 获取登录的用户信息
	 */
	public MemberUser queryLoginUserInfo()
	{
		MemberUser mUser =(MemberUser) sessionMap.get("memberUser");
		
		return mUser;
	}
	
}
