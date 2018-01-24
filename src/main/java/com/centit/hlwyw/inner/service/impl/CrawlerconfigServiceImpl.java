package com.centit.hlwyw.inner.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Crawlerconfig;
import com.centit.hlwyw.inner.repositories.CrawlerconfigRepository;
import com.centit.hlwyw.inner.service.CrawlerconfigService;

@Service("crawlerconfigServiceImpl")
public class CrawlerconfigServiceImpl extends BaseServiceImpl<Crawlerconfig, String>
		implements CrawlerconfigService {
	
	@Resource(name = "crawlerconfigRepository")
	private CrawlerconfigRepository repository;
	
	@Resource(name = "crawlerconfigRepository")
	public void setReposity(
			PagingAndSortingRepository<Crawlerconfig, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Crawlerconfig find() {
		List<Crawlerconfig> crawlerconfig=repository.find();
		if(crawlerconfig.size()>0){
			return crawlerconfig.get(0);
		}else{
			return null;
		}
	}
}
