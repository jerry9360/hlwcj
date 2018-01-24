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
import com.centit.hlwyw.inner.entity.Hnii_report;
import com.centit.hlwyw.inner.repositories.Hnii_reportRepository;
import com.centit.hlwyw.inner.service.Hnii_reportService;

@Service("hnii_reportServiceImpl")
public class Hnii_reportServiceImpl extends BaseServiceImpl<Hnii_report, String>
		implements Hnii_reportService {

	@Resource(name = "hnii_reportRepository")
	private Hnii_reportRepository repository;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;


	@Resource(name = "hnii_reportRepository")
	public void setReposity(
			PagingAndSortingRepository<Hnii_report, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Hnii_report find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_report> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_report> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_report> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Hnii_report> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Hnii_report entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Hnii_report update(Hnii_report entity) {
		Hnii_report hnii_report = super.find(entity.getId());
		super.update(entity);
		return hnii_report;
	}

	@Override
	@Transactional
	public Hnii_report update(Hnii_report entity, String... ignoreProperties) {
		Hnii_report hnii_report = super.update(entity, ignoreProperties);
		return hnii_report;
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
	public void delete(Hnii_report entity) {
		super.delete(entity);
	}

	@Override
	public Page<Hnii_report> findList(String industry, String servicetype,String content,Pageable pageable) {
		return repository.findList(industry, servicetype, content,pageable);
	}
	public Page<Object> findStatistics(Pageable pageable) {
		List<Object> values= new ArrayList<Object>();
		String columnsql = null;
		StringBuffer sql = null;
		columnsql = " h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype) ";
		sql = new StringBuffer(" from hnii_report h  ");
		String order="group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		Page<Object> page=queryService.queryObjectForPage(columnsql, sql.toString(), order, values, pageable);
		return page;
						
	}
	
	public List<Object> findStatistics( ) {
		String sql="select h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype)  from hnii_report h  group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		List<Object> page=queryService.queryObjectBySql(sql);
		return page;
						
	}


}
