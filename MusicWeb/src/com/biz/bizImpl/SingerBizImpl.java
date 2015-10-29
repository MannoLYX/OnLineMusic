package com.biz.bizImpl;

import java.util.List;

import com.biz.SingerBiz;
import com.dao.SingerDao;
import com.dao.daoImpl.SingerDaoImpl;
import com.entity.Singer;



/**
 *	
 * 2015-3-10ÏÂÎç1:55:58
 *
 *MusicWeb.biz.bizImpl.SingerBizImpl
 */
public class SingerBizImpl implements SingerBiz{

	SingerDao dao = new SingerDaoImpl();
	
	
	public boolean addSinger(Singer singer) {
		// TODO Auto-generated method stub
		return dao.addSinger(singer);
	}

	public boolean deleteSinger(int singerId) {
		// TODO Auto-generated method stub
		return dao.deleteSinger(singerId);
	}

	public boolean updateSinger(Singer singer) {
		// TODO Auto-generated method stub
		return dao.updateSinger(singer);
	}

	public Singer querySingerBySingerId(int singerId) {
		// TODO Auto-generated method stub
		return dao.querySingerBySingerId(singerId);
	}

	public List<Singer> querySingerByTimers(String times) {
		// TODO Auto-generated method stub
		return dao.querySingerByTimers(times);
	}

	public List<Singer> querySingerByCountry(String singerCountry) {
		// TODO Auto-generated method stub
		return dao.querySingerByCountry(singerCountry);
	}

	public List<Singer> querySingerByGender(String singerGender) {
		// TODO Auto-generated method stub
		return dao.querySingerByGender(singerGender);
	}

	public List<Singer> querySingerByPopularity(int popularity) {
		// TODO Auto-generated method stub
		return dao.querySingerByPopularity(popularity);
	}

	public List<Singer> queryAllSingerInfo() {
		// TODO Auto-generated method stub
		return dao.queryAllSingerInfo();
	}

	public List<Singer> querySingerInfoByNumber() {
		// TODO Auto-generated method stub
		
		
		return dao.querySingerInfoByNumber();
	}

	public Singer querySingerInfoBySingerName(String singerName) {
		// TODO Auto-generated method stub
		return dao.querySingerInfoBySingerName(singerName);
	}

	public int counterByPage() {
		// TODO Auto-generated method stub
		return dao.counterByPage();
	}

	public List<Singer> querySingerInfoByPage(int pageNow, int limitPage) {
		// TODO Auto-generated method stub
		return dao.querySingerInfoByPage(pageNow, limitPage);
	}

}
