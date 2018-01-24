package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Crawlerconfig;


public interface CrawlerconfigRepository extends PagingAndSortingRepository<Crawlerconfig, String>{

	@Query(value="select c from Crawlerconfig c  ")
	List<Crawlerconfig> find();
	
}
