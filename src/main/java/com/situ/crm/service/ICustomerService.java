package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.Customer;

public interface ICustomerService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param customerName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, Customer customer);

	ServerResponse delete(String ids);

	ServerResponse addCustomer(Customer customer);

	ServerResponse updateCustomer(Customer customer);

	Customer findById(Integer id);

}
