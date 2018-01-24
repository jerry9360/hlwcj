package com.centit.hlwyw.inner.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Bigtypestatistics;
import com.centit.hlwyw.inner.entity.Hniidata_view;
import com.centit.hlwyw.inner.entity.Industrystatistics;
import com.centit.hlwyw.inner.entity.Smalltypestatistics;
import com.centit.hlwyw.inner.repositories.Hniidata_viewRepository;
import com.centit.hlwyw.inner.service.BigtypestatisticsService;
import com.centit.hlwyw.inner.service.Hnii_alarm_serviceService;
import com.centit.hlwyw.inner.service.Hniidata_viewService;
import com.centit.hlwyw.inner.service.IndustrystatisticsService;
import com.centit.hlwyw.inner.service.SmalltypestatisticsService;

@Service("hniidata_viewServiceImpl")
public class Hniidata_viewServiceImpl extends BaseServiceImpl<Hniidata_view, String>
		implements Hniidata_viewService {

	@Resource(name = "hniidata_viewRepository")
	private Hniidata_viewRepository repository;

	@Resource(name = "industrystatisticsServiceImpl")
	private IndustrystatisticsService industrystatisticsService;
	
//	private static IndustrystatisticsServiceImpl industrystatisticsService = new IndustrystatisticsServiceImpl();
	
	@Resource(name = "hnii_alarm_serviceServiceImpl")
	private Hnii_alarm_serviceService hnii_alarm_serviceService;

	@Resource(name = "hniidata_viewServiceImpl")
	private Hniidata_viewService hniidata_viewService;
	
	@Resource(name = "bigtypestatisticsServiceImpl")
	private BigtypestatisticsService bigtypestatisticsService;
	
	@Resource(name = "smalltypestatisticsServiceImpl")
	private SmalltypestatisticsService  smalltypestatisticsService;
	
	 
	
	@Resource(name = "hniidata_viewRepository")
	public void setReposity(
			PagingAndSortingRepository<Hniidata_view, String> repository) {
		super.setReposity(repository);
	}
	
	@Override
	public String statByHangye(String hangye) {
		return repository.statByHangye(hangye);
	}

	@Override
	public String statByDalei(String hangye, String dalei) {
		return repository.statByDalei(hangye, dalei);
	}

	@Override
	public String statByXiaolei(String hangye, String dalei, String xiaolei) {
		return repository.statByXiaolei(hangye, dalei, xiaolei);
	}

	@Override
	public String statByDaleiOnly(String dalei) {
		return repository.statByDaleiOnly(dalei);
	}

	@Override
	public String statByXiaoleiOnly(String xiaolei) {
		return repository.statByXiaoleiOnly(xiaolei);
	}

	@Override
	public List<String> getYears() {
		return repository.getYears();
	}

	@Override
	public List<Object[]> stat(String infotype) {
		if("hangye".equals(infotype)){
			return repository.statByIndustry();
		}else if("dalei".equals(infotype)){
			return repository.statByDalei();
		}
		return repository.statByXiaolei();
	}

	@Override
	public String statByName(String infotype,String name,String year) {
		if("hangye".equals(infotype)){
			return repository.statByIndustryName(name,year);
		}
		return repository.statByDaleiName(name,year);
	}

	@Override
	public List<Object[]> statAll(String infotype) {
		if("industry".equals(infotype)){
			return repository.statIndustry();
		}else if("dalei".equals(infotype)){
			return repository.statDalei();
		}
		return repository.statXiaolei();
	}

	@Override
	public List<Object[]> statByYear() {
		return repository.statByYear();
	}

	public   void statisticsIndustry() {
		if(industrystatisticsService.findAll()!=null)
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
	
	public   void statDalei()  {
		if(bigtypestatisticsService.findAll()!=null)
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
	public   void statXiaolei()  {
		if(smalltypestatisticsService.findAll()!=null)
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
					small_statistics.setBig_type_name(result[3].toString());
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
