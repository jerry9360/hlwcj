package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Corpgood_badinfo;

public interface Corpgood_badinfoService extends BaseService<Corpgood_badinfo, String> {

	public Page<Corpgood_badinfo> findSearch(String corp_name,String type, String source, Pageable pageable);
	
	public Page<Corpgood_badinfo> findWash(String corp_name,String type, String source,Pageable pageable);
 
	public Page<Corpgood_badinfo> findClearSearch(String corp_name,String type,String source,String state,Pageable pageable);
	
	public String findOneMonth(List<String> dateliststr, String dateFrom, String dateNow);
	
	public List<Object[]> stat();
	
}
