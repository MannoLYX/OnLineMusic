package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.MusicDao;
import com.entity.Music;
import com.entity.MusicInfo;
import com.util.DBUtil;



/**
 *	
 * 2015-3-6下午3:36:35
 *
 *MusicWeb.dao.daoImpl.MusicDaoImpl
 */
public class MusicDaoImpl implements MusicDao {

	DBUtil util = new DBUtil();
	String sql;
	
	
	
	/* (non-Javadoc)
	 * @see dao.MusicDao#addMusic(entity.Music)
	 */
	public boolean addMusic(Music music) {
		// TODO Auto-generated method stub
		sql="INSERT INTO MUSIC(MUSICNAME,MUSICPICTURE,MUSICLYRICS,MUSICINSTRUCTION,SINGERID,STYLEID,EMOTIONID,musicpath)VALUES(?,?,?,?,?,?,?,?)";
		return util.update(sql, music.getMusicName(),music.getMusicPicture(),music.getMusicLyrics(),music.getMusicInstruction(),
				music.getSingerId(),music.getStyleId(),music.getEmotionId(),music.getMusicPath())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.MusicDao#deleteMusic(int)
	 */
	public boolean deleteMusic(int musicId) {
		// TODO Auto-generated method stub
		sql="DELETE FROM MUSIC WHERE MUSICID=?";
		
		return util.update(sql,musicId)>=1;
	}

	/* (non-Javadoc)
	 * @see dao.MusicDao#updateMusic(entity.Music)
	 */
	public boolean updateMusic(Music music) {
		// TODO Auto-generated method stub
		sql="UPDATE MUSIC SET MUSICNAME=?,MUSICLYRICS=?,MUSICINSTRUCTION=?,SINGERID=?,STYLEID=?,EMOTIONID=? WHERE MUSICID=?";
		return util.update(sql,music.getMusicName(),music.getMusicLyrics(),music.getMusicInstruction(),
				music.getSingerId(),music.getStyleId(),music.getEmotionId(),music.getMusicId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.MusicDao#queryMusicById(int)
	 */
	public MusicInfo queryMusicBymusicId(int musicId) {
		// TODO Auto-generated method stub
		sql="SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath,m.styleid,m.emotionid FROM MUSIC m,singer s,emotion_category e,style_category st " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid and m.musicId=? order by m.musicid ASC";
		MusicInfo musicInfo =null;
		ResultSet rs = util.Query(sql, musicId);
		
		try {
			while(rs.next())
			{
				 musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getInt("styleid"),rs.getInt("emotionid"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return musicInfo;
	}

	/* (non-Javadoc)
	 * @see dao.MusicDao#queryAllMusicInfo()
	 */
	public List<MusicInfo> queryAllMusicInfo() {
		// TODO Auto-generated method stub
		sql="SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid  order by m.musicid ASC";
		
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
				musicList.add(musicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}	
		return musicList;
	}

	/* (non-Javadoc)
	 * @see dao.MusicDao#queryMusicBysingerId(int)
	 */
	public List<MusicInfo> queryMusicBysingerId(int singerId) {
		// TODO Auto-generated method stub
		sql="SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid and m.singerid=? order by m.musicid ASC";
List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		ResultSet rs = util.Query(sql,singerId);
		
		try {
			while(rs.next())
			{
				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
				musicList.add(musicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}	
		return musicList;
	}

	/* (non-Javadoc)
	 * @see dao.MusicDao#queryMusicBystyleId(int)
	 */
	public List<MusicInfo> queryMusicBystyleId(int styleId) {
		// TODO Auto-generated method stub
		sql="SELECT distinct m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st  " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid and m.styleid=? order by m.musicid ASC";
List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		ResultSet rs = util.Query(sql,styleId);
		
		try {
			while(rs.next())
			{

				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
				musicList.add(musicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}	
		return musicList;
	}

	/* (non-Javadoc)
	 * @see dao.MusicDao#queryMusicByemotionId(int)
	 */
	public List<MusicInfo> queryMusicByemotionId(int emotionId) {
		sql="SELECT distinct m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st  " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid and m.emotionId=? order by m.musicid ASC";
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
				
				ResultSet rs = util.Query(sql,emotionId);
				
				try {
					while(rs.next())
					{
						MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
								rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
					
						musicList.add(musicInfo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					util.close();
				}	
				return musicList;
	}

	/* (non-Javadoc)
	 * @see com.dao.MusicDao#queryAllMusicInfoByNumber()
	 */
	public List<MusicInfo> queryAllMusicInfoByNumber() {
		// TODO Auto-generated method stub
		sql="SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid  and rownum<=12 order by m.musicid ASC";
		
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
				
				musicList.add(musicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}	
		return musicList;
	}

	/* (non-Javadoc)
	 * @see com.dao.MusicDao#queryNewMusicByNumber()
	 */
	public List<MusicInfo> queryNewMusicByNumber() {
		// TODO Auto-generated method stub
		sql="select * from(SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid  order by m.musicid DESC)where rownum<=15";
		
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
				musicList.add(musicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}	
		return musicList;
	}

	/* (non-Javadoc)
	 * @see com.dao.MusicDao#queryHostMusicByNumber()
	 */
	public List<MusicInfo> queryHostMusicByNumber() {
		// TODO Auto-generated method stub
		sql="select * from(SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid and s.popularity>=8  order by m.musicid ASC)where rownum<=15";
		
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		ResultSet rs = util.Query(sql);
		
		try {
			while(rs.next())
			{
				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
				musicList.add(musicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}	
		return musicList;
	}



	/* (non-Javadoc)
	 * @see com.dao.MusicDao#counterByPage()
	 */
	public int counterByPage() {
		// TODO Auto-generated method stub
		sql="select count(*) from music";
		
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
	 * @see com.dao.MusicDao#queryMusicInfoByPage(int, int)
	 */
	public List<MusicInfo> queryMusicInfoByPage(int pageNow, int limitPage) {
		// TODO Auto-generated method stub
		sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid  order by m.musicid ASC) A WHERE ROWNUM <=?)WHERE RN >?";
		
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		ResultSet rs = util.Query(sql,limitPage*pageNow,(pageNow-1)*limitPage);
		
		try {
			while(rs.next())
			{
				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
			
				musicList.add(musicInfo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return musicList;
	}

	/* (non-Javadoc)
	 * @see com.dao.MusicDao#queryNewMusicByNumberByPage(int, int)
	 * 最新的20首歌 用于首页显示
	 */
	public List<MusicInfo> queryNewMusicByNumberByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (select * from(SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st " +
				"where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid  order by m.musicid DESC)where rownum<=20) A WHERE ROWNUM <=?)WHERE RN >?";
		
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		ResultSet rs = util.Query(sql,limitPage*pageNow,(pageNow-1)*limitPage);
		
		try {
			while(rs.next())
			{
				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),rs.getString("MUSICNAME"),rs.getString("singername"),rs.getString("MUSICPICTURE"),rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),rs.getString("stylename"),rs.getString("emotionname"),rs.getString("musicpath"));
				musicList.add(musicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}	
		return musicList;
	}

	
}
