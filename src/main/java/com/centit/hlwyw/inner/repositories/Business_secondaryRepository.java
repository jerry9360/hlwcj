package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Business_secondary;

public interface Business_secondaryRepository extends PagingAndSortingRepository<Business_secondary, String>{

	
	@Query("select t from Business_secondary t where t.root_id = ?1 order by t.modify_date desc")
	public Page<Business_secondary> findByRoot_id(String root_id,Pageable pageable);

	@Query("select t from Business_secondary t where t.root_id = ?1 order by t.modify_date desc")
	public List<Business_secondary> findAllDelete(String root_id);
	@Modifying(clearAutomatically = true)
	@Query(value = "update Business_secondary  t set t.types  =?2 where t.root_id  = ?1",nativeQuery = true)
	int updateByIndustry_id(String root_id, String business_name);
	
	@Query("select t from Business_secondary t where t.industry like ?1 order by t.modify_date desc")
	public Page<Business_secondary> findByIndustry(String industry,Pageable pageable);
	
	@Query("select t from Business_secondary t where t.root_id = ?1")
	public List<Business_secondary> findByRootid(String root_id);
}
