package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.UrlSource;

public interface UrlSourceRepository extends
		PagingAndSortingRepository<UrlSource, String> {

	@Query(value = "select u from UrlSource u where u.isvalid != 'N' order by u.modifyDate desc")
	public Page<UrlSource> findPage(Pageable pageable);

	@Query(value = "select u from UrlSource u where u.webname like ?1 and u.isvalid != 'N' order by u.modifyDate desc")
	public Page<UrlSource> findSearchname(String webname, Pageable pageable);
	
	@Query(value = "update url_source u set u.isvalid = 'N' where u.id = ?1",nativeQuery=true)
	@Modifying
	public void deleteUrl(String id);
}
