package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hnii_suggest;

public interface Hnii_suggestService extends BaseService<Hnii_suggest, String> {
	
	public Page<Hnii_suggest>  findList(String industry,String servicetype,String content,Pageable pageable);

	public List<Object> findStatistics();
}
