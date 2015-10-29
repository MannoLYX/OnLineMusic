package com.dao;

import java.util.List;

import com.entity.Music;
import com.entity.MusicInfo;


/**
 *	
 * 2015-3-6����3:31:49
 *
 *MusicWeb.dao.MusicDao
 */
public interface MusicDao {

	/**
	 * @param music
	 * @return
	 * ��Ӹ���
	 */
	public boolean addMusic(Music music);
	
	/**
	 * @param MusicId
	 * @return
	 * ɾ��
	 */
	public boolean deleteMusic(int MusicId);
	
	/**
	 * @param music
	 * @return
	 * �޸�
	 */
	public boolean updateMusic(Music music);
	
	/**
	 * @param musicId
	 * @return
	 * ͨ��ID ����
	 */
	public MusicInfo queryMusicBymusicId(int musicId);
	
	
	/**
	 * @return
	 * ����ȫ����Ϣ
	 */
	public List<MusicInfo> queryAllMusicInfo();
	
	
	/**
	 * @param singerId
	 * @return
	 * ͨ��singerId����������
	 */
	public List<MusicInfo> queryMusicBysingerId(int singerId);
	
	/**
	 * @param singerId
	 * @return
	 * ͨ��styleId����������
	 */
	public List<MusicInfo> queryMusicBystyleId(int styleId);
	
	
	/**
	 * @param singerId
	 * @return
	 * ͨ��emotionId����������
	 */
	public List<MusicInfo> queryMusicByemotionId(int emotionId);
	
	/**
	 * @return
	 * ����12��������Ϣ
	 */
	public List<MusicInfo> queryAllMusicInfoByNumber();
	
	/**
	 * @return
	 * ���µ�12�׸�
	 */
	public List<MusicInfo> queryNewMusicByNumber();
	
	/**
	 * @return
	 * ����12�׸�
	 */
	public List<MusicInfo>queryHostMusicByNumber();
	
	
	/**
	 * @return
	 * ��ȡ�����ܼ�¼��
	 */
	public int counterByPage();
	
	/**
	 * @param pageNum
	 * @param limitPage
	 * @return
	 * ��ѯ�ڼ�ҳ����Ϣ
	 */
	public  List<MusicInfo> queryMusicInfoByPage(int pageNow,int limitPage);
	
	
	/**
	 * @return
	 * ��ҳ��ҳ��ʾ���µ�20�׸�
	 */
	public List<MusicInfo> queryNewMusicByNumberByPage(int pageNow,int limitPage);
}

