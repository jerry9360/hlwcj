package com.centit.hlwyw.inner.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Jwdata;

public interface JwdataRepository extends
		PagingAndSortingRepository<Jwdata, String> {
	@Query("select  c.create_date from Jwdata c where c.create_date>=?1 and c.create_date<=?2 ")
	List<Date> findOneDayCount(Date datestart, Date dateend);

	// @Query("select  COUNT(c.create_date) from Jwdata c where c.create_date>=?1 and c.create_date<=?2 ORDER BY c.create_date asc group by convert(c.create_date,120) ")
	// Long[] findCountGroupByDay(Date dateFrom, Date dateNow);

	@Query("select c from Jwdata c where c.title like ?1 and c.source like ?2 order by c.create_date desc  ")
	Page<Jwdata> findPageTitleSource(String title, String source,
			Pageable pageable);

	@Query("select c from Jwdata c where c.title like ?1 order by c.create_date desc  ")
	Page<Jwdata> findPageTitle(String title, Pageable pageable);

	@Query("select c from Jwdata c where c.source like ?1 order by c.create_date desc  ")
	Page<Jwdata> findPageSource(String source, Pageable pageable);

	@Query("select c from Jwdata c order by c.create_date desc  ")
	Page<Jwdata> findPage(Pageable pageable);

}
