package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerContact;

public interface ICustomerContactService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param saleChanceName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */

	ServerResponse delete(String ids);

	List<CustomerContact> findAll(Integer id);

	ServerResponse add(CustomerContact customerContact);

	ServerResponse update(CustomerContact customerContact);

	ServerResponse deleteById(Integer id);



}
