package com.centit.hlwyw.inner.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
import com.centit.hlwyw.inner.entity.Servicedata;
import com.centit.hlwyw.inner.service.ServicedataService;

@Controller("servicedataController")
@RequestMapping("/data/servicedata")
public class ServicedataController extends BaseController {

	@Resource(name = "servicedataServiceImpl")
	private ServicedataService servicedataService;

	@RequestMapping(method = RequestMethod.GET)
	public String listData(
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String source,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			 ModelMap model) {
		model.addAttribute("type", type);
		model.addAttribute("source", source);
		Page<Servicedata> page = servicedataService.findSearchData(type,
				source, null,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/servicedata/list";
	}

	/**
	 * show
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	String show(@PathVariable String id, ModelMap model) {
		Servicedata servicedata = servicedataService.find(id);
		if (servicedata == null) {
			return "/common/resource_not_found";
		}
		model.addAttribute("servicedata", servicedata);
		return "/servicedata/detail";
	}
	
	/**
	 * clear
	 * @param type
	 * @param source
	 * @param pageable
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/clear",method = RequestMethod.GET)
	public String clearlist(
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String source,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			 ModelMap model) {
		model.addAttribute("type", type);
		model.addAttribute("source", source);
		Page<Servicedata> page = servicedataService.findSearchData(type,
				source, null,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/servicedata/list";
	}
}
