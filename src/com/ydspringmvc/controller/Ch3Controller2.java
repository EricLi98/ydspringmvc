package com.ydspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value="/ch32")
public class Ch3Controller2 {

	@RequestMapping(value="/a",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mapa(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "mapa");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/b",params="create")
	public ModelAndView mapb(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "/b");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/c",params="!create")
	public ModelAndView mapc(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "/c");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/d",params="crud=create")
	public ModelAndView mapd(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "/d");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/e",params={"test","crud=create"})
	public ModelAndView mape(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "/e");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/f",headers="Host")
	public ModelAndView mapf(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "/f");
		mv.setViewName("hello");
		return mv;
	}
}
