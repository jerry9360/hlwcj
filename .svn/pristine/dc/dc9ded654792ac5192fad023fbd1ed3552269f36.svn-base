package com.centit.hlwyw.inner.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.cache.CacheUtil;
import com.centit.hlwyw.cache.Cachemodel;
import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.inner.service.Corpgood_badinfoService;
import com.centit.hlwyw.inner.service.CorpmediaexposedService;
import com.centit.hlwyw.inner.service.DishonestManService;
import com.centit.hlwyw.inner.service.JudgeDocService;
import com.centit.hlwyw.inner.service.Public_priseService;
import com.centit.hlwyw.inner.service.Service_complaintService;
import com.centit.hlwyw.sys.entity.Menu;
import com.centit.hlwyw.sys.service.MenuService;



@Controller("statController")
@RequestMapping("/stat")
public class StatController extends BaseController {
	

	@Resource(name = "menuServiceImpl")
	private MenuService menuService;

	@Resource(name = "judgeDocServiceImpl")
	private JudgeDocService judgeDocService;
	
	@Resource(name = "corpgood_badinfoServiceImpl")
	private Corpgood_badinfoService corpgood_badinfoService;
	
	@Resource(name = "corpmediaexposedServiceImpl")
	private CorpmediaexposedService corpmediaexposedService;
	
	@Resource(name = "dishonestManServiceImpl")
	private DishonestManService dishonestManService;
	
	@Resource(name = "public_priseServiceImpl")
	private Public_priseService public_priseService;
	
	@Resource(name = "service_complaintServiceImpl")
	private Service_complaintService service_complaintService;
	
	@RequestMapping(value="/cognos",method = RequestMethod.GET)
 	public String cognos(@Length(min=32, max=32)String menuid,ModelMap model) {
		Menu m = menuService.find(menuid);
		if(m!=null){
			model.addAttribute("menucode", m.getMenucode());
			model.addAttribute("urlpath", m.getUrl());
			model.addAttribute("menuname", m.getMenudesc());
		}
		return "/stat/cognos"; 
	}
	
	@RequestMapping(value="/judgedoc",method = RequestMethod.GET)
	public String listJudgedoc(ModelMap model) {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		Map<String, Object> cacheMap=cacheUtil.getCache("judgedoc");
		List<Object[]> judgeDocs=null;
		BigDecimal countAll=new BigDecimal(0);
		List<String> xdata=new ArrayList<String>();
		List<BigDecimal> ydata=new ArrayList<BigDecimal>();
		if(cacheMap==null){
			judgeDocs=judgeDocService.stat();
			for (Object[] obj : judgeDocs) {
				countAll=countAll.add((BigDecimal)obj[1]);
				if("1".equals(obj[0].toString())){
					xdata.add("'刑事案件'");
				}else if("2".equals(obj[0].toString())){
					xdata.add("'民事案件'");
				}else if("3".equals(obj[0].toString())){
					xdata.add("'行政案件'");
				}else if("4".equals(obj[0].toString())){
					xdata.add("'赔偿案件'");
				}else if("5".equals(obj[0].toString())){
					xdata.add("'执行案件'");
				}
				ydata.add((BigDecimal)obj[1]);
			}
			Cachemodel cachemodel=new Cachemodel();
		    Map<String, Object> map=new HashMap<String, Object>();
			map.put("judgeDocs", judgeDocs);
			map.put("countAll", countAll);
			map.put("xdata", xdata);
			map.put("ydata", ydata);
		    cachemodel.setCacheMap(map);
		    cachemodel.setCdate(new Date());
		    cachemodel.setVdate(24);
		    cacheUtil.addCache("judgedoc",cachemodel);
		}else{
			judgeDocs=(List<Object[]>)cacheMap.get("judgeDocs");
			countAll=(BigDecimal)cacheMap.get("countAll");
			xdata=(List<String>)cacheMap.get("xdata");
			ydata=(List<BigDecimal>)cacheMap.get("ydata");
		}
		model.addAttribute("judgeDocs", judgeDocs);
		model.addAttribute("countAll", countAll);
		model.addAttribute("xdata", xdata);
		model.addAttribute("ydata", ydata);
		return "/stat/judgedoc";
	}
	
