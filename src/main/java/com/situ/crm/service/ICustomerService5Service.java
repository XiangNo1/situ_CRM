package com.situ.crm.service;

import java.util.Date;
import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerService;

public interface ICustomerService5Service {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param customerService5Name 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService5, Date startTime, Date endTime);

	ServerResponse delete(String ids);

	ServerResponse addCustomerService5(CustomerService customerService5);

	ServerResponse updateCustomerService5(CustomerService customerService5);

}
