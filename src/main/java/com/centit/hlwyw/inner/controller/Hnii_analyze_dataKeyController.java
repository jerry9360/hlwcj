package com.centit.hlwyw.inner.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Past;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

import com.centit.hlwyw.cache.CacheUtil;
import com.centit.hlwyw.cache.Cachemodel;
import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.ExportUtil;
import com.centit.hlwyw.inner.entity.Business_root;
import com.centit.hlwyw.inner.entity.Business_secondary;
import com.centit.hlwyw.inner.entity.ExportHnii;
import com.centit.hlwyw.inner.entity.Hnii_analyze_data;
import com.centit.hlwyw.inner.service.Business_rootService;
import com.centit.hlwyw.inner.service.Business_secondaryService;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;
import com.centit.hlwyw.solr.service.SolrService;

@Controller("hnii_analyze_datakeyController")
@RequestMapping("/hnii_analyze/hnii_analyze_datakey")
public class Hnii_analyze_dataKeyController extends BaseController {
	private static Logger log = Logger.getLogger(Hnii_analyze_dataKeyController.class);  

	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_dataService;
	
	@Resource(name = "business_rootServiceImpl")
	private Business_rootService business_rootService;
	
	@Resource(name = "business_secondaryServiceImpl")
	private Business_secondaryService business_secondaryService;
	
	@Resource(name = "solrServiceImpl")
	private SolrService solrService;

	 
	/**
	 * kerwordList
	 */
	@RequestMapping(method = RequestMethod.GET)
	String listshow(
			@RequestParam(required=false) String btype,
			@RequestParam(required=false) String keyword,
			@PageableDefault(page = 0, size = 15) Pageable pageable,
			ModelMap model) {
//		content:*反映* AND content:*110* AND btype:反映情况类
		List<Business_root> roots=business_rootService.findAll();
		Page<Hnii_analyze_data> page = null;
		page = solrService.findKeyWord(btype,keyword, pageable);
		model.addAttribute("btype", btype);
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		model.addAttribute("roots", roots);
		return "/hnii_analyze/keywordlist";
	}
	/**
	 * show
	 */
	@RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
	String show(@PathVariable String id, ModelMap model) {
		Hnii_analyze_data hnii_analyze_data = solrService.find(id);
		if (hnii_analyze_data == null) {
			return "/common/resource_not_found";
		}
		model.addAttribute("object", hnii_analyze_data);
		return "/hnii_analyze/show";
	} 
	

}
