package com.centit.hlwyw.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uploadfile")
public class Uploadfile  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;
	
	/** 是否关联： 0 未关联 */
	public final static String CONSTANT_ISON_ZERO = "0";
	
	/** 是否关联： 1 关联 */
	public final static String CONSTANT_ISON_ONE = "1";

	/** ID */
	@Id
	@Column(name="id")	 
	private String id;	
	@Column(name = "filename")	
    private String filename;
	@Column(name = "fileext")	
    private String fileext;
	@Column(name = "filecontent")	
    private byte[] filecontent;
	@Column(name = "recordder")	
    private String recordder;
	@Column(name = "updatedate")	
    private Date updatedate;
	@Column(name = "ison")	
    private String ison;
	@Column(name = "filesize")
	private String filesize;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileext() {
		return fileext;
	}
	public void setFileext(String fileext) {
		this.fileext = fileext;
	}
	public byte[] getFilecontent() {
 		byte[] ret = null;
		 if ( this.filecontent != null ) {
			 ret = new byte[filecontent.length];
			 for (int i = 0; i < filecontent.length; i++) {
			 ret[i] = this.filecontent[i]; 
			 }
		 }
		 return ret;
 	}
	public void setFilecontent(byte[] filecontent) {
 		 this.filecontent = new byte[filecontent.length];
		 for (int i = 0; i < filecontent.length; ++i)
		 this.filecontent[i] = filecontent[i];
	
	}
	public String getRecordder() {
		return recordder;
	}
	public void setRecordder(String recordder) {
		this.recordder = recordder;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getIson() {
		return ison;
	}
	public void setIson(String ison) {
		this.ison = ison;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
}
