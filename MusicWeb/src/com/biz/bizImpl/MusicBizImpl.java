package com.biz.bizImpl;

import java.util.List;

import com.biz.MusicBiz;
import com.dao.MusicDao;
import com.dao.daoImpl.MusicDaoImpl;
import com.entity.Music;
import com.entity.MusicInfo;



/**
 *	
 * 2015-3-6ÏÂÎç4:45:31
 *
 *MusicWeb.biz.bizImpl.MusicBizImpl
 */
public class MusicBizImpl implements MusicBiz {
	
	
	MusicDao dao = new MusicDaoImpl();

	public boolean addMusic(Music music) {
		// TODO Auto-generated method stub
		return dao.addMusic(music);
	}

	public boolean deleteMusic(int MusicId) {
		// TODO Auto-generated method stub
		return dao.deleteMusic(MusicId);
	}

	public boolean updateMusic(Music music) {
		// TODO Auto-generated method stub
		return dao.updateMusic(music);
	}

	public MusicInfo queryMusicBymusicId(int musicId) {
		// TODO Auto-generated method stub
		return dao.queryMusicBymusicId(musicId);
	}

	public List<MusicInfo> queryAllMusicInfo() {
		// TODO Auto-generated method stub
		return dao.queryAllMusicInfo();
	}

	public List<MusicInfo> queryMusicBysingerId(int singerId) {
		// TODO Auto-generated method stub
		return dao.queryMusicBysingerId(singerId);
	}

	public List<MusicInfo> queryMusicBystyleId(int styleId) {
		// TODO Auto-generated method stub
		return dao.queryMusicBystyleId(styleId);
	}

	public List<MusicInfo> queryMusicByemotionId(int emotionId) {
		// TODO Auto-generated method stub
		return dao.queryMusicByemotionId(emotionId);
	}

	public List<MusicInfo> queryAllMusicInfoByNumber() {
		// TODO Auto-generated method stub
		return dao.queryAllMusicInfoByNumber();
	}

	public List<MusicInfo> queryNewMusicByNumber() {
		// TODO Auto-generated method stub
		return dao.queryNewMusicByNumber();
	}

	public List<MusicInfo> queryHostMusicByNumber() {
		// TODO Auto-generated method stub
		return dao.queryHostMusicByNumber();
	}



	public int counterByPage() {
		// TODO Auto-generated method stub
		return dao.counterByPage();
	}

	public List<MusicInfo> queryMusicInfoByPage(int pageNow, int limitPage) {
		// TODO Auto-generated method stub
		return dao.queryMusicInfoByPage(pageNow, limitPage);
	}

	public List<MusicInfo> queryNewMusicByNumberByPage(int pageNow,
			int limitPage) {
		// TODO Auto-generated method stub
		return dao.queryNewMusicByNumberByPage(pageNow, limitPage);
	}

	

}
