package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.User;

/**
 * 处理 多个班级对应一个年级的情况(多对一)
 * @author WE
 *
 */
public class ClazzVM {
	/**
	 * 非外键属性直接映射
	 */
	private Long id;
	private String name;
	private String description;
	/**
	 * 关联属性处理如下
	 * 通过各自的id找到各自所有的信息
	 */
	private Grade grade;
	private User charge;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public User getCharge() {
		return charge;
	}
	public void setCharge(User charge) {
		this.charge = charge;
	}

}
