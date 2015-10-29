package com.biz;

import com.entity.Commentary;
import java.util.List;

import com.entity.CommentaryInfo;


/**
 *	
 * 2015-3-25����9:05:23
 *
 *MusicWeb.com.biz.CommentaryBiz
 */
public interface CommentaryBiz {

		/**
		 * @param comm
		 * @return
		 * ��������
		 */
		public boolean addCommentary(Commentary comm);
		
		/**
		 * @param commentaryId
		 * @return
		 * ɾ������
		 */
		public boolean deleteCommentary(int commentaryId);
		
		/**
		 * @param commId
		 * @return
		 * ͨ��CommId����
		 */
		public CommentaryInfo queryCommentaryByCommId(int commId);
		
		/**
		 * @param commId
		 * @return
		 * ����ĳ���õ�������Ϣ
		 */
		public CommentaryInfo querySongListCommentaryByCommId(int commId);
		/**
		 * @param musicId
		 * @return
		 * ͨ��musicId ��ѯ����
		 */
		public List<CommentaryInfo> queryCommentaryByMusicId(int musicId);
		
		/**
		 * @param SongListId
		 * @return
		 * ͨ��SongListId ��ѯ����
		 */
		public List<CommentaryInfo> queryCommentaryBySongListId(int songListId);
		
		
		/**
		 * @param memberId
		 * @return
		 * ͨ��memberId ��������
		 */
		public List<CommentaryInfo> queryCommentaryByMemberUserId(int memberId);
		
		/**
		 * @return
		 * ��ѯȫ����Ϣ
		 */
		public List<CommentaryInfo> queryCommentaryInfoByAll();
		
		
		/**
		 * @return
		 * ��ѯĳ�û��ĸ�������
		 */
		public List<CommentaryInfo> queryMusicCommentaryByUserId(int memberId);
		
		
		/**
		 * @return
		 * ��ѯĳ�û����õ�����
		 */
		public List<CommentaryInfo> querySongListCommentaryByUserId(int memberId);
		
		
		/**
		 * @return
		 * ��ѯȫ���ĸ�������
		 */
		public List<CommentaryInfo> queryAllMUsicCommentaryInfo();
		
		/**
		 * @return
		 * ��ѯȫ�����õ���Ϣ
		 */
		public List<CommentaryInfo> queryAllSongListCommentaryInfo();
		

		/**
		 * @return
		 * ��ȡ�����ܼ�¼��
		 */
		public int counterByPage();
		
		/**
		 * @param pageNum
		 * @param limitPage
		 * @return
		 * ��ѯ�ڼ�ҳ�ĸ���������Ϣ
		 */
		public  List<CommentaryInfo> queryMusicCommentaryInfoByPage(int pageNow,int limitPage);
		
		/**
		 * @param pageNow
		 * @param limitPage
		 * @return
		 * ��ѯ�ڼ�ҳ��ȫ������
		 */
		public List<CommentaryInfo> queryAllCommentaryInfoByPage(int pageNow,int limitPage );

}
