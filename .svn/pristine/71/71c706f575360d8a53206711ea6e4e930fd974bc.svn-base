package com.centit.hlwyw.inner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Perbadinfo;
import com.centit.hlwyw.inner.repositories.PerbadinfoRepository;
import com.centit.hlwyw.inner.service.PerbadinfoService;

@Service("perbadinfoServiceImpl")
public class PerbadinfoServiceImpl extends BaseServiceImpl<Perbadinfo, String>
		implements PerbadinfoService {

	@Resource(name = "perbadinfoRepository")
	private PerbadinfoRepository repository;


	@Resource(name = "perbadinfoRepository")
	public void setReposity(
			PagingAndSortingRepository<Perbadinfo, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Perbadinfo find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perbadinfo> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perbadinfo> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perbadinfo> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Perbadinfo> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Perbadinfo entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Perbadinfo update(Perbadinfo entity) {
		Perbadinfo perbadinfo = super.find(entity.getId());
		super.update(entity);
		return perbadinfo;
	}

	@Override
	@Transactional
	public Perbadinfo update(Perbadinfo entity, String... ignoreProperties) {
		Perbadinfo perbadinfo = super.update(entity, ignoreProperties);
		return perbadinfo;
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
	public void delete(Perbadinfo entity) {
		super.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Perbadinfo> findSearch(String name,String type,String source, Pageable pageable) {
		name =StringUtils.isBlank(name)?"%%":"%"+name+"%";
		type =StringUtils.isBlank(type)?"%%":"%"+type+"%";
		source =StringUtils.isBlank(source)?"%%":"%"+source+"%";
		return repository.findSearch(name,type,source,pageable);
	}


}
