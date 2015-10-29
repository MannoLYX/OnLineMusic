package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.biz.MusicBiz;
import com.biz.SingerBiz;
import com.biz.bizImpl.MusicBizImpl;
import com.biz.bizImpl.SingerBizImpl;
import com.entity.EmotionCategory;
import com.entity.Music;
import com.entity.Singer;
import com.entity.StyleCategory;

/**
 *	
 * 2015-4-9����10:06:34
 *
 *MusicWeb.com.action.UploadAction
 *�ϴ�������Ϣ ��.mp3��ͼƬ ���ļ��ϴ���
 */
public class UploadAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ʹ��List�ϴ�����ļ�
	 * 
	 *
	 */
	    private List<File> image; // �ϴ����ļ�
	    private List<String> imageFileName; // �ļ�����
	    private List<String> imageContentType; // �ļ�����
	    private String savePath;
	    
	    
	    
		//���ĸ�����Ϣ
		
		private StyleCategory styleCategory;
		private EmotionCategory emotionCategory;
		
		
		public StyleCategory getStyleCategory() {
			return styleCategory;
		}

		public void setStyleCategory(StyleCategory styleCategory) {
			this.styleCategory = styleCategory;
		}

		public EmotionCategory getEmotionCategory() {
			return emotionCategory;
		}

		public void setEmotionCategory(EmotionCategory emotionCategory) {
			this.emotionCategory = emotionCategory;
		}

		MusicBiz musicbiz = new MusicBizImpl();
		
	    @Override
	    public String execute() throws Exception {
	        ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
	        // ȡ����Ҫ�ϴ����ļ�����
	        List<File> files = getImage();
	        if (files != null && files.size() > 0) {
	            for (int i = 0; i < files.size(); i++) {
	                FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + getImageFileName().get(i));
	                FileInputStream fis = new FileInputStream(files.get(i));
	                byte[] buffer = new byte[1024];
	                int len = 0;
	                while ((len = fis.read(buffer)) > 0) {
	                    fos.write(buffer, 0, len);
	                }
	                fis.close();
	                fos.close();
	            }
	        }
	        
	        //����������Ϣ
	        String musicName = req.getParameter("musicName");
			String singerName =req.getParameter("singerName");
			
			SingerBiz singerbiz = new SingerBizImpl();
			Singer singer = singerbiz.querySingerInfoBySingerName(singerName);
			
			String musicInstruction =req.getParameter("musicInstruction");
			
			int styleId=styleCategory.getStyleId();
			int emotionId =emotionCategory.getEmotionId();
			String musicPicture = savePath+ getImageFileName().get(1);//req.getParameter("musicPicture");
			String musicLyrics =req.getParameter("musicLyrics");
			String musicPath = savePath+ getImageFileName().get(0);
			
			Music music = new Music( musicName,singer.getSingerId(),musicPicture,  musicLyrics, musicInstruction,styleId, emotionId, musicPath);
			
			
			
			if(musicbiz.addMusic(music))
			{
				int operate=0;
				req.setAttribute("operate", operate);
				return "addMusicInfo";
			}
			else
				return "error";
	        
	    }

	    public List<File> getImage() {
	        return image;
	    }

	    public void setImage(List<File> image) {
	        this.image = image;
	    }

	    public List<String> getImageFileName() {
	        return imageFileName;
	    }

	    public void setImageFileName(List<String> imageFileName) {
	        this.imageFileName = imageFileName;
	    }

	    public List<String> getImageContentType() {
	        return imageContentType;
	    }

	    public void setImageContentType(List<String> imageContentType) {
	        this.imageContentType = imageContentType;
	    }

	    /**
	     * �����ϴ��ļ������λ��
	     * 
	     * @return
	     * @throws Exception
	     */
	    public String getSavePath() throws Exception {
	        return ServletActionContext.getServletContext().getRealPath(savePath);
	    }

	    public void setSavePath(String savePath) {
	        this.savePath = savePath;
	    }

	}

