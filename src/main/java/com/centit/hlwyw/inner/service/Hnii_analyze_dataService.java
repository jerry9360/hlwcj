package com.centit.hlwyw.inner.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.ModelMap;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.Hnii_analyze_data;

public interface Hnii_analyze_dataService extends BaseService<Hnii_analyze_data, String> {

	public Page<Object> findDatas(String btype,String stype,String industry,String content,Date begindate,Date enddate,Pageable pageable);
	
	public List<Object[]> findDatasList(String btype,String stype,String industry,String content,Date begindate,Date enddate);
	
	public List<Object[]> findYears();

	/**
	 * @return
	 */
	public Object[] countHniiindustry();

	/**
	 * @return
	 */
	public Object[] countHniibtype();
	
	public List<Object> findLocationDatas(String begindate, String enddate);

	public Page<Hnii_analyze_data> findList(String baddress, Pageable pageable);

	public List<Object> findComplaintCarnoDatas(String begindate, String enddate);

	Page<Hnii_analyze_data> findCarNoList(String carno, Pageable pageable);

	List<Object> findIllegalCarnoDatas(String begindate, String enddate);

	public Object[] getAxis(List<Object> page);

	public List<Object> findIndustryAndCount();

	public List<Object> findBusinessAndCount();

	 

	public void init_analyzeIndustry(String datatype, String timetype, String begindate, String enddate, ModelMap model);

	public void init_analyzeBehavior( String industry,String btype, String timetype, String begindate,
			String enddate, ModelMap model);


	public void saveHniiTypeData();

	public void saveAlarmTypeData();

	public void saveAddressTypeData();
	
	public void saveTimeTypeData();
	
	public void saveCarnoTypeData();

	public void saveIndustryTypeData();
	
	public void saveBtypeTypeData();

}
