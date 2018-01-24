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
import com.centit.hlwyw.inner.entity.Public_prise;
import com.centit.hlwyw.inner.repositories.Public_priseRepository;
import com.centit.hlwyw.inner.service.Public_priseService;

@Service("public_priseServiceImpl")
public class Public_priseServiceImpl extends BaseServiceImpl<Public_prise, String>
		implements Public_priseService {
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;

	@Resource(name = "public_priseRepository")
	private Public_priseRepository repository;


	@Resource(name = "public_priseRepository")
	public void setReposity(
			PagingAndSortingRepository<Public_prise, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Public_prise find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Public_prise> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Public_prise> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Public_prise> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Public_prise> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Public_prise entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Public_prise update(Public_prise entity) {
		Public_prise public_prise = super.find(entity.getId());
		super.update(entity);
		return public_prise;
	}

	@Override
	@Transactional
	public Public_prise update(Public_prise entity, String... ignoreProperties) {
		Public_prise public_prise = super.update(entity, ignoreProperties);
		return public_prise;
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
	public void delete(Public_prise entity) {
		super.delete(entity);
	}

	@Override
	public Page<Public_prise> findList(String corp_name, String accept_num,
			Pageable pageable) {
		return repository.findList(corp_name, accept_num, pageable);
	}

	@Override
	public Page<Public_prise> findWash(String corp_name, String accept_num,Pageable pageable) {
		return repository.findWash(corp_name, accept_num, pageable);
	}

	@Override
	public List<Object[]> stat() {
		return repository.stat();
	}
	
	@Override
	public List<Object> findDatas(String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from Public_prise tb   ");
		String end =  " group by corp_name  order by count(1) desc) where rownum < 21 and corp_name is not null and length(corp_name) > 2" ;
		String sql = null;			
		if(begindate!=null){
			sqlBuilder.append(" where ");
			sqlBuilder.append(" to_char(tb.prisetime,'yyyy-mm-dd')  >= " +"'"+begindate+"'");
			if( enddate!=null){
				sqlBuilder.append(" and to_char(tb.prisetime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
		}
		if(begindate==null&&enddate!=null){
			sqlBuilder.append(" where ");
			sqlBuilder.append(" to_char(tb.prisetime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
		}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}

	@Override
	public Page<Public_prise> findList(String corpname,Pageable pageable) {
		return repository.findList(corpname, pageable);
	}
	
	@Override
	@Cacheable("priseananalyze")
	public List<Object> findDatas( ) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from public_prise   group by corp_name  order by count(1) desc) where rownum < 6 and corp_name is not null and length(corp_name) > 2  ");
		String sql = null;			
		sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}


}
