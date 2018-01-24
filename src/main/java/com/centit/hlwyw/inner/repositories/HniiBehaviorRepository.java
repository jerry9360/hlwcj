package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.HniiBehavior;

 
public interface HniiBehaviorRepository  extends PagingAndSortingRepository<HniiBehavior, String>{

	
	@Query(value = "select *  from (select stype,sum(datasize) from hniibehavior  where btype = '投诉类'  group by stype order by count(1) desc  ) where  rownum < 11 and stype != '其它'",nativeQuery = true)
	public List<Object[]> findComplaint();
	
	@Query(value = "select *  from (select stype,sum(datasize) from hniibehavior   where btype = '咨询类'  group by stype order by count(1) desc  ) where  rownum < 11 and stype != '其它'",nativeQuery = true)
	public List<Object[]> findConsult();
}
