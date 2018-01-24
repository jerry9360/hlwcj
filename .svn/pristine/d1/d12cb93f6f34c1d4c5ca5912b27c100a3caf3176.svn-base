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
import com.centit.hlwyw.inner.entity.Hnii;
import com.centit.hlwyw.inner.repositories.HniiRepository;
import com.centit.hlwyw.inner.service.HniiService;

@Service("hniiServiceImpl")
public class HniiServiceImpl extends BaseServiceImpl<Hnii, String>
		implements HniiService {

	@Resource(name = "hniiRepository")
	private HniiRepository repository;


	@Resource(name = "hniiRepository")
	public void setReposity(
			PagingAndSortingRepository<Hnii, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Hnii find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Hnii> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Hnii entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Hnii update(Hnii entity) {
		Hnii big_type_statistics = super.find(entity.getId());
		super.update(entity);
		return big_type_statistics;
	}

	@Override
	@Transactional
	public Hnii update(Hnii entity, String... ignoreProperties) {
		Hnii big_type_statistics = super.update(entity, ignoreProperties);
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
	public void delete(Hnii entity) {
		super.delete(entity);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

}
