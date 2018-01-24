package com.centit.hlwyw.common.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.centit.hlwyw.common.FileInfo.FileType;
import com.centit.hlwyw.common.service.FileService;
import com.centit.hlwyw.common.service.UploadfileService;

@Controller("uploadfileController")
@RequestMapping("/common/file")
public class UploadfileController {
	
	private static Logger log = Logger.getLogger(UploadfileController.class);  


	@Resource(name = "fileServiceImpl")
	private FileService fileService;

	@Resource(name = "uploadfileServiceImpl")
	private UploadfileService uploadfileService;

//	@RequestMapping(method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
//	public @ResponseBody String handleFormUpload(HttpServletRequest request,
//			HttpServletResponse response) {
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		MultipartFile file = multipartRequest.getFile("upfile");
//		if (file == null) {
//			return "{\"state\":\"没有需要上传的文件\"}";
//		}
//		if (file.getSize() == 0) {
//			return "{\"state\":\"没有需要上传的文件\"}";
//		}
//		String fileSize = "";
//		if (file.getSize() > 1024 * 1024) {
//			fileSize = (Math.round(file.getSize() * 100 / (1024 * 1024)) / 100)
//					+ "MB";
//		} else {
//			fileSize = (Math.round(file.getSize() * 100 / 1024) / 100) + "KB";
//		}
//		String type = file.getContentType();
//		String str = fileService.upload(FileType.file, file);
//		if (str == null) {
//
//			return "{\"state\":\"上传文件失败\"}";
//		}
//		String[] strArr = str.split(",");
//		String filename=file.getOriginalFilename();
//		if(filename!=null){
//			if(filename.endsWith(".jsp")||filename.endsWith(".js")||filename.endsWith(".html")||filename.endsWith("htm")){
//				return "{\"state\":\"请确认文件类型\"}";
//			}
//		}
//		
//		String str_utf = "{\"path\":\""
//				+ strArr[0].substring(0, strArr[0].lastIndexOf("/"))
//				+ "\",\"fileType\":\"" + type
//				+ "\",\"state\":\"SUCCESS\",\"url\":\""
//				+ strArr[0].replaceFirst("group1/", "/") + "\",\"fileSize\":\""
//				+ fileSize + "\",\"name\":\"" + filename
//				+ "\",\"id\":\"" + strArr[1] + "\"}";
//		return str_utf;
//	}

	@RequestMapping(value = "/News", method = RequestMethod.POST)
	@ResponseBody
	public String NewsImageUpload(HttpServletRequest request,
			HttpServletResponse response) throws IOException  {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("upfile");
		String filename=file.getOriginalFilename();
		if(filename!=null){
			if(filename.endsWith(".jsp")||filename.endsWith(".js")||filename.endsWith(".html")||filename.endsWith("htm")){
				return "{\"state\":\"请确认文件类型\"}";
			}
		}
		SaveFileFromInputStream(file.getInputStream(), request.getSession()
				.getServletContext().getRealPath("")
				+ "/upload", filename);
		return filename;
	}

