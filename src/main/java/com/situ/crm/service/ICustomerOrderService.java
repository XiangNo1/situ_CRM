package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerOrder;
import com.situ.crm.pojo.OrderItem;

public interface ICustomerOrderService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param saleChanceName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */

	ServerResponse delete(String ids);

	List<CustomerOrder> findAll(Integer id);

	ServerResponse add(CustomerOrder customerOrder);

	ServerResponse update(CustomerOrder customerOrder);

	ServerResponse deleteById(Integer id);

	List<OrderItem> findById(Integer id);



}
