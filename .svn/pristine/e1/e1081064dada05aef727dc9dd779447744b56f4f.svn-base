package com.centit.hlwyw.inner.service.impl;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Service_interface;
import com.centit.hlwyw.inner.entity.Service_log;
import com.centit.hlwyw.inner.repositories.Service_interfaceRepository;
import com.centit.hlwyw.inner.repositories.Service_logRepository;
import com.centit.hlwyw.inner.service.Service_logService;


@Service("service_logServiceImpl")
public class Service_logServiceImpl extends BaseServiceImpl<Service_log, String>
   implements Service_logService {


	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	
	@Resource(name="service_logRepository")
	private Service_logRepository repository;
	
	
	
	
	 
	@Resource(name = "service_logRepository")
	public void setReposity(
			PagingAndSortingRepository<Service_log, String> repository) {
		super.setReposity(repository);
	}

	
	


	
	@Override
	public Service_log find(String id) {
		return super.find(id);
	}

	@Override
	public List<Service_log> findAll() {
		return super.findAll();
	}

	@Override
	public List<Service_log> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	public List<Service_log> findList(Sort sort) {
		return super.findList(sort);
	}

	

	@Override
	
	public void save(Service_log entity) {
		super.save(entity);

	}

	@Override
	
	public Service_log update(Service_log entity) {
		Service_log service_log = super.find(entity.getId());
		super.update(entity);
		return service_log;
	}

	@Override
	
	public Service_log update(Service_log entity, String... ignoreProperties) {
		Service_log service_log = super.update(entity, ignoreProperties);
		return service_log;
	}

	@Override
	
	public void delete(String id) {
		super.delete(id);

	}

	@Override
	
	public void delete(String[] ids) {
		super.delete(ids);
	}

	@Override
	
	public void delete(Service_log entity) {
		super.delete(entity);

	}

	
	@Override
	public List<Object[]> findGroupByDateMonthYear(String searchtypesub,Date begindate, Date enddate) {
		String format=null;
		if("day".equals(searchtypesub)){
			format="yyyy/mm/dd";
		}else if("month".equals(searchtypesub)){
			format="yyyy/mm";
 		}else if("year".equals(searchtypesub)){
			format="yyyy";
		}else{
			format="yyyy";
		}
			
			
		
		
		List<Object> values = new ArrayList<Object>();
		StringBuffer sqlb = new StringBuffer("select interfaces,unit,data_size,data_type,to_char(time, '"+format+"') as datestr from service_log  ");
	 	String sql=null;
		if(!(begindate==null&& enddate==null )){
			sqlb.append(" where ");
			if(begindate!=null){
				sqlb.append("  time > ? and");
				values.add(begindate);
			}
			if(enddate!=null){
				sqlb.append("  time < ? and");
				values.add(enddate);
			}

			sql=sqlb.toString();
			sql=sql.substring(0, sql.length()-3);
		}else{
			sql=sqlb.toString();
		}
		String order = "  group by interfaces,unit,data_size,data_type,to_char(time, '"+format+"') order by datestr desc";
		sql=sql+order;
		List<Object[]> rst = queryService.query(sql, values);
		return rst;
	}



	@Override
	public  Map<String,Map<String,Long>> getTableMapGroup(List<String> datelist,Date begindate, Date enddate,List<Object[]> serviceloglist){
		Map<String,Map<String,Long>> map=new HashMap<String,Map<String,Long>>();
		for(Object[] log:serviceloglist){
			String interfaces=(String) log[0];
			String unit=(String) log[1];
			String data_size=(String) log[2];
			String data_type=(String) log[3];
			if(!map.containsKey(interfaces)){
				Map<String,Long>  d_num=new HashMap<String,Long>();
				 for(String d:datelist){
					d_num.put(d, 0l);
					
				 }
				map.put(interfaces,d_num);
				
				
			}
			
			
			
		}
		for(Object[] log:serviceloglist){
			String interfaces=(String) log[0];
			String unit=(String) log[1];
			String datestr=(String) log[4];
			Long nums= Long.parseLong(log[2].toString());
			if(nums!=0l){
				map.get(interfaces).put(datestr, nums);
				
				
			}
		}
		return map;
		
	}

		        		
	@Override
	public Object[] getChartData(List<String> datelist,Map<String,Map<String,Long>>  map){
		Object[] ob=new Object[4];
//		legend_data['中国裁判文书网','信用中国','重庆市交通委员会','中华人民共和国交通运输部','重庆市道路运输信息网','重庆市公路局','重庆航运']
//		series[ { name:'中国裁判文书网',type:'line', data:[0,0,0,0,0,1,0]} ]
		StringBuffer legend_data=new StringBuffer("[");
		StringBuffer series=new StringBuffer("[");
		
		List<List<String>> tabletr=new ArrayList<List<String>>();
		
		if(map!=null&&!map.isEmpty()){
			 for(Entry<String, Map<String, Long>> e:map.entrySet()){
				 legend_data.append("'").append(e.getKey()).append("',");
				 series.append("{").append("name:'").append(e.getKey()).append("',type:'line',data:[");
				 List<String> tr=new ArrayList<String>();
				 tabletr.add(tr);
				 tr.add(e.getKey());
				 if(datelist!=null&&datelist.size()>0){
					for(String d:datelist){
						 series.append(e.getValue().get(d)).append(",");
						 tr.add(e.getValue().get(d).toString());
						 
					} 
					series.deleteCharAt(series.length()-1);
				 }
				series.append("]").append("},");
			 }
			 legend_data.deleteCharAt(legend_data.length()-1);
			 series.deleteCharAt(series.length()-1);
		}
		legend_data.append("]");
		series.append("]");
//		xAxis_data['2017/09/04','2017/09/05','2017/09/06','2017/09/07','2017/09/08','2017/09/09','2017/09/10']
		StringBuffer xAxis_data=new StringBuffer("[");
		 if(datelist!=null&&datelist.size()>0){
			 for(String d:datelist){
				 xAxis_data.append("'").append(d).append("',");
			} 
			 xAxis_data.deleteCharAt(xAxis_data.length()-1);
		 }
		 xAxis_data.append("]");
		 
		 ob[0]=legend_data.toString();
		 ob[1]=xAxis_data.toString();
		 ob[2]=series.toString();
		 ob[3]=tabletr;
		 
		return ob;
		
	}

 
	
 
 
}

		
	



