package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Service_complaint;

public interface Service_complaintRepository extends PagingAndSortingRepository<Service_complaint, String> {
	
	@Query(value = "select s from Service_complaint s where s.corp_name like ?1  and s.vehicle_no like ?2  order by s.event_time desc")
	public Page<Service_complaint> findList(String corp_name, String vehicle_no,Pageable pageable);
	
	@Query(value = "select s from Service_complaint s where s.corp_name like ?1  and s.vehicle_no like ?2 and (s.state ='0' or s.state is null) order by s.event_time desc")
	public Page<Service_complaint> findWash(String corp_name, String vehicle_no,Pageable pageable);
	
	@Query(value = "select to_char(event_time,'yyyy') ,count(*) from (select * from Service_complaint  ) group by to_char(event_time,'yyyy') order by to_char(event_time,'yyyy')",nativeQuery = true)
	public List<Object[]> stat();

	/**
	 * @return
	 */
	@Query(value = "select count(*) from Service_complaint j  ")
	public Long countCaixin();
	
	@Query(value = "select z from Service_complaint z where z.corp_name like ?1  order by z.event_time desc")
	public Page<Service_complaint> findList(String corpname, Pageable pageable);
	
	
}
