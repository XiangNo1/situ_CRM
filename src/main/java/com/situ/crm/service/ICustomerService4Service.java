package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerService;

public interface ICustomerService4Service {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param customerService4Name 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService4);

	ServerResponse delete(String ids);

	ServerResponse addCustomerService4(CustomerService customerService4);

	ServerResponse updateCustomerService4(CustomerService customerService4);

}
