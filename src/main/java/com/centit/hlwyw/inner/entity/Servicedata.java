package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.centit.hlwyw.core.entity.BaseEntity;

@SolrDocument(solrCoreName="servicedata")
@Entity
@Table(name = "servicedata")

public class Servicedata extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Field(value="id")
	@Column(name = "id")	
    private String id;
	
	@Field(value="type")
	@Column(name = "type")	
    private String type;
	
	@Field(value="title")
	@Column(name = "title")	
    private String title;
	
	@Field(value="issuedate")
	@Column(name = "issuedate")	
    private String issuedate;
	
	@Field(value="issueunit")
	@Column(name = "issueunit")	
    private String issueunit;
	
	@Field(value="sourcetype")
	@Column(name = "sourcetype")	
    private String sourcetype;
	
	@Field(value="source")
	@Column(name = "source")	
    private String source;
	
	@Field(value="url")
	@Column(name = "url")	
    private String url;
	
	@Field(value="content")
	@Column(name = "content")	
    private String content;
	
	@Field(value="credit")
	@Column(name = "credit")	
    private String credit;
	
	@Field(value="filename")
	@Column(name = "filename")	
    private String filename;
	
	@Field(value="isvalid")
	@Column(name = "isvalid")	
    private String isvalid;
	
	@Field(value="state")
	@Column(name = "state")	
	private String state;
	
	/*@Field(value="create_date")
	@Column(name = "create_date")	
    private Date create_date;*/
	
/*	@Field(value="modify_date")
	@Column(name = "modify_date")	
    private Date modify_date;*/
	
	@Field(value="create_date")
	@Column(name = "create_date")	
    private String create_date;

	@Field(value="modify_date")
	@Column(name = "modify_date")	
    private String modify_date;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getIssueunit() {
		return issueunit;
	}

	public void setIssueunit(String issueunit) {
		this.issueunit = issueunit;
	}

	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
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

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

/*	public Date getCreate_date() {
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
*/


}
