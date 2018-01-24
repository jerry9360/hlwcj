package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Judgedoc;

public interface JudgeDocRepository extends
		PagingAndSortingRepository<Judgedoc, String> {

	@Query(value = "select j from Judgedoc j where j.corp_name like ?1 and j.industry like ?2 and j.state = '1' ")
	public Page<Judgedoc> findSearch(String corp_name,String industry, Pageable pageable);
	
	@Query(value = "select j from Judgedoc j where j.state = '1' ")
	public Page<Judgedoc> findSearchAll( Pageable pageable);
	
	@Query(value = "select j from Judgedoc j where j.corp_name like ?1  and j.state = '1' ")
	public Page<Judgedoc> findSearchCorp_name(String corp_name, Pageable pageable);
	
	@Query(value = "select j from Judgedoc j where j.industry like ?1 and j.state = '1' ")
	public Page<Judgedoc> findSearchIndustry(String industry, Pageable pageable);
	
	@Query(value = "select j from Judgedoc j where j.corp_name like ?1 and j.industry like ?2 and (j.state ='0' or j.state is null) ")
	public Page<Judgedoc> findWash(String corp_name,String industry, Pageable pageable);
	
	
	@Query(value = "select j from Judgedoc j where j.state ='0'")
	public List<Judgedoc> findListAll();
	
	@Query(value = "select HIDCASETYPE,count(*) from (select * from JudgeDoc where HIDCASETYPE is not null and state='1' ) group by HIDCASETYPE order by HIDCASETYPE asc",nativeQuery = true)
	public List<Object[]> statByType();

	/**
	 * @param judgeDocHidcasetypeXingshi
	 * @return
	 */
	@Query(value = "select count(*) from Judgedoc j where j.hidcasetype = ?1 and j.state='1' ")
	public Long countByHidcasetypeCaixin(String hidcasetype);
	
	@Query(value = "select j from Judgedoc j where j.corp_name like ?1 ")
	public Page<Judgedoc> findList(String corpname, Pageable pageable);

	
	/**
	 * @return
	 */
	@Query(value = "select count(*) from Judgedoc j  where j.state='1' ")
	public Long countJudgedoc();
	
}
