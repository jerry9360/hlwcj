package com.centit.hlwyw.inner.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "order_source")
public class Order_source implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 32, nullable = false, unique = true)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "webname")
	@Length(max=255)
	private String webname;
	   
	@Column(name = "sourcetype" , length = 1)
	private String sourcetype;
	
	@Column(name = "platename")
	private String platename;
	
	@Column(name = "weburl")
	@Length(max=255)
	private String weburl;

	@Column(name = "credit" , length = 1)
	private String credit;

	@Column(name = "unitname")
	@Length(max=255)
	private String unitname;
	
	@Column(name = "isvalid")
	private String isvalid;
	
	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "modify_date")
	private Date modifyDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWebname() {
		return webname;
	}

	public void setWebname(String webname) {
		this.webname = webname;
	}

	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
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

	public String getPlatename() {
		return platename;
	}

	public void setPlatename(String platename) {
		this.platename = platename;
	}
	
}
