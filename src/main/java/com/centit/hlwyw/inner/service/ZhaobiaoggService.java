package com.centit.hlwyw.inner.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Zhaobiaogg;

public interface ZhaobiaoggService extends BaseService<Zhaobiaogg, String> {

	public Page<Zhaobiaogg> findSearch(String project_name, String zhaobiaore, Pageable pageable);
	
	public Page<Zhaobiaogg> findWash(String project_name, String zhaobiaore, Pageable pageable);
	
	public String findOneMonth(List<String> dateliststr, String dateFrom, String dateNow);

	public List<Object> findDatas(String begindate, String enddate );

	public Page<Zhaobiaogg> findList(String corpname,Pageable pageable);
 
	
	
}
