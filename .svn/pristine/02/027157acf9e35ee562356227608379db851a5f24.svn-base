package com.centit.hlwyw.solr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.centit.hlwyw.inner.entity.Servicedata;


public interface ServicedataSolrRepository  extends SolrCrudRepository<Servicedata, String> {
	
	@Query("?0")
	public Page<Servicedata> find(String searchTerm,Pageable pageable);

}
