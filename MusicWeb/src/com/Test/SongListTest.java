package com.Test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dao.daoImpl.SongListDaoImpl;
import com.entity.SongList;


/**
 *	
 * 2015-3-9����9:14:50
 *
 *MusicWeb.Test.SongListTest
 */
public class SongListTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	SongListDaoImpl dao = new SongListDaoImpl();
	/**
	 * �����õ�
	 * 
	 */
	@Test
	public void Test_addSongList()
	{
		SongList songList =  new SongList("����֮��֮��","������ָ���","ͼƬY",new Date(0),2,2);
		
		boolean b=dao.addSongList(songList);
		if(b)
			System.out.println("��ӳɹ�");
		else
			System.out.println("���ʧ��");
	}
	
/*	*//**
	 * ɾ���õ���Ϣ
	 *//*
	@Test
	public void Test_deleteSongList()
	{
		boolean b = dao.deleteSongList(0);
		if(b)
			System.out.println("ɾ���ɹ�");
		else
			System.out.println("ɾ��ʧ��");
	}
	
	*//**
	 * �޸��õ�
	 *//*
	@Test
	public void Test_updateSongList()
	{
		SongList songList = new SongList(0,"����֮��","֪��������","ͼƬ1",new Date(1),1,2);
		boolean b = dao.updateSongList(songList);
		
		if(b)
			System.out.println("�޸ĳɹ�");
		else
			System.out.println("�޸�ʧ��");
	}
	
	*//**
	 * ͨ��ID��ѯ�õ�
	 *//*
	@Test
	public void Test_querySongListById()
	{
		
		List<SongList> songListList= new ArrayList<SongList>();
		songListList = dao.querySongListById(2);
		
		for (SongList songList : songListList) {
			System.out.println(songList.getSongListId()+","+songList.getSongListName()+","+songList.getSongListInstryction()+","+
					songList.getSongListPicture()+","+songList.getMemberId()+","+songList.getMusicId());
		}
		
	}
	
	
	*//**
	 * ����ȫ���õ���Ϣ
	 *//*
	@Test
	public void Test_querySongListInfo()
	{
		List<SongList> listSong = new ArrayList<SongList>();	
		listSong = dao.querySongListInfo();
		for (SongList songList : listSong) {
		
				System.out.println(songList.getSongListId()+","+songList.getSongListName()+","+songList.getSongListInstryction()+","+
						songList.getSongListPicture()+","+songList.getMemberId()+","+songList.getMusicId());
			
		}
	}*/
	
}
