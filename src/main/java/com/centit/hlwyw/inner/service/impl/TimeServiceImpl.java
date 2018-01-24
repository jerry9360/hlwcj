package com.centit.hlwyw.inner.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;


@Service("timeServiceImpl")
public class TimeServiceImpl {
	
	public static String DEFAULT_FORMAT = "yyyy-MM-dd"; 
	
	public  static String[] time = new String[2];
	
	/** 
     * 近一周
     * @param week
     * @return String[] 日期字符串 
     */
	public String[] getWeek(){
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, - 7);
        Date d = calendar.getTime();
        String day = formatDate(d);
        time[0] = day;
        time[1] = formatDate(date); 
		return time;
	}
	
	/** 
     * 近一个月 
     * @param month
     * @return String[] 日期字符串 
     */
	public   String[] getMonth(){
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
        Date d = calendar.getTime();
        String day = formatDate(d);
        time[0] = day;
        time[1] = formatDate(date); 
		return time;
	}
	/** 
     * 今年 
     * @param month
     * @return String[] 日期字符串 
     */
	public   String[] getThisYear(){
		Date date = new Date();
        time[0] = formatDate(getCurrYearFirst());
        time[1] = formatDate(date); 
		return time;
	}
	
	/** 
     * 去年
     * @param month
     * @return String[] 日期字符串 
     */
	public   String[] getLastYear(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		int year = Integer.parseInt(sdf.format(calendar.getTime()));
        time[0] = formatDate(getYearFirst(year));
        time[1] = formatDate(getYearLast(year)); 
		return time;
	}
	
	/** 
     * 格式化日期 
     * @param date 日期对象 
     * @return String 日期字符串 
     */  
    public   String formatDate(Date date){  
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);  
        String sDate = f.format(date);  
        return sDate;  
    }  
      
    /** 
     * 获取今年的第一天 
     * @param year 
     * @return 
     */  
    public   Date getCurrYearFirst(){  
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return getYearFirst(currentYear);  
    }  
      
    /** 
     * 获取今年的最后一天 
     * @param year 
     * @return 
     */  
    public   Date getCurrYearLast(){  
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return getYearLast(currentYear);  
    }
      
    /** 
     * 获取某年第一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public   Date getYearFirst(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
    }  
      
    /** 
     * 获取某年最后一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public   Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
        return currYearLast;  
    }

}
