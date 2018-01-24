package com.centit.hlwyw.inner.timetask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

import com.centit.hlwyw.inner.controller.Datastatistics;
 
 
public class NFDFlightDataTimerTask extends TimerTask {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void run() {
    	System.out.println("开始执行---"+formatter.format(Calendar.getInstance().getTime()));
//    	Datastatistics.statisticsIndustry();
//    	Datastatistics.statDalei();
//    	Datastatistics.statXiaolei();
        System.out.println("执行当前时间"+formatter.format(Calendar.getInstance().getTime()));
    }
     
}