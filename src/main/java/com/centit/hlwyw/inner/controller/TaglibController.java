package com.centit.hlwyw.inner.controller;

import java.util.Date;

import javax.annotation.Resource;

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

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Taglib;
import com.centit.hlwyw.inner.service.TaglibService;

@Controller("taglibController")
@RequestMapping("labelmgr/labels")
public class TaglibController extends BaseController {


	@Resource(name = "taglibServiceImpl")
	private TaglibService taglibService;

	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(required=false)String name,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("name", name);
		name = StringUtils.isBlank(name)?"%%":"%"+name+"%";
		Page<Taglib> page = taglibService.findAllTags(name, pageable);
		model.addAttribute("page", page);
		for (Taglib taglib : page) {
			String source=taglib.getSource();
			if(source==null){
				source = "";
			}
			source=source.replace("1", "交通行业政务网站").replace("2", "新闻媒体网站").replace("3", "自媒体（微博、微信）")
				  .replace("4", "搜索引擎").replace("0", "其它");
			taglib.setSource(source);
		}
		model.addAttribute("pageable", pageable);
		return "taglib/list";
	}

	/**
	 * save
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestParam(required=false)String id,String name,@Length(max=255)String namedesc,@Length(max=1)String type,@Length(max=1)String source) {
		Taglib tag = null;
		if(StringUtils.isNotBlank(id)){
			tag = taglibService.find(id);
			if(tag==null){
				return "redirect:/labelmgr/labels"; 
			}
			tag.setName(name);
			tag.setNamedesc(namedesc);
			tag.setType(type);
			tag.setModify_date(new Date());
			tag.setSource(source);
			taglibService.update(tag);
		}else{
			tag = new Taglib();
			tag.setId(KeyUtils.getKey());
			tag.setName(name);
			tag.setNamedesc(namedesc);
			tag.setType(type);
			tag.setModify_date(new Date());
			tag.setCreate_date(new Date());
			tag.setSource(source);
			taglibService.save(tag);
		}
		return Constantval.CONSTANT_SUCCESS;
	}


	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	String delete(@PathVariable String id) {
		Taglib tag = taglibService.find(id);
		if(tag!=null){
			taglibService.delete(id);
		}
		return "redirect:/labelmgr/labels";
	}

}
