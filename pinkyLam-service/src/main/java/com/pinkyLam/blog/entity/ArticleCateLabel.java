package com.pinkylam.blog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月14日 上午9:58:13
 */

@Entity
@Table(name = "ARTICLE_CATE_LABEL")
public class ArticleCateLabel implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -3243547179173396350L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "ARTICLE_ID")
	private Long articleId;
	@Column(name = "CATE_LABEL_ID")
	private Long cateLabelId;

	public ArticleCateLabel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleCateLabel(Long articleId, Long cateLabelId) {
		super();
		this.articleId = articleId;
		this.cateLabelId = cateLabelId;
	}

	public Long getArticleId() {
		return articleId;
	}

	public Long getCateLabelId() {
		return cateLabelId;
	}

	public Long getId() {
		return id;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public void setCateLabelId(Long cateLabelId) {
		this.cateLabelId = cateLabelId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ArticleCateLabel [id=" + id + ", articleId=" + articleId + ", cateLabelId=" + cateLabelId + "]";
	}


}
