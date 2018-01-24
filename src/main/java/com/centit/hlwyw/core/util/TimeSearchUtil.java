package com.centit.hlwyw.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.centit.hlwyw.inner.controller.Corpgood_badinfoController;


public class TimeSearchUtil {
	private static Logger log = Logger.getLogger(TimeSearchUtil.class);  

	public static String DEFAULT_FORMAT = "yyyy-MM-dd"; 
	
	public  static Date[] time = new Date[2];
	
	/** 
     * 近一周
     * @param week
     * @return String[] 日期字符串 
	 * @throws ParseException 
     */
	public static Date[] getWeek() {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, - 7);
        Date d = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String t1=sdf.format(d) ;
        String t2=sdf.format(date) ;
        try {
			time[0] = sdf.parse(t1);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
        try {
			time[1] = sdf.parse(t2);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return time;
	}
	
	/** 
     * 近一个月 
     * @param month
     * @return String[] 日期字符串 
     */
	public static  Date[] getMonth(){
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
        Date d = calendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String t1=sdf.format(d) ;
        String t2=sdf.format(date) ;
        try {
			time[0] = sdf.parse(t1);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
        try {
			time[1] = sdf.parse(t2);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return time;
	}
	/** 
     * 今年 
     * @param month
     * @return String[] 日期字符串 
     */
	public static  Date[] getThisYear(){
		Date date = new Date();
        Date d= getCurrYearFirst();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String t1=sdf.format(d) ;
        String t2=sdf.format(date) ;
        try {
			time[0] = sdf.parse(t1);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
        try {
			time[1] = sdf.parse(t2);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return time;
	}
	
	/** 
     * 去年
     * @param month
     * @return String[] 日期字符串 
     */
	public  static Date[] getLastYear(){
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		int year = Integer.parseInt(sdff.format(calendar.getTime()));
		Date d= getYearFirst(year); 
		Date date = getYearLast(year) ;
        
        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String t1=sdf.format(d) ;
        String t2=sdf.format(date) ;
        try {
			time[0] = sdf.parse(t1);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
        try {
			time[1] = sdf.parse(t2);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return time;
	}
	
	/** 
     * 格式化日期 
     * @param date 日期对象 
     * @return String 日期字符串 
     */  
    public static  String formatDate(Date date){  
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);  
        String sDate = f.format(date);  
        return sDate;  
    }  
      
    /** 
     * 获取今年的第一天 
     * @param year 
     * @return 
     */  
    public static  Date getCurrYearFirst(){  
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
    public  static Date getYearFirst(int year){  
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
    public  static Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
        return currYearLast;  
    }
    
    
    
    public static List<String> getSubTimeGroupByDateMonthYear(String type,Date begindate, Date enddate){
		List<String> subTimelist=new ArrayList<String>();
		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(begindate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(enddate); 
		if("day".equals(type)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			while(beginCalendar.compareTo(endCalendar)<1){//beginCalendar比endCalendar早,返回-1,相同,返回0,晚,返回1
				String datestr = sdf.format(beginCalendar.getTime());
				subTimelist.add(datestr);
				beginCalendar.add(Calendar.DATE, 1);
			}
 		}else if("month".equals(type)){
 	  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
 	  		while(beginCalendar.compareTo(endCalendar)<1){//beginCalendar比endCalendar早,返回-1,相同,返回0,晚,返回1
 	  			String datestr = sdf.format(beginCalendar.getTime());
 	  			subTimelist.add(datestr);
 	  			beginCalendar.add(Calendar.MONTH, 1);
 	  		}
 			
 		}else if("year".equals(type)){
 	  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
 	  		while(beginCalendar.compareTo(endCalendar)<1){//beginCalendar比endCalendar早,返回-1,相同,返回0,晚,返回1
 	  			String datestr = sdf.format(beginCalendar.getTime());
 	  			subTimelist.add(datestr);
 	  			beginCalendar.add(Calendar.YEAR, 1);
 	  		}
 		}
		
		return subTimelist;
	}

    

}
