package com.centit.hlwyw.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QueryService {
	
	public List<Object> queryForObject(String sql,List<Object> values);
	
	public List<Object[]> query(String sql,List<Object> values);
	
	public Object queryObject(String sql);
	
	public List<Object> queryObjectBySql(String sql);
	
	public Integer executeSql(String sql);
	
	
	public Page<Object> queryObjectForPage(String columnsql,String sql,String order,List<Object> values,Pageable pageable);
	
	public Page<Object> queryForPage(String sql, String order,List<Object> values,Class<?> cla,Pageable pageable);
	
	
}
