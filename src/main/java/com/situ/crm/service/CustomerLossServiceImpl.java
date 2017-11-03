package com.situ.crm.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.dao.CustomerLossMapper;
import com.situ.crm.pojo.CustomerLoss;
import com.situ.crm.pojo.CustomerLossExample;
import com.situ.crm.pojo.CustomerLossExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class CustomerLossServiceImpl implements ICustomerLossService{
	@Autowired
	private CustomerLossMapper customerLossMapper;

	@Override
	public EasyUIDataGrideResult findAll2(Integer page, Integer rows, CustomerLoss customerLoss) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		CustomerLossExample customerLossExample = new CustomerLossExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = customerLossExample.createCriteria();
		if (StringUtils.isNotEmpty(customerLoss.getCustomerName())) {
			try {
				createCriteria.andCustomerNameLike(Util.formatLike(new String(customerLoss.getCustomerName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerLoss.getCustomerManager())) {
			try {
				createCriteria.andCustomerManagerLike(Util.formatLike(new String(customerLoss.getCustomerManager().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != customerLoss.getStatus()) {
				createCriteria.andStatusEqualTo(customerLoss.getStatus());
			}
		createCriteria.andStatusEqualTo(1);
		//list
		List<CustomerLoss> customerLossList = customerLossMapper.selectByExample(customerLossExample);
		PageInfo<CustomerLoss> pageInfo = new PageInfo<>(customerLossList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(customerLossList);
		return result;
	}
	
	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerLoss customerLoss) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		CustomerLossExample customerLossExample = new CustomerLossExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = customerLossExample.createCriteria();
		if (StringUtils.isNotEmpty(customerLoss.getCustomerName())) {
			try {
				createCriteria.andCustomerNameLike(Util.formatLike(new String(customerLoss.getCustomerName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerLoss.getCustomerManager())) {
			try {
				createCriteria.andCustomerManagerLike(Util.formatLike(new String(customerLoss.getCustomerManager().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != customerLoss.getStatus()) {
				createCriteria.andStatusEqualTo(customerLoss.getStatus());
			}
		//list
		List<CustomerLoss> customerLossList = customerLossMapper.selectByExample(customerLossExample);
		PageInfo<CustomerLoss> pageInfo = new PageInfo<>(customerLossList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(customerLossList);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(customerLossMapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addCustomerLoss(CustomerLoss customerLoss) {
		try {
			if(customerLossMapper.insert(customerLoss) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateCustomerLoss(CustomerLoss customerLoss) {
		try {
			if(customerLossMapper.updateByPrimaryKey(customerLoss) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public CustomerLoss findById(Integer id) {
		// TODO Auto-generated method stub
		return customerLossMapper.selectByPrimaryKey(id);
	}



}
