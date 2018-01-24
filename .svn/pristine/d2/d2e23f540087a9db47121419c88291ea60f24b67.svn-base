package com.centit.hlwyw.inner.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.centit.hlwyw.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "small_type_statistics")
public class Smalltypestatistics extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "small_type_id")	
    private String small_type_id;
	        
	@Column(name = "big_type_name")	
    private String big_type_name;
	@Column(name = "small_type_name")	
    private String small_type_name;
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
	public String getSmall_type_id() {
		return small_type_id;
	}
	public void setSmall_type_id(String small_type_id) {
		this.small_type_id = small_type_id;
	}
	public String getBig_type_name() {
		return big_type_name;
	}
	public void setBig_type_name(String big_type_name) {
		this.big_type_name = big_type_name;
	}
	public String getSmall_type_name() {
		return small_type_name;
	}
	public void setSmall_type_name(String small_type_name) {
		this.small_type_name = small_type_name;
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
