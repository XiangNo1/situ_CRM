package com.situ.crm.service;

import java.util.List;

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

@Service
public class CustomerService2ServiceImpl implements ICustomerService2Service{
	@Autowired
	private CustomerServiceMapper customerService2Mapper;

	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService2) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		CustomerServiceExample customerService2Example = new CustomerServiceExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = customerService2Example.createCriteria();
		/*if (StringUtils.isNotEmpty(customerService2.getName())) {
			try {
				createCriteria.andNameLike(Util.formatLike(new String(customerService2.getName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerService2.getTrueName())) {
			try {
				createCriteria.andTrueNameLike(Util.formatLike(new String(customerService2.getTrueName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerService2.getRoleName())) {
			try {
				createCriteria.andRoleNameEqualTo(new String(customerService2.getRoleName().getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//list
		List<CustomerService> customerService2List = customerService2Mapper.selectByExample(customerService2Example);
		PageInfo<CustomerService> pageInfo = new PageInfo<>(customerService2List);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(customerService2List);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(customerService2Mapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addCustomerService2(CustomerService customerService2) {
		try {
			if(customerService2Mapper.insert(customerService2) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateCustomerService2(CustomerService customerService2) {
		try {
			if(customerService2Mapper.updateByPrimaryKey(customerService2) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}



}
