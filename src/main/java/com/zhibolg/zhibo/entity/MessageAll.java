package com.zhibolg.zhibo.entity;

import java.sql.Date;

import com.zhibolg.base.EntityBase;

/**
* @author 罗广 
* @version 创建时间：2017年9月8日 下午8:19:18
* 类说明
*/
public class MessageAll  extends EntityBase<MessageAll>{
	
	private String contentId;//留言ID
	private String targetId;//目标ID
	
	private String userName;//留言的用户名
	private String content;//留言的内容
	private Date contentDate;//留言时间
	
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getContentDate() {
		return contentDate;
	}
	public void setContentDate(Date contentDate) {
		this.contentDate = contentDate;
	}
	
	@Override
	public String toString() {
		return "MessageAll [contentId=" + contentId + ", targetId=" + targetId + ", userName=" + userName + ", content="
				+ content + ", contentDate=" + contentDate + "]";
	}
	
	
}
