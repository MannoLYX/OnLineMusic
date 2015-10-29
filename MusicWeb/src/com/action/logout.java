package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**

 *	
 * 2015-4-9ÏÂÎç2:33:43
 *
 *MusicWeb.com.action.logout
 *×¢ÏúµÇÂ¼
 */
public class logout extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws IOException{
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		ServletActionContext.getResponse().setHeader("Pragma", "No-cache");
		ServletActionContext.getResponse().setHeader("Cache-Control",
				"no-cache");
		ServletActionContext.getResponse().setDateHeader("Expires", 0);
		session.removeAttribute("mUser");
		
		return "success";
	}
}
