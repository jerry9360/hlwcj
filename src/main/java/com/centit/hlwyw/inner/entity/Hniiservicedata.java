package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "hniiservicedata")
public class Hniiservicedata extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "id")	
    private String id;
	@Column(name = "myid")	
    private String myid;
	@Column(name = "ctype")	
    private String ctype;
	@Column(name = "service")	
    private String service;
	@Column(name = "type")	
    private String type;
	@Column(name = "cnum")	
    private String cnum;
	@Column(name = "time")	
    private Date time;
	@Column(name = "address")	
    private String address;
	@Column(name = "baddress")	
    private String baddress;
	@Column(name = "eaddress")	
    private String eaddress;
	@Column(name = "isvalid")	
    private String isvalid;
	@Column(name = "state")	
    private String state;
	@Column(name = "unit")	
    private String unit;
	@Column(name = "content")	
    private String content;
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

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBaddress() {
		return baddress;
	}

	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
