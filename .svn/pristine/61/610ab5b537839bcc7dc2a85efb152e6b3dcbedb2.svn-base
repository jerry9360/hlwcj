package com.centit.hlwyw.inner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
 import com.centit.hlwyw.inner.entity.Collectlist;
import com.centit.hlwyw.inner.repositories.CollectlistRepository;
import com.centit.hlwyw.inner.service.CollectlistService;

@Service("collectlistServiceImpl")
public class CollectlistServiceImpl extends BaseServiceImpl<Collectlist, String>
		implements CollectlistService {

	@Resource(name = "collectlistRepository")
	private CollectlistRepository repository;


	@Resource(name = "collectlistRepository")
	public void setReposity(
			PagingAndSortingRepository<Collectlist, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Collectlist find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Collectlist> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Collectlist> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Collectlist> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Collectlist> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Collectlist entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Collectlist update(Collectlist entity) {
		Collectlist collectlist = super.find(entity.getId());
		super.update(entity);
		return collectlist;
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
	public void delete(Collectlist entity) {
		super.delete(entity);
	}


}
