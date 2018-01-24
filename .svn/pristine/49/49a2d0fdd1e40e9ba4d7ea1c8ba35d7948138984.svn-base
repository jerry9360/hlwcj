package com.centit.hlwyw.inner.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.inner.entity.Vehicle_info;

public interface Vehicle_infoRepository extends PagingAndSortingRepository<Vehicle_info, String> {

	/**
	 * @param string
	 * @param string2
	 * @param pageable
	 * @return
	 */
	@Query(value = "select c from Vehicle_info c where c.vehicle_no like ?1 and c.corp_name like ?2 ")
	Page<Vehicle_info> findPageByVehicle_noCorp_name(String vehicle_no, String corp_name,Pageable pageable);

	/**
	 * @param string
	 * @param pageable
	 * @return
	 */
	@Query(value = "select c from Vehicle_info c where c.vehicle_no like ?1 ")
	Page<Vehicle_info> findPageByvehicle_no(String vehicle_no, Pageable pageable);

	/**
	 * @param string
	 * @param pageable
	 * @return
	 */
	@Query(value = "select c from Vehicle_info c where  c.corp_name like ?1 ")
	Page<Vehicle_info> findPageBycorp_name(String corp_name, Pageable pageable);

	/**
	 * @param pageable
	 * @return
	 */
	@Query(value = "select c from Vehicle_info c  ")
	Page<Vehicle_info> findPageAll(Pageable pageable);

	 
	
}
