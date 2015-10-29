package com.dao;

import java.util.List;

import com.entity.SongList;


/**
 *	
 * 2015-3-9上午8:45:35
 *
 *MusicWeb.dao.SongListDao
 */
public interface SongListDao {

	/**
	 * @param songList
	 * @return
	 * 增加悦单
	 */
	public boolean addSongList(SongList songList);
	
	/**
	 * @param songListId
	 * @return
	 * 删除悦单
	 */
	public boolean deleteSongList(int songListId);
	
	/**
	 * @param songList
	 * @return
	 * 修改悦单
	 */
	public boolean updateSongList(SongList songList);
	
	/**
	 * @param songListId
	 * @return
	 * 通过Id查找悦单
	 */
	public List<SongList> querySongListById(int songListId);
	
	/**
	 * @return
	 * 遍历全部的悦单信息
	 */
	public List<SongList> querySongListInfo();
	
	
	/**
	 * @return
	 * 遍历12条的悦单信息
	 */
	public List<SongList> querySongListInfoByNumber();
}
