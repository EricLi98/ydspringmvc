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
		//默认不自动注册任何Formatter
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2);//保留小数点后几位
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);//舍入模式（ceilling表示四舍五入）
		//注册Formatter SPI实现
		conversionService.addFormatter(currencyFormatter);
		//绑定Locale信息到ThreadLocal
		//FormattingConversionService内部自动获取作为Locale信息，如果不设值默认是Locale.getDefault()
		LocaleContextHolder.setLocale(Locale.US);
		String s1 = conversionService.convert(new BigDecimal("1234.128"), String.class);
		LocaleContextHolder.setLocale(null);
		LocaleContextHolder.setLocale(Locale.CHINA);
		String s2 = conversionService.convert(new BigDecimal("1234.128"), String.class);
		BigDecimal b1 = conversionService.convert("￥1,234.13", BigDecimal.class);
		LocaleContextHolder.setLocale(null);
		System.out.println("s1="+s1+",s2="+s2+",b1="+b1);


	}

}
