package com.centit.hlwyw.solr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.centit.hlwyw.inner.entity.Hnii_analyze_data;


public interface HniianalyzedataSolrRepository  extends SolrCrudRepository<Hnii_analyze_data, String> {
	
	/**
	 * @param searchTerm
	 * @param pageable
	 * @return
	 */
	@Query("?0")
	public Page<Hnii_analyze_data> find(String searchTerm,Pageable pageable);
	
	@Query("?0")
	public Hnii_analyze_data find(String searchTerm);
	
	
 

}
