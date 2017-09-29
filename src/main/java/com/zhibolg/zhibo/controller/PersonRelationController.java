package com.zhibolg.zhibo.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		return "zhibo/personRelation";
	}
	
}
