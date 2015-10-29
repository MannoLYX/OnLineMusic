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
 * 2015-3-9上午9:14:50
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
	 * 增加悦单
	 * 
	 */
	@Test
	public void Test_addSongList()
	{
		SongList songList =  new SongList("靡靡之音之音","民间音乐歌手","图片Y",new Date(0),2,2);
		
		boolean b=dao.addSongList(songList);
		if(b)
			System.out.println("添加成功");
		else
			System.out.println("添加失败");
	}
	
/*	*//**
	 * 删除悦单信息
	 *//*
	@Test
	public void Test_deleteSongList()
	{
		boolean b = dao.deleteSongList(0);
		if(b)
			System.out.println("删除成功");
		else
			System.out.println("删除失败");
	}
	
	*//**
	 * 修改悦单
	 *//*
	@Test
	public void Test_updateSongList()
	{
		SongList songList = new SongList(0,"靡靡之音","知名作曲家","图片1",new Date(1),1,2);
		boolean b = dao.updateSongList(songList);
		
		if(b)
			System.out.println("修改成功");
		else
			System.out.println("修改失败");
	}
	
	*//**
	 * 通过ID查询悦单
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
	 * 遍历全部悦单信息
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
