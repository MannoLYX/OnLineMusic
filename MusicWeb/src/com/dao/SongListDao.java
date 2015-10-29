package com.dao;

import java.util.List;

import com.entity.SongList;


/**
 *	
 * 2015-3-9����8:45:35
 *
 *MusicWeb.dao.SongListDao
 */
public interface SongListDao {

	/**
	 * @param songList
	 * @return
	 * �����õ�
	 */
	public boolean addSongList(SongList songList);
	
	/**
	 * @param songListId
	 * @return
	 * ɾ���õ�
	 */
	public boolean deleteSongList(int songListId);
	
	/**
	 * @param songList
	 * @return
	 * �޸��õ�
	 */
	public boolean updateSongList(SongList songList);
	
	/**
	 * @param songListId
	 * @return
	 * ͨ��Id�����õ�
	 */
	public List<SongList> querySongListById(int songListId);
	
	/**
	 * @return
	 * ����ȫ�����õ���Ϣ
	 */
	public List<SongList> querySongListInfo();
	
	
	/**
	 * @return
	 * ����12�����õ���Ϣ
	 */
	public List<SongList> querySongListInfoByNumber();
}
