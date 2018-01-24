package com.centit.hlwyw.account.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.account.entity.Role;



public interface RoleRepository extends PagingAndSortingRepository<Role, String> {

	Set<Role> findByIdIn(String[] roleIdArr);

	Role findByRolename(String rolename);
	
	@Query(value="select r.* from Role r inner join USER_ROLE ur on r.id = ur.ROLE_ID where r.isforbidden = '0' and ur.user_id=?1",nativeQuery=true)
	public List<Role> findByUserid(String userid);
	
	public Role findByRolecode(String rolecode);
	
	@Query("select r from Role r order by r.createDate desc")
	public List<Role> findAllRoles();
}
