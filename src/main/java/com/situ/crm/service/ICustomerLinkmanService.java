package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerLinkman;

public interface ICustomerLinkmanService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param saleChanceName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */

	ServerResponse delete(String ids);

	List<CustomerLinkman> findAll(Integer id);

	ServerResponse add(CustomerLinkman customerLinkman);

	ServerResponse update(CustomerLinkman customerLinkman);

	ServerResponse deleteById(Integer id);



}
