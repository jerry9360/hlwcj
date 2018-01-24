package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Corpbadinfo;

public interface CorpbadinfoService extends BaseService<Corpbadinfo, String> {

	List<Object> findDatas(String begindate, String enddate);

	Page<Corpbadinfo> findList(String corpname, Pageable pageable);

}
