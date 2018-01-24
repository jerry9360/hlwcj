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
import com.centit.hlwyw.inner.entity.Personinfo;
import com.centit.hlwyw.inner.repositories.PersoninfoRepository;
import com.centit.hlwyw.inner.service.PersoninfoService;

@Service("personinfoServiceImpl")
public class PersoninfoServiceImpl extends BaseServiceImpl<Personinfo, String>
		implements PersoninfoService {
	
	@Resource(name = "personinfoRepository")
	private PersoninfoRepository repository;
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "personinfoRepository")
	public void setRepository(
			PagingAndSortingRepository<Personinfo, String> repository) {
		super.setReposity(repository);
	}
	
	@Override
	@Transactional
	public Personinfo update(Personinfo entity){
		super.update(entity);
		return entity;
	}
	
	@Override
	@Transactional
	public List<Personinfo> findPersoninfo(Pageable pageable) {
		return repository.findPersoninfo(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Personinfo> findSearchname(String name,String card_no,String industry,Pageable pageable) {
		if(StringUtils.isNotBlank(industry)){
			return repository.findSearchname(name,card_no,industry,pageable);
		}else{
			return repository.findSearchname(name,card_no,pageable);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Personinfo> findPersoninfoUnTag(String istag){
		return repository.findPersoninfoUnTag(istag);
	}

	@Override
	public List<Object[]> findList(String name, String cardno, String industry) {
		List<Object[]> result=new ArrayList<>();
		Long total=null;
		StringBuffer sqlData =new StringBuffer();
		StringBuffer sqlCount =new StringBuffer();
		List<Object> values = new ArrayList<Object>();
		sqlCount.append("select count(*) from Personinfo tbl where 1=1 ");
		sqlData.append("select * from (select a1.*,rownum rn from (select tbl.perid, tbl.name,tbl.sex,tbl.card_no,tbl.industry from personInfo tbl where 1=1 ");
			if(StringUtils.isNotBlank(name)){
				sqlCount.append("and tbl.name like ? ");
				sqlData.append("and tbl.name like ? ");
				name = "%"+name+"%";
				values.add(name);
			}
			if(StringUtils.isNotBlank(cardno)){
				sqlCount.append("and tbl.card_no like ? ");
				sqlData.append("and tbl.card_no like ? ");
				cardno ="%" + cardno + "%";
				values.add(cardno);
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
