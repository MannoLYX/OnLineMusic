package com.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dao.SingerDao;
import com.dao.daoImpl.SingerDaoImpl;
import com.entity.Singer;


/**
 *	
 * 2015-3-10����10:31:17
 *
 *MusicWeb.Test.SingerTest
 */
public class SingerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	SingerDao dao = new SingerDaoImpl();
	
	@Test
	public void Test_addSinger()
	{
		Singer singer = new Singer(14,"�����","�����ͼƬ","�й�","Ů",7,"90");
		
		boolean b = dao.addSinger(singer);
		
		if(b)
		{
			System.out.println("��ӳɹ�");
		}else
		{
			System.out.println("���ʧ��");
		}
		
	}

	
	@Test
	public void Test_deleteSinger()
	{
		boolean b =dao.deleteSinger(14);
		
		if(b)
		{
			System.out.println("ɾ���ɹ�");
		}else
		{
			System.out.println("ɾ��ʧ��");
		}
	}
	
	
	@Test
	public void Test_updateSinger()
	{
	Singer singer = new Singer(11,"�����","�����ͼƬ","�й�","Ů",9,"90");
		
		boolean b = dao.updateSinger(singer);
		
		if(b)
		{
			System.out.println("�޸ĳɹ�");
		}else
		{
			System.out.println("�޸�ʧ��");
		}
		
	}
	
	
	@Test
	public void Test_querySingerBySingerId()
	{
		Singer singer = new Singer();
		
		singer =dao.querySingerBySingerId(2);
		
		System.out.println(singer.getSingerId()+","+singer.getSingerName()+","+singer.getSingerGender()+","+singer.getSingerPicture()+","+
		singer.getSingerCountry()+","+singer.getPopularity()+","+singer.getTimes());
	}
	
	
	@Test
	public void Test_querySingerByTimers()
	{
		List<Singer> singerList = new ArrayList<Singer>();
		
		singerList = dao.querySingerByTimers("90");
		
		for (Singer singer : singerList) {
			System.out.println(singer.getSingerId()+","+singer.getSingerName()+","+singer.getSingerGender()+","+singer.getSingerPicture()+","+
					singer.getSingerCountry()+","+singer.getPopularity()+","+singer.getTimes());
		}
	}
	
	
	@Test
	public void Test_querySingerByCountry()
	{
		List<Singer> singerList = new ArrayList<Singer>();
		
		singerList = dao.querySingerByCountry("�й�");
		
		for (Singer singer : singerList) {
			System.out.println(singer.getSingerId()+","+singer.getSingerName()+","+singer.getSingerGender()+","+singer.getSingerPicture()+","+
					singer.getSingerCountry()+","+singer.getPopularity()+","+singer.getTimes());
		}
	}
	
	
	@Test
	public void Test_querySingerByGender()
	{
	List<Singer> singerList = new ArrayList<Singer>();
		
		singerList = dao.querySingerByGender("Ů");
		
		for (Singer singer : singerList) {
			System.out.println(singer.getSingerId()+","+singer.getSingerName()+","+singer.getSingerGender()+","+singer.getSingerPicture()+","+
					singer.getSingerCountry()+","+singer.getPopularity()+","+singer.getTimes());
		}
	}
	
	
	@Test
	public void Test_querySingerByPopularity()
	{
	List<Singer> singerList = new ArrayList<Singer>();
		
		singerList = dao.querySingerByPopularity(8);
		
		for (Singer singer : singerList) {
			System.out.println(singer.getSingerId()+","+singer.getSingerName()+","+singer.getSingerGender()+","+singer.getSingerPicture()+","+
					singer.getSingerCountry()+","+singer.getPopularity()+","+singer.getTimes());
		}
	}
	
	
	@Test
	public void Test_queryAllSingerInfo()
	{
	List<Singer> singerList = new ArrayList<Singer>();
		
		singerList = dao.queryAllSingerInfo();
		
		for (Singer singer : singerList) {
			System.out.println(singer.getSingerId()+","+singer.getSingerName()+","+singer.getSingerGender()+","+singer.getSingerPicture()+","+
					singer.getSingerCountry()+","+singer.getPopularity()+","+singer.getTimes());
		}
	}
}
