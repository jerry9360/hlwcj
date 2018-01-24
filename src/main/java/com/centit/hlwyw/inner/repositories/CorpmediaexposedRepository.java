package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Corpmediaexposed;

public interface CorpmediaexposedRepository extends
		PagingAndSortingRepository<Corpmediaexposed, String> {

	@Query(value = "select c from Corpmediaexposed c where c.corp_name like ?1 and c.industry like ?2 and c.state = '1' order by c.create_date desc")
	public Page<Corpmediaexposed> findSearch(String corp_name,String industry, Pageable pageable);
	
	@Query(value = "select c from Corpmediaexposed c where c.corp_name like ?1 and c.industry like ?2 and (c.state ='0' or c.state is null) order by c.create_date desc")
	public Page<Corpmediaexposed> findWash(String corp_name,String industry, Pageable pageable);
	
	@Query(value = "select to_char(issuedate,'yyyy') ,count(*) from (select * from Corpmediaexposed where state='1') group by to_char(issuedate,'yyyy') order by to_char(issuedate,'yyyy')",nativeQuery = true)
	public List<Object[]> stat();

}
