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
import com.centit.hlwyw.inner.entity.Order_source;
import com.centit.hlwyw.inner.service.Order_sourceService;

@Controller("order_sourceController")
@RequestMapping("/urlmgr/order_source")
public class Order_sourceController extends BaseController {
	private static Logger log = Logger.getLogger(Order_sourceController.class);  

	@Resource(name = "order_sourceServiceImpl")
	private Order_sourceService order_sourceService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(String filename, HttpSession session,
			@RequestParam(required = false) String urlname,
			@PageableDefault(page = 0, size = 15) Pageable pageable,
			ModelMap model) {
		model.addAttribute("urlname", urlname);
		urlname = StringUtils.isBlank(urlname) ? "%%" : "%" + urlname + "%";
		Page<Order_source> page = order_sourceService.findSearchname(urlname,
				pageable);
		model.addAttribute("page", page);
		model.addAttribute("filename", filename);
		model.addAttribute("pageable", pageable);
		return "order_source/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@Valid Order_source order_source) {
		order_source.setIsvalid("Y");
		if(StringUtils.isBlank(order_source.getId())){
			order_source.setCreateDate(new Date());
			order_source.setModifyDate(new Date());
			order_sourceService.save(order_source);
		}else{
			order_source.setModifyDate(new Date());
			order_sourceService.update(order_source);
		}
		return Constantval.CONSTANT_SUCCESS;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String toSave() {
		return "/data/order_source/form";
	}

	@RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Order_source toEdit(@PathVariable String id) {
		Order_source order_source = order_sourceService.find(id);
		return order_source;
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable String id, ModelMap model) {
		Order_source order_source = order_sourceService.find(id);
		model.addAttribute("order_source", order_source);
		return "/data/order_source/detail";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id) {
		order_sourceService.deleteUrl(id);
		return "redirect:/urlmgr/order_source";
	}

	/*
	 * 导出Exl
	 */
	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	@ResponseBody
	public String generateExl() {
		ExportExcel<Order_source> ex = new ExportExcel<Order_source>();
		String[] headers = { "ID", "网站名称", "版块名称", "板块链接地址", "是否静态翻页",
				"正文正则表达式", "翻页正则表达式", "可信度", "所属单位", "创建时间", "更新时间" };
		List<Order_source> list = order_sourceService.findAll();

		for (Order_source order_source : list) {
			if ("0".equals(order_source.getCredit())) {
				order_source.setCredit("可信度低");
			}
			if ("1".equals(order_source.getCredit())) {
				order_source.setCredit("可信度高");
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
			Workbook wb;
			wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Integer index = 0;
			Order_source order_source = null;
			// 这个必须用接口
			for (Row row : sheet) {
				Integer index1 = 0;
				order_source = new Order_source();
				index++;
				if (index == 1) {
					continue;
				}
				for (Cell cell : row) {
					// cell.getCellType是获得cell里面保存的值的type
					// 如Cell.CELL_TYPE_STRING
					if (index1 == 0) {
						order_source
								.setId(((String) ExportExcel.convertType(cell)));
					}
//					if (index1 == 1) {
//					}
					if (index1 == 2) {
						order_source.setWebname((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 3) {
						order_source.setPlatename((String) ExportExcel
								.convertType(cell));
					}
//					if (index1 == 4) {
////						order_source.setPlateurl((String) ExportExcel
////								.convertType(cell));
//					}
//					if (index1 == 5) {
//						if ((((String) ExportExcel.convertType(cell))
//								.equals("是"))) {
////							order_source.setIsstaticpage("1");
//						}
//						if (((String) ExportExcel.convertType(cell))
//								.equals("否")) {
////							order_source.setIsstaticpage("0");
//						}
//					}
//					if (index1 == 6) {
////						order_source.setContentregex((String) ExportExcel
////								.convertType(cell));
//					}
//					if (index1 == 7) {
////						order_source.setPageregex((String) ExportExcel
////								.convertType(cell));
//					}
					// if (index1 == 8) {
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("良好"))) {
					// order_source.setTendency("1");
					// }
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("不良"))) {
					// order_source.setTendency("2");
					// }
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("良好和不良"))) {
					// order_source.setTendency("3");
					// }
					// }
					// if (index1 == 9) {
					// order_source.setInfotype((String) ExportExcel
					// .convertType(cell));
					// }
					 if (index1 == 8) {
					 if ((((String) ExportExcel.convertType(cell))
					 .equals("可信度低"))) {
					 order_source.setCredit("0");
					 }
					 if ((((String) ExportExcel.convertType(cell))
					 .equals("可信度高"))) {
					 order_source.setCredit("1");
					 }
					 }
					// if (index1 == 11) {
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("从业企业"))) {
					// order_source.setDirection("1");
					// }
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("从业人员"))) {
					// order_source.setDirection("2");
					// }
					// if ((((String) ExportExcel.convertType(cell))
					// .equals("从业企业和从业人员"))) {
					// order_source.setDirection("3");
					// }
					// }
					if (index1 == 9) {
						order_source.setUnitname((String) ExportExcel
								.convertType(cell));
					}
					if (index1 == 10) {
						if (ExportExcel.convertType(cell) != null
								&& !"".equals((String) ExportExcel
										.convertType(cell))) {
	 							order_source.setCreateDate(sdf
										.parse((String) ExportExcel
												.convertType(cell)));
	 					} else {
							order_source.setCreateDate(new Date());
						}
					}
					if (index1 == 11) {
						if (ExportExcel.convertType(cell) != null
								&& !"".equals((String) ExportExcel
										.convertType(cell))) {
	 							order_source.setModifyDate(sdf
										.parse((String) ExportExcel
												.convertType(cell)));
	 
						} else {
							order_source.setModifyDate(new Date());
						}
					}
					index1++;
				}
				if (index != 0)
					order_sourceService.save(order_source);
			}
			file.delete();
		}catch (InvalidFormatException e) {
			log.error(e.getMessage());log.info(e);
		} catch (IOException e) {
			log.error(e.getMessage());log.info(e);
		}catch (ParseException e) {
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
		return "redirect:/urlmgr/order_source";
	}
}
