package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.struts2.ServletActionContext;

import com.biz.MemberUserBiz;
import com.biz.MusicBiz;
import com.biz.SingerBiz;
import com.biz.bizImpl.MemberUserBizImpl;
import com.biz.bizImpl.MusicBizImpl;
import com.biz.bizImpl.SingerBizImpl;
import com.entity.EmotionCategory;
import com.entity.Music;
import com.entity.Singer;
import com.entity.StyleCategory;

/**
 *	
 * 2015-4-2下午3:59:51
 *
 *MusicWeb.com.action.FileUploadAction
 */
public class FileUploadAction extends BaseAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * 上传后存放在临时文件夹里的文件
	 */
	private File file;
	
	/**
	 * 文件名称
	 */
	private String fileFileName;
	
	/**
	 * 文件的类型
	 */
	private String fileContentType;
	
	
	/**
	 * 图片保存的路径
	 */
	private String picSavePath;
	
	public String getPicSavePath() {
		return picSavePath;
	}

	public void setPicSavePath(String picSavePath) {
		this.picSavePath = picSavePath;
	}

	

	
	
	
	private String memberPicture;
	private int memberId;

	public String getMemberPicture() {
		return memberPicture;
	}

	public void setMemberPicture(String memberPicture) {
		this.memberPicture = memberPicture;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	MemberUserBiz userbiz = new MemberUserBizImpl();
	
	/**
	 * @return
	 * @throws Exception
	 * 修改用户头像
	 */
	public String changeUserPicture() throws Exception
	{
		 String root = ServletActionContext.getServletContext().getRealPath(picSavePath);
		
	        InputStream is = new FileInputStream(file);

	        OutputStream os = new FileOutputStream(new File(root, fileFileName));
	        
	        
       /* //filePath=savePath+"/"+fileFileName;
	        
	        System.out.println("fileFileName: " + fileFileName);
	        System.out.println(root+"\\"+fileFileName);
	       // 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
	        System.out.println("file: " + file.getName());
	        System.out.println("file: " + file.getPath());
	      
	       
	        System.out.println("文件类型："+fileContentType);*/
	       
	 
	        byte[] buffer = new byte[500];
	        @SuppressWarnings("unused")
			int length = 0;
	        
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
	        
	        os.close();
	        is.close();
	        
	        
	        //修改用户头像
	        memberPicture=picSavePath+"/"+fileFileName;
			
			userbiz.changeUserPicture(memberPicture, memberId);
				
				return "changeUserPicture";
	       
	}
	
	
	
	
	/**
	 * 歌曲图片保存路径
	 */
	private String singerSavePath;
	
	public String getSingerSavePath() {
		return singerSavePath;
	}

	public void setSingerSavePath(String singerSavePath) {
		this.singerSavePath = singerSavePath;
	}

	SingerBiz singerbiz = new SingerBizImpl();
	/**
	 * @return
	 * @throws Exception
	 * 增加歌手信息
	 */
	public String addSingerInfo() throws Exception
	{
		 String root = ServletActionContext.getServletContext().getRealPath(singerSavePath);
		
	        InputStream is = new FileInputStream(file);

	        OutputStream os = new FileOutputStream(new File(root, fileFileName));
	        
	        
	        byte[] buffer = new byte[500];
	        @SuppressWarnings("unused")
			int length = 0;
	        
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
	        
	        os.close();
	        is.close();
	        
	        
	        String singerName = req.getParameter("singerName");
			String singerCountry = req.getParameter("singerCountry");
			String singerGender =req.getParameter("singerGender");		
			String singerPicture = singerSavePath+fileFileName;
			int popularity =Integer.valueOf(req.getParameter("popularity"));
			String times = req.getParameter("times");

			Singer singer = new Singer(singerName,singerPicture,singerCountry,singerGender,popularity,
					times);
			
			boolean isok=singerbiz.addSinger(singer);
			if(isok)
			{
				int operate=0;
				req.setAttribute("operate", operate);
				return "addSingerInfo";
			}
			else
				return "error";
		
	}
	
	
}

