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
import com.centit.hlwyw.inner.entity.Industry_type;
import com.centit.hlwyw.inner.repositories.Industry_typeRepository;
import com.centit.hlwyw.inner.service.Industry_typeService;

@Service("industry_typeServiceImpl")
public class Industry_typeServiceImpl extends BaseServiceImpl<Industry_type, String>
		implements Industry_typeService {

	@Resource(name = "industry_typeRepository")
	private Industry_typeRepository repository;


	@Resource(name = "industry_typeRepository")
	public void setReposity(
			PagingAndSortingRepository<Industry_type, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Industry_type find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Industry_type> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Industry_type> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Industry_type> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Industry_type> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Industry_type entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Industry_type update(Industry_type entity) {
		Industry_type industry_type = super.find(entity.getIndustry_id());
		super.update(entity);
		return industry_type;
	}

	@Override
	@Transactional
	public Industry_type update(Industry_type entity, String... ignoreProperties) {
		Industry_type industry_type = super.update(entity, ignoreProperties);
		return industry_type;
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
	public void delete(Industry_type entity) {
		super.delete(entity);
	}

	 

}
