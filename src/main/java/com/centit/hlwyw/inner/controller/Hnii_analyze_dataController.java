package com.centit.hlwyw.inner.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Past;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

import com.centit.hlwyw.cache.CacheUtil;
import com.centit.hlwyw.cache.Cachemodel;
import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.ExportUtil;
import com.centit.hlwyw.inner.entity.Business_root;
import com.centit.hlwyw.inner.entity.Business_secondary;
import com.centit.hlwyw.inner.entity.ExportHnii;
import com.centit.hlwyw.inner.entity.Hnii_analyze_data;
import com.centit.hlwyw.inner.service.Business_rootService;
import com.centit.hlwyw.inner.service.Business_secondaryService;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;
import com.centit.hlwyw.solr.service.SolrService;

@Controller("hnii_analyze_dataController")
@RequestMapping("/hnii_analyze/hnii_analyze_data")
public class Hnii_analyze_dataController extends BaseController {
	private static Logger log = Logger.getLogger(Hnii_analyze_dataController.class);  

	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_dataService;
	
	@Resource(name = "business_rootServiceImpl")
	private Business_rootService business_rootService;
	
	@Resource(name = "business_secondaryServiceImpl")
	private Business_secondaryService business_secondaryService;
	
	@Resource(name = "solrServiceImpl")
	private SolrService solrService;

	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String btype,
			@RequestParam(required=false) String stype,
			@RequestParam(required=false) String industry,
			@RequestParam(required=false) String content,
			@RequestParam(required=false) @Past Date begindate,
			@RequestParam(required=false) @Past Date enddate,
			@PageableDefault(page = 0, size = 15) Pageable pageable,
			ModelMap model) {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		Map<String, Object> cacheMap=cacheUtil.getCache("exportYears");
		List<Object[]> years=null;
//		Page<Object> page = hnii_analyze_dataService.findDatas(btype, stype, industry, content,begindate,enddate, pageable);
		Page<Hnii_analyze_data> page = solrService.findDatas(btype, stype, industry, content,begindate,enddate, pageable);
		List<Business_root> roots=business_rootService.findAll();
		for (Business_root root : roots) {
			List<Business_secondary> secondarys=business_secondaryService.findByRootid(root.getRoot_id());
			root.setSecondarys(secondarys);
		}
		List<Business_secondary> secondarys=business_secondaryService.findAll();
		if(cacheMap==null){
			years=hnii_analyze_dataService.findYears();
			Cachemodel cachemodel=new Cachemodel();
		    Map<String, Object> map=new HashMap<String, Object>();
			map.put("years", years);
		    cachemodel.setCacheMap(map);
		    cachemodel.setCdate(new Date());
		    cachemodel.setVdate(24);
		    cacheUtil.addCache("exportYears",cachemodel);
		}else{
			years=(List<Object[]>)cacheMap.get("years");
		}
		model.addAttribute("years", years);
		model.addAttribute("year", years.get(0));
		model.addAttribute("roots", roots);
		model.addAttribute("secondarys", secondarys);
		model.addAttribute("btype", btype);
		model.addAttribute("stype", stype);
		model.addAttribute("industry", industry);
		model.addAttribute("content", content);
		model.addAttribute("begindate", begindate);
		model.addAttribute("enddate", enddate);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/hnii_analyze/list";
	} 
	/**
	 * show
	 */
	@RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
	String show(@PathVariable String id, ModelMap model) {
		Hnii_analyze_data hnii_analyze_data = solrService.find(id);
		if (hnii_analyze_data == null) {
			return "/common/resource_not_found";
		}
		model.addAttribute("object", hnii_analyze_data);
		return "/hnii_analyze/show";
	}
	/**
	 * List
	 */
	@RequestMapping(value = "/export", produces = "application/json; charset=utf-8",method = RequestMethod.GET)
	@ResponseBody
	public String listExport(
			@RequestParam(required=false) String btype,
			@RequestParam(required=false) String stype,
			@RequestParam(required=false) String industry,
			@RequestParam(required=false) String content,
//			@RequestParam(required=false) String year,
			@RequestParam(required=false) Date begindate,
			@RequestParam(required=false) Date enddate,
			HttpServletRequest req) {
		List<Object[]> list =hnii_analyze_dataService.findDatasList(btype, stype, industry, content,begindate,enddate);
		List<ExportHnii> hniis=new ArrayList<ExportHnii>();
		ExportHnii e=null;
		for (Object[] object : list) {
			 e=new ExportHnii();
			e.setId((String)object[0]);
			e.setMyid((String)object[1]);
			e.setBtype((String)object[2]);
			e.setStype((String)object[3]);
			e.setIndustry((String)object[4]);
			e.setObject((String)object[5]);
			e.setObjectname((String)object[6]);
			e.setCarno((String)object[7]);
			e.setLineno((String)object[8]);
			e.setTime((String)object[9]);
			e.setBaddress((String)object[10]);
			e.setEaddress((String)object[11]);
			e.setContent((String)object[12]);
			e.setUnit((String)object[13]);
			e.setDealopinion((String)object[14]);
			e.setCalltime((Date)object[15]);
			object=null;
			hniis.add(e);
		}
		list=null;
		String[] headers={"工单流水号","业务大类","业务小类","行业类别","主体对象","主体对象名称","车牌号","线路号","事发时间","事发起点","事发终点","工单内容","责任单位","办理意见","来电时间"};
		ExportUtil<ExportHnii> excel=new ExportUtil<>();
		HSSFWorkbook workbook=excel.exportExcelMore(headers, hniis);
		String pathurl=req.getSession().getServletContext().getRealPath("")+"\\doc\\";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		if(industry==null){
			industry="";
		}
		if(btype==null){
			btype="";
		}
		if(stype==null){
			stype="";
		}
		String filename="96096工单数据"+industry+btype+stype+sdf.format(new Date());
		OutputStream os=null;
		try {
			os = new FileOutputStream(pathurl + filename + ".xls");
			workbook.write(os);
		} catch (FileNotFoundException e2) {
			log.error(e2.getMessage());log.info(e2);
 		}catch (Exception e1) {
			log.error(e1.getMessage());log.info(e1);
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e1) {
					log.error(e1.getMessage());log.info(e1);
 				}
			}
		}
		
		return filename+".xls";
	}
	

}
