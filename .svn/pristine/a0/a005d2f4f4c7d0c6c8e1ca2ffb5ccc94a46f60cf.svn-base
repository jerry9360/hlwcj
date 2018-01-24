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
import com.centit.hlwyw.inner.entity.Service_complaint;
import com.centit.hlwyw.inner.service.Service_complaintService;

@Controller("service_complaintController")
@RequestMapping("/corp/servicecomplaint")
public class Service_complaintController extends BaseController {


	@Resource(name = "service_complaintServiceImpl")
	private Service_complaintService service_complaintService;

	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String vehicle_no,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("vehicle_no", vehicle_no);
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		vehicle_no =StringUtils.isBlank(vehicle_no)?"%%":"%"+vehicle_no+"%";
		Page<Service_complaint> page = service_complaintService.findList(corp_name, vehicle_no, pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/servicecomplaint/list";
	}

	
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable String id, ModelMap model) {
		Service_complaint complaint = service_complaintService.find(id);
		model.addAttribute("complaint", complaint);
		return "/servicecomplaint/detail";
	}
	

}
