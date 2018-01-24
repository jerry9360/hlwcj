package com.centit.hlwyw.inner.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.cache.CacheUtil;
import com.centit.hlwyw.cache.Cachemodel;
import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Bigtypestatistics;
import com.centit.hlwyw.inner.entity.Business_root;
import com.centit.hlwyw.inner.entity.Business_secondary;
import com.centit.hlwyw.inner.entity.EntityDalei;
import com.centit.hlwyw.inner.entity.EntityXiaolei;
import com.centit.hlwyw.inner.entity.Industry_type;
import com.centit.hlwyw.inner.entity.Industrystatistics;
import com.centit.hlwyw.inner.entity.Info;
import com.centit.hlwyw.inner.entity.InfoStat;
import com.centit.hlwyw.inner.entity.Smalltypestatistics;
import com.centit.hlwyw.inner.service.BigtypestatisticsService;
import com.centit.hlwyw.inner.service.Business_rootService;
import com.centit.hlwyw.inner.service.Business_secondaryService;
import com.centit.hlwyw.inner.service.Hnii_alarm_serviceService;
import com.centit.hlwyw.inner.service.Hnii_askService;
import com.centit.hlwyw.inner.service.Hnii_complaintService;
import com.centit.hlwyw.inner.service.Hnii_priseService;
import com.centit.hlwyw.inner.service.Hnii_reflectService;
import com.centit.hlwyw.inner.service.Hnii_suggestService;
import com.centit.hlwyw.inner.service.Hniidata_viewService;
import com.centit.hlwyw.inner.service.HniiservicedataService;
import com.centit.hlwyw.inner.service.Industry_typeService;
import com.centit.hlwyw.inner.service.IndustrystatisticsService;
import com.centit.hlwyw.inner.service.SmalltypestatisticsService;

@Controller("hniiservicedataController")
@RequestMapping("/hnii/hniiservicedata")
public class HniiservicedataController extends BaseController {
 
	@Resource(name = "hniiservicedataServiceImpl")
	private HniiservicedataService hniiservicedataService;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "hnii_complaintServiceImpl")
	private Hnii_complaintService hnii_complaintService;
	
	@Resource(name = "hnii_askServiceImpl")
	private Hnii_askService hnii_askService;
	
	@Resource(name = "hnii_suggestServiceImpl")
	private Hnii_suggestService hnii_suggestService;
	
	@Resource(name = "hnii_priseServiceImpl")
	private Hnii_priseService hnii_priseService;

	@Resource(name = "hnii_reflectServiceImpl")
	private Hnii_reflectService hnii_reflectService;
	
	@Resource(name = "hnii_alarm_serviceServiceImpl")
	private Hnii_alarm_serviceService hnii_alarm_serviceService;
	
	@Resource(name = "industry_typeServiceImpl")
	private Industry_typeService industry_typeService;
	
	@Resource(name = "business_rootServiceImpl")
	private Business_rootService business_rootService;
	
	@Resource(name = "business_secondaryServiceImpl")
	private Business_secondaryService business_secondaryService;
	
	@Resource(name = "hniidata_viewServiceImpl")
	private Hniidata_viewService hniidata_viewService;
	
	@Resource(name = "industrystatisticsServiceImpl")
	private IndustrystatisticsService industrystatisticsService;
	
	@Resource(name = "bigtypestatisticsServiceImpl")
	private BigtypestatisticsService bigtypestatisticsService;
	
	@Resource(name = "smalltypestatisticsServiceImpl")
	private SmalltypestatisticsService smalltypestatisticsService;

/**
 * 96096工单数据汇总
 */
