package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.centit.hlwyw.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Judgedoc")
public class Judgedoc extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "id")	
    private String id;
	@Column(name = "corp_id")	
    private String corp_id;
	@Column(name = "corp_name")	
    private String corp_name;
	@Column(name = "industry")	
    private String industry;
	@Column(name = "servicetype")	
    private String servicetype;
	@Column(name = "hidcasetype")	
    private String hidcasetype;
	@Column(name = "casemantype")	
    private String casemantype;
	@Column(name = "hidcourt")	
    private String hidcourt;
	@Column(name = "hidcasenumber")	
    private String hidcasenumber;
	@Column(name = "hidcasename")	
    private String hidcasename;
	@Column(name = "hidcaseinfo")	
    private String hidcaseinfo;
	@Column(name = "releasetime")	
    private String releasetime;
	@Column(name = "source")	
    private String source;
	@Column(name = "url")	
    private String url;
	@Column(name = "content")	
    private String content;
	@Column(name = "pageunit")	
    private String pageunit;
	@Column(name = "credit")	
    private String credit;
	@Column(name = "filename")	
    private String filename;
	@Column(name = "state")
	private String state;
	@Column(name = "create_date")	
    private Date create_date;
	@Column(name = "modify_date")	
    private Date modify_date;
	@Transient
	@JsonIgnore
	private String[] files;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCorp_id() {
		return corp_id;
	}
	public void setCorp_id(String corp_id) {
		this.corp_id = corp_id;
	}
	public String getCorp_name() {
		return corp_name;
	}
	public void setCorp_name(String corp_name) {
		this.corp_name = corp_name;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getHidcasetype() {
		return hidcasetype;
	}
	public void setHidcasetype(String hidcasetype) {
		this.hidcasetype = hidcasetype;
	}
	public String getCasemantype() {
		return casemantype;
	}
	public void setCasemantype(String casemantype) {
		this.casemantype = casemantype;
	}
	public String getHidcourt() {
		return hidcourt;
	}
	public void setHidcourt(String hidcourt) {
		this.hidcourt = hidcourt;
	}
	public String getHidcasenumber() {
		return hidcasenumber;
	}
	public void setHidcasenumber(String hidcasenumber) {
		this.hidcasenumber = hidcasenumber;
	}
	public String getHidcasename() {
		return hidcasename;
	}
	public void setHidcasename(String hidcasename) {
		this.hidcasename = hidcasename;
	}
	public String getHidcaseinfo() {
		return hidcaseinfo;
	}
	public void setHidcaseinfo(String hidcaseinfo) {
		this.hidcaseinfo = hidcaseinfo;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPageunit() {
		return pageunit;
	}
	public void setPageunit(String pageunit) {
		this.pageunit = pageunit;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String[] getFiles() {
		 String[] ret = null;
		 if ( this.files != null ) {
			 ret = new String[files.length];
			 for (int i = 0; i < files.length; i++) {
			 ret[i] = this.files[i]; 
			 }
		 }
		 return ret;		
		
		
	}
	public void setFiles(String[] files) {
		 this.files = new String[files.length];
		 for (int i = 0; i < files.length; ++i)
		 this.files[i] = files[i];

	}
}
