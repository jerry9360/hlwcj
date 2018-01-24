package com.centit.hlwyw.inner.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.centit.hlwyw.core.entity.BaseEntity;
import com.centit.hlwyw.inner.service.impl.HniiServiceImpl;

@Entity
@Table(name = "hnii")
public class Hnii extends BaseEntity{
	
	/**
	 * 保存96096分类数据,行业,业务,行为特征,来电时间,源数据量,表类别,创建时间和更新时间,涉及地点，时间，车牌号
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
	@Column(name = "calltime")	
    private Date calltime;
	@Column(name = "datasize")	
    private String datasize;
	@Column(name = "datatype")	
    private String datatype;
	@Column(name = "baddress")	
    private String baddress;
	@Column(name = "eaddress")	
    private String eaddress;
	@Column(name = "carno")	
    private String carno;
	@Column(name = "time")	
    private String time;
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
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	
	public String getBaddress() {
		return baddress;
	}
	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
