package com.centit.hlwyw.inner.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Service_interface;
import com.centit.hlwyw.inner.service.Service_interfaceService;


@Controller("interfaceManageController")

@RequestMapping("/servicemgr/listmgr")
public class InterfaceManageController extends BaseController{
	
	private static Logger log = Logger.getLogger(AnalyzeAnalyzeController.class);
	
	
	
	@Resource(name="service_interfaceServiceImpl")
	private Service_interfaceService service_interfaceService;
	
	
	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listsi(
			@RequestParam(required=false) String interface_name,
			ModelMap model
		) {
		model.addAttribute("interface_name", interface_name);
		interface_name = StringUtils.isBlank(interface_name)?"%%":"%"+interface_name+"%";
		List<Service_interface> servicelists = service_interfaceService.findByName(interface_name);
		model.addAttribute("serviceinterface", servicelists);
		return "/interfacemanager/list";
	}
	
	
	
	/**
	 * save
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@Valid Service_interface service_interface, 
			ModelMap model) {
//		if (bindingResult.hasErrors()) {
//			return Constantval.CONSTANT_FAIL;
//		}
		if(service_interface.getId()==null||service_interface.getId().trim().length()==0){
			service_interface.setId(KeyUtils.getKey());
			service_interface.setCreate_date(new Date());
			service_interface.setModify_date(new Date());
			service_interfaceService.save(service_interface);
		}
		service_interface.setModify_date(new Date());
		service_interfaceService.update(service_interface);
		return Constantval.CONSTANT_SUCCESS;
	}

	
	
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Service_interface edit(@PathVariable String id, ModelMap model) {
		Service_interface service_interface= service_interfaceService.find(id);
		service_interfaceService.update(service_interface);
		return service_interface;
		
	}


	
	
	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	String delete(@PathVariable String id) {
	
		service_interfaceService.delete(id);
		return Constantval.CONSTANT_SUCCESS;
	
		}
	}


	
	
	
	
	
