package com.centit.hlwyw.inner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Servicedata;

public interface ServicedataRepository extends PagingAndSortingRepository<Servicedata, String> {

 	@Query(value="select p from Servicedata p where p.state = '1' and p.type like ?1 and p.source like ?2 order by p.create_date,p.issuedate desc")
	public Page<Servicedata> findPageByTypeSource(String type, String source, Pageable pageable);
 	
 	@Query(value="select p from Servicedata p where p.state = '1' and p.type like ?1 order by p.create_date,p.issuedate desc")
 	public Page<Servicedata> findPageByType(String type,  Pageable pageable);
 	
 	@Query(value="select p from Servicedata p where p.state = '1' and p.source like ?1 order by p.create_date,p.issuedate desc")
 	public Page<Servicedata> findPageBySource(String source, Pageable pageable);
 	
 	@Query(value="select p from Servicedata p where p.state = '1' order by p.create_date,p.issuedate desc")
 	public Page<Servicedata> findPage(Pageable pageable);
 	
 	@Query(value="select p from Servicedata p where p.state is null and p.type like ?1 and p.source like ?2 order by p.create_date,p.issuedate desc")
	public Page<Servicedata> findCPageByTypeSource(String type, String source, Pageable pageable);
 	
 	@Query(value="select p from Servicedata p where p.state is null and p.type like ?1 order by p.create_date,p.issuedate desc")
 	public Page<Servicedata> findCPageByType(String type,  Pageable pageable);
 	
 	@Query(value="select p from Servicedata p where p.state is null and p.source like ?1 order by p.create_date,p.issuedate desc")
 	public Page<Servicedata> findCPageBySource(String source, Pageable pageable);
 	
 	@Query(value="select p from Servicedata p where p.state is null order by p.create_date,p.issuedate desc")
 	public Page<Servicedata> findCPage(Pageable pageable);
	
}
