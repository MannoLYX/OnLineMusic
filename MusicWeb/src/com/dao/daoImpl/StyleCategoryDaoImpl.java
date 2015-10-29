package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.StyleCategoryDao;
import com.entity.StyleCategory;
import com.util.DBUtil;



/**
 *	
 * 2015-3-10ÏÂÎç2:05:52
 *
 *MusicWeb.dao.daoImpl.StyleCategoryDaoImpl
 */
public class StyleCategoryDaoImpl implements StyleCategoryDao {

	DBUtil  util = new DBUtil();
	String sql;
	
	/* (non-Javadoc)
	 * @see dao.StyleCategoryDao#addStyleCategpry(entity.StyleCategory)
	 */
	public boolean addStyleCategpry(StyleCategory style) {
		// TODO Auto-generated method stub
		sql="Insert into Style_Category(STYLENAME)values(?)";
		return util.update(sql, style.getStyleName())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.StyleCategoryDao#deleteStyleCategory(int)
	 */
	public boolean deleteStyleCategory(int styleId) {
		// TODO Auto-generated method stub
		sql="delete from Style_Category where styleId=?";
		return util.update(sql, styleId)>=1;
	}

	/* (non-Javadoc)
	 * @see dao.StyleCategoryDao#updateStyleCategory(entity.StyleCategory)
	 */
	public boolean updateStyleCategory(StyleCategory style) {
		// TODO Auto-generated method stub
		sql="update style_category set styleName=? where styleId=?";
		
		return util.update(sql, style.getStyleName(),style.getStyleId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.StyleCategoryDao#queryStyleByStyleId(int)
	 */
	public StyleCategory queryStyleByStyleId(int styleId) {
		// TODO Auto-generated method stub
		sql="select * from Style_category where styleId=? order by styleId ASC";
		
		StyleCategory style=null;
		ResultSet rs = util.Query(sql, styleId);
		try {
			while(rs.next())
			{
				style = new StyleCategory(rs.getInt("styleID"),rs.getString("STYLENAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return style;
	}

	/* (non-Javadoc)
	 * @see dao.StyleCategoryDao#queryAllStyleInfo()
	 */
	public List<StyleCategory> queryAllStyleInfo() {
		// TODO Auto-generated method stub
		
		sql="select * from Style_Category order by styleId ASC";
		
		List<StyleCategory> styleList = new ArrayList<StyleCategory>();
		
		ResultSet rs =util.Query(sql);
		
		try {
			while(rs.next())
			{
				StyleCategory style = new StyleCategory(rs.getInt("styleID"),rs.getString("STYLENAME"));
				styleList.add(style);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return styleList;
	}

	/* (non-Javadoc)
	 * @see com.dao.StyleCategoryDao#counterByPage()
	 */
	public int counterByPage() {
		// TODO Auto-generated method stub
sql="select count(*) from STYLE_CATEGORY";
		
		ResultSet rs =util.Query(sql);
		int totalCount=0;
		
		try {
			while(rs.next())
			{
				totalCount = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalCount;
	}

	/* (non-Javadoc)
	 * @see com.dao.StyleCategoryDao#queryStyleCategoryInfoByPage(int, int)
	 */
	public List<StyleCategory> queryStyleCategoryInfoByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (select * from Style_Category order by styleId ASC) A WHERE ROWNUM <=?)WHERE RN >?";
		
		List<StyleCategory> styleList = new ArrayList<StyleCategory>();
		ResultSet rs = util.Query(sql,limitPage*pageNow,(pageNow-1)*limitPage);
		
		try {
			while(rs.next())
			{
				StyleCategory style = new StyleCategory(rs.getInt("styleID"),rs.getString("STYLENAME"));
				styleList.add(style);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return styleList;
	}

}
