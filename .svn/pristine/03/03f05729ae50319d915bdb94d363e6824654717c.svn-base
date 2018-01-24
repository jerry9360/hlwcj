package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Hniiservicedata;

public interface HniiservicedataRepository extends PagingAndSortingRepository<Hniiservicedata, String> {
 
	@Query("select h from Hniiservicedata h where h.ctype = ?1 and h.service = ?2 and h.type = ?3 and h.unit like ?4 and h.cnum like ?5 order by h.modify_date desc")
	Page<Hniiservicedata> findPageCtypeServiceTypeUnitCnum(String ctype,String service, String type, String unit,String cnum, Pageable pageable);
 	@Query("select h from Hniiservicedata h where h.ctype = ?1 and h.service = ?2 and h.type = ?3 and h.unit like ?4 order by h.modify_date desc")
	Page<Hniiservicedata> findPageCtypeServiceTypeUnit(String ctype,String service, String type, String unit, Pageable pageable);
 	 	
 	@Query("select h from Hniiservicedata h where h.ctype = ?1 and h.service = ?2 and h.type = ?3 and h.cnum like ?4 order by h.modify_date desc")
	Page<Hniiservicedata> findPageCtypeServiceTypeCnum(String ctype,String service, String type,String cnum, Pageable pageable);
 	@Query("select h from Hniiservicedata h where h.ctype = ?1 and h.service = ?2 and h.type = ?3 order by h.myid desc")
	Page<Hniiservicedata> findPageCtypeServiceType(String ctype,String service, String type, Pageable pageable);
 	
 	@Query("select h from Hniiservicedata h where h.ctype = ?1 and h.service = ?2 and h.unit like ?3 and h.cnum like ?4 order by h.modify_date desc")
	Page<Hniiservicedata> findPageCtypeServiceUnitCnum(String ctype,String service, String unit, String cnum, Pageable pageable);
 	@Query("select h from Hniiservicedata h where h.ctype = ?1 and h.service = ?2 and h.unit like ?3 order by h.modify_date desc")
	Page<Hniiservicedata> findPageCtypeServiceUnit(String ctype,String service, String unit, Pageable pageable);
 
	@Query("select h from Hniiservicedata h where h.ctype = ?1 and h.service = ?2 and h.cnum like ?3 order by h.modify_date desc")
	Page<Hniiservicedata> findPageCtypeServiceCnum(String ctype, String service, String cnum, Pageable pageable);
	@Query("select h from Hniiservicedata h where h.ctype = ?1 and h.service = ?2 order by h.modify_date desc")
	Page<Hniiservicedata> findPageCtypeService(String ctype, String service,Pageable pageable);
	
	@Query("select h from Hniiservicedata h where h.ctype =?1 and h.service = ?2 and h.type = ?3 order by h.time desc")
	List<Hniiservicedata> findTaxiComplaintAll(String ctypecode,String servicecode,String type);
}
