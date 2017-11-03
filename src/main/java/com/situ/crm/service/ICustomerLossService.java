package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerLoss;

public interface ICustomerLossService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param customerLossName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerLoss customerLoss);

	ServerResponse delete(String ids);

	ServerResponse addCustomerLoss(CustomerLoss customerLoss);

	ServerResponse updateCustomerLoss(CustomerLoss customerLoss);

	CustomerLoss findById(Integer id);

	EasyUIDataGrideResult findAll2(Integer page, Integer rows, CustomerLoss customerLoss);

}
