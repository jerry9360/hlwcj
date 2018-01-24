package com.centit.hlwyw.solr.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.inner.entity.Hnii_analyze_data;
import com.centit.hlwyw.inner.entity.Servicedata;


public interface SolrService  {
	
	public Page<Servicedata> findServiceDataByField(String field,Pageable pageable);

	public Page<Hnii_analyze_data> findDatas(String btype, String stype, String industry, String content, Date begindate,
			Date enddate, Pageable pageable);

	public Hnii_analyze_data find(String id);


	public Page<Hnii_analyze_data> findKeyWord(String btype, String keyword, Pageable pageable);
	
}
