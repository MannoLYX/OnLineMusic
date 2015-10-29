package com.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CommentaryDao;
import com.entity.Commentary;
import com.entity.CommentaryInfo;
import com.util.DBUtil;



/**
 *	
 * 2015-3-9上午11:13:38
 *
 *MusicWeb.dao.daoImpl.CommentaryDaoImpl
 */
public class CommentaryDaoImpl implements CommentaryDao{

	DBUtil util = new DBUtil();
	String sql;
	
	/* (non-Javadoc)
	 * @see dao.CommentaryDao#addCommentary(entity.Commentary)
	 */
	public boolean addCommentary(Commentary comm) {
		// TODO Auto-generated method stub
		sql="insert into Commentary(COMMENTARY_CONTEXT,COMMENTARY_TIME, MUSICID,SONGLISTID,MEMBERID)values(?,?,?,?,?)";
		return util.update(sql, comm.getCommentaryContext(),comm.getCommentaryTime(),comm.getMusicId(),comm.getSongListId(),comm.getMemberId())>=1;
	}

	/* (non-Javadoc)
	 * @see dao.CommentaryDao#deleteCommentary(int)
	 */
	public boolean deleteCommentary(int commentaryId) {
		// TODO Auto-generated method stub
		sql="delete from Commentary where commentaryId=?";
		return util.update(sql, commentaryId)>=1;
	}

