package com.centit.hlwyw.inner.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;
import com.centit.hlwyw.sys.service.IndexService;

@Controller("analyzeAnalyzeController")
@RequestMapping("/analyzemgr/analyze")
public class AnalyzeAnalyzeController  extends BaseController{
	
	private static Logger log = Logger.getLogger(AnalyzeAnalyzeController.class);
	
	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_dataService;
	
	@Resource(name = "indexServiceImpl")
	private IndexService indexService;
	
	/**
	 * List
	 */
		@RequestMapping(method = RequestMethod.GET)
		public String indexAnalyze(ModelMap model) {
			List<Object[]> object = indexService.analyzeCount();
			Object xAxis = indexService.getXEchartsdata(object,"X");
			Object yAxis = indexService.getXEchartsdata(object,"Y");
			model.addAttribute("object", object);
			model.addAttribute("xAxis", xAxis);
			model.addAttribute("yAxis", yAxis);
			return "/analyzehnii/businessdata";
		}

}
