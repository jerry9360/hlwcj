package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Corpbadinfo;

public interface CorpbadinfoRepository extends PagingAndSortingRepository<Corpbadinfo, String> {

	/**
	 * @return
	 */
	@Query(value = "select count(*) from Corpbadinfo j   ")
	public Long countCaixin();
	
	@Query(value = "select j from Corpbadinfo j where j.corp_name like ?1 ")
	public Page<Corpbadinfo> findList(String corpname, Pageable pageable);
	
	
}