	/* (non-Javadoc)
	 * @see dao.CommentaryDao#queryCommentaryByMusicId(int)
	 */
	public List<CommentaryInfo> queryCommentaryByMusicId(int musicId) {
		// TODO Auto-generated method stub
		
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME, M.MUSICNAME,m.musicId,mem.memberId,mem.membername FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM " +
				"WHERE comm.memberid = mem.memberid AND comm.musicid = m.musicid and m.musicid=? order by comm.commentary_time Desc";
		
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql, musicId);
		try {
			while(rs.next())
			{
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setMusicName(rs.getString("MUSICNAME"));
				commInfo.setMemberName(rs.getString("membername"));
				commInfo.setMusicId(rs.getInt("musicId"));
				commInfo.setMemberId(rs.getInt("memberId"));
				
				commentaryList.add(commInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return commentaryList;
	}

	/* (non-Javadoc)
	 * @see dao.CommentaryDao#queryCommentaryBySongListId(int)
	 */
	public List<CommentaryInfo> queryCommentaryBySongListId(int songListId) {
		// TODO Auto-generated method stub
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME,s.songListId,mem.memberId s.songlist_name,mem.membername FROM COMMENTARY COMM,MEMBERUSER MEM,SONGLIST S " +
				"WHERE comm.memberid = mem.memberid AND comm.songlistid =s.songlistid and s.songlistid=? order by comm.commentary_time Desc";
		
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql,songListId);
		try {
			while(rs.next())
			{
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setSongListName(rs.getString("songlist_name"));
				commInfo.setMemberName(rs.getString("membername"));
				commInfo.setSongListId(songListId);
				commInfo.setMemberId(rs.getInt("memberId"));
				
				commentaryList.add(commInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return commentaryList;
	}

	/* (non-Javadoc)
	 * @see dao.CommentaryDao#queryCommentaryByMemberUserId(int)
	 */
	public List<CommentaryInfo> queryCommentaryByMemberUserId(int memberId) {
		// TODO Auto-generated method stub
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM " +
				"WHERE comm.memberid = mem.memberid  and  mem.memberid=? order by comm.commentary_time Asc";
		
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql,memberId);
		try {
			while(rs.next())
			{
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				//commInfo.setSongListName(rs.getString("songlist_name"));
				commInfo.setMemberName(rs.getString("membername"));
				
				commentaryList.add(commInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return commentaryList;
	}

	/* (non-Javadoc)
	 * @see dao.CommentaryDao#queryCommentaryInfoByAll()
	 */
	public List<CommentaryInfo> queryCommentaryInfoByAll() {
		// TODO Auto-generated method stub
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,comm.memberid FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM " +
				"WHERE comm.memberid = mem.memberid order by comm.commentary_time Asc";
		
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql);
		try {
			while(rs.next())
			{
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setMemberName(rs.getString("membername"));
				
				commentaryList.add(commInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return commentaryList;
	}

	
	
	/**
	 * 某用户的歌曲评论信息
	 */
	public List<CommentaryInfo> queryMusicCommentaryByUserId(int memberId) {
		// TODO Auto-generated method stub
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,m.musicname FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM " +
				"WHERE comm.memberid = mem.memberid and comm.musicid = M.musicid and  mem.memberid=?  order by comm.commentary_time Asc";
		
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql,memberId);
		try {
			while(rs.next())
			{
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setMusicName(rs.getString("musicname"));
				commInfo.setMemberName(rs.getString("membername"));
				
				commentaryList.add(commInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return commentaryList;
	}

	/**
	 * 某用户的悦单评论信息
	 */
	public List<CommentaryInfo> querySongListCommentaryByUserId(int memberId) {
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,s.songlist_name FROM COMMENTARY COMM,MEMBERUSER MEM,songlist s " +
				"WHERE comm.memberid = mem.memberid  and comm.songlistid=s.songlistid and  mem.memberid=?  order by comm.commentary_time Asc";
		
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql,memberId);
		try {
			while(rs.next())
			{
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setSongListName(rs.getString("songlist_name"));
				commInfo.setMemberName(rs.getString("membername"));
				
				commentaryList.add(commInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return commentaryList;
	}

	/**
	 * 遍历全部的歌曲评论信息
	 */
	public List<CommentaryInfo> queryAllMUsicCommentaryInfo() {
		// TODO Auto-generated method stub
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,m.musicname FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM " +
				"WHERE comm.memberid = mem.memberid and comm.musicid = M.musicid  order by comm.commentary_time Asc";
		
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql);
		try {
			while(rs.next())
			{
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setMusicName(rs.getString("musicname"));
				commInfo.setMemberName(rs.getString("membername"));
				
				commentaryList.add(commInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return commentaryList;
	}

	/**
	 * 遍历全部的歌单评论信息
	 */
	public List<CommentaryInfo> queryAllSongListCommentaryInfo() {
		
		// TODO Auto-generated method stub
				sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,s.songlist_name FROM COMMENTARY COMM,songlist s,MEMBERUSER MEM " +
						"WHERE comm.memberid = mem.memberid and comm.songlistid=s.songlistid order by comm.commentary_time Asc";
				
				List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
				
				ResultSet rs = util.Query(sql);
				try {
					while(rs.next())
					{
						CommentaryInfo commInfo = new CommentaryInfo();
						commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
						commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
						commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
						commInfo.setSongListName(rs.getString("songlist_name"));
						commInfo.setMemberName(rs.getString("membername"));
						
						commentaryList.add(commInfo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					util.close();
				}
				
				return commentaryList;
	}

	/* (non-Javadoc)
	 * @see com.dao.CommentaryDao#queryCommentaryByCommId(int)
	 */
	public CommentaryInfo queryCommentaryByCommId(int commId) {
		// TODO Auto-generated method stub
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME, M.MUSICNAME,m.musicId,mem.memberId,mem.membername FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM " +
				"WHERE comm.memberid = mem.memberid AND comm.musicid = m.musicid and comm.commentaryId=? order by comm.commentary_time Desc";
		
		CommentaryInfo commInfo =new CommentaryInfo();
		
		ResultSet rs = util.Query(sql, commId);
		try {
			while(rs.next())
			{
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setMusicName(rs.getString("MUSICNAME"));
				commInfo.setMemberName(rs.getString("membername"));
				commInfo.setMusicId(rs.getInt("musicId"));
				commInfo.setMemberId(rs.getInt("memberId"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return commInfo;
	}

	/* (non-Javadoc)
	 * @see com.dao.CommentaryDao#querySongListCommentaryByCommId(int)
	 */
	public CommentaryInfo querySongListCommentaryByCommId(int commId) {
		// TODO Auto-generated method stub
		sql="SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,s.songlist_name FROM COMMENTARY COMM,songlist s,MEMBERUSER MEM " +
				"WHERE comm.memberid = mem.memberid and comm.songlistid=s.songlistid and comm.COMMENTARYID=? order by comm.commentary_time Asc";
		
		CommentaryInfo commInfo = new CommentaryInfo();
		
		ResultSet rs = util.Query(sql,commId);
		try {
			while(rs.next())
			{			
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setSongListName(rs.getString("songlist_name"));
				commInfo.setMemberName(rs.getString("membername"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}	
		return commInfo;
	}

	/* (non-Javadoc)
	 * @see com.dao.CommentaryDao#counterByPage()
	 */
	public int counterByPage() {
		// TODO Auto-generated method stub
		sql="select count(*) from commentary";
		
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
	 * @see com.dao.CommentaryDao#queryCommentaryInfoByPage(int, int)
	 * 歌曲的评论
	 */
	
	public List<CommentaryInfo> queryMusicCommentaryInfoByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,m.musicname FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM " +
				"WHERE comm.memberid = mem.memberid and comm.musicid = M.musicid  order by comm.commentary_time Asc) A WHERE ROWNUM <=?)WHERE RN >?";
		
		List<CommentaryInfo> musicCommentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql,limitPage*pageNow,(pageNow-1)*limitPage);
		
		try {
			while(rs.next())
			{
				CommentaryInfo commInfo = new CommentaryInfo();
				commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
				commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
				commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
				commInfo.setMusicName(rs.getString("musicname"));
				commInfo.setMemberName(rs.getString("membername"));
				
				musicCommentaryList.add(commInfo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return musicCommentaryList;
	}

	
	
	
	/* (non-Javadoc)
	 * @see dao.CommentaryDao#queryCommentaryInfoByAll()
	 */
	public List<CommentaryInfo> queryAllCommentaryInfoByPage(int pageNow,
			int limitPage ) {
		// TODO Auto-generated method stub
		sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (SELECT distinct  COMM.COMMENTARYID,COMM.COMMENTARY_CONTEXT,COMM.COMMENTARY_TIME ,mem.membername,comm.memberid " +
				"FROM COMMENTARY COMM,MUSIC M,MEMBERUSER MEM WHERE comm.memberid = mem.memberid order by comm.commentary_time Asc) A WHERE ROWNUM <=?)WHERE RN >?";
		
		List<CommentaryInfo> CommentaryList = new ArrayList<CommentaryInfo>();
		
		ResultSet rs = util.Query(sql,limitPage*pageNow,(pageNow-1)*limitPage);
		
try {
	while(rs.next())
	{
		CommentaryInfo commInfo = new CommentaryInfo();
		commInfo.setCommentaryId(rs.getInt("COMMENTARYID"));
		commInfo.setCommentaryContext(rs.getString("COMMENTARY_CONTEXT"));
		commInfo.setCommentaryTime(rs.getDate("COMMENTARY_TIME"));
		commInfo.setMemberName(rs.getString("membername"));
		
		CommentaryList.add(commInfo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			util.close();
		}
		
		return CommentaryList;
	}
}
