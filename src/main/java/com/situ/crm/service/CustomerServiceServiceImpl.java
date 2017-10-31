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
import com.situ.crm.dao.CustomerServiceMapper;
import com.situ.crm.pojo.CustomerService;
import com.situ.crm.pojo.CustomerServiceExample;
import com.situ.crm.pojo.CustomerServiceExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class CustomerServiceServiceImpl implements ICustomerServiceService{
	@Autowired
	private CustomerServiceMapper customerServiceMapper;

	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		CustomerServiceExample customerServiceExample = new CustomerServiceExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = customerServiceExample.createCriteria();
		/*if (StringUtils.isNotEmpty(customerService.getName())) {
			try {
				createCriteria.andNameLike(Util.formatLike(new String(customerService.getName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerService.getTrueName())) {
			try {
				createCriteria.andTrueNameLike(Util.formatLike(new String(customerService.getTrueName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerService.getRoleName())) {
			try {
				createCriteria.andRoleNameEqualTo(new String(customerService.getRoleName().getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//list
		List<CustomerService> customerServiceList = customerServiceMapper.selectByExample(customerServiceExample);
		PageInfo<CustomerService> pageInfo = new PageInfo<>(customerServiceList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(customerServiceList);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(customerServiceMapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addCustomerService(CustomerService customerService) {
		try {
			if(customerServiceMapper.insert(customerService) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateCustomerService(CustomerService customerService) {
		try {
			if(customerServiceMapper.updateByPrimaryKey(customerService) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public List<CustomerService> findRoleName() {
		// TODO Auto-generated method stub
		//return customerServiceMapper.findRoleName();
		return null;
	}



}
