package com.centit.hlwyw.inner.service;

import java.util.List;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hniidata_view;

public interface Hniidata_viewService extends BaseService<Hniidata_view, String> {
	
    public String statByHangye(String hangye);
	
	public String statByDalei(String hangye,String dalei);
	
	public String statByXiaolei(String hangye,String dalei,String xiaolei);
	
	public String statByDaleiOnly(String dalei);
	
	public String statByXiaoleiOnly(String xiaolei);
	
	public List<String> getYears();
	
	public List<Object[]> stat(String infotype);
	
	public String statByName(String infotype,String name,String year);
	
	public List<Object[]> statAll(String infotype);
	
	public List<Object[]> statByYear();

	public void statisticsIndustry();

	public void statDalei();

	public void statXiaolei();
	
	
	
	
}
