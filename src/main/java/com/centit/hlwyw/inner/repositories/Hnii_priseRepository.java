package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Hnii_prise;

public interface Hnii_priseRepository extends PagingAndSortingRepository<Hnii_prise, String> {
	
	@Query(value = "select h from Hnii_prise h where h.industry like ?1  and h.servicetype like ?2 and h.content like ?3 order by h.create_date desc")
	public Page<Hnii_prise> findList(String industry, String servicetype,String content,Pageable pageable);
}
