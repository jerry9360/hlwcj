package com.centit.hlwyw.inner.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.centit.hlwyw.core.entity.BaseEntity;

@Entity
@Table(name = "hnii_alarm_service_log2015")
public class Hnii_alarm_service extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;

	@Id
	@Column(name = "myid")	
    private String myid;
	@Column(name = "computerid")	
    private String computerid;
	@Column(name = "calltime")	
    private Date calltime;
	@Column(name = "org")	
    private String org;
	@Column(name = "callreason")	
    private String callreason;
	@Column(name = "ownername")	
    private String ownername;
	@Column(name = "mainphone")	
    private String mainphone;
	@Column(name = "callednum")	
    private String callednum;
	@Column(name = "gdhf")	
    private String gdhf;
	@Column(name = "gdhfmath")	
    private String gdhfmath;
	@Column(name = "gdhfmathmore")	
    private String gdhfmathmore;
	@Column(name = "content")	
    private String content;
	@Column(name = "dealresult")	
    private String dealresult;
	@Column(name = "alarmtype")	
    private String alarmtype;
	@Column(name = "dealday")	
    private Double dealday;
	@Column(name = "dealoverdate")	
    private Date dealoverdate;
	@Column(name = "acceptunit")	
    private String acceptunit;
	@Column(name = "personid")	
    private String personid;
	@Column(name = "blnr")	
    private String blnr;
	@Column(name = "jksydw")	
    private String jksydw;
	@Column(name = "createtime")	
    private Date createtime;
	@Column(name = "orgname")	
    private String orgname;
	@Column(name = "bae001")	
    private String bae001;
	@Column(name = "bae003")	
    private String bae003;
	@Column(name = "bae010")	
    private String bae010;
	@Column(name = "bae002")	
    private String bae002;
	@Column(name = "bae013")	
    private String bae013;
	@Column(name = "bae014")	
    private String bae014;
	@Column(name = "bae015")	
    private String bae015;
	@Column(name = "clfs")	
    private String clfs;
	@Column(name = "dljd")	
    private String dljd;
	@Column(name = "dlwd")	
    private String dlwd;
	@Column(name = "udid")	
    private String udid;
	@Column(name = "flag")	
    private String flag;
	@Column(name = "callreason_code")	
    private String callreason_code;
	@Column(name = "gdhf_code")	
    private String gdhf_code;
	@Column(name = "dealresult_code")	
    private String dealresult_code;
	@Column(name = "alarmtype_code")	
    private String alarmtype_code;
	@Column(name = "acceptunit_code")	
    private String acceptunit_code;
	@Column(name = "org_code")	
    private String org_code;
	@Column(name = "jtbywly")	
    private String jtbywly;
	@Column(name = "jtbywlx")	
    private String jtbywlx;
	@Column(name = "jtbywdm")	
    private String jtbywdm;
	@Column(name = "rt_msg")	
    private String rt_msg;
	@Column(name = "fail_count")	
    private Long fail_count;
	@Column(name = "ringtime")	
    private Date ringtime;
	@Column(name = "endtime")	
    private Date endtime;
	@Column(name = "waittime")	
    private String waittime;
	@Column(name = "ywmyd")	
    private String ywmyd;
	@Column(name = "visittime")	
    private Date visittime;
	@Column(name = "skilltime")	
    private Date skilltime;
	@Column(name = "seattime")	
    private Date seattime;
	@Column(name = "sendstate")	
    private String sendstate;
	@Column(name = "recordid_code")	
    private String recordid_code;
	@Column(name = "starttime")	
    private Date starttime;
	@Column(name = "istag")	
    private String istag;
	@Column(name = "shicahng")	
    private String shicahng;
	@Column(name = "hangye")	
    private String hangye;
	@Column(name = "dalei")	
    private String dalei;
	@Column(name = "xiaolei")	
    private String xiaolei;
	@Column(name = "isdeal")	
    private String isdeal;
	/*@Column(name = "dealflag")	
    private String dealflag;*/

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getComputerid() {
		return computerid;
	}

	public void setComputerid(String computerid) {
		this.computerid = computerid;
	}

	public Date getCalltime() {
		return calltime;
	}

	public void setCalltime(Date calltime) {
		this.calltime = calltime;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getCallreason() {
		return callreason;
	}

	public void setCallreason(String callreason) {
		this.callreason = callreason;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getMainphone() {
		return mainphone;
	}

	public void setMainphone(String mainphone) {
		this.mainphone = mainphone;
	}

	public String getCallednum() {
		return callednum;
	}

	public void setCallednum(String callednum) {
		this.callednum = callednum;
	}

	public String getGdhf() {
		return gdhf;
	}

	public void setGdhf(String gdhf) {
		this.gdhf = gdhf;
	}

	public String getGdhfmath() {
		return gdhfmath;
	}

	public void setGdhfmath(String gdhfmath) {
		this.gdhfmath = gdhfmath;
	}

	public String getGdhfmathmore() {
		return gdhfmathmore;
	}

	public void setGdhfmathmore(String gdhfmathmore) {
		this.gdhfmathmore = gdhfmathmore;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDealresult() {
		return dealresult;
	}

	public void setDealresult(String dealresult) {
		this.dealresult = dealresult;
	}

	public String getAlarmtype() {
		return alarmtype;
	}

	public void setAlarmtype(String alarmtype) {
		this.alarmtype = alarmtype;
	}

	public Double getDealday() {
		return dealday;
	}

	public void setDealday(Double dealday) {
		this.dealday = dealday;
	}

	public Date getDealoverdate() {
		return dealoverdate;
	}

	public void setDealoverdate(Date dealoverdate) {
		this.dealoverdate = dealoverdate;
	}

	public String getAcceptunit() {
		return acceptunit;
	}

	public void setAcceptunit(String acceptunit) {
		this.acceptunit = acceptunit;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getBlnr() {
		return blnr;
	}

	public void setBlnr(String blnr) {
		this.blnr = blnr;
	}

	public String getJksydw() {
		return jksydw;
	}

	public void setJksydw(String jksydw) {
		this.jksydw = jksydw;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getBae001() {
		return bae001;
	}

	public void setBae001(String bae001) {
		this.bae001 = bae001;
	}

	public String getBae003() {
		return bae003;
	}

	public void setBae003(String bae003) {
		this.bae003 = bae003;
	}

	public String getBae010() {
		return bae010;
	}

	public void setBae010(String bae010) {
		this.bae010 = bae010;
	}

	public String getBae002() {
		return bae002;
	}

	public void setBae002(String bae002) {
		this.bae002 = bae002;
	}

	public String getBae013() {
		return bae013;
	}

	public void setBae013(String bae013) {
		this.bae013 = bae013;
	}

	public String getBae014() {
		return bae014;
	}

	public void setBae014(String bae014) {
		this.bae014 = bae014;
	}

	public String getBae015() {
		return bae015;
	}

	public void setBae015(String bae015) {
		this.bae015 = bae015;
	}

	public String getClfs() {
		return clfs;
	}

	public void setClfs(String clfs) {
		this.clfs = clfs;
	}

	public String getDljd() {
		return dljd;
	}

	public void setDljd(String dljd) {
		this.dljd = dljd;
	}

	public String getDlwd() {
		return dlwd;
	}

	public void setDlwd(String dlwd) {
		this.dlwd = dlwd;
	}

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCallreason_code() {
		return callreason_code;
	}

	public void setCallreason_code(String callreason_code) {
		this.callreason_code = callreason_code;
	}

	public String getGdhf_code() {
		return gdhf_code;
	}

	public void setGdhf_code(String gdhf_code) {
		this.gdhf_code = gdhf_code;
	}

	public String getDealresult_code() {
		return dealresult_code;
	}

	public void setDealresult_code(String dealresult_code) {
		this.dealresult_code = dealresult_code;
	}

	public String getAlarmtype_code() {
		return alarmtype_code;
	}

	public void setAlarmtype_code(String alarmtype_code) {
		this.alarmtype_code = alarmtype_code;
	}

	public String getAcceptunit_code() {
		return acceptunit_code;
	}

	public void setAcceptunit_code(String acceptunit_code) {
		this.acceptunit_code = acceptunit_code;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getJtbywly() {
		return jtbywly;
	}

	public void setJtbywly(String jtbywly) {
		this.jtbywly = jtbywly;
	}

	public String getJtbywlx() {
		return jtbywlx;
	}

	public void setJtbywlx(String jtbywlx) {
		this.jtbywlx = jtbywlx;
	}

	public String getJtbywdm() {
		return jtbywdm;
	}

	public void setJtbywdm(String jtbywdm) {
		this.jtbywdm = jtbywdm;
	}

	public String getRt_msg() {
		return rt_msg;
	}

	public void setRt_msg(String rt_msg) {
		this.rt_msg = rt_msg;
	}

	public Long getFail_count() {
		return fail_count;
	}

	public void setFail_count(Long fail_count) {
		this.fail_count = fail_count;
	}

	public Date getRingtime() {
		return ringtime;
	}

	public void setRingtime(Date ringtime) {
		this.ringtime = ringtime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getWaittime() {
		return waittime;
	}

	public void setWaittime(String waittime) {
		this.waittime = waittime;
	}

	public String getYwmyd() {
		return ywmyd;
	}

	public void setYwmyd(String ywmyd) {
		this.ywmyd = ywmyd;
	}

	public Date getVisittime() {
		return visittime;
	}

	public void setVisittime(Date visittime) {
		this.visittime = visittime;
	}

	public Date getSkilltime() {
		return skilltime;
	}

	public void setSkilltime(Date skilltime) {
		this.skilltime = skilltime;
	}

	public Date getSeattime() {
		return seattime;
	}

	public void setSeattime(Date seattime) {
		this.seattime = seattime;
	}

	public String getSendstate() {
		return sendstate;
	}

	public void setSendstate(String sendstate) {
		this.sendstate = sendstate;
	}

	public String getRecordid_code() {
		return recordid_code;
	}

	public void setRecordid_code(String recordid_code) {
		this.recordid_code = recordid_code;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getIstag() {
		return istag;
	}

	public void setIstag(String istag) {
		this.istag = istag;
	}

	public String getShicahng() {
		return shicahng;
	}

	public void setShicahng(String shicahng) {
		this.shicahng = shicahng;
	}

	public String getHangye() {
		return hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
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

	public String getIsdeal() {
		return isdeal;
	}

	public void setIsdeal(String isdeal) {
		this.isdeal = isdeal;
	}

	/*public String getDealflag() {
		return dealflag;
	}

	public void setDealflag(String dealflag) {
		this.dealflag = dealflag;
	}*/



}
