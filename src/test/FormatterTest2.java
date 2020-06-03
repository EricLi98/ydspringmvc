package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.number.CurrencyFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormatterTest2 {

	@Test
	public void test() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		//Ĭ�ϲ��Զ�ע���κ�Formatter
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2);//����С�����λ
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);//����ģʽ��ceilling��ʾ�������룩
		//ע��Formatter SPIʵ��
		conversionService.addFormatter(currencyFormatter);
		//��Locale��Ϣ��ThreadLocal
		//FormattingConversionService�ڲ��Զ���ȡ��ΪLocale��Ϣ���������ֵĬ����Locale.getDefault()
		LocaleContextHolder.setLocale(Locale.US);
		String s1 = conversionService.convert(new BigDecimal("1234.128"), String.class);
		LocaleContextHolder.setLocale(null);
		LocaleContextHolder.setLocale(Locale.CHINA);
		String s2 = conversionService.convert(new BigDecimal("1234.128"), String.class);
		BigDecimal b1 = conversionService.convert("��1,234.13", BigDecimal.class);
		LocaleContextHolder.setLocale(null);
		System.out.println("s1="+s1+",s2="+s2+",b1="+b1);


	}

}
