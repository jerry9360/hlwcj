package com.centit.hlwyw.core.util;

import java.text.NumberFormat;

public class GetPercentUtils {
	
	public Object getPercent(Object num1,Object num2){
		if(Integer.parseInt(num1.toString())==0||Integer.parseInt(num2.toString())==0){
			return "0%";
		}
		Object result = null;
		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(0);
		result = numberFormat.format((float) Integer.parseInt(num1.toString()) / (float) Integer.parseInt(num2.toString()) * 100);
		return result+"%";
	}

	public static void main(String[] args) {
		GetPercentUtils get = new GetPercentUtils();
		Object num = 190;
		Object num2= 0;
		System.out.println(get.getPercent(num,num2));
		
	}
}
