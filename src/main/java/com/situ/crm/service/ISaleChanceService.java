package com.situ.crm.service;

import java.util.Date;
import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.SaleChance;

public interface ISaleChanceService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param saleChanceName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, SaleChance saleChance, Date startTime, Date endTime);

	ServerResponse delete(String ids);

	ServerResponse addSaleChance(SaleChance saleChance);

	ServerResponse updateSaleChance(SaleChance saleChance);

	ServerResponse findById(Integer id);

	ServerResponse updateDevResult(Integer saleChanceId, Integer devResult);


}
