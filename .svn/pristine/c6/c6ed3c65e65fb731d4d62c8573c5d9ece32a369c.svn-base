package com.centit.hlwyw.inner.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Zhaobiaogg;

public interface ZhaobiaoggRepository extends
		PagingAndSortingRepository<Zhaobiaogg, String> {

	@Query(value = "select z from Zhaobiaogg z where z.project_name like ?1 and z.zhaobiaoren like ?2  ")
	public Page<Zhaobiaogg> findSearch(String project_name, String zhaobiaore, Pageable pageable);
	
	@Query(value = "select z from Zhaobiaogg z  ")
	public Page<Zhaobiaogg> findSearchAll(Pageable pageable);
	
	@Query(value = "select z from Zhaobiaogg z where z.project_name like ?1   ")
	public Page<Zhaobiaogg> findSearchProject_name(String project_name, Pageable pageable);
	
	@Query(value = "select z from Zhaobiaogg z where z.zhaobiaoren like ?1 ")
	public Page<Zhaobiaogg> findSearchZhaobiaoren(String zhaobiaore, Pageable pageable);
	
	@Query(value = "select z from Zhaobiaogg z where z.project_name like ?1 and z.zhaobiaoren like ?2 and (z.state ='0' or z.state is null) order by z.web_update desc")
	public Page<Zhaobiaogg> findWash(String project_name, String zhaobiaore, Pageable pageable);

	/**
	 * @return
	 */
	@Query(value = "select count(*) from Zhaobiaogg j   ")
	public Long countCaixin();
	
	@Query(value = "select z from Zhaobiaogg z where z.zhaobiaoren like ?1  order by z.gg_update desc")
	public Page<Zhaobiaogg> findList(String corpname, Pageable pageable);

}
