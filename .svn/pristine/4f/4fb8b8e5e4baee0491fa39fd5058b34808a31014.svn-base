package com.centit.hlwyw.inner.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Bigtypestatistics;
import com.centit.hlwyw.inner.entity.Industrystatistics;
import com.centit.hlwyw.inner.entity.Smalltypestatistics;
import com.centit.hlwyw.inner.service.impl.BigtypestatisticsServiceImpl;
import com.centit.hlwyw.inner.service.impl.Hnii_alarm_serviceServiceImpl;
import com.centit.hlwyw.inner.service.impl.Hniidata_viewServiceImpl;
import com.centit.hlwyw.inner.service.impl.IndustrystatisticsServiceImpl;
import com.centit.hlwyw.inner.service.impl.SmalltypestatisticsServiceImpl;

public class Datastatistics {
	
	private static Hnii_alarm_serviceServiceImpl hnii_alarm_serviceService = new Hnii_alarm_serviceServiceImpl();
	
	private static Hniidata_viewServiceImpl hniidata_viewService = new Hniidata_viewServiceImpl();
	
//	private static Industry_typeServiceImpl industry_typeService = new Industry_typeServiceImpl();
 
	private static IndustrystatisticsServiceImpl industrystatisticsService = new IndustrystatisticsServiceImpl();
	
	private static BigtypestatisticsServiceImpl bigtypestatisticsService = new BigtypestatisticsServiceImpl() ;
	
 	private static   SmalltypestatisticsServiceImpl smalltypestatisticsService = new SmalltypestatisticsServiceImpl();

	public static  void statisticsIndustry() {
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
 	
	public static void statDalei()  {
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
	
	public static void statXiaolei()  {
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
					//[9, 道路货物运输, 2013]
				if (obj[1]==null||"".equals(obj[1].toString())||result[2]==null||"".equals(result[2].toString()) ){
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
					smalltypestatisticsService.save(small_statistics);
					}
				}
			}
	}
 
}
