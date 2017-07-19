package com.pinkyLam.blog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午2:44:03
 */

@Entity
@Table(name = "CATE_LABEL")
public class CateLabel implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 4054187413973378444L;

	/**
	 * 类别
	 */
	public static final Integer CATEGORY_TYPE = 1;
	/**
	 * 标签
	 */
	public static final Integer LABEL_TYPE = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private Integer type;
	@Column(name = "REMARK")
	private String remark;

	public CateLabel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CateLabel(String name, Integer type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getRemark() {
		return remark;
	}

	public Integer getType() {
		return type;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CateLabel [id=" + id + ", name=" + name + ", type=" + type + ", remark=" + remark + "]";
	}


}