@RequestMapping(value = "/datacollect",method = RequestMethod.GET)
public String listCollect(ModelMap model){
	CacheUtil cacheUtil=CacheUtil.newInstance();
	Map<String, Object> cacheMap=cacheUtil.getCache("stat");
	List<Industry_type> industryList=null;
	List<Business_root> roots=null;
	List<String> industrynames=new ArrayList<String>();
	List<String> industrycount=new ArrayList<String>();
	List<String> rootnames=new ArrayList<String>();
	List<String> rootcount=new ArrayList<String>();
	List<Object[]> dataIndustry=null;
	List<Object[]> dataDalei=null;
	List<Object[]> dataXiaolei=null;
	List<Object[]> years=null;
	BigDecimal countAll=new BigDecimal(0);
	List<String> yearnames=new ArrayList<String>();
	List<String> yearcount=new ArrayList<String>();
	List<EntityDalei> entityDaleis=new ArrayList<>();
	List<List<String>> namedatas=new ArrayList<>();
	List<List<String>> countdatas=new ArrayList<>();
	if(cacheMap==null){
		//行业
		years=hnii_alarm_serviceService.statByYear();
		for (Object[] obj : years) {
			countAll=countAll.add((BigDecimal)obj[0]);
			yearnames.add("'"+obj[1]+"'");
			yearcount.add("{value:"+obj[0]+",name:'"+obj[1]+"'}");
		}
		industryList=industry_typeService.findAll();
		dataIndustry=hniidata_viewService.statAll("industry");
		for (Object[] obj : dataIndustry) {
		    industrynames.add("'"+obj[0]+"'");
		    industrycount.add("{value:"+obj[1]+",name:'"+obj[0]+"'}");
		}
		//大类
		roots=business_rootService.findListAll();
		dataDalei=hniidata_viewService.statAll("dalei");
		for (Object[] obj : dataDalei) {
			rootnames.add("'"+obj[0]+"'");
			rootcount.add("{value:"+obj[1]+",name:'"+obj[0]+"'}");
		}
		//小类
		dataXiaolei=hniidata_viewService.statAll("xiaolei");
		EntityDalei entityDalei=null;
		List<EntityXiaolei> entityXiaoleis=null;
		List<String> namedata=null;
		List<String> countdata=null;
		EntityXiaolei entityXiaolei=null;
		for (Object[] dobj : dataDalei) {
			entityDalei=new EntityDalei();
			entityDalei.setName(dobj[0].toString());
			entityXiaoleis=new ArrayList<EntityXiaolei>();
			namedata=new ArrayList<>();
			countdata=new ArrayList<>();
			for (Object[] xobj : dataXiaolei) {
				 entityXiaolei=new EntityXiaolei();
				if(dobj[0].toString().equals(xobj[2].toString())){
					entityXiaolei.setName(xobj[0].toString());
					entityXiaolei.setCount(xobj[1].toString());
					namedata.add("'"+xobj[0]+"'");
					countdata.add("{value:"+xobj[1]+",name:'"+xobj[0]+"'}");
					entityXiaoleis.add(entityXiaolei);
				}
				
			}
			namedatas.add(namedata);
			countdatas.add(countdata);
			entityDalei.setValues(entityXiaoleis);
			entityDalei.setNamedata(namedata);
			entityDalei.setCountdata(countdata);
			entityDaleis.add(entityDalei);
		}
		Cachemodel cachemodel=new Cachemodel();
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("industryList", industryList);
		map.put("roots", roots);
		map.put("industrynames", industrynames);
		map.put("industrycount", industrycount);
		map.put("rootnames", rootnames);
		map.put("rootcount", rootcount);
		map.put("dataIndustry", dataIndustry);
		map.put("dataDalei", dataDalei);
		map.put("dataXiaolei", dataXiaolei);
		map.put("countAll", countAll);
		map.put("years", years);
		map.put("yearnames", yearnames);
		map.put("yearcount", yearcount);
		map.put("entityDaleis", entityDaleis);
		map.put("namedatas", namedatas);
		map.put("countdatas", countdatas);
	    cachemodel.setCacheMap(map);
	    cachemodel.setCdate(new Date());
	    cachemodel.setVdate(24);
	    cacheUtil.addCache("stat",cachemodel);
	}else{
		industryList=(List<Industry_type>)cacheMap.get("industryList");
		roots=(List<Business_root>)cacheMap.get("roots");
		industrynames=(List<String>)cacheMap.get("industrynames");
		industrycount=(List<String>)cacheMap.get("industrycount");
		rootnames=(List<String>)cacheMap.get("rootnames");
		rootcount=(List<String>)cacheMap.get("rootcount");
		dataIndustry=(List<Object[]>)cacheMap.get("dataIndustry");
		dataDalei=(List<Object[]>)cacheMap.get("dataDalei");
		dataXiaolei=(List<Object[]>)cacheMap.get("dataXiaolei");
		years=(List<Object[]>)cacheMap.get("years");
		countAll=(BigDecimal)cacheMap.get("countAll");
		yearnames=(List<String>)cacheMap.get("yearnames");
		yearcount=(List<String>)cacheMap.get("yearcount");
		entityDaleis=(List<EntityDalei>)cacheMap.get("entityDaleis");
		namedatas=(List<List<String>>)cacheMap.get("namedatas");
		countdatas=(List<List<String>>)cacheMap.get("countdatas");
	}
	model.addAttribute("industryList", industryList);
	model.addAttribute("roots", roots);
	model.addAttribute("industrynames", industrynames);
	model.addAttribute("industrycount", industrycount);
	model.addAttribute("rootnames", rootnames);
	model.addAttribute("rootcount", rootcount);
	model.addAttribute("dataIndustry", dataIndustry);
	model.addAttribute("dataDalei", dataDalei);
	model.addAttribute("dataXiaolei", dataXiaolei);
	model.addAttribute("years", years);
	model.addAttribute("countAll", countAll);
	model.addAttribute("yearnames", yearnames);
	model.addAttribute("yearcount", yearcount);
	model.addAttribute("entityDaleis", entityDaleis);
	model.addAttribute("namedatas", namedatas);
	model.addAttribute("countdatas", countdatas);
	return "/96096statistics/classification";
}

