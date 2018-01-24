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
import com.centit.hlwyw.inner.entity.Pergoodinfo;
import com.centit.hlwyw.inner.service.PergoodinfoService;

@Controller("pergoodinfoController")
@RequestMapping("/per/pergoodinfo")
public class PergoodinfoController extends BaseController {


	@Resource(name = "pergoodinfoServiceImpl")
	private PergoodinfoService pergoodinfoService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String type,
			@RequestParam(required=false) String source,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("name", name);
		model.addAttribute("type", type);
		model.addAttribute("source", source);
 		Page<Pergoodinfo> page= pergoodinfoService.findSearch(name,type,source,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/pergoodinfo/list";
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable String id, ModelMap model) {
		Pergoodinfo pergoodinfo = pergoodinfoService.find(id);
		model.addAttribute("pergoodinfo", pergoodinfo);
		return "/pergoodinfo/detail";
	}
	

	

}