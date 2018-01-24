package com.centit.hlwyw.inner.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Dishonestman;
import com.centit.hlwyw.inner.repositories.DishonestManRepository;
import com.centit.hlwyw.inner.service.DishonestManService;

@Service("dishonestManServiceImpl")
public class DishonestManServiceImpl extends BaseServiceImpl<Dishonestman, String>
		implements DishonestManService {
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "dishonestManRepository")
	private DishonestManRepository repository;


	@Resource(name = "dishonestManRepository")
	public void setReposity(
			PagingAndSortingRepository<Dishonestman, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Dishonestman find(String id) {
		return super.find(id);
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Dishonestman> findSearch(String disman_name,String industry,Pageable pageable) {
		disman_name =StringUtils.isBlank(disman_name)?"%%":"%"+disman_name+"%";
		industry =StringUtils.isBlank(industry)?"%%":"%"+industry+"%";
		return repository.findSearch(disman_name,industry, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public String findOneMonth(List<String> dateliststr, String dateFrom,String dateNow) {
		String sql="select  to_char(create_date,'YYYY/MM/DD'),nvl(count(*),0)  "
				+ "from dishonestMan  p "
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
	public Page<Dishonestman> findWash(String corp_name, String source,Pageable pageable) {
		return repository.findWash(corp_name, source, pageable);
	}

	@Override
	public List<Object[]> stat() {
		return repository.stat();
	}

	@Override
	public List<Object> findDatas(String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from Dishonestman  tb   ");
		String end =  " group by corp_name  order by count(1) desc) where rownum < 21 and corp_name is not null and length(corp_name) > 2" ;
		String sql = null;			
			if(begindate!=null){
				sqlBuilder.append(" where ");
				sqlBuilder.append(" to_char(tb.releasetime,'yyyy-mm-dd' ) >= " +"'"+begindate+"'");
				if( enddate!=null){
					sqlBuilder.append(" and to_char(tb.releasetime,'yyyy-mm-dd' )  <= " +"'"+enddate+"'");
				}
			}
			if(begindate==null&&enddate!=null){
				sqlBuilder.append(" where ");
				sqlBuilder.append(" to_char(tb.releasetime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}
	
	@Override
	public Page<Dishonestman> findList(String corpname,Pageable pageable) {
		return repository.findList(corpname, pageable);
	}
	
	@Override
	@Cacheable("dishonestmananalyze")
	public List<Object> findDatas( ) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from dishonestman   group by corp_name  order by count(1) desc) where rownum < 6 and corp_name is not null and length(corp_name) > 2  ");
		String sql = null;			
		sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}
}
