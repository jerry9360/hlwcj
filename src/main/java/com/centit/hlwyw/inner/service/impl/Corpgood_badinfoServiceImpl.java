package com.centit.hlwyw.inner.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Corpgood_badinfo;
import com.centit.hlwyw.inner.repositories.Corpgood_badinfoRepository;
import com.centit.hlwyw.inner.service.Corpgood_badinfoService;

@Service("corpgood_badinfoServiceImpl")
public class Corpgood_badinfoServiceImpl extends BaseServiceImpl<Corpgood_badinfo, String>
		implements Corpgood_badinfoService {
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	@Resource(name = "corpgood_badinfoRepository")
	private Corpgood_badinfoRepository repository;


	@Resource(name = "corpgood_badinfoRepository")
	public void setReposity(
			PagingAndSortingRepository<Corpgood_badinfo, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Corpgood_badinfo find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpgood_badinfo> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpgood_badinfo> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpgood_badinfo> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Corpgood_badinfo> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Corpgood_badinfo entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Corpgood_badinfo update(Corpgood_badinfo entity) {
		Corpgood_badinfo corpgood_badinfo = super.find(entity.getId());
		super.update(entity);
		return corpgood_badinfo;
	}

	@Override
	@Transactional
	public Corpgood_badinfo update(Corpgood_badinfo entity, String... ignoreProperties) {
		Corpgood_badinfo corpgood_badinfo = super.update(entity, ignoreProperties);
		return corpgood_badinfo;
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
	public void delete(Corpgood_badinfo entity) {
		super.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
//	@Cacheable("corpgood_badinfosearch")
	public Page<Corpgood_badinfo> findSearch(String corp_name,String type,  String source ,Pageable pageable) {
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		type =StringUtils.isBlank(type)?"%%":"%"+type+"%";
		source =StringUtils.isBlank(source)?"%%":"%"+source+"%";
		return repository.findSearch(corp_name,type,source, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Corpgood_badinfo> findClearSearch(String corp_name,String type,String source,String state,Pageable pageable){
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		type =StringUtils.isBlank(type)?"%%":"%"+type+"%";
		if(StringUtils.isNotBlank(state)){
			if(StringUtils.isNotBlank(source)){
				source =StringUtils.isBlank(source)?"%%":"%"+source+"%";
				return repository.findDearSearch(state,corp_name, type, source,pageable);
			}else{
				return repository.findDearSearch(state,corp_name, type,pageable);
			}
		}else{
			if(StringUtils.isNotBlank(source)){
				source =StringUtils.isBlank(source)?"%%":"%"+source+"%";
				return repository.findClearSearch(corp_name,type,source,pageable);
			}else{
				return repository.findClearSearch(corp_name,type,pageable);
			}
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public String findOneMonth(List<String> dateliststr,String dateFrom,String dateNow) {
  		String sql="select  to_char(create_date,'YYYY/MM/DD'),nvl(count(*),0)  "
				+ "from corpgood_badinfo  p "
				+ "where p.create_date>= to_date('"+dateFrom+"','yyyy/mm/dd')  and p.create_date<= to_date('"+dateNow+"','yyyy/mm/dd')  "
				+ "group by to_char(create_date,'YYYY/MM/DD') " ;
 		List<Object> rst = queryService.queryObjectBySql(sql);
		Map<String,String> rstmap=new HashMap<String,String>();
		for(Object rs:rst){
			Object[]r=(Object[]) rs;
			rstmap.put(r[0].toString(), r[1].toString());
		}
 		String crt_seriesdata="[";
		for(String datestr:dateliststr){
			if(rstmap.get(datestr)==null){
				crt_seriesdata=crt_seriesdata+"'0',";
			}else{
				crt_seriesdata=crt_seriesdata+"'"+rstmap.get(datestr)+"',";
			}
		}
		crt_seriesdata=crt_seriesdata.substring(0,crt_seriesdata.length()-1)+"]";
		return crt_seriesdata;
	}

	@Override
	public Page<Corpgood_badinfo> findWash(String corp_name, String type,String source, Pageable pageable) {
		return repository.findWash(corp_name, type, source, pageable);
	}

	@Override
	public List<Object[]> stat() {
		return repository.stat();
	}


}
