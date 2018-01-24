package com.centit.hlwyw.sys.service.impl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.centit.hlwyw.cache.CacheUtil;
import com.centit.hlwyw.cache.Cachemodel;
import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.inner.entity.Business_root;
import com.centit.hlwyw.inner.entity.Business_secondary;
import com.centit.hlwyw.inner.entity.EntityDalei;
import com.centit.hlwyw.inner.entity.EntityXiaolei;
import com.centit.hlwyw.inner.entity.Industry_type;
import com.centit.hlwyw.inner.entity.Info;
import com.centit.hlwyw.inner.entity.InfoStat;
import com.centit.hlwyw.inner.repositories.CorpbadinfoRepository;
import com.centit.hlwyw.inner.repositories.Corpgood_badinfoRepository;
import com.centit.hlwyw.inner.repositories.CorpgoodinfoRepository;
import com.centit.hlwyw.inner.repositories.CorpinfoRepository;
import com.centit.hlwyw.inner.repositories.CorpmediaexposedRepository;
import com.centit.hlwyw.inner.repositories.DishonestManRepository;
import com.centit.hlwyw.inner.repositories.Hnii_analyze_dataRepository;
import com.centit.hlwyw.inner.repositories.JudgeDocRepository;
import com.centit.hlwyw.inner.repositories.PersoninfoRepository;
import com.centit.hlwyw.inner.repositories.Public_priseRepository;
import com.centit.hlwyw.inner.repositories.Service_complaintRepository;
import com.centit.hlwyw.inner.repositories.ZhaobiaoggRepository;
import com.centit.hlwyw.inner.repositories.ZhongbiaoggRepository;
import com.centit.hlwyw.inner.service.Business_rootService;
import com.centit.hlwyw.inner.service.Business_secondaryService;
import com.centit.hlwyw.inner.service.Corpgood_badinfoService;
import com.centit.hlwyw.inner.service.CorpmediaexposedService;
import com.centit.hlwyw.inner.service.DishonestManService;
import com.centit.hlwyw.inner.service.HniiBehaviorService;
import com.centit.hlwyw.inner.service.Hnii_alarm_serviceService;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;
import com.centit.hlwyw.inner.service.Hniidata_viewService;
import com.centit.hlwyw.inner.service.Industry_typeService;
import com.centit.hlwyw.inner.service.JudgeDocService;
import com.centit.hlwyw.inner.service.JwdataService;
import com.centit.hlwyw.inner.service.Public_priseService;
import com.centit.hlwyw.inner.service.Service_complaintService;
import com.centit.hlwyw.inner.service.ZhaobiaoggService;
import com.centit.hlwyw.inner.service.ZhongbiaoggService;
import com.centit.hlwyw.sys.service.IndexService;


@Service("indexServiceImpl")
public class IndexServiceImpl implements IndexService {
	private static Logger log = Logger.getLogger(IndexServiceImpl.class);  
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "jwdataServiceImpl")
	private JwdataService jwdataService;
	
	@Resource(name = "corpgood_badinfoServiceImpl")
	private Corpgood_badinfoService corpgood_badinfoService;
	
	@Resource(name = "corpmediaexposedServiceImpl")
	private CorpmediaexposedService corpmediaexposedService;
	
	@Resource(name = "judgeDocServiceImpl")
	private JudgeDocService judgeDocService;
	
	@Resource(name = "dishonestManServiceImpl")
	private DishonestManService dishonestManService;
	
	@Resource(name = "zhaobiaoggServiceImpl")
	private ZhaobiaoggService zhaobiaoggService;
	
	@Resource(name = "zhongbiaoggServiceImpl")
	private ZhongbiaoggService zhongbiaoggService;
	
	@Resource(name = "corpgood_badinfoRepository")
	private Corpgood_badinfoRepository corpgood_badinfoRepository;
	
	@Resource(name = "corpmediaexposedRepository")
	private CorpmediaexposedRepository corpmediaexposedRepository;
	
	@Resource(name = "judgeDocRepository")
	private JudgeDocRepository judgeDocRepository;
	
	@Resource(name = "dishonestManRepository")
	private DishonestManRepository dishonestManRepository;
	
	@Resource(name = "zhaobiaoggRepository")
	private ZhaobiaoggRepository zhaobiaoggRepository;
	
	@Resource(name = "zhongbiaoggRepository")
	private ZhongbiaoggRepository zhongbiaoggRepository;
	
//	@Resource(name = "corpbadinfoServiceImpl")
//	private CorpbadinfoService corpbadinfoService;
	
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
	
	
	@Resource(name = "public_priseServiceImpl")
	private Public_priseService public_priseService;
	
	@Resource(name = "service_complaintServiceImpl")
	private Service_complaintService service_complaintService;
		
	@Resource(name = "hnii_analyze_dataServiceImpl")
	private Hnii_analyze_dataService hnii_analyze_dataService;
	
	@Resource(name = "hniiBehaviorServiceImpl")
	private HniiBehaviorService hniibehaviorService;
	
	
	@Resource(name = "corpinfoRepository")
	private CorpinfoRepository corpinfoRepository;
	@Resource(name = "personinfoRepository")
	private PersoninfoRepository personinfoRepository;
	@Resource(name = "corpgoodinfoRepository")
	private CorpgoodinfoRepository corpgoodinfoRepository;
	@Resource(name = "corpbadinfoRepository")
	private CorpbadinfoRepository corpbadinfoRepository; 
	@Resource(name = "service_complaintRepository")
	private Service_complaintRepository service_complaintRepository; 
	@Resource(name = "public_priseRepository")
	private Public_priseRepository public_priseRepository; 
	@Resource(name = "hnii_analyze_dataRepository")
	private Hnii_analyze_dataRepository hnii_analyze_dataRepository;
	
