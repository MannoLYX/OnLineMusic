package com.Test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dao.CommentaryDao;
import com.dao.daoImpl.CommentaryDaoImpl;
import com.entity.Commentary;
import com.entity.CommentaryInfo;


/**
 *	
 * 2015-3-9上午11:19:14
 *
 *MusicWeb.Test.CommentaryTest
 */
public class CommentaryTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	CommentaryDao dao = new CommentaryDaoImpl();
	/**
	 * 增加
	 */
	@Test
	public void Test_addCommentary()
	{
		Commentary comm = new Commentary("a goog song",new Date(3),1,0,1);
		boolean b = dao.addCommentary(comm);
		
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
	public void Test_deleteCommentary()
	{
		boolean b = dao.deleteCommentary(21);
		
		if(b)
		{
			System.out.println("删除成功");
		}else
		{
			System.out.println("删除失败");
		}
	}

	
	/**
	 * 通过musicId查找 评论
	 */
	@Test
	public void Test_queryCommentaryByMusicId()
	{
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		commentaryList = dao.queryCommentaryByMusicId(1);
		for (CommentaryInfo commentaryInfo : commentaryList) {
			System.out.println(commentaryInfo.getCommentaryId()+","+commentaryInfo.getCommentaryContext()+","+commentaryInfo.getCommentaryTime()+","+
					commentaryInfo.getMusicName()+","+commentaryInfo.getMemberName());
		}
	}
	
	/**
	 * 通过SongListId查找 评论
	 */
	@Test
	public void Test_queryCommentaryBySongListId()
	{
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		commentaryList = dao.queryCommentaryBySongListId(1);
		
		for (CommentaryInfo commentaryInfo : commentaryList) {
			System.out.println(commentaryInfo.getCommentaryId()+","+commentaryInfo.getCommentaryContext()+","+commentaryInfo.getCommentaryTime()+","+
					commentaryInfo.getSongListName()+","+commentaryInfo.getMemberName());
		}
	}
	
	/**
	 * 通过memberId查找 评论
	 */
	@Test
	public void Test_queryCommentaryByMemberId()
	{
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		commentaryList = dao.queryCommentaryByMemberUserId(1);
		
		for (CommentaryInfo commentaryInfo : commentaryList) {
			System.out.println(commentaryInfo.getCommentaryId()+","+commentaryInfo.getCommentaryContext()+","+commentaryInfo.getCommentaryTime()+","+
					commentaryInfo.getMemberName());
		}
	}
	
	/**
	 * 查询全部的 用户评论
	 */
	@Test
	public void Test_queryCommentaryInfoByAll()
	{
		List<CommentaryInfo> commentaryList = new ArrayList<CommentaryInfo>();
		commentaryList = dao.queryCommentaryInfoByAll();
		
		for (CommentaryInfo commentaryInfo : commentaryList) {
			System.out.println(commentaryInfo.getCommentaryId()+","+commentaryInfo.getCommentaryContext()+","+commentaryInfo.getCommentaryTime()+","+
					commentaryInfo.getMemberName());
		}
	}
}
