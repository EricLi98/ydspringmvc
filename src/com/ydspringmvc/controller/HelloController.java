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
		
		//�Ӹ������л�ȡҵ��bean���������ķ���
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(arg0.getSession().getServletContext());//ServeltContext 
		TestBean tb=(TestBean)ac.getBean("testBean");
		// TODO Auto-generated method stub
		//����ֵModelAndView,Я����ҵ����Ľ����ͬʱҲ��������һ����ת��ҳ��
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", tb.getName());//���õ�����
		mv.setViewName("hello");//����ʹ���ĸ�JSP����չʾ
		return mv;
		
		
	}

}
