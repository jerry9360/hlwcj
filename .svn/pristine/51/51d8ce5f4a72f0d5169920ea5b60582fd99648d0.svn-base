package com.centit.hlwyw.inner.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Logcollect;

public interface LogcollectService extends BaseService<Logcollect, String> {
 

	/**
	 * @param datelist
	 * @param begindate
	 * @param enddate
	 * @param loglist
	 * @return
	 */
	Map<String, Map<String, Long>> getTableMapGroup(List<String> datelist,
			Date begindate, Date enddate, List<Object[]> loglist);

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
