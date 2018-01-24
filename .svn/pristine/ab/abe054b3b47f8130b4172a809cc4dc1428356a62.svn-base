package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hnii_complaint;

public interface Hnii_complaintService extends BaseService<Hnii_complaint, String> {
	
	public Page<Hnii_complaint>  findList(String industry,String servicetype,String content,Pageable pageable);

	public Page<Object> findStatistics(Pageable pageable);
	
	public List<Object> findStatistics();

}
