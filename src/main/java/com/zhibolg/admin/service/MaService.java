package com.zhibolg.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhibolg.admin.dao.MaDao;
import com.zhibolg.admin.entity.Ma;
import com.zhibolg.base.DaoBase;
import com.zhibolg.base.ServiceBase;

@Service
public class MaService extends ServiceBase<DaoBase<Ma>, Ma>{
	
	@Autowired
	private MaDao dao;
	
	public Ma getByNameColor(Ma ma) {
		return dao.getByNameColor(ma);
	}

	public void insertMaCount(Ma ma) {
		dao.insertMaCount(ma);
	}
	
}
