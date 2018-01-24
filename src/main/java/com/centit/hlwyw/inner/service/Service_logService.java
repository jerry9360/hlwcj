package com.centit.hlwyw.inner.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Service_log;

public interface Service_logService extends BaseService<Service_log, String>{
	

	
	
	
	Map<String, Map<String, Long>> getTableMapGroup(List<String> datelist,
			Date begindate, Date enddate, List<Object[]> serviceloglist);

	/**
	 * @param datelist
	 * @param map
	 * @return
	 */
	Object[] getChartData(List<String> datelist,
			Map<String, Map<String, Long>> map);

 
	/**
	 * @param searchtypesub
	 * @param begindate
	 * @param enddate
	 * @return
	 */
	List<Object[]> findGroupByDateMonthYear(String searchtypesub,
			Date begindate, Date enddate);
  

}
