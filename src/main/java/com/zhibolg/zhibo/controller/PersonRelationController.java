package com.zhibolg.zhibo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhibolg.admin.entity.VistIp;
import com.zhibolg.admin.service.VistIpService;
import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.entity.Person;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.service.PersonService;
import com.zhibolg.zhibo.util.UserUtil;

import sun.net.www.content.text.plain;

@Controller
@RequestMapping(value = "person")
public class PersonRelationController extends ControllerBase{
	
	private Log log = LogFactory.getLog(PersonRelationController.class);
	
	@Autowired
	private PersonService personService;

	@ModelAttribute
	public Person get(@RequestParam(required = false) String id) {
		if(id == null) {
			return new Person();
		}
		return personService.get(id);
	}
	
	@RequestMapping(value = "personRelation")
	public String person(Model model) {
		/*
		 * 获取当前用户
		 */
		User user = UserUtil.getUser();
		model.addAttribute("user", user);
		
		Person person = new Person();
		person.setCreateBy(user);
		
		/*
		 * 查询所有人物
		 */
		List<Person> personList =  personService.findListPerson(person);
		model.addAttribute("personList", personList);
		
		/*
		 * 查询人物关系
		 */
		List<Person> personRelationList =  personService.findListPersonRelation(person);
		model.addAttribute("personRelationList", personRelationList);
		
		return "zhibo/person/personRelation";
	}

	/**
	 * @param model
	 * @return 人物管理页面
	 */
	@RequestMapping(value = "personGuanLi")
	public String personGuanLi(Model model) {
		/*
		 * 获取当前用户
		 */
		User user = UserUtil.getUser();
		model.addAttribute("user", user);
		
		Person person = new Person();
		person.setCreateBy(user);
		
		/*
		 * 查询所有人物
		 */
		List<Person> personList =  personService.findListPerson(person);
		model.addAttribute("personList", personList);
		
		return "zhibo/person/personGuanLi";
	}
	
	
	@RequestMapping(value = "personAdd")
	public String personAdd(Model model) {
		/*
		 * 获取当前用户
		 */
		User user = UserUtil.getUser();
		model.addAttribute("user", user);
		
		return "zhibo/person/personAdd";
	}
	
	
	@RequestMapping(value = "personRelationAdd")
	public String personRelationAdd(Person person, Model model) {
		
		model.addAttribute("person", person);
		/*
		 * 获取当前用户
		 */
		User user = UserUtil.getUser();
		model.addAttribute("user", user);
		
		person.setCreateBy(user);
		
		List<Person> RelationList = personService.findRelation(person);
		List<Integer> keyList = new ArrayList<Integer>();
		for(Person p: RelationList) {
			keyList.add(p.getSource());
			keyList.add(p.getTarget());
		}
		log.info(keyList);
		List<Person> personList = personService.findListPersonByRank(keyList);
		log.info(personList);
		 return "";
	}
	
	/**
	 * 验证姓名是否存在
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "yzName")
	@ResponseBody
	public String yzName(@RequestParam("name") String name) {
		Person person =  personService.getByName(name);
		if(person == null) {
			return "true";
		}else {
			return "false";
		}
	}
	
	/**
	 * 保存人物信息
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "personSave")
	public String personSave(Person person) {
		person.setCreateBy(UserUtil.getUser());
		List<Person> personList = personService.findListPerson(person);
		person.setRank(personList.size());
		person.setCategory("1");
		
		personService.insertPerson(person);
		return "redirect:/person/personRelation.html";
	}
	
	
	
}
