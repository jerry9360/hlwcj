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
import com.centit.hlwyw.inner.entity.Vehicle_info;
import com.centit.hlwyw.inner.repositories.Vehicle_infoRepository;
import com.centit.hlwyw.inner.service.Vehicle_infoService;

@Service("vehicle_infoServiceImpl")
public class Vehicle_infoServiceImpl extends BaseServiceImpl<Vehicle_info, String>
		implements Vehicle_infoService {

	@Resource(name = "vehicle_infoRepository")
	private Vehicle_infoRepository repository;
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	

	@Resource(name = "vehicle_infoRepository")
	public void setReposity(
			PagingAndSortingRepository<Vehicle_info, String> repository) {
		super.setReposity(repository);
	}

 
	@Override
	@Transactional(readOnly = true)
	public Page<Vehicle_info> findSearch(String vehicle_no, String corp_name,Pageable pageable) {
		Page<Vehicle_info>  page=null;
			if(StringUtils.isNotBlank(vehicle_no)){
				if(StringUtils.isNotBlank(corp_name)){
					page=repository.findPageByVehicle_noCorp_name("%"+vehicle_no+"%","%"+corp_name+"%", pageable);
				}else{
					page=repository.findPageByvehicle_no("%"+vehicle_no+"%", pageable);
				}
			}else{
				if(StringUtils.isNotBlank(corp_name)){
					page=repository.findPageBycorp_name("%"+corp_name+"%", pageable);
				}else{
					page=repository.findPageAll( pageable);
				}
			}
	
		return page;
 	}


	 
	@Override
	public List<Object[]> findExcelList(String corp_name) {
		List<Object[]> result=new ArrayList<>();
		Long total=null;
		StringBuffer sqlData =new StringBuffer();
		StringBuffer sqlCount =new StringBuffer();
		List<Object> values = new ArrayList<Object>();
		sqlCount.append("select count(*) from Vehicle_info tbl where 1=1 ");
		sqlData.append("select * from (select a1.*,rownum rn from (select tbl.vehicle_id, tbl.vehicle_no,tbl.plate_color_name,tbl.corp_id,tbl.corp_name from Vehicle_info tbl where 1=1 ");
			if(StringUtils.isNotBlank(corp_name)){
				sqlCount.append("and tbl.corp_name like ? ");
				sqlData.append("and tbl.corp_name like ? ");
				corp_name = "%"+corp_name+"%";
				values.add(corp_name);
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
