package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerLossMeasure;

public interface ICustomerLossMeasureService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param saleChanceName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */

	ServerResponse delete(String ids);

	List<CustomerLossMeasure> findAll(Integer id);

	ServerResponse add(CustomerLossMeasure customerLossMeasure);

	ServerResponse update(CustomerLossMeasure customerLossMeasure);

	ServerResponse deleteById(Integer id);



}
