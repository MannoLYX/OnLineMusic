package com.dao;

import java.util.List;

import com.entity.StyleCategory;


/**
 *	
 * 2015-3-10下午1:59:34
 *
 *MusicWeb.dao.StyleCategory
 *
 */
public interface StyleCategoryDao {

	/**
	 * @param style
	 * @return
	 * 增加风格类型
	 */
	public boolean addStyleCategpry(StyleCategory style);
	
	/**
	 * @param styleId
	 * @return
	 * 删除风格
	 */
	public boolean deleteStyleCategory(int styleId);
	
	/**
	 * @param style
	 * @return
	 * 更新 风格
	 */
	public boolean updateStyleCategory(StyleCategory style);
	
	
	/**
	 * @return
	 * 通过StyleId 查找风格类别信息
	 */
	public StyleCategory queryStyleByStyleId(int styleId);
	
	/**
	 * @return
	 * 查找全部风格类别信息
	 */
	public List<StyleCategory> queryAllStyleInfo();
	
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
	public  List<StyleCategory> queryStyleCategoryInfoByPage(int pageNow,int limitPage);
}
