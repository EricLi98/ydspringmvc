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
		//CurrencyFormatter��ʵ�ֻ�����ʽ�ĸ�ʽ��/����
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2);//����С�����λ
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);//����ģʽ��ceilling��ʾ�������룩
		//1���������ҷ��ŵ��ַ�����$123.125��ת��ΪBigDecimal("123.00")
		BigDecimal b1 = currencyFormatter.parse("$123.125", Locale.US);
		//2����BigDecimal("123")��ʽ��Ϊ�ַ�����$123.00��չʾ
		String s1 = currencyFormatter.print(new BigDecimal("123"), Locale.US);
		String s2 = currencyFormatter.print(new BigDecimal("123"), Locale.CHINA);
		System.out.println("b1="+b1+",s1="+s1+",s2="+s2);


	}

}
