package com.centit.hlwyw.solr.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.centit.hlwyw.inner.entity.Hnii_analyze_data;
import com.centit.hlwyw.inner.entity.Servicedata;
import com.centit.hlwyw.solr.repositories.HniianalyzedataSolrRepository;
import com.centit.hlwyw.solr.repositories.ServicedataSolrRepository;
import com.centit.hlwyw.solr.service.SolrService;
import org.springframework.data.domain.Sort;

@Service("solrServiceImpl")
public class SolrServiceImpl implements SolrService {
	
	@Resource(name = "servicedataSolrRepository")
	private ServicedataSolrRepository servicedataSolrRepository;
	
	@Resource(name = "hniianalyzedataSolrRepository")
	private HniianalyzedataSolrRepository hniianalyzedataSolrRepository;
	
	//solr 日期格式:
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");  
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//开始日期到结束日期
	String time = "["+sdf.format(new Date())+" TO "+sdf.format(new Date())+"]";

	public Page<Servicedata> findServiceDataByField(String field, Pageable pageable) {
		Page<Servicedata> page=null;
		if(StringUtils.isBlank(field)){
			field = "*";
		}else{
			String[] fieldarr = field.split("\\+");
			field ="'"+ fieldarr[0] +"'";
			if(fieldarr.length>1){
				for(int i=1; i<fieldarr.length;i++){
					field = field + " AND " + "'"+fieldarr[i]+"'";
				}
			}
			field = "text:" + field ;
		}
		page=servicedataSolrRepository.find(field, pageable);
		return page;
	}


	public Page<Hnii_analyze_data> findDatas(String btype, String stype, String industry, String myid, Date begindate,
			Date enddate, Pageable pageable) {
		Page<Hnii_analyze_data> page=null;
		String field = "";
		if(btype!=null&&!("".equals(btype))) {
			field = field+ "btype:"+btype+",";
		}if(stype!=null&&!("".equals(stype))) {
			field = field+  "stype:"+stype+",";
		}if(industry!=null&&!("".equals(industry))) {
			field = field+"industry:"+industry+",";
		}if(myid!=null&&!("".equals(myid))) {
			field = field+  "myid:*"+myid+"* ,";
		}if(begindate==null||"".equals(begindate)) {
			try {
				begindate = format.parse("2013-12-29 00:00:00");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}if(enddate==null||"".equals(enddate)) {
			enddate = new Date();
		}  
		field = field+ "calltime:["+sdf.format(begindate)+" TO "+sdf.format(enddate)+"]";
		String[] fieldarr = field.split("\\,");
		if(fieldarr.length>=0){
			field = "";
			field = field +fieldarr[0];
			for(int i=1; i<fieldarr.length;i++){
				field = field + " AND "+fieldarr[i];
			}
		} 
		if(field==null||"".equals(field)){
			field = "*:*";
		}
//		field = field + " &sort=calltime desc, score desc";
		Sort sort = new Sort(Sort.Direction.DESC, "calltime");
		//分页
		int max = pageable.getPageSize();
		int min = pageable.getPageNumber();
		Pageable pages = new PageRequest(min, max, sort);
		page=hniianalyzedataSolrRepository.find(field, pages);
		return page;
	}

	 private Sort sortByIdDesc() {
		Sort sort = new Sort(Sort.Direction.DESC, "calltime");
		//分页
		Pageable page = new PageRequest(0, 10, sort);
	        return new Sort(Sort.Direction.DESC, "calltime");
	    }

	@Override
	public Hnii_analyze_data find(String id) {
		Hnii_analyze_data hnii = null;
		String field = "";
		field = "id:"+id;
		hnii = hniianalyzedataSolrRepository.find(field);
		return hnii;
	}


	@Override
	public Page<Hnii_analyze_data> findKeyWord(String btype, String keyword, Pageable pageable) {
		Page<Hnii_analyze_data> page=null;
		String field = "";
		if(btype==null&&keyword==null){
			field = "*:*";
		}if(btype!=null&&!("".equals(btype))) {
			field = field+ "btype:"+btype+",";
		}if(keyword!=null&&!("".equals(keyword))) {
			String key = getKeyWord(keyword);
			field = field+key;
		}  
		String[] fieldarr = field.split("\\,");
		if(fieldarr.length>=0){
			field = "";
			field = field +fieldarr[0];
			for(int i=1; i<fieldarr.length;i++){
				field = field + " AND "+fieldarr[i];
			}
		} 
		if(field==null||"".equals(field)){
			field = "*:*";
		}
//		field = field + " &sort=calltime desc";
		Sort sort = new Sort(Sort.Direction.DESC, "calltime");
		//分页
		int max = pageable.getPageSize();
		int min = pageable.getPageNumber();
		Pageable pages = new PageRequest(min, max, sort);
		page=hniianalyzedataSolrRepository.find(field, pages);
		return page;
	}


	private String getKeyWord(String keyword) {
		String key = "";
		String[] str = keyword.split("\\*");
		for(String s:str){
			key = key+"content:*"+s+"* ,";
		}
		return key;
	}
	
	
	/*@Override
	public Page<Corpview> findCorpByField(String field,Pageable pageable){
		Page<Corpview> page=null;
		if(StringUtils.isBlank(field)){
			field = "*";
		}else{
			field = "text:\"" + field + "\"";
		}
		page=corpRepository.find(field, pageable);
		if(page!=null){
			List<Corpview> corpviewlist=page.getContent();
			if(corpviewlist!=null&&!corpviewlist.isEmpty()){
				for(Corpview corpview:corpviewlist){
					String corpid=corpview.getId();
					String industry=corpview.getIndustry();
					List<Date> endtimelist=black_corpRepository.findEndtimeByCorpidIndustry(corpid,industry);
					if(endtimelist!=null&&!endtimelist.isEmpty()){
						corpview.setEndtimelist(endtimelist);
					}
				}
			}
		}
		return page;
	}*/
	
	
	
}
