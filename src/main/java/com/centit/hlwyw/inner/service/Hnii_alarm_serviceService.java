package com.centit.hlwyw.inner.service;

import java.util.List;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hnii_alarm_service;

public interface Hnii_alarm_serviceService extends BaseService<Hnii_alarm_service, String> {
	
	public List<Object[]> statByYear();
	
	public List<String> getYears();
	
	public String sumByYear(String year);
	
}
