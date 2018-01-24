package com.centit.hlwyw.inner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Hniiservicedata;
import com.centit.hlwyw.inner.repositories.HniiservicedataRepository;
import com.centit.hlwyw.inner.service.HniiservicedataService;

@Service("hniiservicedataServiceImpl")
public class HniiservicedataServiceImpl extends BaseServiceImpl<Hniiservicedata, String>
		implements HniiservicedataService {

	@Resource(name = "hniiservicedataRepository")
	private HniiservicedataRepository repository;


	@Resource(name = "hniiservicedataRepository")
	public void setReposity(
			PagingAndSortingRepository<Hniiservicedata, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Hniiservicedata find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hniiservicedata> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hniiservicedata> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hniiservicedata> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Hniiservicedata> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Hniiservicedata entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Hniiservicedata update(Hniiservicedata entity) {
		Hniiservicedata hniiservicedata = super.find(entity.getId());
		super.update(entity);
		return hniiservicedata;
	}

	@Override
	@Transactional
	public Hniiservicedata update(Hniiservicedata entity, String... ignoreProperties) {
		Hniiservicedata hniiservicedata = super.update(entity, ignoreProperties);
		return hniiservicedata;
	}

	@Override
	@Transactional
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	@Transactional
	public void delete(String[] ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	public void delete(Hniiservicedata entity) {
		super.delete(entity);
	}

	
	@Override
	public Page<Hniiservicedata> findServicedataPage(String ctype , String service , String type , String unit ,String cnum, Pageable pageable) {
		Page<Hniiservicedata> page=null;
		if(StringUtils.isNotBlank(type)){
			if(StringUtils.isNotBlank(unit)){
				if(StringUtils.isNotBlank(cnum)){
					page=repository.findPageCtypeServiceTypeUnitCnum(ctype,service,type,"%"+unit+"%","%"+cnum+"%",pageable);
				}else{
					page=repository.findPageCtypeServiceTypeUnit(ctype,service,type,"%"+unit+"%",pageable);
 				}
			}else{
				if(StringUtils.isNotBlank(cnum)){
					page=repository.findPageCtypeServiceTypeCnum(ctype,service,type,"%"+cnum+"%",pageable);
				}else{
					page=repository.findPageCtypeServiceType(ctype,service,type,pageable);
				}
			}
		}else{
			if(StringUtils.isNotBlank(unit)){
				if(StringUtils.isNotBlank(cnum)){
					page=repository.findPageCtypeServiceUnitCnum(ctype,service,"%"+unit+"%","%"+cnum+"%",pageable);
				}else{
					page=repository.findPageCtypeServiceUnit(ctype,service,"%"+unit+"%",pageable);
				}
			}else{
				if(StringUtils.isNotBlank(cnum)){
				 	page=repository.findPageCtypeServiceCnum(ctype,service,"%"+cnum+"%",pageable);
				}else{
				 	page=repository.findPageCtypeService(ctype,service,pageable);
				}
			}
		}
 

		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hniiservicedata> findTaxiComplaintAll(String ctypecode,String  servicecode,String type) {
		return repository.findTaxiComplaintAll(ctypecode,servicecode,type);
	}
}
