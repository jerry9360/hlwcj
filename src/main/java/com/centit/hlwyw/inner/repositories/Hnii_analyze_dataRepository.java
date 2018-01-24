package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Hnii_analyze_data;

public interface Hnii_analyze_dataRepository extends PagingAndSortingRepository<Hnii_analyze_data, String> {
	
	
	@Query(value = "select * from (select a1.*,rownum rn from (select tbl.myid,tbl.btype,tbl.stype,tbl.industry,tbl.object,tbl.objectname,tbl.carno,tbl.lineno,tbl.time,tbl.baddress,tbl.eaddress,"
			+ "tbl.content,tbl.unit,tbl.dealopinion,tbl.calltime from Hnii_analyze_data tbl where tbl.btype like ?1 and tbl.stype like ?2 and tbl.industry like ?3 "
			+ "and tbl.content like ?4) a1  where rownum <= ?5)  where rn > ?6",nativeQuery = true)
	public List<Object> findDatasList(String btype, String stype,String industry, String content,Long upper,Long downner);
	
	@Query(value = "select to_char(calltime,'yyyy') from Hnii_analyze_data  group by to_char(calltime,'yyyy') order by to_char(calltime,'yyyy') desc",nativeQuery = true)
	public List<Object[]> findYears();

	/**
	 * @return
	 */
	@Query(value = "select count(*) from Hnii_analyze_data j ")
	public Long countByIndustryCaixin(String industry);
	
	@Query(value = "select count(industry),industry from hnii_analyze_data group by  industry ",nativeQuery = true)
	public List<Object[]> countHniiindustry();
	@Query(value = "select count(btype),btype from hnii_analyze_data group by  btype ",nativeQuery = true)
	public List<Object[]> countHniibtype();
	
	@Query(value = " select h  from Hnii_analyze_data h   where h.baddress  = ?1 order by h.create_date desc " )
	public Page<Hnii_analyze_data> findList(String baddress, Pageable pageable);
	
	@Query(value = " select h  from Hnii_analyze_data h   where h.carno  = ?1 order by h.create_date desc " )
	public Page<Hnii_analyze_data> findCarNoList(String carno, Pageable pageable);
	
	
	
}
