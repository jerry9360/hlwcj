package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Taglib;

public interface TaglibRepository extends PagingAndSortingRepository<Taglib, String> {
	
	@Query("select t from Taglib t where t.name like ?1 order by t.modify_date desc")
	public Page<Taglib> findAllTags(String name,Pageable pageable);
}
