package com.situ.crm.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.dao.CustomerLossMeasureMapper;
import com.situ.crm.dao.SaleChanceMapper;
import com.situ.crm.pojo.CustomerLossMeasure;
import com.situ.crm.pojo.CustomerLossMeasureExample;
import com.situ.crm.pojo.CustomerLossMeasure;
import com.situ.crm.pojo.CustomerLossMeasureExample;
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.pojo.SaleChanceExample;
import com.situ.crm.pojo.SaleChanceExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class CustomerLossMeasureServiceImpl implements ICustomerLossMeasureService{
	@Autowired
	private SaleChanceMapper saleChanceMapper;
	@Autowired
	private CustomerLossMeasureMapper customerLossMeasureMapper;

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(saleChanceMapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}


	@Override
	public ServerResponse add(CustomerLossMeasure customerLossMeasure) {
		// TODO Auto-generated method stub
		if (customerLossMeasureMapper.insert(customerLossMeasure) > 0) {
			return ServerResponse.createSuccess();
		}
		return ServerResponse.createError();
	}

	@Override
	public ServerResponse update(CustomerLossMeasure customerLossMeasure) {
		if (customerLossMeasureMapper.updateByPrimaryKey(customerLossMeasure) > 0) {
			return ServerResponse.createSuccess("修改成功! ");
		}
		return ServerResponse.createError("修改失败!");
	}

	@Override
	public ServerResponse deleteById(Integer id) {
		if (customerLossMeasureMapper.deleteByPrimaryKey(id) > 0) {
			return ServerResponse.createSuccess("删除数据成功 ");
		}
		return ServerResponse.createSuccess("数据已经成功删除");
	}


	@Override
	public List<CustomerLossMeasure> findAll(Integer id) {
		CustomerLossMeasureExample customerLossMeasureExample = new CustomerLossMeasureExample();
		com.situ.crm.pojo.CustomerLossMeasureExample.Criteria criteria = customerLossMeasureExample.createCriteria();
		criteria.andLossIdEqualTo(id);
		return customerLossMeasureMapper.selectByExample(customerLossMeasureExample);
	}




}
