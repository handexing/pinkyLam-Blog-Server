package com.pinkylam.blog.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pinkylam.blog.utils.CustomDateSerializer;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午5:10:03
 */

@Entity
@Table(name = "ARTICLE")
public class Article implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 5918485060819084203L;

	/**
	 * 草稿
	 */
	public static final Integer ARTICLE_DRAFT = 1;
	/**
	 * 发布
	 */
	public static final Integer ARTICLE_PUBLISH = 2;
	/**
	 * 删除
	 */
	public static final Integer ARTICLE_DELETE = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "SUBTITLE")
	private String subtitle;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "STATUS")
	private Integer status;
	@Column(name = "HITS")
	private Integer hits;
	@Column(name = "AUTHOR_ID")
	private Long authorId;
	@Column(name = "WRITING_TIME")
	private Integer writingTime;
	@Column(name = "CREATE_TIME")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date updateTime;

	@Transient
	private String tag;
	@Transient
	private Long cateId;
	@Transient
	private List<CateLabel> labels;

	public Long getAuthorId() {
		return authorId;
	}

	public Long getCateId() {
		return cateId;
	}

	public String getContent() {
		return content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Integer getHits() {
		return hits;
	}

	public Long getId() {
		return id;
	}

	public List<CateLabel> getLabels() {
		return labels;
	}

	public Integer getStatus() {
		return status;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getTag() {
		return tag;
	}

	public String getTitle() {
		return title;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Integer getWritingTime() {
		return writingTime;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabels(List<CateLabel> labels) {
		this.labels = labels;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setWritingTime(Integer writingTime) {
		this.writingTime = writingTime;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", subtitle=" + subtitle + ", content=" + content
				+ ", status=" + status + ", hits=" + hits + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", tag=" + tag + ", cateId=" + cateId + "]";
	}


}
