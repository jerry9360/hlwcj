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

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Service_complaint;
import com.centit.hlwyw.inner.repositories.Service_complaintRepository;
import com.centit.hlwyw.inner.service.Service_complaintService;

@Service("service_complaintServiceImpl")
public class Service_complaintServiceImpl extends BaseServiceImpl<Service_complaint, String>
		implements Service_complaintService {

	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "service_complaintRepository")
	private Service_complaintRepository repository;


	@Resource(name = "service_complaintRepository")
	public void setReposity(
			PagingAndSortingRepository<Service_complaint, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Service_complaint find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Service_complaint> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Service_complaint> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Service_complaint> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Service_complaint> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Service_complaint entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Service_complaint update(Service_complaint entity) {
		Service_complaint service_complaint = super.find(entity.getId());
		super.update(entity);
		return service_complaint;
	}

	@Override
	@Transactional
	public Service_complaint update(Service_complaint entity, String... ignoreProperties) {
		Service_complaint service_complaint = super.update(entity, ignoreProperties);
		return service_complaint;
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
	public void delete(Service_complaint entity) {
		super.delete(entity);
	}

	@Override
//	@Cacheable("service_complaintcarno")
	public Page<Service_complaint> findList(String corp_name,
			String vehicle_no, Pageable pageable) {
		return repository.findList(corp_name, vehicle_no, pageable);
	}

	@Override
	public Page<Service_complaint> findWash(String corp_name,String vehicle_no, Pageable pageable) {
		return repository.findWash(corp_name, vehicle_no, pageable);
	}

	@Override
	public List<Object[]> stat() {
		return repository.stat();
	}
	
	@Override
	public List<Object> findDatas(String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from Service_complaint tb   ");
		String end =  " group by corp_name  order by count(1) desc) where rownum < 21 and corp_name is not null and length(corp_name) > 2" ;
		String sql = null;			
		if(begindate!=null){
			sqlBuilder.append(" where ");
			sqlBuilder.append(" to_char(tb.eventitime,'yyyy-mm-dd') >= " +"'"+begindate+"'");
			if( enddate!=null){
				sqlBuilder.append(" and to_char(tb.eventitime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
		}
		if(begindate==null&&enddate!=null){
			sqlBuilder.append(" where ");
			sqlBuilder.append(" to_char(tb.eventitime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
		}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}

	@Override
	public Page<Service_complaint> findList(String corpname,Pageable pageable) {
		return repository.findList(corpname, pageable);
	}
	
	@Override
	@Cacheable("complaintanalyze")
	public List<Object> findDatas( ) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from service_complaint   group by corp_name  order by count(1) desc) where rownum < 6 and corp_name is not null and length(corp_name) > 2  ");
		String sql = null;			
		sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}
	


}
