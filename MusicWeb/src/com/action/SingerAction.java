package com.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.SingerBiz;
import com.biz.bizImpl.SingerBizImpl;
import com.entity.MusicInfo;
import com.entity.Singer;
import com.opensymphony.xwork2.Action;
import com.util.DBUtil;

/**
 * 
 *         2015-3-18下午1:57:55
 * 
 *         MusicWeb.com.action.SingerAction
 */
public class SingerAction extends BaseAction implements Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Singer singer;
	private int singerId;
	private String singerGender;
	private String singerCountry;
	private int popularity;
	private String times;
	private List<Singer> singerList;

	public List<Singer> getSingerList() {
		return singerList;
	}

	public void setSingerList(List<Singer> singerList) {
		this.singerList = singerList;
	}

	public String getSingerGender() {
		return singerGender;
	}

	public void setSingerGender(String singerGender) {

		this.singerGender = singerGender;

	}

	public String getSingerCountry() {
		return singerCountry;
	}

	public void setSingerCountry(String singerCountry) {
		/*
		 * try { this.singerCountry = new
		 * String(singerCountry.getBytes("iso-8859-1"),"utf-8"); } catch
		 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); };
		 */
		this.singerCountry = singerCountry;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public int getSingerId() {
		return singerId;
	}

	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}

	SingerBiz biz = new SingerBizImpl();

	/**
	 * @return 增加歌手信息
	 */
	public String addSinger() {
		String singerName = req.getParameter("singerName");
		String singerCountry = req.getParameter("singerCountry");
		String singerGender = req.getParameter("singerGender");
		String singerPicture = req.getParameter("singerPicture");
		int popularity = Integer.valueOf(req.getParameter("popularity"));
		String times = req.getParameter("times");

		singer = new Singer(singerName, singerPicture, singerCountry,
				singerGender, popularity, times);
		


		if (biz.addSinger(singer))
			return "addSinger";
		else
			return "error";

	}

	/**
	 * @return 删除歌手信息
	 */
	public String deleteSinger() {
		if (biz.deleteSinger(singerId))

			return "deleteSinger";
		else
			return "error";
	}

	/**
	 * @return 修改歌手信息
	 */
	public String updateSinger() {

		int singerId = Integer.valueOf(req.getParameter("singerId"));
		String singerName = req.getParameter("singerName");
		String singerCountry = req.getParameter("singerCountry");
		String singerGender = req.getParameter("singerGender");
		String singerPicture = req.getParameter("singerPicture");
		int popularity = Integer.valueOf(req.getParameter("popularity"));
		String times = req.getParameter("times");

		singer = new Singer(singerId, singerName, singerPicture, singerCountry,
				singerGender, popularity, times);

		if (biz.updateSinger(singer))

			return "updateSinger";

		else
			return "error";
	}

	/**
	 * @return 用户通过ID查找
	 */
	public String querySingerBySingerId() {
		biz.querySingerBySingerId(singerId);

		return "querySingerBySingerId";
	}

	/**
	 * @return 管理员通过ID查找歌手信息以便查看
	 */
	public String AdminQuerySingerBySingerIdToCheck() {
		singer = biz.querySingerBySingerId(singerId);

		int check = 2;
		req.setAttribute("check", check);

		return "AdminQuerySingerBySingerIdToCheck";
	}

	/**
	 * @return 管理员通过ID查找歌手信息以便更新
	 */
	public String AdminQuerySingerBySingerIdToUpdate() {
		singer = biz.querySingerBySingerId(singerId);

		int update = 2;
		req.setAttribute("update", update);

		return "AdminQuerySingerBySingerIdToUpdate";
	}

	/**
	 * @return 管理员通过歌手信息以便添加
	 */
	public String AdminQuerySingerToAdd() {

		int add = 2;
		req.setAttribute("add", add);

		return "AdminQuerySingerToAdd";
	}

	/**
	 * @return 通过年代查找
	 */
	public String querySingerByTimers() {

		List<Singer> singerByTimes = biz.querySingerByTimers(times);

		app.setAttribute("singerByTimes", singerByTimes);

		int s = 3;
		req.setAttribute("s", s);
		return "querySingerByTimers";
	}

	/**
	 * @return 通过国家查找
	 * 
	 */
	public String querySingerByCountry() {

		List<Singer> singerByCountry = biz.querySingerByCountry(singerCountry);

		app.setAttribute("singerByCountry", singerByCountry);

		int s = 1;
		req.setAttribute("s", s);
		return "querySingerByCountry";
	}

	/**
	 * @return 通过性别查找
	 */
	public String querySingerByGender() {

		List<Singer> singerByGender = biz.querySingerByGender(singerGender);

		app.setAttribute("singerByGender", singerByGender);

		int s = 0;
		req.setAttribute("s", s);

		return "querySingerByGender";
	}

	/**
	 * @return 通过欢迎程度查找
	 */
	public String querySingerByPopularity() {
		List<Singer> singerByPopularity = biz
				.querySingerByPopularity(popularity);

		app.setAttribute("singerByPopularity", singerByPopularity);

		int s = 2;
		req.setAttribute("s", s);
		return "querySingerByPopularity";
	}
	
	
	/**
	 * @return 查询全部信息
	 */
	@SuppressWarnings("unchecked")
	public String queryAllSingerNameInfo() {
		 singerList = biz.queryAllSingerInfo();

		sessionMap.put("singerList", singerList);

		return "queryAllSingerNameInfo";
	}

	/**
	 * @return 查询全部信息
	 */
	@SuppressWarnings("unchecked")
	public String queryAllSingerInfo() {
		List<Singer> singerList = biz.queryAllSingerInfo();

		sessionMap.put("singerList", singerList);

		return "queryAllSingerInfo";
	}

	/**
	 * @return 管理员查询全部信息
	 */
	public String queryAllSingerInfoToAdmin() {
		List<Singer> singerListToAdmin = biz.queryAllSingerInfo();

		app.setAttribute("singerListToAdmin", singerListToAdmin);

		int a = 2;
		req.setAttribute("a", a);

		return "queryAllSingerInfoToAdmin";
	}

	/**
	 * @return 管理员查询全部信息用于更新歌曲
	 */
	public String queryAllSingerInfoToUpdateMusic() {
		singerList = biz.queryAllSingerInfo();

		app.setAttribute("singerList", singerList);

		return "queryAllSingerInfoToUpdateMusic";
	}

	/**
	 * @return 模糊查询
	 */
	public String fuzzyQuerySingerInfo() {

		String searchName = req.getParameter("searchName");

		String sql = "select * from singer  where singerName like '%"
				+ searchName + "%'";

		List<Singer> fuzzysingerList = new ArrayList<Singer>();
		DBUtil util = new DBUtil();
		ResultSet rs = util.Query(sql);

		try {
			while (rs.next()) {
				Singer Singer = new Singer(rs.getInt("singerId"),
						rs.getString("SINGERNAME"),
						rs.getString("SINGERPICTURE"),
						rs.getString("singerCountry"),
						rs.getString("SingerGender"), rs.getInt("popularity"),
						rs.getString("times"));

				fuzzysingerList.add(Singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}

		app.setAttribute("fuzzysingerList", fuzzysingerList);

		int s = 4;
		req.setAttribute("s", s);
		return "fuzzyQuerySingerInfo";

	}
}
