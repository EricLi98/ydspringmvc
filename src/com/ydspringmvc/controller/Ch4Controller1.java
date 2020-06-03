package com.ydspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch41")
//@SessionAttributes������Controller��ļ������еĲ���������������model����������ʱ��������ݵ������뱾����һ��ʱ��
//MVC�Ὣ����ͬʱ���浽Session��
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
			url="redirect:/ch41/map3";//�ض���ʱ��ʹ��redirect:��������൱�ڷ���2������
			
		}else{
			//ʹ��forward:����ת��
			//Model�е����ݣ�����ת�������ᶪʧ
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
