package com.dao;

import java.util.List;

import com.entity.EmotionCategory;


/**
 *	
 * 2015-3-10����2:21:02
 *
 *MusicWeb.dao.EmotionCategoryDao
 */
public interface EmotionCategoryDao {

	/**
	 * @param emotion
	 * @return
	 * ������������
	 */
	public boolean addEmotionCategory(EmotionCategory emotion);
	
	/**
	 * @param emotionId
	 * @return
	 * ɾ������
	 */
	public boolean deleteEmotionCategory(int emotionId);
	
	/**
	 * @param emotion
	 * @return
	 * ���� ����
	 */
	public boolean updateEmotionCategory(EmotionCategory emotion);
	
	
	/**
	 * @return
	 * ͨ��emotionId �������������Ϣ
	 */
	public EmotionCategory queryemotionByemotionId(int emotionId);
	
	/**
	 * @return
	 * ����ȫ�����������Ϣ
	 */
	public List<EmotionCategory> queryAllemotionInfo();
	
	
	/**
	 * @return
	 * ��ȡ�����ܼ�¼��
	 */
	public int counterByPage();
	
	/**
	 * @param pageNum
	 * @param limitPage
	 * @return
	 * ��ѯ�ڼ�ҳ����Ϣ
	 */
	public  List<EmotionCategory> queryEmotionCategoryInfoByPage(int pageNow,int limitPage);

}
