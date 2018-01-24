package com.centit.hlwyw.inner.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Corpinfo;

public interface CorpinfoService extends BaseService<Corpinfo, String> {

	List<Corpinfo> findCorpinfo(Pageable pageable);

 
	public List<Corpinfo> findAllUnTag(String istag);

	Page<Corpinfo> findSearch(String corp_name, String corp_short, String industry, Pageable pageable);
	
	public List<Object[]> findList(String corp_name,String corp_short,String industry);

}
