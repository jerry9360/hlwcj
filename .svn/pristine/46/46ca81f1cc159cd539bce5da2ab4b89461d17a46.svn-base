package com.centit.hlwyw.inner.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import javax.annotation.Resource;
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

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.inner.entity.Corpbadinfo;
import com.centit.hlwyw.inner.entity.Corpgood_badinfo;
import com.centit.hlwyw.inner.entity.Corpgoodinfo;
import com.centit.hlwyw.inner.entity.Corpmediaexposed;
import com.centit.hlwyw.inner.entity.Dishonestman;
import com.centit.hlwyw.inner.entity.Judgedoc;
import com.centit.hlwyw.inner.entity.Public_prise;
import com.centit.hlwyw.inner.entity.Service_complaint;
import com.centit.hlwyw.inner.entity.Zhaobiaogg;
import com.centit.hlwyw.inner.entity.Zhongbiaogg;
import com.centit.hlwyw.inner.service.CorpbadinfoService;
import com.centit.hlwyw.inner.service.Corpgood_badinfoService;
import com.centit.hlwyw.inner.service.CorpgoodinfoService;
import com.centit.hlwyw.inner.service.CorpmediaexposedService;
import com.centit.hlwyw.inner.service.DishonestManService;
import com.centit.hlwyw.inner.service.JudgeDocService;
import com.centit.hlwyw.inner.service.Public_priseService;
import com.centit.hlwyw.inner.service.Service_complaintService;
import com.centit.hlwyw.inner.service.ZhaobiaoggService;
import com.centit.hlwyw.inner.service.ZhongbiaoggService;
@Controller("infoWashController")
@RequestMapping("/infowash")
public class InfoWashController extends BaseController{
	private static Logger log = Logger.getLogger(InfoWashController.class);  

	@Resource(name = "corpgood_badinfoServiceImpl")
	private Corpgood_badinfoService corpgood_badinfoService;
	@Resource(name = "corpmediaexposedServiceImpl")
	private CorpmediaexposedService corpmediaexposedService;
	@Resource(name = "judgeDocServiceImpl")
	private JudgeDocService judgeDocService;
	@Resource(name = "dishonestManServiceImpl")
	private DishonestManService dishonestManService;
	@Resource(name = "public_priseServiceImpl")
	private Public_priseService public_priseService;
	@Resource(name = "service_complaintServiceImpl")
	private Service_complaintService service_complaintService;
	@Resource(name = "zhaobiaoggServiceImpl")
	private ZhaobiaoggService zhaobiaoggService;
	@Resource(name = "zhongbiaoggServiceImpl")
	private ZhongbiaoggService zhongbiaoggService;
	@Resource(name = "corpgoodinfoServiceImpl")
	private CorpgoodinfoService corpgoodinfoService;
	@Resource(name = "corpbadinfoServiceImpl")
	private CorpbadinfoService corpbadinfoService;
	

