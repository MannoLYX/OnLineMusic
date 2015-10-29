package com.dao;

import java.util.List;

import com.entity.StyleCategory;


/**
 *	
 * 2015-3-10����1:59:34
 *
 *MusicWeb.dao.StyleCategory
 *
 */
public interface StyleCategoryDao {

	/**
	 * @param style
	 * @return
	 * ���ӷ������
	 */
	public boolean addStyleCategpry(StyleCategory style);
	
	/**
	 * @param styleId
	 * @return
	 * ɾ�����
	 */
	public boolean deleteStyleCategory(int styleId);
	
	/**
	 * @param style
	 * @return
	 * ���� ���
	 */
	public boolean updateStyleCategory(StyleCategory style);
	
	
	/**
	 * @return
	 * ͨ��StyleId ���ҷ�������Ϣ
	 */
	public StyleCategory queryStyleByStyleId(int styleId);
	
	/**
	 * @return
	 * ����ȫ����������Ϣ
	 */
	public List<StyleCategory> queryAllStyleInfo();
	
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
	public  List<StyleCategory> queryStyleCategoryInfoByPage(int pageNow,int limitPage);
}
