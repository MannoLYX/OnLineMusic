package com.biz.bizImpl;

import java.util.List;

import com.biz.CommentaryBiz;
import com.dao.CommentaryDao;
import com.dao.daoImpl.CommentaryDaoImpl;
import com.entity.Commentary;
import com.entity.CommentaryInfo;

/**
 *	
 * 2015-3-25ÉÏÎç9:07:00
 *
 *MusicWeb.com.biz.bizImpl.CommentaryBizImpl
 */
public class CommentaryBizImpl implements CommentaryBiz {

	CommentaryDao dao = new CommentaryDaoImpl();
	
	
	public boolean addCommentary(Commentary comm) {
		// TODO Auto-generated method stub
		return dao.addCommentary(comm);
	}

	public boolean deleteCommentary(int commentaryId) {
		// TODO Auto-generated method stub
		return dao.deleteCommentary(commentaryId);
	}

	public List<CommentaryInfo> queryCommentaryByMusicId(int musicId) {
		// TODO Auto-generated method stub
		return dao.queryCommentaryByMusicId(musicId);
	}

	public List<CommentaryInfo> queryCommentaryBySongListId(int songListId) {
		// TODO Auto-generated method stub
		return dao.queryCommentaryBySongListId(songListId);
	}

	public List<CommentaryInfo> queryCommentaryByMemberUserId(int memberId) {
		// TODO Auto-generated method stub
		return dao.queryCommentaryByMemberUserId(memberId);
	}

	public List<CommentaryInfo> queryCommentaryInfoByAll() {
		// TODO Auto-generated method stub
		return dao.queryCommentaryInfoByAll();
	}

	public List<CommentaryInfo> queryMusicCommentaryByUserId(int memberId) {
		// TODO Auto-generated method stub
		return dao.queryMusicCommentaryByUserId(memberId);
	}

	public List<CommentaryInfo> querySongListCommentaryByUserId(int memberId) {
		// TODO Auto-generated method stub
		return dao.querySongListCommentaryByUserId(memberId);
	}

	public List<CommentaryInfo> queryAllMUsicCommentaryInfo() {
		// TODO Auto-generated method stub
		return dao.queryAllMUsicCommentaryInfo();
	}

	public List<CommentaryInfo> queryAllSongListCommentaryInfo() {
		// TODO Auto-generated method stub
		return dao.queryAllSongListCommentaryInfo();
	}

	public CommentaryInfo queryCommentaryByCommId(int commId) {
		// TODO Auto-generated method stub
		return dao.queryCommentaryByCommId(commId);
	}

	public CommentaryInfo querySongListCommentaryByCommId(int commId) {
		// TODO Auto-generated method stub
		return dao.querySongListCommentaryByCommId(commId);
	}

	public int counterByPage() {
		// TODO Auto-generated method stub
		return dao.counterByPage();
	}

	public List<CommentaryInfo> queryMusicCommentaryInfoByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		return dao.queryMusicCommentaryInfoByPage(pageNow, limitPage);
	}

	public List<CommentaryInfo> queryAllCommentaryInfoByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		return dao.queryAllCommentaryInfoByPage(pageNow, limitPage);
	}

	
	
	
}
