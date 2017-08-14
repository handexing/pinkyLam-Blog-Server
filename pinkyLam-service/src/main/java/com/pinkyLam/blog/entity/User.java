package com.pinkylam.blog.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pinkylam.blog.utils.CustomDateSerializer;

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
 * @date 2017年7月10日 上午11:17:15
 */

@Entity
@Table(name = "USER")
public class User implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 5804711413177326374L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NICK")
	private String nick;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PSW")
	private String psw;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "STATUS")
	private Integer status;

	@Column(name = "CREATE_TIME")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNick() {
		return nick;
	}

	public String getPsw() {
		return psw;
	}

	public Integer getStatus() {
		return status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nick=" + nick + ", name=" + name + ", psw=" + psw + ", email=" + email
				+ ", status=" + status + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
