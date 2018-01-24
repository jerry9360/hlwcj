package com.centit.hlwyw.inner.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

@Controller("analyzeCorpOrderController")
@RequestMapping("/analyzemgr/corporder")
public class AnalyzeCorpOrderController extends BaseController{
	
	private static Logger log = Logger.getLogger(AnalyzeCorpOrderController.class);
	
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
			@RequestParam(required=false) String datatype,
			@RequestParam(required=false)  String begindate,
			@RequestParam(required=false)   String enddate,
			ModelMap model) {
		List<Object> page = null;
		if("".equals(begindate)){
			begindate =null;
		}if ("".equals(enddate)){
			enddate =null;
		}
		if("".equals(datatype)||datatype==null)
			datatype="judgedoc";
	   if ("judgedoc".equals(datatype)){
		   page = judgedocService.findDatas(begindate,enddate);
	   }else if ("dishonestman".equals(datatype)){
		   page = dishonestmanService.findDatas(begindate,enddate);
	   }else if ("biaozhang".equals(datatype)||"huojiang".equals(datatype)){
		   String type = null;
		   if("biaozhang".equals(datatype)){
			   type = "表彰";
		   }else{
			   type = "获奖";
			   }
		   page = corpgoodinfoService.findDatas(type,begindate,enddate);
	   }else if ("tongbaopiping".equals(datatype)){
		   page = corpbadinfoService.findDatas(begindate,enddate);
	   }else if ("public_prise".equals(datatype)){
		   page = public_priseService.findDatas(begindate,enddate);
	   }else if ("servicecomplaint".equals(datatype)){
		   page = service_complaintService.findDatas(begindate,enddate);
	   }else if("zhaobiao".equals(datatype)){
		  page = zhaobiaoggService.findDatas(begindate,enddate );
		}else if ("zhongbiao".equals(datatype)){
		  page = zhongbiaoggService.findDatas(begindate,enddate);
	   }
		model.addAttribute("page", page);
		model.addAttribute("datatype", datatype);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
		if(begindate!=null&&enddate!=null){
		try {
			Date begindat = sdf.parse(begindate);
			Date enddat = sdf.parse(enddate);
			model.addAttribute("begindate", begindat);
			model.addAttribute("enddate", enddat);
		} catch (ParseException e) {
			e.printStackTrace();
			}
		}
		return "/analyzecorporder/list";
	}
	
	/**
	 * 查看详情
	 */
	@RequestMapping(value = "/show")
	public String projectDetail(@RequestParam(required=false)  String corpname,
			@RequestParam(required=false) String datatype,
			@PageableDefault(page = 0, size = 15) Pageable pageable,
			ModelMap model) {
			if ("judgedoc".equals(datatype)){
			   Page<Judgedoc> page = judgedocService.findList(corpname,pageable);
			   model.addAttribute("page", page);
			   }else if ("dishonestman".equals(datatype)){
			   Page<Dishonestman> page = dishonestmanService.findList(corpname,pageable);
			   model.addAttribute("page", page);
			   }else if ("biaozhang".equals(datatype)||"huojiang".equals(datatype)){
			   String type = null;
			   if("biaozhang".equals(datatype)){
				   type = "表彰";
			   }else{
			   type = "获奖";
			   }
			   Page<Corpgoodinfo> page = corpgoodinfoService.findList(type,corpname,pageable);
			   model.addAttribute("page", page);
		   }else if ("tongbaopiping".equals(datatype)){
			   Page<Corpbadinfo> page = corpbadinfoService.findList(corpname,pageable);
			   model.addAttribute("page", page);
		   }else if ("public_prise".equals(datatype)){
			   Page<Public_prise> page = public_priseService.findList(corpname,pageable);
			   model.addAttribute("page", page);
		   }else if ("servicecomplaint".equals(datatype)){
			   Page<Service_complaint> page = service_complaintService.findList(corpname,pageable);
			   model.addAttribute("page", page);
		   }else if("zhaobiao".equals(datatype)){
			  Page<Zhaobiaogg> page = zhaobiaoggService.findList(corpname,pageable);
			  model.addAttribute("page", page);
			}else if ("zhongbiao".equals(datatype)){
			Page<Zhaobiaogg> page = zhaobiaoggService.findList(corpname,pageable);
			model.addAttribute("page", page);
		   }else if ("zhongbiao".equals(datatype)){
			  Page<Zhongbiaogg> page = zhongbiaoggService.findList(corpname,pageable);
			  model.addAttribute("page", page);
		   }
		model.addAttribute("datatype", datatype);
		model.addAttribute("corpname", corpname);
		model.addAttribute("pageable", pageable);
		return "/analyzecorporder/show";
	}
	
}
