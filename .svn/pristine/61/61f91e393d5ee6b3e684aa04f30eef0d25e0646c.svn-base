package com.centit.hlwyw.inner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Order_source;

public interface Order_sourceService extends BaseService<Order_source, String>{
	Page<Order_source> findPage(Pageable pageable);

	Page<Order_source> findSearchname(String webname, Pageable pageable);
	
	public void deleteUrl(String id);
}
