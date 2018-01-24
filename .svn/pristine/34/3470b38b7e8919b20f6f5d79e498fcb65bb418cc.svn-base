package com.centit.hlwyw.inner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.HniiBehavior;
import com.centit.hlwyw.inner.repositories.HniiBehaviorRepository;
import com.centit.hlwyw.inner.service.HniiBehaviorService;

@Service("hniiBehaviorServiceImpl")
public class HniiBehaviorServiceImpl extends BaseServiceImpl<HniiBehavior, String>
		implements HniiBehaviorService {

	@Resource(name = "hniiBehaviorRepository")
	private HniiBehaviorRepository repository;


	@Resource(name = "hniiBehaviorRepository")
	public void setReposity(
			PagingAndSortingRepository<HniiBehavior, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public HniiBehavior find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HniiBehavior> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<HniiBehavior> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HniiBehavior> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<HniiBehavior> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(HniiBehavior entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public HniiBehavior update(HniiBehavior entity) {
		HniiBehavior big_type_statistics = super.find(entity.getId());
		super.update(entity);
		return big_type_statistics;
	}

	@Override
	@Transactional
	public HniiBehavior update(HniiBehavior entity, String... ignoreProperties) {
		HniiBehavior big_type_statistics = super.update(entity, ignoreProperties);
		return big_type_statistics;
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
	public void delete(HniiBehavior entity) {
		super.delete(entity);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	@Cacheable("analyzecomplaint")
	public List<Object[]> findComplaint() {
		return repository.findComplaint();
	}

	@Override
	@Cacheable("analyzeconsult")
	public List<Object[]> findConsult() {
		return repository.findConsult();
	}
}
