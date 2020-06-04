package com.ydspringmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ydspringmvc.entity.Department;
import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch81")
public class Ch8Controller {
	@RequestMapping(value="/map1",method=RequestMethod.GET)
	public String map1(@ModelAttribute("user") UserBean userBean){
		return "ch81";
	}
	
	@RequestMapping(value="/map1",method=RequestMethod.POST)
	public String map2(@ModelAttribute("user") UserBean userBean){
		if(userBean.getHobbies().size()>=2){
			return "hello";
		}
		return "ch81";
	}
	
	//准备复选框的所有选项
	@ModelAttribute("allHobbies")
	public List<String> getHobbies(){
		ArrayList al=new ArrayList();
		al.add("soccer");
		al.add("tennis");
		al.add("swim");
		return al;
	}
	
	//准备复选框的所有选项
	@ModelAttribute("allDepts")
	public List<Department> getDepts(){
		ArrayList al=new ArrayList();
		
		Department dept=new Department();
		dept.setId("1");
		dept.setName("Sales");
		al.add(dept);
		dept=new Department();
		dept.setId("2");
		dept.setName("HR");
		al.add(dept);
		
		return al;
	}
	
	//准备select的所有选项
	@ModelAttribute("allCountry")
	public Map getCountry(){
		HashMap hm=new HashMap();
		hm.put("cn","China");
		hm.put("jp","Japan");
		return hm;
	}
}
