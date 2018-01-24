package com.centit.hlwyw.inner.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.TimeSearchUtil;
import com.centit.hlwyw.inner.service.LogbusinessService;
import com.centit.hlwyw.inner.service.LogcollectService;
import com.centit.hlwyw.inner.service.LogsaveService;

@Controller("datalogController")
public class DatalogController extends BaseController {

	
	@Resource(name="logcollectServiceImpl")
	private LogcollectService logcollectService;
	@Resource(name="logbusinessServiceImpl")
	private LogbusinessService logbusinessService;
	@Resource(name="logsaveServiceImpl")
	private LogsaveService logsaveService;
	
	/**
	 * 数据采集-采集日志
	 */
	@RequestMapping(value = "/urlmgr/collectlog",method = RequestMethod.GET)
	public String collectlog(
			@RequestParam(required=false) String searchtype,
			@RequestParam(required=false) String searchtypesub,
			@RequestParam(required=false) Date begindate,
			@RequestParam(required=false) Date enddate,ModelMap model) {
		log("collectlog", searchtype, searchtypesub, begindate, enddate, model);
 		return "/datalog/collectlog";
	}


	  
	/**
	 * 数据清洗-网站清洗日志
	 */
	@RequestMapping(value = "/logmgr/weblog",method = RequestMethod.GET)
	public String weblog(
			@RequestParam(required=false) String searchtype,
			@RequestParam(required=false) String searchtypesub,
			@RequestParam(required=false) Date begindate,
			@RequestParam(required=false) Date enddate,ModelMap model) {
		log( "weblog", searchtype, searchtypesub, begindate, enddate, model);
 		return "/datalog/weblog";
	}
	/**
	 * 数据存储-存储日志
	 */
	@RequestMapping(value = "/datamgr/logsave",method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String searchtype,
			@RequestParam(required=false) String searchtypesub,
			@RequestParam(required=false) Date begindate,
			@RequestParam(required=false) Date enddate,ModelMap model) {
		log( "logsave", searchtype, searchtypesub, begindate, enddate, model);
 		return "/datalog/logsave";
	}
	 
	/**
	 * 数据清洗-业务清洗日志
	 */
	@RequestMapping(value = "/logmgr/businesslog",method = RequestMethod.GET)
	public String businesslog(
			@RequestParam(required=false) String searchtype,
			@RequestParam(required=false) String searchtypesub,
			@RequestParam(required=false) Date begindate,
			@RequestParam(required=false) Date enddate,ModelMap model) {
		log( "businesslog", searchtype, searchtypesub, begindate, enddate, model);
 		return "/datalog/businesslog";
	}
	private void log(String logtype,String searchtype,String searchtypesub,Date begindate,Date enddate,ModelMap model)  {
		if(searchtype==null||searchtype.trim().length()==0
				||(!("subtime".equals(searchtype))&&!("oneweek".equals(searchtype))
						&&!("onemonth".equals(searchtype))&&!("thisyear".equals(searchtype))&&!("lastyear".equals(searchtype)))){
			searchtype="oneweek";
			model.addAttribute("searchtype", searchtype);
		}else if("subtime".equals(searchtype)){
			if(searchtypesub==null||searchtypesub.trim().length()==0
					||(!("day".equals(searchtypesub))&&!("month".equals(searchtypesub))&&!("year".equals(searchtypesub)))){
				searchtypesub="month";
			}

			if(begindate==null||enddate==null){
				searchtypesub="month";
				Date[] date=TimeSearchUtil.getThisYear();
				begindate =date[0];
				enddate =date[1];
			}
			
			model.addAttribute("searchtype", searchtype);
			model.addAttribute("searchtypesub", searchtypesub);
			model.addAttribute("begindate", begindate);
			model.addAttribute("enddate", enddate);
 		}else{
			model.addAttribute("searchtype", searchtype);
 		}
		
		if("oneweek".equals(searchtype)){
			Date[] date=TimeSearchUtil.getWeek();
			begindate =date[0];
			enddate =date[1];
			searchtypesub="day";
		}else if("onemonth".equals(searchtype)){
			Date[] date=TimeSearchUtil.getMonth();
			begindate =date[0];
			enddate =date[1];
			searchtypesub="day";
		}else if("thisyear".equals(searchtype)){
			Date[] date=TimeSearchUtil.getThisYear();
			begindate =date[0];
			enddate =date[1];
			searchtypesub="month";
		}else if("lastyear".equals(searchtype)){
			Date[] date=TimeSearchUtil.getLastYear();
			begindate =date[0];
			enddate =date[1];
			searchtypesub="month";
		}
		
		List<String> datelist=TimeSearchUtil.getSubTimeGroupByDateMonthYear(searchtypesub,begindate, enddate);
		List<Object[]> loglist=null;
		if("collectlog".equals(logtype)||"weblog".equals(logtype)){
			loglist=logcollectService.findGroupByDateMonthYear(searchtypesub,begindate, enddate);
		}else if("businesslog".equals(logtype)){
			loglist=logbusinessService.findGroupByDateMonthYear(searchtypesub,begindate, enddate);
		}else if("logsave".equals(logtype)){
			loglist=logsaveService.findGroupByDateMonthYear(searchtypesub,begindate, enddate);
		}
		Map<String,Map<String,Long>> datamap=logcollectService.getTableMapGroup(datelist,begindate,enddate,loglist);
		Object[] chartdata=logcollectService.getChartData(datelist,datamap);
		model.addAttribute("datelist", datelist);
		model.addAttribute("tabletr", chartdata[3]);
		model.addAttribute("chartdata", chartdata);
	}

}