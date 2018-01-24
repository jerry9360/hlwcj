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
import com.centit.hlwyw.inner.entity.Bigtypestatistics;
import com.centit.hlwyw.inner.repositories.BigtypestatisticsRepository;
import com.centit.hlwyw.inner.service.BigtypestatisticsService;

@Service("bigtypestatisticsServiceImpl")
public class BigtypestatisticsServiceImpl extends BaseServiceImpl<Bigtypestatistics, String>
		implements BigtypestatisticsService {

	@Resource(name = "bigtypestatisticsRepository")
	private BigtypestatisticsRepository repository;


	@Resource(name = "bigtypestatisticsRepository")
	public void setReposity(
			PagingAndSortingRepository<Bigtypestatistics, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Bigtypestatistics find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bigtypestatistics> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bigtypestatistics> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bigtypestatistics> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Bigtypestatistics> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Bigtypestatistics entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Bigtypestatistics update(Bigtypestatistics entity) {
		Bigtypestatistics big_type_statistics = super.find(entity.getBig_type_id());
		super.update(entity);
		return big_type_statistics;
	}

	@Override
	@Transactional
	public Bigtypestatistics update(Bigtypestatistics entity, String... ignoreProperties) {
		Bigtypestatistics big_type_statistics = super.update(entity, ignoreProperties);
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
	public void delete(Bigtypestatistics entity) {
		super.delete(entity);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	 


}
