package com.ydspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch41")
public class Ch4Controller1 {
	@RequestMapping(value="/map1",method=RequestMethod.GET)
	public String map1(){
		return "ch41";
	}
	@RequestMapping(value="/map1",method=RequestMethod.POST)
	public String map1(UserBean user,Model model){
		String url="";
		if(user.getPassword().equals("123")&&user.getUserName().equals("admin")){
			url="hello";
		}else{
			model.addAttribute("user",user);
			url="forward:/ch41/loginErr";
		}
		
		return url;
		
	}
	@RequestMapping(value="/loginErr")
	public String map2(){
		return "ch41";
	}
}
