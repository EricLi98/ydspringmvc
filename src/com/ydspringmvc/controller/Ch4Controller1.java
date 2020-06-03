package com.ydspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch41")
//@SessionAttributes定义在Controller类的级别，其中的参数，代表当我们向model中设置数据时，如果数据的名称与本参数一致时，
//MVC会将数据同时保存到Session中
@SessionAttributes("loginUser")
public class Ch4Controller1 {
	@RequestMapping(value="/map1",method=RequestMethod.GET)
	public String map1(){
		return "ch41";
	}
	
	@RequestMapping(value="/map3")
	public String map3(){
		return "success";
	}
	
	@RequestMapping(value="/map1",method=RequestMethod.POST)
	public String map1(UserBean user,Model model){
		String url="";
		if(user.getPassword().equals("123")&&user.getUserName().equals("admin")){
			model.addAttribute("loginUser",user);
			url="redirect:/ch41/map3";//重定向时，使用redirect:，浏览器相当于发送2次请求。
			
		}else{
			//使用forward:进行转发
			//Model中的数据，经过转发，不会丢失
			model.addAttribute("user",user);
			url="forward:/ch41/loginErr";
		}
		
		return url;
		
	}
	@RequestMapping(value="/loginErr")
	public String map2(){
		return "ch41";
	}
	
	@RequestMapping(value="/xmlViewResolver")
	public String map4(UserBean userBean,Model model){
		model.addAttribute("name","/xmlViewResolver");
		return "helloPage";
	}
}