	public void SaveFileFromInputStream(InputStream stream, String path,
			String savefile) throws IOException {
		System.out.println("------------" + path + "/" + savefile);
		FileOutputStream fs = new FileOutputStream(path + "/" + savefile);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		
		stream.close();
		if(fs!=null){
			fs.close();
		}
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String downloadfile(String filename,
 			HttpServletResponse response,
			HttpServletRequest request) throws UnsupportedEncodingException {
		filename = URLEncoder.encode(filename, "UTF-8");
		String filepath = "E:/doc/" + filename;
		FileInputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(new File(filepath));
			if (in != null) {
				// 所有不想下载的文件格式添加
				// if(!(filetype.equals("text")||filetype.equals("image")||filetype.equals("png")||filetype.equals("jpg")))
				response.setContentType("application/x-msdownload");
				// 2.设置文件头：最后一个参数是设置下载文件名
				response.setHeader("Content-Disposition",
						"attachment;filename="
								+ new String(filename.getBytes("gbk"), "iso-8859-1"));
				out = response.getOutputStream();
				byte[] buf = new byte[1048576];
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
			}
		} catch (IOException e) {
			log.error(e.getMessage());
			log.info(e); 	
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException ex2) {
				log.error(ex2.getMessage());
				log.info(ex2); 			
			}
		}
		return null;
	}

	// 单表导出弹出
	@RequestMapping(value = "/down", method = RequestMethod.GET)
	public String downloadfile(String filesource, String filename,
 			HttpServletResponse response) {

		OutputStream out = null;
		InputStream in = null;
		try {
			// 所有不想下载的文件格式添加
			// if(!(filetype.equals("text")||filetype.equals("image")||filetype.equals("png")||filetype.equals("jpg")))
			response.setContentType("application/x-msdownload");
			// 2.设置文件头：最后一个参数是设置下载文件名
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(filename, "UTF-8"));
			in = new FileInputStream(filesource);
			out = response.getOutputStream();
			byte[] tempbytes = new byte[1024];
			int byteread = 0;
			while ((byteread = in.read(tempbytes)) != -1) {
				out.write(tempbytes, 0, tempbytes.length);
			}
		} catch (IOException e) {
			log.error(e.getMessage());
			log.info(e); 			
		} finally {
			try {
				if(out!=null){
					out.flush();
				}
				if(in!=null){
					in.close();
				}
				if(out!=null){
					out.close();
					
				}
			} catch (IOException ex2) {
				log.error(ex2.getMessage());
				log.info(ex2); 			
			}
		}
		return null;
	}

	// 多表导出弹出
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String downloadfile(String filesource, String filename,
			String index, ModelMap model, HttpServletResponse response) {

		byte[] buffer = new byte[1024];
		ZipOutputStream out1 = null;
		String tmpFileName = "File.zip";
		try {
			out1 = new ZipOutputStream(new FileOutputStream("D:/File.zip"));
			File[] file = new File[Integer.parseInt(index)];
			int imax=Integer.parseInt(index); 
			for (int i = 1; i <= imax; i++) {
//				int s = filename.lastIndexOf('.');
//				String head1 = filename.substring(0, s);
//				String tail1 = filename.substring(s);
//				String filename1 = head1 + i + tail1;
				int c = filesource.lastIndexOf('.');
				String head2 = filesource.substring(0, c);
				String tail2 = filesource.substring(c);
				String filesource1 = head2 + i + tail2;
				file[i - 1] = new File(filesource1);
			}
			FileInputStream fis =null;
			for (int i = 0; i < file.length; i++) {
				 fis = new FileInputStream(file[i]);
				out1.putNextEntry(new ZipEntry(file[i].getName()));
				// 设置压缩文件内的字符编码，不然会变成乱码
				out1.setEncoding("GBK");
				int len;
				// 读入需要下载的文件的内容，打包到zip文件
				while ((len = fis.read(buffer)) > 0) {
					out1.write(buffer, 0, len);
				}
				out1.closeEntry();
				fis.close();
			}
			
			this.downFile(response, tmpFileName);
		} catch (IOException e) {
			log.error(e.getMessage());
			log.info(e); 	
		}finally{
			if(out1!=null){
				try {
					out1.close();
				} catch (IOException e) {
					log.error(e.getMessage());
					log.info(e); 	
				}
			}
		}
		return null;
	}

	private void downFile(HttpServletResponse response, String tmpFileName) {
		InputStream ins =null;
		BufferedInputStream bins =null;
		BufferedOutputStream bouts = null;
		try {
			File file = new File("D:/File.zip");
			if (file.exists()) {
				  ins = new FileInputStream("D:/File.zip");
				 bins = new BufferedInputStream(ins);// 放到缓冲流里面
				OutputStream outs = response.getOutputStream();// 获取文件输出IO流
				 bouts = new BufferedOutputStream(outs);
				response.setContentType("application/x-download");// 设置response内容的类型
				response.setHeader(
						"Content-disposition",
						"attachment;filename="
								+ URLEncoder.encode(tmpFileName, "UTF-8"));// 设置头部信息
				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				// 开始向网络传输文件流
				while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
					bouts.write(buffer, 0, bytesRead);
				}
				bouts.flush();// 这里一定要调用flush()方法
				
				outs.close();
 			}
		} catch (IOException e) {
			log.error(e.getMessage());
			log.info(e); 	
		}finally{
			if(ins!=null){
				try {
					ins.close();
				} catch (IOException e) {
					log.error(e.getMessage());
					log.info(e); 				
				}
			}
			if(bouts!=null){
				try {
					bouts.close();
				} catch (IOException e) {
					log.error(e.getMessage());
					log.info(e); 				
				}
			}
			if(bins!=null){
				try {
					bins.close();
				} catch (IOException e) {
					log.error(e.getMessage());
					log.info(e); 	
				}

			}
		}
	}
}
