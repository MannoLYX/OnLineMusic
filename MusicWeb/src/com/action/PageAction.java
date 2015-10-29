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
 *         2015-4-2上午8:54:37
 * 
 *         MusicWeb.com.action.PageAction
 */
public class PageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 总记录数
	 */
	private int totalRecord;
	/**
	 * 每页显示条数
	 */
	private int limitPage = 5;

	/**
	 * 当前页
	 */
	private int nowPage = 1;

	/**
	 * 总页数
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
	 * @return 获取某页用户信息的记录
	 */
	public String queryMemberUserInfoByPage() {
		List<MemberUserRole> memberListByPage = new ArrayList<MemberUserRole>();

		// 获取总记录数
		totalRecord = memberUserBiz.counterByPage();

		// 获取总页数
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// 当前页处理
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// 获得某页的记录
		memberListByPage = memberUserBiz.queryMemberUserInfoByPage(nowPage,
				limitPage);

		app.setAttribute("memberListByPage", memberListByPage);

		int a = 0;
		req.setAttribute("a", a);

			return "queryMemberUserInfoByPage";
		
	}

	MusicBiz musicBiz = new MusicBizImpl();

	/**
	 * @return 获取某页音乐的信息
	 */
	public String queryMusicInfoByPage() {

		// 获取总记录数
		totalRecord = musicBiz.counterByPage();

		// 获取总页数
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// 当前页处理
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// 获得某页的记录
		List<MusicInfo> MusicInfoPage = musicBiz.queryMusicInfoByPage(nowPage,
				limitPage);

		app.setAttribute("MusicInfoPage", MusicInfoPage);

		int a = 1;
		req.setAttribute("a", a);

		
			return "queryMusicInfoByPage";
		
	}

	/**
	 * @return 首页显示分页显示20首歌
	 */
	public String queryNewMusicByNumberByPage() {
		// 获取总记录数
		totalRecord = musicBiz.counterByPage();
		if(totalRecord>20)
		{
		totalRecord = 20;// musicBiz.counterByPage();
		}
		// 获取总页数
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// 当前页处理
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// 获得某页的记录
		List<MusicInfo> allmusicListPage = musicBiz
				.queryNewMusicByNumberByPage(nowPage, limitPage);
		app.setAttribute("allmusicListPage", allmusicListPage);

		return "queryNewMusicByNumberByPage";
	}

	SingerBiz singerBiz = new SingerBizImpl();

	/**
	 * @return 查询某页的歌手信息
	 */
	public String querySingerInfoByPage() {
		// 获取总记录数
		totalRecord = singerBiz.counterByPage();

		// 获取总页数
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// 当前页处理
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// 获得某页的记录
		List<Singer> SingerInfoPage = singerBiz.querySingerInfoByPage(nowPage,
				limitPage);

		app.setAttribute("SingerInfoPage", SingerInfoPage);

		int a = 2;
		req.setAttribute("a", a);

		return "querySingerInfoByPage";

	}

	EmotionCategoryBiz emotionBiz = new EmotionCategoryBizImpl();

	/**
	 * @return 情感类型分类
	 */
	public String queryEmotionCategoryInfoByPage() {
		// 获取总记录数
		totalRecord = emotionBiz.counterByPage();

		// 获取总页数
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// 当前页处理
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// 获得某页的记录
		List<EmotionCategory> EmotionCategoryInfoPage = emotionBiz
				.queryEmotionCategoryInfoByPage(nowPage, limitPage);

		app.setAttribute("EmotionCategoryInfoPage", EmotionCategoryInfoPage);

		int a = 4;
		req.setAttribute("a", a);
		return "queryEmotionCategoryInfoByPage";

	}

	StyleCategoryBiz styleBiz = new StyleCategoryBizImpl();

	/**
	 * @return 查询某页风格类型信息
	 */
	public String queryStyleCategoryInfoByPage() {
		// 获取总记录数
		totalRecord = styleBiz.counterByPage();

		// 获取总页数
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// 当前页处理
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// 获得某页的记录
		List<StyleCategory> StyleCategoryInfoPage = styleBiz
				.queryStyleCategoryInfoByPage(nowPage, limitPage);

		app.setAttribute("StyleCategoryInfoPage", StyleCategoryInfoPage);

		int a = 3;
		req.setAttribute("a", a);

		return "queryStyleCategoryInfoByPage";
	}

	CommentaryBiz commBiz = new CommentaryBizImpl();

	/**
	 * @return 全部评论信息
	 */
	public String queryAllCommentaryInfoByPage() {
		// 获取总记录数
		totalRecord = commBiz.counterByPage();

		// 获取总页数
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// 当前页处理
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// 获得某页的记录
		List<CommentaryInfo> AllCommentaryInfoPage = commBiz
				.queryAllCommentaryInfoByPage(nowPage, limitPage);

		app.setAttribute("AllCommentaryInfoPage", AllCommentaryInfoPage);

		int a = 7;
		req.setAttribute("a", a);

		return "queryAllCommentaryInfoByPage";

	}

	/**
	 * @return 歌曲评论信息
	 */
	public String queryMusicCommentaryInfoByPage() {
		// 获取总记录数
		totalRecord = commBiz.counterByPage();

		// 获取总页数
		totalPage = (totalRecord + limitPage - 1) / limitPage;

		// 当前页处理
		if (nowPage < 1) {
			nowPage = 1;
		} else if (nowPage >= totalPage) {
			nowPage = totalPage;
		}

		// 获得某页的记录
		List<CommentaryInfo> MusicCommentaryInfoPage = commBiz
				.queryMusicCommentaryInfoByPage(nowPage, limitPage);

		app.setAttribute("MusicCommentaryInfoPage", MusicCommentaryInfoPage);

		int a = 5;
		req.setAttribute("a", a);

		return "queryMusicCommentaryInfoByPage";

	}

}
