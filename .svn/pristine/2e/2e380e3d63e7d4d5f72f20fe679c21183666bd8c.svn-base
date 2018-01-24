package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hnii_report;

public interface Hnii_reportService extends BaseService<Hnii_report, String> {
	
	public Page<Hnii_report>  findList(String industry,String servicetype,String content,Pageable pageable);

	public Page<Object> findStatistics(Pageable pageable);
	
	public List<Object> findStatistics();

}
