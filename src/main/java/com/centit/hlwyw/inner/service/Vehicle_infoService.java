package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.inner.entity.Vehicle_info;

public interface Vehicle_infoService extends com.centit.hlwyw.core.service.BaseService<Vehicle_info, String> {

	/**
	 * @param vehicle_no
	 * @param corp_name
	 * @param pageable
	 * @return
	 */
	Page<Vehicle_info> findSearch(String vehicle_no, String corp_name,
			Pageable pageable);

	/**
	 * @param corp_name
	 * @return
	 */
	List<Object[]> findExcelList(String corp_name);

}
