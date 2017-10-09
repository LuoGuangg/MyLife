package com.zhibolg.admin.dao;

import org.springframework.stereotype.Component;

import com.zhibolg.admin.entity.Ma;
import com.zhibolg.base.DaoBase;

@Component
public interface MaDao  extends DaoBase<Ma>{

	Ma getByNameColor(Ma ma);

	void insertMaCount(Ma ma);

}
