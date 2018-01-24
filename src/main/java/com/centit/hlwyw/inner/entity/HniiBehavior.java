package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "hniibehavior")
public class HniiBehavior extends BaseEntity{
	
	/**
	 * 保存96096分类数据,行业,业务,行为特征,来电时间,源数据量,创建时间和更新时间
	 */
	private static final long serialVersionUID =  1L;
	
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid") 
	@Column(name = "id")	
    private String id;
	@Column(name = "industry")	
    private String industry;
	@Column(name = "btype")	
    private String btype;
	@Column(name = "stype")	
    private String stype;
	@Column(name = "calltime")	
    private Date calltime;
	@Column(name = "datasize")	
    private String datasize;
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
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public Date getCalltime() {
		return calltime;
	}
	public void setCalltime(Date calltime) {
		this.calltime = calltime;
	}
	public String getDatasize() {
		return datasize;
	}
	public void setDatasize(String datasize) {
		this.datasize = datasize;
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
