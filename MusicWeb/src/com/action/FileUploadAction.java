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
 * 2015-4-2����3:59:51
 *
 *MusicWeb.com.action.FileUploadAction
 */
public class FileUploadAction extends BaseAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * �ϴ���������ʱ�ļ�������ļ�
	 */
	private File file;
	
	/**
	 * �ļ�����
	 */
	private String fileFileName;
	
	/**
	 * �ļ�������
	 */
	private String fileContentType;
	
	
	/**
	 * ͼƬ�����·��
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
	 * �޸��û�ͷ��
	 */
	public String changeUserPicture() throws Exception
	{
		 String root = ServletActionContext.getServletContext().getRealPath(picSavePath);
		
	        InputStream is = new FileInputStream(file);

	        OutputStream os = new FileOutputStream(new File(root, fileFileName));
	        
	        
       /* //filePath=savePath+"/"+fileFileName;
	        
	        System.out.println("fileFileName: " + fileFileName);
	        System.out.println(root+"\\"+fileFileName);
	       // ��Ϊfile�Ǵ������ʱ�ļ��е��ļ������ǿ��Խ����ļ������ļ�·����ӡ����������֮ǰ��fileFileName�Ƿ���ͬ
	        System.out.println("file: " + file.getName());
	        System.out.println("file: " + file.getPath());
	      
	       
	        System.out.println("�ļ����ͣ�"+fileContentType);*/
	       
	 
	        byte[] buffer = new byte[500];
	        @SuppressWarnings("unused")
			int length = 0;
	        
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
	        
	        os.close();
	        is.close();
	        
	        
	        //�޸��û�ͷ��
	        memberPicture=picSavePath+"/"+fileFileName;
			
			userbiz.changeUserPicture(memberPicture, memberId);
				
				return "changeUserPicture";
	       
	}
	
	
	
	
	/**
	 * ����ͼƬ����·��
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
	 * ���Ӹ�����Ϣ
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

