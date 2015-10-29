package com.dao;

import java.util.List;

import com.entity.Commentary;
import com.entity.CommentaryInfo;


/**
 *	
 * 2015-3-9上午10:57:02
 *
 *MusicWeb.dao.CommentaryDao
 */
public interface CommentaryDao {

	/**
	 * @param comm
	 * @return
	 * 发表评论
	 */
	public boolean addCommentary(Commentary comm);
	
	/**
	 * @param commentaryId
	 * @return
	 * 删除评论
	 */
	public boolean deleteCommentary(int commentaryId);
	
	/**
	 * @param commId
	 * @return
	 * 通过CommId查找 某条歌曲评论信息
	 */
	public CommentaryInfo queryCommentaryByCommId(int commId);
	
	
	
	/**
	 * @param commId
	 * @return
	 * 查找某条悦单评论信息
	 */
	public CommentaryInfo querySongListCommentaryByCommId(int commId);
	
	/**
	 * @param musicId
	 * @return
	 * 通过musicId 查询评论
	 */
	public List<CommentaryInfo> queryCommentaryByMusicId(int musicId);
	
	/**
	 * @param SongListId
	 * @return
	 * 通过SongListId 查询评论
	 */
	public List<CommentaryInfo> queryCommentaryBySongListId(int songListId);
	
	
	/**
	 * @param memberId
	 * @return
	 * 通过memberId 查找某用户的全部评论
	 */
	public List<CommentaryInfo> queryCommentaryByMemberUserId(int memberId);
	
	
	/**
	 * @return
	 * 查询全部信息
	 */
	public List<CommentaryInfo> queryCommentaryInfoByAll();
	
	/**
	 * @return
	 * 查询某用户的歌曲评论
	 */
	public List<CommentaryInfo> queryMusicCommentaryByUserId(int memberId);
	
	
	/**
	 * @return
	 * 查询某用户的悦单评论
	 */
	public List<CommentaryInfo> querySongListCommentaryByUserId(int memberId);
	
	
	/**
	 * @return
	 * 查询全部的歌曲评论
	 */
	public List<CommentaryInfo> queryAllMUsicCommentaryInfo();
	
	/**
	 * @return
	 * 查询全部的悦单信息
	 */
	public List<CommentaryInfo> queryAllSongListCommentaryInfo();
	
	
	/**
	 * @return
	 * 获取表中总记录数
	 */
	public int counterByPage();
	
	/**
	 * @param pageNum
	 * @param limitPage
	 * @return
	 * 查询第几页的歌曲评论信息
	 */
	public  List<CommentaryInfo> queryMusicCommentaryInfoByPage(int pageNow,int limitPage);
	
	/**
	 * @param pageNow
	 * @param limitPage
	 * @return
	 * 查询第几页的全部评论
	 */
	public List<CommentaryInfo> queryAllCommentaryInfoByPage(int pageNow,int limitPage );
	
}
