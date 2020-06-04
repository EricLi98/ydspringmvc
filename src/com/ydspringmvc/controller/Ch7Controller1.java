package com.ydspringmvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch71")
public class Ch7Controller1 {
	@RequestMapping(value="/map1",method=RequestMethod.GET)
	public String map1(@ModelAttribute("user") UserBean userBean){
		return "ch71";
	}
	@RequestMapping(value="/map1",method=RequestMethod.POST)
	public String map1(@Valid @ModelAttribute("user")  UserBean userBean,BindingResult result,Model model){
		if(result.hasErrors()){
			//model.addAttribute("user",userBean);
			//如果验证有错误，跳转到填报界面，提示错误，让用户重新填写
			//model.addAttribute("error",result.getAllErrors());
		}else{
			return "success";
		}
		return "ch71";
	}
	
	@RequestMapping(value="/map2",method=RequestMethod.GET)
	public String map2(){
		String a=null;
		String[] b={"a","b"};
		int c=0;
		//c=3/c;
		b[2]="c";
		a.equals("1");
		return "ch71";
	}
	
	@ExceptionHandler(value={NullPointerException.class,ArrayIndexOutOfBoundsException.class})
	public ModelAndView exeception(Exception ex){
		ModelAndView mv=new ModelAndView();
		mv.addObject("ex",ex);
		mv.setViewName("error");
		return mv;
	}

}
