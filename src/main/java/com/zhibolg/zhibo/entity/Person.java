package com.zhibolg.zhibo.entity;

import com.zhibolg.base.EntityBase;

public class Person extends EntityBase<Person>{
	
	/*
	 * 人物
	 */
	private int rank;//用于关联关系
	private String name;//姓名
	private String category;//颜色
	private int age;//年龄
	private String sex;//性别
	private String phone;//电话
	private String qq;//QQ
	
	/*
	 * 人物关系
	 */
	private int source;//来源
	private int target;//目标
	private String relation;//关系
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
