package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Personinfo;

public interface PersoninfoRepository extends PagingAndSortingRepository<Personinfo, String> {

	@Query("select p from Personinfo p order by p.create_date desc ")
	public List<Personinfo> findPersoninfo(Pageable pageable);

	@Query(value="select p from Personinfo p where p.name like ?1 and p.card_no like?2 and p.industry = ?3 order by p.create_date desc ")
    Page<Personinfo> findSearchname(String name,String card_no,String industry,Pageable pageable);
	
	@Query(value="select p from Personinfo p where p.name like ?1 and p.card_no like?2 order by p.create_date desc ")
    Page<Personinfo> findSearchname(String name,String card_no,Pageable pageable);
	
	@Query("select p from Personinfo p where p.istag != ?1 or p.istag is null")
	public List<Personinfo> findPersoninfoUnTag(String istag);

	/**
	 * @return
	 */	
	@Query(value = "select count(*) from Personinfo j   ")
	public Long countCaixin();
	
}
