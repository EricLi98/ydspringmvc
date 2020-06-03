package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.support.DefaultFormattingConversionService;

import com.ydspringmvc.entity.FormatterModel;

public class FormatterTest3 {

	@Test
	public void test() throws Exception{
		//默认自动注册对@NumberFormat和@DateTimeFormat的支持
		DefaultFormattingConversionService conversionService =
		new DefaultFormattingConversionService();
		//准备测试模型对象
		FormatterModel model = new FormatterModel();
		model.setTotalCount(10000);
		model.setDiscount(0.51);
		model.setSumMoney(10000.13);
		model.setRegisterDate(new Date(2013-1900, 4, 1));
		model.setOrderDate(new Date(2013-1900, 4, 1, 20, 18, 18));
		/*
		//得到格式化的注解
		TypeDescriptor descriptor =new TypeDescriptor(FormatterModel.class.getDeclaredField("totalCount"));
		TypeDescriptor stringDescriptor = TypeDescriptor.valueOf(String.class);
		String s1 = (String)conversionService.convert(model.getTotalCount(), descriptor,stringDescriptor);
		int a = (Integer)conversionService.convert("10,000", stringDescriptor, descriptor);
		System.out.println("s1=="+s1+" , a="+a);
		*/
		TypeDescriptor stringDescriptor = TypeDescriptor.valueOf(String.class);
		TypeDescriptor descriptor = new
		TypeDescriptor(FormatterModel.class.getDeclaredField("registerDate"));
		String s1 = (String)conversionService.convert(model.getRegisterDate(), descriptor,stringDescriptor);
		Date d1 = (Date)conversionService.convert("2013-05-01", stringDescriptor, descriptor);
		descriptor = new TypeDescriptor(FormatterModel.class.getDeclaredField("orderDate"));
		String s2 = (String)conversionService.convert(model.getOrderDate(), descriptor,stringDescriptor);
		Date d2 = (Date)conversionService.convert("2013-05-01 20:18:18", stringDescriptor,descriptor);
		System.out.println("s1=="+s1+" , d1="+d1+" , s2="+s2+" , d2="+d2);


	}

}
