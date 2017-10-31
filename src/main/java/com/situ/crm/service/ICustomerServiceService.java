package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerService;

public interface ICustomerServiceService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param customerServiceName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService);

	ServerResponse delete(String ids);

	ServerResponse addCustomerService(CustomerService customerService);

	ServerResponse updateCustomerService(CustomerService customerService);

	List<CustomerService> findRoleName();

}
