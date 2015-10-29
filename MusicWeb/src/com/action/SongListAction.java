package com.action;

import java.util.List;

import com.biz.SongListBiz;
import com.biz.bizImpl.SongListBizImpl;
import com.entity.SongList;
import com.opensymphony.xwork2.Action;

/**
 *	
 * 2015-3-18����5:32:43
 *
 *MusicWeb.com.action.SongListAction
 */
public class SongListAction extends BaseAction implements Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SongList song ;
	private int songListId;
	
	
	
	public int getSongListId() {
		return songListId;
	}




	public void setSongListId(int songListId) {
		this.songListId = songListId;
	}




	public SongList getSong() {
		return song;
	}




	public void setSong(SongList song) {
		this.song = song;
	}


	SongListBiz songListbiz = new SongListBizImpl();


	/**
	 * @return
	 * �����õ�
	 */
	public String addSongList()
	{
		songListbiz.addSongList(song);
		
		return "addSongList";
	}
	
	
	/**
	 * @return
	 * ɾ���õ�
	 */
	public String deleteSongList()
	{
		songListbiz.deleteSongList(songListId);
		
		return "deleteSongList";
	}

	
	/**
	 * @return
	 * �޸��õ�
	 */
	public String updateSongList()
	{
		songListbiz.updateSongList(song);
		
		return "updateSongList";
	}
	
	
	/**
	 * @return
	 * ͨ��ID����
	 */
	public String querySongListById()
	{
		songListbiz.querySongListById(songListId);
		
		return "querySongListById";
		
	}
	
	
	/**
	 * @return
	 * ��ѯȫ������Ϣ
	 */
	public String querySongListInfo()
	{
		List<SongList> songList = songListbiz.querySongListInfo();
		
		app.setAttribute("songList", songList);
		
		return "querySongListInfo";
	}
	
	
	
}
