package com.centit.hlwyw.inner.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

 


import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.inner.entity.Jwdata;
import com.centit.hlwyw.inner.service.JwdataService;

@Controller("jwdataController")
@RequestMapping("/jw/jwdata")
public class JwdataController extends BaseController {
 

 
 
	@Resource(name = "jwdataServiceImpl")
	private JwdataService jwdataService;

	/**
	 * List
	 */
	@RequestMapping(value = "/jwquery/list",method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String title,
			@RequestParam(required=false) String source,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("title", title);
		model.addAttribute("source", source);
		Page<Jwdata> page = jwdataService.findJwdataPage(title,source,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/jwdata/list";
	}
	/**
	 * show
	 */
	@RequestMapping(value = "/jwquery/detail/{id}", method = RequestMethod.GET)
	String detail(@PathVariable String id, ModelMap model) {
		Jwdata jwdata = jwdataService.find(id);
		if (jwdata == null) {
			return "/common/resource_not_found";
		}
		model.addAttribute("jwdata", jwdata);
		return "/jwdata/detail";
	}
//	/**
//	 * EditList
//	 */
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public String editlist(
//			@PageableDefault(page = 0, size = PAGE_SIZE) Pageable pageable,
//			ModelMap model) {
//		Page<Jwdata> page = jwdataService.findPage(pageable);
//		model.addAttribute("page", page);
//		model.addAttribute("pageable", pageable);
//		return "/inner/jwdata/listedit";
//	}
//
//	/**
//	 * add
//	 */
//	@RequestMapping(value = "/new", method = RequestMethod.GET)
//	public String add(ModelMap model) {	
//		Jwdata jwdata = new Jwdata();
//		model.addAttribute("jwdata", jwdata);
//		return "/inner/jwdata/new";
//	}
//
//	/**
//	 * save
//	 */
//	@RequestMapping(method = RequestMethod.POST)
//	public String save(@Valid Jwdata jwdata, BindingResult bindingResult,
//			ModelMap model,RedirectAttributes redirectAttributes) {
//		if (bindingResult.hasErrors()) {
//			return "/inner/jwdata/new";
//		}
//		jwdataService.save(jwdata);
//		return "redirect:/inner/jwdata";
//	}
//
//	/**
//	 * eidt
//	 */
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public String edit(@PathVariable String id, ModelMap model) {
//		Jwdata jwdata = jwdataService.find(id);
//		if (jwdata == null) {
//			return "/common/resource_not_found";
//		}
//		model.addAttribute("jwdata", jwdata);
//		return "/inner/jwdata/edit";
//	}
//
//	/**
//	 * update
//	 */
//	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
//	public String update(@Valid Jwdata jwdata, BindingResult bindingResult,
//			@PathVariable String id, String companyId, ModelMap model,
//			RedirectAttributes redirectAttributes) {
//		if (bindingResult.hasErrors()) {
//			return "/inner/jwdata/edit";
//		}
//		jwdata.setId(id);
//		jwdataService.update(jwdata);
//		return "redirect:/inner/jwdata";
//	}
//
//	/**
//	 * delete
//	 */
//	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
//	String delete(@PathVariable String id) {
//		jwdataService.delete(id);
//		return "redirect:/inner/jwdata";
//	}
//


}
