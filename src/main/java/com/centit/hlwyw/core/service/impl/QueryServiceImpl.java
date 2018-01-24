package com.centit.hlwyw.core.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.hlwyw.core.service.QueryService;
import com.centit.hlwyw.inner.controller.UrlSourceController;


@Service("queryServiceImpl")
public class QueryServiceImpl implements QueryService {
	private static Logger log = Logger.getLogger(QueryServiceImpl.class);  

	
	
	@PersistenceContext(unitName = "hlwyw")
	private EntityManager entityManager;

	/**
	 * select 
	 */
	private static final  String SELECT = "select ";
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object> queryForObject(String sql, List<Object> values) {
		Query query = entityManager.createNativeQuery(sql);
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + 1, values.get(i));
		}
		List<Object> rst = query.getResultList();
		entityManager.clear();
		return rst;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> query(String sql, List<Object> values) {
		Query query = entityManager.createNativeQuery(sql);
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + 1, values.get(i));
		}
		List<Object[]> result = query.getResultList();
		return result;
	}
	
	@Override
	@Transactional
	public Object queryObject(String sql){
		Query query = entityManager.createNativeQuery(sql);
		return query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object> queryObjectBySql(String sql){
		Query query = entityManager.createNativeQuery(sql);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public Integer executeSql(String sql){
		Query query = entityManager.createNativeQuery(sql);
		return query.executeUpdate();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public Page<Object> queryObjectForPage(String columnsql,String sql,String order, List<Object> values,
			Pageable pageable) {
		Query query =  entityManager.createNativeQuery("select count(*) " + sql);
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + 1, values.get(i));
		}
		Integer total = ((BigDecimal)query.getSingleResult()).intValue();
		query =  entityManager.createNativeQuery(SELECT + columnsql + " " + sql + " " + order);
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + 1, values.get(i));
		}
		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<Object> content = total > pageable.getOffset() ? query.getResultList() : Collections.<Object> emptyList();
		return new PageImpl<Object>(content, pageable, total);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public Page<Object> queryForPage(String sql, String order,List<Object> values,Class<?> cla,Pageable pageable) {
		Query query =  entityManager.createNativeQuery("select count(*) " + sql);
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + 1, values.get(i));
		}
		List<String> columns = initColumnNames(cla);
		String columnsql = initColumnsql(columns);
		Integer total = ((BigDecimal)query.getSingleResult()).intValue();
		
		query =  entityManager.createNativeQuery(SELECT + columnsql + " " + sql + " " + order);
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + 1, values.get(i));
		}
		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<Object[]> content = total > pageable.getOffset() ? query.getResultList() : Collections.<Object[]> emptyList();
		List<Object> contentval = null;
		try {
			contentval = zuzhuanData(cla,columns,content);
		} catch (NoSuchFieldException e1) {
			log.error(e1.getMessage());log.info(e1);
		} catch (SecurityException e1) {
			log.error(e1.getMessage());log.info(e1);
 		} catch (InstantiationException e1) {
 			log.error(e1.getMessage());log.info(e1);
 	 	} catch (IllegalAccessException e1) {
 	 		log.error(e1.getMessage());log.info(e1);
 	 	} catch (NoSuchMethodException e1) {
 	 		log.error(e1.getMessage());log.info(e1);
 	 	} catch (IllegalArgumentException e1) {
 	 		log.error(e1.getMessage());log.info(e1);
 	 	} catch (InvocationTargetException e1) {
 	 		log.error(e1.getMessage());log.info(e1);
 	 	} catch (ParseException e1) {
 	 		log.error(e1.getMessage());log.info(e1);
 	 	}
		return new PageImpl<Object>(contentval, pageable, total);
	}
	
	/**
	 * @param c
	 * @return
	 */
	private List<String> initColumnNames(Class<?> c){
		Field[] fields = c.getDeclaredFields();
		List<String> columnlist = new ArrayList<>();
		Column a = null;
		for (Field f : fields) {
			a = f.getAnnotation(Column.class);
			if(a!=null){
				columnlist.add(a.name());
			}
		}
		return columnlist;
	}
	
	/**
	 * @param columns
	 * @return
	 */
	private String initColumnsql(List<String> columns){
		StringBuilder sb = new StringBuilder();
		for(String col:columns){
			sb.append("tbl.") .append(col) .append(",");
		}
		String sqlcolumn = sb.toString();
		return sqlcolumn.substring(0,sqlcolumn.length()-1);
	}
	
	/**
	 * @param c
	 * @param columns
	 * @param objs
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ParseException
	 */
	private List<Object> zuzhuanData(Class<?> c,List<String> columns,List<Object[]> objs) 
			throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, ParseException{
		List<Object> list = new ArrayList<Object>();
		Map<String,Class<?>>  colTypeMap = getColumnClass(c, columns);
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
 		for(Object[] obj:objs){
			Object o = c.newInstance();
			for(int i=0;i<columns.size();i++){
				Method m = c.getDeclaredMethod(parseColumn(columns.get(i)),colTypeMap.get(columns.get(i)));
				if(m!=null&&obj[i]!=null){
					if(obj[i] instanceof Timestamp) {
						m.invoke(o,sdf.parse(sdf.format((Timestamp) obj[i])));
					}else if(obj[i] instanceof BigInteger){
						m.invoke(o, ((BigInteger)obj[i]).longValue());
					}else if(obj[i] instanceof Integer){
						m.invoke(o, ((Integer)obj[i]).longValue());
					}else if(obj[i] instanceof BigDecimal){
						m.invoke(o, ((BigDecimal)obj[i]).doubleValue());
					}else if(obj[i] instanceof Double){
						m.invoke(o, (Double)obj[i]);
					}else if(obj[i] instanceof Date){
						m.invoke(o, (Date)obj[i]);
					}else if(obj[i] instanceof String){
						m.invoke(o, (String)obj[i]);
					}else if(obj[i] instanceof Character){
						m.invoke(o, String.valueOf(obj[i]));
					}
				}
			}
			list.add(o);
		}
		return list;
	}
	
	private String parseColumn(String col){
		StringBuilder sb = new StringBuilder("set");
		sb.append(col.substring(0, 1).toUpperCase());
		sb.append(col.substring(1, col.length()));
		return sb.toString();
	}
	
	/**
	 * 此方法先只适用于本系统，具体映射要根据不同数据库确定
	 * @param c
	 * @param column
	 * @return
	 * @throws NoSuchFieldException
 	 */
	private Map<String,Class<?>> getColumnClass(Class<?> c,List<String> columns) throws NoSuchFieldException {
  		Map<String,Class<?>> types = new HashMap<>();
		for(String column:columns){
  			types.put(column, c.getDeclaredField(column).getType());
		}
		return types;
	}
	
}