//	@Override
//	public Map<String, Object[]> initData() {
//		Date cdate = new Date();
////		Calendar cal = new Calendar();
////		cal.setTime(cdate);
//		
//		String sql = "";
//		List<Object> values = new ArrayList<Object>();
//		List<Object[]> rst = queryService.query(sql, values);
//		return null;
//	}

	@Override
	public Object[] getEchartDate() {
		Object[] echartdate=new Object[8];
 		Date dateNow = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(dateNow);
		cl.add(Calendar.MONTH, -1);
		Date dateFrom = cl.getTime();
		
		SimpleDateFormat  sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		String dateFromstr=sdf2.format(dateFrom);
		String dateNowstr=sdf2.format(dateNow);
 		String titlesubtext=dateFromstr+"~"+dateNowstr;
 		echartdate[0]=titlesubtext;
 		List<Date> datelist=new ArrayList<Date>();
 		datelist=getDatelist(sdf2,datelist, dateFrom, dateNow);
 		List<String> dateliststr=new ArrayList<String>();
 		for(Date date:datelist){
 			dateliststr.add(sdf2.format(date));
 		}
 		String xAxisdata="[";
 		for(String date:dateliststr){
 			xAxisdata=xAxisdata+"'"+date+"',";
 		}
 		xAxisdata=xAxisdata.substring(0,xAxisdata.length()-1)+"]";
  		echartdate[1]=xAxisdata;
 		echartdate[2]=corpgood_badinfoService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
   		echartdate[3]=corpmediaexposedService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
   		echartdate[4]=dishonestManService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
   		echartdate[5]=judgeDocService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
   		echartdate[6]=zhaobiaoggService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
   		echartdate[7]=zhongbiaoggService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
		return echartdate;
	}
	
	private List<Date> getDatelist(SimpleDateFormat  sdf,List<Date> datelist,Date datestart,Date dateend){
		if(datestart.before(dateend)){
			datelist.add(datestart);
			Calendar cl = Calendar.getInstance();
			cl.setTime(datestart);
			cl.add(Calendar.DAY_OF_YEAR, 1);
			datestart=cl.getTime();
			datelist=getDatelist(sdf,datelist,datestart,dateend);
		}else{
			datelist.add(dateend);
		}
		return datelist;
		
	}

	@Override
	public void initStat(ModelMap model) {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		Map<String, Object> cacheMap=cacheUtil.getCache("info");
		initInfo(cacheUtil, cacheMap, model);
	}
	
	private void initInfo(CacheUtil cacheUtil,Map<String, Object> cacheMap,ModelMap model){
		//总计
		Long countcorp=0L;//从业企业数量
		Long countperson=0L;//从业人员数量
		Long counthlwcollect=0L;//互联网采集数量
		Long count96096=0L;//96096工单处理数量
		//司法判决信息统计
		Object[] datajudge  =null;
		//从业企业信用数据采集统计
		Object[] datacredit  =new Object[2];
		//96096工单行业分布统计
		Object[] data96096industrydesc  =null;
		//96096工单业务分布统计
		Object[] data96096btypedesc =null;
//		统计公众服务评价信息和服务质量投诉信息
		Long credit =0L;
		if(cacheMap==null){
			//总计
			countcorp=corpinfoRepository.countCaixin();//从业企业数量
			countperson=personinfoRepository.countCaixin();//从业人员数量
			//司法判决信息统计
			datajudge=judgeDocService.statByType();
			//从业企业信用数据采集统计
			Long countcreditbiaozhang=corpgoodinfoRepository.countByTypeCaixin(Constantval.CORPGOODINFO_TYPE_BIAOZHANG);//表彰
			Long countcredithuojiang=corpgoodinfoRepository.countByTypeCaixin(Constantval.CORPGOODINFO_TYPE_HUOJIANG);//获奖
			Long countcredittongbao=corpbadinfoRepository.countCaixin();//通报批评
			Long countcreditsifapanjue=(Long) datajudge[2];//司法判决
			Long countcreditshixin=dishonestManRepository.countCaixin();//失信被执行人
			Long countcreditzhaobiao=zhaobiaoggRepository.countCaixin();//招标信息
			Long countcreditzhongbiao=zhongbiaoggRepository.countCaixin();//中标信息
			Long countcreditfuwu=service_complaintRepository.countCaixin();//服务质量投诉信息
			Long countcreditbiaoyang=public_priseRepository.countCaixin();//公众表扬信息
			 credit = countcreditfuwu + countcreditbiaoyang;
			String creditdesc="['表彰','获奖','通报批评','司法判决','失信被执行人','招标信息','中标信息','服务质量投诉信息','公众表扬信息']";
			String creditcount="["+countcreditbiaozhang+","+countcredithuojiang+","+countcredittongbao
					+","+countcreditsifapanjue+","+countcreditshixin+","+countcreditzhaobiao+","+countcreditzhongbiao+","+countcreditfuwu
					+","+countcreditbiaoyang+"]";
			datacredit[0]=creditdesc;
			datacredit[1]=creditcount;
			//96096工单行业分布统计
			data96096industrydesc=hnii_analyze_dataService.countHniiindustry();
			//96096工单业务分布统计
			data96096btypedesc=hnii_analyze_dataService.countHniibtype();
			counthlwcollect=countcreditbiaozhang+countcredithuojiang+countcredittongbao+countcreditsifapanjue+countcreditshixin+countcreditzhaobiao+countcreditzhongbiao;//互联网采集数量
			count96096=(Long) data96096industrydesc[2];//96096工单处理数量
			Cachemodel cachemodel=new Cachemodel();
		    Map<String, Object> map=new HashMap<String, Object>();
		    map.put("countcorp", countcorp);
		    map.put("countperson", countperson);
		    map.put("counthlwcollect", counthlwcollect);
		    map.put("count96096", count96096);
		    map.put("datajudge", datajudge);
		    map.put("datacredit", datacredit);
		    map.put("data96096btypedesc", data96096btypedesc);
		    map.put("data96096industrydesc", data96096industrydesc);
		    map.put("credit", credit);
		    cachemodel.setCacheMap(map);
		    cachemodel.setCdate(new Date());
		    cachemodel.setVdate(24);
		    cacheUtil.addCache("info",cachemodel);
		}else{
			countcorp= (Long) cacheMap.get("countcorp");
			countperson=(Long) cacheMap.get("countperson");
			counthlwcollect=(Long) cacheMap.get("counthlwcollect");
			count96096=(Long) cacheMap.get("count96096");
			datajudge=(Object[]) cacheMap.get("datajudge");
			datacredit=(Object[]) cacheMap.get("datacredit");
			data96096industrydesc=(Object[]) cacheMap.get("data96096industrydesc");
			data96096btypedesc=(Object[]) cacheMap.get("data96096btypedesc");
			credit = (Long) cacheMap.get("credit");
		}
		//创建json字符串
 		model.addAttribute("countcorp",countcorp);
 		model.addAttribute("countperson",countperson);
 		model.addAttribute("counthlwcollect",counthlwcollect);
 		model.addAttribute("count96096",count96096);
 		model.addAttribute("datajudge",datajudge);
  		model.addAttribute("datacredit", datacredit);
 		model.addAttribute("data96096industrydesc",data96096industrydesc);
  		model.addAttribute("data96096btypedesc", data96096btypedesc);
  		model.addAttribute("credit", credit);
	}
	
	@Override
	public void statinitInfo() {
		CacheUtil cacheUtil=CacheUtil.newInstance();
		//首页缓存
		initInfo(cacheUtil);
		//analyze缓存
		initAnalyzeInfo(cacheUtil);
		//数据汇总
		initInfoStat(cacheUtil);
		//按行业统计
		statIndustry(cacheUtil);
		//按大类统计
		statDalei(cacheUtil);
		//按小类统计
		statXiaolei(cacheUtil);
		statJudgedoc(cacheUtil);
		statDishonestMan(cacheUtil);
		statGoodbad(cacheUtil);
		statMediaexposed(cacheUtil);
		statPublicprise(cacheUtil);
		statServicecomplaint(cacheUtil);
		//导出96096工单数据年份
		initExportYears(cacheUtil);
	}
	
	private void initAnalyzeInfo(CacheUtil cacheUtil) {
		cacheUtil.clearModel("analyze");
		//服务质量投诉 和公众表扬信息
		Long public_priseCount = 0L;
		Long service_complaintCount = 0L;
		//司法判决
		Long judgeCount = 0L;
		//失信被执行人
		Long dishonestCount = 0L;
		judgeCount=judgeDocRepository.countJudgedoc();
		dishonestCount=dishonestManRepository.countCaixin();
		public_priseCount = public_priseRepository.countCaixin();
		service_complaintCount = service_complaintRepository.countCaixin();
		Cachemodel cachemodel=new Cachemodel();
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("judgeCount", judgeCount);
	    map.put("dishonestCount", dishonestCount);
	    map.put("public_priseCount", public_priseCount);
	    map.put("service_complaintCount", service_complaintCount);
	    cachemodel.setCacheMap(map);
	    cachemodel.setCdate(new Date());
	    cachemodel.setVdate(24);
	    cacheUtil.addCache("analyze",cachemodel);
	}

	private void initExportYears(CacheUtil cacheUtil){
		cacheUtil.clearModel("exportYears");
		List<Object[]> years=hnii_analyze_dataService.findYears();
		Cachemodel cachemodel=new Cachemodel();
	    Map<String, Object> map=new HashMap<String, Object>();
		map.put("years", years);
	    cachemodel.setCacheMap(map);
	    cachemodel.setCdate(new Date());
	    cachemodel.setVdate(24);
	    cacheUtil.addCache("exportYears",cachemodel);
	}
	private void initInfo(CacheUtil cacheUtil){
		cacheUtil.clearModel("info");
		//总计
		Long countcorp=0L;//从业企业数量
		Long countperson=0L;//从业人员数量
		Long counthlwcollect=0L;//互联网采集数量
		Long count96096=0L;//96096工单处理数量
		//司法判决信息统计
		Object[] datajudge  =null;
		//从业企业信用数据采集统计
		Object[] datacredit  =new Object[2];
		//96096工单行业分布统计
		Object[] data96096industrydesc  =null;
		//96096工单业务分布统计
		Object[] data96096btypedesc =null;
		//总计
		countcorp=corpinfoRepository.countCaixin();//从业企业数量
		countperson=personinfoRepository.countCaixin();//从业人员数量
		//司法判决信息统计
		datajudge=judgeDocService.statByType();
		//从业企业信用数据采集统计
		Long countcreditbiaozhang=corpgoodinfoRepository.countByTypeCaixin(Constantval.CORPGOODINFO_TYPE_BIAOZHANG);//表彰
		Long countcredithuojiang=corpgoodinfoRepository.countByTypeCaixin(Constantval.CORPGOODINFO_TYPE_HUOJIANG);//获奖
		Long countcredittongbao=corpbadinfoRepository.countCaixin();//通报批评
		Long countcreditsifapanjue=(Long) datajudge[2];//司法判决
		Long countcreditshixin=dishonestManRepository.countCaixin();//失信被执行人
		Long countcreditzhaobiao=zhaobiaoggRepository.countCaixin();//招标信息
		Long countcreditzhongbiao=zhongbiaoggRepository.countCaixin();//中标信息
		Long countcreditfuwu=service_complaintRepository.countCaixin();//服务质量投诉信息
		Long countcreditbiaoyang=public_priseRepository.countCaixin();//公众表扬信息
		Long credit = countcreditfuwu + countcreditbiaoyang;
		String creditdesc="['表彰','获奖','通报批评','司法判决','失信被执行人','招标信息','中标信息','服务质量投诉信息','公众表扬信息']";
		String creditcount="["+countcreditbiaozhang+","+countcredithuojiang+","+countcredittongbao
				+","+countcreditsifapanjue+","+countcreditshixin+","+countcreditzhaobiao+","+countcreditzhongbiao+","+countcreditfuwu
				+","+countcreditbiaoyang+"]";
		datacredit[0]=creditdesc;
		datacredit[1]=creditcount;
		//96096工单行业分布统计
		data96096industrydesc=hnii_analyze_dataService.countHniiindustry();
		//96096工单业务分布统计
		data96096btypedesc=hnii_analyze_dataService.countHniibtype();
		counthlwcollect=countcreditbiaozhang+countcredithuojiang+countcredittongbao+countcreditsifapanjue+countcreditshixin+countcreditzhaobiao+countcreditzhongbiao;//互联网采集数量
		count96096=(Long) data96096industrydesc[2];//96096工单处理数量
		Cachemodel cachemodel=new Cachemodel();
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("countcorp", countcorp);
	    map.put("countperson", countperson);
	    map.put("counthlwcollect", counthlwcollect);
	    map.put("count96096", count96096);
	    map.put("datajudge", datajudge);
	    map.put("datacredit", datacredit);
	    map.put("data96096btypedesc", data96096btypedesc);
	    map.put("data96096industrydesc", data96096industrydesc);
	    map.put("credit", credit);
	    cachemodel.setCacheMap(map);
	    cachemodel.setCdate(new Date());
	    cachemodel.setVdate(24);
	    cacheUtil.addCache("info",cachemodel);
//		Map<String, Object> cacheMap=cacheUtil.getCache("info");
//		initInfo(cacheUtil, cacheMap, model);
// 		Date dateNow = new Date();
//		Calendar cl = Calendar.getInstance();
//		cl.setTime(dateNow);
//		cl.add(Calendar.MONTH, -1);
//		Date dateFrom = cl.getTime();
//		SimpleDateFormat  sdf2 = new SimpleDateFormat("yyyy/MM/dd");
//		String dateFromstr=sdf2.format(dateFrom);
//		String dateNowstr=sdf2.format(dateNow);
// 		String titlesubtext=dateFromstr+"~"+dateNowstr;
// 		Object etitle=titlesubtext;
// 		List<Date> datelist=new ArrayList<Date>();
// 		datelist=getDatelist(sdf2,datelist, dateFrom, dateNow);
// 		List<String> dateliststr=new ArrayList<String>();
// 		for(Date date:datelist){
// 			dateliststr.add(sdf2.format(date));
// 		}
// 		String xAxisdata="[";
// 		for(String date:dateliststr){
// 			xAxisdata=xAxisdata+"'"+date+"',";
// 		}
// 		xAxisdata=xAxisdata.substring(0,xAxisdata.length()-1)+"]";
// 		Object ex =xAxisdata;
// 		Object egood_bad=corpgood_badinfoService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
// 		Object emediaexposed=corpmediaexposedService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
// 		Object edishonestMan=dishonestManService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
// 		Object ejudgeDoc=judgeDocService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
// 		Object ezhaobiaogg=zhaobiaoggService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
// 		Object ezhongbiaogg=zhongbiaoggService.findOneMonth(dateliststr,dateFromstr,dateNowstr);
//		Object good_badCount=corpgood_badinfoRepository.count();
//		Object mediaCount=corpmediaexposedRepository.count();
//		Object judgeCount=judgeDocRepository.count();
//		Object dishonestCount=dishonestManRepository.count();
//		Object zhaobiaoCount=zhaobiaoggRepository.count();
//		Object zhongbiaoCount=zhongbiaoggRepository.count();
//		Cachemodel cachemodel=new Cachemodel();
//	    Map<String, Object> map=new HashMap<String, Object>();
//	    map.put("etitle", etitle);
//	    map.put("ex", ex);
//	    map.put("egood_bad", egood_bad);
//	    map.put("emediaexposed", emediaexposed);
//	    map.put("edishonestMan", edishonestMan);
//	    map.put("ejudgeDoc", ejudgeDoc);
//	    map.put("ezhaobiaogg", ezhaobiaogg);
//	    map.put("ezhongbiaogg", ezhongbiaogg);
//	    map.put("good_badCount", good_badCount);
//	    map.put("mediaCount", mediaCount);
//	    map.put("judgeCount", judgeCount);
//	    map.put("dishonestCount", dishonestCount);
//	    map.put("zhaobiaoCount", zhaobiaoCount);
//	    map.put("zhongbiaoCount", zhongbiaoCount);
//	    cachemodel.setCacheMap(map);
//	    cachemodel.setCdate(new Date());
//	    cachemodel.setVdate(24);
//	    cacheUtil.addCache("info",cachemodel);
	}

	@Override
	public void readData(String shichang,String hangye,String dalei) {
		//训练市场
		if(shichang==null && hangye==null && dalei==null){
			trainShichang();
		}else if(shichang!=null && hangye==null && dalei==null){//训练行业
			trainHangye(shichang);
		}else if(shichang!=null && hangye!=null && dalei==null){//训练大类
			trainDalei(shichang, hangye);
		}else if(shichang!=null && hangye!=null && dalei!=null){//训练小类
			trainXiaolei(shichang, hangye, dalei);
		}
	}
	
	//训练所有
	private void trainShichang(){
		List<Object> params=new ArrayList<Object>();
		String sql="select shichang,content from hnii_alarm_service_log2015 where shichang is not null order by createtime";
		String filename="D:/train/shicahng.txt";
		List<Object[]> rst = queryService.query(sql,params);
 		String shichang=null;
 		String content=null;
 		PrintWriter pw = null;
 		File file = new File(filename);
 		 if(!file.exists()){
             try {
            	 file.createNewFile();
             } catch (IOException e) {
                 log.error(e.getMessage());log.info(e);
             } 
         }
 		 try {
			pw = new PrintWriter(file);
			for (Object[] object : rst) {
				shichang = (String) object[0];
				content= (String) object[1];
	            pw.print(shichang + ";");
	            pw.print(content);
	            pw.println();
	            pw.flush();
			}
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());log.info(e);
		}finally{
			if(pw!=null){
				pw.close();
			}
		}

	}
	
	//训练市场
	private void trainHangye(String shichang){
		List<Object> params=new ArrayList<Object>();
		String sql="select hangye,content from hnii_alarm_service_log2015 where shichang = ? order by createtime";
		String filename="D:/train/"+shichang+".txt";
		if("daoluyunshu".equals(shichang)){
			params.add("道路运输市场");
		}else if("shuiluyunshu".equals(shichang)){
			params.add("水路运输市场");
		}else if("gonglujianshe".equals(shichang)){
			params.add("公路建设市场");
		}else if("shuiyunjianshe".equals(shichang)){
			params.add("水运建设市场");
		}
		List<Object[]> rst = queryService.query(sql,params);
		String hangye=null;
 		String content=null;
 		PrintWriter pw = null;
 		File file = new File(filename);
 		 if(!file.exists()){
             try {
            	 file.createNewFile();
             } catch (IOException e) {
                 log.error(e.getMessage());log.info(e);
             } 
         }
 		 try {
			pw = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());log.info(e);
		}
 		
		for (Object[] object : rst) {
			hangye = (String) object[0];
			content= (String) object[1];
            pw.print(hangye + ";");
            pw.print(content);
            pw.println();
            pw.flush();
		}
	}
	
	//训练行业
	private void trainDalei(String shichang,String hangye){
		List<Object> params=new ArrayList<Object>();
		String sql="select dalei,content from hnii_alarm_service_log2015 where  hangye = ? order by createtime";
		String filename="D:/train/"+shichang+"_"+hangye+".txt";
		if("chuzuche".equals(hangye)){//出租车行业
			params.add("出租车行业");
		}else if("wangyueche".equals(hangye)){//网约车行业
			params.add("网约车行业");
		}else if("jiapei".equals(hangye)){//驾培行业
			params.add("驾培行业");
		}else if("daolulvke".equals(hangye)){//道路旅客行业
			params.add("道路旅客行业");
		}else if("daoluhuoyun".equals(hangye)){//道路运输行业
			params.add("道路货运行业");
		}else if("gongjiaoche".equals(hangye)){//公交车行业
			params.add("公交车行业");
		}else if("guidaojiaotong".equals(hangye)){//轨道交通行业
			params.add("轨道交通行业");
		}else if("qichezuling".equals(hangye)){//汽车租赁行业
			params.add("汽车租赁行业");
		}else if("shuiyunlvkeyunshu".equals(hangye)){//水运旅客运输行业
			params.add("水运旅客运输");
		}else if("gonglujianshe".equals(hangye)){//公路建设行业
			params.add("公路建设行业");
		}else if("shuiyunzuoye".equals(hangye)){//水运作业
			params.add("水运作业");
		}
		List<Object[]> rst = queryService.query(sql,params);
		String dalei=null;
 		String content=null;
 		PrintWriter pw = null;
 		File file = new File(filename);
 		 if(!file.exists()){
             try {
            	 file.createNewFile();
             } catch (IOException e) {
                 log.error(e.getMessage());log.info(e);
             } 
         }
 		 try {
			pw = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());log.info(e);
		}
 		
		for (Object[] object : rst) {
			dalei = (String) object[0];
			content= (String) object[1];
            pw.print(dalei + ";");
            pw.print(content);
            pw.println();
            pw.flush();
		}
	}
	
	//训练大类
		private void trainXiaolei(String shichang,String hangye,String dalei){
			List<Object> params=new ArrayList<Object>();
			String sql="select xiaolei,content from hnii_alarm_service_log2015 where  hangye =? and dalei =? and xiaolei not in"
						+ "('驾驶员不一致','疲劳驾驶','欺诈','场地不合格','驾校地点','考场地点','选客（归为拒载）','漏客','卫生差','站场乱收费','站场设备设施差','站场秩序差','站场安检问题','货物丢失晚到问题',"
						+ "'线路调整未提示','站点命名','免费票','月票','路线（和线路重）','乘车环境差（太宽泛，难以定位）','设备设施不运行（和反映的电梯闸机重）','安检（和投诉类安检重）','租赁手续办理','汽车租赁政策','航线事宜','路产路权维护','非法营业','非法采沙') order by createtime" ;
			String filename="D:/train/"+shichang+"_"+hangye+"_"+dalei+".txt";
			if("chuzuche".equals(hangye)){//出租车行业
				params.add("出租车行业");
			}else if("wangyueche".equals(hangye)){//网约车行业
				params.add("网约车行业");
			}else if("jiapei".equals(hangye)){//驾培行业
				params.add("驾培行业");
			}else if("daolulvke".equals(hangye)){//道路旅客行业
				params.add("道路旅客行业");
			}else if("daoluhuoyun".equals(hangye)){//道路运输行业
				params.add("道路货运行业");
			}else if("gongjiaoche".equals(hangye)){//公交车行业
				params.add("公交车行业");
			}else if("guidaojiaotong".equals(hangye)){//轨道交通行业
				params.add("轨道交通行业");
			}else if("qichezuling".equals(hangye)){//汽车租赁行业
				params.add("汽车租赁行业");
			}else if("shuiyunlvkeyunshu".equals(hangye)){//水运旅客运输行业
				params.add("水运旅客运输");
			}else if("gonglujianshe".equals(hangye)){//公路建设行业
				params.add("公路建设行业");
			}else if("shuiyunzuoye".equals(hangye)){//水运作业
				params.add("水运作业");
			}
			if("tousu".equals(dalei)){//投诉
				params.add("投诉类");
			}else if("zixun".equals(dalei)){
				params.add("咨询类");
			}else if("fanyingqingkuang".equals(dalei)){
				params.add("反映情况类");
			}else if("qiuzhu".equals(dalei)){
				params.add("求助类");
			}else if("biaoyang".equals(dalei)){
				params.add("表扬类");
			}else if("jianyi".equals(dalei)){
				params.add("建议类");
			}
			List<Object[]> rst = queryService.query(sql,params);
			String xiaolei=null;
	 		String content=null;
	 		PrintWriter pw = null;
	 		File file = new File(filename);
	 		 if(!file.exists()){
	             try {
	            	 file.createNewFile();
	             } catch (IOException e) {
	                 log.error(e.getMessage());log.info(e);
	             } 
	         }
	 		 try {
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				log.error(e.getMessage());log.info(e);
			}
	 		
			for (Object[] object : rst) {
				xiaolei = (String) object[0];
				content= (String) object[1];
	            pw.print(xiaolei + ";");
	            pw.print(content);
	            pw.println();
	            pw.flush();
			}
		}
		//96096工单数据汇总
		private void initInfoStat(CacheUtil cacheUtil){
			cacheUtil.clearModel("stat");
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

		}
		
		/**
		 * 96096工单数据按行业统计
		 */
		private void statIndustry(CacheUtil cacheUtil){
				//96096工单数据按行业统计
				cacheUtil.clearModel("industry");
				List<InfoStat> infos=new ArrayList<InfoStat>();
				List<Industry_type> industryList=null;
				List<Object[]> years=null;
				List<Object[]> results=null;
				String countAll=null;
				List<String> yearcount=null;
				List<String> datastr=null;
				InfoStat stat=null;
				List<Info> value=null;
				Info info=null;
				BigDecimal a=null;
				BigDecimal b=null;
				BigDecimal r=null;
				List<String> yearstr=new ArrayList<String>();
				List<String> industrystr=new ArrayList<String>();
				List<String> datas=new ArrayList<String>();
					years=hniidata_viewService.statByYear();
					results=hniidata_viewService.stat("hangye");
				    industryList=industry_typeService.findAll();
				    yearcount=new ArrayList<>();
					for (Object[] obj : years) {
						yearcount.add(obj[1].toString());
					}
					datas.add("{name:'处理基数',type:'bar',data:"+yearcount+"}");
					industrystr.add("'处理基数'");
					 for (Industry_type indus : industryList) {
					    	industrystr.add("'"+indus.getIndustry_name()+"'");
					    	datastr=new ArrayList<>();
					    	boolean has=false;
					    	for (Object[] obj : years){
					    		for (Object[] result : results) {
									if(result[1].toString().equals(indus.getIndustry_name())&&obj[0].toString().equals(result[2].toString())){
										datastr.add(result[0].toString());
										has=true;
									}
							 }
					    		if(has==false){
					    			datastr.add("0");
					    		}
					    	
						}
					    	datas.add("{name:'"+indus.getIndustry_name()+"',type:'bar',data:"+datastr+"}");
					 }
					
					for (Object[] obj : years) {
						yearstr.add("'"+obj[0].toString()+"'");
						stat=new InfoStat();
						countAll=obj[1].toString();
						stat.setYears(obj[0].toString());
						stat.setCountAll(countAll);
						value=new ArrayList<Info>();
						for (Industry_type industry : industryList) {
							industrystr.add("'"+industry.getIndustry_name()+"'");
							info=new Info();
							for (Object[] result : results) {
								if(result[1].toString().equals(industry.getIndustry_name())&&obj[0].toString().equals(result[2].toString())){
									info.setIndustry((String)result[1]);
									info.setCount((BigDecimal)result[0]);
									a=(BigDecimal)result[0];
									b=new BigDecimal(countAll);
									r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
									info.setPercent(r);
								}
							}
							value.add(info);
							stat.setValues(value);
						}
						infos.add(stat);
					}
					Cachemodel cachemodel=new Cachemodel();
				    Map<String, Object> map=new HashMap<String, Object>();
				    map.put("yearstr", yearstr);
					map.put("infos", infos);
					map.put("industryList", industryList);
					map.put("industrystr", industrystr);
					map.put("datas", datas);
				    cachemodel.setCacheMap(map);
				    cachemodel.setCdate(new Date());
				    cachemodel.setVdate(24);
				    cacheUtil.addCache("industry",cachemodel);
		}
		
		/**
		 * 96096工单数据按大类统计
		 */
		private void statDalei(CacheUtil cacheUtil){
				cacheUtil.clearModel("dalei");
				List<InfoStat> infos=new ArrayList<InfoStat>();
				List<Business_root> roots=null;
				List<Object[]> years=null;
				List<String> yearstr=new ArrayList<String>();
				List<String> rootstr=new ArrayList<String>();
				List<Object[]> results=null;
				String countAll=null;
				List<String> datas=new ArrayList<String>();
					years=hniidata_viewService.statByYear();
					results=hniidata_viewService.stat("dalei");
					roots=business_rootService.findAll();
					List<String> yearcount=new ArrayList<>();
					for (Object[] obj : years) {
						yearcount.add(obj[1].toString());
					}
					datas.add("{name:'处理基数',type:'bar',data:"+yearcount+"}");
					rootstr.add("'处理基数'");
					List<String> datastr=null;
					for (Business_root root : roots) {
						rootstr.add("'"+root.getBusiness_name()+"'");
				    	datastr=new ArrayList<>();
				    	boolean has=false;
				    	for (Object[] obj : years){
				    		for (Object[] result : results) {
								if(result[1].toString().equals(root.getBusiness_name())&&obj[0].toString().equals(result[2].toString())){
									datastr.add(result[0].toString());
									has=true;
								}
						 }
				    		if(has==false){
				    			datastr.add("0");
				    		}
				    	
					}
				    	datas.add("{name:'"+root.getBusiness_name()+"',type:'bar',data:"+datastr+"}");
					}
					InfoStat stat=null;
					List<Info> value=null;
					Info info=null;
					BigDecimal a=null;
					BigDecimal b=null;
					BigDecimal r=null;
					for (Object[] obj : years) {
						yearstr.add("'"+obj[0].toString()+"'");
						 stat=new InfoStat();
						countAll=obj[1].toString();
						stat.setYears(obj[0].toString());
						stat.setCountAll(countAll);
						value=new ArrayList<Info>();
						for (Business_root root : roots) {
							 info=new Info();
							for (Object[] objects : results) {
								if(objects[1].toString().equals(root.getBusiness_name())&&obj[0].toString().equals(objects[2].toString())){
									info.setIndustry((String)objects[1]);
									info.setCount((BigDecimal)objects[0]);
									a=(BigDecimal)objects[0];
									b=new BigDecimal(countAll);
									r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
									info.setPercent(r);
								}
							}
							value.add(info);
							stat.setValues(value);
						}
						infos.add(stat);
					}
					
					
					Cachemodel cachemodel=new Cachemodel();
				    Map<String, Object> map=new HashMap<String, Object>();
					map.put("infos", infos);
					map.put("roots", roots);
					map.put("yearstr", yearstr);
					map.put("rootstr", rootstr);
					map.put("datas", datas);
				    cachemodel.setCacheMap(map);
				    cachemodel.setCdate(new Date());
				    cachemodel.setVdate(24);
				    cacheUtil.addCache("dalei",cachemodel);
		}
		
		/**
		 * 96096工单数据按小类统计
		 */
		private void statXiaolei(CacheUtil cacheUtil){
			cacheUtil.clearModel("xiaolei");
			List<Business_root> roots=null;
			List<Object[]> years=null;
			List<Object[]> results=null;
			String countAll=null;
			InfoStat stat=null;
			List<Info> value=null;
			List<InfoStat> infos=null;
			Info info=null;
			BigDecimal a=null;
			BigDecimal b=null;
			BigDecimal r=null;
			
				years=hniidata_viewService.statByYear();
				results=hniidata_viewService.stat("xiaolei");
				roots=business_rootService.findAll();
				for (Business_root root : roots) {
					List<Business_secondary> secondarys=business_secondaryService.findByRootid(root.getRoot_id());
					root.setSecondarys(secondarys);
					//*****************
					infos=new ArrayList<InfoStat>();
					for (Object[] obj : years) {
						stat=new InfoStat();
						countAll=obj[1].toString();
						stat.setYears(obj[0].toString());
						stat.setCountAll(countAll);
						value=new ArrayList<Info>();
						for (Business_secondary secondary : secondarys) {
							 info=new Info();
							for (Object[] objects : results) {
								if(objects[1].toString().equals(secondary.getBusiness_name())&&obj[0].toString().equals(objects[2].toString())){
									info.setIndustry((String)objects[1]);
									info.setCount((BigDecimal)objects[0]);
									a=(BigDecimal)objects[0];
									b=new BigDecimal(countAll);
									r=a.multiply(new BigDecimal(100)).divide(b, 2, RoundingMode.HALF_UP);
									info.setPercent(r);
								}
							}
							value.add(info);
						}
						stat.setValues(value);
						infos.add(stat);
					}
					
					//***************
					root.setInfos(infos);
				}
				Cachemodel cachemodel=new Cachemodel();
			    Map<String, Object> map=new HashMap<String, Object>();
				map.put("roots", roots);
			    cachemodel.setCacheMap(map);
			    cachemodel.setCdate(new Date());
			    cachemodel.setVdate(24);
			    cacheUtil.addCache("xiaolei",cachemodel);
			
		}
		
		private void statJudgedoc(CacheUtil cacheUtil){
			cacheUtil.clearModel("judgedoc");
			List<Object[]> judgeDocs=null;
			BigDecimal countAll=new BigDecimal(0);
			List<String> xdata=new ArrayList<String>();
			List<BigDecimal> ydata=new ArrayList<BigDecimal>();
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
		}
		
		private void statGoodbad(CacheUtil cacheUtil){
			cacheUtil.clearModel("goodbad");
			List<Object[]> goodbads=null;
			BigDecimal countAll=new BigDecimal(0);
			List<String> xdata=new ArrayList<String>();
			List<BigDecimal> ydata=new ArrayList<BigDecimal>();
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
		}
		
		private void statDishonestMan(CacheUtil cacheUtil){
			cacheUtil.clearModel("dishonestMan");
			List<Object[]> dishonestMans=null;
			BigDecimal countAll=new BigDecimal(0);
			List<String> xdata=new ArrayList<String>();
			List<BigDecimal> ydata=new ArrayList<BigDecimal>();
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
		}
		
		private void statMediaexposed(CacheUtil cacheUtil){
			cacheUtil.clearModel("mediaexposed");
			List<Object[]> mediaexposeds=null;
			BigDecimal countAll=new BigDecimal(0);
			List<String> xdata=new ArrayList<String>();
			List<BigDecimal> ydata=new ArrayList<BigDecimal>();
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
		}
		
		private void statPublicprise(CacheUtil cacheUtil){
			cacheUtil.clearModel("publicprise");
			List<Object[]> publicprises=null;
			BigDecimal countAll=new BigDecimal(0);
			List<String> xdata=new ArrayList<String>();
			List<BigDecimal> ydata=new ArrayList<BigDecimal>();
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
		}
		
		private void statServicecomplaint(CacheUtil cacheUtil){
			cacheUtil.clearModel("servicecomplaint");
			List<Object[]> servicecomplaints=null;
			BigDecimal countAll=new BigDecimal(0);
			List<String> xdata=new ArrayList<String>();
			List<BigDecimal> ydata=new ArrayList<BigDecimal>();
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
		}
		
		
		@Override
		public void init_analyzeStat(ModelMap model) {
			CacheUtil cacheUtil=CacheUtil.newInstance();
			Map<String, Object> cacheMap=cacheUtil.getCache("analyze");
			initAnalyzeInfo(cacheUtil, cacheMap, model);
		}
		
		public void initAnalyzeInfo(CacheUtil cacheUtil,Map<String, Object> cacheMap,ModelMap model) {
			//服务质量投诉 和公众表扬信息
			Long public_priseCount = 0L;
			Long service_complaintCount = 0L;
			//司法判决
			Long judgeCount = 0L;
			//失信被执行人
			Long dishonestCount = 0L;
			if(cacheMap==null){
				judgeCount=judgeDocRepository.countJudgedoc();
				dishonestCount=dishonestManRepository.countCaixin();
				public_priseCount = public_priseRepository.countCaixin();
				service_complaintCount = service_complaintRepository.countCaixin();
				Cachemodel cachemodel=new Cachemodel();
			    Map<String, Object> map=new HashMap<String, Object>();
			    map.put("judgeCount", judgeCount);
			    map.put("dishonestCount", dishonestCount);
			    map.put("public_priseCount", public_priseCount);
			    map.put("service_complaintCount", service_complaintCount);
			    cachemodel.setCacheMap(map);
			    cachemodel.setCdate(new Date());
			    cachemodel.setVdate(24);
			    cacheUtil.addCache("analyze",cachemodel);
			}
			else{
				judgeCount= (Long) cacheMap.get("judgeCount");
				dishonestCount= (Long) cacheMap.get("dishonestCount");
				public_priseCount= (Long) cacheMap.get("public_priseCount");
				service_complaintCount= (Long) cacheMap.get("service_complaintCount");
			}
			List<Object> pageJudgedoc = judgeDocService.findDatas();
			List<Object> pageDishonestMan = dishonestManService.findDatas();
			List<Object> pagePublicPrise = public_priseService.findDatas();
			List<Object> pageServiceComplaint= service_complaintService.findDatas();
			Object xComplaint = null;
			Object yComplaint = null;
			Object xConsult = null;
			Object yConsult = null;
			List<Object[]> hniiComplaint = hniibehaviorService.findComplaint();
			xComplaint = getXEchartsdata(hniiComplaint,"X");
			yComplaint = getXEchartsdata(hniiComplaint,"Y");
	 		List<Object[]> hniiConsult = hniibehaviorService.findConsult();
	 		xConsult = getXEchartsdata(hniiConsult,"X");
			yConsult = getXEchartsdata(hniiConsult,"Y");
			model.addAttribute("judgeCount", judgeCount);
			model.addAttribute("dishonestCount", dishonestCount);
			model.addAttribute("public_priseCount", public_priseCount);
			model.addAttribute("service_complaintCount", service_complaintCount);
			model.addAttribute("pageJudgedoc", pageJudgedoc);
			model.addAttribute("pageDishonestMan", pageDishonestMan);
			model.addAttribute("pageServiceComplaint", pageServiceComplaint);
			model.addAttribute("pagePublicPrise", pagePublicPrise);
			model.addAttribute("xComplaint", xComplaint);
			model.addAttribute("yComplaint", yComplaint);
			model.addAttribute("xConsult", xConsult);
			model.addAttribute("yConsult", yConsult);
		}

		public Object getXEchartsdata(List<Object[]> dataList,String coordinates) {
			int i = 0;
			if("X".equals(coordinates)){
				  i = 0;
			}else if ("Y".equals(coordinates)){
				  i = 1;
			}
			Object ex = null;
			String coordinatesData="[";
	 		for(Object[] data:dataList){
	 			coordinatesData=coordinatesData+"'"+data[i]+"',";
	 		}
	 		coordinatesData=coordinatesData.substring(0,coordinatesData.length()-1)+"]";
	 		ex = coordinatesData;
			return ex;
		}

		public List<Object[]> analyzeCount() {
			List<Object[]> object= new ArrayList<Object[]>();
			List<Object[]> zuheObject= new ArrayList<Object[]>();
			Object[] tablename = {"中国裁判文书网","失信被执行人信息","表彰信息","获奖信息","通报批评信息","公众表扬信息","服务质量投诉信息","项目招标信息","项目中标信息"};
			object = findCount();
			for(int order=0;order<tablename.length;order++){
				Object[] zuhe = new Object[2];
				 zuhe[0] = tablename[order];
				 zuhe[1] = object.get(0)[order];
				 zuheObject.add(zuhe);
			}
			return zuheObject;
		}

		private List<Object[]> findCount() {
			List<Object> values = new ArrayList<Object>();
//			String sql = "select j.count1,d.count1,b.count1,h.count1,t.count1,p.count1,s.count1,z.count1,zhong.count1 from (select count(*) count1   from judgedoc )j ,(select count(*) count1 from dishonestman )d, (select count(*) count1 from corpgoodinfo where type = '表彰' ) b, (select count(*) count1 from corpgoodinfo where type = '获奖' ) h,(select count(*) count1 from corpgoodinfo  ) t,(select count(*) count1 from public_prise  ) p,(select count(*) count1 from service_complaint  ) s,(select count(*) count1 from zhaobiaogg  ) z,(select count(*) count1 from zhongbiaogg  ) zhong";
			String sql= "select j.count1,d.count2,b.count3,h.count4,t.count5,p.count6,s.count7,z.count8,zhong.count9 from (select count(1) count1 from judgedoc )j ,(select count(1) count2 from dishonestman )d, (select count(1) count3 from corpgoodinfo where type = '表彰' ) b, (select count(1) count4 from corpgoodinfo where type = '获奖' ) h,(select count(1) count5 from corpgoodinfo  ) t,(select count(1) count6 from public_prise  ) p,(select count(1) count7 from service_complaint  ) s,(select count(1) count8 from zhaobiaogg  ) z,(select count(1) count9 from zhongbiaogg  ) zhong";
			List<Object[]> rst = queryService.query(sql,values);
			return rst;
		}

	 
		
}
