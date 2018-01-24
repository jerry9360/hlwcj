package com.centit.hlwyw.inner.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "business_root")
public class Business_root extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "root_id")	
    private String root_id;
	@Column(name = "industry_id")	
    private String industry_id;
	@Column(name = "business_name")	
    private String business_name;
	@Column(name = "key_word")	
    private String key_word; 
	@Column(name = "un_key_word")	
    private String un_key_word; 
	@Column(name = "types")	
    private String types; 
	@Column(name = "regex")	
    private String regex; 
	@Column(name = "create_date")	
    private Date create_date;
	@Column(name = "modify_date")	
    private Date modify_date;
	public String getRoot_id() {
		return root_id;
	}
	public void setRoot_id(String root_id) {
		this.root_id = root_id;
	}
	public String getIndustry_id() {
		return industry_id;
	}
	public void setIndustry_id(String industry_id) {
		this.industry_id = industry_id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getKey_word() {
		return key_word;
	}
	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}
	
	public String getUn_key_word() {
		return un_key_word;
	}
	public void setUn_key_word(String un_key_word) {
		this.un_key_word = un_key_word;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
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
	
	@Transient
	private String alarms;

	public String getAlarms() {
		return alarms;
	}
	public void setAlarms(String alarms) {
		this.alarms = alarms;
	}
	
	@Transient
	private List<Business_secondary> secondarys;
	public List<Business_secondary> getSecondarys() {
		return secondarys;
	}
	public void setSecondarys(List<Business_secondary> secondarys) {
		this.secondarys = secondarys;
	}
	@Transient
	private List<InfoStat> infos;
	public List<InfoStat> getInfos() {
		return infos;
	}
	public void setInfos(List<InfoStat> infos) {
		this.infos = infos;
	}
	
	

}
