package com.centit.hlwyw.account.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.account.entity.Permission;
import com.centit.hlwyw.account.repository.PermissionRepository;
import com.centit.hlwyw.account.service.PermissionService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;



@Service("permissionServiceImpl")
public class PermissionServiceImpl extends BaseServiceImpl<Permission, String>
		implements PermissionService {
	
	@Resource(name = "permissionRepository")
	private PermissionRepository repository;
	
	@Resource(name = "permissionRepository")
	public void setReposity(
			PagingAndSortingRepository<Permission, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional
	@Cacheable("permission")
	public List<Permission> findUserPermissions(String id) {
		return repository.findUserPermissions(id);
	}

	@Override
	@Transactional
	@Cacheable("permission")
	public Set<Permission> findByIdIn(String[] permissionIdArr) {
		return repository.findByIdIn(permissionIdArr);
	}

	@Override
	@Transactional
	@Cacheable("permission")
	public List<Permission> findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		super.delete(id);
	}
}
