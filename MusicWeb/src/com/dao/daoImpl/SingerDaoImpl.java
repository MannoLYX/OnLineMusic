package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.SingerDao;
import com.entity.Singer;
import com.util.DBUtil;



/**
 *	
 * 2015-3-10ÉÏÎç10:03:12
 *
 *MusicWeb.dao.daoImpl.SingerDaoImpl
 */
public class SingerDaoImpl implements SingerDao{

	DBUtil util = new DBUtil();
	String sql;
	/* (non-Javadoc)
	 * @see dao.SingerDao#addSinger(entity.Singer)
	 */
	public boolean addSinger(Singer singer) {
		// TODO Auto-generated method stub
		sql="Insert Into Singer(SINGERNAME,SINGERPICTURE,SINGERCOUNTRY,SINGERGENDER,POPULARITY,TIMES)values(?,?,?,?,?,?)";
		
		//sql="Insert Into Singer(SINGERNAME,SINGERPICTURE,SINGERCOUNTRY,SINGERGENDER,POPULARITY,TIMES)values(?,?,?,?,?,?)";
		return util.update(sql,
				singer.getSingerName(),singer.getSingerPicture(),singer.getSingerCountry(),singer.getSingerGender(),
				singer.getPopularity(),singer.getTimes())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.SingerDao#deleteSinger(int)
	 */
	public boolean deleteSinger(int singerId) {
		// TODO Auto-generated method stub
		sql="delete from singer where singerId=?";
		return util.update(sql, singerId)>=1;
	}

	/* (non-Javadoc)
	 * @see dao.SingerDao#updateSinger(entity.Singer)
	 */
	public boolean updateSinger(Singer singer) {
		// TODO Auto-generated method stub
		sql="update singer set SINGERNAME=?,SINGERCOUNTRY=?,SINGERGENDER=?,POPULARITY=?,TIMES=? where singerId=?";
		return util.update(sql,singer.getSingerName(),singer.getSingerCountry(),singer.getSingerGender(),
				singer.getPopularity(),singer.getTimes(),singer.getSingerId() )>=1;
	}

	/* (non-Javadoc)
	 * @see dao.SingerDao#querySingerBySingerId(int)
	 */
	public Singer querySingerBySingerId(int singerId) {
		// TODO Auto-generated method stub
		sql="select * from singer where singerId=? order by singerid ASC";
		
		Singer singer =null;
		ResultSet rs = util.Query(sql, singerId);
		
		try {
			while(rs.next())
			{
				singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		
		return singer;
	}

	/* (non-Javadoc)
	 * @see dao.SingerDao#querySingerByTimers(java.lang.String)
	 */
	public List<Singer> querySingerByTimers(String times) {
		// TODO Auto-generated method stub
		sql="select * from singer where times=? order by singerid ASC";
		
		List<Singer> singerList = new ArrayList<Singer>();
		ResultSet rs = util.Query(sql, times);
		
		try {
			while(rs.next())
			{
				Singer Singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
				singerList.add(Singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return singerList;
	}

	/* (non-Javadoc)
	 * @see dao.SingerDao#querySingerByCountry(java.lang.String)
	 */
	public List<Singer> querySingerByCountry(String singerCountry) {
		// TODO Auto-generated method stub
		sql="select * from singer where singerCountry=? order by singerid ASC";
		
		List<Singer> singerList = new ArrayList<Singer>();
		ResultSet rs = util.Query(sql, singerCountry);
		
		try {
			while(rs.next())
			{
				Singer Singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
				singerList.add(Singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return singerList;
	}

	/* (non-Javadoc)
	 * @see dao.SingerDao#querySingerByGender(java.lang.String)
	 */
	public List<Singer> querySingerByGender(String singerGender) {
		// TODO Auto-generated method stub
	sql="select * from singer where singerGender=? order by singerid ASC";
		
		List<Singer> singerList = new ArrayList<Singer>();
		ResultSet rs = util.Query(sql, singerGender);
		
		try {
			while(rs.next())
			{
				Singer Singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
				singerList.add(Singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return singerList;
	}

	/* (non-Javadoc)
	 * @see dao.SingerDao#querySingerByPopularity(int)
	 */
	public List<Singer> querySingerByPopularity(int popularity) {
		// TODO Auto-generated method stub
	sql="select * from singer where popularity>? order by singerid ASC";
		
		List<Singer> singerList = new ArrayList<Singer>();
		ResultSet rs = util.Query(sql, popularity);
		
		try {
			while(rs.next())
			{
				Singer Singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
				singerList.add(Singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return singerList;
	}

	/* (non-Javadoc)
	 * @see dao.SingerDao#queryAllSingerInfo()
	 */
	public List<Singer> queryAllSingerInfo() {
		// TODO Auto-generated method stub
	sql="select * from singer order by singerid ASC ";
		
		List<Singer> singerList = new ArrayList<Singer>();
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				Singer Singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
				singerList.add(Singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return singerList;
	}

	/* (non-Javadoc)
	 * @see com.dao.SingerDao#querySingerInfoByNumber()
	 */
	public List<Singer> querySingerInfoByNumber() {
		// TODO Auto-generated method stub
		sql="select * from (select * from singer  order by popularity DESC )where rownum<=12 ";
		
		List<Singer> singerList = new ArrayList<Singer>();
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				Singer Singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
				singerList.add(Singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return singerList;
	}

	/* (non-Javadoc)
	 * @see com.dao.SingerDao#querySingerInfoBySingerName()
	 */
	public Singer querySingerInfoBySingerName(String singerName) {
		// TODO Auto-generated method stub
		
		sql="select * from singer where singerName=? ";
		
		Singer singer =null;
		ResultSet rs = util.Query(sql, singerName);
		
		try {
			while(rs.next())
			{
				singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return singer;
	}

	public int counterByPage() {
		// TODO Auto-generated method stub
sql="select count(*) from singer";
		
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

	public List<Singer> querySingerInfoByPage(int pageNow, int limitPage) {
		// TODO Auto-generated method stub
		sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (select * from singer order by singerid ASC) A WHERE ROWNUM <=?)WHERE RN >?";
		
		List<Singer> singerList = new ArrayList<Singer>();
		ResultSet rs = util.Query(sql,limitPage*pageNow,(pageNow-1)*limitPage);
		
		try {
			while(rs.next())
			{
				Singer Singer = new Singer(rs.getInt("singerId"),rs.getString("SINGERNAME"),rs.getString("SINGERPICTURE"),rs.getString("singerCountry"),
						rs.getString("SingerGender"),rs.getInt("popularity"),rs.getString("times"));
				
				singerList.add(Singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return singerList;
	}

}
