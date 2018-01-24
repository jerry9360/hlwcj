package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Hniidata_view;
public interface Hniidata_viewRepository extends PagingAndSortingRepository<Hniidata_view, String> {
	@Query(value = "select count(*) from Hniidata_view s where s.industry = ?1 ",nativeQuery = true)
	public String statByHangye(String hangye);
	
	@Query(value = "select count(*) from Hniidata_view s where s.industry = ?1 and s.dalei= ?2 ",nativeQuery = true)
	public String statByDalei(String hangye,String dalei);
	
	@Query(value = "select count(*) from Hniidata_view s where s.industry = ?1 and s.dalei= ?2 and s.xiaolei = ?3 ",nativeQuery = true)
	public String statByXiaolei(String hangye,String dalei,String xiaolei);
	
	@Query(value = "select count(*) from Hniidata_view s where  s.dalei= ?1 ",nativeQuery = true)
	public String statByDaleiOnly(String dalei);
	
	@Query(value = "select count(*) from Hniidata_view s where s.xiaolei = ?1 ",nativeQuery = true)
	public String statByXiaoleiOnly(String xiaolei);
	
	@Query(value = "select distinct years from Hniidata_view order by years",nativeQuery = true)
	public List<String> getYears();
	
	@Query(value = "select count(*),industry,years from (select * from Hniidata_view where industry is not null) group by industry,years  order by years",nativeQuery = true)
	public List<Object[]> statByIndustry();
	
	@Query(value = "select count(*),dalei,years from (select * from Hniidata_view where dalei is not null) group by dalei,years  order by years",nativeQuery = true)
	public List<Object[]> statByDalei();
	
	@Query(value = "select count(*),xiaolei,years,dalei from (select * from Hniidata_view where xiaolei is not null) group by xiaolei,years,dalei  order by years",nativeQuery = true)
	public List<Object[]> statByXiaolei();
	
	@Query(value = "select count(*) from Hniidata_view where industry = ?1 and years = ?2",nativeQuery = true)
	public String statByIndustryName(String industry,String years);
	
	@Query(value = "select count(*) from Hniidata_view where dalei = ?1 and years = ?2",nativeQuery = true)
	public String statByDaleiName(String dalei,String years);
	
	@Query(value = "select industry,count(*) from (select * from Hniidata_view where industry is not null) group by industry  order by industry desc",nativeQuery = true)
	public List<Object[]> statIndustry();
	
	@Query(value = "select dalei, count(*) from (select * from Hniidata_view where dalei is not null) group by dalei  order by dalei desc",nativeQuery = true)
	public List<Object[]> statDalei();
	
	@Query(value = "select xiaolei,count(*),dalei from (select * from Hniidata_view where xiaolei is not null) group by xiaolei,dalei order by dalei desc",nativeQuery = true)
	public List<Object[]> statXiaolei();
	
	@Query(value = "select years,count(*) from Hniidata_view  group by years order by years",nativeQuery = true)
	public List<Object[]> statByYear();
	
	
	
	
}
