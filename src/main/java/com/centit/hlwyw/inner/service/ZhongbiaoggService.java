package com.centit.hlwyw.inner.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Zhongbiaogg;

public interface ZhongbiaoggService extends BaseService<Zhongbiaogg, String> {

	public Page<Zhongbiaogg> findSearch(String project_name, String zhaobiaore, Pageable pageable);
	
	public Page<Zhongbiaogg> findWash(String project_name, String zhaobiaore, Pageable pageable);
	
	public String findOneMonth(List<String> dateliststr, String dateFrom, String dateNow);

	public List<Object> findDatas(String begindate, String enddate);

	Page<Zhongbiaogg> findList(String corpname, Pageable pageable);

	
}
