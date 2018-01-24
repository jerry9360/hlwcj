package com.centit.hlwyw.inner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Organinfo;

public interface OrganinfoService extends BaseService<Organinfo, String> {

	public Page<Organinfo> findAll(String name,Pageable pageable);
}
