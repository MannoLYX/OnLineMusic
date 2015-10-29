package com.action;

import java.util.List;

import com.biz.EmotionCategoryBiz;
import com.biz.StyleCategoryBiz;
import com.biz.bizImpl.EmotionCategoryBizImpl;
import com.biz.bizImpl.StyleCategoryBizImpl;
import com.entity.EmotionCategory;
import com.entity.StyleCategory;
import com.opensymphony.xwork2.Action;

/**

 * 
 *         2015-3-19下午2:51:37
 * 
 *         MusicWeb.com.action.CategoryAction
 */
public class CategoryAction extends BaseAction implements Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StyleCategory style;
	private EmotionCategory emotion;

	private int styleId;
	private int emotionId;

	private List<StyleCategory> styleList;
	private List<EmotionCategory> emotionList;

	public List<EmotionCategory> getEmotionList() {
		return emotionList;
	}

	public void setEmotionList(List<EmotionCategory> emotionList) {
		this.emotionList = emotionList;
	}

	public List<StyleCategory> getStyleList() {
		return styleList;
	}

	public void setStyleList(List<StyleCategory> styleList) {
		this.styleList = styleList;
	}

	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	public int getEmotionId() {
		return emotionId;
	}

	public void setEmotionId(int emotionId) {
		this.emotionId = emotionId;
	}

	public StyleCategory getStyle() {
		return style;
	}

	public void setStyle(StyleCategory style) {
		this.style = style;
	}

	public EmotionCategory getEmotion() {
		return emotion;
	}

	public void setEmotion(EmotionCategory emotion) {
		this.emotion = emotion;
	}

	// 风格类别的处理
	StyleCategoryBiz stylebiz = new StyleCategoryBizImpl();

	/**
	 * @return
	 * 
	 */

	public String addStyleforword() {
		int add = 3;
		req.setAttribute("add", add);

		return "addStyleforword";
	}

	/**
	 * @return
	 */
	public String addStyle() {
		String styleName = req.getParameter("styleName");

		style = new StyleCategory(styleName);
		if (stylebiz.addStyleCategpry(style))

			return "addStyle";

		else
			return "error";
	}

	/**
	 * @return
	 */
	public String deleteStyle() {
		if (stylebiz.deleteStyleCategory(styleId))

			return "deleteStyle";

		else
			return "error";

	}

	/**
	 * @return
	 */
	public String updateStyle() {
		int styleId = Integer.valueOf(req.getParameter("styleId"));
		String styleName = req.getParameter("styleName");
		style = new StyleCategory(styleId, styleName);

		if (stylebiz.updateStyleCategory(style))
			return "updateStyle";

		else
			return "error";
	}

	/**
	 * @return
	 */
	public String queryStyleByStyleId() {
		stylebiz.queryStyleByStyleId(styleId);
		return "queryStyleByStyleId";
	}

	/**
	 * @return 管理员更新全部风格类型信息
	 */
	public String AdminQueryStyleByStyleIdToUpdate() {
		style = stylebiz.queryStyleByStyleId(styleId);

		int update = 3;
		req.setAttribute("update", update);

		return "AdminQueryStyleByStyleIdToUpdate";
	}

	/**
	 * @return 查询全部的风格类别以便管理员更新歌曲信息
	 */
	public String queryAllStyleInfoToUpdate() {
		styleList = stylebiz.queryAllStyleInfo();
		app.setAttribute("styleList", styleList);

		return "queryAllStyleInfoToUpdate";
	}

	/**
	 * @return
	 */
	public String queryAllStyleInfo() {
		List<StyleCategory> styleList = stylebiz.queryAllStyleInfo();
		app.setAttribute("styleList", styleList);

		int a = 3;
		req.setAttribute("a", a);
		return "queryAllStyleInfo";
	}

	// 情感分类

	EmotionCategoryBiz emotionbiz = new EmotionCategoryBizImpl();

	public String addEmotionforword() {
		int add = 4;
		req.setAttribute("add", add);

		return "addEmotionforword";
	}

	/**
	 * @return
	 */
	public String addEmotion() {

		if (emotionbiz.addEmotionCategory(emotion))

			return "addEmotion";

		else
			return "error";
	}

	/**
	 * @return
	 */
	public String deleteEmotion() {
		if (emotionbiz.deleteEmotionCategory(emotionId))
			return "deleteEmotion";

		else
			return "error";
	}

	/**
	 * @return
	 */
	public String updateEmotion() {
		int emotionId = Integer.valueOf(req.getParameter("emotionId"));
		String emotionName = req.getParameter("emotionName");

		emotion = new EmotionCategory(emotionId, emotionName);

		if (emotionbiz.updateEmotionCategory(emotion))

			return "updateEmotion";

		else
			return "error";
	}

	/**
	 * @return
	 * 
	 */
	public String queryemotionByemotionId() {
		emotionbiz.queryemotionByemotionId(emotionId);

		return "queryemotionByemotionId";
	}

	/**
	 * @return 管理员用于更新情感类型信息
	 */
	public String AdminQueryemotionByemotionId() {
		emotion = emotionbiz.queryemotionByemotionId(emotionId);

		int update = 4;
		req.setAttribute("update", update);

		return "AdminQueryemotionByemotionId";
	}

	/**
	 * @return 用于管理员更新歌曲信息
	 */
	public String queryAllemotionInfoToUpdate() {
		emotionList = emotionbiz.queryAllemotionInfo();

		app.setAttribute("emotionList", emotionList);

		int update = 1;
		req.setAttribute("update", update);

		return "queryAllemotionInfoToUpdate";
	}

	/**
	 * @return
	 */
	public String queryAllemotionInfo() {
		List<EmotionCategory> emotionList = emotionbiz.queryAllemotionInfo();

		app.setAttribute("emotionList", emotionList);

		int a = 4;
		req.setAttribute("a", a);

		return "queryAllemotionInfo";
	}

	/**
	 * @return 查询全部的风格类别以便管理员增加歌曲信息
	 */
	public String queryAllStyleInfoToAdd() {
		styleList = stylebiz.queryAllStyleInfo();
		app.setAttribute("styleList", styleList);

		return "queryAllStyleInfoToAdd";
	}

	/**
	 * @return 用于管理员增加歌曲信息
	 */
	public String queryAllemotionInfoToAdd() {
		emotionList = emotionbiz.queryAllemotionInfo();

		app.setAttribute("emotionList", emotionList);

		int add = 1;
		req.setAttribute("add", add);

		return "queryAllemotionInfoToAdd";
	}
}
