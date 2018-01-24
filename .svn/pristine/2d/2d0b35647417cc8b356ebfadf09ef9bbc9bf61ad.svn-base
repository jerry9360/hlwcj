package com.centit.hlwyw.inner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.UrlSource;

public interface UrlSourceService extends BaseService<UrlSource, String>{
	Page<UrlSource> findPage(Pageable pageable);

	Page<UrlSource> findSearchname(String webname, Pageable pageable);
	
	public void deleteUrl(String id);
}
