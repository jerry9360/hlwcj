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
import com.centit.hlwyw.inner.entity.Corpbadinfo;
import com.centit.hlwyw.inner.repositories.CorpbadinfoRepository;
import com.centit.hlwyw.inner.service.CorpbadinfoService;

@Service("corpbadinfoServiceImpl")
public class CorpbadinfoServiceImpl extends BaseServiceImpl<Corpbadinfo, String>
		implements CorpbadinfoService {
	
	@Resource(name = "queryServiceImpl")
	private QueryService queryService;

	@Resource(name = "corpbadinfoRepository")
	private CorpbadinfoRepository repository;


	@Resource(name = "corpbadinfoRepository")
	public void setReposity(
			PagingAndSortingRepository<Corpbadinfo, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Corpbadinfo find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpbadinfo> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpbadinfo> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Corpbadinfo> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Corpbadinfo> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	public void save(Corpbadinfo entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	public Corpbadinfo update(Corpbadinfo entity) {
		Corpbadinfo corpbadinfo = super.find(entity.getId());
		super.update(entity);
		return corpbadinfo;
	}

	@Override
	@Transactional
	public Corpbadinfo update(Corpbadinfo entity, String... ignoreProperties) {
		Corpbadinfo corpbadinfo = super.update(entity, ignoreProperties);
		return corpbadinfo;
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
	public void delete(Corpbadinfo entity) {
		super.delete(entity);
	}

	@Override
	public List<Object> findDatas(String begindate, String enddate) {
		StringBuilder sqlBuilder = new StringBuilder("select * from  (select  corp_name,count(1)from corpbadinfo tb   ");
		String end =  " group by corp_name  order by count(1) desc) where rownum < 21 and corp_name is not null and length(corp_name) > 2" ;
		String sql = null;			
			if(begindate!=null){
				sqlBuilder.append(" where ");
				sqlBuilder.append(" to_char(tb.issuedate,'yyyy-mm-dd') >= " +"'"+begindate+"'");
				if( enddate!=null){
					sqlBuilder.append(" and to_char(tb.issuedate,'yyyy-mm-dd')   <= " +"'"+enddate+"'");
				}
			}
			if(begindate==null&&enddate!=null){
				sqlBuilder.append(" where ");
				sqlBuilder.append(" to_char(tb.issuedate,'yyyy-mm-dd')  <= " +"'"+enddate+"'");
			}
			sqlBuilder.append(end);
			sql = sqlBuilder.toString();
		List<Object> rst = queryService.queryObjectBySql(sql);
		return rst;
	}

	@Override
	public Page<Corpbadinfo> findList(String corpname,Pageable pageable) {
		return repository.findList(corpname, pageable);
	}

}
