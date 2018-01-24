package com.centit.hlwyw.inner.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.ExportExcel;
import com.centit.hlwyw.core.util.ExportUtil;
import com.centit.hlwyw.inner.entity.Corpinfo;
import com.centit.hlwyw.inner.entity.ExportCorpinfo;
import com.centit.hlwyw.inner.service.CorpinfoService;



@Controller("corpinfoController")
@RequestMapping("/corpmgr/corpinfo")
public class CorpinfoController extends BaseController {
	private static Logger log = Logger.getLogger(CorpinfoController.class);  

	@Resource(name = "corpinfoServiceImpl")
	private CorpinfoService corpinfoService;

	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String list(String filename,
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String corp_short,
			@RequestParam(required=false) String industry,
			@PageableDefault(page = 0, size = 15) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("corp_short", corp_short);
		model.addAttribute("industry", industry);
		Page<Corpinfo> page= corpinfoService.findSearch( corp_name,  corp_short,  industry,  pageable);
		model.addAttribute("page", page);
		model.addAttribute("filename", filename);
		model.addAttribute("pageable", pageable);
		return "/corpinfo/list";
	}

	@RequestMapping(value="/editShortname",method = RequestMethod.POST)
	public String editShortname(String corp_id, String corp_short) {
		
		Corpinfo cor = corpinfoService.find(corp_id);
		cor.setCorp_short(corp_short);
		cor.setModify_date(new Date());
		corpinfoService.update(cor);
		return "redirect:/corpmgr/corpinfo/list";
	}
	
	@RequestMapping(value = "/exportExcel",produces = "application/json; charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	public String generateExl(HttpServletRequest request,
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String corp_short,
			@RequestParam(required=false)@Length(min=1,max=1) String industry) {
		ExportUtil<ExportCorpinfo> excel = new ExportUtil<ExportCorpinfo>();
		String[] headers = { "企业名称", "统一社会信用代码", "企业名称简称", "所属行业"};
		List<Object[]> list = corpinfoService.findList(corp_name,corp_short,industry);
		List<ExportCorpinfo> corps=new ArrayList<>();
		ExportCorpinfo corp=null;
		for (Object[] object : list) {
			 corp=new ExportCorpinfo();
			corp.setCorpid((String)object[0]);
			corp.setCorpname((String)object[1]);
			corp.setCreditcode((String)object[2]);
			corp.setCorpshort((String)object[3]);
			if(object[4].toString().equals("1")){
				corp.setIndustry("公路建设市场");
			}else if(object[4].toString().equals("2")){
				corp.setIndustry("水运建设市场");
			}else if(object[4].toString().equals("4")){
				corp.setIndustry("道路运输市场");
			}
			corps.add(corp);
		}
		String industrystr=null;
		if(industry.equals("1")){
			industrystr="公路建设市场";
		}else if(industry.equals("2")){
			industrystr="水运建设市场";
		}else if(industry.equals("4")){
			industrystr="道路运输市场";
		}else{
			industrystr="";
		}
		if(corp_name==null){
			corp_name="";
		}
		String pathurl=request.getSession().getServletContext().getRealPath("")+"\\doc\\";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String filename="从业企业"+industrystr+corp_name+sdf.format(new Date());
		HSSFWorkbook workbook=excel.exportExcelMore(headers, corps);
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(pathurl + filename + ".xls");
			workbook.write(os);
		} catch (FileNotFoundException e1) {
			log.error(e1.getMessage());log.info(e1);
		} catch (IOException e) {
			log.error(e.getMessage());log.info(e);
		}finally{
			if(os!= null){
				try {
					os.close();
				} catch (IOException e) {
					log.error(e.getMessage());log.info(e);

				}
			}
		}

		
 
		return filename+".xls";
	}
	

	/*
	 * Exl导入数据库
	 */
	@RequestMapping(value = "/excelToData", method = RequestMethod.GET)	
	public String readExl(String filename,HttpServletRequest request) {

		InputStream is = null;
		File file=new File(request.getSession().getServletContext().getRealPath("")+"/upload/"+filename);
		try {
			is = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Integer index = 0;
			Corpinfo corpinfo = null;
			Date createdate=null;
			Date modify_date=null;
			// 这个必须用接口
			for (Row row : sheet) {
				Integer index1 = 0;
				corpinfo=new Corpinfo();
				index++;
				if (index == 1) {
					continue;
				}
				for (Cell cell : row) {
					// cell.getCellType是获得cell里面保存的值的type
					// 如Cell.CELL_TYPE_STRING
					if (index1 == 0) {
						corpinfo.setCorp_id((String)ExportExcel.convertType(cell));
					}
					if (index1 == 1) {
						corpinfo.setCorp_name((String)ExportExcel.convertType(cell));
					}
					if (index1 == 2) {
						corpinfo.setIndustry(((String)ExportExcel.convertType(cell)));
					}
					if (index1 == 3) {
						corpinfo.setCorp_short((String)ExportExcel.convertType(cell));
					}
					if (index1 == 4) {
						if(ExportExcel.convertType(cell)!=null&&!"".equals((String)ExportExcel.convertType(cell))){
							createdate=sdf.parse((String)ExportExcel.convertType(cell));
						}else{
							createdate=new Date();
						}
						corpinfo.setCreate_date(createdate);
					}
					if (index1 == 5) {
						if(ExportExcel.convertType(cell)!=null&&!"".equals((String)ExportExcel.convertType(cell))){
							modify_date=sdf.parse((String)ExportExcel.convertType(cell));
 						}else{
							modify_date=new Date();
 						}
						corpinfo.setModify_date(modify_date);
					}
					index1++;
				}
				if(index!=0)
				corpinfoService.save(corpinfo);
			}
			file.delete();
		} catch (Exception e) {
			
			log.error(e.getMessage());log.info(e);
		} finally {
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage());log.info(e);
			}
		}
		return "redirect:/corpmgr/corpinfo/list";
	}
}

