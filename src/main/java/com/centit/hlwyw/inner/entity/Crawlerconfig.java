package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "crawlerconfig")
public class Crawlerconfig extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "crawl_depth")
	private String crawl_depth;
	@Column(name = "crawl_thread_num")
	private String crawl_thread_num;
	@Column(name = "crawl_topn")
	private String crawl_topn;
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

	public String getCrawl_depth() {
		return crawl_depth;
	}

	public void setCrawl_depth(String crawl_depth) {
		this.crawl_depth = crawl_depth;
	}

	public String getCrawl_thread_num() {
		return crawl_thread_num;
	}

	public void setCrawl_thread_num(String crawl_thread_num) {
		this.crawl_thread_num = crawl_thread_num;
	}

	public String getCrawl_topn() {
		return crawl_topn;
	}

	public void setCrawl_topn(String crawl_topn) {
		this.crawl_topn = crawl_topn;
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
