package com.centit.hlwyw.inner.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Past;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
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
import org.springframework.web.util.HtmlUtils;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Business_root;
import com.centit.hlwyw.inner.entity.Business_secondary;
import com.centit.hlwyw.inner.entity.Industry_type;
import com.centit.hlwyw.inner.service.Business_rootService;
import com.centit.hlwyw.inner.service.Business_secondaryService;
import com.centit.hlwyw.inner.service.Industry_typeService;

@Controller("businessClassificationController")
@RequestMapping("business/keyword")
public class BusinessClassificationController extends BaseController {


	@Resource(name = "business_rootServiceImpl")
	private Business_rootService business_rootService;
	
	@Resource(name = "business_secondaryServiceImpl")
	private Business_secondaryService business_secondaryService;
	
	@Resource(name = "industry_typeServiceImpl")
	private Industry_typeService industry_typeService;

	/**
	 * ListRoot
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listRoot(@PageableDefault(page = 0, size = Constantval.PAGE_TWENTY) Pageable pageable,
			ModelMap model) {
		Page<Business_root>   budiness_rootList = business_rootService.findPage(pageable);
		model.addAttribute("page", budiness_rootList);
		model.addAttribute("pageable", pageable);
		return "business/root_list";
	}
	/**
	 * PageSecondary
	 */
	@RequestMapping(value = "/secondary/page"  )
	public String pageSecondary(@RequestParam(required=false)String industry,@PageableDefault(page = 0, size = Constantval.PAGE_TWENTY) Pageable pageable,
			ModelMap model) {
		String busineess_name = "%"+industry+"%";
		Page<Business_root> page =  business_rootService.findByBusinessName(busineess_name, pageable);
		model.addAttribute("page", page);
		model.addAttribute("industry", industry);
		model.addAttribute("pageable", pageable);
		return "business/root_list";
	}
	
