package com.pinkylam.blog.vo;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年8月1日 上午11:23:35
 * @see 首页面板展示信息
 */
public class IndexPanelVo {

	/**
	 * 文章数量
	 */
	public Integer articleCnt;
	/**
	 * 附件数量
	 */
	public Integer attachCnt;
	/**
	 * 备忘录数量
	 */
	public Integer remindCnt;
	/**
	 * 写作时间
	 */
	public Integer writingTime;

	public Integer getArticleCnt() {
		return articleCnt;
	}

	public Integer getAttachCnt() {
		return attachCnt;
	}


	public Integer getWritingTime() {
		return writingTime;
	}

	public void setArticleCnt(Integer articleCnt) {
		this.articleCnt = articleCnt;
	}

	public void setAttachCnt(Integer attachCnt) {
		this.attachCnt = attachCnt;
	}


	public void setWritingTime(Integer writingTime) {
		this.writingTime = writingTime;
	}

	public Integer getRemindCnt() {
		return remindCnt;
	}

	public void setRemindCnt(Integer remindCnt) {
		this.remindCnt = remindCnt;
	}

	@Override
	public String toString() {
		return "IndexPanelVo [articleCnt=" + articleCnt + ", attachCnt=" + attachCnt + ", remindCnt=" + remindCnt
				+ ", writingTime=" + writingTime + "]";
	}




}
