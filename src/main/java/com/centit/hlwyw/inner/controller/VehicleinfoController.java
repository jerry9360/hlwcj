package com.centit.hlwyw.inner.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.centit.hlwyw.core.util.ExportUtil;
import com.centit.hlwyw.inner.entity.ExportVehicleinfo;
import com.centit.hlwyw.inner.entity.Vehicle_info;
import com.centit.hlwyw.inner.service.Vehicle_infoService;

@Controller("vehicleinfoController")
@RequestMapping("/vehiclemgr/vehicleinfo")
public class VehicleinfoController extends BaseController {
	private static Logger log = Logger.getLogger(VehicleinfoController.class);  

	@Resource(name = "vehicle_infoServiceImpl")
	private Vehicle_infoService vehicle_infoService;

	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String list(String filename,
			@RequestParam(required=false) String vehicle_no,
			@RequestParam(required=false)  String corp_name,
			@PageableDefault(page = 0, size = 15) Pageable pageable,ModelMap model) {
		model.addAttribute("vehicle_no", vehicle_no);
		model.addAttribute("corp_name", corp_name);
		Page<Vehicle_info> page= vehicle_infoService.findSearch(  vehicle_no,  corp_name,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/vehicleinfo/list";
	}

	
	@RequestMapping(value = "/exportExcel",produces = "application/json; charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	public String generateExl(HttpServletRequest request,
			@RequestParam(required=false) String corp_name) {
		ExportUtil<ExportVehicleinfo> excel = new ExportUtil<ExportVehicleinfo>();
		String[] headers = { "车牌号", "车牌颜色", "企业名称"};
		List<Object[]> list = vehicle_infoService.findExcelList(corp_name);
		List<ExportVehicleinfo> vehicles=new ArrayList<ExportVehicleinfo>();
		ExportVehicleinfo vehicle=null;
		for (Object[] object : list) {
			vehicle=new ExportVehicleinfo();
			vehicle.setVehicle_id(Double.parseDouble(object[0].toString()));
			vehicle.setVehicle_no((String)object[1]);
			vehicle.setPlate_color_name((String)object[2]);
//			vehicle.setCorp_id((String)object[3]);
			vehicle.setCorp_name((String)object[4]);
			vehicles.add(vehicle);
		}

		if(corp_name==null){
			corp_name="";
		}
		String pathurl=request.getSession().getServletContext().getRealPath("")+"\\doc\\";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String filename="车辆信息"+corp_name+sdf.format(new Date());
		HSSFWorkbook workbook=excel.exportExcelMore(headers, vehicles);
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
	
}