/**
 * 96096工单数据按行业统计
 *
 */
//@RequestMapping(value = "/stat/industry",method = RequestMethod.GET)
//public String statIndustry(ModelMap model){
//	CacheUtil cacheUtil=CacheUtil.newInstance();
//	Map<String, Object> cacheMap=cacheUtil.getCache("industry");
//	List<InfoStat> infos=new ArrayList<InfoStat>();
//	List<Industry_type> industryList=null;
//	List<Object[]> years=null;
//	List<Object[]> results=null;
//	String countAll=null;
//	List<String> yearstr=new ArrayList<String>();
//	List<String> industrystr=new ArrayList<String>();
//	List<String> datas=new ArrayList<String>();
//	if(cacheMap==null){
//		years=hnii_alarm_serviceService.statByYear();
//		results=hniidata_viewService.stat("hangye");
//	    industryList=industry_typeService.findAll();
//	    List<String> yearcount=new ArrayList<>();
//		for (Object[] obj : years) {
//			yearcount.add(obj[0].toString());
//		}
//		datas.add("{name:'处理基数',type:'bar',data:"+yearcount+"}");
//		industrystr.add("'处理基数'");
//		 for (Industry_type indus : industryList) {
//		    	industrystr.add("'"+indus.getIndustry_name()+"'");
//		    	List<String> datastr=new ArrayList<>();
//		    	boolean has=false;
//		    	for (Object[] obj : years){
//		    		for (Object[] result : results) {
//						if(result[1].toString().equals(indus.getIndustry_name())&&obj[1].toString().equals(result[2].toString())){
//							datastr.add(result[0].toString());
//							has=true;
//						}
//				 }
//		    		if(has==false){
//		    			datastr.add("0");
//		    		}
//		    	
//			}
//		    	datas.add("{name:'"+indus.getIndustry_name()+"',type:'bar',data:"+datastr+"}");
//		 }
//		
//		for (Object[] obj : years) {
//			yearstr.add("'"+obj[1].toString()+"'");
//			InfoStat stat=new InfoStat();
//			countAll=obj[0].toString();
//			stat.setYears(obj[1].toString());
//			stat.setCountAll(countAll);
//			List<Info> value=new ArrayList<Info>();
//			for (Industry_type industry : industryList) {
//				industrystr.add("'"+industry.getIndustry_name()+"'");
//				Info info=new Info();
//				for (Object[] result : results) {
//					if(result[1].toString().equals(industry.getIndustry_name())&&obj[1].toString().equals(result[2].toString())){
//						info.setIndustry((String)result[1]);
//						info.setCount((BigDecimal)result[0]);
//						BigDecimal a=(BigDecimal)result[0];
//						BigDecimal b=new BigDecimal(countAll);
//						BigDecimal r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
//						info.setPercent(r);
//					}
//				}
//				value.add(info);
//				stat.setValues(value);
//			}
//			infos.add(stat);
//		}
//		
//		
//		Cachemodel cachemodel=new Cachemodel();
//	    Map<String, Object> map=new HashMap<String, Object>();
//	    map.put("yearstr", yearstr);
//		map.put("infos", infos);
//		map.put("industryList", industryList);
//		map.put("industrystr", industrystr);
//		map.put("datas", datas);
//	    cachemodel.setCacheMap(map);
//	    cachemodel.setCdate(new Date());
//	    cachemodel.setVdate(24);
//	    cacheUtil.addCache("industry",cachemodel);
//	}else{
//		infos=(List<InfoStat>)cacheMap.get("infos");
//		industryList=(List<Industry_type>)cacheMap.get("industryList");
//		yearstr=(List<String>)cacheMap.get("yearstr");
//		industrystr=(List<String>)cacheMap.get("industrystr");
//		datas=(List<String>)cacheMap.get("datas");
//	}
//	model.addAttribute("industryList", industryList);
//	model.addAttribute("infos", infos);
//	model.addAttribute("yearstr", yearstr);
//	model.addAttribute("industrystr", industrystr);
//	model.addAttribute("datas", datas);
//	return "/96096statistics/statindustry";
//}
/**
 * 96096工单数据按行业统计----datastatistics
 *
 */

