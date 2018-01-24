package com.centit.hlwyw.sys.service;

import java.util.List;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.sys.entity.Menu;

public interface MenuService extends BaseService<Menu, String> {

	public List<String> findMenuByroleid(String role_id);
	
	public void deleteByroleid(String role_id);
	
	public void saveMenu(String role_id,List<String> menu_id);
	
	public void deleteByid(String id);
	
	public void deleteBypid(String id);
	
	public Menu newMenu();
	
	public Menu setMenuid(Menu menu);
	
	public List<Menu> findVaidMenus();
	
	public List<Menu> findUserRoleMenus(String roleid);
	
	public void forbidmenu(String isforbidden,String id);
	
	public List<Menu> findChildMenuUnforbidden(String pid);
	
	public List<Menu> findMenusByUserid(String userid);
	
	public List<Menu> findALlMenus();
	
//	public List<Menu> findByMenutype(String type);
	
	public List<Menu> findUserMenus(List<String> roleids);
	
	public List<Menu> parseUserMenus(List<Menu> menus);
	
	public List<Menu> findMenusByRoleid(String roleid);
	
	
}
