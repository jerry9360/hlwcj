package com.centit.hlwyw.common.service.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.centit.hlwyw.common.FileInfo.FileType;
import com.centit.hlwyw.common.entity.Uploadfile;
import com.centit.hlwyw.common.service.FileService;
import com.centit.hlwyw.common.service.UploadfileService;


@Service("fileServiceImpl")
public class FileServiceImpl implements FileService, ServletContextAware {
	private static Logger log = Logger.getLogger(FileServiceImpl.class);  

	/** servletContext */
	private ServletContext servletContext;

	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;

	@Resource(name = "uploadfileServiceImpl")
	private UploadfileService uploadfileService;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	/**
	 * add upload task
	 * 
	 * @param storagePlugin
	 * @param path
	 * @param tempFile
	 * @param contentType
	 */
	private void addTask(
			final File tempFile, final String contentType) {
		taskExecutor.execute(new Runnable() {
			public void run() {

			}
		});
	}
	
	@Override
	public String upload(FileType fileType, MultipartFile multipartFile,
			boolean async) {
		if (multipartFile == null) {
			return null;
		}
		
//		String fileId = null;
		String id = null;
			
		try {
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("uuid", UUID.randomUUID().toString());
			String fileName = multipartFile.getOriginalFilename();
			if(fileName!=null){
				if(fileName.endsWith(".jsp")||fileName.endsWith(".js")||fileName.endsWith(".html")||fileName.endsWith("htm")){
					return "{\"state\":\"请确认文件类型\"}";
				}
			}
			
			
			String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
			id = UUID.randomUUID().toString();
			id = id.replace("-", "");
			File tempFile = new File(servletContext.getContextPath()
					+ "/file/" + id + "." + prefix);
			if (!tempFile.getParentFile().exists()) {
				tempFile.getParentFile().mkdirs();
			}
			multipartFile.transferTo(tempFile);
			return id;

		} catch (IllegalStateException e) {
			log.error(e.getMessage());log.info(e);

		} catch (IOException e) {
			log.error(e.getMessage());log.info(e);

		}
		return null;
	}
	
	@Override
	public String serverUpload(File file,String filename){
		if (file == null) {
			return null;
		}
		
		String fileId = null;
		String id = null;
		try {
			String prefix = filename.substring(filename.lastIndexOf(".") + 1);
			id = UUID.randomUUID().toString();
			id = id.replace("-", "");
			File tempFile = new File(System.getProperty("java.io.tmpdir")
					+ "/upload_" + id + "." + prefix);
			if (!tempFile.getParentFile().exists()) {
				tempFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(file, tempFile);
//			fileId = uploadfile(tempFile);
			// 保存数据库
			byte[] filecontent = toinputStream(tempFile);
			id = saveUploadfile(id,filecontent,fileId, prefix, filename,null);
			return fileId + "," + id;

		} catch (IOException e) {
			log.error(e.getMessage());log.info(e);

		}
		return null;
	}
//
//	private String uploadfile(File tempFile)  {
//		return null;
//	}
//	
//	public String upload(File tempFile,Uploadfile file){
//		return null;
//	}

	@Override
	public String upload(FileType fileType, MultipartFile multipartFile) {
		return upload(fileType, multipartFile, false);
	}
//	@Override
//	public String download(String fileid) {
//		return null;
//	}
//	
//	
//	
//	@Override
//	public boolean delete(String fileid) {
//		return true;
//	}
	
	@Override
	public void deleteTemp(String id){
		Uploadfile docfile = uploadfileService.find(id);
		if(docfile!=null){
			String ext = '.' + docfile.getFileext().toLowerCase();
			String fromfileName = System.getProperty("java.io.tmpdir") +"/upload_"+docfile.getId()+ext;
			File tempFile = new File(fromfileName);
			if(tempFile!=null&&tempFile.exists()){
				FileUtils.deleteQuietly(tempFile);
			}
		}
	}


	private String saveUploadfile(String id,byte[] filecontent, String fileid,String prefix,String filename,String filesize){
		Uploadfile obj = new Uploadfile();
		obj.setId(id);
		obj.setFilecontent(filecontent);
		obj.setFileext(prefix);
		obj.setFilename(filename);
		obj.setIson(Uploadfile.CONSTANT_ISON_ZERO);
		obj.setUpdatedate(new Date());
		obj.setFilesize(filesize);
		uploadfileService.save(obj);
		return obj.getId();
	}
	
//	private  byte[] parseByteArray(File file) throws IOException{
//		byte[] buffer  = new byte[(int) file.length()];
//		FileInputStream fis = new FileInputStream(file);
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		while ((fis.read(buffer )) >0) {
//			baos.write(buffer);
//		}
//		buffer = baos.toByteArray();
//		fis.close();
//		baos.close();
//		return buffer;
//	}
//	
	private byte[] toinputStream(File file) throws IOException {
		byte[] a = new byte[1048576];
		FileInputStream fis;
		fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		if(bis!=null){
			bis.read(a);
			bis.close();
		}
		if(fis!=null){
			fis.close();
		}
		return a;
	}
//	@Override
//	public void docToFlash(String id) {
// 		
//	}
}
