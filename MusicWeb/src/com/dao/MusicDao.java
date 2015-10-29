package com.dao;

import java.util.List;

import com.entity.Music;
import com.entity.MusicInfo;


/**
 *	
 * 2015-3-6下午3:31:49
 *
 *MusicWeb.dao.MusicDao
 */
public interface MusicDao {

	/**
	 * @param music
	 * @return
	 * 添加歌曲
	 */
	public boolean addMusic(Music music);
	
	/**
	 * @param MusicId
	 * @return
	 * 删除
	 */
	public boolean deleteMusic(int MusicId);
	
	/**
	 * @param music
	 * @return
	 * 修改
	 */
	public boolean updateMusic(Music music);
	
	/**
	 * @param musicId
	 * @return
	 * 通过ID 查找
	 */
	public MusicInfo queryMusicBymusicId(int musicId);
	
	
	/**
	 * @return
	 * 遍历全部信息
	 */
	public List<MusicInfo> queryAllMusicInfo();
	
	
	/**
	 * @param singerId
	 * @return
	 * 通过singerId遍历出歌曲
	 */
	public List<MusicInfo> queryMusicBysingerId(int singerId);
	
	/**
	 * @param singerId
	 * @return
	 * 通过styleId遍历出歌曲
	 */
	public List<MusicInfo> queryMusicBystyleId(int styleId);
	
	
	/**
	 * @param singerId
	 * @return
	 * 通过emotionId遍历出歌曲
	 */
	public List<MusicInfo> queryMusicByemotionId(int emotionId);
	
	/**
	 * @return
	 * 遍历12条歌曲信息
	 */
	public List<MusicInfo> queryAllMusicInfoByNumber();
	
	/**
	 * @return
	 * 最新的12首歌
	 */
	public List<MusicInfo> queryNewMusicByNumber();
	
	/**
	 * @return
	 * 最火的12首歌
	 */
	public List<MusicInfo>queryHostMusicByNumber();
	
	
	/**
	 * @return
	 * 获取表中总记录数
	 */
	public int counterByPage();
	
	/**
	 * @param pageNum
	 * @param limitPage
	 * @return
	 * 查询第几页的信息
	 */
	public  List<MusicInfo> queryMusicInfoByPage(int pageNow,int limitPage);
	
	
	/**
	 * @return
	 * 首页分页显示最新的20首歌
	 */
	public List<MusicInfo> queryNewMusicByNumberByPage(int pageNow,int limitPage);
}

