package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Corpgoodinfo;

public interface CorpgoodinfoService extends BaseService<Corpgoodinfo, String> {

	List<Object> findDatas(String type, String begindate, String enddate);

	Page<Corpgoodinfo> findList(String datatype, String corpname, Pageable pageable);


}
