package com.centit.hlwyw.inner.service.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.core.util.GetPercentUtils;
import com.centit.hlwyw.inner.entity.Hnii;
import com.centit.hlwyw.inner.entity.HniiBehavior;
import com.centit.hlwyw.inner.entity.Hnii_analyze_data;
import com.centit.hlwyw.inner.repositories.Hnii_analyze_dataRepository;
import com.centit.hlwyw.inner.service.HniiBehaviorService;
import com.centit.hlwyw.inner.service.HniiService;
import com.centit.hlwyw.inner.service.Hnii_analyze_dataService;

@Service("hnii_analyze_dataServiceImpl")
public class Hnii_analyze_dataServiceImpl extends BaseServiceImpl<Hnii_analyze_data, String>
		implements Hnii_analyze_dataService {

	@Resource(name = "hnii_analyze_dataRepository")
	private Hnii_analyze_dataRepository repository;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "hniiServiceImpl")
	private HniiService hniiService;
	
	@Resource(name = "hniiBehaviorServiceImpl")
	private HniiBehaviorService hniiBehaviorService;
	
	GetPercentUtils getPercent = new GetPercentUtils();


	@Resource(name = "hnii_analyze_dataRepository")
	public void setReposity(
			PagingAndSortingRepository<Hnii_analyze_data, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("hnii_analyze_data_detail")
	public Hnii_analyze_data find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_analyze_data> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_analyze_data> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hnii_analyze_data> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Hnii_analyze_data> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable("hnii_analyze_data")
	public Page<Object> findDatas(String btype,String stype,String industry,String content,Date begindate,Date enddate,Pageable pageable){
		StringBuilder sqlBuilder = new StringBuilder("from Hnii_analyze_data tbl");
		String order = " order by  tbl.calltime desc ";
		List<Object> values = new ArrayList<Object>();
		String sql = null;			
		if(StringUtils.isNotBlank(btype)||StringUtils.isNotBlank(stype)||StringUtils.isNotBlank(industry)||StringUtils.isNotBlank(content)||begindate!=null||enddate!=null){
			sqlBuilder.append(" where");
			if(StringUtils.isNotBlank(btype)){
				sqlBuilder.append(" tbl.btype like ? and");
				btype = "%"+btype+"%";
				values.add(btype);
			}
			if(StringUtils.isNotBlank(stype)){
				sqlBuilder.append(" tbl.stype like ? and");
				stype = "%"+stype+"%";
				values.add(stype);
			}
			if(StringUtils.isNotBlank(industry)){
				sqlBuilder.append(" tbl.industry like ? and");
				industry = "%"+industry+"%";
				values.add(industry);
			}
			if(StringUtils.isNotBlank(content)){
				sqlBuilder.append(" tbl.myid like ? and");
				content = "%"+content+"%";
				values.add(content);
			}
			if(begindate!=null){
				sqlBuilder.append(" tbl.calltime >= ? and");
				
				values.add(begindate);
			}
			if(enddate!=null){
				sqlBuilder.append(" tbl.calltime <= ? and");
			
				values.add(enddate);
			}
			sql = sqlBuilder.toString();
			sql = sql.substring(0, sql.length()-4);
		}else{
			sql = sqlBuilder.toString();
		}
		return queryService.queryForPage(sql, order, values, Hnii_analyze_data.class, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable("hniiservicedata")
	public List<Object[]> findDatasList(String btype, String stype,String industry, String content,Date begindate,Date enddate) {
		List<Object[]> result=new ArrayList<>();
		Long total=null;
		StringBuffer sqlData =new StringBuffer();
		StringBuffer sqlCount =new StringBuffer();
		sqlData.append("select * from (select a1.*,rownum rn from (select tbl.id, tbl.myid,tbl.btype,tbl.stype,tbl.industry,tbl.object,tbl.objectname,tbl.carno,tbl.lineno,tbl.time,tbl.baddress,"
					+ "tbl.eaddress,tbl.content,tbl.unit,tbl.dealopinion,tbl.calltime from Hnii_analyze_data tbl where 1=1 ");
		sqlCount.append("select count(*) from Hnii_analyze_data tbl where 1=1 ");
		List<Object> values = new ArrayList<Object>();
		//只导出本年度的数据
		if(begindate!=null){
			sqlData.append(" and tbl.calltime >= ? ");
			sqlCount.append(" and tbl.calltime >= ? ");
			values.add(begindate);
		}
		if(enddate!=null){
			sqlData.append(" and tbl.calltime <= ? ");
			sqlCount.append(" and tbl.calltime <= ? ");
			values.add(enddate);
		}
			
			if(StringUtils.isNotBlank(btype)){
				sqlData.append(" and tbl.btype like ? ");
				sqlCount.append(" and tbl.btype like ? ");
				btype = "%"+btype+"%";
				values.add(btype);
			}
			if(StringUtils.isNotBlank(stype)){
				sqlData.append(" and tbl.stype like ? ");
				sqlCount.append(" and tbl.stype like ? ");
				stype = "%"+stype+"%";
				values.add(stype);
			}
			if(StringUtils.isNotBlank(industry)){
				sqlData.append(" and tbl.industry like ? ");
				sqlCount.append(" and tbl.industry like ? ");
				industry = "%"+industry+"%";
				values.add(industry);
			}
			if(StringUtils.isNotBlank(content)){
				sqlData.append(" and tbl.content like ? ");
				sqlCount.append(" and tbl.content like ? ");
				content = "%"+content+"%";
				values.add(content);
			}
			sqlData.append(") a1  where rownum <= ? )  where rn > ?");
			Object rst=queryService.queryForObject(sqlCount.toString(), values).get(0);
			if(rst!=null){
				total=((BigDecimal)rst).longValue();
			}
			
		int pagesize=0;
		if(total%200000 ==0){
			pagesize=(int)(total/200000);
		}else{
			pagesize=(int)(total/200000)+1;
		}
		for(int i=1;i<=pagesize;i++){
			values.add((long)200000*i);
			values.add((long)(i-1)*200000);
			result.addAll(queryService.query(sqlData.toString(), values));
			values.remove(values.size()-1);
			values.remove(values.size()-1);
		}
		return result;
	}

	@Override
	public List<Object[]> findYears() {
		return repository.findYears();
	}

 
	@Override
	public Object[] countHniiindustry() {
		 List<Object[]> count96096industrydesc=repository.countHniiindustry() ;
		Object[] data96096industrydesc = new Object[3];
		StringBuilder sbindustrydesc = new StringBuilder("[");
		StringBuilder sbdesc = new StringBuilder("[");
		Long total=0l;
		if(count96096industrydesc!=null&&!count96096industrydesc.isEmpty()){
			for(Object[] industrydesc:count96096industrydesc){
				sbindustrydesc.append("{value:"+industrydesc[0]+", name:'"+industrydesc[1]+"'},");
				sbdesc.append("'"+industrydesc[1]+"',");
				total=total+Long.valueOf(industrydesc[0].toString());
			}
			sbindustrydesc.deleteCharAt(sbindustrydesc.length()-1);
			sbdesc.deleteCharAt(sbdesc.length()-1);
		}
		sbdesc.append("]");
		sbindustrydesc.append("]");
		data96096industrydesc[0] = sbindustrydesc.toString();
		data96096industrydesc[1] = sbdesc.toString();
		data96096industrydesc[2] = total;
		return data96096industrydesc;
	}

 
	@Override
	public Object[] countHniibtype() {
		 List<Object[]> count96096btypedesc=repository.countHniibtype();
		Object[] data96096btypedesc = new Object[2];
		StringBuilder bbbtypedesc = new StringBuilder("[");
		StringBuilder bbdesc = new StringBuilder("[");
		if(count96096btypedesc!=null&&!count96096btypedesc.isEmpty()){
			for(Object[] btypedesc:count96096btypedesc){
				bbbtypedesc.append("{value:"+btypedesc[0]+", name:'"+btypedesc[1]+"'},");
				bbdesc.append("'"+btypedesc[1]+"',");
			}
			bbbtypedesc.deleteCharAt(bbbtypedesc.length()-1);
			bbdesc.deleteCharAt(bbdesc.length()-1);
		}
		bbbtypedesc.append("]");
		bbdesc.append("]");
		data96096btypedesc[0] = bbbtypedesc.toString();
		data96096btypedesc[1] = bbdesc.toString();
		return data96096btypedesc;
	}

	/**
	 * datatype  industry  btype
	 * timetype year month  day
	 */
	@Override
	@Cacheable("analyzeindustry")
	public void init_analyzeIndustry(String datatype,String timetype,String begindate, String enddate,  ModelMap model) {
			    List<Object[]> list =  new ArrayList<Object[]>();
//			    [咨询类, 投诉类, 反映情况类, 求助，其它，表扬类，建议类，重复来电举报类,备案，报案 ]
//			[巡游出租车, 网约出租车, 铁路旅客运输, 水路运输市场, 汽车租赁, 其它, 驾培, 航道, 公路养护, 公路施工, 公共交通, 高速公路, 道路货物运输, 长途客运]
			    List<Object> industrydata = new ArrayList<Object>();
			    if("btype".equals(datatype)){
			    	industrydata = findBusinessAndCount();
			    }else{
			    	industrydata = findIndustryAndCount();
			    }
			    Object[] listtitle = getAxis(industrydata);
				Object xcoordinatesData = listtitle[0];
//			    2017	477069
			    List<Object[]> alarmdata = findCount("hnii",timetype, begindate, enddate);
			    int industrySize = industrydata.size();
//			   2017	  巡游出租车   	42046
				List<Object[]> allData = findAllData(datatype,timetype, begindate, enddate);
				int size = 2*industrySize + 4;
//				遍历年份
				for(Object[] year:alarmdata){
					if(year[0]!=null&&year[0]!=""){
//						年份
						Object[] zuheObject = getOneData(size,year[0],year[1],industrydata,allData);
						//将这一条object[]放进List集合里
						list.add(zuheObject);	
					}
				}
				Object[] lastObject = getLastData(size,list); 
				Object ycoordinatesData = getYAxis(size,lastObject);
				list.add(lastObject);
				model.addAttribute("industrydata",industrydata);
				model.addAttribute("xAxis",xcoordinatesData);
				model.addAttribute("yAxis",ycoordinatesData);
//				model.addAttribute("timetype",timetype);
//				model.addAttribute("begindate",begindate);
//				model.addAttribute("enddate",enddate);
				model.addAttribute("list",list);
	}
	
	private Object getYAxis(int size,Object[] lastObject) {
		Object yAxis = null;
		List<Object> list = new ArrayList<Object>();
		Object[] object = null;
		for (int order=4;order<size;order++){
			object = new Object[2];
			object[0] =lastObject[order].toString();
			order++;
			object[1] =lastObject[order].toString();
			list.add(object);
		}
		yAxis = getAxis(list)[0];
		return yAxis;
	}

	private Object[] getLastData(int size, List<Object[]> list) {
		int count = 0;
		int order1 = 0;
		Object[] lastOneData = new Object[size];
		lastOneData[0] = "汇总";
		for(Object[] obj:list){
			if(obj[1]==null){
				obj[1]="0";
			}
			count += Integer.parseInt((String) obj[1]);
		}
		lastOneData[1]=(Object)count;
		for(int order=2;order<size;order++){
			count = 0;
			for(Object[] obj:list){
				count += Integer.parseInt(obj[order].toString());
			}
			lastOneData[order] = (Object)count;
			order++;
			lastOneData[order]=getPercent.getPercent(lastOneData[order-1],lastOneData[1]);
		}
		return lastOneData;
	}

	private Object[] getOneData(int size,Object year,Object countyear, List<Object> industrydata, List<Object[]> allData) {
		Object[] zuheObject = new Object[size];
		int count = 0;
		for(int order=4;order<size;order++){
			for(Object industry:industrydata)	{
//			按年份和行业名称组合数据
			int indexLine = -1;
				//遍历每一条数据
				int index = getData(indexLine,year,industry,allData);
				if(index==10000){
					zuheObject[order]="0";
					order++;
					zuheObject[order]="0";
					order++;
				}else{
//					处理工单总量 --遍历
//					总占比
//					行业数据量
					zuheObject[order]=allData.get(index)[2].toString();
					order++;
//					行业占比
					zuheObject[order]=getPercent.getPercent(allData.get(index)[2], countyear);
					order++;
					}
				}
			for(int order1=4;order1<size;order1++){
				count += Integer.parseInt((String) zuheObject[order1]);
				order1++;
			}
//			时间
			zuheObject[0]=year.toString();
//			工单总量
			zuheObject[1]=countyear.toString();
			zuheObject[2] = count;
			zuheObject[3] = getPercent.getPercent(count,zuheObject[1]);
		}
		return zuheObject;
	}

	private int getData(int index ,Object year, Object industry, List<Object[]> allData) {
		for(Object[] object:allData){
			index ++;
			if(object[0].equals(year)&&object[1].equals(((Object[])industry)[0])){
				if(index!=0){
					return index;
					}
				return 0;
				}
			}
		return 10000;
	}
	
	@Override
	public List<Object> findLocationDatas(String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from (select baddress,sum(datasize) from hnii   where     datatype = 'address'   ");
		String end =  " group by baddress order by sum(datasize) desc ) where rownum < 21 " ;
		String sql = null;			
			if(begindate!=null){
				sqlBuilder.append(" and to_char(calltime,'yyyy-mm-dd') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}

	@Override
	public Page<Hnii_analyze_data> findList(String baddress, Pageable pageable) {
		return repository.findList(baddress,pageable);
	}
	
	@Override
	public Page<Hnii_analyze_data> findCarNoList(String carno, Pageable pageable) {
		return repository.findCarNoList(carno,pageable);
	}

	@Override
	public List<Object> findComplaintCarnoDatas(String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from (select carno,sum(datasize) from hnii   where  btype = '投诉类' and datatype = 'carno'    ");
		String end =  " group by carno  order by sum(datasize) desc ) where rownum < 21 " ;
		String sql = null;			
			if(begindate!=null){
				sqlBuilder.append(" and to_char(calltime,'yyyy-mm-dd') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}

	@Override
	public List<Object> findIllegalCarnoDatas(String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from (select carno,sum(datasize) from hnii   where btype = '非法营运' and  datatype = 'carno'    ");
		String end =  " group by carno  order by sum(datasize) desc ) where rownum < 21 " ;
		String sql = null;			
			if(begindate!=null){
				sqlBuilder.append(" and to_char(calltime,'yyyy-mm-dd') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}

	 public Object[] getAxis(List<Object> page){
		 Object[] x = new Object[2];
		String xcoordinatesData="[";
		String ycoordinatesData="[";
		for(Object object:page){
			Object[] string = new Object[2];
			string = (Object[]) object;
			xcoordinatesData = xcoordinatesData+"'"+string[0]+"',";
			ycoordinatesData = ycoordinatesData+"'"+string[1]+"',";
		}
		xcoordinatesData = xcoordinatesData.substring(0,xcoordinatesData.length()-1)+"]";
		ycoordinatesData = ycoordinatesData.substring(0,ycoordinatesData.length()-1)+"]";
		x[0] = xcoordinatesData;
		x[1] = ycoordinatesData;
		return x;
	 }
	 
		/**
		 * 根据时间获取行业，业务，行为特征分类汇总96096工单数据的分布情况
		 * @param type    	按行业，业务
		 * @param datatype   按年，月，日
		 * @param begindate
		 * @param enddate
		 * @return
		 */
		private List<Object[]> findAllData(String type,String datatype,String begindate, String enddate) {
			if("".equals(type)||type==null){
				type = "industry";
			}
			List<Object> values = new ArrayList<Object>();
			StringBuilder sqlBuilder = new StringBuilder("");
			if(datatype==null||"".equals(datatype)){
				sqlBuilder.append("  select to_char(calltime,'yyyy'),"+type+",sum(datasize) from hnii where datatype = '"+type+"'   group by to_char(calltime,'yyyy'),"+type+"  order by  to_char(calltime,'yyyy') desc,"+type+" desc");
			}else if("year".equals(datatype)){
				sqlBuilder.append("   select to_char(calltime,'yyyy'),"+type+",sum(datasize) from hnii where datatype = '"+type+"'  ");
				if(begindate!=null){
					sqlBuilder.append(" and to_char(calltime,'yyyy') >= " +"'"+begindate+"'");
				}
				if(enddate!=null){
					sqlBuilder.append(" and  to_char(calltime,'yyyy') <= " +"'"+enddate+"'");
				}
				sqlBuilder.append(" group by to_char(calltime,'yyyy'),"+type+"  order by  to_char(calltime,'yyyy') desc,"+type+" desc");
			}else if("month".equals(datatype)){
				sqlBuilder.append("   select to_char(calltime,'yyyy-mm'),"+type+",sum(datasize) from hnii where datatype = '"+type+"'  ");
				if(begindate!=null){
					sqlBuilder.append("  and to_char(calltime,'yyyy-mm') >= " +"'"+begindate+"'");
				}
				if(enddate!=null){
					sqlBuilder.append(" and  to_char(calltime,'yyyy-mm') <= " +"'"+enddate+"'");
				}
				sqlBuilder.append(" group by to_char(calltime,'yyyy-mm'),"+type+"  order by  to_char(calltime,'yyyy-mm') asc,"+type+" desc");
			}else if("day".equals(datatype)){
				sqlBuilder.append("   select to_char(calltime,'yyyy-mm-dd'),"+type+",sum(datasize) from hnii where datatype = '"+type+"'  ");
				if(begindate!=null){
					sqlBuilder.append("  and to_char(calltime,'yyyy-mm-dd') >= " +"'"+begindate+"'");
				}
				if(enddate!=null){
					sqlBuilder.append(" and  to_char(calltime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
				}
				sqlBuilder.append(" group by to_char(calltime,'yyyy-mm-dd'),"+type+"  order by  to_char(calltime,'yyyy-mm-dd') asc,"+type+" desc");
			}
			List<Object[]> rst = queryService.query(sqlBuilder.toString(),values);
			return rst;
		}
		
	 /**
		 * 查出96096数据中包含的所有行业和总量
		 * @return
		 */
	@Override
	public List<Object> findIndustryAndCount() {
		List<Object> values = new ArrayList<Object>();
		String sql  = "select industry,sum(datasize) from hnii where datatype = 'industry' group by industry order by industry desc";
		List<Object> rst = queryService.queryForObject(sql,values);
		return rst;
	}

	@Override
	public List<Object> findBusinessAndCount() {
		List<Object> values = new ArrayList<Object>();
		String sql  = "select btype,sum(datasize) from hnii where datatype = 'btype'  group by btype order by btype desc";
		List<Object> rst = queryService.queryForObject(sql,values);
		return rst;
	}

	@Override
	@Cacheable("analyzebehavior")
	public void init_analyzeBehavior(String industry, String btype,  String timetype, String begindate,
			String enddate, ModelMap model) {
//	    2017	477069
			List<Object[]> alarmdata = findCount("hnii",timetype,begindate,enddate);
			List<Object[]> list =  new ArrayList<Object[]>();
		    List<Object> stypedata = new ArrayList<Object>();
//		   2017	  巡游出租车   	42046
		    List<Object[]> allData = findStypeAndCount(industry.trim(),btype.trim(),timetype,begindate,enddate);
		    stypedata = getStype(industry,btype);
		    Object[] listtitle = getAxis(stypedata);
			Object xcoordinatesData = listtitle[0];
		    int industrySize = stypedata.size();
			int size = 2*industrySize + 4;
//			遍历年份
			for(Object[] year:alarmdata){
				if(year[0]!=null&&year[0]!=""){
//					年份
					Object[] zuheObject = getOneData(size,year[0],year[1],stypedata,allData);
					//将这一条object[]放进List集合里
					list.add(zuheObject);	
				}
			}
			Object[] lastObject = getLastData(size,list); 
			Object ycoordinatesData = getYAxis(size,lastObject);
			list.add(lastObject);
			model.addAttribute("stypedata",stypedata);
			model.addAttribute("xAxis",xcoordinatesData);
			model.addAttribute("yAxis",ycoordinatesData);
			model.addAttribute("list",list);
	}
	
	private List<Object> getStype(String industry, String btype) {
		List<Object> values = new ArrayList<Object>();
		String sql = "select stype,count(1) from hniibehavior where industry='"+industry+"' and btype = '"+btype+"' group by stype";
		List<Object> rst = queryService.queryForObject(sql,values);
		return rst;
	}

	private List<Object> findStypeCount(String timetype, String begindate, String enddate) {
//		select stype,count(1) from hnii_analyze_data where to_char(calltime,'yyyy') >= '2013' and  to_char(calltime,'yyyy') <= '2017' group by stype order by stype desc 
		List<Object> values = new ArrayList<Object>();
		StringBuilder sqlBuilder = new StringBuilder("");
		if(timetype==null||"".equals(timetype)){
			sqlBuilder.append("select stype,sum(datasize) from hniibehavior where calltime is not null and  to_char(calltime,'yyyy') >= '2013' and  to_char(calltime,'yyyy') <= '2017' group by stype order by stype desc");
		}else if("year".equals(timetype)){
			sqlBuilder.append(" select stype,sum(datasize) from hniibehavior where calltime is not null");
			if(begindate!=null){
				sqlBuilder.append(" and to_char(calltime,'yyyy') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by   stype  order by  stype desc");
		}else if("month".equals(timetype)){
			sqlBuilder.append("select stype,sum(datasize) from hniibehavior where calltime is not null ");
			if(begindate!=null){
				sqlBuilder.append("  and to_char(calltime,'yyyy-mm') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by   stype  order by  stype desc");
		}else if("day".equals(timetype)){
			sqlBuilder.append("select stype,sum(datasize)from hniibehavior where calltime is not null ");
			if(begindate!=null){
				sqlBuilder.append("  and to_char(calltime,'yyyy-mm-dd') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by stype  order by stype desc");
		}
		List<Object> rst = queryService.queryForObject(sqlBuilder.toString(),values);
		return rst;
	}

	/**
	 * 96096工单数据的涉及的年份和每年的数据总量
	 * @param enddate 
	 * @param begindate 
	 * @param datatype 
	 * @return
	 */

	private List<Object[]> findCount(String tablename,String timetype,String begindate, String enddate) {
		List<Object> values = new ArrayList<Object>();
		String table = null;
		if("hnii".equals(tablename)){
			 table = " where datatype = "+"'alarm' ";
		}
		else{
			table = "";
		}
		StringBuilder sqlBuilder = new StringBuilder("");
		if(timetype==null||"".equals(timetype)){
			sqlBuilder.append("select to_char(calltime,'yyyy') ,sum(datasize)   from "+tablename+table+"  group by to_char(calltime,'yyyy') order by  to_char(calltime,'yyyy') desc ");
		}else if("year".equals(timetype)){
			sqlBuilder.append(" select to_char(calltime,'yyyy'),sum(datasize)   from "+tablename+table+" ");
			if(begindate!=null){ 
				sqlBuilder.append(" and to_char(calltime,'yyyy') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by   to_char(calltime,'yyyy')  order by  to_char(calltime,'yyyy') desc");
		}else if("month".equals(timetype)){
			sqlBuilder.append("select to_char(calltime,'yyyy-mm'),sum(datasize)   from "+tablename+ table+"     ");
			if(begindate!=null){
				sqlBuilder.append("  and to_char(calltime,'yyyy-mm') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by   to_char(calltime,'yyyy-mm')  order by  to_char(calltime,'yyyy-mm') desc");
		}else if("day".equals(timetype)){
			sqlBuilder.append("select to_char(calltime,'yyyy-mm-dd'),sum(datasize)   from "+tablename+table+"  ");
			if(begindate!=null){
				sqlBuilder.append("  and to_char(calltime,'yyyy-mm-dd') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by   to_char(calltime,'yyyy-mm-dd')  order by  to_char(calltime,'yyyy-mm-dd') desc");
		}
		List<Object[]> rst = queryService.query(sqlBuilder.toString(),values);
		return rst;
	}

	private List<Object[]> findStypeAndCount(String industry, String btype,  String datatype, String begindate,
			String enddate) {
		String type = "stype";
		List<Object> values = new ArrayList<Object>();
		StringBuilder sqlBuilder = new StringBuilder("");
		if(datatype==null||"".equals(datatype)){
			sqlBuilder.append("  select to_char(calltime,'yyyy'),"+type+",sum(datasize) from hniibehavior where    industry = '"+industry+"' and btype = '"+btype+"' group by to_char(calltime,'yyyy'),"+type+"  order by  to_char(calltime,'yyyy') desc,"+type+" desc");
		}else if("year".equals(datatype)){
			sqlBuilder.append(" select to_char(calltime,'yyyy'),"+type+",sum(datasize) from hniibehavior where    industry = '"+industry+"' and btype = '"+btype+"'");
			if(begindate!=null){
				sqlBuilder.append(" and to_char(calltime,'yyyy') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by to_char(calltime,'yyyy'),"+type+"  order by  to_char(calltime,'yyyy') desc,"+type+" desc");
		}else if("month".equals(datatype)){
			sqlBuilder.append(" select to_char(calltime,'yyyy-mm'),"+type+",sum(datasize) from hniibehavior where    industry = '"+industry+"' and btype = '"+btype+"'");
			if(begindate!=null){
				sqlBuilder.append("  and to_char(calltime,'yyyy-mm') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by to_char(calltime,'yyyy-mm'),"+type+"  order by  to_char(calltime,'yyyy-mm') asc,"+type+" desc");
		}else if("day".equals(datatype)){
			sqlBuilder.append(" select to_char(calltime,'yyyy-mm-dd'),"+type+",sum(datasize) from hniibehavior where    industry = '"+industry+"' and btype = '"+btype+"'");
			if(begindate!=null){
				sqlBuilder.append("  and to_char(calltime,'yyyy-mm-dd') >= " +"'"+begindate+"'");
			}
			if(enddate!=null){
				sqlBuilder.append(" and  to_char(calltime,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(" group by to_char(calltime,'yyyy-mm-dd'),"+type+"  order by  to_char(calltime,'yyyy-mm-dd') asc,"+type+" desc");
		}
		List<Object[]> rst = queryService.query(sqlBuilder.toString(),values);
		return rst;
	}
	
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void saveHniiTypeData() {
		List<Object> values = new ArrayList<Object>();
		String  sql =  "select to_char(calltime,'yyyy-mm-dd'),count(1),industry,btype,stype from hnii_analyze_data  where calltime is not null group by to_char(calltime,'yyyy-mm-dd'),industry,btype,stype order by  to_char(calltime,'yyyy-mm-dd') desc ";
		List<Object[]> rst = queryService.query(sql,values);
		for(Object[] obj:rst){
			HniiBehavior hnii = new HniiBehavior();
			try {
				hnii.setCalltime( format.parse(obj[0].toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			hnii.setDatasize(obj[1].toString());
			hnii.setIndustry(obj[2].toString());
			hnii.setBtype(obj[3].toString());
			hnii.setStype(obj[4].toString());
			hnii.setCreate_date(new Date());
			hnii.setModify_date(new Date());
			hniiBehaviorService.save(hnii);
			}
		}
	

	@Override
	public void saveIndustryTypeData() {
		
		for(int i=0;i<2;i++){
			if(i==0){
				List<Object> values = new ArrayList<Object>();
				String  sql =  "select to_char(calltime,'yyyy-mm-dd'),count(1),industry  from hnii_analyze_data  where calltime is not null and industry !='其它' group by to_char(calltime,'yyyy-mm-dd'),industry  order by  to_char(calltime,'yyyy-mm-dd') desc ";
				List<Object[]> rst = queryService.query(sql,values);
				for(Object[] obj:rst){
					Hnii hnii = new Hnii();
					try {
						hnii.setCalltime( format.parse(obj[0].toString()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					hnii.setDatasize(obj[1].toString());
					hnii.setIndustry(obj[2].toString());
					hnii.setDatatype("industry");
					hnii.setCreate_date(new Date());
					hnii.setModify_date(new Date());
					hniiService.save(hnii);
					}
			}if(i==1){
				List<Object> values = new ArrayList<Object>();
				String  sql =  "select to_char(calltime,'yyyy-mm-dd'),count(1),pindustry  from hnii_analyze_data  where calltime is not null and industry ='其它'   group by to_char(calltime,'yyyy-mm-dd'),pindustry  order by  to_char(calltime,'yyyy-mm-dd') desc ";
				List<Object[]> rst = queryService.query(sql,values);
				for(Object[] obj:rst){
					Hnii hnii = new Hnii();
					try {
						hnii.setCalltime( format.parse(obj[0].toString()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					hnii.setDatasize(obj[1].toString());
					hnii.setIndustry(obj[2].toString());
					hnii.setDatatype("industry");
					hnii.setCreate_date(new Date());
					hnii.setModify_date(new Date());
					hniiService.save(hnii);
					}	
			}
		}
		
		}
	
	@Override
	public void saveBtypeTypeData() {
		List<Object> values = new ArrayList<Object>();
		String  sql =  "select to_char(calltime,'yyyy-mm-dd'),count(1),btype  from hnii_analyze_data  where calltime is not null group by to_char(calltime,'yyyy-mm-dd'),btype  order by  to_char(calltime,'yyyy-mm-dd') desc ";
		List<Object[]> rst = queryService.query(sql,values);
		for(Object[] obj:rst){
			Hnii hnii = new Hnii();
			try {
				hnii.setCalltime( format.parse(obj[0].toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			hnii.setDatasize(obj[1].toString());
			hnii.setBtype(obj[2].toString());
			hnii.setDatatype("btype");
			hnii.setCreate_date(new Date());
			hnii.setModify_date(new Date());
			hniiService.save(hnii);
			}
		}
	 
		@Override
		public void saveAlarmTypeData() {
			List<Object> values = new ArrayList<Object>();
			String  sql =  "select to_char(calltime,'yyyy-mm-dd') ,count(1)  from alarm  where calltime is not null group by to_char(calltime,'yyyy-mm-dd') order by  to_char(calltime,'yyyy-mm-dd') desc ";
			List<Object[]> rst = queryService.query(sql,values);
			for(Object[] obj:rst){
				Hnii hnii = new Hnii();
				try {
					hnii.setCalltime( format.parse(obj[0].toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				hnii.setDatasize(obj[1].toString());
				hnii.setDatatype("alarm");
				hnii.setCreate_date(new Date());
				hnii.setModify_date(new Date());
				hniiService.save(hnii);
				}
			}
		
		@Override
		public void saveAddressTypeData() {
			List<Object> values = new ArrayList<Object>();
			String  sql =  "select to_char(calltime,'yyyy-mm-dd'),count(1),baddress,eaddress from hnii_analyze_data  where calltime is not null and length(baddress)>1  and length(eaddress)>1 group by to_char(calltime,'yyyy-mm-dd'),baddress,eaddress order by  to_char(calltime,'yyyy-mm-dd') desc ";
			List<Object[]> rst = queryService.query(sql,values);
			for(Object[] obj:rst){
				Hnii hnii = new Hnii();
				try {
					hnii.setCalltime( format.parse(obj[0].toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				hnii.setDatasize(obj[1].toString());
				if(obj[2]!=null)
				hnii.setBaddress(obj[2].toString());
				if(obj[3]!=null)
				hnii.setEaddress(obj[3].toString());
				hnii.setDatatype("address");
				hnii.setCreate_date(new Date());
				hnii.setModify_date(new Date());
				hniiService.save(hnii);
				}
			}
		
		@Override
		public void saveTimeTypeData() {
			List<Object> values = new ArrayList<Object>();
			String  sql =  "select to_char(calltime,'yyyy-mm-dd'),count(1),time from hnii_analyze_data  where calltime is not null and time is not null and length(time) < 50 group by to_char(calltime,'yyyy-mm-dd'),time order by  to_char(calltime,'yyyy-mm-dd') desc ";
			List<Object[]> rst = queryService.query(sql,values);
			for(Object[] obj:rst){
				Hnii hnii = new Hnii();
				try {
					hnii.setCalltime( format.parse(obj[0].toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				hnii.setDatasize(obj[1].toString());
				if(obj[2]!=null)
				hnii.setTime(obj[2].toString());
				hnii.setDatatype("time");
				hnii.setCreate_date(new Date());
				hnii.setModify_date(new Date());
				hniiService.save(hnii);
				}
			}
		
		@Override
		public void saveCarnoTypeData() {
			List<Object> values = new ArrayList<Object>();
			String  sql =  "select to_char(calltime,'yyyy-mm-dd'),count(1),carno,btype from hnii_analyze_data  where calltime is not null and length(carno)>1 and btype='投诉类'   group by to_char(calltime,'yyyy-mm-dd'),carno,btype  order by  to_char(calltime,'yyyy-mm-dd') desc ";
			List<Object[]> rst = queryService.query(sql,values);
			save(rst);
			String  sql2 =  "select to_char(calltime,'yyyy-mm-dd'),count(1),carno,stype from hnii_analyze_data  where calltime is not null and length(carno)>1 and   stype = '非法营运'  group by to_char(calltime,'yyyy-mm-dd'),carno,stype  order by  to_char(calltime,'yyyy-mm-dd') desc ";
			List<Object[]> rst2 = queryService.query(sql2,values);
			save(rst2);
			}

		private void save(List<Object[]> rst) {
			for(Object[] obj:rst){
				Hnii hnii = new Hnii();
				try {
					hnii.setCalltime( format.parse(obj[0].toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				hnii.setDatasize(obj[1].toString());
				if(obj[2]!=null)
				hnii.setCarno(obj[2].toString());
				hnii.setBtype(obj[3].toString());
				hnii.setDatatype("carno");
				hnii.setCreate_date(new Date());
				hnii.setModify_date(new Date());
				hniiService.save(hnii);
				}
			
		}
		 
}
 
 
	
	 
	 

 
