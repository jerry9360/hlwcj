package com.centit.hlwyw.inner.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Crawlerconfig;
import com.centit.hlwyw.inner.service.CrawlerconfigService;


@Controller("crawlerconfigController")
@RequestMapping("/crawler/crawlerconfig")
public class CrawlerconfigController extends BaseController{

	@Resource(name = "crawlerconfigServiceImpl")
	private CrawlerconfigService crawlerconfigService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String detials( ModelMap model) {
		Crawlerconfig crawlerconfig = crawlerconfigService.find();
		model.addAttribute("crawlerconfig", crawlerconfig);
		return "crawlerconfig/detaillist";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid Crawlerconfig crawlerconfig,  String id) {
		Crawlerconfig c = crawlerconfigService.find(id);
		if (c == null) {
			crawlerconfig.setId(KeyUtils.getKey());
			crawlerconfig.setCreate_date(new Date());
			crawlerconfig.setModify_date(new Date());
			crawlerconfigService.save(crawlerconfig);
		}else{
			crawlerconfig.setModify_date(new Date());
			crawlerconfigService.update(crawlerconfig);
		}
		return "redirect:/crawler/crawlerconfig";
	}
}
