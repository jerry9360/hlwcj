package com.centit.hlwyw.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.sys.entity.Menu;
import com.centit.hlwyw.sys.repositories.MenuRepository;
import com.centit.hlwyw.sys.service.MenuService;

@Service("menuServiceImpl")
public class MenuServiceImpl extends BaseServiceImpl<Menu, String>
		implements MenuService {

	@Resource(name = "menuRepository")
	private MenuRepository repository;

	@Resource(name = "menuRepository")
	public void setReposity(
			PagingAndSortingRepository<Menu, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("menu")
	public Menu find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("menu")
	public List<Menu> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("menu")
	public List<Menu> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("menu")
	public List<Menu> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("menu")
	public Page<Menu> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void save(Menu entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public Menu update(Menu entity) {
		Menu menu = super.find(entity.getId());
		super.update(entity);
		return menu;
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public Menu update(Menu entity, String... ignoreProperties) {
		Menu menu = super.update(entity, ignoreProperties);
		return menu;
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void delete(String[] ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void delete(Menu entity) {
		super.delete(entity);
	}

	@Override
	@Cacheable("menu")
	@Transactional(readOnly=true)
	public List<String> findMenuByroleid(String role_id) {
		return repository.findMenuByroleid(role_id);
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void deleteByroleid(String role_id) {
		repository.deleteByroleid(role_id);
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void saveMenu(String role_id,List<String> menu_idlist) {
		if(menu_idlist.size()>0){
			for(String menu_id : menu_idlist){
				repository.saveMenu(role_id, menu_id);
			}
		}
		
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void deleteByid(String id) {
		repository.deleteByid(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void deleteBypid(String id) {
		repository.deleteBypid(id);
	}

	@Override
	public Menu newMenu() {
		return new Menu();
	}

	@Override
	public Menu setMenuid(Menu menu) {
		String id = UUID.randomUUID().toString();
		id = id.replace("-", "");
		menu.setId(id);
		return menu;
	}

	@Override
	@Cacheable("menu")
	@Transactional(readOnly=true)
	public List<Menu> findVaidMenus() {
		return repository.findVaidMenus();
	}
	
	@Override
	@Cacheable("menu")
	@Transactional(readOnly=true)
	public List<Menu> findUserRoleMenus(String roleid){
		return repository.findUserRoleMenus(roleid);
	}

	@Override
	@Transactional
	@CacheEvict(value = "menu", allEntries = true)
	public void forbidmenu(String isforbidden, String id) {
		repository.forbidmenu(isforbidden, id);
	}

	@Override
	@Cacheable("menu")
	@Transactional(readOnly=true)
	public List<Menu> findChildMenuUnforbidden(String pid) {
		return repository.findChildMenuUnforbidden(pid);
	}
	
	@Override
	@Cacheable("menu")
	@Transactional(readOnly=true)
	public List<Menu> findMenusByUserid(String userid){
		return repository.findMenusByUserid(userid);
	}
	
	@Override
	@CacheEvict(value = "menu", allEntries = true)
	@Transactional(readOnly=true)
	public List<Menu> findALlMenus(){
		return repository.findALlMenus();
	}
	
//	@Override
//	@Cacheable("menu")
//	@Transactional(readOnly=true)
//	public List<Menu> findByMenutype(String type){
//		return null;
//	}
//	
	@Override
	@Cacheable("menu")
	@Transactional(readOnly=true)
	public List<Menu> findUserMenus(List<String> roleids){
		return repository.findUserMenus(roleids);
	}
	
	@Override
	@Cacheable("menu")
	@Transactional(readOnly=true)
	public List<Menu> findMenusByRoleid(String roleid){
		List<Menu> menus = repository.findMenusByRoleid(roleid);
		return parseUserMenus(menus);
	}
	
	@Override
	public List<Menu> parseUserMenus(List<Menu> menus){
		List<Menu> pmenus = new ArrayList<Menu>();
		List<Menu> smenus = new ArrayList<Menu>();
		for(Menu m:menus){
			if(StringUtils.isBlank(m.getPid())){
				pmenus.add(m);
			}else{
				smenus.add(m);
			}
		}
		List<Menu> fmenus = null;
		for(Menu m:smenus){
			fmenus = new ArrayList<Menu>();
			for(Menu m2:menus){
				if(m.getId().equals(m2.getPid())){
					fmenus.add(m2);
				}
			}
			m.setMenus(fmenus);
		}
		for(Menu pm : pmenus){
			fmenus = new ArrayList<Menu>();
			for(Menu m:smenus){
				if(pm.getId().equals(m.getPid())){
					fmenus.add(m);
				}
			}
			pm.setMenus(fmenus);
		}
		return pmenus;
	}
}
