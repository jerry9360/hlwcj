package com.centit.hlwyw.inner.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Hnii_suggest;
import com.centit.hlwyw.inner.repositories.Hnii_suggestRepository;
import com.centit.hlwyw.inner.service.Hnii_suggestService;

@Service("hnii_suggestServiceImpl")
public class Hnii_suggestServiceImpl extends BaseServiceImpl<Hnii_suggest, String>
		implements Hnii_suggestService {

	@Resource(name = "hnii_suggestRepository")
	private Hnii_suggestRepository repository;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;


	@Resource(name = "hnii_suggestRepository")
	public void setReposity(
			PagingAndSortingRepository<Hnii_suggest, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Hnii_suggest find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_suggest> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_suggest> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_suggest> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Hnii_suggest> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Hnii_suggest entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Hnii_suggest update(Hnii_suggest entity) {
		Hnii_suggest hnii_suggest = super.find(entity.getId());
		super.update(entity);
		return hnii_suggest;
	}

	@Override
	@Transactional
	public Hnii_suggest update(Hnii_suggest entity, String... ignoreProperties) {
		Hnii_suggest hnii_suggest = super.update(entity, ignoreProperties);
		return hnii_suggest;
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
	public void delete(Hnii_suggest entity) {
		super.delete(entity);
	}

	@Override
	public Page<Hnii_suggest> findList(String industry, String servicetype,String content,Pageable pageable) {
		return repository.findList(industry, servicetype, content,pageable);
	}
	public Page<Object> findStatistics(Pageable pageable) {
		List<Object> values= new ArrayList<Object>();
		String columnsql = null;
		StringBuffer sql = null;
		columnsql = " h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype) ";
		sql = new StringBuffer(" from hnii_suggest h  ");
		String order="group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		Page<Object> page=queryService.queryObjectForPage(columnsql, sql.toString(), order, values, pageable);
		return page;
						
	}
	
	public List<Object> findStatistics( ) {
		String sql="select h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype)  from hnii_suggest h  group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		List<Object> page=queryService.queryObjectBySql(sql);
		return page;
	}

}
