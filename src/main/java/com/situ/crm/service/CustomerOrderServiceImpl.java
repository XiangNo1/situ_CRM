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
import com.situ.crm.dao.CustomerOrderMapper;
import com.situ.crm.dao.OrderItemMapper;
import com.situ.crm.dao.SaleChanceMapper;
import com.situ.crm.pojo.CustomerOrder;
import com.situ.crm.pojo.CustomerOrderExample;
import com.situ.crm.pojo.OrderItem;
import com.situ.crm.pojo.OrderItemExample;
import com.situ.crm.pojo.CustomerOrder;
import com.situ.crm.pojo.CustomerOrderExample;
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.pojo.SaleChanceExample;
import com.situ.crm.pojo.SaleChanceExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class CustomerOrderServiceImpl implements ICustomerOrderService{
	@Autowired
	private SaleChanceMapper saleChanceMapper;
	@Autowired
	private CustomerOrderMapper customerOrderMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;
	
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
	public ServerResponse add(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		if (customerOrderMapper.insert(customerOrder) > 0) {
			return ServerResponse.createSuccess();
		}
		return ServerResponse.createError();
	}

	@Override
	public ServerResponse update(CustomerOrder customerOrder) {
		if (customerOrderMapper.updateByPrimaryKey(customerOrder) > 0) {
			return ServerResponse.createSuccess("修改成功! ");
		}
		return ServerResponse.createError("修改失败!");
	}

	@Override
	public ServerResponse deleteById(Integer id) {
		if (customerOrderMapper.deleteByPrimaryKey(id) > 0) {
			return ServerResponse.createSuccess("删除数据成功 ");
		}
		return ServerResponse.createSuccess("数据已经成功删除");
	}


	@Override
	public List<CustomerOrder> findAll(Integer id) {
		CustomerOrderExample customerOrderExample = new CustomerOrderExample();
		com.situ.crm.pojo.CustomerOrderExample.Criteria criteria = customerOrderExample.createCriteria();
		criteria.andCustomerIdEqualTo(id);
		return customerOrderMapper.selectByExample(customerOrderExample);
	}


	@Override
	public List<OrderItem> findById(Integer id) {
		// TODO Auto-generated method stub
		OrderItemExample orderItemExample = new OrderItemExample();
		com.situ.crm.pojo.OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
		criteria.andOrderIdEqualTo(id);
		return orderItemMapper.selectByExample(orderItemExample);
	}




}
