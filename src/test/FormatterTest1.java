package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import org.junit.Test;
import org.springframework.format.number.CurrencyFormatter;

public class FormatterTest1 {

	@Test
	public void test() throws Exception {
		//CurrencyFormatter：实现货币样式的格式化/解析
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2);//保留小数点后几位
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);//舍入模式（ceilling表示四舍五入）
		//1、将带货币符号的字符串“$123.125”转换为BigDecimal("123.00")
		BigDecimal b1 = currencyFormatter.parse("$123.125", Locale.US);
		//2、将BigDecimal("123")格式化为字符串“$123.00”展示
		String s1 = currencyFormatter.print(new BigDecimal("123"), Locale.US);
		String s2 = currencyFormatter.print(new BigDecimal("123"), Locale.CHINA);
		System.out.println("b1="+b1+",s1="+s1+",s2="+s2);


	}

}
