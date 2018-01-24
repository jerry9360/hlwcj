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
import com.centit.hlwyw.inner.entity.Servicedata;
import com.centit.hlwyw.inner.repositories.ServicedataRepository;
import com.centit.hlwyw.inner.service.ServicedataService;

@Service("servicedataServiceImpl")
public class ServicedataServiceImpl extends BaseServiceImpl<Servicedata, String>
		implements ServicedataService {

	@Resource(name = "servicedataRepository")
	private ServicedataRepository repository;


	@Resource(name = "servicedataRepository")
	public void setReposity(
			PagingAndSortingRepository<Servicedata, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Servicedata find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servicedata> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servicedata> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servicedata> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Servicedata> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Servicedata entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Servicedata update(Servicedata entity) {
		Servicedata servicedata = super.find(entity.getId());
		super.update(entity);
		return servicedata;
	}

	@Override
	@Transactional
	public Servicedata update(Servicedata entity, String... ignoreProperties) {
		Servicedata servicedata = super.update(entity, ignoreProperties);
		return servicedata;
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
	public void delete(Servicedata entity) {
		super.delete(entity);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Servicedata> findSearchData(String type,String source,String state,Pageable pageable) {
		Page<Servicedata> page=null;
		if("1".equals(state)){
	 		if(StringUtils.isNotBlank(type)){
				if(StringUtils.isNotBlank(source)){
					page=repository.findPageByTypeSource("%"+type+"%","%"+source+"%",pageable);
				}else{
					page=repository.findPageByType("%"+type+"%",pageable);
				}
			}else{
				if(StringUtils.isNotBlank(source)){
					page=repository.findPageBySource("%"+source+"%",pageable);
				}else{
					page=repository.findPage(pageable);
				}
			}
		}else{
	 		if(StringUtils.isNotBlank(type)){
				if(StringUtils.isNotBlank(source)){
					page=repository.findCPageByTypeSource("%"+type+"%","%"+source+"%",pageable);
				}else{
					page=repository.findCPageByType("%"+type+"%",pageable);
				}
			}else{
				if(StringUtils.isNotBlank(source)){
					page=repository.findCPageBySource("%"+source+"%",pageable);
				}else{
					page=repository.findCPage(pageable);
				}
			}
		}
 		return page;
	}
}
