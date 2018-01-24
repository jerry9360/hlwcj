package com.centit.hlwyw.inner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Taglib;
import com.centit.hlwyw.inner.repositories.TaglibRepository;
import com.centit.hlwyw.inner.service.TaglibService;

@Service("taglibServiceImpl")
public class TaglibServiceImpl extends BaseServiceImpl<Taglib, String>
		implements TaglibService {

	@Resource(name = "taglibRepository")
	private TaglibRepository repository;


	@Resource(name = "taglibRepository")
	public void setReposity(
			PagingAndSortingRepository<Taglib, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Taglib find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Taglib> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Taglib> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Taglib> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Taglib> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Taglib entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Taglib update(Taglib entity) {
		Taglib taglib = super.find(entity.getId());
		super.update(entity);
		return taglib;
	}

	@Override
	@Transactional
	public Taglib update(Taglib entity, String... ignoreProperties) {
		Taglib taglib = super.update(entity, ignoreProperties);
		return taglib;
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
	public void delete(Taglib entity) {
		super.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Taglib> findAllTags(String name,Pageable pageable){
		return repository.findAllTags(name, pageable);
	}

}
