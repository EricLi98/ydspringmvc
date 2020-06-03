package com.ydspringmvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ydspringmvc.entity.FormatterModel;
import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch61")
public class Ch6Controller1 {
	@RequestMapping(value="/map1",method=RequestMethod.GET)
	public String map1(Model model2){
		UserBean user=new UserBean();
		FormatterModel model=new FormatterModel();
		model.setTotalCount(10000);
		model.setDiscount(0.51);
		model.setSumMoney(10000.13);
		model.setRegisterDate(new Date(2013-1900, 4, 1));
		model.setOrderDate(new Date(2013-1900, 4, 1, 20, 18, 18));
		user.setFm(model);
		
		model2.addAttribute("user",user);
		return "ch61";
	}
	
}
