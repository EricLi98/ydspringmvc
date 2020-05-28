package com.ydspringmvc.controller;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ydspringmvc.entity.Department;
import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch33")
public class Ch3Controller3 {
	
	@RequestMapping(value="/req",method=RequestMethod.GET)
	public ModelAndView mapa(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("reg");
		return mv;
	}
	
	@RequestMapping(value="/reqbak",method=RequestMethod.POST)
	//Controller�Ĺ��ܴ��������Դ��ܶ����͵Ĳ������ڶ���ʱ������������ʹ�ã�����������ʽ�ķ�ʽ����
	public ModelAndView mapb(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		//��ȡ��������
		String userName=request.getParameter("userName");
		mv.addObject("name", userName);
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/reqbak1",method=RequestMethod.POST)
	//���ݰ󶨵���ʾ��Controller�Ĺ��ܴ��������Դ�����������󣬿���Զ��������ݵİ󶨡�
	public ModelAndView mapc(UserBean userBean){
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("name", userBean.getUserName());
		mv.setViewName("hello");
		return mv;
	}
	
	//���ܳ�������ע����Ϣ����У�飬�����⻰��������д���棨����ԭ����д����Ϣ�������ԣ���������ת��success����
	@RequestMapping(value="/reqBak2",method=RequestMethod.POST)
	public ModelAndView mapd(UserBean userBean){
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",userBean);
		if(userBean.getUserName()!=null&&userBean.getUserName().length()>=6){
			mv.setViewName("success");
		}else{
			mv.setViewName("reg");
			
			mv.addObject("error","�û������ȱ������6");
		}
		return mv;
	}
	
	//���� �����ķ���ֵ�������ַ�������������ͼ�����ƣ��ڲ����У���������Model���͵Ĳ�������������������ͼ�������ݣ����������ԭ�е�ModelAndView��
	@RequestMapping(value="/req",method=RequestMethod.POST)
	public String mape(UserBean userBean,Model model){
		String view="reg";
		model.addAttribute("user",userBean);
		if(userBean.getUserName()!=null&&userBean.getUserName().length()>=6){
			view="success";
		}else{
			//��model���������
			model.addAttribute("error", "�û������ȱ������6");
		}
		return view;
	}
	
	//ʹ��RequestParamע�⽫�������ض���ĳ�������󶨵�������
	@RequestMapping(value="/mapf")
	public String mapf(@RequestParam(value="p1",required=true)String abc,Model model){
		String view="hello";
		model.addAttribute("name",abc);
		
		return view;
	}
	
	//ʹ��RequestParamע�⽫�������ض���ĳ�������󶨵�������
	//���ڶ��ͬ���Ĳ��������԰󶨵�String[]
	@RequestMapping(value="/mape")
	public String mape(@RequestParam(value="p1")String[] abc,Model model){
		String view="hello";
		model.addAttribute("name",abc.length+"[0]:"+abc[0]);
		
		return view;
	}
	
	//ʹ��RequestParamע�⽫�������ض���ĳ�������󶨵�������
		//���ڶ��ͬ���Ĳ��������԰󶨵�ArrayList
		@RequestMapping(value="/mapg")
		public String mapg(@RequestParam(value="p1")ArrayList<String> abc,Model model){
			String view="hello";
			model.addAttribute("name",abc);
			
			return view;
		}
	@RequestMapping(value="/maph")
	public void maph(HttpServletResponse response) throws Exception{
		Writer out=response.getWriter();
		out.write("/maph");
		
	}
	
	@RequestMapping(value="/mapi",method=RequestMethod.POST)
	public String mapi(@ModelAttribute("user")UserBean userBean) {
		
		return "success";
	}
	
	@RequestMapping(value="/mapi",method=RequestMethod.GET)
	public String mapi() {
		
		return "mapi";
	}
	
	//�ڹ��ܷ���ִ��֮ǰ��controller����ִ�д���@ModelAttributeע��ķ��������䷵��ֵ����Model�У���view��ʹ��
	@ModelAttribute("province")
	public List<String> getProvince(){
		ArrayList<String> arr=new ArrayList();
		arr.add("shandong");
		arr.add("henan");
		return arr;
	}
	//@Value���Ը��������и�ֵ����������ͨ���ַ�����Ҳ����ִ��SPEL
	@RequestMapping(value="/mapj",method=RequestMethod.GET)
	public String mapj(@Value("abc")String name,Model model){
		model.addAttribute("name",name);
		return "hello";
	}
	
	//@Value���Ը��������и�ֵ����������ͨ���ַ�����Ҳ����ִ��SPEL(���ڡ�#{}��֮��)
	@RequestMapping(value="/mapk",method=RequestMethod.GET)
	public String mapk(@Value("#{testBean.name}")String name,Model model){
		model.addAttribute("name",name);
		return "hello";
	}
	
	
	@RequestMapping(value="/mapm",method=RequestMethod.GET)
	public String mapm(){
		return "mapm";
	}
	@RequestMapping(value="/mapm",method=RequestMethod.POST)
	public String mapm(@ModelAttribute("user")UserBean userBean,@ModelAttribute("dept")Department dept){
		return "hello";
	}
	//@InitBinderע��ķ������ڹ��ܴ������İ�֮ǰ���е���
	@InitBinder(value="user")
	public void initBinderUser(WebDataBinder binder){
		binder.setFieldDefaultPrefix("u.");
	}
	//@InitBinderע��ķ������ڹ��ܴ������İ�֮ǰ���е���
	@InitBinder(value="dept")
	public void initBinderDept(WebDataBinder binder){
		binder.setFieldDefaultPrefix("d.");
	}
}
