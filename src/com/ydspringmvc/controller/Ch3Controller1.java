package com.ydspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ch3Controller1 {
	
	@RequestMapping(value="/ch31a")
	public ModelAndView mapa(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","/ch31a");
		mv.setViewName("hello");
		return mv;
	}
}
