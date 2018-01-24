package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Zhongbiaogg;

public interface ZhongbiaoggRepository extends
		PagingAndSortingRepository<Zhongbiaogg, String> {

	@Query(value = "select z from Zhongbiaogg z where z.project_name like ?1 and z.zhaobiaoren like ?2  ")
	public Page<Zhongbiaogg> findSearch(String project_name, String zhaobiaore, Pageable pageable);
	
	@Query(value = "select z from Zhongbiaogg z  ")
	public Page<Zhongbiaogg> findSearchAll(Pageable pageable);
	
	@Query(value = "select z from Zhongbiaogg z where z.project_name like ?1   ")
	public Page<Zhongbiaogg> findSearchProject_name(String project_name, Pageable pageable);
	
	@Query(value = "select z from Zhongbiaogg z where z.zhaobiaoren like ?1  ")
	public Page<Zhongbiaogg> findSearchZhaobiaoren(String zhaobiaore, Pageable pageable);
	
	@Query(value = "select z from Zhongbiaogg z where z.project_name like ?1 and z.zhaobiaoren like ?2 and (z.state ='0' or z.state is null) order by z.web_update desc")
	public Page<Zhongbiaogg> findWash(String project_name, String zhaobiaore,Pageable pageable);

	/**
	 * @return
	 */
	@Query(value = "select count(*) from Zhongbiaogg j   ")
	public Long countCaixin();
	
	@Query(value = "select z from Zhongbiaogg z where z.first_candidate like ?1  order by z.gg_update desc")
	public Page<Zhongbiaogg> findList(String corpname, Pageable pageable);
	
	
}
