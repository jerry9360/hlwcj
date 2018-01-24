package com.centit.hlwyw.account.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.account.entity.User;
import com.centit.hlwyw.account.repository.UserRepository;
import com.centit.hlwyw.account.service.UserService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;

@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User, String> implements
		UserService {

	@Resource(name = "userRepository")
	private UserRepository repository;

	@Resource(name = "userRepository")
	public void setReposity(PagingAndSortingRepository<User, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findByNameLike(String name, Pageable pageable) {
		return repository.findByUsernameLikeIgnoreCase("%" + name + "%", pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByRole_Id(String id) {
		return repository.findByRole_Id(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByLoginname(String loginname) {
		return repository.findByLoginname(loginname);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByLoginnameIgnoreCase(String loginname) {
		return repository.findByLoginnameIgnoreCase(loginname);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findByLoginnameLikeIgnoreCase(String loginname,
			Pageable pageable) {
		return repository.findByLoginnameLikeIgnoreCase(loginname, pageable);
	}
	
	@Override
	@Transactional
	public void updatePassword(String passwordtemp,String salt,String id){
		repository.updatePassword(passwordtemp, salt, id);
	}
}
