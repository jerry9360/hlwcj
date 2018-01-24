package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hniiservicedata;

public interface HniiservicedataService extends BaseService<Hniiservicedata, String> {

 
	Page<Hniiservicedata> findServicedataPage(String ctype, String service, String type, String unit, String cnum, Pageable pageable);


	List<Hniiservicedata> findTaxiComplaintAll(String ctypecode,String servicecode,String type);
}
