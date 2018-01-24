package com.centit.hlwyw.account.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.account.entity.User;



public interface UserRepository extends PagingAndSortingRepository<User, String> {

	User findByUsername(String username);
	
	User findByLoginname(String loginname);
	
	List<User> findByLoginnameIgnoreCase(String loginname);
	
	Page<User> findByLoginnameLikeIgnoreCase(String loginname, Pageable pageable);
	
	Page<User> findByUsernameLikeIgnoreCase(String name, Pageable pageable);

	@Query(value="select a.* from Userinfo a inner join user_role  b on a.id = b.user_id " 
			+ " where b.role_id =?1", nativeQuery=true)
	List<User> findByRole_Id(String id);
	
	@Query(value="update Userinfo u set u.password=?1,u.salt=?2 where u.id = ?3",nativeQuery=true)
	@Modifying
	void updatePassword(String passwordtemp,String salt,String id);
	
}
