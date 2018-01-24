package com.centit.hlwyw.account.service.impl;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.account.entity.Role;
import com.centit.hlwyw.account.repository.RoleRepository;
import com.centit.hlwyw.account.service.RoleService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.sys.controller.IndexController;


@Service("roleServiceImpl")
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements
		RoleService {
	
	private static Logger log = Logger.getLogger(RoleServiceImpl.class);  

	
	
	@Resource(name = "roleRepository")
	private RoleRepository repository;
	
	@Resource(name = "roleRepository")
	public void setReposity(PagingAndSortingRepository<Role, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Set<Role> findByIdIn(String[] roleIdArr) {
		return repository.findByIdIn(roleIdArr);
	}

	@Override
	@Transactional(readOnly = true)
	public Role findByRolename(String rolename) {
		return repository.findByRolename(rolename);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findByUserid(String userid) {
		return repository.findByUserid(userid);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Role> findUserroles(String userid){
		List<Role> roles = repository.findByUserid(userid);
		return roles;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll(){
		return super.findAll();		
	}
	
	@Override
	@Transactional
	public String saveRole(Role role){
		super.save(role);
		return "success";
//		try{
//
//		}catch(Exception e){
//			log.error(e.getMessage());log.info(e);
//			return "failed";
//		}		
	}
	
	@Override
	public Role setRoleid(Role role) {
		String id = UUID.randomUUID().toString();
		id = id.replace("-", "");
		role.setId(id);
		return role;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Role findById(String id){
		return super.find(id);		
	}
	
	@Transactional
	public void updateRole(Role role){
		super.update(role);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Role findByRolecode(String rolecode){
		return repository.findByRolecode(rolecode);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Role> findAllRoles(){
		return repository.findAllRoles();
	}
}
