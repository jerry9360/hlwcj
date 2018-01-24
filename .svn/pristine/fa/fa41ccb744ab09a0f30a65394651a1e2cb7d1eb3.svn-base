package com.centit.hlwyw.inner.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Corpgood_badinfo;

public interface Corpgood_badinfoRepository extends
		PagingAndSortingRepository<Corpgood_badinfo, String> {

//	@Query(value = "select c from Corpgood_badinfo c where c.state = '1' and c.corp_name like ?1 and c.type like ?2  and c.source like ?3 order by c.create_date desc")
    /**状态为已清理不再作为查询条件  update by lsj 20170227 **/
	@Query(value = "select c from Corpgood_badinfo c where c.corp_name like ?1 and c.type like ?2  and c.source like ?3   order by c.create_date desc")
	public Page<Corpgood_badinfo> findSearch(String corp_name, String type,String source, Pageable pageable);
	
	@Query(value = "select c from Corpgood_badinfo c where c.corp_name like ?1 and c.type like ?2  and c.source like ?3 and (c.state ='0' or c.state is null) order by c.create_date desc")
	public Page<Corpgood_badinfo> findWash(String corp_name, String type,String source, Pageable pageable);
	
	@Query(value = "select c from Corpgood_badinfo c where c.state is null and c.corp_name like ?1 and c.type like ?2 order by c.create_date desc")
	public Page<Corpgood_badinfo> findClearSearch(String corp_name, String type,Pageable pageable);
	
	@Query(value = "select c from Corpgood_badinfo c where c.state is null and c.corp_name like ?1 and c.type like ?2 and c.source like ?3 order by c.create_date desc")
	public Page<Corpgood_badinfo> findClearSearch(String corp_name, String type,String source,Pageable pageable);
	
	@Query(value = "select c from Corpgood_badinfo c where c.state = ?1 and c.corp_name like ?2 and c.type like ?3 order by c.create_date desc")
	public Page<Corpgood_badinfo> findDearSearch(String state,String corp_name, String type,Pageable pageable);
	
	@Query(value = "select c from Corpgood_badinfo c where c.state = ?1 and c.corp_name like ?2 and c.type like ?3 and c.source like ?4 order by c.create_date desc")
	public Page<Corpgood_badinfo> findDearSearch(String state,String corp_name, String type,String source,Pageable pageable);
	

	@Query("select  c.create_date from Corpgood_badinfo c where c.create_date>=?1 and c.create_date<=?2 ")
	public List<Date> findOneDayCount(Date datestart, Date dateend);
	
	@Query(value = "select type,count(*) from (select * from Corpgood_badinfo where state='1') group by type",nativeQuery = true)
	public List<Object[]> stat();

}
