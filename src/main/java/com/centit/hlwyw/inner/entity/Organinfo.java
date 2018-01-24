package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "organinfo")
public class Organinfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orgid")
	private String orgid;
	@Column(name = "orgname")
	private String orgname;
	@Column(name = "keyval")
	private String keyval;
	@Column(name = "istag")
	private String istag;
	@Column(name = "create_date")
	private Date createdate;
	@Column(name = "modify_date")
	private Date modifydate;

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getKeyval() {
		return keyval;
	}

	public void setKeyval(String keyval) {
		this.keyval = keyval;
	}

	public String getIstag() {
		return istag;
	}

	public void setIstag(String istag) {
		this.istag = istag;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
}
