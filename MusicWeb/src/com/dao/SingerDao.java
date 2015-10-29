package com.dao;

import java.util.List;

import com.entity.Singer;


/**
 *	
 * 2015-3-10����9:53:36
 *
 *MusicWeb.dao.SingerDao
 */
public interface SingerDao {

	/**
	 * @param singer
	 * @return
	 * ���Ӹ�����Ϣ
	 */
	public boolean addSinger(Singer singer);
	
	/**
	 * @param singerId
	 * @return
	 * ɾ������
	 */
	public boolean deleteSinger(int singerId);
	
	/**
	 * @param singer
	 * @return
	 * �޸ĸ�����Ϣ
	 */
	public boolean updateSinger(Singer singer);
	
	/**
	 * @param singerId
	 * @return
	 * ͨ��SingerId������Ϣ
	 */
	public Singer querySingerBySingerId(int singerId);
	
	/**
	 * @param Timers
	 * @return
	 * ͨ�� timers ���������
	 */
	public List<Singer> querySingerByTimers(String times);
	
	/**
	 * @param singerCountry
	 * @return
	 * ͨ������������
	 */
	public List<Singer> querySingerByCountry(String singerCountry);
	
	
	/**
	 * @param singerGender
	 * @return
	 * ͨ������ �Ա�������
	 */
	public List<Singer> querySingerByGender(String singerGender);
	
	/**
	 * @param popularity
	 * @return
	 * ͨ�� �����ܻ�ӭ�̶� ������
	 */
	public List<Singer> querySingerByPopularity(int popularity);
	
	/**
	 * @return
	 * ����ȫ��������Ϣ
	 */
	public List<Singer> queryAllSingerInfo();
	
	
	/**
	 * @return
	 * ����12��������Ϣ
	 */
	public List<Singer> querySingerInfoByNumber();
	
	/**
	 * @return
	 * ͨ�������� ���Ҹ�����Ϣ
	 */
	public Singer querySingerInfoBySingerName(String singerName);
	
	
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
	public  List<Singer> querySingerInfoByPage(int pageNow,int limitPage);
}
