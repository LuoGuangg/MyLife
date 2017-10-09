package com.zhibolg.admin.entity;

import com.zhibolg.base.EntityBase;

public class Ma extends EntityBase<Ma>{
	
	private String maType;
	private String maType2;
	private String maWin;
	
	
	public Ma() {
		super();
	}

	public String getMaType() {
		return maType;
	}

	public void setMaType(String maType) {
		this.maType = maType;
	}

	public String getMaType2() {
		return maType2;
	}

	public void setMaType2(String maType2) {
		this.maType2 = maType2;
	}

	public String getMaWin() {
		return maWin;
	}

	public void setMaWin(String maWin) {
		this.maWin = maWin;
	}

	
	
}
