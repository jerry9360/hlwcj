package com.centit.hlwyw.inner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Pergoodinfo;
import com.centit.hlwyw.inner.repositories.PergoodinfoRepository;
import com.centit.hlwyw.inner.service.PergoodinfoService;

@Service("pergoodinfoServiceImpl")
public class PergoodinfoServiceImpl extends BaseServiceImpl<Pergoodinfo, String>
		implements PergoodinfoService {

	@Resource(name = "pergoodinfoRepository")
	private PergoodinfoRepository repository;


	@Resource(name = "pergoodinfoRepository")
	public void setReposity(
			PagingAndSortingRepository<Pergoodinfo, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Pergoodinfo find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pergoodinfo> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pergoodinfo> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pergoodinfo> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pergoodinfo> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Pergoodinfo entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Pergoodinfo update(Pergoodinfo entity) {
		Pergoodinfo pergoodinfo = super.find(entity.getId());
		super.update(entity);
		return pergoodinfo;
	}

	@Override
	@Transactional
	public Pergoodinfo update(Pergoodinfo entity, String... ignoreProperties) {
		Pergoodinfo pergoodinfo = super.update(entity, ignoreProperties);
		return pergoodinfo;
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
	public void delete(Pergoodinfo entity) {
		super.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pergoodinfo> findSearch(String name, String type,String source,Pageable pageable) {
		name =StringUtils.isBlank(name)?"%%":"%"+name+"%";
		type =StringUtils.isBlank(type)?"%%":"%"+type+"%";
		source =StringUtils.isBlank(source)?"%%":"%"+source+"%";
		return repository.findSearch(name, type,source,pageable);
	}
 


}
