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
import com.centit.hlwyw.inner.entity.Hnii_ask;
import com.centit.hlwyw.inner.repositories.Hnii_askRepository;
import com.centit.hlwyw.inner.service.Hnii_askService;

@Service("hnii_askServiceImpl")
public class Hnii_askServiceImpl extends BaseServiceImpl<Hnii_ask, String>
		implements Hnii_askService {

	@Resource(name = "hnii_askRepository")
	private Hnii_askRepository repository;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;


	@Resource(name = "hnii_askRepository")
	public void setReposity(
			PagingAndSortingRepository<Hnii_ask, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Hnii_ask find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_ask> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_ask> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_ask> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Hnii_ask> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Hnii_ask entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Hnii_ask update(Hnii_ask entity) {
		Hnii_ask hnii_ask = super.find(entity.getId());
		super.update(entity);
		return hnii_ask;
	}

	@Override
	@Transactional
	public Hnii_ask update(Hnii_ask entity, String... ignoreProperties) {
		Hnii_ask hnii_ask = super.update(entity, ignoreProperties);
		return hnii_ask;
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
	public void delete(Hnii_ask entity) {
		super.delete(entity);
	}

	@Override
	public Page<Hnii_ask> findList(String industry, String servicetype,String content,Pageable pageable) {
		return repository.findList(industry, servicetype, content,pageable);
	}
	public Page<Object> findStatistics(Pageable pageable) {
		List<Object> values= new ArrayList<Object>();
		String columnsql = null;
		StringBuffer sql = null;
		columnsql = " h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype) ";
		sql = new StringBuffer(" from hnii_ask h  ");
		String order="group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		Page<Object> page=queryService.queryObjectForPage(columnsql, sql.toString(), order, values, pageable);
		return page;
						
	}
	
	public List<Object> findStatistics( ) {
		String sql="select h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype)  from hnii_ask h  group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		List<Object> page=queryService.queryObjectBySql(sql);
		return page;
	}

}
