package com.centit.hlwyw.common.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.centit.hlwyw.common.FileInfo.FileType;
import com.centit.hlwyw.common.entity.Uploadfile;

/**
 * Service - File
 * 
 */
public interface FileService {

	/**
	 * Upload file
	 * 
	 * @param fileType
	 * @param multipartFile
	 * @param async
	 * @return file URL
	 */
	String upload(FileType fileType, MultipartFile multipartFile, boolean async);

	/**
	 * Upload file asynchronously
	 * 
	 * @param fileType
	 * @param multipartFile
	 * @return file URL
	 */
	String upload(FileType fileType, MultipartFile multipartFile);
	
	String serverUpload(File file,String filename);

	/**
	 * Download file asynchronously
	 * 
	 * @param fileType
	 * @param fileName
	 * @param multipartFile
	 * @param localPath
	 * @return true or false
	 */
//	String download(String fileid);
	
/*	String downloadfile(String fileid, String filename, String path);*/
	
//	boolean delete(String fileid);
	
	void deleteTemp(String id);
	
//	String upload(File tempFile,Uploadfile file);
	
//	void docToFlash(String id);

}