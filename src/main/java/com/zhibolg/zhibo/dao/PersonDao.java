package com.zhibolg.zhibo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zhibolg.base.DaoBase;
import com.zhibolg.zhibo.entity.Person;

@Component
public interface PersonDao extends DaoBase<Person>{
	
	/*
	 * 查询所有人物
	 */
	List<Person> findListPerson(Person person);

	/*
	 * 查询所有人物关系
	 */
	List<Person> findListPersonRelation(Person person);

}
