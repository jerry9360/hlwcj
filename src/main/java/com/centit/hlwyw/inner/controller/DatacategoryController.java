package com.centit.hlwyw.inner.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Datacategory;
import com.centit.hlwyw.inner.service.DatacategoryService;

@Controller("datacategoryController")
@RequestMapping("/datamgr/datacategory")
public class DatacategoryController extends BaseController {
	
	@Resource(name="datacategoryServiceImpl")
	private DatacategoryService datacategoryService;
	


	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<Datacategory> datacategorylist=datacategoryService.findAll();
		model.addAttribute("datacategorylist", datacategorylist);
		return "/datacategory/list";
	}

 
 

	/**
	 * save
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@Valid Datacategory datacategory, BindingResult bindingResult,
			ModelMap model) {
//		if (bindingResult.hasErrors()) {
//			return Constantval.CONSTANT_FAIL;
//		}
		if(datacategory.getId()==null||datacategory.getId().trim().length()==0){
			datacategory.setId(KeyUtils.getKey());
			datacategory.setCreate_date(new Date());
			datacategory.setModify_date(new Date());
			datacategoryService.save(datacategory);
		}
		datacategory.setModify_date(new Date());
		datacategoryService.update(datacategory);
		return Constantval.CONSTANT_SUCCESS;
	}

	/**
	 * eidt
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Datacategory edit(@PathVariable String id, ModelMap model) {
		Datacategory datacategory = datacategoryService.find(id);
		return datacategory;
	}


	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable String id) {
		datacategoryService.delete(id);
		return Constantval.CONSTANT_SUCCESS;
	}




}