@RequestMapping(value = "/stat/industry",method = RequestMethod.GET)
public  void statisticsIndustry() {
	industrystatisticsService.deleteAll();
	List<Object[]> years=null;
	List<Object[]> results=null;
	years=hnii_alarm_serviceService.statByYear();
	results=hniidata_viewService.stat("hangye");
	Industrystatistics industry_statistics = null;
	BigDecimal a=null;
	BigDecimal b=null;
	BigDecimal r=null;
		for (Object[] obj : years) {
			//[6234, 2013]
			for (Object[] result:results){
				//[9, 道路货物运输, 2013]
			if (obj[1] == null||result[2]==null){
				continue;
			}
			if(obj[1].toString().equals(result[2].toString())){
				 industry_statistics = new Industrystatistics();
				industry_statistics.setIndustry_name(result[1].toString());
				industry_statistics.setYear(result[2].toString());
				industry_statistics.setCardinal_number((BigDecimal)obj[0]);
				industry_statistics.setData_size((BigDecimal) result[0]);
				 a=(BigDecimal)result[0];
				 b=new BigDecimal( obj[0].toString());
				 r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
				industry_statistics.setMatching_ratio(r);
				industry_statistics.setStatistics_date(new Date());
				industry_statistics.setIndustry_id(KeyUtils.getKey());
				industrystatisticsService.save(industry_statistics);
				}
			}
		}
}


