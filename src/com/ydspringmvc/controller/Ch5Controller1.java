package com.ydspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch51")
public class Ch5Controller1 {
	@RequestMapping(value="/map1",method=RequestMethod.GET)
	public String map1(){
		return "ch51";
	}
	//�ڹ��� ���������������֮�󣬿������һ��BindingResult������������󶨹����г��ֵĴ���
	@RequestMapping(value="/map1",  method=RequestMethod.POST)
	public String map1(UserBean user, BindingResult bindResult,Model model){
		//���һ�£�BindingResult�еĴ���
		if(bindResult.hasErrors()){
			model.addAttribute("error",bindResult.getAllErrors());
		}
		model.addAttribute("user",user);
		return "success";
	}
}
