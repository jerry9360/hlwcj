package com.centit.hlwyw.inner.service;

import java.util.List;

import com.centit.hlwyw.core.service.BaseService;
import com.centit.hlwyw.inner.entity.HniiBehavior;

public interface HniiBehaviorService extends BaseService<HniiBehavior, String> {

	void deleteAll();

	  List<Object[]> findComplaint();

	  List<Object[]> findConsult();

}
