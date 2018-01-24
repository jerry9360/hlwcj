package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Public_prise;

public interface Public_priseRepository extends PagingAndSortingRepository<Public_prise, String> {
	
	@Query(value = "select p from Public_prise p where p.corp_name like ?1  and p.accept_num like ?2  order by p.prisetime desc")
	public Page<Public_prise> findList(String corp_name, String accept_num,Pageable pageable);
	
	@Query(value = "select p from Public_prise p where p.corp_name like ?1  and p.accept_num like ?2 and (p.state ='0' or p.state is null) order by p.prisetime desc")
	public Page<Public_prise> findWash(String corp_name, String accept_num,Pageable pageable);
	
	@Query(value = "select to_char(prisetime,'yyyy') ,count(*) from (select * from Public_prise  ) group by to_char(prisetime,'yyyy') order by to_char(prisetime,'yyyy')",nativeQuery = true)
	public List<Object[]> stat();

	/**
	 * @return
	 */
	@Query(value = "select count(*) from Public_prise j   ")
	public Long countCaixin();
	
	@Query(value = "select z from Public_prise z where z.corp_name like ?1  order by z.prisetime desc")
	public Page<Public_prise> findList(String corpname, Pageable pageable);

	
	
}
