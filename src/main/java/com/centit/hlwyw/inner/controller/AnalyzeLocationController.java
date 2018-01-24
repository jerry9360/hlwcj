package com.centit.hlwyw.inner.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.inner.entity.Hnii_analyze_data;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;
import com.centit.hlwyw.inner.service.impl.TimeServiceImpl;

@Controller("analyzeLocationController")
@RequestMapping("/analyzemgr/location")
public class AnalyzeLocationController  extends BaseController{
	
	private static Logger log = Logger.getLogger(AnalyzeLocationController.class);
	
	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_dataService;
	
	@Resource(name = "timeServiceImpl")
	private TimeServiceImpl timeService;
	
	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String time,
			@RequestParam(required=false)  String begindate,
			@RequestParam(required=false)   String enddate,
			ModelMap model) {
			String[] date = new String[2];
			if("".equals(begindate)||"".equals(enddate)){
				begindate=null;
				enddate=null;
			}
//			0 近一周  1  近一个月  2 今年  3 今年
			if(begindate==null&&enddate==null){
			if("0".equals(time)){
				date = timeService.getWeek();
			}else if("1".equals(time)){
				date = timeService.getMonth();
			}else if("2".equals(time)){
				date = timeService.getThisYear();
			}else if("3".equals(time)){
				date = timeService.getLastYear();
				}
			begindate = date[0];
			enddate = date[1];
			}
			List<Object> page = hnii_analyze_dataService.findLocationDatas(begindate,enddate);
			Object[] xAxis = hnii_analyze_dataService.getAxis(page);
			model.addAttribute("xAxis", xAxis[0]);
			model.addAttribute("yAxis", xAxis[1]);
			model.addAttribute("page", page);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
			if(begindate!=null&&enddate!=null){
			try {
				Date begindat = sdf.parse(begindate);
				Date enddat = sdf.parse(enddate);
				model.addAttribute("begindate", begindat);
				model.addAttribute("enddate", enddat);
			} catch (ParseException e) {
				e.printStackTrace();
				}
			}
		return "/analyzelocation/list";
	}
	
	/**
	 * 查看详情
	 */
	@RequestMapping(value = "/show")
	public String projectDetail(@RequestParam(required=false)  String baddress,
			@RequestParam(required=false) String datatype,
			@PageableDefault(page = 0, size = 15) Pageable pageable,
			ModelMap model) {
		Page<Hnii_analyze_data> page = hnii_analyze_dataService.findList(baddress,pageable);
		model.addAttribute("page", page);
		model.addAttribute("carno", baddress);
		model.addAttribute("pageable", pageable);
		return "/analyzelocation/show";
	}

}
