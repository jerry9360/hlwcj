package com.centit.hlwyw.inner.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Collectlist;
import com.centit.hlwyw.inner.entity.Service_interface;
import com.centit.hlwyw.inner.repositories.Service_interfaceRepository;
import com.centit.hlwyw.inner.service.Service_interfaceService;
 
@Service("service_interfaceServiceImpl")
public class Service_interfaceServiceImpl extends BaseServiceImpl<Service_interface, String>implements Service_interfaceService {

	@Resource(name="service_interfaceRepository")
	private Service_interfaceRepository repository;
	
	 
	@Resource(name = "service_interfaceRepository")
	public void setReposity(
			PagingAndSortingRepository<Service_interface, String> repository) {
		super.setReposity(repository);
	}

	
	@Override

	public Service_interface find(String id) {
		return super.find(id);
	}

	@Override
	
	public List<Service_interface> findAll() {
		return super.findAll();
	}

	@Override
	public List<Service_interface> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	public List<Service_interface> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	public Page<Service_interface> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}


	@Override
	
	public void save(Service_interface entity) {
		super.save(entity);
	}

	@Override

	public Service_interface update(Service_interface entity) {
		Service_interface service_interface = super.find(entity.getId());
		super.update(entity);
		return service_interface;
	}


	@Override
	public void delete(String id) {
		super.delete(id);
	}

	@Override

	public void delete(String[] ids) {
		super.delete(ids);
	}

	@Override
	public void delete(Service_interface entity) {
		super.delete(entity);
	}
	


	@Override
	public List<Service_interface> findByName(String interface_name) {
		return repository.findByName(interface_name);
	}

}
