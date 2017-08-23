package com.pinkylam.blog.entity;

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
 * @date 2017年8月8日 下午1:38:09
 */
@Entity
@Table(name = "MEMO_REMIND")
public class MemoRemind implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -7213787022886568071L;
	
	/**
	 * 默认
	 */
	public static final Integer MEMOREMIND_DEFAULT_STATUS = 0;
	/**
	 * 关闭
	 */
	public static final Integer MEMOREMIND_CLOSE_STATUS = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "AUTHOR_ID")
	private Long authorId;
	@Column(name = "REMIND_DESCRIBE")
	private String describe;
	@Column(name = "REMIND_TIME")
	private String remindTime;
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@Column(name = "STATUS")
	private Integer status;

	public MemoRemind() {
		super();
	}

	public MemoRemind(Long id, Long authorId, String describe, String remindTime, Date createTime) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.describe = describe;
		this.remindTime = remindTime;
		this.createTime = createTime;
	}


	public Long getAuthorId() {
		return authorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String getDescribe() {
		return describe;
	}

	public Long getId() {
		return id;
	}

	public String getRemindTime() {
		return remindTime;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemoRemind [id=" + id + ", authorId=" + authorId + ", describe=" + describe + ", remindTime="
				+ remindTime + ", createTime=" + createTime + "]";
	}


}
