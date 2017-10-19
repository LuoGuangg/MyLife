package com.zhibolg.zhibo.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhibolg.base.DaoBase;
import com.zhibolg.base.ServiceBase;
import com.zhibolg.zhibo.dao.PersonDao;
import com.zhibolg.zhibo.entity.Person;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.util.UserUtil;

@Service
public class PersonService extends ServiceBase<DaoBase<Person>, Person>{
	
	@Autowired
	private PersonDao dao;
	
	public List<Person> findListPerson(Person person) {
		return dao.findListPerson(person);
	}

	public List<Person> findListPersonRelation(Person person) {
		return dao.findListPersonRelation(person);
	}

	public Person getByName(String name) {
		return dao.getByName(name);
	}

	public void insertPerson(Person person) {
		User user = UserUtil.getUser();
		Date d = new Date(System.currentTimeMillis());
		person.setCreateDate(d);
		person.setUpdateDate(d);
		person.setCreateBy(user);
		person.setUpdateBy(user);
		person.setId(UUID.randomUUID().toString().replace("-", ""));
		
		dao.insertPerson(person);
	}

	public List<Person> findRelation(Person person) {
		return dao.findRelation(person);
	}

	public void insertPersonRelation(Person person) {
		
		User user = UserUtil.getUser();
		Date d = new Date(System.currentTimeMillis());
		person.setCreateDate(d);
		person.setUpdateDate(d);
		person.setCreateBy(user);
		person.setUpdateBy(user);
		person.setId(UUID.randomUUID().toString().replace("-", ""));
		
		dao.insertPersonRelation(person);
	}

	public List<Person> findListPersonRelationXinXi(Person person) {
		
		return dao.findListPersonRelationXinXi(person);
	}

	public void relationDelete(Person person) {
		dao.relationDelete(person);
	}

	public void personDelete(Person person) {
		dao.personDelete(person);
		dao.personUpdate(person);
		dao.personRelationSourceUpdate(person);
		dao.personRelationTargetUpdate(person);
	}

	public void personAddZX(Person person) {
		dao.personZXclear(person);
		dao.personAddZX(person);
	}


}
