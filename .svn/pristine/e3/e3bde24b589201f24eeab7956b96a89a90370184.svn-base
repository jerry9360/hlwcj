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
@Table(name = "url_source")
public class UrlSource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 32, nullable = false, unique = true)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "webtype" , length = 1)
	private String webtype;

	@Column(name = "webname" )
	private String webname;

	@Column(name = "platename")
	private String platename;

	@Column(name = "plateurl")
	private String plateurl;

	@Column(name = "isstaticpage")
	private String isstaticpage;

	@Column(name = "contentregex")
	@Length(max=255)
	private String contentregex;

	@Column(name = "pageregex")
	@Length(max=255)
	private String pageregex;

	@Column(name = "credit", length = 1)
	private String credit;

	@Column(name = "unitname")
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

	public String getWebtype() {
		return webtype;
	}

	public void setWebtype(String webtype) {
		this.webtype = webtype;
	}

	public String getWebname() {
		return webname;
	}

	public void setWebname(String webname) {
		this.webname = webname;
	}

	public String getPlatename() {
		return platename;
	}

	public void setPlatename(String platename) {
		this.platename = platename;
	}

	public String getPlateurl() {
		return plateurl;
	}

	public void setPlateurl(String plateurl) {
		this.plateurl = plateurl;
	}

	public String getIsstaticpage() {
		return isstaticpage;
	}

	public void setIsstaticpage(String isstaticpage) {
		this.isstaticpage = isstaticpage;
	}

	public String getContentregex() {
		return contentregex;
	}

	public void setContentregex(String contentregex) {
		this.contentregex = contentregex;
	}

	public String getPageregex() {
		return pageregex;
	}

	public void setPageregex(String pageregex) {
		this.pageregex = pageregex;
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
}
