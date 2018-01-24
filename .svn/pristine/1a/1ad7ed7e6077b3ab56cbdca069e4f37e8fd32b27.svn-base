package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Business_secondary;

public interface Business_secondaryService extends BaseService<Business_secondary, String> {


	Page<Business_secondary> findByRoot_id(String root_id, Pageable pageable);

	List<Business_secondary> findAllDelete(String root_id);

	int updateByIndustry_id(String root_id, String business_name);
	
	Page<Business_secondary> findByIndustry(String industry, Pageable pageable);

	public List<Business_secondary> findByRootid(String root_id);

}
