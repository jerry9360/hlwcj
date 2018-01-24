package com.centit.hlwyw.inner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Taglib;

public interface TaglibService extends BaseService<Taglib, String> {

	public Page<Taglib> findAllTags(String name,Pageable pageable);
}
