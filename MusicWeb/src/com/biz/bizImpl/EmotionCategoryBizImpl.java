package com.biz.bizImpl;

import java.util.List;

import com.biz.EmotionCategoryBiz;
import com.dao.EmotionCategoryDao;
import com.dao.daoImpl.EmotionCategoryDaoImpl;
import com.entity.EmotionCategory;



/**
 *	
 * 2015-3-10ÏÂÎç2:52:32
 *
 *MusicWeb.biz.bizImpl.EmotionCategoryBizImpl
 */
public class EmotionCategoryBizImpl implements EmotionCategoryBiz{

	EmotionCategoryDao dao = new EmotionCategoryDaoImpl();
	
	
	public boolean addEmotionCategory(EmotionCategory emotion) {
		// TODO Auto-generated method stub
		return dao.addEmotionCategory(emotion);
	}

	public boolean deleteEmotionCategory(int emotionId) {
		// TODO Auto-generated method stub
		return dao.deleteEmotionCategory(emotionId);
	}

	public boolean updateEmotionCategory(EmotionCategory emotion) {
		// TODO Auto-generated method stub
		return dao.updateEmotionCategory(emotion);
	}

	public EmotionCategory queryemotionByemotionId(int emotionId) {
		// TODO Auto-generated method stub
		return dao.queryemotionByemotionId(emotionId);
	}

	public List<EmotionCategory> queryAllemotionInfo() {
		// TODO Auto-generated method stub
		return dao.queryAllemotionInfo();
	}

	public int counterByPage() {
		// TODO Auto-generated method stub
		return dao.counterByPage();
	}

	public List<EmotionCategory> queryEmotionCategoryInfoByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		return dao.queryEmotionCategoryInfoByPage(pageNow, limitPage);
	}

}
