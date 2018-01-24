package com.centit.hlwyw.sys.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.centit.hlwyw.account.entity.Role;
import com.centit.hlwyw.account.service.RoleService;
import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;

@Controller("roleController")
@RequestMapping("/adminmgr/role")
public class RoleController extends BaseController{
	
	@Resource(name="roleServiceImpl")
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String roleList(ModelMap model){
		List<Role> list=roleService.findAllRoles();
		model.addAttribute("rolelist", list);		
		return "/sys/role/rolelist";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String addRole(@Valid Role role,BindingResult bindingResult, ModelMap model,
			 HttpServletRequest request,HttpServletResponse response){
 		if (bindingResult.hasErrors()) {
			model.addAttribute("role", role);
			model.addAttribute("valid_error", bindingResult.getAllErrors());
			return "/sys/role/newrole";
//			return Constantval.CONSTANT_FAIL;
			}
		if(null == role.getId()){
			role = roleService.setRoleid(role);
			//roleService.saveRole(role2);	
		}
		if(null!=role.getRolename()){
			Role role2=roleService.findByRolecode(role.getRolecode());
			if(null != role2 && !role.getId().equals(role2.getId())){
				model.addAttribute("role", role);
				bindingResult.rejectValue("rolename", "角色编码唯一", "角色编码唯一");
				model.addAttribute("valid_error", bindingResult.getAllErrors());
				return "/sys/role/newrole";
//				return Constantval.CONSTANT_FAIL;
			}
			}
		if(null==role.getCreateDate()){
			role.setCreateDate(new Date());
		}
		role.setModifyDate(new Date());
		roleService.saveRole(role);
		return "redirect:/adminmgr/role";
//		return Constantval.CONSTANT_SUCCESS;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateRole(@Valid Role role,BindingResult bindingResult, ModelMap model 
			 ){
		if(null!=role.getRolename()){
			Role role2=roleService.findByRolecode(role.getRolecode());
			if(null != role2){
				return "角色编码唯一！";
			}
		}
		if(null==role.getCreateDate()){
			role.setCreateDate(new Date());
		}
		role.setModifyDate(new Date());		
		System.out.println(role.getRolename());
		roleService.updateRole(role);		
		List<Role> list=roleService.findAll();
		model.addAttribute("rolelist", list);		
		return "/sys/role/rolelist";
	}
	
	@RequestMapping(value="/isforbidden/{id}/{isforbidden}")
	@ResponseBody
	public String forbiddenRole(@PathVariable String id,@PathVariable String isforbidden ){
		Role role = roleService.findById(id);
			role.setIsforbidden(isforbidden);
		roleService.updateRole(role);	
		return "SUCCESS";
	}
	
	@RequestMapping(value="/new" )
	public String newRole(ModelMap model){
		Role role = new Role();
		model.addAttribute("role", role);
		return "/sys/role/newrole";
	}
	
	@RequestMapping(value="/update/{id}")
	public String updateRole(@PathVariable String id, ModelMap model){
		if(null != id){
			Role role =roleService.findById(id);
			model.addAttribute("role", role);			
		}		
		return "/sys/role/newrole";
	}
	
}
