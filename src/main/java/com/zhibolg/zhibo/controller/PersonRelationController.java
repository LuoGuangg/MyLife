package com.zhibolg.zhibo.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	/**
	 * 设置中心人物
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "personAddZX")
	public String personAddZX(Person person, Model model) {
		/*
		 * 获取当前用户
		 */
		User user = UserUtil.getUser();
		model.addAttribute("user", user);
		person.setCreateBy(user);
		
		log.info(person);
		personService.personAddZX(person);
		
		return "redirect:/person/personRelation.html";
	}
	
	
	@RequestMapping(value = "personDelete")
	public String personDelete(Person person, Model model) {
		log.info(person);
		/*
		 * 获取当前用户
		 */
		User user = UserUtil.getUser();
		model.addAttribute("user", user);
		person.setCreateBy(user);
		
		personService.personDelete(person);
		
		
		return "redirect:/person/personGuanLi.html";
	}

	/**
	 * 人物关系列表
	 * @param person
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "personRelationList")
	public String personRelationList(Person person, Model model) {
		log.info(person);
		/*
		 * 获取当前用户
		 */
		User user = UserUtil.getUser();
		model.addAttribute("user", user);
		person.setCreateBy(user);
		
		List<Person> personRelationlist = personService.findListPersonRelationXinXi(person);
		model.addAttribute("personRelationlist", personRelationlist);
		log.info(personRelationlist);
		
		return "zhibo/person/personRelationList";
	}
	
	/**
	 * 人物关系添加页面
	 * @param person
	 * @param model
	 * @return
	 */
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
		log.info(RelationList);
		//获得所有关系角色
		List<Integer> keyList = new ArrayList<Integer>();
		for(Person p: RelationList) {
			keyList.add(Integer.parseInt(p.getSource()));
			keyList.add(Integer.parseInt(p.getTarget()));
		}
		log.info(keyList);
		//删除已有关系的角色
		List<Person> personList = personService.findListPerson(person);
		for (int i = personList.size() - 1; i >= 0; i-- ) {
			Person p = personList.get(i);
			log.info(p);
			for (Integer k: keyList) {
				if (p.getRank() == k) {
					personList.remove(p);  
				}
			}
			if (person.getRank() == p.getRank()) {
				personList.remove(p);
			}
		}
		log.info(personList);
		model.addAttribute("personList", personList);
		
		return "zhibo/person/personRelationAdd";
	}

	@RequestMapping(value = "personRelationDelete")
	public String personRelationDelete(@RequestParam("rid") String rid) {
		personService.relationDelete(rid);
		return "redirect:/person/personRelationList.html";
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
	
	/**
	 * 保存人物关系
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "personRelationSave")
	public String personRelationSave(Person person) {
		log.info(person);
		personService.insertPersonRelation(person);
		return "redirect:/person/personRelation.html";
	}
	
	
	
}
