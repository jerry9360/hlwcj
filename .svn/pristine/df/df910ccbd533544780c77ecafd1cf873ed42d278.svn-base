package com.centit.hlwyw.account.service;

import java.util.List;
import java.util.Set;

import com.centit.hlwyw.account.entity.Role;
import com.centit.hlwyw.core.service.BaseService;

public interface RoleService extends BaseService<Role, String> {

	Set<Role> findByIdIn(String[] roleIdArr);

	Role findByRolename(String rolename);
	
	public List<Role> findByUserid(String userid);
	
	List<Role> findAll();
	
	String saveRole(Role role);
	
	Role setRoleid(Role role);
	
	Role findById(String id);
	
	void updateRole(Role role);
	
	public Role findByRolecode(String rolecode);
	
	public List<Role> findUserroles(String userid);
	
	public List<Role> findAllRoles();
}
