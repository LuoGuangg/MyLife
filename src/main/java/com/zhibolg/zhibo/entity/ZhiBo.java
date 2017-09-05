package com.zhibolg.zhibo.entity;

import java.util.HashMap;
import java.util.Map;

import com.zhibolg.base.EntityBase;

public class ZhiBo extends EntityBase<ZhiBo>{
	private String name;
	private String title;
	private String url;
	private String img;
	private int num;
	private int index;
	private Map<String, String> pageMap = new HashMap<String, String>();
	
	public ZhiBo() {
		super();
	}
	public Map<String, String> getPageMap() {
		return pageMap;
	}

	public void setPageMap(Map<String, String> pageMap) {
		this.pageMap = pageMap;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		return "ZhiBo [id=" + super.getId() + ", name=" + name + ", title=" + title + ", url=" + url + ", img=" + img + ", num="
				+ num + ", index=" + index + "]";
	}
	
	
}
