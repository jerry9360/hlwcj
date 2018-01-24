package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Service_complaint;

public interface Service_complaintService extends BaseService<Service_complaint, String> {
	
	public Page<Service_complaint> findList(String corp_name,String vehicle_no,Pageable pageable);
	
	public Page<Service_complaint> findWash(String corp_name,String vehicle_no,Pageable pageable);
	
	public List<Object[]> stat();

	public List<Object> findDatas(String begindate, String enddate);

	public Page<Service_complaint> findList(String corpname, Pageable pageable);

	public List<Object> findDatas();

}
