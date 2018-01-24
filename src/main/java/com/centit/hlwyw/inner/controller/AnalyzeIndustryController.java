package com.centit.hlwyw.inner.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;
import com.centit.hlwyw.inner.service.impl.TimeServiceImpl;

@Controller("analyzeIndustryController")
@RequestMapping("/analyzemgr/industry")
public class AnalyzeIndustryController  extends BaseController{
	
	private static Logger log = Logger.getLogger(AnalyzeIndustryController.class);
	
	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_dataService;
	
	@Resource(name = "timeServiceImpl")
	private TimeServiceImpl timeService;
	
	/**
	 * List
	 */
		@RequestMapping(method = RequestMethod.GET)
		public String indexAnalyze(
//				@RequestParam(required=false) String time,
				@RequestParam(required=false) String timetype,
				@RequestParam(required=false) String begindate,
				@RequestParam(required=false) String enddate,
				ModelMap model) {
			String[] date = new String[2];
//			time 0 近一周  1  近一个月  2 今年  3 今年
//			if(begindate==null&&enddate==null){
//			if("0".equals(time)){
//				date = timeService.getWeek();
//			}else if("1".equals(time)){
//				date = timeService.getMonth();
//			}else if("2".equals(time)){
//				date = timeService.getThisYear();
//			}else if("3".equals(time)){
//				date = timeService.getLastYear();
//				}
//			begindate = date[0];
//			enddate = date[1];
//			}
//			List<Object[]> list=new ArrayList<Object[]>();//List集合中存放Map集合
			hnii_analyze_dataService.init_analyzeIndustry("industry",timetype,begindate,enddate,model);
//			List<Object> industryAndCount = hnii_analyze_dataService.findIndustryAndCount();
//			Object[] listtitle = hnii_analyze_dataService.getAxis(industryAndCount);
//			Object xcoordinatesData = listtitle[0];
//			Object ycoordinatesData = listtitle[1];
//			model.addAttribute("xAxis",xcoordinatesData);
//			model.addAttribute("yAxis",ycoordinatesData);
//			model.addAttribute("list",list);
			return "/analyzehnii/industry";
		}

}
