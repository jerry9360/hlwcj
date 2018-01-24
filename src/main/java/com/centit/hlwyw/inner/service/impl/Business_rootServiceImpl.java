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
import com.centit.hlwyw.inner.entity.Business_root;
import com.centit.hlwyw.inner.repositories.Business_rootRepository;
import com.centit.hlwyw.inner.service.Business_rootService;

@Service("business_rootServiceImpl")
public class Business_rootServiceImpl extends BaseServiceImpl<Business_root, String>
		implements Business_rootService {

	@Resource(name = "business_rootRepository")
	private Business_rootRepository repository;


	@Resource(name = "business_rootRepository")
	public void setReposity(
			PagingAndSortingRepository<Business_root, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Business_root find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Business_root> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Business_root> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Business_root> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Business_root> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Business_root entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Business_root update(Business_root entity) {
		Business_root business_root = super.find(entity.getRoot_id());
		super.update(entity);
		return business_root;
	}

	@Override
	@Transactional
	public Business_root update(Business_root entity, String... ignoreProperties) {
		Business_root business_root = super.update(entity, ignoreProperties);
		return business_root;
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
	public void delete(Business_root entity) {
		super.delete(entity);
	}

	public Page<Business_root> findById(String industry_id, Pageable pageable) {
		
		return repository.findById(industry_id, pageable);
	}

	@Override
	public int updateByIndustry_id(String industry_id, String industry_name) {
		return repository.updateByIndustry_id(industry_id, industry_name);
	}

	@Override
	public Page<Business_root> findByBusinessName(String busineess_name, Pageable pageable) {
		return repository.findByBusinessName(busineess_name, pageable);
	}

	@Override
	public List<Business_root> findListAll() {
		return repository.findListAll();
	}

	 

}
