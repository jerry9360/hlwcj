package com.centit.hlwyw.account.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.account.entity.Permission;



public interface PermissionRepository extends
		PagingAndSortingRepository<Permission, String> {

	@Query(value="select a.* from Permission a inner join role_permission  b on a.id = b.permission_id " 
			+ " inner join role c on c.id = b.role_id "
			+ " inner join user_role e on e.role_id = c.id "
			+ " inner join Userinfo d on d.id = e.user_id "
			+ " where d.userid =?1", nativeQuery=true)
	List<Permission> findUserPermissions(String id);
	
	Set<Permission> findByIdIn(String[] permissionIdArr);

	List<Permission> findByName(String name);
}
