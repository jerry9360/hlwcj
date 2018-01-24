package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Jwdata;

public interface JwdataService extends BaseService<Jwdata, String> {

	public String findOneMonth(List<String> dateliststr, String dateFrom, String dateNow);

	public Page<Jwdata> findJwdataPage(String title, String source, Pageable pageable);

 
}
