package com.centit.hlwyw.inner.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Length;
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
import com.centit.hlwyw.inner.entity.Corpgood_badinfo;
import com.centit.hlwyw.inner.entity.Taglib;
import com.centit.hlwyw.inner.service.Corpgood_badinfoService;
import com.centit.hlwyw.inner.service.TaglibService;
@Controller("corpgood_badinfoController")
@RequestMapping("/corp/corpgood_badinfo")
public class Corpgood_badinfoController extends BaseController{
	
	private static Logger log = Logger.getLogger(Corpgood_badinfoController.class);  

	

	@Resource(name = "corpgood_badinfoServiceImpl")
	private Corpgood_badinfoService corpgood_badinfoService;
	
	@Resource(name = "taglibServiceImpl")
	private TaglibService taglibService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String type,
			@RequestParam(required=false) String source,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("type", type);
		model.addAttribute("source", source);
 		Page<Corpgood_badinfo> page= corpgood_badinfoService.findSearch(corp_name,type,source, pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/corpgood_badinfo/list";
	}
	
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable @Length(min=32,max=32) String id, ModelMap model) {
		Corpgood_badinfo corpgood_badinfo = corpgood_badinfoService.find(id);
		try {
			if(StringUtils.isNotBlank(corpgood_badinfo.getFilename())){
				String filename = URLDecoder.decode(corpgood_badinfo.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				corpgood_badinfo.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		model.addAttribute("corpgood_badinfo", corpgood_badinfo);
		return "/corpgood_badinfo/detail";
	}
	
	@RequestMapping(value = "/clear",method = RequestMethod.GET)
	public String clearlist(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String type,
			@RequestParam(required=false) String source,
			@RequestParam(required=false) String state,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("type", type);
		model.addAttribute("source", source);
		model.addAttribute("state", state);
		Page<Corpgood_badinfo> page= corpgood_badinfoService.findClearSearch(corp_name,type,source,state,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/corpgood_badinfo/clearlist";
	}
	
	@RequestMapping(value = "/clear/{id}")
	public String clearDetail(@PathVariable String id, ModelMap model) {
		Corpgood_badinfo corpgood_badinfo = corpgood_badinfoService.find(id);
		try {
			if(StringUtils.isNotBlank(corpgood_badinfo.getFilename())){
				String filename = URLDecoder.decode(corpgood_badinfo.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				corpgood_badinfo.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		List<Taglib> tags = taglibService.findAll();
		model.addAttribute("tags", tags);
		model.addAttribute("corpgood_badinfo", corpgood_badinfo);
		return "/corpgood_badinfo/cleardetail";
	}
	
	@RequestMapping(value = "/dear/{id}")
	@ResponseBody
	public String dear(@PathVariable String id, String type,String credit,String state) {
		Corpgood_badinfo corpgood_badinfo = corpgood_badinfoService.find(id);
		if(corpgood_badinfo!=null){
			if("1".equals(state)||"2".equals(state)){
				corpgood_badinfo.setType(type);
				corpgood_badinfo.setCredit(credit);
				corpgood_badinfo.setState(state);
				corpgood_badinfoService.update(corpgood_badinfo);
				return "success";
			}else{
				return "error";
			}
		}else{
			return "error";
		}

	}
}
