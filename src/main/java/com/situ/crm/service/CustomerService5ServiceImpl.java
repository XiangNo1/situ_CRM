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
import com.situ.crm.dao.CustomerServiceMapper;
import com.situ.crm.pojo.CustomerService;
import com.situ.crm.pojo.CustomerServiceExample;
import com.situ.crm.pojo.CustomerServiceExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class CustomerService5ServiceImpl implements ICustomerService5Service{
	@Autowired
	private CustomerServiceMapper customerService5Mapper;

	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService5, Date startTime, Date endTime) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		CustomerServiceExample customerService5Example = new CustomerServiceExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = customerService5Example.createCriteria();
		if (StringUtils.isNotEmpty(customerService5.getCustomer())) {
			try {
				createCriteria.andCustomerLike(Util.formatLike(new String(customerService5.getCustomer().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerService5.getOverview())) {
			try {
				createCriteria.andOverviewLike(Util.formatLike(new String(customerService5.getOverview().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerService5.getServiceType())) {
			try {
				createCriteria.andServiceTypeEqualTo(new String(customerService5.getServiceType().getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != startTime && null != endTime) {
			createCriteria.andCreateTimeBetween(startTime, endTime);
		}
		//list
		List<CustomerService> customerService5List = customerService5Mapper.selectByExample(customerService5Example);
		PageInfo<CustomerService> pageInfo = new PageInfo<>(customerService5List);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(customerService5List);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(customerService5Mapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addCustomerService5(CustomerService customerService5) {
		try {
			if(customerService5Mapper.insert(customerService5) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateCustomerService5(CustomerService customerService5) {
		try {
			if(customerService5Mapper.updateByPrimaryKey(customerService5) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}



}