/**
 * 96096工单数据按大类统计
*/
//
//@RequestMapping(value = "/stat/dalei",method = RequestMethod.GET)
//public String statDalei(ModelMap model){
//	CacheUtil cacheUtil=CacheUtil.newInstance();
//	Map<String, Object> cacheMap=cacheUtil.getCache("dalei");
//	List<InfoStat> infos=new ArrayList<InfoStat>();
//	List<Business_root> roots=null;
//	List<Object[]> years=null;
//	List<String> yearstr=new ArrayList<String>();
//	List<String> rootstr=new ArrayList<String>();
//	List<Object[]> results=null;
//	String countAll=null;
//	List<String> datas=new ArrayList<String>();
//	if(cacheMap==null){
//		years=hnii_alarm_serviceService.statByYear();
//		results=hniidata_viewService.stat("dalei");
//		roots=business_rootService.findAll();
//		List<String> yearcount=new ArrayList<>();
//		for (Object[] obj : years) {
//			yearcount.add(obj[0].toString());
//		}
//		datas.add("{name:'处理基数',type:'bar',data:"+yearcount+"}");
//		rootstr.add("'处理基数'");
//		for (Business_root root : roots) {
//			rootstr.add("'"+root.getBusiness_name()+"'");
//	    	List<String> datastr=new ArrayList<>();
//	    	boolean has=false;
//	    	for (Object[] obj : years){
//	    		for (Object[] result : results) {
//					if(result[1].toString().equals(root.getBusiness_name())&&obj[1].toString().equals(result[2].toString())){
//						datastr.add(result[0].toString());
//						has=true;
//					}
//			 }
//	    		if(has==false){
//	    			datastr.add("0");
//	    		}
//	    	
//		}
//	    	datas.add("{name:'"+root.getBusiness_name()+"',type:'bar',data:"+datastr+"}");
//		}
//		for (Object[] obj : years) {
//			yearstr.add("'"+obj[1].toString()+"'");
//			InfoStat stat=new InfoStat();
//			countAll=obj[0].toString();
//			stat.setYears(obj[1].toString());
//			stat.setCountAll(countAll);
//			List<Info> value=new ArrayList<Info>();
//			for (Business_root root : roots) {
//				Info info=new Info();
//				for (Object[] objects : results) {
//					if(objects[1].toString().equals(root.getBusiness_name())&&obj[1].toString().equals(objects[2].toString())){
//						info.setIndustry((String)objects[1]);
//						info.setCount((BigDecimal)objects[0]);
//						BigDecimal a=(BigDecimal)objects[0];
//						BigDecimal b=new BigDecimal(countAll);
//						BigDecimal r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
//						info.setPercent(r);
//					}
//				}
//				value.add(info);
//				stat.setValues(value);
//			}
//			infos.add(stat);
//		}
//		
//		
//		Cachemodel cachemodel=new Cachemodel();
//	    Map<String, Object> map=new HashMap<String, Object>();
//		map.put("infos", infos);
//		map.put("roots", roots);
//		map.put("yearstr", yearstr);
//		map.put("rootstr", rootstr);
//		map.put("datas", datas);
//	    cachemodel.setCacheMap(map);
//	    cachemodel.setCdate(new Date());
//	    cachemodel.setVdate(24);
//	    cacheUtil.addCache("dalei",cachemodel);
//	}else{
//		infos=(List<InfoStat>)cacheMap.get("infos");
//		roots=(List<Business_root>)cacheMap.get("roots");
//		yearstr=(List<String>)cacheMap.get("yearstr");
//		rootstr=(List<String>)cacheMap.get("rootstr");
//		datas=(List<String>)cacheMap.get("datas");
//	}
//	model.addAttribute("roots", roots);
//	model.addAttribute("infos", infos);
//	model.addAttribute("yearstr", yearstr);
//	model.addAttribute("rootstr", rootstr);
//	model.addAttribute("datas", datas);
//	return "/96096statistics/statdalei";
//}

/**
 * 96096工单数据按大类统计----datastatistics
*/

@RequestMapping(value = "/stat/dalei",method = RequestMethod.GET)
public void statDalei()  {
	bigtypestatisticsService.deleteAll();
	List<Object[]> years=null;
	List<Object[]> results=null;
		years=hnii_alarm_serviceService.statByYear();
		results=hniidata_viewService.stat("dalei");
		Bigtypestatistics big_statistics = null;
 		BigDecimal a=null;
		BigDecimal b=null;
		BigDecimal r=null;
		for (Object[] obj : years) {
			//[6234, 2013]
			for (Object[] result:results){
				//[9, 道路货物运输, 2013]
			if (obj[1] == null||result[2]==null){
				continue;
			}
			if(obj[1].toString().equals(result[2].toString())){
				 big_statistics = new Bigtypestatistics();
				big_statistics.setBig_type_name(result[1].toString());
				big_statistics.setYear(result[2].toString());
				big_statistics.setCardinal_number((BigDecimal)obj[0]);
				big_statistics.setData_size((BigDecimal) result[0]);
				 a=(BigDecimal)result[0];
				 b=new BigDecimal( obj[0].toString());
				 r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
				big_statistics.setMatching_ratio(r);
				big_statistics.setStatistics_date(new Date());
				big_statistics.setBig_type_id(KeyUtils.getKey());
				bigtypestatisticsService.save(big_statistics);
				}
			}
		}
}


