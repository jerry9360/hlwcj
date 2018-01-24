package com.centit.hlwyw.account.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.centit.hlwyw.core.entity.BaseEntity;



@Entity
@Table(name = "role")
public class Role extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4543017171320150602L;

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@Column(length = 32, nullable = false,unique=true)  
    @GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	/** Create Date */
	@Column(name = "create_date", nullable = false, updatable = false)
	private Date createDate;

	/** Modify Date */
	@Column(name = "modify_date", nullable = false)
	private Date modifyDate;


	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	private String rolename;
	
	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	private String rolecode;
	
	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	private String mainpage;
	
	@NotEmpty
	@Length(max = 1)
	@Column(nullable = false)
	private String isforbidden;	
	
	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	private String description;

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users;

	@ManyToMany
	@JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissions;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getMainpage() {
		return mainpage;
	}

	public void setMainpage(String mainpage) {
		this.mainpage = mainpage;
	}

	public String getIsforbidden() {
		return isforbidden;
	}

	public void setIsforbidden(String isforbidden) {
		this.isforbidden = isforbidden;
	}
	
}
