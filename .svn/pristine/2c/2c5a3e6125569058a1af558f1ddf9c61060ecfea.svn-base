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
 import com.centit.hlwyw.inner.entity.Datacategory;
import com.centit.hlwyw.inner.repositories.DatacategoryRepository;
import com.centit.hlwyw.inner.service.DatacategoryService;

@Service("datacategoryServiceImpl")
public class DatacategoryServiceImpl extends BaseServiceImpl<Datacategory, String>
		implements DatacategoryService {

	@Resource(name = "datacategoryRepository")
	private DatacategoryRepository repository;


	@Resource(name = "datacategoryRepository")
	public void setReposity(
			PagingAndSortingRepository<Datacategory, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Datacategory find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Datacategory> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Datacategory> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Datacategory> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Datacategory> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Datacategory entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Datacategory update(Datacategory entity) {
		Datacategory datacategory = super.find(entity.getId());
		super.update(entity);
		return datacategory;
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
	public void delete(Datacategory entity) {
		super.delete(entity);
	}


}
