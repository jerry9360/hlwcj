package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Hnii_alarm_service;
public interface Hnii_alarm_serviceRepository extends PagingAndSortingRepository<Hnii_alarm_service, String> {
	
	@Query(value = "select distinct to_char(calltime,'yyyy') from alarm",nativeQuery = true)
	public List<String> getYears();
	
	@Query(value = "select count(*),to_char(calltime,'yyyy') from alarm  group by to_char(calltime,'yyyy') order by to_char(calltime,'yyyy')",nativeQuery = true)
	public List<Object[]> statByYear();
	
	@Query(value = "select count(*) from alarm where to_char(calltime,'yyyy')=?1 ",nativeQuery = true)
	public String sumByYear(String year);

}
