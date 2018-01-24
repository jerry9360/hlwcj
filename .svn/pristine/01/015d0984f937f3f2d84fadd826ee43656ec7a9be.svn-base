package com.centit.hlwyw.inner.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
import com.centit.hlwyw.inner.entity.Public_prise;
import com.centit.hlwyw.inner.service.Public_priseService;

@Controller("public_priseController")
@RequestMapping("/corp/publicprise")
public class Public_priseController extends BaseController {



	@Resource(name = "public_priseServiceImpl")
	private Public_priseService public_priseService;

	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String accept_num,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("accept_num", accept_num);
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		accept_num =StringUtils.isBlank(accept_num)?"%%":"%"+accept_num+"%";
		Page<Public_prise> page = public_priseService.findList(corp_name, accept_num, pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/publicprise/list";
	}

	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable String id, ModelMap model) {
		Public_prise prise = public_priseService.find(id);
		model.addAttribute("prise", prise);
		return "/publicprise/detail";
	}

}
