package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Public_prise;

public interface Public_priseService extends BaseService<Public_prise, String> {
	
	public Page<Public_prise> findList(String corp_name,String accept_num,Pageable pageable);
	
	public Page<Public_prise> findWash(String corp_name,String accept_num,Pageable pageable);
	
	public List<Object[]> stat();

	public List<Object> findDatas(String begindate, String enddate);

	public Page<Public_prise> findList(String corpname, Pageable pageable);

	public List<Object> findDatas();

}
