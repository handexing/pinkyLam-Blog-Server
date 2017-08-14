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
	 * 评论数量
	 */
	public Integer commentCnt;
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

	public Integer getCommentCnt() {
		return commentCnt;
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

	public void setCommentCnt(Integer commentCnt) {
		this.commentCnt = commentCnt;
	}

	public void setWritingTime(Integer writingTime) {
		this.writingTime = writingTime;
	}

	@Override
	public String toString() {
		return "IndexPanelVo [articleCnt=" + articleCnt + ", attachCnt=" + attachCnt + ", commentCnt=" + commentCnt
				+ ", writingTime=" + writingTime + "]";
	}



}
