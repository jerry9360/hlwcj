package com.centit.hlwyw.inner.controller;

import javax.annotation.Resource;

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
import com.centit.hlwyw.inner.entity.Corpbadinfo;
import com.centit.hlwyw.inner.entity.Corpgoodinfo;
import com.centit.hlwyw.inner.entity.Dishonestman;
import com.centit.hlwyw.inner.entity.Judgedoc;
import com.centit.hlwyw.inner.entity.Public_prise;
import com.centit.hlwyw.inner.entity.Service_complaint;
import com.centit.hlwyw.inner.entity.Zhaobiaogg;
import com.centit.hlwyw.inner.entity.Zhongbiaogg;
import com.centit.hlwyw.inner.service.CorpbadinfoService;
import com.centit.hlwyw.inner.service.CorpgoodinfoService;
import com.centit.hlwyw.inner.service.DishonestManService;
import com.centit.hlwyw.inner.service.JudgeDocService;
import com.centit.hlwyw.inner.service.Public_priseService;
import com.centit.hlwyw.inner.service.Service_complaintService;
import com.centit.hlwyw.inner.service.ZhaobiaoggService;
import com.centit.hlwyw.inner.service.ZhongbiaoggService;

@Controller("analyzeCorpController")
@RequestMapping("/analyzemgr/corp")
public class AnalyzeCorpController extends BaseController{
	
	private static Logger log = Logger.getLogger(AnalyzeCorpController.class);
	
	@Resource(name = "judgeDocServiceImpl")
	private JudgeDocService judgedocService;
	
	@Resource(name = "dishonestManServiceImpl")
	private DishonestManService dishonestmanService;
	
	@Resource(name = "corpgoodinfoServiceImpl")
	private CorpgoodinfoService corpgoodinfoService;
	
	@Resource(name = "corpbadinfoServiceImpl")
	private CorpbadinfoService corpbadinfoService;
	
	@Resource(name = "public_priseServiceImpl")
	private Public_priseService public_priseService;
	
	@Resource(name = "service_complaintServiceImpl")
	private Service_complaintService service_complaintService;
	
	@Resource(name = "zhaobiaoggServiceImpl")
	private ZhaobiaoggService zhaobiaoggService;
	
