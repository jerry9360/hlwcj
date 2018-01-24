package com.centit.hlwyw.inner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Crawler;

public interface CrawlerService extends BaseService<Crawler, String> {

	public Page<Crawler> findByName(String name,Pageable pageable);
	
	public void closeAllCrawlers();
}
