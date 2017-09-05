package com.zhibolg.base;


import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.zhibolg.zhibo.entity.Page;
import com.zhibolg.zhibo.entity.User;

@Transactional(readOnly = true)
public abstract class EntityBase<T> {
	
	public static final String DEL_FLAG_NORMAL = "0";//0：正常
	public static final String DEL_FLAG_DELETE = "1";//1：删除
	/*
	 * 用于分页
	 */
	private Page<T> page;
	
	/*
	 * 唯一标识ID
	 */
	private String id;
	
	private User createBy;		// 创建者
	private Date createDate;	// 创建日期
	private User updateBy;		// 更新者
	private Date updateDate;	// 更新日期
	private String delFlag; 	// 删除标记（0：正常；1：删除；）

	public EntityBase() {
		this.setDelFlag(DEL_FLAG_NORMAL);
	}
	
	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	
	
}
