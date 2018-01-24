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
import com.centit.hlwyw.inner.entity.Zhongbiaogg;
import com.centit.hlwyw.inner.repositories.ZhongbiaoggRepository;
import com.centit.hlwyw.inner.service.ZhongbiaoggService;

@Service("zhongbiaoggServiceImpl")
public class ZhongbiaoggServiceImpl extends BaseServiceImpl<Zhongbiaogg, String>
		implements ZhongbiaoggService {
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "zhongbiaoggRepository")
	private ZhongbiaoggRepository repository;


	@Resource(name = "zhongbiaoggRepository")
	public void setReposity(
			PagingAndSortingRepository<Zhongbiaogg, String> repository) {
		super.setReposity(repository);
	}
		
	@Override
	public Page<Zhongbiaogg> findSearch(String project_name, String zhaobiaore,
			Pageable pageable) {
		project_name =StringUtils.isBlank(project_name)?"%%":"%"+project_name+"%";
		zhaobiaore =StringUtils.isBlank(zhaobiaore)?"%%":"%"+zhaobiaore+"%";
		if(StringUtils.isBlank(project_name)&&StringUtils.isBlank(zhaobiaore)){
			repository.findSearchAll(pageable);
		}else if(StringUtils.isNotBlank(project_name)&&StringUtils.isBlank(zhaobiaore)){
			repository.findSearchProject_name(project_name, pageable);
		}else if(StringUtils.isBlank(project_name)&&StringUtils.isNotBlank(zhaobiaore)){
			return repository.findSearchZhaobiaoren(zhaobiaore, pageable);
		}
		return repository.findSearch(project_name,zhaobiaore,pageable);
	}

	@Override
	@Transactional(readOnly = true)
//	@Cacheable("zhongbiaogg")
	public String findOneMonth(List<String> dateliststr, String dateFrom,String dateNow) {
		String sql="select  to_char(udate,'YYYY/MM/DD'),nvl(count(*),0)  "
				+ "from zhongbiaogg  p "
				+ "where p.udate>= to_date('"+dateFrom+"','yyyy/mm/dd')  and p.udate<= to_date('"+dateNow+"','yyyy/mm/dd')  "
				+ "group by to_char(udate,'YYYY/MM/DD') " ;
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
	public Page<Zhongbiaogg> findWash(String project_name, String zhaobiaore,Pageable pageable) {
		return repository.findWash(project_name, zhaobiaore, pageable);
	}
	
	@Override
	public List<Object> findDatas(String begindate, String enddate ) {
		StringBuilder sqlBuilder = new StringBuilder(" select * from (select  first_candidate,count(1),create_date from Zhongbiaogg tb");
		String end =   " group by first_candidate,create_date  order by count(1) desc  ) tb  where rownum < 21 and tb.first_candidate is not null and length(tb.first_candidate) > 2";
		String sql = null;			
		if(begindate!=null){
			sqlBuilder.append(" where ");
			sqlBuilder.append(" to_char(tb.gg_update,'yyyy-mm-dd') >= " +"'"+begindate+"'");
			if( enddate!=null){
				sqlBuilder.append(" and to_char(tb.gg_update,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
		}
		if(begindate==null&&enddate!=null){
			sqlBuilder.append(" where ");
			sqlBuilder.append(" to_char(tb.gg_update,'yyyy-mm-dd') <= " +"'"+enddate+"'");
		}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}

	@Override
	public Page<Zhongbiaogg> findList(String corpname,Pageable pageable) {
		return repository.findList(corpname, pageable);
	}


}
