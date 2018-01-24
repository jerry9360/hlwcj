package com.centit.hlwyw.inner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "hniidata_view")
public class Hniidata_view extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "id")	
    private String id;
	@Column(name = "industry")	
    private String industry;
	@Column(name = "dalei")	
    private String dalei;
	@Column(name = "xiaolei")	
    private String xiaolei;
	@Column(name = "years")	
    private String years;
    
    
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
	public String getDalei() {
		return dalei;
	}
	public void setDalei(String dalei) {
		this.dalei = dalei;
	}
	public String getXiaolei() {
		return xiaolei;
	}
	public void setXiaolei(String xiaolei) {
		this.xiaolei = xiaolei;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	} 
	
	
}
