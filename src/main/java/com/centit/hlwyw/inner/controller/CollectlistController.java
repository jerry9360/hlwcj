package com.centit.hlwyw.inner.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Collectlist;
import com.centit.hlwyw.inner.service.CollectlistService;

@Controller("collectlistController")
@RequestMapping("/urlmgr/collectlist")
public class CollectlistController extends BaseController {


	@Resource(name="collectlistServiceImpl")
	private CollectlistService collectlistService;
	


	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<Collectlist> collectlist=collectlistService.findAll();
		model.addAttribute("collectlist", collectlist);
		return "/collectlist/list";
	}

 
 

	/**
	 * save
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@Valid Collectlist collectlist, BindingResult bindingResult,
			ModelMap model) {
//		if (bindingResult.hasErrors()) {
//			return Constantval.CONSTANT_FAIL;
//		}
		if(collectlist.getId()==null||collectlist.getId().trim().length()==0){
			collectlist.setId(KeyUtils.getKey());
			collectlist.setCreate_date(new Date());
			collectlist.setModify_date(new Date());
			collectlistService.save(collectlist);
		}
		collectlist.setModify_date(new Date());
		collectlistService.update(collectlist);
		return Constantval.CONSTANT_SUCCESS;
	}

	/**
	 * eidt
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Collectlist edit(@PathVariable String id, ModelMap model) {
		Collectlist collectlist = collectlistService.find(id);
		return collectlist;
	}


	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable String id) {
		collectlistService.delete(id);
		return Constantval.CONSTANT_SUCCESS;
	}


}