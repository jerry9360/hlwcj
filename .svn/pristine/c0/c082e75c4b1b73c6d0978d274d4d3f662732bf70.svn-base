package com.centit.hlwyw.inner.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Logcollect;
import com.centit.hlwyw.inner.repositories.LogcollectRepository;
import com.centit.hlwyw.inner.service.LogcollectService;

@Service("logcollectServiceImpl")
public class LogcollectServiceImpl extends BaseServiceImpl<Logcollect, String>
		implements LogcollectService {

	@Resource(name = "logcollectRepository")
	private LogcollectRepository repository;

	@Resource(name = "queryServiceImpl")
	private QueryService queryService;

	@Resource(name = "logcollectRepository")
	public void setReposity(
			PagingAndSortingRepository<Logcollect, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
 	public Logcollect find(String id) {
		return super.find(id);
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
		StringBuffer sqlb = new StringBuffer("select type,to_char(logdate, '"+format+"') as datestr,sum(num) from logcollect  ");
	 	String sql=null;
		if(!(begindate==null&& enddate==null )){
			sqlb.append(" where ");
			if(begindate!=null){
				sqlb.append("  logdate >= ? and");
				values.add(begindate);
			}
			if(enddate!=null){
				sqlb.append("  logdate <= ? and");
				values.add(enddate);
			}

			sql=sqlb.toString();
			sql=sql.substring(0, sql.length()-3);
		}else{
			sql=sqlb.toString();
		}
		String order = "  group by type,to_char(logdate, '"+format+"') order by datestr asc ";
		sql=sql+order;
		List<Object[]> rst = queryService.query(sql, values);
		return rst;
	}



	@Override
	public  Map<String,Map<String,Long>> getTableMapGroup(List<String> datelist,Date begindate, Date enddate,List<Object[]> loglist){
		Map<String,Map<String,Long>> map=new HashMap<String,Map<String,Long>>();
		for(Object[] log:loglist){
			String source=(String) log[0];
			if(!map.containsKey(source)){
				Map<String,Long>  d_num=new HashMap<String,Long>();
				 for(String d:datelist){
					d_num.put(d, 0l);
				 }
				map.put(source,d_num);
			}
		}
		for(Object[] log:loglist){
			String source=(String) log[0];
			String datestr=(String) log[1];
			Long num= Long.parseLong(log[2].toString());
			if(num!=0l){
				map.get(source).put(datestr, num);
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
