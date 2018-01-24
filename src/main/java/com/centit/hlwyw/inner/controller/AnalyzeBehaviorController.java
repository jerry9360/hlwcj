package com.centit.hlwyw.inner.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.inner.entity.Business_root;
import com.centit.hlwyw.inner.entity.Business_secondary;
import com.centit.hlwyw.inner.entity.Industry_type;
import com.centit.hlwyw.inner.service.Business_rootService;
import com.centit.hlwyw.inner.service.Business_secondaryService;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;
import com.centit.hlwyw.inner.service.Industry_typeService;

@Controller("analyzeBehaviorController")
@RequestMapping("/analyzemgr/behavior")
public class AnalyzeBehaviorController  extends BaseController{
	
	private static Logger log = Logger.getLogger(AnalyzeBehaviorController.class);
	
	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_dataService;
	
	@Resource(name = "business_rootServiceImpl")
	private Business_rootService business_rootService;
	
	@Resource(name = "business_secondaryServiceImpl")
	private Business_secondaryService business_secondaryService;
	
	@Resource(name = "industry_typeServiceImpl")
	private Industry_typeService industry_typeService;
	
		/**
		 * List
		 */
			@RequestMapping(method = RequestMethod.GET)
			public String indexAnalyze(
					@RequestParam(required=false) String industry,
					@RequestParam(required=false) String btype,
//					@RequestParam(required=false) String time,
					@RequestParam(required=false) String timetype,
					@RequestParam(required=false) String begindate,
					@RequestParam(required=false) String enddate,
					ModelMap model) {
				if("".equals(begindate)){
					begindate = null;
				}if("".equals(enddate)){
					enddate = null;
				}if("".equals(industry)||industry==null){
					industry = "公共交通";
				}if("".equals(btype)||btype==null){
					btype = "投诉类";
				}
				List<Industry_type> industrys=industry_typeService.findAll();
				List<Business_root> roots=business_rootService.findAll();
				for (Business_root root : roots) {
					List<Business_secondary> secondarys=business_secondaryService.findByRootid(root.getRoot_id());
					root.setSecondarys(secondarys);
				}
				List<Business_secondary> secondarys=business_secondaryService.findAll();
				hnii_analyze_dataService.init_analyzeBehavior(industry, btype,timetype,begindate,enddate,model);
				model.addAttribute("industrys",industrys);
				model.addAttribute("roots",roots);
				model.addAttribute("secondarys",secondarys);
				return "/analyzehnii/behavior";
			}
}
