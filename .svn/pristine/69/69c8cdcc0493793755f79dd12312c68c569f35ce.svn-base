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
import com.centit.hlwyw.inner.entity.Smalltypestatistics;
import com.centit.hlwyw.inner.repositories.SmalltypestatisticsRepository;
import com.centit.hlwyw.inner.service.SmalltypestatisticsService;

@Service("smalltypestatisticsServiceImpl")
public class SmalltypestatisticsServiceImpl extends BaseServiceImpl<Smalltypestatistics, String>
		implements SmalltypestatisticsService {

	@Resource(name = "smalltypestatisticsRepository")
	private SmalltypestatisticsRepository repository;


	@Resource(name = "smalltypestatisticsRepository")
	public void setReposity(
			PagingAndSortingRepository<Smalltypestatistics, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Smalltypestatistics find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Smalltypestatistics> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Smalltypestatistics> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Smalltypestatistics> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Smalltypestatistics> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Smalltypestatistics entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Smalltypestatistics update(Smalltypestatistics entity) {
		Smalltypestatistics small_type_statistics = super.find(entity.getSmall_type_id());
		super.update(entity);
		return small_type_statistics;
	}

	@Override
	@Transactional
	public Smalltypestatistics update(Smalltypestatistics entity, String... ignoreProperties) {
		Smalltypestatistics small_type_statistics = super.update(entity, ignoreProperties);
		return small_type_statistics;
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
	public void delete(Smalltypestatistics entity) {
		super.delete(entity);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}


}
