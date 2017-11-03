package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerService;

public interface ICustomerService2Service {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param customerService2Name 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService2);

	ServerResponse delete(String ids);

	ServerResponse addCustomerService2(CustomerService customerService2);

	ServerResponse updateCustomerService2(CustomerService customerService2);

}
