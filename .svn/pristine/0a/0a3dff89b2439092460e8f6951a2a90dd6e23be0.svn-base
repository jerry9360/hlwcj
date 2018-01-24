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
import com.centit.hlwyw.inner.entity.Hnii_reflect;
import com.centit.hlwyw.inner.repositories.Hnii_reflectRepository;
import com.centit.hlwyw.inner.service.Hnii_reflectService;

@Service("hnii_reflectServiceImpl")
public class Hnii_reflectServiceImpl extends BaseServiceImpl<Hnii_reflect, String>
		implements Hnii_reflectService {

	@Resource(name = "hnii_reflectRepository")
	private Hnii_reflectRepository repository;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;


	@Resource(name = "hnii_reflectRepository")
	public void setReposity(
			PagingAndSortingRepository<Hnii_reflect, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Hnii_reflect find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_reflect> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_reflect> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_reflect> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Hnii_reflect> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Hnii_reflect entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Hnii_reflect update(Hnii_reflect entity) {
		Hnii_reflect hnii_reflect = super.find(entity.getId());
		super.update(entity);
		return hnii_reflect;
	}

	@Override
	@Transactional
	public Hnii_reflect update(Hnii_reflect entity, String... ignoreProperties) {
		Hnii_reflect hnii_reflect = super.update(entity, ignoreProperties);
		return hnii_reflect;
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
	public void delete(Hnii_reflect entity) {
		super.delete(entity);
	}

	@Override
	public Page<Hnii_reflect> findList(String industry, String servicetype,String content,Pageable pageable) {
		return repository.findList(industry, servicetype, content,pageable);
	}
	public Page<Object> findStatistics(Pageable pageable) {
		List<Object> values= new ArrayList<Object>();
		String columnsql = null;
		StringBuffer sql = null;
		columnsql = " h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype) ";
		sql = new StringBuffer(" from hnii_reflect h  ");
		String order="group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		Page<Object> page=queryService.queryObjectForPage(columnsql, sql.toString(), order, values, pageable);
		return page;
						
	}

	public List<Object> findStatistics() {
		String sql="select h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype)  from hnii_reflect h  group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		List<Object> page=queryService.queryObjectBySql(sql);
		return page;
	}
	


}
