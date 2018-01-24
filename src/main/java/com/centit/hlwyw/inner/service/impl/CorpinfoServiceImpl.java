package com.centit.hlwyw.inner.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Corpinfo;
import com.centit.hlwyw.inner.repositories.CorpinfoRepository;
import com.centit.hlwyw.inner.service.CorpinfoService;

@Service("corpinfoServiceImpl")
public class CorpinfoServiceImpl extends BaseServiceImpl<Corpinfo, String>
		implements CorpinfoService {
	
	@Resource(name = "corpinfoRepository")
	private CorpinfoRepository repository;
	

	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "corpinfoRepository")
	public void setReposity(
			PagingAndSortingRepository<Corpinfo, String> repository) {
		super.setReposity(repository);
	}
	
	@Override
	@Transactional
	public Corpinfo update(Corpinfo entity){
		super.update(entity);
		return entity;
	}
	
	@Override
	@Transactional
	public List<Corpinfo> findCorpinfo(Pageable pageable) {
		return repository.findCorpinfo(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Corpinfo> findSearch(String corp_name, String corp_short,String industry,Pageable pageable) {
		Page<Corpinfo>  page=null;
		if(StringUtils.isNotBlank(corp_name)){
			if(StringUtils.isNotBlank(corp_short)){
				if(StringUtils.isNotBlank(industry)){
					page=repository.findPageByCorp_nameCorp_shortIndustry("%"+corp_name+"%","%"+corp_short+"%",industry, pageable);
				}else{
					page=repository.findPageByCorp_nameCorp_short("%"+corp_name+"%","%"+corp_short+"%", pageable);
				}
			}else{
				if(StringUtils.isNotBlank(industry)){
					page=repository.findPageByCorp_nameIndustry("%"+corp_name+"%",industry, pageable);
				}else{
					page=repository.findPageByCorp_name("%"+corp_name+"%", pageable);
				}
			}
		}else{
			if(StringUtils.isNotBlank(corp_short)){
				if(StringUtils.isNotBlank(industry)){
					page=repository.findPageByCorp_shortIndustry("%"+corp_short+"%",industry, pageable);
				}else{
					page=repository.findPageByCorp_short("%"+corp_short+"%", pageable);
				}
			}else{
				if(StringUtils.isNotBlank(industry)){
					page=repository.findPageByIndustry(industry, pageable);
				}else{
					page=repository.findPage( pageable);
				}
			}
		}
		return page;
 	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Corpinfo> findAllUnTag(String istag){
		return repository.findAllUnTag(istag);
	}

	@Override
	public List<Object[]> findList(String corp_name,String corp_short,String industry) {
		List<Object[]> result=new ArrayList<>();
		Long total=null;
		StringBuffer sqlData =new StringBuffer();
		StringBuffer sqlCount =new StringBuffer();
		List<Object> values = new ArrayList<Object>();
		sqlCount.append("select count(*) from corpInfo tbl where 1=1 ");
		sqlData.append("select * from (select a1.*,rownum rn from (select tbl.corp_id, tbl.corp_name,tbl.credit_code,tbl.corp_short,tbl.industry from corpInfo tbl where 1=1 ");
			if(StringUtils.isNotBlank(corp_name)){
				sqlCount.append("and tbl.corp_name like ? ");
				sqlData.append("and tbl.corp_name like ? ");
				corp_name = "%"+corp_name+"%";
				values.add(corp_name);
			}
			if(StringUtils.isNotBlank(corp_short)){
				sqlCount.append("and tbl.corp_short like ? ");
				sqlData.append("and tbl.corp_short like ? ");
				corp_short ="%" + corp_short + "%";
				values.add(corp_short);
			}
			if(StringUtils.isNotBlank(industry)){
				sqlCount.append("and tbl.industry like ? ");
				sqlData.append("and tbl.industry like ? ");
				industry = "%" + industry + "%";
				values.add(industry);
			}
			sqlData.append(") a1  where rownum <= ? )  where rn > ?");
		Object rst=queryService.queryForObject(sqlCount.toString(), values).get(0);
		if(rst!=null){
			total=((BigDecimal)rst).longValue();
		}
		int pagesize=0;
		if(total%200000==0){
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

}
