package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hnii_reflect;

public interface Hnii_reflectService extends BaseService<Hnii_reflect, String> {
	
	public Page<Hnii_reflect>  findList(String industry,String servicetype,String content,Pageable pageable);

	public List<Object> findStatistics();
	
}
