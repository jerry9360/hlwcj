package com.centit.hlwyw.account.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.centit.hlwyw.account.entity.User;
import com.centit.hlwyw.core.service.BaseService;



public interface UserService extends BaseService<User, String> {
	User findByUsername(String username);

	User findByLoginname(String loginname);
	
	List<User> findByLoginnameIgnoreCase(String loginname);
	
	Page<User> findByLoginnameLikeIgnoreCase(String loginname, Pageable pageable);
	
	Page<User> findByNameLike(String name, Pageable pageable);

	public List<User> findByRole_Id(String id);
	
	public void updatePassword(String passwordtemp,String salt,String id);
	
}
