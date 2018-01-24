package com.centit.hlwyw.inner.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.inner.entity.Corpmediaexposed;
import com.centit.hlwyw.inner.service.CorpmediaexposedService;
import com.centit.hlwyw.inner.service.TaglibService;
@Controller("corpmediaexposedController")
@RequestMapping("/corp/corpmediaexposed")
public class CorpmediaexposedController extends BaseController{

	private static Logger log = Logger.getLogger(CorpmediaexposedController.class);  

	
	
	@Resource(name = "corpmediaexposedServiceImpl")
	private CorpmediaexposedService corpmediaexposedService;
	
	@Resource(name = "taglibServiceImpl")
	private TaglibService taglibService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String industry,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("industry", industry);
 		Page<Corpmediaexposed> page= corpmediaexposedService.findSearch(corp_name,industry,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/corpmediaexposed/list";
	}
	
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable String id, ModelMap model) {
		Corpmediaexposed corpmediaexposed = corpmediaexposedService.find(id);
		try {
			if(StringUtils.isNotBlank(corpmediaexposed.getFilename())){
				String filename = URLDecoder.decode(corpmediaexposed.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				corpmediaexposed.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		model.addAttribute("corpmediaexposed", corpmediaexposed);
		return "/corpmediaexposed/detail";
	}
	
}
