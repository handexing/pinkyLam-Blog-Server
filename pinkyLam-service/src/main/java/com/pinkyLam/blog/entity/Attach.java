package com.pinkyLam.blog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月22日 下午2:48:04
 */
@Entity
@Table(name = "ATTACH")
public class Attach implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 6945843175557149622L;

	/**
	 * 图片
	 */
	public static final String UPLOAD_TYPE_IMAGE = "image";
	/**
	 * 文件
	 */
	public static final String UPLOAD_TYPE_FILE = "file";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "AUTHOR_ID")
	private Long authorId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "URL")
	private String url;
	@Column(name = "CREATE_TIME")
	private Date createTime;

	public Attach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attach(Long authorId, String name, String type, String url, Date createTime) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.type = type;
		this.url = url;
		this.createTime = createTime;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Attach [id=" + id + ", authorId=" + authorId + ", name=" + name + ", type=" + type + ", url=" + url
				+ ", createTime=" + createTime + "]";
	}


}
