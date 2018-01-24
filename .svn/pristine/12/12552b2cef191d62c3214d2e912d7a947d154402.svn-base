package com.centit.hlwyw.inner.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.inner.entity.Judgedoc;
import com.centit.hlwyw.inner.repositories.JudgeDocRepository;
import com.centit.hlwyw.inner.service.JudgeDocService;

@Service("judgeDocServiceImpl")
public class JudgeDocServiceImpl extends BaseServiceImpl<Judgedoc, String>
		implements JudgeDocService {
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	@Resource(name = "judgeDocRepository")
	private JudgeDocRepository repository;


	@Resource(name = "judgeDocRepository")
	public void setReposity(
			PagingAndSortingRepository<Judgedoc, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Judgedoc find(String id) {
		return super.find(id);
	}


	@Override
	@Transactional(readOnly = true)
	@Cacheable("judgedoc")
	public Page<Object> findSearch(String corp_name,String industry,Pageable pageable) {
		/*corp_name =StringUtils.isBlank(corp_name)?"%%":"%"+corp_name+"%";
		industry =StringUtils.isBlank(industry)?"%%":"%"+industry+"%";
		if(StringUtils.isBlank(corp_name)&&StringUtils.isBlank(industry)){
			repository.findSearchAll(pageable);
		}else if(StringUtils.isNotBlank(corp_name)&&StringUtils.isBlank(industry)){
			repository.findSearchCorp_name(corp_name, pageable);
		}else if(StringUtils.isBlank(corp_name)&&StringUtils.isNotBlank(industry)){
			return repository.findSearchIndustry(industry, pageable);
		}
		return repository.findSearch(corp_name, industry, pageable);*/
		StringBuilder sqlBuilder = new StringBuilder("from Judgedoc tbl where tbl.state='1' ");
		String order = " ";
		List<Object> values = new ArrayList<Object>();
			if(StringUtils.isNotBlank(corp_name)){
				sqlBuilder.append(" and tbl.corp_name like ? ");
				corp_name = "%"+corp_name+"%";
				values.add(corp_name);
			}
			if(StringUtils.isNotBlank(industry)){
				sqlBuilder.append(" and tbl.industry like ? ");
				industry = "%"+industry+"%";
				values.add(industry);
			}
			sqlBuilder.append(" order by releasetime desc");
		return queryService.queryForPage(sqlBuilder.toString(), order, values, Judgedoc.class, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public String findOneMonth(List<String> dateliststr, String dateFrom,String dateNow) {
		String sql="select  to_char(create_date,'YYYY/MM/DD'),nvl(count(*),0)  "
				+ "from judgeDoc  p "
				+ "where p.create_date>= to_date('"+dateFrom+"','yyyy/mm/dd')  and p.create_date<= to_date('"+dateNow+"','yyyy/mm/dd')  "
				+ "group by to_char(create_date,'YYYY/MM/DD') " ;
 		List<Object> rst = queryService.queryObjectBySql(sql);
		Map<String,String> rstmap=new HashMap<String,String>();
		for(Object rs:rst){
			Object[]r=(Object[]) rs;
			rstmap.put(r[0].toString(), r[1].toString());
		}
 		String crt_seriesdata="[";
		for(String datestr:dateliststr){
			if(rstmap.get(datestr)==null){
				crt_seriesdata=crt_seriesdata+"'0',";
			}else{
				crt_seriesdata=crt_seriesdata+"'"+rstmap.get(datestr)+"',";
			}
		}
		crt_seriesdata=crt_seriesdata.substring(0,crt_seriesdata.length()-1)+"]";
		return crt_seriesdata;
	}

	@Override
	public Page<Judgedoc> findWash(String corp_name, String industry,Pageable pageable) {
		return repository.findWash(corp_name, industry, pageable);
	}

	@Override
	public List<Object[]> stat() {
		return repository.statByType();
	}
	/** 1刑事案件 **/
	public static final String JUDGE_DOC_HIDCASETYPE_XINGSHI="1";
	/** 2民事案件 **/
	public static final String JUDGE_DOC_HIDCASETYPE_MINGSHI="2";
	/** 3行政案件 **/
	public static final String JUDGE_DOC_HIDCASETYPE_XINGZHENG="3";
	/** 4赔偿案件 **/
	public static final String JUDGE_DOC_HIDCASETYPE_PEICHANG="4";
	/** 5执行案件 **/
	public static final String JUDGE_DOC_HIDCASETYPE_ZHIXING="5";

	@Override
	public Object[] statByType() {
		List<Object[]> countJudgedoc=repository.statByType();
		Object[] datajudge = new Object[3];
		StringBuilder desc = new StringBuilder("[");
		StringBuilder count = new StringBuilder("[");
		Long total=0l;
		if(countJudgedoc!=null&&!countJudgedoc.isEmpty()){
			for(Object[] countt:countJudgedoc){
				if(Constantval.JUDGE_DOC_HIDCASETYPE_XINGSHI.equals(countt[0].toString())){
					desc.append("'刑事案件',");
				}else if(Constantval.JUDGE_DOC_HIDCASETYPE_MINGSHI.equals(countt[0].toString())){
					desc.append("'民事案件',");
				}else if(Constantval.JUDGE_DOC_HIDCASETYPE_XINGZHENG.equals(countt[0].toString())){
					desc.append("'行政案件',");
				}else if(Constantval.JUDGE_DOC_HIDCASETYPE_PEICHANG.equals(countt[0].toString())){
					desc.append("'赔偿案件',");
				}else if(Constantval.JUDGE_DOC_HIDCASETYPE_ZHIXING.equals(countt[0].toString())){
					desc.append("'执行案件',");
				}
				count.append(countt[1]+",");
				total=total+Long.valueOf(countt[1].toString());
			}
			desc.deleteCharAt(desc.length()-1);
			count.deleteCharAt(count.length()-1);
		}
		desc.append("]");
		count.append("]");
		datajudge[0] = desc.toString();
		datajudge[1] = count.toString();
		datajudge[2] =total;
		return datajudge;
	}

	@Override
	public List<Object> findDatas(String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from judgedoc tb   ");
		String end =  " group by corp_name  order by count(1) desc) where rownum < 21 and corp_name is not null and length(corp_name) > 2" ;
		String sql = null;			
			if(begindate!=null){
				sqlBuilder.append(" where ");
				sqlBuilder.append(" tb.releasetime >=  "+"'"+begindate+"'" );
				if( enddate!=null){
					sqlBuilder.append(" and tb.releasetime <= "+"'"+enddate+"'");
				}
			}
			if(begindate==null&&enddate!=null){
				sqlBuilder.append(" where ");
				sqlBuilder.append(" tb.releasetime <= "+"'"+enddate+"'");
			}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}
	
	@Override
	public Page<Judgedoc> findList(String corpname,Pageable pageable) {
		return repository.findList(corpname, pageable);
	}
	
	@Override
	@Cacheable("judgedocanalyze")
	public List<Object> findDatas( ) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from judgedoc tb group by corp_name  order by count(1) desc) where rownum < 6 and corp_name is not null and length(corp_name) > 2  ");
		String sql = null;			
		sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}
	
}
