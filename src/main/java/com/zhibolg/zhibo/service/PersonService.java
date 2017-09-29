package com.zhibolg.zhibo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhibolg.base.DaoBase;
import com.zhibolg.base.ServiceBase;
import com.zhibolg.zhibo.dao.PersonDao;
import com.zhibolg.zhibo.entity.Person;

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

}
