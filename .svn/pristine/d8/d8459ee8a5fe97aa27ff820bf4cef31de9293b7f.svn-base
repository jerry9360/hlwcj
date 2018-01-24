package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hnii_ask;

public interface Hnii_askService extends BaseService<Hnii_ask, String> {
	
	public Page<Hnii_ask>  findList(String industry,String servicetype,String content,Pageable pageable);

	public List<Object> findStatistics();
}
