package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Corpgoodinfo;

public interface CorpgoodinfoRepository extends PagingAndSortingRepository<Corpgoodinfo, String> {

	/**
	 * @param corpgoodinfoTypeBiaozhang
	 * @return
	 */
	@Query(value = "select count(*) from Corpgoodinfo j where j.type = ?1   ")
	Long countByTypeCaixin(String Type);
	
	@Query(value = "select j from Corpgoodinfo j where j.type like ?1 and j.corp_name like ?2  ")
	public Page<Corpgoodinfo> findList(String datatype,String corpname, Pageable pageable);

	
}
