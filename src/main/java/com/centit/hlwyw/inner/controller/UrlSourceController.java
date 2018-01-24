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
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.ExportExcel;
import com.centit.hlwyw.inner.entity.UrlSource;
import com.centit.hlwyw.inner.service.UrlSourceService;

@Controller("urlSourceController")
@RequestMapping("/urlmgr/urlSource")
public class UrlSourceController extends BaseController {
	private static Logger log = Logger.getLogger(UrlSourceController.class);  
	@Resource(name = "urlSourceServiceImpl")
	private UrlSourceService urlSourceService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(String filename, 
			@RequestParam(required = false) String urlname,
			@PageableDefault(page = 0, size = 15) Pageable pageable,
			ModelMap model) {
		model.addAttribute("urlname", urlname);
		urlname = StringUtils.isBlank(urlname) ? "%%" : "%" + urlname + "%";
		Page<UrlSource> page = urlSourceService.findSearchname(urlname,
				pageable);
		model.addAttribute("page", page);
		model.addAttribute("filename", filename);
		model.addAttribute("pageable", pageable);
		return "urlsource/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save( @Valid UrlSource urlSource) {
		urlSource.setIsvalid("Y");
		if(urlSource.getIsstaticpage()==null){
		urlSource.setIsstaticpage("0");
		}
		if(StringUtils.isBlank(urlSource.getId())){
			urlSource.setCreateDate(new Date());
			urlSource.setModifyDate(new Date());
			urlSourceService.save(urlSource);
		}else{
			urlSource.setModifyDate(new Date());
			urlSourceService.update(urlSource);
		}
		return Constantval.CONSTANT_SUCCESS;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String toSave(ModelMap model) {
		return "/data/urlSource/form";
	}

	@RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UrlSource toEdit(@PathVariable String id) {
		UrlSource urlSource = urlSourceService.find(id);
		return urlSource;
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable String id, ModelMap model) {
		UrlSource urlSource = urlSourceService.find(id);
		model.addAttribute("urlSource", urlSource);
		return "/data/urlSource/detail";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id) {
		urlSourceService.deleteUrl(id);
		return "redirect:/urlmgr/urlSource";
	}

	/*
	 * 导出Exl
	 */
	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	@ResponseBody
	public String generateExl(HttpServletRequest request) {
		ExportExcel<UrlSource> ex = new ExportExcel<UrlSource>();
		String[] headers = { "ID", "网站名称", "版块名称", "板块链接地址", "是否静态翻页",
				"正文正则表达式", "翻页正则表达式", "可信度", "所属单位", "创建时间", "更新时间" };
		List<UrlSource> list = urlSourceService.findAll();
		for (UrlSource urlSource : list) {
			if ("0".equals(urlSource.getIsstaticpage())) {
				urlSource.setIsstaticpage("否");
			}
			if ("1".equals(urlSource.getIsstaticpage())) {
				urlSource.setIsstaticpage("是");
			}
			if ("0".equals(urlSource.getCredit())) {
				urlSource.setCredit("可信度低");
			}
			if ("1".equals(urlSource.getCredit())) {
				urlSource.setCredit("可信度高");
			}

		}

		OutputStream out = null;
		try {
			out = new FileOutputStream("D:/数据源.xls");
			ex.exportExcel(headers, list, out);
		} catch (FileNotFoundException e) {
			
			log.error(e.getMessage());log.info(e);
		} finally {
			try {
				if(out!=null){
					out.close();
					
				}

					
			} catch (IOException e) {
				log.error(e.getMessage());log.info(e);
			}
		}
		if (null == list||list.size()==0) {
			return "FAIL";
		} else {
			return "SUCCESS";
		}
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Integer index = 0;
			UrlSource urlSource = null;
			// 这个必须用接口
			for (Row row : sheet) {
				Integer index1 = 0;
				urlSource = new UrlSource();
				index++;
				if (index == 1) {
					continue;
				}
				for (Cell cell : row) {
					// cell.getCellType是获得cell里面保存的值的type
					// 如Cell.CELL_TYPE_STRING
					if (index1 == 0) {
						urlSource
								.setId(((String) ExportExcel.convertType(cell)));
					}
					if (index1 == 1) {
						if ((((String) ExportExcel.convertType(cell))
								.equals("政府监管"))) {
							urlSource.setWebtype("1");
						}
						if (((String) ExportExcel.convertType(cell))
								.equals("媒体评价")) {
							urlSource.setWebtype("2");
						}
						if (((String) ExportExcel.convertType(cell))
								.equals("其他")) {
							urlSource.setWebtype("3");
						}
					}
					if (index1 == 2) {
						urlSource.setWebname((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 3) {
						urlSource.setPlatename((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 4) {
						urlSource.setPlateurl((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 5) {
						if ((((String) ExportExcel.convertType(cell))
								.equals("是"))) {
							urlSource.setIsstaticpage("1");
						}
						if (((String) ExportExcel.convertType(cell))
								.equals("否")) {
							urlSource.setIsstaticpage("0");
						}
					}
					if (index1 == 6) {
						urlSource.setContentregex((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 7) {
						urlSource.setPageregex((String) ExportExcel
								.convertType(cell));
					}
					// if (index1 == 8) {
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("良好"))) {
					// urlSource.setTendency("1");
					// }
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("不良"))) {
					// urlSource.setTendency("2");
					// }
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("良好和不良"))) {
					// urlSource.setTendency("3");
					// }
					// }
					// if (index1 == 9) {
					// urlSource.setInfotype((String) ExportExcel
					// .convertType(cell));
					// }
					 if (index1 == 8) {
					 if ((((String) ExportExcel.convertType(cell))
					 .equals("可信度低"))) {
					 urlSource.setCredit("0");
					 }
					 if ((((String) ExportExcel.convertType(cell))
					 .equals("可信度高"))) {
					 urlSource.setCredit("1");
					 }
					 }
					// if (index1 == 11) {
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("从业企业"))) {
					// urlSource.setDirection("1");
					// }
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("从业人员"))) {
					// urlSource.setDirection("2");
					// }
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("从业企业和从业人员"))) {
					// urlSource.setDirection("3");
					// }
					// }
					if (index1 == 9) {
						urlSource.setUnitname((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 10) {
						if (ExportExcel.convertType(cell) != null
								&& !"".equals((String) ExportExcel
										.convertType(cell))) {
							urlSource.setCreateDate(sdf
									.parse((String) ExportExcel
											.convertType(cell)));
						} else {
							urlSource.setCreateDate(new Date());
						}
					}
					if (index1 == 11) {
						if (ExportExcel.convertType(cell) != null
								&& !"".equals((String) ExportExcel
										.convertType(cell))) {
							urlSource.setModifyDate(sdf
									.parse((String) ExportExcel
											.convertType(cell)));
						} else {
							urlSource.setModifyDate(new Date());
						}
					}
					index1++;
				}
				if (index != 0)
					urlSourceService.save(urlSource);
			}
			file.delete();
		}catch (InvalidFormatException e) {
			log.error(e.getMessage());log.info(e);
		} catch (IOException e) {
			log.error(e.getMessage());log.info(e);
		}catch (ParseException e) {
			log.error(e.getMessage());log.info(e);
		}finally {
			try {
				if(is!=null){
					is.close();
				}

			} catch (IOException e) {
				log.error(e.getMessage());log.info(e);
			}
		}
		return "redirect:/urlmgr/urlSource";
	}
}