/**
 * 96096工单数据按小类统计
 */
//
//@RequestMapping(value = "/stat/xiaolei",method = RequestMethod.GET)
//public String statXiaolei(ModelMap model){
//	CacheUtil cacheUtil=CacheUtil.newInstance();
//	Map<String, Object> cacheMap=cacheUtil.getCache("xiaolei");
//	List<Business_root> roots=null;
//	List<Object[]> years=null;
//	List<Object[]> results=null;
//	String countAll=null;
//	if(cacheMap==null){
//		years=hnii_alarm_serviceService.statByYear();
//		results=hniidata_viewService.stat("xiaolei");
//		roots=business_rootService.findAll();
//		for (Business_root root : roots) {
//			List<Business_secondary> secondarys=business_secondaryService.findByRootid(root.getRoot_id());
//			root.setSecondarys(secondarys);
//			//*****************
//			List<InfoStat> infos=new ArrayList<InfoStat>();
//			for (Object[] obj : years) {
//				InfoStat stat=new InfoStat();
//				countAll=obj[0].toString();
//				stat.setYears(obj[1].toString());
//				stat.setCountAll(countAll);
//				List<Info> value=new ArrayList<Info>();
//				for (Business_secondary secondary : secondarys) {
//					Info info=new Info();
//					for (Object[] objects : results) {
//						if(objects[1].toString().equals(secondary.getBusiness_name())&&obj[1].toString().equals(objects[2].toString())){
//							info.setIndustry((String)objects[1]);
//							info.setCount((BigDecimal)objects[0]);
//							BigDecimal a=(BigDecimal)objects[0];
//							BigDecimal b=new BigDecimal(countAll);
//							BigDecimal r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
//							info.setPercent(r);
//						}
//					}
//					value.add(info);
//				}
//				stat.setValues(value);
//				infos.add(stat);
//			}
//			
//			//***************
//			root.setInfos(infos);
//		}
//		Cachemodel cachemodel=new Cachemodel();
//	    Map<String, Object> map=new HashMap<String, Object>();
//		map.put("roots", roots);
//	    cachemodel.setCacheMap(map);
//	    cachemodel.setCdate(new Date());
//	    cachemodel.setVdate(24);
//	    cacheUtil.addCache("xiaolei",cachemodel);
//	}else{
//		roots=(List<Business_root>)cacheMap.get("roots");
//	}
//	model.addAttribute("roots", roots);
//	return "/96096statistics/statxiaolei";
//}

/**
 * 96096工单数据按小类统计----datastatistics
*/
@RequestMapping(value = "/stat/xiaolei",method = RequestMethod.GET)
public void statXiaolei()  {
	smalltypestatisticsService.deleteAll();
	List<Object[]> years=null;
	List<Object[]> results=null;
	years=hnii_alarm_serviceService.statByYear();
	results=hniidata_viewService.stat("xiaolei");
	Smalltypestatistics small_statistics = null;
	BigDecimal a=null;
	BigDecimal b=null;
	BigDecimal r=null;
		for (Object[] obj : years) {
			//[6234, 2013]
			for (Object[] result:results){
				//[9, 道路货物运输, 2013,表扬类]
			if (obj[1] == null||result[2]==null){
				continue;
			}
			if(obj[1].toString().equals(result[2].toString())){
				 small_statistics = new Smalltypestatistics();
				small_statistics.setSmall_type_name(result[1].toString());
				small_statistics.setYear(result[2].toString());
				small_statistics.setCardinal_number((BigDecimal)obj[0]);
				small_statistics.setData_size((BigDecimal) result[0]);
				 a=(BigDecimal)result[0];
				 b=new BigDecimal( obj[0].toString());
				 r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
				small_statistics.setMatching_ratio(r);
				small_statistics.setStatistics_date(new Date());
				small_statistics.setSmall_type_id(KeyUtils.getKey());
				small_statistics.setBig_type_name(result[3].toString());
				smalltypestatisticsService.save(small_statistics);
				}
			}
		}
}
	
}

 


