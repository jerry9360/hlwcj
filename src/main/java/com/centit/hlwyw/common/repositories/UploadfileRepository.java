package com.centit.hlwyw.common.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.centit.hlwyw.common.entity.Uploadfile;

public interface UploadfileRepository extends PagingAndSortingRepository<Uploadfile, String> {
	
	public List<Uploadfile> findByIson(String ison);
	
	@Query(value="update uploadfile set ison = ?1 where id in ?2",nativeQuery=true)
	@Modifying
	public void updateFileIson(String ison,String[] ids);
	
	@Query(value="update uploadfile set ison = ?1 where id = ?2",nativeQuery=true)
	@Modifying
	public void updateFileIson(String ison,String ids);
	
	@Query(value="delete uploadfile where ison = '0'",nativeQuery=true)
	@Modifying
	public void deleteUnIsonFile();
}

