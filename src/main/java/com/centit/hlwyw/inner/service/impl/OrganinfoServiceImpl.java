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
import com.centit.hlwyw.inner.entity.Organinfo;
import com.centit.hlwyw.inner.repositories.OrganinfoRepository;
import com.centit.hlwyw.inner.service.OrganinfoService;

@Service("organinfoServiceImpl")
public class OrganinfoServiceImpl extends BaseServiceImpl<Organinfo, String>
		implements OrganinfoService {

	@Resource(name = "organinfoRepository")
	private OrganinfoRepository repository;


	@Resource(name = "organinfoRepository")
	public void setReposity(
			PagingAndSortingRepository<Organinfo, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Organinfo find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Organinfo> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Organinfo> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Organinfo> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Organinfo> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Organinfo entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Organinfo update(Organinfo entity) {
		Organinfo organinfo = super.find(entity.getOrgid());
		super.update(entity);
		return organinfo;
	}

	@Override
	@Transactional
	public Organinfo update(Organinfo entity, String... ignoreProperties) {
		Organinfo organinfo = super.update(entity, ignoreProperties);
		return organinfo;
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
	public void delete(Organinfo entity) {
		super.delete(entity);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Organinfo> findAll(String name,Pageable pageable){
		return repository.findByOrgnameLikeOrderByCreatedateDesc(name, pageable);
	}
}
