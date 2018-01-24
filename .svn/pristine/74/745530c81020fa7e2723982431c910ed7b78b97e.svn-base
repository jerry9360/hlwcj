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
import com.centit.hlwyw.inner.entity.Industrystatistics;
import com.centit.hlwyw.inner.repositories.IndustrystatisticsRepository;
import com.centit.hlwyw.inner.service.IndustrystatisticsService;
 

@Service("industrystatisticsServiceImpl")
public class IndustrystatisticsServiceImpl extends BaseServiceImpl<Industrystatistics, String>
		implements IndustrystatisticsService {

	@Resource(name = "industrystatisticsRepository")
	private IndustrystatisticsRepository repository;


	@Resource(name = "industrystatisticsRepository")
	public void setReposity(
			PagingAndSortingRepository<Industrystatistics, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Industrystatistics find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Industrystatistics> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Industrystatistics> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Industrystatistics> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Industrystatistics> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Industrystatistics entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Industrystatistics update(Industrystatistics entity) {
		Industrystatistics industry_statistics = super.find(entity.getIndustry_id());
		super.update(entity);
		return industry_statistics;
	}

	@Override
	@Transactional
	public Industrystatistics update(Industrystatistics entity, String... ignoreProperties) {
		Industrystatistics industry_statistics = super.update(entity, ignoreProperties);
		return industry_statistics;
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
	public void delete(Industrystatistics entity) {
		super.delete(entity);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}


}
