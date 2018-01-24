package com.centit.hlwyw.inner.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.centit.hlwyw.inner.entity.Service_interface;

public interface Service_interfaceRepository extends PagingAndSortingRepository<Service_interface, String>{

	@Query(value = "select s from Service_interface s where s.interface_name like ?1 " )
	public List<Service_interface> findByName(String interface_name);


}