	@RequestMapping(value = "/good_badinfo",method = RequestMethod.GET)
	public String goodbadinfoList(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String type,
			@RequestParam(required=false) String source,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("type", type);
		model.addAttribute("source", source);
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		type =StringUtils.isBlank(type)?"%%":"%"+type+"%";
		source =StringUtils.isBlank(source)?"%%":"%"+source+"%";
 		Page<Corpgood_badinfo> page= corpgood_badinfoService.findWash(corp_name,type,source,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/infowash/good_badinfo/list";
	}
	
	
	@RequestMapping(value = "/good_badinfo/{id}")
	public String goodbadinfoDetail(@PathVariable String id, ModelMap model) {
		Corpgood_badinfo corpgood_badinfo = corpgood_badinfoService.find(id);
		try {
			if(StringUtils.isNotBlank(corpgood_badinfo.getFilename())){
				String filename = URLDecoder.decode(corpgood_badinfo.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				corpgood_badinfo.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		model.addAttribute("corpgood_badinfo", corpgood_badinfo);
		return "/infowash/good_badinfo/detail";
	}
	
	@RequestMapping(value = "/good_badinfo/wash/{id}/{state}")
	public String goodbadinfoWash(@PathVariable String id,@PathVariable String state) {
		Corpgood_badinfo good_badinfo = corpgood_badinfoService.find(id);
		if("通报批评".equals(good_badinfo.getType().trim())){
			Corpbadinfo badinfo=corpbadinfoService.find(id);
			badinfo.setState(state);
			badinfo.setModify_date(new Date());
			corpbadinfoService.update(badinfo);
		}else{
			Corpgoodinfo goodinfo=corpgoodinfoService.find(id);
			goodinfo.setState(state);
			goodinfo.setModify_date(new Date());
			corpgoodinfoService.update(goodinfo);
		}
		return "redirect:/infowash/good_badinfo";
	}
	
	
	
	@RequestMapping(value = "/mediaexposed",method = RequestMethod.GET)
	public String mediaexposedList(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String industry,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("industry", industry);
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		industry =StringUtils.isBlank(industry)?"%%":"%"+industry+"%";
 		Page<Corpmediaexposed> page= corpmediaexposedService.findWash(corp_name,industry,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/infowash/mediaexposed/list";
	}
	
	@RequestMapping(value = "/mediaexposed/{id}")
	public String mediaexposedDetail(@PathVariable String id, ModelMap model) {
		Corpmediaexposed corpmediaexposed = corpmediaexposedService.find(id);
		try {
			if(StringUtils.isNotBlank(corpmediaexposed.getFilename())){
				String filename = URLDecoder.decode(corpmediaexposed.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				corpmediaexposed.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		model.addAttribute("corpmediaexposed", corpmediaexposed);
		return "/infowash/mediaexposed/detail";
	}
	
	@RequestMapping(value = "/mediaexposed/wash/{id}/{state}")
	public String mediaexposedWash(@PathVariable String id,@PathVariable String state) {
		Corpmediaexposed mediaexposed = corpmediaexposedService.find(id);
		mediaexposed.setState(state);
		mediaexposed.setModify_date(new Date());
		corpmediaexposedService.update(mediaexposed);
		return "redirect:/infowash/mediaexposed";
	}
	
	@RequestMapping(value = "/judgedoc",method = RequestMethod.GET)
	public String judgedocList(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String industry,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("industry", industry);
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		industry =StringUtils.isBlank(industry)?"%%":"%"+industry+"%";
 		Page<Judgedoc> page= judgeDocService.findWash(corp_name,industry,pageable);
 		/*String str1=null;
 		String str2=null;
 		String str3=null;
 		String str4=null;
 		for (Judgedoc judgedoc : page.getContent()) {
 			str1="被告人"+judgedoc.getCorp_name();
 			str2="被执行人"+judgedoc.getCorp_name();
 			str3="原告"+judgedoc.getCorp_name();
 			str4="申请人"+judgedoc.getCorp_name();
			if(judgedoc.getContent().contains(str1)||judgedoc.getContent().contains(str2)||judgedoc.getContent().contains(str3)||judgedoc.getContent().contains(str4)){
				judgedoc.setState("1");
				judgedoc.setModify_date(new Date());
				judgeDocService.update(judgedoc);
			}
		}*/
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/infowash/judgedoc/list";
	}
	
	@RequestMapping(value = "/judgedoc/{id}")
	public String judgedocDetail(@PathVariable String id, ModelMap model) {
		Judgedoc judgedoc = judgeDocService.find(id);
		try {
			if(StringUtils.isNotBlank(judgedoc.getFilename())){
				String filename = URLDecoder.decode(judgedoc.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				judgedoc.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		model.addAttribute("judgedoc", judgedoc);
		return "/infowash/judgedoc/detail";
	}	
	
	@RequestMapping(value = "/judgedoc/wash/{id}/{state}")
	public String judgedocWash(@PathVariable String id,@PathVariable String state) {
		Judgedoc judgedoc = judgeDocService.find(id);
		judgedoc.setState(state);
		judgedoc.setModify_date(new Date());
		judgeDocService.update(judgedoc);
		return "redirect:/infowash/judgedoc";
	}
	
	
	@RequestMapping(value = "/dishonestman",method = RequestMethod.GET)
	public String dishonestmanList( 
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String industry,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("industry", industry);
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		industry =StringUtils.isBlank(industry)?"%%":"%"+industry+"%";
 		Page<Dishonestman> page= dishonestManService.findWash(corp_name,industry,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/infowash/dishonestman/list";
	}
	
	@RequestMapping(value = "/dishonestman/{id}")
	public String dishonestmanDetail(@PathVariable String id, ModelMap model) {
		Dishonestman dishonestMan = dishonestManService.find(id);
		try {
			if(StringUtils.isNotBlank(dishonestMan.getFilename())){
				String filename = URLDecoder.decode(dishonestMan.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				dishonestMan.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		model.addAttribute("dishonestMan", dishonestMan);
		return "/infowash/dishonestman/detail";
	}
	
	@RequestMapping(value = "/dishonestman/wash/{id}/{state}")
	public String dishonestmanWash(@PathVariable String id,@PathVariable String state ) {
		Dishonestman dishonestman = dishonestManService.find(id);
		dishonestman.setState(state);
		dishonestman.setModify_date(new Date());
		dishonestManService.update(dishonestman);
		return "redirect:/infowash/dishonestman";
	}
	
	@RequestMapping(value = "/publicprise",method = RequestMethod.GET)
	public String publicpriseList(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String accept_num,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("accept_num", accept_num);
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		accept_num =StringUtils.isBlank(accept_num)?"%%":"%"+accept_num+"%";
		Page<Public_prise> page = public_priseService.findWash(corp_name, accept_num, pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/infowash/publicprise/list";
	}

	@RequestMapping(value = "/publicprise/{id}")
	public String publicpriseDetail(@PathVariable String id, ModelMap model) {
		Public_prise prise = public_priseService.find(id);
		model.addAttribute("prise", prise);
		return "/infowash/publicprise/detail";
	}
	
	@RequestMapping(value = "/publicprise/wash/{id}/{state}")
	public String publicpriseWash(@PathVariable String id,@PathVariable String state) {
		Public_prise publicprise = public_priseService.find(id);
		publicprise.setState(state);
		publicprise.setModify_date(new Date());
		public_priseService.update(publicprise);
		return "redirect:/infowash/publicprise";
	}
	
	
	@RequestMapping(value = "/servicecomplaint",method = RequestMethod.GET)
	public String servicecomplaintList(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String vehicle_no,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("vehicle_no", vehicle_no);
		corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		vehicle_no =StringUtils.isBlank(vehicle_no)?"%%":"%"+vehicle_no+"%";
		Page<Service_complaint> page = service_complaintService.findWash(corp_name, vehicle_no, pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/infowash/servicecomplaint/list";
	}

	
	@RequestMapping(value = "/servicecomplaint/{id}")
	public String servicecomplaintDetail(@PathVariable String id, ModelMap model) {
		Service_complaint complaint = service_complaintService.find(id);
		model.addAttribute("complaint", complaint);
		return "/infowash/servicecomplaint/detail";
	}
	
	@RequestMapping(value = "/servicecomplaint/wash/{id}/{state}")
	public String servicecomplaintWash(@PathVariable String id,@PathVariable String state) {
		Service_complaint servicecomplaint = service_complaintService.find(id);
		servicecomplaint.setState(state);
		servicecomplaint.setUdate(new Date());
		service_complaintService.update(servicecomplaint);
		return "redirect:/infowash/servicecomplaint";
	}
	
	@RequestMapping(value = "/tender",method = RequestMethod.GET)
	public String tenderList(
			@RequestParam(required=false) String project_name,
			@RequestParam(required=false) String zhaobiaore,
			@PageableDefault(page = 0, size =  Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("project_name", project_name);
		model.addAttribute("zhaobiaore", zhaobiaore);
		project_name =StringUtils.isBlank(project_name)?"%%":"%"+project_name+"%";
		zhaobiaore =StringUtils.isBlank(zhaobiaore)?"%%":"%"+zhaobiaore+"%";
 		Page<Zhaobiaogg> page= zhaobiaoggService.findWash(project_name,zhaobiaore,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/infowash/tender/list";
	}
	@RequestMapping(value = "/tender/{id}")
	public String tenderDetail(@PathVariable String id, ModelMap model) {
		Zhaobiaogg zhaobiaogg = zhaobiaoggService.find(id);
		model.addAttribute("zhaobiaogg", zhaobiaogg);
		return "/infowash/tender/detail";
	}
	
	@RequestMapping(value = "/tender/wash/{id}/{state}")
	public String tenderWash(@PathVariable String id,@PathVariable String state) {
		Zhaobiaogg zhaobiaogg = zhaobiaoggService.find(id);
		zhaobiaogg.setState(state);
		zhaobiaogg.setModify_date(new Date());
		zhaobiaoggService.update(zhaobiaogg);
		return "redirect:/infowash/tender";
	}
	
	
	@RequestMapping(value = "/bid",method = RequestMethod.GET)
	public String bidList(
			@RequestParam(required=false) String project_name,
			@RequestParam(required=false) String zhaobiaore,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("project_name", project_name);
		model.addAttribute("zhaobiaore", zhaobiaore);
		project_name =StringUtils.isBlank(project_name)?"%%":"%"+project_name+"%";
		zhaobiaore =StringUtils.isBlank(zhaobiaore)?"%%":"%"+zhaobiaore+"%";
 		Page<Zhongbiaogg> page= zhongbiaoggService.findWash(project_name,zhaobiaore,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/infowash/bid/list";
	}
	@RequestMapping(value = "/bid/{id}")
	public String bidDetail(@PathVariable String id, ModelMap model) {
		Zhongbiaogg zhongbiaogg = zhongbiaoggService.find(id);
		model.addAttribute("zhongbiaogg", zhongbiaogg);
		return "/infowash/bid/detail";
	}
	
	@RequestMapping(value = "/bid/wash/{id}/{state}")
	public String bidWash(@PathVariable String id,@PathVariable String state) {
		Zhongbiaogg zhongbiaogg = zhongbiaoggService.find(id);
		zhongbiaogg.setState(state);
		zhongbiaogg.setModify_date(new Date());
		zhongbiaoggService.update(zhongbiaogg);
		return "redirect:/infowash/bid";
	}
	
}
