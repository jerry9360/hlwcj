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
import com.centit.hlwyw.inner.entity.Perbadinfo;
import com.centit.hlwyw.inner.service.PerbadinfoService;

@Controller("perbadinfoController")
@RequestMapping("/per/perbadinfo")
public class PerbadinfoController extends BaseController {


	@Resource(name = "perbadinfoServiceImpl")
	private PerbadinfoService perbadinfoService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(HttpSession session,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String type,
			@RequestParam(required=false) String source,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("name", name);
		model.addAttribute("type", type);
		model.addAttribute("source", source);
 		Page<Perbadinfo> page= perbadinfoService.findSearch(name,type,source,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/perbadinfo/list";
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable String id, ModelMap model) {
		Perbadinfo perbadinfo = perbadinfoService.find(id);
		model.addAttribute("perbadinfo", perbadinfo);
		return "/perbadinfo/detail";
	}


}
