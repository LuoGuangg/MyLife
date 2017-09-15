package com.zhibolg.zhibo.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zhibolg.base.EntityBase;

/**
* @author 罗广 
* @version 创建时间：2017年9月8日 下午8:19:18
* 类说明
*/
public class MessageAll  extends EntityBase<MessageAll> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String contentId;//留言ID
	private String targetId;//目标ID
	
	private String userName;//留言的用户名
	private String content;//留言的内容
	private Date contentDate;//留言时间
	private String contentDateString; //格式后时间

	private Map<String, String> pageMap = new HashMap<String, String>();
	
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
	
	public String getContentDateString() {
		return contentDateString;
	}
	public void setContentDateString(String contentDateString) {
		this.contentDateString = contentDateString;
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
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.contentDateString = dateFormater.format(contentDate);
		this.contentDate = contentDate;
	}
	
	public Map<String, String> getPageMap() {
		return pageMap;
	}
	public void setPageMap(Map<String, String> pageMap) {
		this.pageMap = pageMap;
	}
	@Override
	public String toString() {
		return "MessageAll [contentId=" + contentId + ", targetId=" + targetId + ", userName=" + userName + ", content="
				+ content + ", contentDate=" + contentDate + "]";
	}
	
	
}