	@RequestMapping(value="/goodbad",method = RequestMethod.GET)
	public String goodbadList(ModelMap model) {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		Map<String, Object> cacheMap=cacheUtil.getCache("goodbad");
		List<Object[]> goodbads=null;
		BigDecimal countAll=new BigDecimal(0);
		List<String> xdata=new ArrayList<String>();
		List<BigDecimal> ydata=new ArrayList<BigDecimal>();
		if(cacheMap==null){
			goodbads=corpgood_badinfoService.stat();
			for (Object[] obj : goodbads) {
				countAll=countAll.add((BigDecimal)obj[1]);
			    xdata.add("'"+obj[0]+"'");
				ydata.add((BigDecimal)obj[1]);
			}
			Cachemodel cachemodel=new Cachemodel();
		    Map<String, Object> map=new HashMap<String, Object>();
			map.put("goodbads", goodbads);
			map.put("countAll", countAll);
			map.put("xdata", xdata);
			map.put("ydata", ydata);
		    cachemodel.setCacheMap(map);
		    cachemodel.setCdate(new Date());
		    cachemodel.setVdate(24);
		    cacheUtil.addCache("goodbad",cachemodel);
		}else{
			goodbads=(List<Object[]>)cacheMap.get("goodbads");
			countAll=(BigDecimal)cacheMap.get("countAll");
			xdata=(List<String>)cacheMap.get("xdata");
			ydata=(List<BigDecimal>)cacheMap.get("ydata");
		}
		model.addAttribute("goodbads", goodbads);
		model.addAttribute("countAll", countAll);
		model.addAttribute("xdata", xdata);
		model.addAttribute("ydata", ydata);
		return "/stat/goodbad";
	}
	
	@RequestMapping(value="/dishonestMan",method = RequestMethod.GET)
	public String dishonestManList(ModelMap model) {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		Map<String, Object> cacheMap=cacheUtil.getCache("dishonestMan");
		List<Object[]> dishonestMans=null;
		BigDecimal countAll=new BigDecimal(0);
		List<String> xdata=new ArrayList<String>();
		List<BigDecimal> ydata=new ArrayList<BigDecimal>();
		if(cacheMap==null){
			dishonestMans=dishonestManService.stat();
			for (Object[] obj : dishonestMans) {
				countAll=countAll.add((BigDecimal)obj[1]);
			    xdata.add("'"+obj[0]+"'");
				ydata.add((BigDecimal)obj[1]);
			}
			Cachemodel cachemodel=new Cachemodel();
		    Map<String, Object> map=new HashMap<String, Object>();
			map.put("dishonestMans", dishonestMans);
			map.put("countAll", countAll);
			map.put("xdata", xdata);
			map.put("ydata", ydata);
		    cachemodel.setCacheMap(map);
		    cachemodel.setCdate(new Date());
		    cachemodel.setVdate(24);
		    cacheUtil.addCache("dishonestMan",cachemodel);
		}else{
			dishonestMans=(List<Object[]>)cacheMap.get("dishonestMans");
			countAll=(BigDecimal)cacheMap.get("countAll");
			xdata=(List<String>)cacheMap.get("xdata");
			ydata=(List<BigDecimal>)cacheMap.get("ydata");
		}
		model.addAttribute("dishonestMans", dishonestMans);
		model.addAttribute("countAll", countAll);
		model.addAttribute("xdata", xdata);
		model.addAttribute("ydata", ydata);
		return "/stat/dishonestMan";
	}
	
	@RequestMapping(value="/mediaexposed",method = RequestMethod.GET)
	public String mediaexposedList(ModelMap model) {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		Map<String, Object> cacheMap=cacheUtil.getCache("mediaexposed");
		List<Object[]> mediaexposeds=null;
		BigDecimal countAll=new BigDecimal(0);
		List<String> xdata=new ArrayList<String>();
		List<BigDecimal> ydata=new ArrayList<BigDecimal>();
		if(cacheMap==null){
			mediaexposeds=corpmediaexposedService.stat();
			for (Object[] obj : mediaexposeds) {
				countAll=countAll.add((BigDecimal)obj[1]);
			    xdata.add("'"+obj[0]+"'");
				ydata.add((BigDecimal)obj[1]);
			}
			Cachemodel cachemodel=new Cachemodel();
		    Map<String, Object> map=new HashMap<String, Object>();
			map.put("mediaexposeds", mediaexposeds);
			map.put("countAll", countAll);
			map.put("xdata", xdata);
			map.put("ydata", ydata);
		    cachemodel.setCacheMap(map);
		    cachemodel.setCdate(new Date());
		    cachemodel.setVdate(24);
		    cacheUtil.addCache("mediaexposed",cachemodel);
		}else{
			mediaexposeds=(List<Object[]>)cacheMap.get("mediaexposeds");
			countAll=(BigDecimal)cacheMap.get("countAll");
			xdata=(List<String>)cacheMap.get("xdata");
			ydata=(List<BigDecimal>)cacheMap.get("ydata");
		}
		model.addAttribute("mediaexposeds", mediaexposeds);
		model.addAttribute("countAll", countAll);
		model.addAttribute("xdata", xdata);
		model.addAttribute("ydata", ydata);
		return "/stat/mediaexposed";
	}
	
