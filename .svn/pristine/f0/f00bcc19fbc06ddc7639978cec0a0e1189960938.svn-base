package com.centit.hlwyw.solr.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.inner.entity.Servicedata;
import com.centit.hlwyw.solr.service.SolrService;

@Controller("solrController")
@RequestMapping("/solr/solrinfo")
public class SolrController extends BaseController{
	
	@Resource(name="solrServiceImpl")
	private SolrService solrService;
	
	@RequestMapping(value = "/servicedatainfo", method = RequestMethod.GET)
	public String serviceDataList(@RequestParam(required=false) String filed,
			@PageableDefault(page = 0, size = 10) Pageable pageable,
			ModelMap model){
		model.addAttribute("field",filed);
		if(StringUtils.isBlank(filed)){
			filed = "";
		}
		Page<Servicedata> page = solrService.findServiceDataByField(filed, pageable);
		model.addAttribute("page",page);
		model.addAttribute("pageable",pageable);
		return "/solr/servicedatalist";
		
	}

}
