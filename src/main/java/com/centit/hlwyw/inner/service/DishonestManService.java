package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Dishonestman;

public interface DishonestManService extends BaseService<Dishonestman, String> {

	public Page<Dishonestman> findSearch(String corp_name, String source,Pageable pageable);
	
	public Page<Dishonestman> findWash(String corp_name, String source,Pageable pageable);
	
	public String findOneMonth(List<String> dateliststr, String dateFrom, String dateNow);
 
	public List<Object[]> stat();

	public List<Object> findDatas(String begindate, String enddate);

	Page<Dishonestman> findList(String corpname, Pageable pageable);

	public List<Object> findDatas();
	
}
