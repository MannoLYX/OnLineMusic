package com.action;

import java.util.ArrayList;
import java.util.List;

import com.biz.CommentaryBiz;
import com.biz.EmotionCategoryBiz;
import com.biz.MemberUserBiz;
import com.biz.MusicBiz;
import com.biz.SingerBiz;
import com.biz.StyleCategoryBiz;
import com.biz.bizImpl.CommentaryBizImpl;
import com.biz.bizImpl.EmotionCategoryBizImpl;
import com.biz.bizImpl.MemberUserBizImpl;
import com.biz.bizImpl.MusicBizImpl;
import com.biz.bizImpl.SingerBizImpl;
import com.biz.bizImpl.StyleCategoryBizImpl;
import com.entity.CommentaryInfo;
import com.entity.EmotionCategory;
import com.entity.MemberUserRole;
import com.entity.MusicInfo;
import com.entity.Singer;
import com.entity.StyleCategory;

/**
 * 
 *         2015-4-2����8:54:37
 * 
 *         MusicWeb.com.action.PageAction
 */
public class PageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ܼ�¼��
	 */
	private int totalRecord;
	/**
	 * ÿҳ��ʾ����
	 */
	private int limitPage = 5;

	/**
	 * ��ǰҳ
	 */
	private int nowPage = 1;

	/**
	 * ��ҳ��
	 */
	private int totalPage;

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getLimitPage() {
		return limitPage;
	}

	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	MemberUserBiz memberUserBiz = new MemberUserBizImpl();

	/**
	 * @return ��ȡĳҳ�û���Ϣ�ļ�¼
	 */
	public String queryMemberUserInfoByPage() {
		List<MemberUserRole> memberListByPage = new ArrayList<MemberUserRole>();

		// ��ȡ�ܼ�¼��
		totalRecord = memberUserBiz.counterByPage();

		// ��ȡ��ҳ��
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// ��ǰҳ����
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// ���ĳҳ�ļ�¼
		memberListByPage = memberUserBiz.queryMemberUserInfoByPage(nowPage,
				limitPage);

		app.setAttribute("memberListByPage", memberListByPage);

		int a = 0;
		req.setAttribute("a", a);

			return "queryMemberUserInfoByPage";
		
	}

	MusicBiz musicBiz = new MusicBizImpl();

	/**
	 * @return ��ȡĳҳ���ֵ���Ϣ
	 */
	public String queryMusicInfoByPage() {

		// ��ȡ�ܼ�¼��
		totalRecord = musicBiz.counterByPage();

		// ��ȡ��ҳ��
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// ��ǰҳ����
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// ���ĳҳ�ļ�¼
		List<MusicInfo> MusicInfoPage = musicBiz.queryMusicInfoByPage(nowPage,
				limitPage);

		app.setAttribute("MusicInfoPage", MusicInfoPage);

		int a = 1;
		req.setAttribute("a", a);

		
			return "queryMusicInfoByPage";
		
	}

	/**
	 * @return ��ҳ��ʾ��ҳ��ʾ20�׸�
	 */
	public String queryNewMusicByNumberByPage() {
		// ��ȡ�ܼ�¼��
		totalRecord = musicBiz.counterByPage();
		if(totalRecord>20)
		{
		totalRecord = 20;// musicBiz.counterByPage();
		}
		// ��ȡ��ҳ��
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// ��ǰҳ����
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// ���ĳҳ�ļ�¼
		List<MusicInfo> allmusicListPage = musicBiz
				.queryNewMusicByNumberByPage(nowPage, limitPage);
		app.setAttribute("allmusicListPage", allmusicListPage);

		return "queryNewMusicByNumberByPage";
	}

	SingerBiz singerBiz = new SingerBizImpl();

	/**
	 * @return ��ѯĳҳ�ĸ�����Ϣ
	 */
	public String querySingerInfoByPage() {
		// ��ȡ�ܼ�¼��
		totalRecord = singerBiz.counterByPage();

		// ��ȡ��ҳ��
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// ��ǰҳ����
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// ���ĳҳ�ļ�¼
		List<Singer> SingerInfoPage = singerBiz.querySingerInfoByPage(nowPage,
				limitPage);

		app.setAttribute("SingerInfoPage", SingerInfoPage);

		int a = 2;
		req.setAttribute("a", a);

		return "querySingerInfoByPage";

	}

	EmotionCategoryBiz emotionBiz = new EmotionCategoryBizImpl();

	/**
	 * @return ������ͷ���
	 */
	public String queryEmotionCategoryInfoByPage() {
		// ��ȡ�ܼ�¼��
		totalRecord = emotionBiz.counterByPage();

		// ��ȡ��ҳ��
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// ��ǰҳ����
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// ���ĳҳ�ļ�¼
		List<EmotionCategory> EmotionCategoryInfoPage = emotionBiz
				.queryEmotionCategoryInfoByPage(nowPage, limitPage);

		app.setAttribute("EmotionCategoryInfoPage", EmotionCategoryInfoPage);

		int a = 4;
		req.setAttribute("a", a);
		return "queryEmotionCategoryInfoByPage";

	}

	StyleCategoryBiz styleBiz = new StyleCategoryBizImpl();

	/**
	 * @return ��ѯĳҳ���������Ϣ
	 */
	public String queryStyleCategoryInfoByPage() {
		// ��ȡ�ܼ�¼��
		totalRecord = styleBiz.counterByPage();

		// ��ȡ��ҳ��
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// ��ǰҳ����
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// ���ĳҳ�ļ�¼
		List<StyleCategory> StyleCategoryInfoPage = styleBiz
				.queryStyleCategoryInfoByPage(nowPage, limitPage);

		app.setAttribute("StyleCategoryInfoPage", StyleCategoryInfoPage);

		int a = 3;
		req.setAttribute("a", a);

		return "queryStyleCategoryInfoByPage";
	}

	CommentaryBiz commBiz = new CommentaryBizImpl();

	/**
	 * @return ȫ��������Ϣ
	 */
	public String queryAllCommentaryInfoByPage() {
		// ��ȡ�ܼ�¼��
		totalRecord = commBiz.counterByPage();

		// ��ȡ��ҳ��
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// ��ǰҳ����
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// ���ĳҳ�ļ�¼
		List<CommentaryInfo> AllCommentaryInfoPage = commBiz
				.queryAllCommentaryInfoByPage(nowPage, limitPage);

		app.setAttribute("AllCommentaryInfoPage", AllCommentaryInfoPage);

		int a = 7;
		req.setAttribute("a", a);

		return "queryAllCommentaryInfoByPage";

	}

	/**
	 * @return ����������Ϣ
	 */
	public String queryMusicCommentaryInfoByPage() {
		// ��ȡ�ܼ�¼��
		totalRecord = commBiz.counterByPage();

		// ��ȡ��ҳ��
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// ��ǰҳ����
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// ���ĳҳ�ļ�¼
		List<CommentaryInfo> MusicCommentaryInfoPage = commBiz
				.queryMusicCommentaryInfoByPage(nowPage, limitPage);

		app.setAttribute("MusicCommentaryInfoPage", MusicCommentaryInfoPage);

		int a = 5;
		req.setAttribute("a", a);

		return "queryMusicCommentaryInfoByPage";

	}

}
