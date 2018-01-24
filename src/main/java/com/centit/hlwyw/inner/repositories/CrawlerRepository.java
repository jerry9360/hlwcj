package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Crawler;

public interface CrawlerRepository extends PagingAndSortingRepository<Crawler, String> {
	
	@Query("select c from Crawler c where c.name like ?1 order by c.modify_date desc")
	public Page<Crawler> findByName(String name,Pageable pageable);
	
	@Query(value="update Crawler c set c.isrun = '0'",nativeQuery=true)
	@Modifying
	public void closeAllCrawlers();
}
