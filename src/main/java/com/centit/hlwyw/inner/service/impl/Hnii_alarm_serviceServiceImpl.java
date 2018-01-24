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
import com.centit.hlwyw.inner.entity.Hnii_alarm_service;
import com.centit.hlwyw.inner.repositories.Hnii_alarm_serviceRepository;
import com.centit.hlwyw.inner.service.Hnii_alarm_serviceService;

@Service("hnii_alarm_serviceServiceImpl")
public class Hnii_alarm_serviceServiceImpl extends BaseServiceImpl<Hnii_alarm_service, String>
		implements Hnii_alarm_serviceService {

	@Resource(name = "hnii_alarm_serviceRepository")
	private Hnii_alarm_serviceRepository repository;


	@Resource(name = "hnii_alarm_serviceRepository")
	public void setReposity(
			PagingAndSortingRepository<Hnii_alarm_service, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("hnii_alarm_service")
	public Hnii_alarm_service find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("hnii_alarm_service")
	public List<Hnii_alarm_service> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("hnii_alarm_service")
	public List<Hnii_alarm_service> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("hnii_alarm_service")
	public List<Hnii_alarm_service> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("hnii_alarm_service")
	public Page<Hnii_alarm_service> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	@CacheEvict(value = "hnii_alarm_service", allEntries = true)
	public void save(Hnii_alarm_service entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	@CacheEvict(value = "hnii_alarm_service", allEntries = true)
	public Hnii_alarm_service update(Hnii_alarm_service entity) {
		Hnii_alarm_service hnii_alarm_service = super.find(entity.getMyid());
		super.update(entity);
		return hnii_alarm_service;
	}

	@Override
	@Transactional
	@CacheEvict(value = "hnii_alarm_service", allEntries = true)
	public Hnii_alarm_service update(Hnii_alarm_service entity, String... ignoreProperties) {
		Hnii_alarm_service hnii_alarm_service = super.update(entity, ignoreProperties);
		return hnii_alarm_service;
	}

	@Override
	@Transactional
	@CacheEvict(value = "hnii_alarm_service", allEntries = true)
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = "hnii_alarm_service", allEntries = true)
	public void delete(String[] ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	@CacheEvict(value = "hnii_alarm_service", allEntries = true)
	public void delete(Hnii_alarm_service entity) {
		super.delete(entity);
	}


	@Override
	public List<String> getYears() {
		return repository.getYears();
	}


	@Override
	public String sumByYear(String year) {
		return repository.sumByYear(year);
	}

	@Override
	public List<Object[]> statByYear() {
		return repository.statByYear();
	}


}
