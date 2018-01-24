package com.centit.hlwyw.inner.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.ExportExcel;
import com.centit.hlwyw.inner.entity.Hnii_ask;
import com.centit.hlwyw.inner.entity.Hnii_complaint;
import com.centit.hlwyw.inner.entity.Hnii_prise;
import com.centit.hlwyw.inner.entity.Hnii_suggest;
import com.centit.hlwyw.inner.entity.Hniiservicedata;
import com.centit.hlwyw.inner.entity.HniiservicedataForm;
import com.centit.hlwyw.inner.service.Hnii_askService;
import com.centit.hlwyw.inner.service.Hnii_complaintService;
import com.centit.hlwyw.inner.service.Hnii_priseService;
import com.centit.hlwyw.inner.service.Hnii_reflectService;
import com.centit.hlwyw.inner.service.Hnii_suggestService;
import com.centit.hlwyw.inner.service.HniiservicedataService;

@Controller("hniilabeldataController")
@RequestMapping("/hnii/hniilabeldata")
public class HniilabeldataController extends BaseController {
	private static Logger log = Logger.getLogger(HniilabeldataController.class);  

 
	@Resource(name = "hniiservicedataServiceImpl")
	private HniiservicedataService hniiservicedataService;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "hnii_complaintServiceImpl")
	private Hnii_complaintService hnii_complaintService;
	
	@Resource(name = "hnii_askServiceImpl")
	private Hnii_askService hnii_askService;
	
	@Resource(name = "hnii_suggestServiceImpl")
	private Hnii_suggestService hnii_suggestService;
	
	@Resource(name = "hnii_priseServiceImpl")
	private Hnii_priseService hnii_priseService;

	@Resource(name = "hnii_reflectServiceImpl")
	private Hnii_reflectService hnii_reflectService;

	/**
	 * List
	 */
	@RequestMapping(value = "/hniiquery/list/{servicecode}",method = RequestMethod.GET)
	public String list(
			@PathVariable String servicecode,
			@RequestParam(required=false) String industry,
  			@RequestParam(required=false) String type,
			@RequestParam(required=false) String content,
 			@PageableDefault(page = 0,size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("servicecode", servicecode);
		model.addAttribute("industry", industry);
		model.addAttribute("type", type);
		model.addAttribute("content", content);
		industry = StringUtils.isBlank(industry) ? "%%" : "%" + industry + "%";
		type = StringUtils.isBlank(type) ? "%%" : "%" + type + "%";
		content = StringUtils.isBlank(content) ? "%%" : "%" + content + "%";
		String service=null;
 			if("complaint".equals(servicecode)){
				service="投诉";
				Page<Hnii_complaint> page=hnii_complaintService.findList(industry, type, content,pageable);
				model.addAttribute("page", page);
				
			}else if("ask".equals(servicecode)){
				service="咨询";
				Page<Hnii_ask> page=hnii_askService.findList(industry, type, content,pageable);
				model.addAttribute("page", page);
			}else if("suggest".equals(servicecode)){
				service="建议";
				Page<Hnii_suggest> page=hnii_suggestService.findList(industry, type, content,pageable);
				model.addAttribute("page", page);
			}else if("prise".equals(servicecode)){
				service="表扬";
				Page<Hnii_prise> page=hnii_priseService.findList(industry, type, content,pageable);
				model.addAttribute("page", page);
			}
		
		if(service==null){
			return Constantval.ERRORPAGE_SOURCENOTFOUND;
		}
		model.addAttribute("service", service);
		model.addAttribute("pageable", pageable);
		return "/96096hnii/hniilabelquery/list";
	}
	/**
	 * show
	 */
	@RequestMapping(value = "/hniiquery/detail/{servicecode}/{id}", method = RequestMethod.GET)
	String show(
			@PathVariable String servicecode,
			@PathVariable String id, ModelMap model) {
		model.addAttribute("servicecode", servicecode);
		String service=null;
 			if("complaint".equals(servicecode)){
				service="投诉";
				Hnii_complaint complaint=hnii_complaintService.find(id);
				if (complaint == null) {
					return Constantval.ERRORPAGE_SOURCENOTFOUND;
				}
				model.addAttribute("object", complaint);
			}else if("ask".equals(servicecode)){
				service="咨询";
				Hnii_ask ask=hnii_askService.find(id);
				if (ask == null) {
					return Constantval.ERRORPAGE_SOURCENOTFOUND;
				}
				model.addAttribute("object", ask);
			}else if("suggest".equals(servicecode)){
				service="建议";
				Hnii_suggest suggest=hnii_suggestService.find(id);
				if (suggest == null) {
					return Constantval.ERRORPAGE_SOURCENOTFOUND;
				}
				model.addAttribute("object", suggest);
			}else if("prise".equals(servicecode)){
				Hnii_prise prise=hnii_priseService.find(id);
				if (prise == null) {
					return Constantval.ERRORPAGE_SOURCENOTFOUND;
				}
				model.addAttribute("object", prise);
				service="表扬";
			}
		model.addAttribute("service", service);
		if(service==null){
			return Constantval.ERRORPAGE_SOURCENOTFOUND;
		}
		return "/96096hnii/hniilabelquery/detail";
	}
	
	
	
	/**
	 * show
	 */
	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	String listStatistics( ModelMap model) {
		List<Object> objectList = new ArrayList<Object>();
		List<Object> hnii_complaint= hnii_complaintService.findStatistics();
		List<Object> hnii_ask = hnii_askService.findStatistics( );
		List<Object>  hnii_suggest = hnii_suggestService.findStatistics( );
		List<Object>  hnii_prise = hnii_priseService.findStatistics( );
		List<Object>  hnii_reflect = hnii_reflectService.findStatistics( );
		for(Object object:hnii_complaint){
			objectList.add( object);
		}for(Object object:hnii_ask){
			objectList.add( object);
		}for(Object object:hnii_suggest){
			objectList.add( object);
		}for(Object object:hnii_prise){
			objectList.add(object);
		}for(Object object:hnii_reflect){
			objectList.add( object);
		}
		model.addAttribute("hnii_complaint", hnii_complaint);
		model.addAttribute("hnii_ask", hnii_ask);
		model.addAttribute("hnii_suggest", hnii_suggest);
		model.addAttribute("hnii_prise", hnii_prise);
		model.addAttribute("hnii_reflect", hnii_reflect);
		model.addAttribute("objectList", objectList);
		model.addAttribute("hnii_complaint_size", hnii_complaint.size());
		model.addAttribute("hnii_ask_size", hnii_ask.size()+hnii_complaint.size());
		model.addAttribute("hnii_suggest_size", hnii_suggest.size()+hnii_ask.size()+hnii_complaint.size());
		model.addAttribute("hnii_prise_size", hnii_prise.size()+hnii_suggest.size()+hnii_ask.size()+hnii_complaint.size());
		model.addAttribute("hnii_reflect_size", hnii_reflect.size());
		model.addAttribute("objectList_size", objectList.size());
		System.out.println(objectList.size());
		
		return "/96096statistics/classification";
	}
	
	
	
	
	
	
 
	@RequestMapping(value="/hniiquery/edit/{servicecode}/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String hniiqueryedit(
			@PathVariable String servicecode,
			@PathVariable String id, 
			String cnum,
 			String baddress,
   			String eaddress 
			){
		Hniiservicedata hniiservicedata = hniiservicedataService.find(id);
		if (hniiservicedata == null) {
			return Constantval.CONSTANT_ERROR;
		}
		hniiservicedata.setCnum(cnum);
		hniiservicedata.setModify_date(new Date());
		if("complaint".equals(servicecode)){
			hniiservicedata.setBaddress(baddress);
			hniiservicedata.setEaddress(eaddress);
		}
		hniiservicedataService.update(hniiservicedata);
		return Constantval.CONSTANT_SUCCESS;
	}
		
	
	
	/*
	 * 导出Exl
	 */
	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	@ResponseBody
	public String generateExl(
//			HttpServletRequest request,
			String ctype,String service,String type) {
		ExportExcel<Hniiservicedata> ex = new ExportExcel<Hniiservicedata>();
		String[] headers = new String[]{ "类别", "车牌号", "事发起点", "事发终点", "事发时间", "来电人", "来电号码", "来电时间", "受理状态", "受理单位","工单内容" };
		List<Hniiservicedata> list = hniiservicedataService.findTaxiComplaintAll(ctype,service,type);
		List a = new ArrayList();
		String sql = "select ownername,mainphone,calltime from hnii_view where myid = ?";
		List<Object[]> arr = null;
		List<Object> values = null;
		HniiservicedataForm hniiservicedataForm =null;
		for (Hniiservicedata hniiservicedata : list) {
			values = new ArrayList<Object>();
			values.add(hniiservicedata.getMyid());
			arr = queryService.query(sql, values);
			hniiservicedataForm = new HniiservicedataForm();
			values = new ArrayList<Object>();
			hniiservicedataForm.setType(hniiservicedata.getType());
			hniiservicedataForm.setCnum(hniiservicedata.getCnum());
			if("投诉".equals(service)){
				hniiservicedataForm.setBaddress(hniiservicedata.getBaddress());
				hniiservicedataForm.setEaddress(hniiservicedata.getEaddress());
			}
			hniiservicedataForm.setTime(hniiservicedata.getTime());
			if(arr.size()>0){
				if(arr.get(0)[0]==null){
					hniiservicedataForm.setOwnername("");
				}else{
					hniiservicedataForm.setOwnername(String.valueOf(arr.get(0)[0]));
				}
				hniiservicedataForm.setMailphone(String.valueOf(arr.get(0)[1]));
				hniiservicedataForm.setCalltime(String.valueOf(arr.get(0)[2]));
			}
			hniiservicedataForm.setState(hniiservicedata.getState());
			hniiservicedataForm.setUnit(hniiservicedata.getUnit());
			hniiservicedataForm.setContent(hniiservicedata.getContent());
			a.add(hniiservicedataForm);	
		}		
		OutputStream out = null;
		String filepath = "D:/96096data/"+ctype+"_"+service+"_"+type+".xls";
		try {
			out = new FileOutputStream(filepath);
			ex.exportExcel(headers, a, out);
		} catch (FileNotFoundException e) {
			
			log.error(e.getMessage());log.info(e);
		} finally {
			try {
				if(out!=null){
					out.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage());log.info(e);
			}
		}
		if (null == list) {
			return "FAIL";
		} else {
			return "SUCCESS";
		}
		}

	}

 


