package com.centit.hlwyw.inner.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Logsave;
import com.centit.hlwyw.inner.repositories.LogsaveRepository;
import com.centit.hlwyw.inner.service.LogsaveService;

@Service("logsaveServiceImpl")
public class LogsaveServiceImpl extends BaseServiceImpl<Logsave, String>
		implements LogsaveService {

	@Resource(name = "logsaveRepository")
	private LogsaveRepository repository;
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;


	@Resource(name = "logsaveRepository")
	public void setReposity(
			PagingAndSortingRepository<Logsave, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
 	public Logsave find(String id) {
		return super.find(id);
	}
 
	@Override
	public List<Object[]> findGroupByDateMonthYear(String searchtypesub,Date begindate, Date enddate) {
		String format=null;
 
		if("day".equals(searchtypesub)){
			format="yyyy/mm/dd";
			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(enddate); 
			endCalendar.add(Calendar.DATE, 1);
			enddate=endCalendar.getTime();
		}else if("month".equals(searchtypesub)){
			format="yyyy/mm";
			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(enddate); 
			endCalendar.add(Calendar.MONTH, 1);
			enddate=endCalendar.getTime();
 		}else if("year".equals(searchtypesub)){
			format="yyyy";
			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(enddate); 
			endCalendar.add(Calendar.YEAR, 1);
			enddate=endCalendar.getTime();
		}else{
			format="yyyy";
			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(enddate); 
			endCalendar.add(Calendar.YEAR, 1);
			enddate=endCalendar.getTime();
		}
			
		
		
		List<Object> values = new ArrayList<Object>();
		StringBuffer sqlb = new StringBuffer("select type,to_char(logdate, '"+format+"') as datestr,sum(num) from Logsave  ");
	 	String sql=null;
		if(!(begindate==null&& enddate==null )){
			sqlb.append(" where ");
			if(begindate!=null){
				sqlb.append("  logdate >= ? and");
				values.add(begindate);
			}
			if(enddate!=null){
				sqlb.append("  logdate < ? and");
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
