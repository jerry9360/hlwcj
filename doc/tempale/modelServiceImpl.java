package {$packagename}.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centit.jsmsa.core.service.impl.BaseServiceImpl;
import {$packagename}.entity.{$table.upcode};
import {$packagename}.repositories.{$table.upcode}Repository;
import {$packagename}.service.{$table.upcode}Service;

@Service("{$table.code}ServiceImpl")
public class {$table.upcode}ServiceImpl extends BaseServiceImpl<{$table.upcode}, String>
		implements {$table.upcode}Service {

	@Resource(name = "{$table.code}Repository")
	private {$table.upcode}Repository repository;


	@Resource(name = "{$table.code}Repository")
	public void setReposity(
			PagingAndSortingRepository<{$table.upcode}, String> repository) {
		super.setReposity(repository);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("{$table.code}")
	public {$table.upcode} find(String id) {
		return super.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("{$table.code}")
	public List<{$table.upcode}> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("{$table.code}")
	public List<{$table.upcode}> findList(String[] ids) {
		return super.findList(ids);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("{$table.code}")
	public List<{$table.upcode}> findList(Sort sort) {
		return super.findList(sort);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("{$table.code}")
	public Page<{$table.upcode}> findPage(Pageable pageable) {
		return super.findPage(pageable);
	}

	@Override
	@Transactional
	@CacheEvict(value = "{$table.code}", allEntries = true)
	public void save({$table.upcode} entity) {
		super.save(entity);
	}

	@Override
	@Transactional
	@CacheEvict(value = "{$table.code}", allEntries = true)
	public {$table.upcode} update({$table.upcode} entity) {
		{$table.upcode} {$table.code} = super.find(entity.getId());
		super.update(entity);
		return {$table.code};
	}

	@Override
	@Transactional
	@CacheEvict(value = "{$table.code}", allEntries = true)
	public {$table.upcode} update({$table.upcode} entity, String... ignoreProperties) {
		{$table.upcode} {$table.code} = super.update(entity, ignoreProperties);
		return {$table.code};
	}

	@Override
	@Transactional
	@CacheEvict(value = "{$table.code}", allEntries = true)
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = "{$table.code}", allEntries = true)
	public void delete(String[] ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	@CacheEvict(value = "{$table.code}", allEntries = true)
	public void delete({$table.upcode} entity) {
		super.delete(entity);
	}


}
