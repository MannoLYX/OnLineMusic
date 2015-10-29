package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.SongListDao;
import com.entity.SongList;
import com.util.DBUtil;



/**
 *	
 * 2015-3-9上午8:50:41
 *
 *MusicWeb.dao.daoImpl.SongListDaoImpl
 */
public class SongListDaoImpl implements SongListDao {

	DBUtil util = new DBUtil();
	String sql;
	/* (non-Javadoc)
	 * @see dao.SongListDao#addSongList(entity.SongList)
	 */
	public boolean addSongList(SongList songList) {
		// TODO Auto-generated method stub
		sql="Insert into songList(SONGLIST_NAME,SONGLIST_INSTRUCTION,SONGLIST_PICTURE,SONGLIST_CREATETIME,MEMBERID,MUSICID)values(?,?,?,?,?,?)";
		return util.update(sql,songList.getSongListName(),songList.getSongListInstryction(),songList.getSongListPicture(),songList.getSongListCreateTime(),
				songList.getMemberId(),songList.getMusicId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.SongListDao#deleteSongList(int)
	 */
	public boolean deleteSongList(int songListId) {
		// TODO Auto-generated method stub
		sql="DELETE from SongList where songListId=?";
		return util.update(sql, songListId)>=1;
	}

	/* (non-Javadoc)
	 * @see dao.SongListDao#updateSongList(entity.SongList)
	 * 不能 修改添加的歌曲
	 */
	public boolean updateSongList(SongList songList) {
		// TODO Auto-generated method stub
		sql="update songlist set SONGLIST_NAME=?,SONGLIST_INSTRUCTION=?,SONGLIST_PICTURE=?,SONGLIST_CREATETIME=?,MEMBERID=? where SONGLISTID=? ";
		return util.update(sql,songList.getSongListName(),songList.getSongListInstryction(),songList.getSongListPicture(),songList.getSongListCreateTime(),
				songList.getMemberId(), songList.getSongListId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.SongListDao#querySongListById(int)
	 */
	public List<SongList> querySongListById(int songListId) {
		// TODO Auto-generated method stub
		sql="select * from songList where songlistId=? order by musicid ASC";
		
		ResultSet rs = util.Query(sql, songListId);
		List<SongList> songList = new ArrayList<SongList>();
		try {
			while(rs.next())
			{
				SongList song =new SongList(rs.getInt("songlistId"),rs.getString("songlist_name"),rs.getString("SONGLIST_INSTRUCTION"),
						rs.getString("SONGLIST_PICTURE"),rs.getDate("SONGLIST_CREATETIME"),rs.getInt("MEMBERID"),rs.getInt("MUSICID"));
				songList.add(song);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		return songList;
	}

	public List<SongList> querySongListInfo() {
		// TODO Auto-generated method stub
		sql="select * from songList order by songlistid ASC ,musicid ASC";
		List<SongList> listSongList = new ArrayList<SongList>();
		
		ResultSet rs =util.Query(sql);
		try {
			while(rs.next())
			{
				SongList song =new SongList(rs.getInt("songlistId"),rs.getString("songlist_name"),rs.getString("SONGLIST_INSTRUCTION"),
						rs.getString("SONGLIST_PICTURE"),rs.getDate("SONGLIST_CREATETIME"),rs.getInt("MEMBERID"),rs.getInt("MUSICID"));
				
				listSongList.add(song);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return listSongList;
	}

	public List<SongList> querySongListInfoByNumber() {
		// TODO Auto-generated method stub
		sql="select * from (select  * from songList order by songlist_createtime DESC)where rownum<=12";
		List<SongList> listSongList = new ArrayList<SongList>();
		
		ResultSet rs =util.Query(sql);
		try {
			while(rs.next())
			{
				SongList song =new SongList(rs.getInt("songlistId"),rs.getString("songlist_name"),rs.getString("SONGLIST_INSTRUCTION"),
						rs.getString("SONGLIST_PICTURE"),rs.getDate("SONGLIST_CREATETIME"),rs.getInt("MEMBERID"),rs.getInt("MUSICID"));
				
				listSongList.add(song);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return listSongList;
	}

}
