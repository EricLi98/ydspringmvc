package com.ydspringmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor1 extends HandlerInterceptorAdapter {
	private NamedThreadLocal<Long> startTimeThreadLocal =new NamedThreadLocal<Long>("StopWatch-StartTime");

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	   long endTime = System.currentTimeMillis();//2������ʱ��
	   long beginTime = startTimeThreadLocal.get();
	   //�õ��̰߳󶨵ľֲ���������ʼʱ�䣩
	   long consumeTime = endTime - beginTime;//3�����ĵ�ʱ��
	   System.out.println(String.format("%s consume %d millis", request.getRequestURI(), consumeTime));

		// TODO Auto-generated method stub
		System.out.println("--afterCompletion1--");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--postHandle1--");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	     long beginTime = System.currentTimeMillis();
	     //1����ʼʱ��
	     startTimeThreadLocal.set(beginTime);

		// TODO Auto-generated method stub
		System.out.println("--preHandle1--");
		return true;
	}

}
