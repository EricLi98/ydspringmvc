package com.ydspringmvc.util;

import org.springframework.core.convert.converter.Converter;

import com.ydspringmvc.entity.Tel;

public class TelConverter implements Converter<String, Tel> {

	public Tel convert(String arg0) {
		Tel tel=null;
		if(arg0!=null){
			tel=new Tel();
			tel.setArea(arg0.split("-")[0]);
			tel.setCode(arg0.split("-")[1]);
		}
		
		return tel;
	}

}
