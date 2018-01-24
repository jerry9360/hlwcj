package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Organinfo;

public interface OrganinfoRepository extends PagingAndSortingRepository<Organinfo, String> {
	
	public Page<Organinfo> findByOrgnameLikeOrderByCreatedateDesc(String name,Pageable pageable);
	
}
