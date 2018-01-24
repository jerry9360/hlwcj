package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Perbadinfo;

public interface PerbadinfoRepository extends PagingAndSortingRepository<Perbadinfo, String> {

	@Query(value="select p from Perbadinfo p where p.isvalid='Y' and p.name like ?1 and p.type like ?2 and p.source like ?3 order by p.create_date desc")
	Page<Perbadinfo> findSearch(String name,String type, String source,Pageable pageable);
	
}
