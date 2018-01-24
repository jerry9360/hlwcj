/*
 */
package com.centit.hlwyw.account.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.centit.hlwyw.sys.entity.Menu;

/**
 * Principal
 * 
 */
public class Principal implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7386698598562543697L;

	/** ID */
	private String id;

	private String username;
	
	private String loginname;
	
	private Set<Role> roles;
	
	private List<Menu> menus;
	
	private String index;
	
	public Principal(){
		
	}

	/**
	 * 
	 * @param id
	 * @param loginname
	 * @param username
	 * @param projectid
	 * @param projectname
	 */
	public Principal(String id, String loginname, String username) {
		this.id = id;
		this.loginname = loginname;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return username;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}