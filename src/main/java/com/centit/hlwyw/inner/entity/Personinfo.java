package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "personinfo")
public class Personinfo extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;
	@Id
	@Column(name = "perid")	
    private String perid;
	@Column(name = "sex")	
    private String sex;
	@Column(name = "industry")	
    private String industry;
	@Column(name = "name")	
    private String name;
	@Column(name = "card_no")	
    private String card_no;
	@Column(name = "istag")
	private String istag;
	@Column(name = "create_date")	
    private Date create_date;
	@Column(name = "modify_date")	
    private Date modify_date;

	public String getPerid() {
		return perid;
	}

	public void setPerid(String perid) {
		this.perid = perid;
	}

	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getIstag() {
		return istag;
	}

	public void setIstag(String istag) {
		this.istag = istag;
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
