package com.centit.hlwyw.inner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Perbadinfo;

public interface PerbadinfoService extends BaseService<Perbadinfo, String> {

	Page<Perbadinfo> findSearch(String name,String type, String source, Pageable pageable);

}
