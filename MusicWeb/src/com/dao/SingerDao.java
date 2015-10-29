package com.dao;

import java.util.List;

import com.entity.Singer;


/**
 *	
 * 2015-3-10上午9:53:36
 *
 *MusicWeb.dao.SingerDao
 */
public interface SingerDao {

	/**
	 * @param singer
	 * @return
	 * 增加歌手信息
	 */
	public boolean addSinger(Singer singer);
	
	/**
	 * @param singerId
	 * @return
	 * 删除歌手
	 */
	public boolean deleteSinger(int singerId);
	
	/**
	 * @param singer
	 * @return
	 * 修改歌手信息
	 */
	public boolean updateSinger(Singer singer);
	
	/**
	 * @param singerId
	 * @return
	 * 通过SingerId查找信息
	 */
	public Singer querySingerBySingerId(int singerId);
	
	/**
	 * @param Timers
	 * @return
	 * 通过 timers 年代来查找
	 */
	public List<Singer> querySingerByTimers(String times);
	
	/**
	 * @param singerCountry
	 * @return
	 * 通过国籍来查找
	 */
	public List<Singer> querySingerByCountry(String singerCountry);
	
	
	/**
	 * @param singerGender
	 * @return
	 * 通过歌手 性别来查找
	 */
	public List<Singer> querySingerByGender(String singerGender);
	
	/**
	 * @param popularity
	 * @return
	 * 通过 歌手受欢迎程度 来查找
	 */
	public List<Singer> querySingerByPopularity(int popularity);
	
	/**
	 * @return
	 * 遍历全部歌手信息
	 */
	public List<Singer> queryAllSingerInfo();
	
	
	/**
	 * @return
	 * 遍历12个歌手信息
	 */
	public List<Singer> querySingerInfoByNumber();
	
	/**
	 * @return
	 * 通过歌手名 查找歌手信息
	 */
	public Singer querySingerInfoBySingerName(String singerName);
	
	
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
	public  List<Singer> querySingerInfoByPage(int pageNow,int limitPage);
}
