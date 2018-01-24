package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "jw_data")
public class Jwdata extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "attachment")
	private String attachment;
	@Column(name = "issuetime")
	private Date issuetime;
	@Column(name = "crawltime")
	private Date crawltime;
	@Column(name = "sourcetype")
	private String sourcetype;
	@Column(name = "source")
	private String source;
//	@Column(name = "urlname")
//	private String urlname;
	@Column(name = "url")
	private String url;
	@Column(name = "html")
	private String html;
	@Column(name = "credit")
	private String credit;
	@Column(name = "unitname")
	private String unitname;
	@Column(name = "isvalid")
	private String isvalid;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Date getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(Date issuetime) {
		this.issuetime = issuetime;
	}

	public Date getCrawltime() {
		return crawltime;
	}

	public void setCrawltime(Date crawltime) {
		this.crawltime = crawltime;
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

//	public String getUrlname() {
//		return urlname;
//	}
//
//	public void setUrlname(String urlname) {
//		this.urlname = urlname;
//	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
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
