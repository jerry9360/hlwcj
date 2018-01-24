package com.centit.hlwyw.inner.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "industry_statistics")
public class Industrystatistics extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "industry_id")	
    private String industry_id;
	@Column(name = "industry_name")	
    private String industry_name;
	@Column(name = "year")	
    private String year;
	@Column(name = "data_size")	
    private BigDecimal data_size;
	@Column(name = "cardinal_number")	
    private BigDecimal cardinal_number;
	@Column(name = "matching_ratio")	
    private BigDecimal matching_ratio;
	@Column(name = "statistics_date")	
    private Date statistics_date;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public BigDecimal getData_size() {
		return data_size;
	}
	public void setData_size(BigDecimal data_size) {
		this.data_size = data_size;
	}
	public BigDecimal getCardinal_number() {
		return cardinal_number;
	}
	public void setCardinal_number(BigDecimal cardinal_number) {
		this.cardinal_number = cardinal_number;
	}
	public BigDecimal getMatching_ratio() {
		return matching_ratio;
	}
	public void setMatching_ratio(BigDecimal matching_ratio) {
		this.matching_ratio = matching_ratio;
	}
	public Date getStatistics_date() {
		return statistics_date;
	}
	public void setStatistics_date(Date statistics_date) {
		this.statistics_date = statistics_date;
	}
	
	 

}
