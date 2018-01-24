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
import com.centit.hlwyw.inner.entity.Hnii_complaint;
import com.centit.hlwyw.inner.repositories.Hnii_complaintRepository;
import com.centit.hlwyw.inner.service.Hnii_complaintService;

@Service("hnii_complaintServiceImpl")
public class Hnii_complaintServiceImpl extends BaseServiceImpl<Hnii_complaint, String>
		implements Hnii_complaintService {

	@Resource(name = "hnii_complaintRepository")
	private Hnii_complaintRepository repository;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;


	@Resource(name = "hnii_complaintRepository")
	public void setReposity(
			PagingAndSortingRepository<Hnii_complaint, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Hnii_complaint find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_complaint> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_complaint> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_complaint> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Hnii_complaint> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Hnii_complaint entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Hnii_complaint update(Hnii_complaint entity) {
		Hnii_complaint hnii_complaint = super.find(entity.getId());
		super.update(entity);
		return hnii_complaint;
	}

	@Override
	@Transactional
	public Hnii_complaint update(Hnii_complaint entity, String... ignoreProperties) {
		Hnii_complaint hnii_complaint = super.update(entity, ignoreProperties);
		return hnii_complaint;
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
	public void delete(Hnii_complaint entity) {
		super.delete(entity);
	}

	@Override
	public Page<Hnii_complaint> findList(String industry, String servicetype,String content,Pageable pageable) {
		return repository.findList(industry, servicetype, content,pageable);
	}
	public Page<Object> findStatistics(Pageable pageable) {
		List<Object> values= new ArrayList<Object>();
		String columnsql = null;
		StringBuffer sql = null;
		columnsql = " h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype) ";
		sql = new StringBuffer(" from hnii_complaint h  ");
		String order="group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		Page<Object> page=queryService.queryObjectForPage(columnsql, sql.toString(), order, values, pageable);
		return page;
						
	}
	
	public List<Object> findStatistics( ) {
		String sql="select h.industry,h.servicetype, to_char(h.calltime,'yyyy'),count(h.calltime),count(h.servicetype)  from hnii_complaint h  group by h.industry, to_char(h.calltime,'yyyy'),h.servicetype  order by h.industry,to_char(h.calltime,'yyyy'),h.servicetype  desc ";
		List<Object> page=queryService.queryObjectBySql(sql);
		return page;
						
	}


}
