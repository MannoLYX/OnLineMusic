package com.biz.bizImpl;

import java.util.List;

import com.biz.StyleCategoryBiz;
import com.dao.StyleCategoryDao;
import com.dao.daoImpl.StyleCategoryDaoImpl;
import com.entity.StyleCategory;



/**
 *	
 * 2015-3-10ÏÂÎç2:49:36
 *
 *MusicWeb.biz.bizImpl.StyleCategoryBizImpl
 */
public class StyleCategoryBizImpl implements StyleCategoryBiz{

	StyleCategoryDao dao = new StyleCategoryDaoImpl();
	
	
	public boolean addStyleCategpry(StyleCategory style) {
		// TODO Auto-generated method stub
		return dao.addStyleCategpry(style);
	}

	public boolean deleteStyleCategory(int styleId) {
		// TODO Auto-generated method stub
		return dao.deleteStyleCategory(styleId);
	}

	public boolean updateStyleCategory(StyleCategory style) {
		// TODO Auto-generated method stub
		return dao.updateStyleCategory(style);
	}

	public StyleCategory queryStyleByStyleId(int styleId) {
		// TODO Auto-generated method stub
		return dao.queryStyleByStyleId(styleId);
	}

	public List<StyleCategory> queryAllStyleInfo() {
		// TODO Auto-generated method stub
		return dao.queryAllStyleInfo();
	}

	public int counterByPage() {
		// TODO Auto-generated method stub
		return dao.counterByPage();
	}

	public List<StyleCategory> queryStyleCategoryInfoByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		return dao.queryStyleCategoryInfoByPage(pageNow, limitPage);
	}
	
	

}
