package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Business_root;

public interface Business_rootService extends BaseService<Business_root, String> {

	Page<Business_root> findById(String industry_id, Pageable pageable);

	int updateByIndustry_id(String industry_id,String industry_name);

	Page<Business_root> findByBusinessName(String busineess_name, Pageable pageable);
	
	public List<Business_root> findListAll();

}
