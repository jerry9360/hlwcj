package com.centit.hlwyw.inner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;

@Controller("analyzeBusinessController")
@RequestMapping("/analyzemgr/business")
public class AnalyzeBusinessController  extends BaseController{
	
	private static Logger log = Logger.getLogger(AnalyzeBusinessController.class);
	
	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_dataService;
	
	/**
	 * List
	 */
		@RequestMapping(method = RequestMethod.GET)
		public String indexAnalyze(@RequestParam(required=false) String time,
		@RequestParam(required=false) String timetype,
		@RequestParam(required=false) String begindate,
		@RequestParam(required=false) String enddate,
		ModelMap model) {
			hnii_analyze_dataService.init_analyzeIndustry("btype",timetype,begindate,enddate,model);
			return "/analyzehnii/business";
		}

}
