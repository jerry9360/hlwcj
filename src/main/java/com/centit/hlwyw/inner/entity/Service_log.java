package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;


@Entity
@Table(name = "service_log")
public class Service_log extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;
	
	@Id
	@Column(name = "id")	
	private String id;
	@Column(name = "interfaces")	
	private String interfaces;
	@Column(name = "data_type")	
	private String data_type;
	@Column(name = "unit")	
	private String unit;
	@Column(name = "data_size")	
	private String data_size;
	@Column(name = "time")	
	private Date time;
	@Column(name = "modify_date")	
	private Date modify_date;
	@Column(name = "create_date")	
	private Date create_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(String interfaces) {
		this.interfaces = interfaces;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getData_size() {
		return data_size;
	}
	public void setData_size(String data_size) {
		this.data_size = data_size;
	}
	public Date gettime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	

	
	
	
	
}
