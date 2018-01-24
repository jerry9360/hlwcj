package com.centit.hlwyw.inner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.core.service.impl.BaseServiceImpl;
import com.centit.hlwyw.inner.entity.Corpgoodinfo;
import com.centit.hlwyw.inner.repositories.CorpgoodinfoRepository;
import com.centit.hlwyw.inner.service.CorpgoodinfoService;

@Service("corpgoodinfoServiceImpl")
public class CorpgoodinfoServiceImpl extends BaseServiceImpl<Corpgoodinfo, String>
		implements CorpgoodinfoService {

	@Resource(name = "queryServiceImpl")
	private QueryService queryService;
	
	@Resource(name = "corpgoodinfoRepository")
	private CorpgoodinfoRepository repository;


	@Resource(name = "corpgoodinfoRepository")
	public void setReposity(
			PagingAndSortingRepository<Corpgoodinfo, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Corpgoodinfo find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpgoodinfo> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpgoodinfo> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpgoodinfo> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Corpgoodinfo> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Corpgoodinfo entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Corpgoodinfo update(Corpgoodinfo entity) {
		Corpgoodinfo corpgoodinfo = super.find(entity.getId());
		super.update(entity);
		return corpgoodinfo;
	}

	@Override
	@Transactional
	public Corpgoodinfo update(Corpgoodinfo entity, String... ignoreProperties) {
		Corpgoodinfo corpgoodinfo = super.update(entity, ignoreProperties);
		return corpgoodinfo;
	}

	@Override
	@Transactional
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	@Transactional
	public void delete(String[] ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	public void delete(Corpgoodinfo entity) {
		super.delete(entity);
	}

	 

	@Override
	public List<Object> findDatas(String datatype,String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from Corpgoodinfo tb  where type   like ");
		String end =  " group by corp_name  order by count(1) desc) where rownum < 21 and corp_name is not null and length(corp_name) > 2" ;
		datatype = "'%"+datatype+"%'";
		sqlBuilder.append(datatype);
		String sql = null;			
			if(begindate!=null){
				sqlBuilder.append(" and to_char(tb.issuedate,'yyyy-mm-dd')  >= " +"'"+begindate+"'");
				if( enddate!=null){
					sqlBuilder.append(" and to_char(tb.issuedate,'yyyy-mm-dd')   <= " +"'"+enddate+"'");
				}
			}
			if(begindate==null&&enddate!=null){
				sqlBuilder.append(" and to_char(tb.issuedate,'yyyy-mm-dd') <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}

	@Override
	public Page<Corpgoodinfo> findList(String datatype,String corpname,Pageable pageable) {
		return repository.findList(datatype,corpname, pageable);
	}

}
