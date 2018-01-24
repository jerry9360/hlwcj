package com.centit.hlwyw.inner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Crawler;
import com.centit.hlwyw.inner.repositories.CrawlerRepository;
import com.centit.hlwyw.inner.service.CrawlerService;

@Service("crawlerServiceImpl")
public class CrawlerServiceImpl extends BaseServiceImpl<Crawler, String>
		implements CrawlerService {

	@Resource(name = "crawlerRepository")
	private CrawlerRepository repository;
	
	@Resource(name = "crawlerRepository")
	public void setReposity(
			PagingAndSortingRepository<Crawler, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Crawler find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Crawler> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Crawler> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Crawler> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Crawler> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Crawler entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Crawler update(Crawler entity) {
		Crawler crawler = super.find(entity.getId());
		super.update(entity);
		return crawler;
	}

	@Override
	@Transactional
	public Crawler update(Crawler entity, String... ignoreProperties) {
		Crawler crawler = super.update(entity, ignoreProperties);
		return crawler;
	}

	@Override
	@Transactional
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	@Transactional
	public void delete(String[] ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	public void delete(Crawler entity) {
		super.delete(entity);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Crawler> findByName(String name,Pageable pageable){
		return repository.findByName(name,pageable);
	}
	
	@Override
	@Transactional
	public void closeAllCrawlers(){
		repository.closeAllCrawlers();
	}
}
