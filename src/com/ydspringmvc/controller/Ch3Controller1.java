package com.ydspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/ch31")
public class Ch3Controller1 {
	
	@RequestMapping(value="/a")
	public ModelAndView mapa(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","/ch31a");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value={"/b","/b/a"})
	public ModelAndView mapb(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","/ch31b");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/c/{id}/abc/{stuId}")
	public ModelAndView mapc(@PathVariable(value="id") String userId,@PathVariable(value="stuId") String stuId){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","/ch31c:"+userId+",stuId:"+stuId);
		mv.setViewName("hello");
		return mv;
	}
	//?代表只能有一个字符
	@RequestMapping(value="/d?")
	public ModelAndView mapd(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","/ch31d");
		mv.setViewName("hello");
		return mv;
	}
	//*代表0个或多个字符
	@RequestMapping(value="/e*")
	public ModelAndView mape(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","/ch31e");
		mv.setViewName("hello");
		return mv;
	}
	//“/**”实现多个级别路径的映射
	@RequestMapping(value="/f/**")//ch3/f/a/b
	public ModelAndView mapf(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","/ch31f");
		mv.setViewName("hello");
		return mv;
	}
	
}
