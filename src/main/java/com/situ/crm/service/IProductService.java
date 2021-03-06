package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.Product;

public interface IProductService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param productName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, Product product);

	ServerResponse delete(String ids);

	ServerResponse addProduct(Product product);

	ServerResponse updateProduct(Product product);

}
