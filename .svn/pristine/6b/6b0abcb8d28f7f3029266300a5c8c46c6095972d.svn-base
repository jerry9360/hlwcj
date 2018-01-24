package com.centit.hlwyw.inner.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
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
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Crawler;
import com.centit.hlwyw.inner.service.CrawlerService;

@Controller("crawlerController")
@RequestMapping("/crawler/spilders")
public class CrawlerController extends BaseController {
	
	@Resource(name="crawlerServiceImpl")
	private CrawlerService crawlerService;

	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String name,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("name", name);
		name = StringUtils.isBlank(name)?"%%":"%"+name+"%";
		Page<Crawler> page = crawlerService.findByName(name, pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/crawler/list";
	}

	/**
	 * save
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String save(@RequestParam(required=false)String id,String code,String name,String period) {
		Crawler entity = null;
		if(StringUtils.isBlank(id)){
			entity = new Crawler();
			entity.setId(KeyUtils.getKey());
			entity.setCode(code);
			entity.setName(name);
			entity.setPeriod(period);
			entity.setIsrun("0");
			entity.setModify_date(new Date());
			entity.setCreate_date(new Date());
			crawlerService.save(entity);
		}else{
			entity = crawlerService.find(id);
			if(entity!=null){
				entity.setName(name);
				entity.setPeriod(period);
				entity.setModify_date(new Date());
				crawlerService.update(entity);
			}
		}
		return "redirect:/crawler/spilders";
	}


	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	String delete(@PathVariable String id) {
		Crawler entity = crawlerService.find(id);
		if(entity!=null){
			crawlerService.delete(id);
		}
		return "redirect:/crawler/spilders";
	}
	
	/**
	 * start
	 */
	@RequestMapping(value = "/start/{id}", method = RequestMethod.GET)
	String start(@PathVariable String id) {
		Crawler entity = crawlerService.find(id);
		if(entity!=null){
			if("0".equals(entity.getIsrun())){
				entity.setIsrun("2");
				entity.setModify_date(new Date());
				crawlerService.update(entity);
			}
		}
		return "redirect:/crawler/spilders";
	}
	
	/**
	 * close
	 */
	@RequestMapping(value = "/close/{id}", method = RequestMethod.GET)
	String close(@PathVariable String id) {
		Crawler entity = crawlerService.find(id);
		if(entity!=null){
			if("1".equals(entity.getIsrun())){
				entity.setIsrun("3");
				entity.setModify_date(new Date());
				crawlerService.update(entity);
			}
		}
		return "redirect:/crawler/spilders";
	}
	
	/**
	 * closeall
	 */
	@RequestMapping(value = "/closeSpilder", method = RequestMethod.GET)
	String closeall() {
		crawlerService.closeAllCrawlers();
		return "redirect:/crawler/spilders";
	}
}
