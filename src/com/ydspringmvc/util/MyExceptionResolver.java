package com.ydspringmvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex) {
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("ex",ex);
		if(ex instanceof NullPointerException){
	    //这里就写如何处理,比如:记日志
			System.out.println("now is NullPointer");
			mv.setViewName("nullPage");
		}else if(ex instanceof ArrayIndexOutOfBoundsException){
			//这里就写如何处理,比如:记日志
			mv.setViewName("ArrayIndexOutOfBoundsException");
		}

		
		// TODO Auto-generated method stub
		return mv;
	}

}