	@Resource(name = "zhongbiaoggServiceImpl")
	private ZhongbiaoggService zhongbiaoggService;
	
	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable,
			ModelMap model) {
		Page<Judgedoc> pageJudgedoc = null;
		Page<Dishonestman> pageDishonestman = null;
		Page<Corpgoodinfo> pageBiaoZhang = null;
		Page<Corpgoodinfo> pageHuoJiang = null;
		Page<Corpbadinfo> pagePiping = null;
		Page<Public_prise> pagePrise = null;
		Page<Service_complaint> pageComplaint = null;
		Page<Zhaobiaogg> pageZhaobiao = null;
		Page<Zhongbiaogg> pageZhongbiao = null;
		if(!("".equals(corpname))&&corpname!=null){
		pageJudgedoc = judgedocService.findList(corpname, pageable) ;
		pageDishonestman = dishonestmanService.findList(corpname, pageable);
		pageBiaoZhang = corpgoodinfoService.findList("表彰",corpname, pageable);
		pageHuoJiang = corpgoodinfoService.findList("获奖",corpname, pageable);
		pagePiping = corpbadinfoService.findList(corpname, pageable);
		pagePrise = public_priseService.findList(corpname, pageable) ;
		pageComplaint = service_complaintService.findList(corpname, pageable) ;
		pageZhaobiao = zhaobiaoggService.findList(corpname, pageable);
		pageZhongbiao = zhongbiaoggService.findList(corpname, pageable);
		}
		model.addAttribute("corpname", corpname);
		model.addAttribute("pageJudgedoc", pageJudgedoc);
		model.addAttribute("pageDishonestman", pageDishonestman);
		model.addAttribute("pageBiaoZhang", pageBiaoZhang);
		model.addAttribute("pageHuoJiang", pageHuoJiang);
		model.addAttribute("pagePiping", pagePiping);
		model.addAttribute("pagePrise", pagePrise);
		model.addAttribute("pageComplaint", pageComplaint);
		model.addAttribute("pageZhaobiao", pageZhaobiao);
		model.addAttribute("pageZhongbiao", pageZhongbiao);
		return "/analyzecorp/list";
	}
	
	/**
	 * 查看详情
	 */
	@RequestMapping(value = "/show")
	public String projectDetail(@RequestParam(required=false)  String corpname,
			@RequestParam(required=false) String datatype,
			@RequestParam(required=false) String id,
			@PageableDefault(page = 0, size = 15) Pageable pageable,
			ModelMap model) {
		if("1".equals(datatype)){
			Judgedoc judgec = judgedocService.find(id);
			model.addAttribute("judgec", judgec);
		}else if("2".equals(datatype)){
			Dishonestman dishonestman = dishonestmanService.find(id);
			model.addAttribute("dishonestman", dishonestman);
		}else if("3".equals(datatype)){
			Corpgoodinfo corpgoodinfo = corpgoodinfoService.find(id);
			model.addAttribute("corpgoodinfo", corpgoodinfo);
		}else if("4".equals(datatype)){
			Corpbadinfo corpbadinfo = corpbadinfoService.find(id);
			model.addAttribute("corpbadinfo", corpbadinfo);
		}else if("5".equals(datatype)){
			Public_prise prise = public_priseService.find(id);
			model.addAttribute("prise", prise);
		}else if("6".equals(datatype)){
			Service_complaint complaint = service_complaintService.find(id);
			model.addAttribute("complaint", complaint);
		}else if("7".equals(datatype)){
			Zhaobiaogg zhaobiao = zhaobiaoggService.find(id);
			model.addAttribute("zhaobiao", zhaobiao);
		}else if("8".equals(datatype)){
			Zhongbiaogg zhongbiao = zhongbiaoggService.find(id);
			model.addAttribute("zhongbiao", zhongbiao);
		}
		model.addAttribute("datatype", datatype);
		model.addAttribute("corpname", corpname);
		model.addAttribute("pageable", pageable);
		return "/analyzecorp/show";
	}
	
	/**
	 * 分页查询：司法判决信息
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/judgedoc/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Judgedoc> judgedocPage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return judgedocService.findList(corpname,pageable);
		
	}
	/**
	 * 分页查询：失信被执行人信息
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/dishonestman/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Dishonestman> dishonestPage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return dishonestmanService.findList(corpname,pageable);
		
	}
	/**
	 * 分页查询：表彰获奖信息
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/biaozhang/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Corpgoodinfo> biaozhangPage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return corpgoodinfoService.findList("%%", corpname, pageable);
		
	}
	/**
	 * 分页查询：获奖信息
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/huojiang/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Corpgoodinfo> corpgoodinfoPage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return corpgoodinfoService.findList("%%", corpname, pageable);
		
	}
	
	/**
	 * 分页查询：通报批评
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/piping/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Corpbadinfo> corpbadinfoPage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return corpbadinfoService.findList(corpname,pageable);
		
	}
	
	/**
	 * 分页查询：公众表扬信息
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/prise/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Public_prise> public_prisePage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return public_priseService.findList(corpname,pageable);
		
	}
	
	/**
	 * 分页查询：服务质量投诉信息
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/complaint/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Service_complaint> service_complaintPage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return service_complaintService.findList(corpname,pageable);
		
	}
	/**
	 * 分页查询：项目招标信息
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/zhaobiao/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Zhaobiaogg> zhaobiaoPage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return zhaobiaoggService.findList(corpname,pageable);
		
	}
	/**
	 * 分页查询：项目中标信息
	 * 
	 * @param corpname
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/zhongbiao/{corpname}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Zhongbiaogg> zhongbiaoPage(
			@PathVariable String corpname,
			@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return zhongbiaoggService.findList(corpname,pageable);
		
	}
	/**
	 * 查看详情：judgedoc
	 * 
	 * @param id
	 * @param model
	 * @return
	 */ 
	@RequestMapping(value = "/judgedoc/show/{id}", method = RequestMethod.GET)
	public String jbxxapplyshow(
			@PathVariable String id,
			ModelMap model) {
		String datatype = "judgedoc";
		Judgedoc judgec = judgedocService.find(id);
		model.addAttribute("judgec", judgec);
		model.addAttribute("datatype", datatype);
		return "/analyzecorp/show";
	}
	
}
