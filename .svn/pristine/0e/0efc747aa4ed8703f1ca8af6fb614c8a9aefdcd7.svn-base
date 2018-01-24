package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "industry_type")
public class Industry_type extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "industry_id")	
    private String industry_id;
	@Column(name = "industry_name")	
    private String industry_name;
	@Column(name = "key_word")	
    private String key_word; 
	@Column(name = "un_key_word")	
    private String un_key_word;
	@Column(name = "belong_industry")	
    private String belong_industry;
	@Column(name = "regex")	
    private String regex; 
	@Column(name = "create_date")	
    private Date create_date;
	@Column(name = "modify_date")	
    private Date modify_date;
	public String getIndustry_id() {
		return industry_id;
	}
	public void setIndustry_id(String industry_id) {
		this.industry_id = industry_id;
	}
	public String getIndustry_name() {
		return industry_name;
	}
	public void setIndustry_name(String industry_name) {
		this.industry_name = industry_name;
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
	public String getBelong_industry() {
		return belong_industry;
	}
	public void setBelong_industry(String belong_industry) {
		this.belong_industry = belong_industry;
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


}
