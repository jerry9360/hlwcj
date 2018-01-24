package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Business_root;

public interface Business_rootRepository extends PagingAndSortingRepository<Business_root, String>{
	
 

	@Query("select t from Business_root t where t.industry_id = ?1 order by t.modify_date desc")
	public Page<Business_root> findById(String industry_id,Pageable pageable);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update Business_root t set t.types  =?2 where t.industry_id  = ?1",nativeQuery = true)
	public int updateByIndustry_id(String industry_id, String industry_name);
	
	@Query("select t from Business_root t where t.business_name like ?1 order by t.modify_date desc")
	public Page<Business_root> findByBusinessName(String business_name,Pageable pageable);
	
	@Query("select t from Business_root t")
	public List<Business_root> findListAll();
	
}
