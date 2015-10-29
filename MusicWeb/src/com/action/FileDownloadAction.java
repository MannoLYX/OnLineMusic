package com.action;

import java.io.IOException;
import java.io.InputStream;
import org.apache.struts2.ServletActionContext;

import com.biz.MemberUserBiz;
import com.biz.bizImpl.MemberUserBizImpl;

/**
 *	
 * 2015-4-2下午4:31:07
 *
 *MusicWeb.com.action.FileDownloadAction
 */
public class FileDownloadAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 文件名称
	 */
	private String fileName;
	private int memberId;
	
	
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getFileName() throws IOException {
		
	
		return  new String(fileName.getBytes(), "ISO8859-1");
	}
	
		public void setFileName(String fileName) {
			
				this.fileName = fileName;;
		
		}
		
		MemberUserBiz biz = new MemberUserBizImpl();
		
		 public InputStream getInputStream() throws Exception{
			 	
			// String filePath = "upload/"+fileName;
			 	
			 	
			 return ServletActionContext.getServletContext().getResourceAsStream( fileName);
			  
			   }
			 
			    public String execute()throws Exception{
			    	
			    	biz.reducedIntegral(memberId);//下载，减积分
					return SUCCESS;
				}
}
