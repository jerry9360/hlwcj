package com.centit.hlwyw.task;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.centit.hlwyw.inner.service.HniiBehaviorService;
import com.centit.hlwyw.inner.service.HniiService;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;

@Component("hniitask")
public class HniiTask {

	 
	
	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_service;
	
	@Resource(name = "hniiServiceImpl")
	private HniiService hnii;
	
	@Resource(name = "hniiBehaviorServiceImpl")
	private HniiBehaviorService hniiBehaviorService;
	
	public void initHnii(){
		hnii.deleteAll();
		hniiBehaviorService.deleteAll();
//		行业，大类，小类，总量，来电时间（按天）
		hnii_analyze_service.saveHniiTypeData();
//		行业，总量，来电时间（按天）
		hnii_analyze_service.saveIndustryTypeData();
//		大类，总量，来电时间（按天）
		hnii_analyze_service.saveBtypeTypeData();
		hnii_analyze_service.saveAlarmTypeData();
		hnii_analyze_service.saveAddressTypeData();
		hnii_analyze_service.saveCarnoTypeData();
//		hnii_analyze_service.saveTimeTypeData();
	}
	
	public static void main(String[] args) {
		
	}
}
