package com.centit.hlwyw.inner.service.impl;

import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Order_source;
import com.centit.hlwyw.inner.repositories.Order_sourceRepository;
import com.centit.hlwyw.inner.service.Order_sourceService;

@Service("order_sourceServiceImpl")
public class Order_sourceServiceImpl extends BaseServiceImpl<Order_source, String>
implements Order_sourceService{
	
	@Resource(name = "order_sourceRepository")
	private Order_sourceRepository repository;
	
	@Resource(name = "order_sourceRepository")
	public void setReposity(
			PagingAndSortingRepository<Order_source, String> repository) {
		super.setReposity(repository);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Order_source> findPage(Pageable pageable){
		return repository.findPage(pageable);
	}
	
	@Override
	@Transactional
	public void save(Order_source entity) {
		super.save(entity);
	}
	
	@Override
	@Transactional
	public Order_source update(Order_source entity) {
		return super.update(entity);
	}
	
	@Override
	@Transactional
	public Order_source find(String id) {
		return super.find(id);
	}
	@Override
	@Transactional
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	@Transactional
	public Page<Order_source> findSearchname(String urlname, Pageable pageable) {
		return repository.findSearchname(urlname, pageable);
	}
	
	@Override
	@Transactional
	public void deleteUrl(String id){
		repository.deleteUrl(id);
	}
}
