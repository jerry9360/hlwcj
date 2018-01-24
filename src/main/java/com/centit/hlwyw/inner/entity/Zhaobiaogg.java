package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "zhaobiaogg")
public class Zhaobiaogg extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;
	
	@Id
	@Column(name = "zhaobiao_id")	
    private String zhaobiao_id;
	@Column(name = "project_name")	
    private String project_name;
	@Column(name = "project_code_cq")	
    private String project_code_cq;
	@Column(name = "industry")	
    private String industry;
	@Column(name = "gg_type")	
	private String gg_type;
	@Column(name = "zhaobiao_type")	
    private String zhaobiao_type;
	@Column(name = "zhaobiaoren")	
    private String zhaobiaoren;
	@Column(name = "zhaobiaodaili")	
    private String zhaobiaodaili;
	@Column(name = "zijinlaiyuan")	
    private String zijinlaiyuan;
	@Column(name = "zhaobiao_no")	
    private String zhaobiao_no;
	@Column(name = "zhuanghao")	
    private String zhuanghao;
	@Column(name = "htd")	
    private String htd;
	@Column(name = "gg_update")	
    private Date gg_update;
	@Column(name = "web_content")	
    private String web_content;
	@Column(name = "web_name")	
    private String web_name;
	@Column(name = "url")	
	private String url;
	@Column(name = "webunit")
	private String webunit;
	@Column(name = "filename")
	private String filename;
	@Column(name = "credit")
	private String credit;
	@Column(name = "isvalid")
	private String isvalid;
	@Column(name = "web_update")	
    private Date web_update;
	@Column(name = "state")	
    private String state;
	@Column(name = "create_date")	
    private Date create_date;
	@Column(name = "modify_date")	
    private Date modify_date;
	public String getZhaobiao_id() {
		return zhaobiao_id;
	}
	public void setZhaobiao_id(String zhaobiao_id) {
		this.zhaobiao_id = zhaobiao_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_code_cq() {
		return project_code_cq;
	}
	public void setProject_code_cq(String project_code_cq) {
		this.project_code_cq = project_code_cq;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getZhaobiao_type() {
		return zhaobiao_type;
	}
	public void setZhaobiao_type(String zhaobiao_type) {
		this.zhaobiao_type = zhaobiao_type;
	}
	public String getZhaobiaoren() {
		return zhaobiaoren;
	}
	public void setZhaobiaoren(String zhaobiaoren) {
		this.zhaobiaoren = zhaobiaoren;
	}
	public String getZhaobiaodaili() {
		return zhaobiaodaili;
	}
	public void setZhaobiaodaili(String zhaobiaodaili) {
		this.zhaobiaodaili = zhaobiaodaili;
	}
	public String getZijinlaiyuan() {
		return zijinlaiyuan;
	}
	public void setZijinlaiyuan(String zijinlaiyuan) {
		this.zijinlaiyuan = zijinlaiyuan;
	}
	public String getZhaobiao_no() {
		return zhaobiao_no;
	}
	public void setZhaobiao_no(String zhaobiao_no) {
		this.zhaobiao_no = zhaobiao_no;
	}
	public String getZhuanghao() {
		return zhuanghao;
	}
	public void setZhuanghao(String zhuanghao) {
		this.zhuanghao = zhuanghao;
	}
	public String getHtd() {
		return htd;
	}
	public void setHtd(String htd) {
		this.htd = htd;
	}
	public Date getGg_update() {
		return gg_update;
	}
	public void setGg_update(Date gg_update) {
		this.gg_update = gg_update;
	}
	public String getWeb_content() {
		return web_content;
	}
	public void setWeb_content(String web_content) {
		this.web_content = web_content;
	}
	public String getWeb_name() {
		return web_name;
	}
	public void setWeb_name(String web_name) {
		this.web_name = web_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWebunit() {
		return webunit;
	}
	public void setWebunit(String webunit) {
		this.webunit = webunit;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}
	public Date getWeb_update() {
		return web_update;
	}
	public void setWeb_update(Date web_update) {
		this.web_update = web_update;
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
	public void setModify_date(Date modify_udate) {
		this.modify_date = modify_udate;
	}
	public String getGg_type() {
		return gg_type;
	}
	public void setGg_type(String gg_type) {
		this.gg_type = gg_type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
