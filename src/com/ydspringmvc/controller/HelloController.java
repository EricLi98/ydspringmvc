package com.ydspringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ydspringmvc.service.TestBean;


public class HelloController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		//从父容器中获取业务bean，调用它的方法
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(arg0.getSession().getServletContext());//ServeltContext 
		TestBean tb=(TestBean)ac.getBean("testBean");
		// TODO Auto-generated method stub
		//返回值ModelAndView,携带了业务处理的结果，同时也包含了下一步跳转的页面
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", tb.getName());//设置的数据
		mv.setViewName("hello");//设置使用哪个JSP进行展示
		return mv;
		
		
	}

}
