package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Corpinfo;

public interface CorpinfoRepository extends
		PagingAndSortingRepository<Corpinfo, String> {

	@Query("select c from Corpinfo c order by c.create_date desc ")
	public List<Corpinfo> findCorpinfo(Pageable pageable);

	@Query(value = "select c from Corpinfo c where c.corp_name like ?1 and c.corp_short like ?2 order by c.create_date desc")
	Page<Corpinfo> findSearchname(String corp_name, String corp_short,
			Pageable pageable);

	@Query(value = "select c from Corpinfo c where c.corp_name like ?1 order by c.create_date desc")
	Page<Corpinfo> findSearchname(String corp_name, Pageable pageable);

	@Query("select c from Corpinfo c where c.istag != ?1")
	public List<Corpinfo> findAllUnTag(String istag);

	@Query(value = "select c from Corpinfo c where c.corp_name like ?1 and c.corp_short like ?2 and c.industry = ?3 order by c.create_date desc")
	public Page<Corpinfo> findPageByCorp_nameCorp_shortIndustry(
			String corp_name, String corp_short, String industry,
			Pageable pageable);

	@Query(value = "select c from Corpinfo c where c.corp_name like ?1 and c.corp_short like ?2  order by c.create_date desc")
	public Page<Corpinfo> findPageByCorp_nameCorp_short(String corp_name,
			String corp_short, Pageable pageable);

	@Query(value = "select c from Corpinfo c where c.corp_name like ?1 and c.industry = ?2 order by c.create_date desc")
	public Page<Corpinfo> findPageByCorp_nameIndustry(String corp_name,
			String industry, Pageable pageable);

	@Query(value = "select c from Corpinfo c where c.corp_name like ?1 order by c.create_date desc")
	public Page<Corpinfo> findPageByCorp_name(String corp_name,
			Pageable pageable);

	@Query(value = "select c from Corpinfo c where c.corp_short like ?1 and c.industry = ?2 order by c.create_date desc")
	public Page<Corpinfo> findPageByCorp_shortIndustry(String corp_short,
			String industry, Pageable pageable);

	@Query(value = "select c from Corpinfo c where c.corp_short like ?1 order by c.create_date desc")
	public Page<Corpinfo> findPageByCorp_short(String corp_short,
			Pageable pageable);

	@Query(value = "select c from Corpinfo c where c.industry = ?1 order by c.create_date desc")
	public Page<Corpinfo> findPageByIndustry(String industry,
			Pageable pageable);

	@Query(value = "select c from Corpinfo c order by c.create_date desc")
	public Page<Corpinfo> findPage(Pageable pageable);

	/**
	 * @return
	 */
	@Query(value = "select count(*) from Corpinfo j  ")
	public Long countCaixin();
	

}
