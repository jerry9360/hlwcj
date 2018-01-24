package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "hnii_prise")
public class Hnii_prise extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "id")	
    private String id;
	@Column(name = "myid")	
    private String myid;
	@Column(name = "industry")	
    private String industry;
	@Column(name = "servicetype")	
    private String servicetype;
	@Column(name = "object")	
    private String object;
	@Column(name = "objectname")	
    private String objectname;
	@Column(name = "time")	
    private String time;
	@Column(name = "isvalid")	
    private String isvalid;
	@Column(name = "unit")	
    private String unit;
	@Column(name = "content")	
    private String content;
	@Column(name = "carno")	
    private String carno;
	@Column(name = "matecount")	
    private String matecount;
	@Column(name = "dealresult")	
    private String dealresult;
	@Column(name = "calltime")	
    private Date calltime;
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

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getObjectname() {
		return objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

	public String getMatecount() {
		return matecount;
	}

	public void setMatecount(String matecount) {
		this.matecount = matecount;
	}

	public String getDealresult() {
		return dealresult;
	}

	public void setDealresult(String dealresult) {
		this.dealresult = dealresult;
	}

	public Date getCalltime() {
		return calltime;
	}

	public void setCalltime(Date calltime) {
		this.calltime = calltime;
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

	public String getCarno() {
		return carno;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}



}
