package com.dao;

import java.util.List;

import com.entity.EmotionCategory;


/**
 *	
 * 2015-3-10下午2:21:02
 *
 *MusicWeb.dao.EmotionCategoryDao
 */
public interface EmotionCategoryDao {

	/**
	 * @param emotion
	 * @return
	 * 增加心情类型
	 */
	public boolean addEmotionCategory(EmotionCategory emotion);
	
	/**
	 * @param emotionId
	 * @return
	 * 删除心情
	 */
	public boolean deleteEmotionCategory(int emotionId);
	
	/**
	 * @param emotion
	 * @return
	 * 更新 心情
	 */
	public boolean updateEmotionCategory(EmotionCategory emotion);
	
	
	/**
	 * @return
	 * 通过emotionId 查找心情类别信息
	 */
	public EmotionCategory queryemotionByemotionId(int emotionId);
	
	/**
	 * @return
	 * 查找全部心情类别信息
	 */
	public List<EmotionCategory> queryAllemotionInfo();
	
	
	/**
	 * @return
	 * 获取表中总记录数
	 */
	public int counterByPage();
	
	/**
	 * @param pageNum
	 * @param limitPage
	 * @return
	 * 查询第几页的信息
	 */
	public  List<EmotionCategory> queryEmotionCategoryInfoByPage(int pageNow,int limitPage);

}
