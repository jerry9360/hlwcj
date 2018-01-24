package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "service_interface")
public class Service_interface extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "interface_name")
	private String interface_name;
	@Column(name = "visit_url")
	private String visit_url;
	@Column(name = "name_space")
	private String name_space;
	@Column(name = "function_name")
	private String function_name;
	@Column(name = "parameter_name")
	private String parameter_name;
	@Column(name = "create_date")	
    private Date create_date;
	@Column(name = "modify_date")	
    private Date modify_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInterface_name() {
		return interface_name;
	}
	public void setInterface_name(String interface_name) {
		this.interface_name = interface_name;
	}
	public String getVisit_url() {
		return visit_url;
	}
	public void setVisit_url(String visit_url) {
		this.visit_url = visit_url;
	}
	public String getName_space() {
		return name_space;
	}
	public void setName_space(String name_space) {
		this.name_space = name_space;
	}
	public String getFunction_name() {
		return function_name;
	}
	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}
	public String getParameter_name() {
		return parameter_name;
	}
	public void setParameter_name(String parameter_name) {
		this.parameter_name = parameter_name;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	

}
