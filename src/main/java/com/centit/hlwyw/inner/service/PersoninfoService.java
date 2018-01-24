package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Personinfo;

public interface PersoninfoService extends BaseService<Personinfo, String>{

	public List<Personinfo> findPersoninfo(Pageable pageable);

	public Page<Personinfo> findSearchname(String name,String card_no,String industry,Pageable pageable);

	public List<Personinfo> findPersoninfoUnTag(String istag);

	public List<Object[]> findList(String name,String cardno,String industry);
}
