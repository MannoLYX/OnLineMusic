package com.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dao.daoImpl.MusicDaoImpl;
import com.entity.Music;
import com.entity.MusicInfo;


/**
 *	
 * 2015-3-6下午4:18:32
 *
 *MusicWeb.Test.MusicTest
 */
public class MusicTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	MusicDaoImpl daoImpl = new MusicDaoImpl();
	
	
	/**
	 * 添加
	 */
	@Test
	public void Test_addMusic()
	{
		Music music = new Music("遇见",1,"图片爱情","亲爱的，那不是爱情","遇见不如不见",1,1, null);
		
		boolean b=daoImpl.addMusic(music);
		if(b)
		{
			System.out.println("添加成功");
		}else
		{
			System.out.println("添加失败");
		}
		
	}
	
	
	/**
	 * 删除
	 */
	@Test
	public void Test_deleteMusic()
	{
		boolean b=daoImpl.deleteMusic(6);
		if(b)
		{
			System.out.println("删除成功");
		}else
		{
			System.out.println("删除失败");
		}
	}
	
	/**
	 * 修改
	 */
	@Test
	public void Test_updateMusic()
	{
		Music music = new Music(2,"那不是爱情",2,"图片爱情","亲爱的，那不是爱情","相见不如不见", 2,2, null);
		
		boolean b=daoImpl.updateMusic(music);
		if(b)
		{
			System.out.println("更新成功");
		}else
		{
			System.out.println("更新失败");
		}
		
	}
	
	
	
	/**
	 * 通过musicID 查找音乐信息
	 */
	@Test
	public void Test_queryMusicBymusicId()
	{
		MusicInfo music = new MusicInfo();
		music = daoImpl.queryMusicBymusicId(2);
		System.out.println(music.getMusicId()+","+music.getMusicName()+","+music.getSingerName()+","+music.getMusicLyrics()+","+
				music.getMusicPicture()+","+music.getMusicInstruction()+","+music.getStyleName()+","+music.getEmotionName());
	}
	
	/**
	 * 遍历全部音乐信息
	 */
	@Test
	public void Test_queryAllMusicInfo()
	{
		
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		
		musicList = daoImpl.queryAllMusicInfo();
		
		for (MusicInfo music : musicList) {
			System.out.println(music.getMusicId()+","+music.getMusicName()+","+music.getSingerName()+","+music.getMusicLyrics()+","+
					music.getMusicPicture()+","+music.getMusicInstruction()+","+music.getStyleName()+","+music.getEmotionName());
		}
	}
	
	
	/**
	 * 通过singerId 查找音乐信息
	 */
	@Test
	public void Test_queryMusicBysingerId()
	{
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		musicList = daoImpl.queryMusicBysingerId(2);
		for (MusicInfo musicInfo : musicList) {

		System.out.println(musicInfo.getMusicId()+","+musicInfo.getMusicName()+","+musicInfo.getSingerName()+","+musicInfo.getMusicLyrics()+","+
				musicInfo.getMusicPicture()+","+musicInfo.getMusicInstruction()+","+musicInfo.getStyleName()+","+musicInfo.getEmotionName());
	
		}
	}
	
	/**
	 * 通过styleId 查找音乐信息
	 */
	@Test
	public void Test_queryMusicBystyleId()
	{
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		musicList = daoImpl.queryMusicBystyleId(2);
		for (MusicInfo musicInfo : musicList) {

		System.out.println(musicInfo.getMusicId()+","+musicInfo.getMusicName()+","+musicInfo.getSingerName()+","+musicInfo.getMusicLyrics()+","+
				musicInfo.getMusicPicture()+","+musicInfo.getMusicInstruction()+","+musicInfo.getStyleName()+","+musicInfo.getEmotionName());
		}
	}
	
	/**
	 * 通过emotionId 查找音乐信息
	 */
	@Test
	public void queryMusicByemotionId()
	{
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
		musicList = daoImpl.queryMusicByemotionId(2);
		for (MusicInfo musicInfo : musicList) {

		System.out.println(musicInfo.getMusicId()+","+musicInfo.getMusicName()+","+musicInfo.getSingerName()+","+musicInfo.getMusicLyrics()+","+
				musicInfo.getMusicPicture()+","+musicInfo.getMusicInstruction()+","+musicInfo.getStyleName()+","+musicInfo.getEmotionName());
		}
	}
	

}
