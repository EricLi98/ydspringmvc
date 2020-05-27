package com.ydspringmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	//Controller的功能处理方法可以带很多类型的参数，在定义时，根据需求来使用（类似于自助式的方式）。
	public ModelAndView mapb(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		//获取表单的数据
		String userName=request.getParameter("userName");
		mv.addObject("name", userName);
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/reqbak1",method=RequestMethod.POST)
	//数据绑定的演示：Controller的功能处理方法可以带命令（表单）对象，框架自动进行数据的绑定。
	public ModelAndView mapc(UserBean userBean){
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("name", userBean.getUserName());
		mv.setViewName("hello");
		return mv;
	}
	
	//功能场景：对注册信息进行校验，有问题话，返回填写界面（保留原有填写的信息，表单回显）；否则跳转到success界面
	@RequestMapping(value="/reqBak2",method=RequestMethod.POST)
	public ModelAndView mapd(UserBean userBean){
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",userBean);
		if(userBean.getUserName()!=null&&userBean.getUserName().length()>=6){
			mv.setViewName("success");
		}else{
			mv.setViewName("reg");
			
			mv.addObject("error","用户名长度必须大于6");
		}
		return mv;
	}
	
	//功能 方法的返回值可以是字符串，它代表视图的名称；在参数中，可以增加Model类型的参数，它的作用是向视图传递数据；这样替代了原有的ModelAndView。
	@RequestMapping(value="/req",method=RequestMethod.POST)
	public String mape(UserBean userBean,Model model){
		String view="reg";
		model.addAttribute("user",userBean);
		if(userBean.getUserName()!=null&&userBean.getUserName().length()>=6){
			view="success";
		}else{
			//向model中添加数据
			model.addAttribute("error", "用户名长度必须大于6");
		}
		return view;
	}
	
	//使用RequestParam注解将请求中特定的某个参数绑定到变量中
	@RequestMapping(value="/mapf")
	public String mapf(@RequestParam(value="p1",required=true)String abc,Model model){
		String view="hello";
		model.addAttribute("name",abc);
		
		return view;
	}
	
	//使用RequestParam注解将请求中特定的某个参数绑定到变量中
	//对于多个同名的参数，可以绑定到String[]
	@RequestMapping(value="/mape")
	public String mape(@RequestParam(value="p1")String[] abc,Model model){
		String view="hello";
		model.addAttribute("name",abc.length+"[0]:"+abc[0]);
		
		return view;
	}
	
	//使用RequestParam注解将请求中特定的某个参数绑定到变量中
		//对于多个同名的参数，可以绑定到ArrayList
		@RequestMapping(value="/mapg")
		public String mapg(@RequestParam(value="p1")ArrayList<String> abc,Model model){
			String view="hello";
			model.addAttribute("name",abc);
			
			return view;
		}
	

}
