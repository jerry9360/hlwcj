package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Corpmediaexposed;

public interface CorpmediaexposedService extends BaseService<Corpmediaexposed, String> {

	public Page<Corpmediaexposed> findSearch(String corp_name,String industry,Pageable pageable);
	
	public Page<Corpmediaexposed> findWash(String corp_name,String industry,Pageable pageable);
 
	public String findOneMonth(List<String> dateliststr, String dateFrom, String dateNow);
	
	public List<Object[]> stat();
	
}
