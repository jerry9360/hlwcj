package com.centit.hlwyw.inner.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Judgedoc;

public interface JudgeDocService extends BaseService<Judgedoc, String> {

	public Page<Object> findSearch(String corp_name,String industry,Pageable pageable);
	
	public Page<Judgedoc> findWash(String corp_name,String industry,Pageable pageable);
	
	public String findOneMonth(List<String> dateliststr, String dateFrom, String dateNow);
	
	public List<Object[]> stat();

	/**
	 * @return
	 */
	public Object[] statByType();
	
	public List<Object> findDatas(String begindate, String enddate);

	Page<Judgedoc> findList(String corpname, Pageable pageable);

	public List<Object> findDatas();

 
}
