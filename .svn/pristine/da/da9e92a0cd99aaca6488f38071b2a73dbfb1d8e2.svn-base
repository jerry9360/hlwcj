package com.centit.hlwyw.account.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "userinfo")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -857881974826851181L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@Column(length = 32, nullable = false,unique=true)  
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
	
	@Column(name = "username")	
    private String username;	

	@Column(name = "sex")
	private String sex;	
	
	@Column(name = "linkphone")	
	private String linkphone;
	
	@Column(name = "email")	
	private String email;
	
	@Column(name="loginname")
	private String loginname;	
	
	@JsonIgnore
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="salt")
	private String salt;
	
	@Column(name="isvaild",nullable = false, length = 1)
	private String isvaild;		
	
	@Column(name = "create_date", nullable = false, updatable = false)
	private Date createDate;

	@Column(name = "modify_date", nullable = false)
	private Date modifyDate;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLinkphone() {
		return linkphone;
	}

	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		if(salt==null){
			salt = "";
		}
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getIsvaild() {
		return isvaild;
	}

	public void setIsvaild(String isvaild) {
		this.isvaild = isvaild;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
