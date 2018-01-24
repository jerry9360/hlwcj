
package com.centit.hlwyw.sys.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.account.entity.Role;
import com.centit.hlwyw.account.entity.User;
import com.centit.hlwyw.account.service.RoleService;
import com.centit.hlwyw.account.service.UserService;
import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.shiro.security.PasswordHelper;

@Controller("userInfoController")
@RequestMapping("/adminmgr/userInfo")
public class UserController extends BaseController{
	
	@Resource(name="roleServiceImpl")
	private RoleService roleService;	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Resource(name="passwordHelper")
	private PasswordHelper passwordHelper;
	
	@RequestMapping(method = RequestMethod.GET)
	public String roleList(ModelMap model){
		List<User> list=userService.findAll();
		model.addAttribute("list", list);		
		return "/sys/userInfo/list";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	@ResponseBody
	public String addRole(@Valid User user,BindingResult bindingResult, ModelMap model ){
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("valid_error", bindingResult.getAllErrors());
			return "/sys/userInfo/newrole";
		}
		if(user.getId()==null||"".equals(user.getId())){
			String salt = KeyUtils.getKey();
			String pwd = passwordHelper.getPassword(salt, "000000");
			user.setPassword(pwd);
			user.setSalt(salt);
			Role role=roleService.findByRolecode("ROLE_SYSADMIN");
			Set<Role> roles=new HashSet<Role>();
			roles.add(role);
			user.setRoles(roles);
		}
		if(null==user.getCreateDate()){
			user.setCreateDate(new Date());
		}
		user.setModifyDate(new Date());
 		userService.save(user);
//		return "redirect:/adminmgr/userInfo";
 		return Constantval.CONSTANT_SUCCESS;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateRole(@Valid User user,  ModelMap model ){
		if(null==user.getCreateDate()){
			user.setCreateDate(new Date());
		}
		user.setModifyDate(new Date());		
		userService.update(user);		
		List<User> list=userService.findAll();
		model.addAttribute("list", list);		
		return "/sys/userInfo/form";
	}
	
	@RequestMapping(value="/isVaild/{id}/{isVaild}")
	@ResponseBody
	public String forbiddenRole(@PathVariable String id,@PathVariable String isVaild ){
		User user = userService.find(id);
			user.setIsvaild(isVaild);
		userService.update(user);	
		return "SUCCESS";
	}
	
	@RequestMapping(value="/new")
	public String newRole(ModelMap model){
		User user = new User();
		model.addAttribute("user", user);
		return "/sys/userInfo/form";
	}
	
	@RequestMapping(value="/update/{id}")
	public String updateUser(@PathVariable String id, ModelMap model){
		if(null != id){
			User user =userService.find(id);
			model.addAttribute("user", user);			
		}		
		return "/sys/userInfo/form";
	}
	@RequestMapping(value="/{id}/delete")
	public String delete(@PathVariable String id, ModelMap model){
			userService.delete(id);
		return "redirect:/adminmgr/userInfo";
	}
	/*
	 * 密码初始化
	 */
	@RequestMapping(value="/{id}/initial")
	public String  initialization(@PathVariable String id ){
		User user =userService.find(id);
		String salt = KeyUtils.getKey();
		String pwd = passwordHelper.getPassword(salt, "000000");
		user.setPassword(pwd);
		user.setSalt(salt);
		userService.save(user);
		return "redirect:/adminmgr/userInfo";
	}
}

