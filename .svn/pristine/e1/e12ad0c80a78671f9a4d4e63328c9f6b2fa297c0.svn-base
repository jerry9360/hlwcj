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
import com.centit.hlwyw.inner.entity.Business_secondary;
import com.centit.hlwyw.inner.repositories.Business_secondaryRepository;
import com.centit.hlwyw.inner.service.Business_secondaryService;

@Service("business_secondaryServiceImpl")
public class Business_secondaryServiceImpl extends BaseServiceImpl<Business_secondary, String>
		implements Business_secondaryService {

	@Resource(name = "business_secondaryRepository")
	private Business_secondaryRepository repository;


	@Resource(name = "business_secondaryRepository")
	public void setReposity(
			PagingAndSortingRepository<Business_secondary, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Business_secondary find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Business_secondary> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Business_secondary> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Business_secondary> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Business_secondary> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Business_secondary entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Business_secondary update(Business_secondary entity) {
		Business_secondary business_secondary = super.find(entity.getRoot_id());
		super.update(entity);
		return business_secondary;
	}

	@Override
	@Transactional
	public Business_secondary update(Business_secondary entity, String... ignoreProperties) {
		Business_secondary business_secondary = super.update(entity, ignoreProperties);
		return business_secondary;
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
	public void delete(Business_secondary entity) {
		super.delete(entity);
	}

	@Override
	public Page<Business_secondary> findByRoot_id(String root_id, Pageable pageable) {
		return repository.findByRoot_id(root_id, pageable);
	}

	@Override
	public List<Business_secondary> findAllDelete(String root_id) {
		return repository.findAllDelete(root_id);
	}

	@Override
	public int updateByIndustry_id(String root_id, String business_name) {
		return repository.updateByIndustry_id(root_id,business_name);
	}

	public Page<Business_secondary> findByIndustry(String industry, Pageable pageable) {
		return repository.findByIndustry(industry, pageable);
	}

	@Override
	public List<Business_secondary> findByRootid(String root_id) {
		return repository.findByRootid(root_id);
	}

	 

	 

}
