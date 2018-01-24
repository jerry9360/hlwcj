package com.centit.hlwyw.inner.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.UrlSource;
import com.centit.hlwyw.inner.repositories.UrlSourceRepository;
import com.centit.hlwyw.inner.service.UrlSourceService;

@Service("urlSourceServiceImpl")
public class UrlSourceServiceImpl extends BaseServiceImpl<UrlSource, String>
implements UrlSourceService{
	
	@Resource(name = "urlSourceRepository")
	private UrlSourceRepository repository;
	
	@Resource(name = "urlSourceRepository")
	public void setReposity(
			PagingAndSortingRepository<UrlSource, String> repository) {
		super.setReposity(repository);
	}
	
	@Override
	@Transactional(readOnly = true)
//	@Cacheable("urlSource")
	public Page<UrlSource> findPage(Pageable pageable){
		return repository.findPage(pageable);
	}
	
	@Override
	@Transactional
//	@CacheEvict(value = "urlSource", allEntries = true)
	public void save(UrlSource entity) {
		super.save(entity);
	}
	
	@Override
	@Transactional
//	@CacheEvict(value = "urlSource", allEntries = true)
	public UrlSource update(UrlSource entity) {
		return super.update(entity);
	}
	
	@Override
	@Transactional
//	@Cacheable("urlSource")
	public UrlSource find(String id) {
		return super.find(id);
	}
	@Override
	@Transactional
//	@CacheEvict(value = "urlSource", allEntries = true)
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	@Transactional
//	@Cacheable("urlSource")
	public Page<UrlSource> findSearchname(String urlname, Pageable pageable) {
		return repository.findSearchname(urlname, pageable);
	}
	
	@Override
	@Transactional
//	@CacheEvict(value = "urlSource", allEntries = true)
	public void deleteUrl(String id){
		repository.deleteUrl(id);
	}
}
