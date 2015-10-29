package com.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.EmotionCategoryBiz;
import com.biz.MusicBiz;
import com.biz.SingerBiz;
import com.biz.StyleCategoryBiz;
import com.biz.bizImpl.EmotionCategoryBizImpl;
import com.biz.bizImpl.MusicBizImpl;
import com.biz.bizImpl.SingerBizImpl;
import com.biz.bizImpl.StyleCategoryBizImpl;
import com.entity.EmotionCategory;
import com.entity.Music;
import com.entity.MusicInfo;
import com.entity.Singer;
import com.entity.StyleCategory;
import com.opensymphony.xwork2.Action;
import com.util.DBUtil;

/**
 * 
 *         2015-3-18下午4:54:07
 * 
 *         MusicWeb.com.action.MusicAction
 */
public class MusicAction extends BaseAction implements Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MusicInfo musicInfo;
	private Music music;
	private int styleId;
	private int emotionId;
	private int singerId;
	private String styleName;

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	private StyleCategory styleCategory;
	private EmotionCategory emotionCategory;
	private Singer singer;
	

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public EmotionCategory getEmotionCategory() {
		return emotionCategory;
	}

	public void setEmotionCategory(EmotionCategory emotionCategory) {
		this.emotionCategory = emotionCategory;
	}

	public StyleCategory getStyleCategory() {
		return styleCategory;
	}

	public void setStyleCategory(StyleCategory styleCategory) {
		this.styleCategory = styleCategory;
	}

	public int getSingerId() {
		return singerId;
	}

	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}

	public int getEmotionId() {
		return emotionId;
	}

	public void setEmotionId(int emotionId) {
		this.emotionId = emotionId;
	}

	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	public MusicInfo getMusicInfo() {
		return musicInfo;
	}

	public void setMusicInfo(MusicInfo musicInfo) {
		this.musicInfo = musicInfo;
	}

	private int musicId;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	MusicBiz musicbiz = new MusicBizImpl();

	/**
	 * @return 添加歌曲
	 */
	public String addMusic() {
		String musicName = req.getParameter("musicName");
		String singerName = req.getParameter("singerName");

		SingerBiz singerbiz = new SingerBizImpl();
		Singer singer = singerbiz.querySingerInfoBySingerName(singerName);
	

		String musicInstruction = req.getParameter("musicInstruction");
			
		int styleId = styleCategory.getStyleId();
		int emotionId = emotionCategory.getEmotionId();
		String musicPicture = req.getParameter("musicPicture");
		String musicLyrics = req.getParameter("musicLyrics");
		String musicPath = req.getParameter("musicPath");

		music = new Music(musicName, singer.getSingerId(), musicPicture,
				musicLyrics, musicInstruction, styleId, emotionId, musicPath);

		if (musicbiz.addMusic(music))

			return "addMusic";
		else
			return "error";
	}

	/**
	 * @return 删除歌曲
	 */
	public String deleteMusic() {
		if (musicbiz.deleteMusic(musicId))

			return "deleteMusic";
		else
			return "error";
	}

	/**
	 * @return 修改歌曲信息
	 */
	public String updateMusic() {
		int musicId = Integer.valueOf(req.getParameter("musicId"));
		String musicName = req.getParameter("musicName");
		String singerName = req.getParameter("singerName");

		SingerBiz singerbiz = new SingerBizImpl();
		Singer singer = singerbiz.querySingerInfoBySingerName(singerName);

		String musicInstruction = req.getParameter("musicInstruction");

		int styleId = styleCategory.getStyleId();
		int emotionId = emotionCategory.getEmotionId();
		String musicPicture = req.getParameter("musicPicture");
		String musicLyrics = req.getParameter("musicLyrics");
		String musicPath = req.getParameter("musicPath");

		music = new Music(musicId, musicName, singer.getSingerId(),
				musicPicture, musicLyrics, musicInstruction, styleId,
				emotionId, musicPath);

		if (musicbiz.updateMusic(music))

			return "updateMusic";
		else
			return "error";
	}

	/**
	 * @return 通过歌曲ID查找 用于首页显示
	 */
	@SuppressWarnings("unchecked")
	public String queryMusicBymusicId() {
		musicInfo = musicbiz.queryMusicBymusicId(musicId);

		sessionMap.put("musicInfo", musicInfo);

		return "queryMusicBymusicId";
	}

	/**
	 * @return 通过歌曲ID查找用于音乐页面显示
	 */
	@SuppressWarnings("unchecked")
	public String queryMusicInfoBymusicId() {
		musicInfo = musicbiz.queryMusicBymusicId(musicId);

		sessionMap.put("musicInfo", musicInfo);

		int i = 6;
		req.setAttribute("i", i);

		return "queryMusicInfoBymusicId";
	}

	/**
	 * @return 通过歌曲ID查找用于音乐页面显示
	 */
	@SuppressWarnings("unchecked")
	public String queryMusicInfoBymusicIdByAll() {
		musicInfo = musicbiz.queryMusicBymusicId(musicId);

		sessionMap.put("musicInfo", musicInfo);

		return "queryMusicInfoBymusicIdByAll";
	}

	/**
	 * @return 通过歌曲ID查找 用于管理员查看
	 */

	public String queryMusicBymusicIdToAdmin() {
		musicInfo = musicbiz.queryMusicBymusicId(musicId);

		app.setAttribute("musicInfo", musicInfo);

		int check = 1;
		req.setAttribute("check", check);

		return "queryMusicBymusicIdToAdmin";
	}

	/**
	 * @return 通过歌曲ID查找 用于管理员更新信息
	 */

	public String queryMusicBymusicIdToAdminUpdate() {
		musicInfo = musicbiz.queryMusicBymusicId(musicId);

		musicInfo.setStyleName("唯美");

		app.setAttribute("musicInfo", musicInfo);

		return "queryMusicBymusicIdToAdminUpdate";
	}

	/**
	 * @return 通过歌手ID查找
	 */
	public String queryMusicBysingerId() {
		List<MusicInfo> singerMusicInfo = musicbiz
				.queryMusicBysingerId(singerId);

		app.setAttribute("singerMusicInfo", singerMusicInfo);

		int i = 7;
		req.setAttribute("i", i);

		return "queryMusicBysingerId";
	}

	/**
	 * @return 通过风格ID查找
	 */
	public String queryMusicBystyleId() {

		List<MusicInfo> styleMusicInfo = musicbiz.queryMusicBystyleId(styleId);

		app.setAttribute("styleMusicInfo", styleMusicInfo);
		int i = 0;
		req.setAttribute("i", i);

		return "queryMusicBystyleId";
	}

	/**
	 * @return 通过情感ID查找
	 */
	public String queryMusicByemotionId() {
		List<MusicInfo> emotionMusicInfo = musicbiz
				.queryMusicByemotionId(emotionId);

		app.setAttribute("emotionMusicInfo", emotionMusicInfo);
		int i = 1;
		req.setAttribute("i", i);
		return "queryMusicByemotionId";

	}

	/**
	 * @return 查询12首歌曲信息
	 */
	public String queryAllMusicInfoByNumber() {
		List<MusicInfo> musicListByNumber = musicbiz
				.queryAllMusicInfoByNumber();

		app.setAttribute("musicListByNumber", musicListByNumber);

		return "queryAllMusicInfoByNumber";
	}

	/**
	 * @return 模糊查询
	 */
	public String fuzzyQueryMusicInfo() {

		String searchName = req.getParameter("searchName");

		String sql = "SELECT m.MUSICID,m.MUSICNAME,m.MUSICPICTURE,m.MUSICLYRICS,m.MUSICINSTRUCTION,s.singername,"
				+ "st.stylename,e.emotionname,m.musicpath FROM MUSIC m,singer s,emotion_category e,style_category st "
				+ "where m.emotionid = e.emotionid and m.singerid = s.singerid and st.styleid = m.styleid and m.musicname like '%"
				+ searchName + "%'";
		DBUtil util = new DBUtil();
		ResultSet rs = util.Query(sql);

		List<MusicInfo> fuzzymusicList = new ArrayList<MusicInfo>();

		try {
			while (rs.next()) {
				MusicInfo musicInfo = new MusicInfo(rs.getInt("MUSICID"),
						rs.getString("MUSICNAME"), rs.getString("singername"),
						rs.getString("MUSICPICTURE"),
						rs.getString("MUSICLYRICS"),
						rs.getString("MUSICINSTRUCTION"),
						rs.getString("stylename"), rs.getString("emotionname"),
						rs.getString("musicpath"));
				fuzzymusicList.add(musicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}

		app.setAttribute("fuzzymusicList", fuzzymusicList);

		int i = 5;
		req.setAttribute("i", i);
		return "fuzzyQueryMusicInfo";

	}

	/**
	 * @return 遍历全部信息
	 */
	public String queryAllMusicInfo() {
		List<MusicInfo> allmusicList = musicbiz.queryAllMusicInfo();

		app.setAttribute("allmusicList", allmusicList);

		return "queryAllMusicInfo";

	}

	/**
	 * @return 遍历全部信息2
	 */
	public String queryMusicInfo() {
		List<MusicInfo> musicList = musicbiz.queryAllMusicInfo();

		app.setAttribute("musicList", musicList);

		int i = 4;
		req.setAttribute("i", i);
		return "queryMusicInfo";

	}

	/**
	 * @return 遍历全部信息3 用于管理员管理
	 */
	public String queryMusicInfoToAdmin() {
		List<MusicInfo> musicListToAdmin = musicbiz.queryAllMusicInfo();

		app.setAttribute("musicListToAdmin", musicListToAdmin);

		int a = 1;
		req.setAttribute("a", a);

		return "queryMusicInfoToAdmin";

	}

	/**
	 * @return 最新的歌单
	 */
	public String queryNewMusicByNumber() {
		List<MusicInfo> newMusicList = musicbiz.queryNewMusicByNumber();
		app.setAttribute("newMusicList", newMusicList);

		int i = 2;
		req.setAttribute("i", i);
		return "queryNewMusicByNumber";
	}

	/**
	 * @return 最火的歌单
	 */
	public String queryHostMusicByNumber() {
		List<MusicInfo> hostMusicList = musicbiz.queryHostMusicByNumber();

		app.setAttribute("hostMusicList", hostMusicList);

		int i = 3;
		req.setAttribute("i", i);
		return "queryHostMusicByNumber";
	}

	// 情感分类

	EmotionCategoryBiz emotionbiz = new EmotionCategoryBizImpl();

	/**
	 * @return
	 */
	public String queryAllemotionInfo() {
		List<EmotionCategory> emotionList = emotionbiz.queryAllemotionInfo();

		app.setAttribute("emotionList", emotionList);

		return "queryAllemotionInfo";
	}

	// 风格类别的处理
	StyleCategoryBiz stylebiz = new StyleCategoryBizImpl();

	/**
	 * @return
	 */
	public String queryAllStyleInfo() {
		List<StyleCategory> styleList = stylebiz.queryAllStyleInfo();
		app.setAttribute("styleList", styleList);
		return "queryAllStyleInfo";
	}
}
