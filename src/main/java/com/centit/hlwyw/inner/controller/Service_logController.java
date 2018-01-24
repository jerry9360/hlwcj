package com.centit.hlwyw.inner.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

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
import com.centit.hlwyw.core.util.TimeSearchUtil;
import com.centit.hlwyw.inner.entity.Service_interface;
import com.centit.hlwyw.inner.entity.Service_log;
import com.centit.hlwyw.inner.service.LogbusinessService;
import com.centit.hlwyw.inner.service.LogsaveService;
import com.centit.hlwyw.inner.service.Service_logService;
import com.centit.hlwyw.inner.service.impl.TimeServiceImpl;


@Controller("service_logController")
@RequestMapping("servicemgr/logs")
public class Service_logController extends BaseController{
	
	private static Logger log = Logger.getLogger(Service_logController.class);  
	
	
	@Resource(name="service_logServiceImpl")
	private Service_logService service_logService;
	@Resource(name="logbusinessServiceImpl")
	private LogbusinessService logbusinessService;
	@Resource(name="logsaveServiceImpl")
	private LogsaveService logsaveService;
	
	
	
	@Resource(name = "timeServiceImpl")
	private TimeServiceImpl timeService;


	
	
/*	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) @Past Date begintime,
			@RequestParam(required=false) @Past Date  endtime,
			@RequestParam(required=false) String unit,
			@RequestParam(required=false) String data_type,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
		String begintime1=simpleDateFormat.format(begintime);
		String endtime1=simpleDateFormat.format(endtime);
		model.addAttribute("begintime", begintime);
		model.addAttribute("endtime", endtime);
		model.addAttribute("unit", unit);
		model.addAttribute("data_type", data_type);
 		Page<Service_log> page= service_logService.findInterfaceSearch(begintime1, endtime1, unit, data_type, pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "logmanager/list";
	}
//	*/
//	/**
//	 * ListRoot
//	 */
//	
//	@RequestMapping(value="/select",method = RequestMethod.GET)
//	public String listLogs(
//			ModelMap model) {
//		List<Service_log> servicelogLists=service_logService.findAll();
//		model.addAttribute("servicelogLists", servicelogLists);
//		return "/servicelogLists/list";
//		
//	}
	
/*	@RequestMapping(method = RequestMethod.GET)
	public String listloggs(
			@RequestParam(required=false) String times,
			@RequestParam(required=false) String unit,
			@RequestParam(required=false) String data_size,
			@RequestParam(required=false)  String begindate,
			@RequestParam(required=false)   String enddate,
			ModelMap model)  {
		String[] date = new String[2];
//		0 近一周  1  近一个月  2 今年  3 今年
		if(begindate==null&&enddate==null){
		if("0".equals(times)){
			date = timeService.getWeek();
		}else if("1".equals(times)){
			date = timeService.getMonth();
		}else if("2".equals(times)){
			date = timeService.getThisYear();
		}else if("3".equals(times)){
			date = timeService.getLastYear();
			}
		begindate = date[0];
		enddate = date[1];
		}
		List<Object> servicelogs = service_logService.findAllData(unit, data_size, begindate, enddate);
		model.addAttribute("servicelogs", servicelogs);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
		if(begindate!=null&&enddate!=null){
		try {
			Date begindate1 = sdf.parse(begindate);
			Date enddate1 = sdf.parse(enddate);
			model.addAttribute("begindate", begindate1);
			model.addAttribute("enddate", enddate1);
		} catch (ParseException e) {
			e.printStackTrace();
			}
		}
	return "servicelogs/list";
}
	*/
	
	
	@RequestMapping( method = RequestMethod.GET)
	public String servicelogs(
			@RequestParam(required=false) String searchtype,
			@RequestParam(required=false) String searchtypesub,
			@RequestParam(required=false) Date begindate,
			@RequestParam(required=false) Date enddate,ModelMap model) {
		log("servicelogs", searchtype, searchtypesub, begindate, enddate, model);
 		return "/servicelogs/list";
	}
	
	
	/**
	 * save
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@Valid Service_log service_log,
			ModelMap model) {
//		if (bindingResult.hasErrors()) {
//			return Constantval.CONSTANT_FAIL;
//		}
		if(service_log.getId()==null||service_log.getId().trim().length()==0){
			service_log.setId(KeyUtils.getKey());
			service_log.setCreate_date(new Date());
			service_log.setModify_date(new Date());
			service_logService.save(service_log);
		}
		service_log.setModify_date(new Date());
		service_logService.update(service_log);
		return Constantval.CONSTANT_SUCCESS;
	}

	
	
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Service_log edit(@PathVariable String id, ModelMap model) {
		Service_log service_log= service_logService.find(id);
		service_logService.update(service_log);
		/*service_logService.update(service_log);*/
		return service_log;
		
	}
	
	
	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	String delete(@PathVariable String id) {
		service_logService.delete(id);
		return Constantval.CONSTANT_SUCCESS;
	}

	private void log(String logtype,String searchtype,String searchtypesub,Date begindate,Date enddate,ModelMap model){
		if(searchtype==null||searchtype.trim().length()==0
				||(!("subtime".equals(searchtype))&&!("oneweek".equals(searchtype))
						&&!("onemonth".equals(searchtype))&&!("thisyear".equals(searchtype))&&!("lastyear".equals(searchtype)))){
			searchtype="oneweek";
			model.addAttribute("searchtype", searchtype);
		}else if("subtime".equals(searchtype)){
			if(searchtypesub==null||searchtypesub.trim().length()==0
					||(!("day".equals(searchtypesub))&&!("month".equals(searchtypesub))&&!("year".equals(searchtypesub)))){
				searchtypesub="year";
			}

			if(begindate==null||enddate==null){
				searchtypesub="date";
				Date[] date=TimeSearchUtil.getWeek();
				begindate =date[0];
				enddate =date[1];
			}
			
			model.addAttribute("searchtype", searchtype);
			model.addAttribute("searchtypesub", searchtypesub);
			model.addAttribute("begindate", begindate);
			model.addAttribute("enddate", enddate);
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
		List<Object[]> serviceloglist=null;
		if("servicelogs".equals(logtype)||"weblog".equals(logtype)){
			serviceloglist=service_logService.findGroupByDateMonthYear(searchtypesub,begindate, enddate);
		}else if("businesslog".equals(logtype)){
			serviceloglist=logbusinessService.findGroupByDateMonthYear(searchtypesub,begindate, enddate);
		}else if("logsave".equals(logtype)){
			serviceloglist=logsaveService.findGroupByDateMonthYear(searchtypesub,begindate, enddate);
		}
		Map<String,Map<String,Long>> datamap=service_logService.getTableMapGroup(datelist,begindate,enddate,serviceloglist);
		Object[] chartdata=service_logService.getChartData(datelist,datamap);
		model.addAttribute("datelist", datelist);
		model.addAttribute("tabletr", chartdata[3]);
		model.addAttribute("chartdata", chartdata);
	}

}