	/**
	 * ListIndustry
	 */
	@RequestMapping(value = "/industry/list"  )
	public String listIndustry(@PageableDefault(page = 0, size = Constantval.PAGE_TWENTY) Pageable pageable,
			ModelMap model) {
		Page<Industry_type> page =  industry_typeService.findPage(pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "business/industry_list";
	}
	

	/**
	 * ListSecondary
	 */
	@RequestMapping(value = "/secondary/list/{root_id}"  )
	public String listSecondary(@PathVariable String root_id,
//			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE) Pageable pageable,
			ModelMap model) {
		List<Business_secondary> page = null;
		if(StringUtils.isBlank(root_id)){
			page = new ArrayList<Business_secondary>();
		}else{
			page =  business_secondaryService.findAllDelete(root_id);
		}
		model.addAttribute("root_id", root_id);
		model.addAttribute("page", page);
		return "business/secondary_list";
	}
	
	/**
	 * save
	 */
	@RequestMapping(value = "/save/industry", method = RequestMethod.POST)
	@ResponseBody
	public String saveIndustry(@RequestParam(required=false)String industry_id, String industry_name, String key_word,String un_key_word,String belong_industry,Date create_date,String regex) {
		Industry_type industry_type = null;
		industry_name=industry_name.trim();
		key_word=key_word.trim();
		regex = HtmlUtils.htmlUnescape(regex);
		if(StringUtils.isNotBlank(industry_id)){
			industry_type = industry_typeService.find(industry_id);
			if(industry_type==null){
				return Constantval.CONSTANT_SUCCESS;
			}
			industry_type.setIndustry_name(industry_name);
			industry_type.setKey_word(key_word);
			industry_type.setUn_key_word(un_key_word);
			industry_type.setBelong_industry(belong_industry);
			industry_type.setCreate_date(create_date); 
			industry_type.setModify_date(new Date());
			industry_type.setRegex(regex);
			industry_typeService.update(industry_type);
//			business_rootService.updateByIndustry_id(industry_id,industry_name);
		}else{
			if("".equals(industry_name)&&"".equals(key_word)){
				return Constantval.CONSTANT_SUCCESS;
			}
			industry_type = new Industry_type();
			industry_type.setIndustry_id(KeyUtils.getKey());
			industry_type.setIndustry_name(industry_name);
			industry_type.setKey_word(key_word);
			industry_type.setUn_key_word(un_key_word);
			industry_type.setBelong_industry(belong_industry);
			industry_type.setCreate_date(new Date());
			industry_type.setModify_date(new Date());
			industry_type.setRegex(regex);
			industry_typeService.save(industry_type);
		}
		return Constantval.CONSTANT_SUCCESS; 
	}

	/**
	 * save
	 */
	@RequestMapping(value = "/save/root", method = RequestMethod.POST)
	@ResponseBody
	public String saveRoot(@RequestParam(required=false)String root_id,String business_name,String key_word,String un_key_word,String types, Date create_date,String regex) {
		Business_root business_root = null;
		key_word=key_word.trim();
		regex = HtmlUtils.htmlUnescape(regex);
		if(StringUtils.isNotBlank(root_id)){
			business_root = business_rootService.find(root_id);
			if(business_root==null){
//				return "redirect:/business/keyword";
				return Constantval.CONSTANT_SUCCESS; 
			}
//			business_root.setIndustry_id(industry_id);
			business_root.setBusiness_name(business_name);
			business_root.setKey_word(key_word);
			business_root.setUn_key_word(un_key_word);
			business_root.setTypes(types);
			business_root.setCreate_date(create_date); 
			business_root.setModify_date(new Date());
			business_root.setRegex(regex);
			business_rootService.update(business_root);
//			business_secondaryService.updateByIndustry_id(root_id,business_name);
			
		}else{
			if("".equals(business_name)&&"".equals(key_word)){
//				return "redirect:/business/keyword";
				return Constantval.CONSTANT_SUCCESS; 
			}
			business_root = new Business_root();
			business_root.setRoot_id(KeyUtils.getKey());
//			business_root.setIndustry_id(industry_id);
			business_root.setBusiness_name(business_name);
			business_root.setKey_word(key_word);
			business_root.setUn_key_word(un_key_word);
			business_root.setTypes(types);
			business_root.setCreate_date(new Date());
			business_root.setModify_date(new Date());
			business_root.setRegex(regex);
			business_rootService.save(business_root);
		}
//		return "redirect:/business/keyword";
		return Constantval.CONSTANT_SUCCESS; 
	}
	
	/**
	 * save
	 */
	@RequestMapping(value = "/save/secondary", method = RequestMethod.POST)
	@ResponseBody
	public String saveSecondary(
			@RequestParam(required=false) String id,
			 String root_id,
			 String industry_id,
			String business_name,
			String key_word,
			String un_key_word,
			String types,
			Date create_date,
			String industry,
			String regex) {
		Business_secondary business_secondary = null;
		regex = HtmlUtils.htmlUnescape(regex);
		business_name=business_name.trim();
		key_word=key_word.trim();
		if(StringUtils.isNotBlank(id)){
			business_secondary = business_secondaryService.find(id);
			if(business_secondary==null){
//				return "redirect:/business/keyword/secondary/list/"+root_id; 
				return Constantval.CONSTANT_SUCCESS; 
			}
			business_secondary.setRoot_id(business_secondary.getRoot_id());
			business_secondary.setBusiness_name(business_name);
			business_secondary.setKey_word(key_word);
			business_secondary.setUn_key_word(un_key_word);
			business_secondary.setTypes(types);
			business_secondary.setRegex(regex);
			business_secondary.setIndustry(industry);
			business_secondary.setCreate_date(create_date); 
			business_secondary.setModify_date(new Date());
			business_secondaryService.update(business_secondary);
		}else{
			if("".equals(business_name)&&"".equals(key_word)){
//				return "redirect:/business/keyword/secondary/list/"+root_id;
				return Constantval.CONSTANT_SUCCESS; 
			}
			business_secondary = new Business_secondary();
			business_secondary.setId(KeyUtils.getKey());
			business_secondary.setRoot_id(root_id);
			business_secondary.setBusiness_name(business_name);
			business_secondary.setKey_word(key_word);
			business_secondary.setUn_key_word(un_key_word);
			business_secondary.setTypes(types);
			business_secondary.setRegex(regex);
			business_secondary.setIndustry(industry);
			business_secondary.setCreate_date(new Date());
			business_secondary.setModify_date(new Date());
			business_secondaryService.save(business_secondary);
		}
//		return "redirect:/business/keyword/secondary/list/"+root_id;
		return Constantval.CONSTANT_SUCCESS; 
	}
	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/industry/{id}", method = RequestMethod.GET)
	String deleteIndustry(@PathVariable String id) {
		Industry_type industry_type = industry_typeService.find(id);
		if(industry_type!=null){
			industry_typeService.delete(id);
		}
		return "redirect:/business/keyword/industry/list"; 
	}

	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/root/{root_id}", method = RequestMethod.GET)
	String deleteRoot( @PathVariable String root_id) {
		Business_root business_root = business_rootService.find(root_id);
		if(business_root!=null){
			business_rootService.delete(root_id);
		}
		return "redirect:/business/keyword"; 
	}
	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/secondary/{root_id}/{id}", method = RequestMethod.GET)
	String deleteSecondary(@PathVariable String root_id,@PathVariable String id) {
		Business_secondary business_secondary = business_secondaryService.find(id);
		if(business_secondary!=null){
			business_secondaryService.delete(id);
		}
		return "redirect:/business/keyword/secondary/list/"+root_id;
	}

	/**
	 * 校验小类是否已全部删除
	 */
	@RequestMapping(value = "/sureAllSecondaryDelete/{root_id}", method = RequestMethod.GET)
	@ResponseBody
	public String sureAllSecondaryDelete(@PathVariable String root_id){
		List<Business_secondary> list = business_secondaryService.findAllDelete(root_id);
		if(null!=list&&list.size()>0){
			return "FAIL";
		}else{
			return "SUCCESS";
		}
	}

	
	
}
