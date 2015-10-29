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
 * 2015-3-6����4:18:32
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
	 * ���
	 */
	@Test
	public void Test_addMusic()
	{
		Music music = new Music("����",1,"ͼƬ����","�װ��ģ��ǲ��ǰ���","�������粻��",1,1, null);
		
		boolean b=daoImpl.addMusic(music);
		if(b)
		{
			System.out.println("��ӳɹ�");
		}else
		{
			System.out.println("���ʧ��");
		}
		
	}
	
	
	/**
	 * ɾ��
	 */
	@Test
	public void Test_deleteMusic()
	{
		boolean b=daoImpl.deleteMusic(6);
		if(b)
		{
			System.out.println("ɾ���ɹ�");
		}else
		{
			System.out.println("ɾ��ʧ��");
		}
	}
	
	/**
	 * �޸�
	 */
	@Test
	public void Test_updateMusic()
	{
		Music music = new Music(2,"�ǲ��ǰ���",2,"ͼƬ����","�װ��ģ��ǲ��ǰ���","������粻��", 2,2, null);
		
		boolean b=daoImpl.updateMusic(music);
		if(b)
		{
			System.out.println("���³ɹ�");
		}else
		{
			System.out.println("����ʧ��");
		}
		
	}
	
	
	
	/**
	 * ͨ��musicID ����������Ϣ
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
	 * ����ȫ��������Ϣ
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
	 * ͨ��singerId ����������Ϣ
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
	 * ͨ��styleId ����������Ϣ
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
	 * ͨ��emotionId ����������Ϣ
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
