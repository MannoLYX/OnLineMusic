package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.EmotionCategoryDao;
import com.entity.EmotionCategory;
import com.util.DBUtil;



/**
 *	
 * 2015-3-10ÏÂÎç2:34:09
 *
 *MusicWeb.dao.daoImpl.EmotionCategoryDaoImpl
 */
public class EmotionCategoryDaoImpl implements EmotionCategoryDao{

	DBUtil util = new DBUtil();
	
	String sql;
	
	
	/**
	 * @param emotion
	 * @return
	 */
	public boolean addEmotionCategory(EmotionCategory emotion) {
		// TODO Auto-generated method stub
		sql="Insert into Emotion_Category(emotionName)values(?) ";
		return util.update(sql, emotion.getEmotionName())>=1;
	}

	/**
	 * @param emotionId
	 * @return
	 */
	public boolean deleteEmotionCategory(int emotionId) {
		// TODO Auto-generated method stub
		sql="delete from emotion_category where emotionId=?";
		return util.update(sql, emotionId)>=1;
	}

	/**
	 * @param emotion
	 * @return
	 */
	public boolean updateEmotionCategory(EmotionCategory emotion) {
		// TODO Auto-generated method stub
		sql="update emotion_category set emotionName=? where emotionId=?";
		return util.update(sql, emotion.getEmotionName(),emotion.getEmotionId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.EmotionCategoryDao#queryemotionByemotionId(int)
	 */
	public EmotionCategory queryemotionByemotionId(int emotionId) {
		// TODO Auto-generated method stub
		sql="select * from emotion_category where emotionId=? order by emotionId ASC";
		EmotionCategory emotion = null;
		
		ResultSet rs = util.Query(sql, emotionId);
		
		try {
			while(rs.next())
			{
				emotion =new EmotionCategory(rs.getInt("emotionId"),rs.getString("emotionName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return emotion;
	}

	/* (non-Javadoc)
	 * @see dao.EmotionCategoryDao#queryAllemotionInfo()
	 */
	public List<EmotionCategory> queryAllemotionInfo() {
		// TODO Auto-generated method stub
		sql="select * from Emotion_category order by emotionId ASC";
		
		List<EmotionCategory> emotionList = new ArrayList<EmotionCategory>();
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
			EmotionCategory emotion = new EmotionCategory(rs.getInt("emotionId"),rs.getString("emotionName"));
			emotionList.add(emotion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return emotionList;
	}

	/* (non-Javadoc)
	 * @see com.dao.EmotionCategoryDao#counterByPage()
	 */
	public int counterByPage() {
		// TODO Auto-generated method stub
sql="select count(*) from EMOTION_CATEGORY";
		
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
	 * @see com.dao.EmotionCategoryDao#queryEmotionCategoryInfoByPage(int, int)
	 */
	public List<EmotionCategory> queryEmotionCategoryInfoByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (select * from Emotion_category order by emotionId ASC) A WHERE ROWNUM <=?)WHERE RN >?";
		
		List<EmotionCategory> emotionList = new ArrayList<EmotionCategory>();
		ResultSet rs = util.Query(sql,limitPage*pageNow,(pageNow-1)*limitPage);
		
		try {
			while(rs.next())
			{
			EmotionCategory emotion = new EmotionCategory(rs.getInt("emotionId"),rs.getString("emotionName"));
			emotionList.add(emotion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return emotionList;
	}

}
