package com.centit.hlwyw.inner.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Jwdata;
import com.centit.hlwyw.inner.repositories.JwdataRepository;
import com.centit.hlwyw.inner.service.JwdataService;

@Service("jwdataServiceImpl")
public class JwdataServiceImpl extends BaseServiceImpl<Jwdata, String>
		implements JwdataService {
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "jwdataRepository")
	private JwdataRepository repository;

	@Resource(name = "jwdataRepository")
	public void setReposity(
			PagingAndSortingRepository<Jwdata, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Jwdata find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Jwdata> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Jwdata> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Jwdata> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Jwdata> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Jwdata entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Jwdata update(Jwdata entity) {
		Jwdata Jwdata = super.find(entity.getId());
		super.update(entity);
		return Jwdata;
	}

	@Override
	@Transactional
	public Jwdata update(Jwdata entity, String... ignoreProperties) {
		Jwdata Jwdata = super.update(entity, ignoreProperties);
		return Jwdata;
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
	public void delete(Jwdata entity) {
		super.delete(entity);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public String findOneMonth(List<String> dateliststr,String dateFrom,String dateNow) {
  		String sql="select  to_char(create_date,'YYYY/MM/DD'),nvl(count(*),0)  "
				+ "from jw_data  p "
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
	@Transactional(readOnly = true)
	public Page<Jwdata> findJwdataPage(String title, String source, Pageable pageable) {
		Page<Jwdata> page=null;
		if(StringUtils.isNotBlank(title)){
			title="%"+title+"%";
			if(StringUtils.isNotBlank(source)){
				source="%"+source+"%";
 				page=repository.findPageTitleSource(title,source,pageable);
			}else{
				page=repository.findPageTitle(title,pageable);
			}
		}else{
			if(StringUtils.isNotBlank(source)){
				source="%"+source+"%";
				page=repository.findPageSource(source,pageable);
			}else{
				page=repository.findPage(pageable);
			}
		}
		return page;
	}
}
