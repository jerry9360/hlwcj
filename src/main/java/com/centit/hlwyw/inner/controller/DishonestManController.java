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
import com.centit.hlwyw.inner.entity.Dishonestman;
import com.centit.hlwyw.inner.service.DishonestManService;
import com.centit.hlwyw.inner.service.TaglibService;
@Controller("dishonestManController")
@RequestMapping("/corp/dishonestMan")
public class DishonestManController extends BaseController{

	private static Logger log = Logger.getLogger(DishonestManController.class);  

	
	@Resource(name = "dishonestManServiceImpl")
	private DishonestManService dishonestManService;
	
	@Resource(name = "taglibServiceImpl")
	private TaglibService taglibService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String disman_name,
			@RequestParam(required=false) String industry,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("disman_name", disman_name);
		model.addAttribute("industry", industry);
 		Page<Dishonestman> page= dishonestManService.findSearch(disman_name,industry,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/dishonestMan/list";
	}
	
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable String id, ModelMap model) {
		Dishonestman dishonestMan = dishonestManService.find(id);
		try {
			if(StringUtils.isNotBlank(dishonestMan.getFilename())){
				String filename = URLDecoder.decode(dishonestMan.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				dishonestMan.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		model.addAttribute("dishonestMan", dishonestMan);
		return "/dishonestMan/detail";
	}
}
