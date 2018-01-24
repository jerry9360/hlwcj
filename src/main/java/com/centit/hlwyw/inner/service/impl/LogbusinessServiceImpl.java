package com.centit.hlwyw.inner.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Logbusiness;
import com.centit.hlwyw.inner.repositories.LogbusinessRepository;
import com.centit.hlwyw.inner.service.LogbusinessService;

@Service("logbusinessServiceImpl")
public class LogbusinessServiceImpl extends BaseServiceImpl<Logbusiness, String>
		implements LogbusinessService {

	@Resource(name = "logbusinessRepository")
	private LogbusinessRepository repository;
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;


	@Resource(name = "logbusinessRepository")
	public void setReposity(
			PagingAndSortingRepository<Logbusiness, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
 	public Logbusiness find(String id) {
		return super.find(id);
	}

 
	@Override
	public List<Object[]> findGroupByDateMonthYear(String searchtypesub,Date begindate, Date enddate) {
		String format=null;
		if("day".equals(searchtypesub)){
			format="yyyy/mm/dd";
		}else if("month".equals(searchtypesub)){
			format="yyyy/mm";
 		}else if("year".equals(searchtypesub)){
			format="yyyy";
		}else{
			format="yyyy";
		}
			
			
		
		
		List<Object> values = new ArrayList<Object>();
		StringBuffer sqlb = new StringBuffer("select type,to_char(logdate, '"+format+"') as datestr,sum(num) from Logbusiness  ");
	 	String sql=null;
		if(!(begindate==null&& enddate==null )){
			sqlb.append(" where ");
			if(begindate!=null){
				sqlb.append("  logdate >= ? and");
				values.add(begindate);
			}
			if(enddate!=null){
				sqlb.append("  logdate <= ? and");
				values.add(enddate);
			}

			sql=sqlb.toString();
			sql=sql.substring(0, sql.length()-3);
		}else{
			sql=sqlb.toString();
		}
		String order = "  group by type,to_char(logdate, '"+format+"') order by datestr asc ";
		sql=sql+order;
		List<Object[]> rst = queryService.query(sql, values);
		return rst;
	}


 
 
}
