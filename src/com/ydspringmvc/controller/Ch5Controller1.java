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
	//在功能 处理方法的命令对象之后，可以添加一个BindingResult对象，它来保存绑定过程中出现的错误
	@RequestMapping(value="/map1",  method=RequestMethod.POST)
	public String map1(UserBean user, BindingResult bindResult,Model model){
		//检测一下，BindingResult中的错误
		if(bindResult.hasErrors()){
			model.addAttribute("error",bindResult.getAllErrors());
		}
		model.addAttribute("user",user);
		return "success";
	}
}
