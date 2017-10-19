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
	 * 插入角色之间的关系
	 */
	void insertPersonRelation(Person person);

	/*
	 * 查询关系列表的信息
	 */
	List<Person> findListPersonRelationXinXi(Person person);

	/*
	 * 删除关系
	 */
	void relationDelete(Person person);

	/*
	 * 删除角色
	 */
	void personDelete(Person person);
	/*
	 * 删除角色后修改rank
	 */
	void personUpdate(Person person);
	/*
	 * 删除角色后修改source
	 */
	void personRelationSourceUpdate(Person person);
	/*
	 * 删除角色后修改target
	 */
	void personRelationTargetUpdate(Person person);

	/*
	 * 清除所有中心人物
	 */
	void personZXclear(Person person);
	
	/*
	 * 设置中心人物
	 */
	void personAddZX(Person person);


}
