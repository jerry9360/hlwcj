package com.centit.hlwyw.inner.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Corpmediaexposed;
import com.centit.hlwyw.inner.repositories.CorpmediaexposedRepository;
import com.centit.hlwyw.inner.service.CorpmediaexposedService;

@Service("corpmediaexposedServiceImpl")
public class CorpmediaexposedServiceImpl extends BaseServiceImpl<Corpmediaexposed, String>
		implements CorpmediaexposedService {
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	@Resource(name = "corpmediaexposedRepository")
	private CorpmediaexposedRepository repository;


	@Resource(name = "corpmediaexposedRepository")
	public void setReposity(
			PagingAndSortingRepository<Corpmediaexposed, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Corpmediaexposed find(String id) {
		return super.find(id);
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Corpmediaexposed> findSearch(String corp_name,String industry,Pageable pageable) {
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		industry =StringUtils.isBlank(industry)?"%%":"%"+industry+"%";
		return repository.findSearch(corp_name,industry, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public String findOneMonth(List<String> dateliststr, String dateFrom,String dateNow) {
		String sql="select  to_char(create_date,'YYYY/MM/DD'),nvl(count(*),0)  "
				+ "from corpmediaexposed  p "
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
	public Page<Corpmediaexposed> findWash(String corp_name, String industry,Pageable pageable) {
		return repository.findWash(corp_name, industry, pageable);
	}

	@Override
	public List<Object[]> stat() {
		return repository.stat();
	}
	
}
