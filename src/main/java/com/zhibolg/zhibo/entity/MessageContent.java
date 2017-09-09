package com.zhibolg.zhibo.entity;

import com.zhibolg.base.EntityBase;

/**
* @author 罗广 
* @version 创建时间：2017年9月7日 下午11:17:14
* 类说明
*/
public class MessageContent  extends EntityBase<MessageContent>{
	
	private int gameId; //1、Dota2 2、LOL 3、DNF 4、CSGO 5、炉石传说 6、守望先锋 7、美女秀 8、 主机游戏 9、绝地H1Z1
	private String content; //留言内容
	
	private String targetId; // 回复ID 
	
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public MessageContent() {
		super();
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MessageContent [id="+super.getId()+",gameId=" + gameId + ", content=" + content + ",targetId=" + targetId + ", CreateBy=" + super.getCreateBy() + ", CreateDate=" + super.getCreateDate() + ", UpdateBy=" + super.getUpdateBy() + ", UpdateDate=" +  super.getUpdateDate()  + "]";
	}
	
	
}
