package com.centit.hlwyw.inner.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.centit.hlwyw.inner.entity.ExportPerson;
import com.centit.hlwyw.inner.entity.Personinfo;
import com.centit.hlwyw.inner.service.PersoninfoService;

@Controller("personinfoController")
@RequestMapping("/permgr/personinfo")
public class PersoninfoController extends BaseController {
	private static Logger log = Logger.getLogger(PersoninfoController.class);  
	@Resource(name = "personinfoServiceImpl")
	private PersoninfoService personinfoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String filename, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String card_no,
			@RequestParam(required = false) String industry,
			@PageableDefault(page = 0, size = 15) Pageable pageable,
			ModelMap model) {
		model.addAttribute("name", name);
		model.addAttribute("card_no", card_no);
		model.addAttribute("industry", industry);
		name = StringUtils.isBlank(name) ? "%%" : "%" + name + "%";
		card_no = StringUtils.isBlank(card_no) ? "%%" : "%" + card_no + "%";
		Page<Personinfo> page = personinfoService.findSearchname(name, card_no,
				industry, pageable);
		model.addAttribute("page", page);
		model.addAttribute("filename", filename);
		model.addAttribute("pageable", pageable);
		return "/personinfo/list";
	}

	@RequestMapping(value = "/exportExcel",produces = "application/json; charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	public String generateExl(HttpServletRequest request,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String card_no,
			@RequestParam(required = false)@Length(min=1,max=1) String industry) {
		ExportUtil<ExportPerson> excel = new ExportUtil<ExportPerson>();
		String[] headers = {  "姓名","性别", "身份证", "所属行业"};
		List<Object[]> list = personinfoService.findList(name, card_no, industry);
		List<ExportPerson> persons=new ArrayList<>();
		ExportPerson person =null;
		for (Object[] object : list) {
			 person = new ExportPerson();
			person.setPerid((String)object[0]);
			person.setName((String)object[1]);
			person.setSex((String)object[2]);
			person.setCardno((String)object[3]);
			person.setIndustry((String)object[4]);
			persons.add(person);
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
		if(name==null){
			name="";
		}
		String pathurl=request.getSession().getServletContext().getRealPath("")+"\\doc\\";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String filename="从业人员"+industrystr+name+sdf.format(new Date());
		HSSFWorkbook workbook=excel.exportExcelMore(headers, persons);
		OutputStream os=null;
		

		
		try {
			os = new FileOutputStream(pathurl+filename+".xls");
			workbook.write(os);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());log.info(e);
		} catch (IOException e) {
			log.error(e.getMessage());log.info(e);
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e1) {
					log.error(e1.getMessage());log.info(e1);
 				}
			}
		}
		return filename+".xls";
	}
	


	/*
	 * Exl导入数据库
	 */
	@RequestMapping(value = "/excelToData", method = RequestMethod.GET)
	public String readExl(String filename, HttpServletRequest request) {

		InputStream is = null;
		File file = new File(request.getSession().getServletContext()
				.getRealPath("")
				+ "/upload/" + filename);
		try {
			is = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Personinfo personinfo = null;
			Integer index = 0;
			// 这个必须用接口
			for (Row row : sheet) {
				Integer index1 = 0;
				personinfo = new Personinfo();
				index++;
				if (index == 1) {
					continue;
				}
				for (Cell cell : row) {
					// cell.getCellType是获得cell里面保存的值的type
					// 如Cell.CELL_TYPE_STRING
					if (index1 == 0) {
						personinfo.setPerid((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 1) {
						personinfo.setName((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 2) {
						personinfo.setCard_no(((String) ExportExcel
								.convertType(cell)));
					}
					if (index1 == 3) {
						if (ExportExcel.convertType(cell) != null
								&& !"".equals((String) ExportExcel
										.convertType(cell))) {
							personinfo.setCreate_date(sdf
									.parse((String) ExportExcel
											.convertType(cell)));
						} else {
							personinfo.setCreate_date(new Date());
						}
					}
					if (index1 == 4) {
						if (ExportExcel.convertType(cell) != null
								&& !"".equals((String) ExportExcel
										.convertType(cell))) {
							personinfo.setModify_date(sdf
									.parse((String) ExportExcel
											.convertType(cell)));
						} else {
							personinfo.setModify_date(new Date());
						}
					}
					index1++;
				}
				if (index != 0)
					personinfoService.save(personinfo);
			}
			file.delete();
		} catch (InvalidFormatException e) {
			log.error(e.getMessage());log.info(e);
		} catch (IOException e) {
			log.error(e.getMessage());log.info(e);
		}catch (ParseException e) {
			log.error(e.getMessage());log.info(e);
		}  finally {
			try {
				if(is!=null){
					is.close();
				}

					
			} catch (IOException e) {
				log.error(e.getMessage());log.info(e);
			}
		}
		return "redirect:/permgr/personinfo/list";
	}

}
