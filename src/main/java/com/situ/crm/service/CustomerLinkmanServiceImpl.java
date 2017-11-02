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
import com.situ.crm.dao.CustomerLinkmanMapper;
import com.situ.crm.dao.SaleChanceMapper;
import com.situ.crm.pojo.CustomerLinkman;
import com.situ.crm.pojo.CustomerLinkmanExample;
import com.situ.crm.pojo.CustomerLinkman;
import com.situ.crm.pojo.CustomerLinkmanExample;
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.pojo.SaleChanceExample;
import com.situ.crm.pojo.SaleChanceExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class CustomerLinkmanServiceImpl implements ICustomerLinkmanService{
	@Autowired
	private SaleChanceMapper saleChanceMapper;
	@Autowired
	private CustomerLinkmanMapper customerLinkmanMapper;

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
	public ServerResponse add(CustomerLinkman customerLinkman) {
		// TODO Auto-generated method stub
		if (customerLinkmanMapper.insert(customerLinkman) > 0) {
			return ServerResponse.createSuccess("添加成功! ");
		}
		return ServerResponse.createError("添加失败!");
	}

	@Override
	public ServerResponse update(CustomerLinkman customerLinkman) {
		if (customerLinkmanMapper.updateByPrimaryKey(customerLinkman) > 0) {
			return ServerResponse.createSuccess("修改成功! ");
		}
		return ServerResponse.createError("修改失败!");
	}

	@Override
	public ServerResponse deleteById(Integer id) {
		if (customerLinkmanMapper.deleteByPrimaryKey(id) > 0) {
			return ServerResponse.createSuccess("删除数据成功 ");
		}
		return ServerResponse.createSuccess("数据已经成功删除");
	}


	@Override
	public List<CustomerLinkman> findAll(Integer id) {
		CustomerLinkmanExample customerLinkmanExample = new CustomerLinkmanExample();
		com.situ.crm.pojo.CustomerLinkmanExample.Criteria criteria = customerLinkmanExample.createCriteria();
		criteria.andCustomerIdEqualTo(id);
		return customerLinkmanMapper.selectByExample(customerLinkmanExample);
	}




}
