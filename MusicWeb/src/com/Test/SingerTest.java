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
 * 2015-3-10上午10:31:17
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
		Singer singer = new Singer(14,"曾轶可","曾轶可图片","中国","女",7,"90");
		
		boolean b = dao.addSinger(singer);
		
		if(b)
		{
			System.out.println("添加成功");
		}else
		{
			System.out.println("添加失败");
		}
		
	}

	
	@Test
	public void Test_deleteSinger()
	{
		boolean b =dao.deleteSinger(14);
		
		if(b)
		{
			System.out.println("删除成功");
		}else
		{
			System.out.println("删除失败");
		}
	}
	
	
	@Test
	public void Test_updateSinger()
	{
	Singer singer = new Singer(11,"曾轶可","曾轶可图片","中国","女",9,"90");
		
		boolean b = dao.updateSinger(singer);
		
		if(b)
		{
			System.out.println("修改成功");
		}else
		{
			System.out.println("修改失败");
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
		
		singerList = dao.querySingerByCountry("中国");
		
		for (Singer singer : singerList) {
			System.out.println(singer.getSingerId()+","+singer.getSingerName()+","+singer.getSingerGender()+","+singer.getSingerPicture()+","+
					singer.getSingerCountry()+","+singer.getPopularity()+","+singer.getTimes());
		}
	}
	
	
	@Test
	public void Test_querySingerByGender()
	{
	List<Singer> singerList = new ArrayList<Singer>();
		
		singerList = dao.querySingerByGender("女");
		
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
