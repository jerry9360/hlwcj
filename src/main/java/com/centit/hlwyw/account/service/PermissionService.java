package com.centit.hlwyw.account.service;

import java.util.List;
import java.util.Set;

import com.centit.hlwyw.account.entity.Permission;
import com.centit.hlwyw.core.service.BaseService;



public interface PermissionService extends BaseService<Permission, String> {
	
	List<Permission> findUserPermissions(String id);

	Set<Permission> findByIdIn(String[] permissionIdArr);

	List<Permission> findByName(String name);
}
