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

	/*
	 * 按照姓名查找人物
	 */
	Person getByName(String name);

	/*
	 * 插入人物信息
	 */
	void insertPerson(Person person);

	/*
	 * 获得此人物的关系列表
	 */
	List<Person> findRelation(Person person);

	/*
	 * 排除以及有关系的人物，获得其他人物
	 */
	List<Person> findListPersonByRank(List<Integer> keyList);

}
