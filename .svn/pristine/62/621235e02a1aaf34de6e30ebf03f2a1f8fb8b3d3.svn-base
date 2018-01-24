package com.centit.hlwyw.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.centit.hlwyw.inner.service.HniiBehaviorService;
import com.centit.hlwyw.inner.service.Hniidata_viewService;
@Component("cognostask")
public class CognosTask {
	
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource(name = "hniidata_viewServiceImpl")
	private Hniidata_viewService  hniidata_viewService;
    
    @Resource(name = "hniiBehaviorServiceImpl")
	private HniiBehaviorService hniiBehaviorService;
	
    
	public static void main(String[] args) {
		
	}
	
	public void initCognos() {
		System.out.println("开始执行---"+formatter.format(Calendar.getInstance().getTime()));
		hniidata_viewService.statisticsIndustry();
		hniidata_viewService.statDalei();
		hniidata_viewService.statXiaolei();
        System.out.println("结束时间----"+formatter.format(Calendar.getInstance().getTime()));
    
	}
}
