package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Dishonestman;

public interface DishonestManRepository extends
		PagingAndSortingRepository<Dishonestman, String> {


	@Query(value = "select d from Dishonestman d where d.name like ?1  and d.industry like ?2 and d.state='1' order by d.releasetime desc")
	public Page<Dishonestman> findSearch(String disman_name,String industry, Pageable pageable);
	
	@Query(value = "select d from Dishonestman d where d.corp_name like ?1  and d.industry like ?2 and (d.state ='0' or d.state is null) order by d.create_date desc")
	public Page<Dishonestman> findWash(String corp_name,String industry, Pageable pageable);
	
	@Query(value = "select to_char(releasetime,'yyyy') ,count(*) from (select * from Dishonestman where state='1') group by to_char(releasetime,'yyyy') order by to_char(releasetime,'yyyy')",nativeQuery = true)
	public List<Object[]> stat();

	/**
	 * @return
	 */
	@Query(value = "select count(*) from Dishonestman j where   j.state='1' ")
	public Long countCaixin();
	
	@Query(value = "select j from Dishonestman j where j.corp_name like ?1 order by j.create_date desc ")
	public Page<Dishonestman> findList(String corpname, Pageable pageable);

	
	
}
