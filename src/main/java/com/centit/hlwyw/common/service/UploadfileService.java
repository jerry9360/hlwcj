package com.centit.hlwyw.common.service;

import java.io.File;
import java.util.List;

import com.centit.hlwyw.common.entity.Uploadfile;
import com.centit.hlwyw.core.service.BaseService;

public interface UploadfileService extends BaseService<Uploadfile, String>  {
//	public String uploadFlash(File tempFile,Uploadfile file);
	public List<Uploadfile> findByIson(String ison);
	public void updateFileIson(String ison,String[] ids);
	public void updateFileIson(String ison,String ids);
	public void deleteUnIsonFile();
	void closeFileIson(String fileid);
	void openFileIson(String fileid);
}