	@RequestMapping(value="/publicprise",method = RequestMethod.GET)
	public String publicpriseList(ModelMap model) {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		Map<String, Object> cacheMap=cacheUtil.getCache("publicprise");
		List<Object[]> publicprises=null;
		BigDecimal countAll=new BigDecimal(0);
		List<String> xdata=new ArrayList<String>();
		List<BigDecimal> ydata=new ArrayList<BigDecimal>();
		if(cacheMap==null){
			publicprises=public_priseService.stat();
			for (Object[] obj : publicprises) {
				countAll=countAll.add((BigDecimal)obj[1]);
			    xdata.add("'"+obj[0]+"'");
				ydata.add((BigDecimal)obj[1]);
			}
			Cachemodel cachemodel=new Cachemodel();
		    Map<String, Object> map=new HashMap<String, Object>();
			map.put("publicprises", publicprises);
			map.put("countAll", countAll);
			map.put("xdata", xdata);
			map.put("ydata", ydata);
		    cachemodel.setCacheMap(map);
		    cachemodel.setCdate(new Date());
		    cachemodel.setVdate(24);
		    cacheUtil.addCache("publicprise",cachemodel);
		}else{
			publicprises=(List<Object[]>)cacheMap.get("publicprises");
			countAll=(BigDecimal)cacheMap.get("countAll");
			xdata=(List<String>)cacheMap.get("xdata");
			ydata=(List<BigDecimal>)cacheMap.get("ydata");
		}
		model.addAttribute("publicprises", publicprises);
		model.addAttribute("countAll", countAll);
		model.addAttribute("xdata", xdata);
		model.addAttribute("ydata", ydata);
		return "/stat/publicprise";
	}
	
	@RequestMapping(value="/servicecomplaint",method = RequestMethod.GET)
	public String servicecomplaintList(ModelMap model) {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		Map<String, Object> cacheMap=cacheUtil.getCache("servicecomplaint");
		List<Object[]> servicecomplaints=null;
		BigDecimal countAll=new BigDecimal(0);
		List<String> xdata=new ArrayList<String>();
		List<BigDecimal> ydata=new ArrayList<BigDecimal>();
		if(cacheMap==null){
			servicecomplaints=service_complaintService.stat();
			for (Object[] obj : servicecomplaints) {
				countAll=countAll.add((BigDecimal)obj[1]);
			    xdata.add("'"+obj[0]+"'");
				ydata.add((BigDecimal)obj[1]);
			}
			Cachemodel cachemodel=new Cachemodel();
		    Map<String, Object> map=new HashMap<String, Object>();
			map.put("servicecomplaints", servicecomplaints);
			map.put("countAll", countAll);
			map.put("xdata", xdata);
			map.put("ydata", ydata);
		    cachemodel.setCacheMap(map);
		    cachemodel.setCdate(new Date());
		    cachemodel.setVdate(24);
		    cacheUtil.addCache("servicecomplaint",cachemodel);
		}else{
			servicecomplaints=(List<Object[]>)cacheMap.get("servicecomplaints");
			countAll=(BigDecimal)cacheMap.get("countAll");
			xdata=(List<String>)cacheMap.get("xdata");
			ydata=(List<BigDecimal>)cacheMap.get("ydata");
		}
		model.addAttribute("servicecomplaints", servicecomplaints);
		model.addAttribute("countAll", countAll);
		model.addAttribute("xdata", xdata);
		model.addAttribute("ydata", ydata);
		return "/stat/servicecomplaint";
	}



}

