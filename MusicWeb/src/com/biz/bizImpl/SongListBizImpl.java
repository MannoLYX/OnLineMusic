package com.biz.bizImpl;

import java.util.List;

import com.biz.SongListBiz;
import com.dao.SongListDao;
import com.dao.daoImpl.SongListDaoImpl;
import com.entity.SongList;



/**
 *	
 * 2015-3-9ÉÏÎç10:53:38
 *
 *MusicWeb.biz.bizImpl.SongListBizImpl
 */
public class SongListBizImpl implements SongListBiz{

	SongListDao dao = new SongListDaoImpl();
	
	public boolean addSongList(SongList songList) {
		// TODO Auto-generated method stub
		return dao.addSongList(songList);
	}

	public boolean deleteSongList(int songListId) {
		// TODO Auto-generated method stub
		return dao.deleteSongList(songListId);
	}

	public boolean updateSongList(SongList songList) {
		// TODO Auto-generated method stub
		return dao.updateSongList(songList);
	}

	public List<SongList> querySongListById(int songListId) {
		// TODO Auto-generated method stub
		return dao.querySongListById(songListId);
	}

	public List<SongList> querySongListInfo() {
		// TODO Auto-generated method stub
		return dao.querySongListInfo();
	}

	public List<SongList> querySongListInfoByNumber() {
		// TODO Auto-generated method stub
		return dao.querySongListInfoByNumber();
	}

}
