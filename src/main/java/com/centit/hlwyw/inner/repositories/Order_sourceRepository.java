package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Order_source;

public interface Order_sourceRepository extends
		PagingAndSortingRepository<Order_source, String> {

	@Query(value = "select u from Order_source u where u.isvalid != 'N' order by u.modifyDate desc")
	public Page<Order_source> findPage(Pageable pageable);

	@Query(value = "select u from Order_source u where u.webname like ?1 and u.isvalid != 'N' order by u.modifyDate desc")
	public Page<Order_source> findSearchname(String webname, Pageable pageable);
	
	@Query(value = "update Order_source u set u.isvalid = 'N' where u.id = ?1",nativeQuery=true)
	@Modifying
	public void deleteUrl(String id);
}
